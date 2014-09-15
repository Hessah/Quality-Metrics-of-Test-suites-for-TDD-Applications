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

public class BinomialDistributionTest extends NumericTestCase {

    public void testConstructor() {
        testConstructorFailure(-1, 0.5);
        testConstructorFailure(0, 0.5);
        testConstructorFailure(10, Double.NaN);
        testConstructorFailure(10, -1.0);
        testConstructorFailure(10, 0.0);
        testConstructorSuccess(10, 0.5);
        testConstructorFailure(10, 1.0);
        testConstructorFailure(10, 2.0);
    }

    private void testConstructorFailure(int n, double p) {
        try {
            new BinomialDistribution(n, p);
            fail();
        } catch (IllegalArgumentException ex) {
            // success
        }
    }

    private void testConstructorSuccess(int n, double p) {
        try {
            BinomialDistribution d = new BinomialDistribution(n, p);
            assertEquals(n, d.getNumberOfTrials());
            assertEquals(p, d.getProbabilityOfSuccess(), 0.0);
        } catch (IllegalArgumentException ex) {
            fail();
        }
    }

    public void testNumberOfTrials() {
        BinomialDistribution d = new BinomialDistribution();
        testNumberOfTrialsFailure(d, -1);
        testNumberOfTrialsFailure(d, 0);
        testNumberOfTrialsSuccess(d, 5);
    }

    private void testNumberOfTrialsSuccess(BinomialDistribution d, int n) {
        try {
            d.setNumberOfTrials(n);
            assertEquals(n, d.getNumberOfTrials());
        } catch (IllegalArgumentException ex) {
            fail();
        }
    }

    private void testNumberOfTrialsFailure(BinomialDistribution d, int n) {
        try {
            d.setNumberOfTrials(n);
            fail();
        } catch (IllegalArgumentException ex) {
            // success
        }
    }

    public void testProbabilityOfSuccess() {
        BinomialDistribution d = new BinomialDistribution();
        testProbabilityOfSuccessFailure(d, Double.NaN);
        testProbabilityOfSuccessFailure(d, -1.0);
        testProbabilityOfSuccessFailure(d, 0.0);
        testProbabilityOfSuccessSuccess(d, 0.5);
        testProbabilityOfSuccessFailure(d, 1.0);
        testProbabilityOfSuccessFailure(d, -2.0);
    }

    private void testProbabilityOfSuccessSuccess(BinomialDistribution d, double p) {
        try {
            d.setProbabilityOfSuccess(p);
            assertEquals(p, d.getProbabilityOfSuccess(), 0.0);
        } catch (IllegalArgumentException ex) {
            fail();
        }
    }

    private void testProbabilityOfSuccessFailure(BinomialDistribution d, double p) {
        try {
            d.setProbabilityOfSuccess(p);
            fail();
        } catch (IllegalArgumentException ex) {
            // success
        }
    }
    
    public void testProbability() throws NumericException {
        BinomialDistribution d = new BinomialDistribution();
        testProbabilitySuccess(d, 3, 21, 0.632668793971301, 4.99369170106176e-6);
        testProbabilitySuccess(d, 3, 26, 0.925621512236776, 2.27804648932988e-23); 
        testProbabilitySuccess(d, 6, 22, 0.154316032018405, 0.0689620794794458); 
        testProbabilitySuccess(d, 7, 28, 0.085602783699861, 0.00608995927399188); 
        testProbabilitySuccess(d, 10, 29, 0.722743487803501, 0.0000202430708595095); 
        testProbabilitySuccess(d, 11, 23, 0.239479821395702, 0.00752122924232239);
        testProbabilitySuccess(d, 11, 26, 0.0454922665994631, 6.63695388289145e-9); 
        testProbabilitySuccess(d, 12, 24, 0.487433889995306, 0.15996282041183);
        testProbabilitySuccess(d, 13, 29, 0.633929269416168, 0.0188455779460824); 
        testProbabilitySuccess(d, 17, 24, 0.778443241276828, 0.128368902581968);       
        testProbabilitySuccess(d, -1, 10, 0.5, 0.0);
        testProbabilitySuccess(d, 11, 10, 0.5, 0.0);
    }
    
    private void testProbabilitySuccess(BinomialDistribution d, int x, int n, double p, double expected) throws NumericException {
        d.setNumberOfTrials(n);
        d.setProbabilityOfSuccess(p);
        double actual = d.probability(x);
        assertRelativelyEquals(expected, actual, 1.0e-12);
    }
    
