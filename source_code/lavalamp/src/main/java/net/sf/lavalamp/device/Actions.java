package net.sf.lavalamp.device;


public class Actions {

	private final Action successAction;
	private final Action failureAction;
	private final Action errorAction;

	public Actions(Action successAction, Action failureAction,
			Action errorAction) {
		this.successAction = successAction;
		this.failureAction = failureAction;
		this.errorAction = errorAction;
	}


	public Action getSuccessAction() {
		return successAction;
	}

	public Action getFailureAction() {
		return failureAction;
	}

	public Action getErrorAction() {
		return errorAction;
	}

}
