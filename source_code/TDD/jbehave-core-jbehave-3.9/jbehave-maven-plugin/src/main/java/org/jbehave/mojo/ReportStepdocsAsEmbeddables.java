package org.jbehave.mojo;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.jbehave.core.Embeddable;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.steps.CandidateSteps;

/**
 * Mojo to report stepdocs for the {@link Embeddable} instances provided (more
 * specifically instances of {@link ConfiguredEmbedder} which provides both
 * {@link Configuration} and {@link CandidateSteps}).
 * 
 * @goal report-stepdocs-as-embeddables
 */
public class ReportStepdocsAsEmbeddables extends AbstractEmbedderMojo {

    public void execute() throws MojoExecutionException, MojoFailureException {
        Embedder embedder = newEmbedder();
        getLog().info("Reporting stepdocs as embeddables using embedder " + embedder);
        try {
            embedder.reportStepdocsAsEmbeddables(classNames());
        } catch (RuntimeException e) {
            throw new MojoFailureException("Failed to report stepdocs as embeddables", e);
        }
    }

}
