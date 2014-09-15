/*
 * Copyright (c) 2005, DoodleProject
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 
 * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 * 
 * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in
 * the documentation and/or other materials provided with the
 * distribution.
 * 
 * Neither the name of DoodleProject nor the names of its
 * contributors may be used to endorse or promote products derived
 * from this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND
 * CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES,
 * INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS
 * BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED
 * TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR
 * TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF
 * THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 */
package net.sf.doodleproject.numerics4j.statistics.distribution;

import net.sf.doodleproject.numerics4j.NumericTestCase;
import net.sf.doodleproject.numerics4j.exception.NumericException;

public class HypergeometricDistributionTest extends NumericTestCase {

    public void testConstructor() {
        testConstructorFailure(-1, 1, 1);
        testConstructorSuccess(0, 1, 1);
        testConstructorSuccess(1, 1, 1);
        testConstructorFailure(1, -1, 1);
        testConstructorSuccess(1, 0, 1);
        testConstructorFailure(1, 1, 0);
    }

    private void testConstructorFailure(int s, int f, int n) {
        try {
            new HypergeometricDistribution(s, f, n);
            fail();
        } catch (IllegalArgumentException ex) {
            // success
        }
    }

    private void testConstructorSuccess(int s, int f, int n) {
        try {
            HypergeometricDistribution d = new HypergeometricDistribution(s, f, n);
            assertEquals(s, d.getNumberOfSuccesses());
            assertEquals(f, d.getNumberOfFailures());
            assertEquals(n, d.getSampleSize());
        } catch (IllegalArgumentException ex) {
            fail();
        }
    }
    
    public void testNumberOfSuccesses() {
        HypergeometricDistribution d = new HypergeometricDistribution();
        testNumberOfSuccessesFailure(d, -1);
        testNumberOfSuccessesSuccess(d, 0);
        testNumberOfSuccessesSuccess(d, 1);
    }

    private void testNumberOfSuccessesSuccess(HypergeometricDistribution d, int n) {
        try {
            d.setNumberOfSuccesses(n);
            assertEquals(n, d.getNumberOfSuccesses());
        } catch (IllegalArgumentException ex) {
            fail();
        }
    }

    private void testNumberOfSuccessesFailure(HypergeometricDistribution d, int n) {
        try {
            d.setNumberOfSuccesses(n);
            fail();
        } catch (IllegalArgumentException ex) {
            // success
        }
    }
    
    public void testNumberOfFailures() {
        HypergeometricDistribution d = new HypergeometricDistribution();
        testNumberOfFailuresFailure(d, -1);
        testNumberOfFailuresSuccess(d, 0);
        testNumberOfFailuresSuccess(d, 1);
    }

    private void testNumberOfFailuresSuccess(HypergeometricDistribution d, int n) {
        try {
            d.setNumberOfFailures(n);
            assertEquals(n, d.getNumberOfFailures());
        } catch (IllegalArgumentException ex) {
            fail();
        }
    }

    private void testNumberOfFailuresFailure(HypergeometricDistribution d, int n) {
        try {
            d.setNumberOfFailures(n);
            fail();
        } catch (IllegalArgumentException ex) {
            // success
        }
    }
    
    public void testSampleSize() {
        HypergeometricDistribution d = new HypergeometricDistribution();
        testSampleSizeFailure(d, -1);
        testSampleSizeFailure(d, 0);
        testSampleSizeSuccess(d, 1);
    }

    private void testSampleSizeSuccess(HypergeometricDistribution d, int n) {
        try {
            d.setSampleSize(n);
            assertEquals(n, d.getSampleSize());
        } catch (IllegalArgumentException ex) {
            fail();
        }
    }

    private void testSampleSizeFailure(HypergeometricDistribution d, int n) {
        try {
            d.setSampleSize(n);
            fail();
        } catch (IllegalArgumentException ex) {
            // success
        }
    }

    public void testProbability() throws NumericException {
        HypergeometricDistribution d = new HypergeometricDistribution();
        testProbabilitySuccess(d, 5, 16, 10, 16, 0.0);
        testProbabilitySuccess(d, 5, 17, 17, 16, 0.034747744201676); 
        testProbabilitySuccess(d, 7, 15, 20, 11, 0.0747258859049738); 
        testProbabilitySuccess(d, 7, 20, 13, 13, 0.23208672161615);
        testProbabilitySuccess(d, 8, 10, 17, 13, 0.0138825324180015);
        testProbabilitySuccess(d, 9, 10, 11, 18, 0.413533834586466);
        testProbabilitySuccess(d, 9, 11, 12, 11, 0.00268475635281397); 
        testProbabilitySuccess(d, 9, 15, 14, 13, 0.0738242849679391);
        testProbabilitySuccess(d, 9, 20, 17, 13, 0.112210096637238);
        testProbabilitySuccess(d, 10, 15, 12, 19, 0.297584541062802);
        testProbabilitySuccess(d, 9, 20, 10, 20, 0.0);
        testProbabilitySuccess(d, 21, 20, 10, 20, 0.0);
        testProbabilitySuccess(d, -1, 10, 10, 20, 0.0);
        testProbabilitySuccess(d, 11, 10, 10, 20, 0.0);
        testProbabilitySuccess(d, -1, 100, 100, 20, 0.0);
        testProbabilitySuccess(d, 21, 100, 100, 20, 0.0);
    }
    
