package org.jbehave.core.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static org.jbehave.core.annotations.AfterScenario.Outcome.ANY;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface AfterScenario {

	enum Outcome { ANY, SUCCESS, FAILURE }
	
	/**
	 * Signals that the annotated method should be invoked only upon given outcome
	 * 
	 * @return An Outcome upon which the method should be invoked 
	 */
	Outcome uponOutcome() default ANY;

    /**
     * Signals that the annoated method should be invoked only upon given type
     * 
     * @return A ScenarioType upon which the method should be invoked
     */
    ScenarioType uponType() default ScenarioType.NORMAL;

}
