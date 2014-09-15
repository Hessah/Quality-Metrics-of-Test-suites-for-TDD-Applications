package org.jbehave.core.junit.needle;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.inject.Inject;

import org.jbehave.core.InjectableEmbedder;
import org.jbehave.core.annotations.Configure;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.UsingEmbedder;
import org.jbehave.core.annotations.UsingSteps;
import org.jbehave.core.annotations.needle.NeedleInjectionProvider;
import org.jbehave.core.annotations.needle.UsingNeedle;
import org.jbehave.core.configuration.needle.NeedleAnnotationBuilder;
import org.jbehave.core.configuration.needle.ValueGetterProvider;
import org.jbehave.core.junit.AnnotatedEmbedderRunner;
import org.jbehave.core.steps.CandidateSteps;
import org.jbehave.core.steps.needle.ValueGetter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.model.InitializationError;

import de.akquinet.jbosscc.needle.injection.InjectionProvider;

public class NeedleAnnotatedEmbedderRunnerBehaviour {

	@Test
	public void shouldCreateWithGuiceAnnotatedBuilder() throws InitializationError {
		AnnotatedEmbedderRunner runner = new NeedleAnnotatedEmbedderRunner(RunningWithAnnotatedEmbedderRunner.class);
		assertThat(runner.annotationBuilder(), instanceOf(NeedleAnnotationBuilder.class));
	}

	@RunWith(NeedleAnnotatedEmbedderRunner.class)
	@Configure()
	@UsingSteps(instances = Steps.class)
	@UsingEmbedder()
	@UsingNeedle
	public static class RunningWithAnnotatedEmbedderRunner extends InjectableEmbedder {

		@Test
		public void run() {
			assertTrue(true);
		}

		@Test
		public void testSteps() {
			final List<CandidateSteps> candidateSteps = injectedEmbedder().stepsFactory().createCandidateSteps();
			assertThat(candidateSteps.size(), is(1));
		}

	}

	public static class Steps {
		@NeedleInjectionProvider
		InjectionProvider<ValueGetter> provider = new ValueGetterProvider();

		@Inject
		private ValueGetter getter;

		@Given("Some")
		public boolean complete() {
			return ValueGetter.VALUE.equals(getter.getValue());
		}
	}

}