    private void testProbabilitySuccess(HypergeometricDistribution d, int x, int s, int f, int n, double expected) throws NumericException {
        d.setNumberOfFailures(f);
        d.setNumberOfSuccesses(s);
        d.setSampleSize(n);
        double actual = d.probability(x);
        assertRelativelyEquals(expected, actual, 1.0e-14);
    }
    
    private void testCumulativeProbabilitySuccess(HypergeometricDistribution d, int x, int s, int f, int n, double expected) throws NumericException {
        d.setNumberOfFailures(f);
        d.setNumberOfSuccesses(s);
        d.setSampleSize(n);
        double actual = d.cumulativeProbability(x);
        assertRelativelyEquals(expected, actual, 1.0e-12);
    }
    
    public void testCumulativeProbability() throws NumericException {
        HypergeometricDistribution d = new HypergeometricDistribution();

        testCumulativeProbabilitySuccess(d, 5, 19, 19, 17, 0.0244265558431056); 
        testCumulativeProbabilitySuccess(d, 6, 14, 10, 15, 0.0244985866200027);
        testCumulativeProbabilitySuccess(d, 6, 14, 20, 11, 0.928513162773452); 
        testCumulativeProbabilitySuccess(d, 6, 16, 18, 11, 0.83429736744531);
        testCumulativeProbabilitySuccess(d, 7, 10, 11, 15, 0.632684652808492); 
        testCumulativeProbabilitySuccess(d, 7, 18, 10, 11, 0.631731502669718); 
        testCumulativeProbabilitySuccess(d, 7, 20, 19, 12, 0.824607779557724);
        testCumulativeProbabilitySuccess(d, 8, 15, 14, 15, 0.708817263195028);
        testCumulativeProbabilitySuccess(d, 5, 12, 17, 20, 0.0116172682889325);
        testCumulativeProbabilitySuccess(d, 6, 11, 14, 13, 0.734540314981828); 
        testCumulativeProbabilitySuccess(d, 10, 10, 10, 11, 1.0);
        testCumulativeProbabilitySuccess(d, 11, 10, 10, 11, 1.0);
    }
    
    public void testInveseCumulativeProbability() throws NumericException {
        HypergeometricDistribution d = new HypergeometricDistribution();
        testInveseCumulativeProbabilitySuccess(d, 0.00170994984984056, 17, 18, 16, 3);
        testInveseCumulativeProbabilitySuccess(d, 0.0659072317625079, 11, 14, 14, 3);
        testInveseCumulativeProbabilitySuccess(d, 0.178483069611587, 15, 19, 14, 4);
        testInveseCumulativeProbabilitySuccess(d, 0.485920918365931, 17, 19, 17, 7);
        testInveseCumulativeProbabilitySuccess(d, 0.518662681392113, 16, 10, 17, 10);
        testInveseCumulativeProbabilitySuccess(d, 0.520675653166034, 13, 19, 18, 6);
        testInveseCumulativeProbabilitySuccess(d, 0.562082766247812, 16, 13, 10, 5);
        testInveseCumulativeProbabilitySuccess(d, 0.768774120433555, 20, 17, 11, 6);
        testInveseCumulativeProbabilitySuccess(d, 0.846303343975822, 18, 15, 17, 10);
        testInveseCumulativeProbabilitySuccess(d, 0.884197779918223, 10, 12, 15, 7);
        testInveseCumulativeProbabilitySuccess(d, 0.0, 10, 10, 11, 0);
        testInveseCumulativeProbabilitySuccess(d, 1.0, 10, 10, 11, 10);
        testInveseCumulativeProbabilitySuccess(d, -1.0, 10, 10, 11, Integer.MIN_VALUE);
        testInveseCumulativeProbabilitySuccess(d, 2.0, 10, 10, 11, Integer.MIN_VALUE);
    }
    
    private void testInveseCumulativeProbabilitySuccess(HypergeometricDistribution d, double p, int s, int f, int n, int expected) throws NumericException {
        d.setNumberOfFailures(f);
        d.setNumberOfSuccesses(s);
        d.setSampleSize(n);
        int actual = d.inverseCumulativeProbability(p);
        assertEquals(expected, actual);
        if (Integer.MIN_VALUE < actual && actual < Integer.MAX_VALUE) {
            assertTrue(d.cumulativeProbability(actual - 1) <= p);
            assertTrue(d.cumulativeProbability(actual) <= p);
            assertTrue(p <= d.cumulativeProbability(actual + 1));
            assertTrue(1.0 - p <= 1.0 - d.cumulativeProbability(actual - 1));
            assertTrue(1.0 - p <= 1.0 - d.cumulativeProbability(actual));
            assertTrue(1.0 - d.cumulativeProbability(actual + 1) <= 1.0 - p);
        }
    }
}
