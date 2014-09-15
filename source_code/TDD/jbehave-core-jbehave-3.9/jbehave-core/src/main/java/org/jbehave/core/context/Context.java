package org.jbehave.core.context;

/**
 * Holds context-related information
 */
public class Context {
	
	private ThreadLocal<String> currentStory = new ThreadLocal<String>();
	private ThreadLocal<String> currentScenario = new ThreadLocal<String>();

    public String getCurrentStory() {
		return currentStory.get();
	}

	public void setCurrentStory(String currentStory) {
		this.currentStory.set(currentStory);
	}

	public String getCurrentScenario() {
		return currentScenario.get();
	}

	public void setCurrentScenario(String currentScenario) {
		this.currentScenario.set(currentScenario);
	}

}
