package org.jbehave.core.configuration;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.jbehave.core.embedder.StoryControls;
import org.jbehave.core.failures.FailureStrategy;
import org.jbehave.core.failures.PendingStepStrategy;
import org.jbehave.core.io.StoryLoader;
import org.jbehave.core.io.StoryPathResolver;
import org.jbehave.core.parsers.StepPatternParser;
import org.jbehave.core.parsers.StoryParser;
import org.jbehave.core.reporters.StoryReporter;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.reporters.ViewGenerator;
import org.jbehave.core.steps.ParameterControls;
import org.jbehave.core.steps.ParameterConverters;
import org.jbehave.core.steps.StepCollector;
import org.jbehave.core.steps.StepMonitor;

import com.thoughtworks.paranamer.Paranamer;

/**
 * Decorator of Configuration that disables modification of configuration
 * elements.
 */
public class UnmodifiableConfiguration extends Configuration {

    private final Configuration delegate;

    public UnmodifiableConfiguration(Configuration delegate) {
        this.delegate = delegate;
    }

    /**
     * @deprecated Use {@link StoryReporterBuilder}
     */
    public StoryReporter defaultStoryReporter() {
        return delegate.defaultStoryReporter();
    }

    public StoryParser storyParser() {
        return delegate.storyParser();
    }

    public PendingStepStrategy pendingStepStrategy() {
        return delegate.pendingStepStrategy();
    }

    public StepCollector stepCollector() {
        return delegate.stepCollector();
    }

    public FailureStrategy failureStrategy() {
        return delegate.failureStrategy();
    }

    public Keywords keywords() {
        return delegate.keywords();
    }

    public ParameterConverters parameterConverters() {
        return delegate.parameterConverters();
    }

    public ParameterControls parameterControls(){
        return delegate.parameterControls();
    }
    
    public Paranamer paranamer() {
        return delegate.paranamer();
    }

    public ViewGenerator viewGenerator() {
        return delegate.viewGenerator();
    }

    public StepMonitor stepMonitor() {
        return delegate.stepMonitor();
    }

    public StepPatternParser stepPatternParser() {
        return delegate.stepPatternParser();
    }

    public boolean dryRun() {
        return delegate.dryRun();
    }

    public StoryControls storyControls() {
        return delegate.storyControls();
    }

    public StoryLoader storyLoader() {
        return delegate.storyLoader();
    }

    public StoryPathResolver storyPathResolver() {
        return delegate.storyPathResolver();
    }

    public StoryReporter storyReporter(String storyPath) {
        return delegate.storyReporter(storyPath);
    }

    public StoryReporterBuilder storyReporterBuilder() {
        return delegate.storyReporterBuilder();
    }

    @Override
    public Configuration useKeywords(Keywords keywords) {
        throw notAllowed();
    }

    @Override
    public Configuration useStepCollector(StepCollector stepCollector) {
        throw notAllowed();
    }

    @Override
    public Configuration usePendingStepStrategy(PendingStepStrategy pendingStepStrategy) {
        throw notAllowed();
    }

    @Override
    public Configuration useFailureStrategy(FailureStrategy failureStrategy) {
        throw notAllowed();
    }

    @Override
    public Configuration doDryRun(Boolean dryRun) {
        throw notAllowed();
    }

    @Override
    public Configuration useStoryControls(StoryControls storyControls) {
        throw notAllowed();
    }

    @Override
    public Configuration useStoryParser(StoryParser storyParser) {
        throw notAllowed();
    }

    @Override
    public Configuration useDefaultStoryReporter(StoryReporter storyReporter) {
        throw notAllowed();
    }

    @Override
    public Configuration useParameterConverters(ParameterConverters parameterConverters) {
        throw notAllowed();
    }
    
    @Override
    public Configuration useParameterControls(ParameterControls parameterControls) {
        throw notAllowed();
    }    

    @Override
    public Configuration useParanamer(Paranamer paranamer) {
        throw notAllowed();
    }

    @Override
    public Configuration useStepMonitor(StepMonitor stepMonitor) {
        throw notAllowed();
    }

    @Override
    public Configuration useStepPatternParser(StepPatternParser stepPatternParser) {
        throw notAllowed();
    }

    @Override
    public Configuration useViewGenerator(ViewGenerator viewGenerator) {
        throw notAllowed();
    }

    @Override
    public Configuration useStoryLoader(StoryLoader storyLoader) {
        throw notAllowed();
    }

    @Override
    public Configuration useStoryPathResolver(StoryPathResolver storyPathResolver) {
        throw notAllowed();
    }

    @Override
    public Configuration useStoryReporterBuilder(StoryReporterBuilder storyReporterBuilder) {
        throw notAllowed();
    }

    private RuntimeException notAllowed() {
        return new ModificationNotAllowed();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).append(delegate).toString();
    }

    @SuppressWarnings("serial")
    public static class ModificationNotAllowed extends RuntimeException {
        public ModificationNotAllowed(){
            super("Configuration elements are unmodifiable");
        }
    }
}