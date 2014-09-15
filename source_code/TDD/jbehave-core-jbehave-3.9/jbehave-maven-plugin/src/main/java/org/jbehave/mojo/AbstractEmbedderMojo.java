package org.jbehave.mojo;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutorService;

import org.apache.maven.plugin.AbstractMojo;
import org.jbehave.core.ConfigurableEmbedder;
import org.jbehave.core.InjectableEmbedder;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.embedder.EmbedderClassLoader;
import org.jbehave.core.embedder.EmbedderControls;
import org.jbehave.core.embedder.EmbedderMonitor;
import org.jbehave.core.embedder.MetaFilter;
import org.jbehave.core.embedder.NullEmbedderMonitor;
import org.jbehave.core.embedder.UnmodifiableEmbedderControls;
import org.jbehave.core.embedder.executors.ExecutorServiceFactory;
import org.jbehave.core.failures.BatchFailures;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.AnnotatedEmbedderRunner;
import org.jbehave.core.model.Meta;
import org.jbehave.core.model.Story;
import org.jbehave.core.model.StoryDuration;
import org.jbehave.core.model.StoryMaps;
import org.jbehave.core.reporters.ReportsCount;

import static org.apache.commons.lang.ArrayUtils.isNotEmpty;

/**
 * Abstract mojo that holds all the configuration parameters to specify and load
 * stories.
 * 
 * @requiresDependencyResolution test
 */
public abstract class AbstractEmbedderMojo extends AbstractMojo {

    static final String TEST_SCOPE = "test";

    /**
     * @parameter expression="${project.build.sourceDirectory}"
     * @required
     */
    String sourceDirectory;

    /**
     * @parameter expression="${project.build.testSourceDirectory}"
     * @required
     */
    String testSourceDirectory;

    /**
     * @parameter expression="${project.build.outputDirectory}"
     * @required
     */
    String outputDirectory;

    /**
     * @parameter expression="${project.build.testOutputDirectory}"
     * @required
     */
    String testOutputDirectory;

    /**
     * The scope of the mojo classpath, either "compile" or "test"
     * 
     * @parameter default-value="compile"
     */
    String scope;

    /**
     * Include filters, relative to the root source directory determined by the
     * scope
     * 
     * @parameter
     */
    List<String> includes;

    /**
     * Exclude filters, relative to the root source directory determined by the
     * scope
     * 
     * @parameter
     */
    List<String> excludes;

    /**
     * Compile classpath.
     * 
     * @parameter expression="${project.compileClasspathElements}"
     * @required
     * @readonly
     */
    List<String> compileClasspathElements;

    /**
     * Test classpath.
     * 
     * @parameter expression="${project.testClasspathElements}"
     * @required
     * @readonly
     */
    List<String> testClasspathElements;

    /**
     * The boolean flag to skip stories
     * 
     * @parameter default-value="false"
     */
    boolean skip = false;

    /**
     * The boolean flag to run in batch mode
     * 
     * @parameter default-value="false"
     */
    boolean batch = false;

    /**
     * The boolean flag to ignore failure in stories
     * 
     * @parameter default-value="false"
     */
    boolean ignoreFailureInStories = false;

    /**
     * The boolean flag to ignore failure in view
     * 
     * @parameter default-value="false"
     */
    boolean ignoreFailureInView = false;

    /**
     * The boolean flag to generate view after stories are run
     * 
     * @parameter default-value="true"
     */
    boolean generateViewAfterStories = true;

    /**
     * The boolean flag to output failures in verbose mode
     * 
     * @parameter default-value="false"
     */
    boolean verboseFailures = false;

    /**
     * The boolean flag to output filtering in verbose mode
     * 
     * @parameter default-value="false"
     */
    boolean verboseFiltering = false;

    /**
     * The story timeout in secs
     * 
     * @parameter default-value="300"
     */
    long storyTimeoutInSecs = 300;

