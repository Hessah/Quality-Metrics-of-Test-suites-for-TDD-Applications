package org.jbehave.core.reporters;

import static java.util.Arrays.asList;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.InputStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.SortedMap;
import java.util.TreeMap;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.jbehave.core.io.IOUtils;
import org.jbehave.core.io.StoryNameResolver;
import org.jbehave.core.model.StoryLanes;
import org.jbehave.core.model.StoryMaps;

/**
 * <p>
 * {@link ViewGenerator}, which uses the configured {@link TemplateProcessor} to
 * generate the views from templates. The default view properties are
 * overridable via the method {@link Properties} parameter. To override, specify
 * the path to the new template under the appropriate key:
 * 
 * <pre>
 * &quot;views&quot;: the path to global view template, including reports and maps views
 * &quot;maps&quot;: the path to the maps view template
 * &quot;reports&quot;: the path to the reports view template
 * &quot;decorated&quot;: the path to the template to generate a decorated (i.e. styled) single report
 * &quot;nonDecorated&quot;: the path to the template to generated a non decorated single report
 * </pre>
 * <p>
 * The view generator provides the following resources:
 * 
 * <pre>
 * &quot;decorateNonHtml&quot; = &quot;true&quot;
 * &quot;defaultFormats&quot; = &quot;stats&quot;
 * &quot;viewDirectory&quot; = &quot;view&quot;
 * </pre>
 * 
 * </p>
 * 
 * @author Mauro Talevi
 */
public class TemplateableViewGenerator implements ViewGenerator {

    private final StoryNameResolver nameResolver;
    private final TemplateProcessor processor;
    private Properties viewProperties;
    private List<Report> reports = new ArrayList<Report>();

    public TemplateableViewGenerator(StoryNameResolver nameResolver, TemplateProcessor processor) {
        this.nameResolver = nameResolver;
        this.processor = processor;
    }

    public Properties defaultViewProperties() {
        Properties properties = new Properties();
        properties.setProperty("decorateNonHtml", "true");
        properties.setProperty("defaultFormats", "stats");
        properties.setProperty("viewDirectory", "view");
        return properties;
    }

    private Properties mergeWithDefault(Properties properties) {
        Properties merged = defaultViewProperties();
        merged.putAll(properties);
        return merged;
    }

    private void generateViewsIndex(File outputDirectory) {
        String outputName = templateResource("viewDirectory") + "/index.html";
        String viewsTemplate = templateResource("views");
        Map<String, Object> dataModel = newDataModel();
        dataModel.put("date", new Date());
        write(outputDirectory, outputName, viewsTemplate, dataModel);
    }

    public void generateMapsView(File outputDirectory, StoryMaps storyMaps, Properties viewProperties) {
        this.viewProperties = mergeWithDefault(viewProperties);
        String outputName = templateResource("viewDirectory") + "/maps.html";
        String mapsTemplate = templateResource("maps");
        Map<String, Object> dataModel = newDataModel();
        dataModel.put("storyLanes", new StoryLanes(storyMaps, nameResolver));
        dataModel.put("date", new Date());
        write(outputDirectory, outputName, mapsTemplate, dataModel);
        generateViewsIndex(outputDirectory);
    }

    public void generateReportsView(File outputDirectory, List<String> formats, Properties viewProperties) {
        this.viewProperties = mergeWithDefault(viewProperties);
        String outputName = templateResource("viewDirectory") + "/reports.html";
        String reportsTemplate = templateResource("reports");
        List<String> mergedFormats = mergeFormatsWithDefaults(formats);
        reports = createReports(readReportFiles(outputDirectory, outputName, mergedFormats));
        Map<String, Object> dataModel = newDataModel();
        dataModel.put("reportsTable", new ReportsTable(reports, nameResolver));
        dataModel.put("date", new Date());
        dataModel.put("timeFormatter", new TimeFormatter());
        write(outputDirectory, outputName, reportsTemplate, dataModel);
        generateViewsIndex(outputDirectory);
    }

