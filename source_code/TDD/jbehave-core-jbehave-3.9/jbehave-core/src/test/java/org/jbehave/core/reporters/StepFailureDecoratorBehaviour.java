package org.jbehave.core.reporters;

import java.util.List;
import java.util.Map;

import org.hamcrest.MatcherAssert;
import org.jbehave.core.failures.UUIDExceptionWrapper;
import org.jbehave.core.model.ExamplesTable;
import org.jbehave.core.model.GivenStories;
import org.jbehave.core.model.OutcomesTable;
import org.jbehave.core.model.Story;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import static java.util.Arrays.asList;

import static org.hamcrest.Matchers.equalTo;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class StepFailureDecoratorBehaviour {

    private StoryReporter delegate;
    private StepFailureDecorator decorator;

    @Before
    public void createDecorator() {
        delegate = mock(StoryReporter.class);
        decorator = new StepFailureDecorator(delegate);
    }

    @Test
    public void shouldJustDelegateAllReportingMethodsOtherThanFailure() {
        // Given
        Story story = new Story();
        boolean givenStory = false;
        List<String> steps = asList("Given step <one>", "Then step <two>");
        ExamplesTable table = new ExamplesTable("|one|two|\n |1|2|\n");
        Map<String, String> tableRow = table.getRow(0);

        // When
        decorator.dryRun();
        decorator.beforeStory(story, givenStory);
        decorator.beforeScenario("My core 1");
        GivenStories givenStories = new GivenStories("/path1,/path2");
        decorator.givenStories(givenStories);
        decorator.ignorable("!-- ignore me");
        decorator.successful("Given step 1.1");
        decorator.pending("When step 1.2");
        decorator.notPerformed("Then step 1.3");
        decorator.beforeExamples(steps, table);
        decorator.example(tableRow);
        decorator.afterExamples();
        decorator.afterScenario();
        decorator.afterStory(givenStory);

        // Then
        InOrder inOrder = inOrder(delegate);

        inOrder.verify(delegate).beforeStory(story, givenStory);
        inOrder.verify(delegate).beforeScenario("My core 1");
        inOrder.verify(delegate).givenStories(givenStories);
        inOrder.verify(delegate).ignorable("!-- ignore me");
        inOrder.verify(delegate).successful("Given step 1.1");
        inOrder.verify(delegate).pending("When step 1.2");
        inOrder.verify(delegate).notPerformed("Then step 1.3");
        inOrder.verify(delegate).beforeExamples(steps, table);
        inOrder.verify(delegate).example(tableRow);
        inOrder.verify(delegate).afterExamples();
        inOrder.verify(delegate).afterScenario();
        inOrder.verify(delegate).afterStory(givenStory);
    }

    @Test
    public void shouldProvideFailureCauseWithMessageDescribingStep() {
        // Given
        Throwable t = new UUIDExceptionWrapper(new IllegalArgumentException("World Peace for everyone"));
        // When
        decorator.failed("When I have a bad idea", t);
        OutcomesTable table = new OutcomesTable();
        decorator.failedOutcomes("When outcomes fail", table);

        // Then
        verify(delegate).failed(Mockito.eq("When I have a bad idea"), Mockito.eq(t));
        verify(delegate).failedOutcomes(Mockito.eq("When outcomes fail"), Mockito.eq(table));
    }

    @Test
    public void shouldRethrowFailureCauseAfterStory() {
        // Given
        Throwable t = new UUIDExceptionWrapper(new IllegalArgumentException("World Peace for everyone"));
        String stepAsString = "When I have a bad idea";
        decorator.failed(stepAsString, t);
        boolean givenStory = false;

        // When
        try {
            decorator.afterStory(givenStory);
            Assert.fail("Should have rethrown exception");
        } catch (Throwable rethrown) {
            // Then
            MatcherAssert.assertThat(rethrown, equalTo(t));
        }
    }
}