    /**
     * The number of threads
     * 
     * @parameter default-value="1"
     */
    int threads = 1;

    /**
     * The embedder class
     * 
     * @parameter default-value="org.jbehave.core.embedder.Embedder"
     */
    String embedderClass = Embedder.class.getName();

    /**
     * The implementation class of the {@link ExecutorServiceFactory}
     * 
     * @parameter
     */
    String executorsClass;

    /**
     * The class that is injected with the embedder
     * 
     * @parameter
     */
    String injectableEmbedderClass;

    /**
     * The annotated embedder runner class
     * 
     * @parameter default-value="org.jbehave.core.junit.AnnotatedEmbedderRunner"
     * @deprecated Obsolete
     */
    String annotatedEmbedderRunnerClass = AnnotatedEmbedderRunner.class.getName();

    /**
     * Used to find story paths and class names
     * 
     * @parameter
     */
    String storyFinderClass = StoryFinder.class.getName();

    /**
     * The meta filter
     * 
     * @parameter
     */
    String[] metaFilters;

    /**
     * The system properties
     * 
     * @parameter
     */
    Properties systemProperties = new Properties();

    /**
     * The class loader
     */
    private EmbedderClassLoader classLoader;

    /**
     * Determines if the scope of the mojo classpath is "test"
     * 
     * @return A boolean <code>true</code> if test scoped
     */
    boolean isTestScope() {
        return TEST_SCOPE.equals(scope);
    }

    String searchDirectory() {
        if (isTestScope()) {
            return testSourceDirectory;
        }
        return sourceDirectory;
    }

    String outputDirectory() {
        if (isTestScope()) {
            return testOutputDirectory;
        }
        return outputDirectory;
    }

    URL codeLocation() {
        String outputDirectory = outputDirectory();
        try {
            return outputDirectory != null ? new File(outputDirectory).toURI().toURL() : null;
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Failed to create code location from " + outputDirectory, e);
        }
    }

    /**
     * Returns the EmbedderClassLoader with the classpath element of the
     * selected scope.
     * 
     * @return An EmbedderClassLoader
     */
    protected EmbedderClassLoader classLoader() {
        if (classLoader == null) {
            classLoader = new EmbedderClassLoader(classpathElements());
        }
        return classLoader;
    }

    List<String> classpathElements() {
        List<String> classpathElements = compileClasspathElements;
        if (isTestScope()) {
            classpathElements = testClasspathElements;
        }
        return classpathElements;
    }

    /**
     * Finds story paths, using the {@link #newStoryFinder()}, in the
     * {@link #searchDirectory()} given specified {@link #includes} and
     * {@link #excludes}.
     * 
     * @return A List of story paths found
     */
    protected List<String> storyPaths() {
        getLog().debug("Searching for story paths including " + includes + " and excluding " + excludes);
        List<String> storyPaths = newStoryFinder().findPaths(searchDirectory(), includes, excludes);
        getLog().info("Found story paths: " + storyPaths);
        return storyPaths;
    }

    /**
     * Finds class names, using the {@link #newStoryFinder()}, in the
     * {@link #searchDirectory()} given specified {@link #includes} and
     * {@link #excludes}.
     * 
     * @return A List of class names found
     */
    protected List<String> classNames() {
        getLog().debug("Searching for class names including " + includes + " and excluding " + excludes);
        List<String> classNames = newStoryFinder().findClassNames(searchDirectory(), includes, excludes);
        getLog().info("Found class names: " + classNames);
        return classNames;
    }

    /**
     * Creates an instance of StoryFinder, using the {@link #storyFinderClass}
     * 
     * @return A StoryFinder
     */
    protected StoryFinder newStoryFinder() {
        return classLoader().newInstance(StoryFinder.class, storyFinderClass);
    }

