package org.jbehave.core.embedder;

import java.io.PrintStream;

/**
 *  Monitor that reports nothing
 */
public class SilentEmbedderMonitor extends PrintStreamEmbedderMonitor {

	public SilentEmbedderMonitor(PrintStream output) {
	    super(output);
    }

    @Override
    protected void print(String message) {
	}

    @Override
	protected void printStackTrace(Throwable e) {
	}

}