    private void testCumulativeProbabilitySuccess(BinomialDistribution d, int x, int n, double p, double expected) throws NumericException {
        d.setNumberOfTrials(n);
        d.setProbabilityOfSuccess(p);
        double actual = d.cumulativeProbability(x);
        assertRelativelyEquals(expected, actual, 1.0e-12);
    }
    
    public void testCumulativeProbability() throws NumericException {
        BinomialDistribution d = new BinomialDistribution();
        testCumulativeProbabilitySuccess(d, 3, 30, 0.013919299299916, 0.999229776784619); 
        testCumulativeProbabilitySuccess(d, 5, 20, 0.235309597808196, 0.675815920409857);
        testCumulativeProbabilitySuccess(d, 6, 27, 0.77130548021837, 2.37139046445786e-9); 
        testCumulativeProbabilitySuccess(d, 6, 29, 0.434617914739711, 0.00921284508474472); 
        testCumulativeProbabilitySuccess(d, 8, 21, 0.6068110274244, 0.0304317466114743);
        testCumulativeProbabilitySuccess(d, 8, 23, 0.375872790741577, 0.482417318795537); 
        testCumulativeProbabilitySuccess(d, 9, 26, 0.587176527371838, 0.011326417159273);
        testCumulativeProbabilitySuccess(d, 10, 22, 0.0499416490578149, 0.999999997967302); 
        testCumulativeProbabilitySuccess(d, 14, 26, 0.2969027854443, 0.997280536573119); 
        testCumulativeProbabilitySuccess(d, 20, 25, 0.548326485716307, 0.997805321951694); 
        testCumulativeProbabilitySuccess(d, -1, 10, 0.5, 0.0);
        testCumulativeProbabilitySuccess(d, 11, 10, 0.5, 1.0);
    }
    
    public void testInveseCumulativeProbability() throws NumericException {
        BinomialDistribution d = new BinomialDistribution();
        testInveseCumulativeProbabilitySuccess(d, 0.101596, 20, 0.00434435785977823, -1);
        testInveseCumulativeProbabilitySuccess(d, 0.148592, 27, 0.270444156840255, 4); 
        testInveseCumulativeProbabilitySuccess(d, 0.216234, 25, 0.747973606169628, 16);
        testInveseCumulativeProbabilitySuccess(d, 0.277101, 23, 0.659156718780353, 13); 
        testInveseCumulativeProbabilitySuccess(d, 0.30291, 30, 0.276104637840953, 6);
        testInveseCumulativeProbabilitySuccess(d, 0.341727, 29, 0.565457779290481, 14); 
        testInveseCumulativeProbabilitySuccess(d, 0.488488, 25, 0.0977395250457446, 1);
        testInveseCumulativeProbabilitySuccess(d, 0.567851, 24, 0.831427476547385, 19); 
        testInveseCumulativeProbabilitySuccess(d, 0.709117, 29, 0.0455093451644875, 1);
        testInveseCumulativeProbabilitySuccess(d, 0.804987, 30, 0.358860672543873, 12);
        testInveseCumulativeProbabilitySuccess(d, Double.NaN, 10, 0.5, Integer.MIN_VALUE);
        testInveseCumulativeProbabilitySuccess(d, -1.0, 10, 0.5, Integer.MIN_VALUE);
        testInveseCumulativeProbabilitySuccess(d, 0.0, 10, 0.5, -1);
        testInveseCumulativeProbabilitySuccess(d, 1.0, 10, 0.5, 10);
        testInveseCumulativeProbabilitySuccess(d, 2.0, 10, 0.5, Integer.MIN_VALUE);
    }
    
    private void testInveseCumulativeProbabilitySuccess(BinomialDistribution d, double q, int n, double p, int expected) throws NumericException {
        d.setNumberOfTrials(n);
        d.setProbabilityOfSuccess(p);
        int actual = d.inverseCumulativeProbability(q);
        assertEquals(expected, actual);
        if (Integer.MIN_VALUE < actual && actual < Integer.MAX_VALUE) {
            assertTrue(d.cumulativeProbability(actual - 1) <= q);
            assertTrue(d.cumulativeProbability(actual) <= q);
            assertTrue(q <= d.cumulativeProbability(actual + 1));
            assertTrue(1.0 - q <= 1.0 - d.cumulativeProbability(actual - 1));
            assertTrue(1.0 - q <= 1.0 - d.cumulativeProbability(actual));
            assertTrue(1.0 - d.cumulativeProbability(actual + 1) <= 1.0 - q);
        }
    }
}
