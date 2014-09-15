package org.jbehave.core.steps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jbehave.core.annotations.ScenarioType;
import org.jbehave.core.configuration.Keywords;
import org.jbehave.core.i18n.LocalizedKeywords;
import org.jbehave.core.model.Lifecycle;
import org.jbehave.core.model.Meta;
import org.jbehave.core.model.Scenario;
import org.jbehave.core.model.Story;
import org.jbehave.core.steps.AbstractStepResult.Pending;
import org.jbehave.core.steps.StepCreator.PendingStep;

/**
 * StepCollector that marks unmatched steps as {@link Pending}. It uses a
 * {@link StepFinder} to collect and prioritise {@link StepCandidate}s.
 */
public class MarkUnmatchedStepsAsPending implements StepCollector {

    private final StepFinder stepFinder;
    private final Keywords keywords;

    public MarkUnmatchedStepsAsPending() {
        this(new StepFinder());
    }

    public MarkUnmatchedStepsAsPending(StepFinder stepFinder) {
        this(stepFinder, new LocalizedKeywords());
    }

    public MarkUnmatchedStepsAsPending(Keywords keywords) {
        this(new StepFinder(), keywords);
    }

   public MarkUnmatchedStepsAsPending(StepFinder stepFinder, Keywords keywords) {
        this.stepFinder = stepFinder;
        this.keywords = keywords;
    }

     public List<Step> collectBeforeOrAfterStoriesSteps(List<CandidateSteps> candidateSteps, Stage stage) {
        List<Step> steps = new ArrayList<Step>();
        for (CandidateSteps candidates : candidateSteps) {
            steps.addAll(createSteps(candidates.listBeforeOrAfterStories(), stage));
        }
        return steps;
    }

    public List<Step> collectBeforeOrAfterStorySteps(List<CandidateSteps> candidateSteps, Story story, Stage stage,
            boolean givenStory) {
        List<Step> steps = new ArrayList<Step>();
        for (CandidateSteps candidates : candidateSteps) {
            steps.addAll(createSteps(candidates.listBeforeOrAfterStory(givenStory), story.getMeta(), stage));
        }
        return steps;
    }

    public List<Step> collectBeforeOrAfterScenarioSteps(List<CandidateSteps> candidateSteps, Meta storyAndScenarioMeta, Stage stage, ScenarioType type) {
        List<Step> steps = new ArrayList<Step>();
        for (CandidateSteps candidates : candidateSteps) {
            List<BeforeOrAfterStep> beforeOrAfterScenarioSteps = candidates.listBeforeOrAfterScenario(type);
            if (stage == Stage.BEFORE) {
                steps.addAll(createSteps(beforeOrAfterScenarioSteps, storyAndScenarioMeta, stage));
            } else {
                steps.addAll(0, createStepsUponOutcome(beforeOrAfterScenarioSteps, storyAndScenarioMeta, stage));
            }
        }
        return steps;
    }

    public List<Step> collectLifecycleSteps(List<CandidateSteps> candidateSteps, Lifecycle lifecycle, Meta storyAndScenarioMeta, Stage stage) {
        List<Step> steps = new ArrayList<Step>();
        Map<String, String> namedParameters = new HashMap<String, String>();
        if (stage == Stage.BEFORE) {
            addMatchedSteps(lifecycle.getBeforeSteps(), steps, namedParameters, candidateSteps);
        } else {
            addMatchedSteps(lifecycle.getAfterSteps(), steps, namedParameters, candidateSteps);
        }
        return steps;
    }

    public List<Step> collectScenarioSteps(List<CandidateSteps> candidateSteps, Scenario scenario,
            Map<String, String> parameters) {
        List<Step> steps = new ArrayList<Step>();
        addMatchedSteps(scenario.getSteps(), steps, parameters, candidateSteps);
        return steps;
    }

    private List<Step> createSteps(List<BeforeOrAfterStep> beforeOrAfter, Stage stage) {
        return createSteps(beforeOrAfter, null, stage);
    }

    private List<Step> createSteps(List<BeforeOrAfterStep> beforeOrAfter, Meta meta, Stage stage) {
        List<Step> steps = new ArrayList<Step>();
        for (BeforeOrAfterStep step : beforeOrAfter) {
            if (stage == step.getStage()) {
                steps.add(meta == null ? step.createStep() : step.createStepWith(meta));
            }
        }
        return steps;
    }

    private List<Step> createStepsUponOutcome(List<BeforeOrAfterStep> beforeOrAfter, Meta storyAndScenarioMeta, Stage stage) {
        List<Step> steps = new ArrayList<Step>();
        for (BeforeOrAfterStep step : beforeOrAfter) {
            if (stage == step.getStage()) {
                steps.add(step.createStepUponOutcome(storyAndScenarioMeta));
            }
        }
        return steps;
    }

    private void addMatchedSteps(List<String> stepsAsString, List<Step> steps, Map<String, String> namedParameters,
            List<CandidateSteps> candidateSteps) {
        List<StepCandidate> allCandidates = stepFinder.collectCandidates(candidateSteps);
        String previousNonAndStep = null;
        for (String stepAsString : stepsAsString) {
            // pending is default step, overridden below
            Step step = StepCreator.createPendingStep(stepAsString, previousNonAndStep);
            List<Step> composedSteps = new ArrayList<Step>();
            List<StepCandidate> prioritisedCandidates = stepFinder.prioritise(stepAsString, allCandidates);
            for (StepCandidate candidate : prioritisedCandidates) {
                if (candidate.ignore(stepAsString)) {
                    // ignorable steps are added
                    // so they can be reported
                    step = StepCreator.createIgnorableStep(stepAsString);
                    break;
                }
                if (matchesCandidate(stepAsString, previousNonAndStep, candidate)) {
                    // step matches candidate
                    if (candidate.isPending()) {
                        ((PendingStep) step).annotatedOn(candidate.getMethod());
                    } else {
                        step = candidate.createMatchedStep(stepAsString, namedParameters);
                        if ( candidate.isComposite() ){
                            candidate.addComposedSteps(composedSteps, stepAsString, namedParameters, allCandidates);
                        }
                    }
                    if (!(candidate.isAndStep(stepAsString) || candidate.isIgnorableStep(stepAsString))) {
                        // only update previous step if not AND or IGNORABLE step
                        previousNonAndStep = stepAsString;
                    }
                    break;
                }
            }
            if ( !(keywords.isAndStep(stepAsString) || keywords.isIgnorableStep(stepAsString)) ){
                previousNonAndStep = stepAsString;
            }
            steps.add(step);
            steps.addAll(composedSteps);
        }
    }

    private boolean matchesCandidate(String step, String previousNonAndStep, StepCandidate candidate) {
        if (previousNonAndStep != null) {
            return candidate.matches(step, previousNonAndStep);
        }
        return candidate.matches(step);
    }

}
