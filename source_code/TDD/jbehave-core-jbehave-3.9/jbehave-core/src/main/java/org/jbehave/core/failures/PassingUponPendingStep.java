package org.jbehave.core.failures;

public final class PassingUponPendingStep implements PendingStepStrategy {

	public void handleFailure(Throwable throwable) {
		// do nothing
	}

}