    public ReportsCount getReportsCount() {
        int stories = countStoriesWithScenarios();
        int storiesNotAllowed = count("notAllowed", reports);
        int storiesPending = count("pending", reports);
        int scenarios = count("scenarios", reports);
        int scenariosFailed = count("scenariosFailed", reports);
        int scenariosNotAllowed = count("scenariosNotAllowed", reports);
        int scenariosPending = count("scenariosPending", reports);
        int stepsFailed = count("stepsFailed", reports);
        return new ReportsCount(stories, storiesNotAllowed, storiesPending, scenarios, scenariosFailed,
                scenariosNotAllowed, scenariosPending, stepsFailed);
    }

    private int countStoriesWithScenarios(){
        int storyCount = 0;
        for (Report report : reports){
            Map<String, Integer> stats = report.getStats();
            if (stats.containsKey("scenarios")){
                if (stats.get("scenarios") > 0)
                storyCount++;
            }
        }
        return storyCount;
    }
    
    int count(String event, Collection<Report> reports) {
        int count = 0;
        for (Report report : reports) {
            Properties stats = report.asProperties("stats");
            if (stats.containsKey(event)) {
                count = count + Integer.parseInt((String) stats.get(event));
            }
        }
        return count;
    }

    private List<String> mergeFormatsWithDefaults(List<String> formats) {
        List<String> merged = new ArrayList<String>();
        merged.addAll(asList(templateResource("defaultFormats").split(",")));
        merged.addAll(formats);
        return merged;
    }

    List<Report> createReports(Map<String, List<File>> reportFiles) {
        try {
            String decoratedTemplate = templateResource("decorated");
            String nonDecoratedTemplate = templateResource("nonDecorated");
            String viewDirectory = templateResource("viewDirectory");
            boolean decorateNonHtml = Boolean.valueOf(templateResource("decorateNonHtml"));
            List<Report> reports = new ArrayList<Report>();
            for (String name : reportFiles.keySet()) {
                Map<String, File> filesByFormat = new HashMap<String, File>();
                for (File file : reportFiles.get(name)) {
                    String fileName = file.getName();
                    String format = FilenameUtils.getExtension(fileName);
                    Map<String, Object> dataModel = newDataModel();
                    dataModel.put("name", name);
                    dataModel.put("body", IOUtils.toString(new FileReader(file), true));
                    dataModel.put("format", format);
                    File outputDirectory = file.getParentFile();
                    String outputName = viewDirectory + "/" + fileName;
                    String template = decoratedTemplate;
                    if (!format.equals("html")) {
                        if (decorateNonHtml) {
                            outputName = outputName + ".html";
                        } else {
                            template = nonDecoratedTemplate;
                        }
                    }
                    File written = write(outputDirectory, outputName, template, dataModel);
                    filesByFormat.put(format, written);
                }
                reports.add(new Report(name, filesByFormat));
            }
            return reports;
        } catch (Exception e) {
            throw new ReportCreationFailed(reportFiles, e);
        }
    }

