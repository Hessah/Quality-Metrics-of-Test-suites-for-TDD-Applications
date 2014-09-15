package org.jbehave.examples.core.needle;

import static org.jbehave.core.io.CodeLocations.codeLocationFromPath;

import java.util.List;

import org.jbehave.core.InjectableEmbedder;
import org.jbehave.core.annotations.Configure;
import org.jbehave.core.annotations.UsingEmbedder;
import org.jbehave.core.annotations.needle.UsingNeedle;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.needle.NeedleAnnotatedEmbedderRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Run stories via annotated embedder configuration and steps using needle. The textual trader stories are exactly the
 * same ones found in the jbehave-trader-example. Here we are only concerned with using the container to compose the
 * configuration and the steps instances.
 */
@RunWith(NeedleAnnotatedEmbedderRunner.class)
@Configure
@UsingNeedle
@UsingEmbedder(embedder = Embedder.class, generateViewAfterStories = true, ignoreFailureInStories = true, ignoreFailureInView = true)
public class AnnotatedEmbedderUsingNeedle extends InjectableEmbedder {

	@Test
	public void run() {
		injectedEmbedder().runStoriesAsPaths(storyPaths());
	}

	protected List<String> storyPaths() {
		return new StoryFinder().findPaths(codeLocationFromPath("../trader/src/main/java"), "**/*.story", "");
	}

}
