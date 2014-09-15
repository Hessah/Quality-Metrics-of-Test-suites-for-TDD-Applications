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

public class PoissonDistributionTest extends NumericTestCase {

    public void testConstructor() {
        testConstructorFailure(Double.NaN);
        testConstructorFailure(-1.0);
        testConstructorFailure(0.0);
        testConstructorSuccess(1.0);
    }

    private void testConstructorFailure(double mean) {
        try {
            new PoissonDistribution(mean);
            fail();
        } catch (IllegalArgumentException ex) {
            // success
        }
    }

    private void testConstructorSuccess(double mean) {
        try {
            PoissonDistribution d = new PoissonDistribution(mean);
            assertEquals(mean, d.getMean(), 0.0);
        } catch (IllegalArgumentException ex) {
            fail();
        }
    }

    public void testMean() {
        PoissonDistribution d = new PoissonDistribution();
        testMeanFailure(d, Double.NaN);
        testMeanFailure(d, -1.0);
        testMeanFailure(d, 0.0);
        testMeanSuccess(d, 1.0);
    }

    private void testMeanSuccess(PoissonDistribution d, double p) {
        try {
            d.setMean(p);
            assertEquals(p, d.getMean(), 0.0);
        } catch (IllegalArgumentException ex) {
            fail();
        }
    }

    private void testMeanFailure(PoissonDistribution d, double p) {
        try {
            d.setMean(p);
            fail();
        } catch (IllegalArgumentException ex) {
            // success
        }
    }
    
    public void testProbability() throws NumericException {
        PoissonDistribution d = new PoissonDistribution();
        testProbabilitySuccess(d, 2, 27.2623108253656, 5.37309078977067e-10);
        testProbabilitySuccess(d, 7, 25.8868462402422, 8.84319082284979e-6); 
        testProbabilitySuccess(d, 11, 16.416505444671, 0.0433844824282923);
        testProbabilitySuccess(d, 12, 24.7268007326161, 0.00199051323846319); 
        testProbabilitySuccess(d, 13, 15.0972708714776, 0.0943491658588478);
        testProbabilitySuccess(d, 14, 20.4310396537491, 0.0339289485033913); 
        testProbabilitySuccess(d, 15, 13.2049639384855, 0.0911414029765052);
        testProbabilitySuccess(d, 15, 15.9320891640239, 0.0996260482213742); 
        testProbabilitySuccess(d, 17, 28.3130132741066, 0.00686293091896092);
        testProbabilitySuccess(d, 18, 22.3471725470006, 0.0594855850786975);
        testProbabilitySuccess(d, -1, 1.0, 0.0);
    }
    
    private void testProbabilitySuccess(PoissonDistribution d, int x, double mean, double expected) throws NumericException {
        d.setMean(mean);
        double actual = d.probability(x);
        assertRelativelyEquals(expected, actual, 1.0e-12);
    }
    
    private void testCumulativeProbabilitySuccess(PoissonDistribution d, int x, double mean, double expected) throws NumericException {
        d.setMean(mean);
        double actual = d.cumulativeProbability(x);
        assertRelativelyEquals(expected, actual, 1.0e-12);
    }
    
    public void testCumulativeProbability() throws NumericException {
        PoissonDistribution d = new PoissonDistribution();
        testCumulativeProbabilitySuccess(d, 5, 19.994129643106, 0.0000722322107081512);
        testCumulativeProbabilitySuccess(d, 5, 25.2673289104899, 1.12512316949118e-6);
        testCumulativeProbabilitySuccess(d, 6, 10.9063820470809, 0.0825443009991483);
        testCumulativeProbabilitySuccess(d, 9, 12.9201563634893, 0.171150877819186);
        testCumulativeProbabilitySuccess(d, 10, 15.9192466160041, 0.0801915161068822);
        testCumulativeProbabilitySuccess(d, 12, 22.3218352477012, 0.0128756133904903);
        testCumulativeProbabilitySuccess(d, 15, 16.8384712111047, 0.386228131542689);
        testCumulativeProbabilitySuccess(d, 15, 25.0595244223355, 0.0217112295253477);
        testCumulativeProbabilitySuccess(d, 15, 25.4882069622551, 0.0179103679613408);
        testCumulativeProbabilitySuccess(d, 20, 19.9622535508579, 0.562445762170383);
        testCumulativeProbabilitySuccess(d, -1, 1.0, 0.0);
    }
    
    public void testInveseCumulativeProbability() throws NumericException {
        PoissonDistribution d = new PoissonDistribution();
        testInveseCumulativeProbabilitySuccess(d, 0.0294047264363213, 16.5575281653433, 8);
        testInveseCumulativeProbabilitySuccess(d, 0.261829065321774, 28.0424565773904, 24);
        testInveseCumulativeProbabilitySuccess(d, 0.332136524193155, 26.2424464358302, 23);
        testInveseCumulativeProbabilitySuccess(d, 0.424802328664357, 13.3449746723208, 11);
        testInveseCumulativeProbabilitySuccess(d, 0.465051462638836, 17.9742590138801, 16);
        testInveseCumulativeProbabilitySuccess(d, 0.467656213301559, 23.4285511467263, 22);
        testInveseCumulativeProbabilitySuccess(d, 0.534512777134091, 18.6608859712494, 18);
        testInveseCumulativeProbabilitySuccess(d, 0.614394914504755, 28.979263673862, 29);
        testInveseCumulativeProbabilitySuccess(d, 0.655201498683634, 22.7216363864942, 23);
        testInveseCumulativeProbabilitySuccess(d, 0.932463352118843, 26.7722430539146, 34);
        testInveseCumulativeProbabilitySuccess(d, Double.NaN, 1.0, Integer.MIN_VALUE);
        testInveseCumulativeProbabilitySuccess(d, -1.0, 1.0, Integer.MIN_VALUE);
        testInveseCumulativeProbabilitySuccess(d, 0.0, 1.0, -1);
        testInveseCumulativeProbabilitySuccess(d, 1.0, 1.0, Integer.MAX_VALUE);
        testInveseCumulativeProbabilitySuccess(d, 2.0, 1.0, Integer.MIN_VALUE);
    }
    
    private void testInveseCumulativeProbabilitySuccess(PoissonDistribution d, double p, double mean, int expected) throws NumericException {
        d.setMean(mean);
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