    /**
     * Creates an instance of Embedder, either using
     * {@link #injectableEmbedderClass} (if set) or defaulting to
     * {@link #embedderClass}.
     * 
     * @return An Embedder
     */
    protected Embedder newEmbedder() {
        Embedder embedder = null;
        EmbedderClassLoader classLoader = classLoader();
        if (injectableEmbedderClass != null) {
            embedder = classLoader.newInstance(InjectableEmbedder.class, injectableEmbedderClass).injectedEmbedder();
        } else {
            embedder = classLoader.newInstance(Embedder.class, embedderClass);
        }
        
        URL codeLocation = codeLocation();
        if (codeLocation != null) {
            embedder.configuration().storyReporterBuilder().withCodeLocation(codeLocation);
        }

        embedder.useClassLoader(classLoader);
        embedder.useEmbedderControls(embedderControls());
        if ( executorsClass != null ){
            ExecutorServiceFactory executorServiceFactory = classLoader.newInstance(ExecutorServiceFactory.class, executorsClass);
            embedder.useExecutorService(executorServiceFactory.create(embedder.embedderControls()));
        }
        embedder.useEmbedderMonitor(embedderMonitor());
        if (isNotEmpty(metaFilters)) {
            List<String> filters = new ArrayList<String>();
            for (String filter : metaFilters) {
                if (filter != null) {
                    filters.add(filter);
                }
            }
            embedder.useMetaFilters(filters);
        }
        if (!systemProperties.isEmpty()) {
            embedder.useSystemProperties(systemProperties);
        }
        return embedder;
    }

    protected EmbedderMonitor embedderMonitor() {
        return new MavenEmbedderMonitor();
    }

    protected EmbedderControls embedderControls() {
        return new UnmodifiableEmbedderControls(new EmbedderControls().doBatch(batch).doSkip(skip)
                .doGenerateViewAfterStories(generateViewAfterStories).doIgnoreFailureInStories(ignoreFailureInStories)
                .doIgnoreFailureInView(ignoreFailureInView).doVerboseFailures(verboseFailures)
                .doVerboseFiltering(verboseFiltering).useStoryTimeoutInSecs(storyTimeoutInSecs).useThreads(threads));
    }

    protected class MavenEmbedderMonitor extends NullEmbedderMonitor {

        public void batchFailed(BatchFailures failures) {
            getLog().warn("Failed to run batch " + failures);
        }

        public void beforeOrAfterStoriesFailed() {
            getLog().warn("Failed to run before or after stories steps");
        }

        public void embeddableFailed(String name, Throwable cause) {
            getLog().warn("Failed to run embeddable " + name, cause);
        }

        public void embeddableNotConfigurable(String name) {
            getLog().warn("Embeddable " + name + " must be an instance of " + ConfigurableEmbedder.class);
        }

        public void embeddablesSkipped(List<String> classNames) {
            getLog().info("Skipped embeddables " + classNames);
        }

        public void metaNotAllowed(Meta meta, MetaFilter filter) {
            getLog().debug(meta + " excluded by filter '" + filter.asString() + "'");
        }

        public void runningEmbeddable(String name) {
            getLog().info("Running embeddable " + name);
        }

        public void runningStory(String path) {
            getLog().info("Running story " + path);
        }

        public void storyFailed(String path, Throwable cause) {
            getLog().warn("Failed to run story " + path, cause);
        }

        public void storiesSkipped(List<String> storyPaths) {
            getLog().info("Skipped stories " + storyPaths);
        }

        public void storiesNotAllowed(List<Story> stories, MetaFilter filter, boolean verbose) {
            StringBuffer sb = new StringBuffer();
            sb.append(stories.size() + " stories excluded by filter: " + filter.asString() + "\n");
            if (verbose) {
                for (Story story : stories) {
                    sb.append(story.getPath()).append("\n");
                }
            }
            getLog().info(sb.toString());
        }

        public void runningWithAnnotatedEmbedderRunner(String className) {
            getLog().info("Running with AnnotatedEmbedderRunner '" + className + "'");
        }