    SortedMap<String, List<File>> readReportFiles(File outputDirectory, final String outputName,
            final List<String> formats) {
        SortedMap<String, List<File>> reportFiles = new TreeMap<String, List<File>>();
        if (outputDirectory == null || !outputDirectory.exists()) {
            return reportFiles;
        }
        String[] fileNames = outputDirectory.list(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return !name.equals(outputName) && hasFormats(name, formats);
            }

            private boolean hasFormats(String name, List<String> formats) {
                for (String format : formats) {
                    if (name.endsWith(format)) {
                        return true;
                    }
                }
                return false;
            }
        });
        for (String fileName : fileNames) {
            String name = FilenameUtils.getBaseName(fileName);
            List<File> filesByName = reportFiles.get(name);
            if (filesByName == null) {
                filesByName = new ArrayList<File>();
                reportFiles.put(name, filesByName);
            }
            filesByName.add(new File(outputDirectory, fileName));
        }
        return reportFiles;
    }

    private File write(File outputDirectory, String outputName, String resource, Map<String, Object> dataModel) {
        try {
            File file = new File(outputDirectory, outputName);
            file.getParentFile().mkdirs();
            Writer writer = new FileWriter(file);
            processor.process(resource, dataModel, writer);
            writer.close();
            return file;
        } catch (Exception e) {
            throw new ViewGenerationFailedForTemplate(resource, e);
        }
    }

    private String templateResource(String format) {
        return viewProperties.getProperty(format);
    }

    private Map<String, Object> newDataModel() {
        return new HashMap<String, Object>();
    }

    @SuppressWarnings("serial")
    public static class ReportCreationFailed extends RuntimeException {

        public ReportCreationFailed(Map<String, List<File>> reportFiles, Exception cause) {
            super("Report creation failed from file " + reportFiles, cause);
        }
    }

    @SuppressWarnings("serial")
    public static class ViewGenerationFailedForTemplate extends RuntimeException {

        public ViewGenerationFailedForTemplate(String resource, Exception cause) {
            super(resource, cause);
        }

    }

    public static class ReportsTable {

        private final Map<String, Report> reports = new HashMap<String, Report>();
        private final StoryNameResolver nameResolver;

        public ReportsTable(List<Report> reports, StoryNameResolver nameResolver) {
            this.nameResolver = nameResolver;
            index(reports);
            addTotalsReport();
        }

        private void index(List<Report> reports) {
            for (Report report : reports) {
                report.nameAs(nameResolver.resolveName(report.getPath()));
                this.reports.put(report.getName(), report);
            }
        }

        private void addTotalsReport() {
            Report report = totals(reports.values());
            report.nameAs(nameResolver.resolveName(report.getPath()));
            reports.put(report.getName(), report);
        }

        private Report totals(Collection<Report> values) {
            Map<String, Integer> totals = new HashMap<String, Integer>();
            for (Report report : values) {
                Map<String, Integer> stats = report.getStats();
                for (String key : stats.keySet()) {
                    Integer total = totals.get(key);
                    if (total == null) {
                        total = 0;
                    }
                    total = total + stats.get(key);
                    totals.put(key, total);
                }
            }
            return new Report("Totals", new HashMap<String, File>(), totals);
        }

        public List<Report> getReports() {
            List<Report> list = new ArrayList<Report>(reports.values());
            Collections.sort(list);
            return list;
        }

        public List<String> getReportNames() {
            List<String> list = new ArrayList<String>(reports.keySet());
            Collections.sort(list);
            return list;
        }

        public Report getReport(String name) {
            return reports.get(name);
        }
    }

    public static class Report implements Comparable<Report> {

        private final String path;
        private final Map<String, File> filesByFormat;
        private Map<String, Integer> stats;
        private String name;

        public Report(String path, Map<String, File> filesByFormat) {
            this(path, filesByFormat, null);
        }

        public Report(String path, Map<String, File> filesByFormat, Map<String, Integer> stats) {
            this.path = path;
            this.filesByFormat = filesByFormat;
            this.stats = stats;
        }

        public String getPath() {
            return path;
        }

        public String getName() {
            return name != null ? name : path;
        }

        public void nameAs(String name) {
            this.name = name;
        }

        public Map<String, File> getFilesByFormat() {
            return filesByFormat;
        }

        public Properties asProperties(String format) {
            Properties p = new Properties();
            File stats = filesByFormat.get(format);
            try {
                InputStream inputStream = new FileInputStream(stats);
                p.load(inputStream);
                inputStream.close();
            } catch (Exception e) {
                // return empty map
            }
            return p;
        }

        public Map<String, Integer> getStats() {
            if (stats == null) {
                Properties p = asProperties("stats");
                stats = new HashMap<String, Integer>();
                for (Enumeration<?> e = p.propertyNames(); e.hasMoreElements();) {
                    String key = (String) e.nextElement();
                    stats.put(key, valueOf(key, p));
                }
            }
            return stats;
        }

        private Integer valueOf(String key, Properties p) {
            try {
                return Integer.valueOf(p.getProperty(key));
            } catch (NumberFormatException e) {
                return 0;
            }
        }

        public int compareTo(Report that) {
            return CompareToBuilder.reflectionCompare(this.getName(), that.getName());
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).append(path).toString();
        }
    }

    public static class TimeFormatter {

        public String formatMillis(long millis) {
            int second = 1000;
            int minute = 60 * second;
            int hour = 60 * minute;
            long hours = millis / hour;
            long minutes = (millis % hour) / minute;
            long seconds = ((millis % hour) % minute) / second;
            long milliseconds = ((millis % hour) % minute % second);
            Formatter formatter = new Formatter();
            String result = formatter.format("%02d:%02d:%02d.%03d", hours, minutes, seconds, milliseconds).toString();
            formatter.close();
            return result;
        }

    }
}
