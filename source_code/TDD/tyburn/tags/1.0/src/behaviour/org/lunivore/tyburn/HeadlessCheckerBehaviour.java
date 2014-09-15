package org.lunivore.tyburn;

import static org.junit.Assert.fail;

import java.awt.HeadlessException;

import org.junit.Test;

/**
 * Use this class at the beginning of any Swing behaviours which
 * shouldn't be run in Headless mode. Those behaviours will be
 * shown as pending instead (which won't break your automated
 * build).
 */
public class HeadlessCheckerBehaviour extends Behaviour {

    private String envHeadless;

    @Test
    public void shouldThrowAPendingExceptionIfRunningInHeadlessMode() throws Exception {
        storeCurrentHeadlessMode();
        
        final HeadlessChecker headlessChecker = new HeadlessChecker();
        
        ensureThrowsHeadlessExceptionOnHeadless(headlessChecker);
        ensureDoesNotThrowExceptionWhenNotHeadless(headlessChecker);
        
        resetOriginalHeadlessMode();
    }

    private void ensureDoesNotThrowExceptionWhenNotHeadless(final HeadlessChecker headlessChecker) throws Exception {
        System.getProperties().remove("java.awt.headless");
        headlessChecker.check();
    }

    private void ensureThrowsHeadlessExceptionOnHeadless(final HeadlessChecker headlessChecker) throws Exception {
        System.setProperty("java.awt.headless", "true");
        try {
            headlessChecker.check();
            fail("Should have thrown headless exception");
        } catch (HeadlessException e) {}
    }

    private void resetOriginalHeadlessMode() {
        if (envHeadless != null) {
            System.setProperty("java.awt.headless", envHeadless);
        }
    }

    private void storeCurrentHeadlessMode() {
        envHeadless = System.getProperty("java.awt.headless");
    }
}