        public void annotatedInstanceNotOfType(Object annotatedInstance, Class<?> type) {
            getLog().warn("Annotated instance " + annotatedInstance + " not of type " + type);
        }

        public void generatingReportsView(File outputDirectory, List<String> formats, Properties viewProperties) {
            getLog().info(
                    "Generating reports view to '" + outputDirectory + "' using formats '" + formats + "'"
                            + " and view properties '" + viewProperties + "'");
        }

        public void reportsViewGenerationFailed(File outputDirectory, List<String> formats, Properties viewProperties,
                Throwable cause) {
            String message = "Failed to generate reports view to '" + outputDirectory + "' using formats '" + formats
                    + "'" + " and view properties '" + viewProperties + "'";
            getLog().warn(message, cause);
        }

        public void reportsViewGenerated(ReportsCount count) {
            getLog().info(
                    "Reports view generated with " + count.getStories() + " stories (of which "
                            + count.getStoriesPending() + " pending) containing " + count.getScenarios()
                            + " scenarios (of which " + count.getScenariosPending() + " pending)");
            if (count.getStoriesNotAllowed() > 0 || count.getScenariosNotAllowed() > 0) {
                getLog().info(
                        "Meta filters excluded " + count.getStoriesNotAllowed() + " stories and  "
                                + count.getScenariosNotAllowed() + " scenarios");
            }
        }

        public void reportsViewFailures(ReportsCount count) {
            getLog().warn("Failures in reports view: " + count.getScenariosFailed() + " scenarios failed");
        }

        public void reportsViewNotGenerated() {
            getLog().info("Reports view not generated");
        }

        public void mappingStory(String storyPath, List<String> metaFilters) {
            getLog().info("Mapping story " + storyPath + " with meta filters " + metaFilters);
        }

        public void generatingMapsView(File outputDirectory, StoryMaps storyMaps, Properties viewProperties) {
            getLog().info(
                    "Generating maps view to '" + outputDirectory + "' using story maps '" + storyMaps + "'"
                            + " and view properties '" + viewProperties + "'");
        }

        public void mapsViewGenerationFailed(File outputDirectory, StoryMaps storyMaps, Properties viewProperties,
                Throwable cause) {
            getLog().warn(
                    "Failed to generate maps view to '" + outputDirectory + "' using story maps '" + storyMaps + "'"
                            + " and view properties '" + viewProperties + "'", cause);
        }

        public void generatingNavigatorView(File outputDirectory, Properties viewProperties) {
            getLog().info(
                    "Generating navigator view to '" + outputDirectory + "' using view properties '" + viewProperties
                            + "'");
        }

        public void navigatorViewGenerationFailed(File outputDirectory, Properties viewProperties, Throwable cause) {
            getLog().warn(
                    "Failed to generate navigator view to '" + outputDirectory + "' using view properties '"
                            + viewProperties + "'", cause);
        }

        public void navigatorViewNotGenerated() {
            getLog().warn(
                    "Navigator view not generated, as the CrossReference has not been declared in the StoryReporterBuilder");
        }

        public void processingSystemProperties(Properties properties) {
            getLog().info("Processing system properties " + properties);
        }

        public void systemPropertySet(String name, String value) {
            getLog().info("System property '" + name + "' set to '" + value + "'");
        }

        public void storyTimeout(Story story, StoryDuration storyDuration) {
            getLog().warn(
                    "Story " + story.getPath() + " duration of " + storyDuration.getDurationInSecs()
                            + " seconds has exceeded timeout of " + storyDuration.getTimeoutInSecs() + " seconds");
        }

        public void usingThreads(int threads) {
            getLog().info("Using " + threads + " threads");
        }

        public void usingExecutorService(ExecutorService executorService) {
            getLog().info("Using executor service " + executorService);
        }

        public void usingControls(EmbedderControls embedderControls) {
            getLog().info("Using controls " + embedderControls);
        }

        @Override
        public String toString() {
            return this.getClass().getSimpleName();
        }

    }
}
