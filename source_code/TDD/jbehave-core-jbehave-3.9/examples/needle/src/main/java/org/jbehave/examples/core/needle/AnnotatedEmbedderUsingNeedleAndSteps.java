package org.jbehave.examples.core.needle;

import java.util.List;

import org.jbehave.core.InjectableEmbedder;
import org.jbehave.core.annotations.Configure;
import org.jbehave.core.annotations.UsingEmbedder;
import org.jbehave.core.annotations.UsingSteps;
import org.jbehave.core.annotations.needle.UsingNeedle;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.needle.NeedleAnnotatedEmbedderRunner;
import org.jbehave.examples.core.needle.steps.NeedleTraderSteps;
import org.jbehave.examples.core.steps.AndSteps;
import org.jbehave.examples.core.steps.BeforeAfterSteps;
import org.jbehave.examples.core.steps.CalendarSteps;
import org.jbehave.examples.core.steps.PendingSteps;
import org.jbehave.examples.core.steps.PriorityMatchingSteps;
import org.jbehave.examples.core.steps.SandpitSteps;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.jbehave.core.io.CodeLocations.codeLocationFromPath;

/**
 * Run stories via annotated embedder configuration and steps using Needle. The textual trader stories are exactly the
 * same ones found in the jbehave-trader-example. Here we are only concerned with using the container to compose the
 * configuration and the steps instances.
 */
@RunWith(NeedleAnnotatedEmbedderRunner.class)
@Configure()
@UsingEmbedder(embedder = Embedder.class, generateViewAfterStories = true, ignoreFailureInStories = true, ignoreFailureInView = true)
@UsingSteps(instances = { NeedleTraderSteps.class, BeforeAfterSteps.class, AndSteps.class, CalendarSteps.class,
		PendingSteps.class, PriorityMatchingSteps.class, SandpitSteps.class })
@UsingNeedle
public class AnnotatedEmbedderUsingNeedleAndSteps extends InjectableEmbedder {

	@Test
	public void run() {
		injectedEmbedder().runStoriesAsPaths(storyPaths());
	}

	protected List<String> storyPaths() {
		return new StoryFinder().findPaths(codeLocationFromPath("../trader/src/main/java"), "**/*.story", "");
	}

}
