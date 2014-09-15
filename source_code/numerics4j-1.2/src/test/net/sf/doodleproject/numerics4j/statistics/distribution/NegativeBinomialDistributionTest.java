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

public class NegativeBinomialDistributionTest extends NumericTestCase {

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
            new NegativeBinomialDistribution(n, p);
            fail();
        } catch (IllegalArgumentException ex) {
            // success
        }
    }

    private void testConstructorSuccess(int n, double p) {
        try {
            NegativeBinomialDistribution d = new NegativeBinomialDistribution(n, p);
            assertEquals(n, d.getNumberOfSuccesses());
            assertEquals(p, d.getProbabilityOfSuccess(), 0.0);
        } catch (IllegalArgumentException ex) {
            fail();
        }
    }

    public void testNumberOfSuccesses() {
        NegativeBinomialDistribution d = new NegativeBinomialDistribution();
        testNumberOfSuccessesFailure(d, -1);
        testNumberOfSuccessesFailure(d, 0);
        testNumberOfSuccessesSuccess(d, 5);
    }

    private void testNumberOfSuccessesSuccess(NegativeBinomialDistribution d, int n) {
        try {
            d.setNumberOfSuccesses(n);
            assertEquals(n, d.getNumberOfSuccesses());
        } catch (IllegalArgumentException ex) {
            fail();
        }
    }

    private void testNumberOfSuccessesFailure(NegativeBinomialDistribution d, int n) {
        try {
            d.setNumberOfSuccesses(n);
            fail();
        } catch (IllegalArgumentException ex) {
            // success
        }
    }

    public void testProbabilityOfSuccess() {
        NegativeBinomialDistribution d = new NegativeBinomialDistribution();
        testProbabilityOfSuccessFailure(d, Double.NaN);
        testProbabilityOfSuccessFailure(d, -1.0);
        testProbabilityOfSuccessFailure(d, 0.0);
        testProbabilityOfSuccessSuccess(d, 0.5);
        testProbabilityOfSuccessFailure(d, 1.0);
        testProbabilityOfSuccessFailure(d, -2.0);
    }

    private void testProbabilityOfSuccessSuccess(NegativeBinomialDistribution d, double p) {
        try {
            d.setProbabilityOfSuccess(p);
            assertEquals(p, d.getProbabilityOfSuccess(), 0.0);
        } catch (IllegalArgumentException ex) {
            fail();
        }
    }

    private void testProbabilityOfSuccessFailure(NegativeBinomialDistribution d, double p) {
        try {
            d.setProbabilityOfSuccess(p);
            fail();
        } catch (IllegalArgumentException ex) {
            // success
        }
    }
    
    public void testProbability() throws NumericException {
        NegativeBinomialDistribution d = new NegativeBinomialDistribution();

        testProbabilitySuccess(d, 1, 6, 0.648951807435951, 0.157323163164843);
        testProbabilitySuccess(d, 2, 3, 0.696570036966026, 0.186707836549182); 
            
        testProbabilitySuccess(d, 3, 9, 0.817677887279727, 0.163396314585584);
        testProbabilitySuccess(d, 4, 10, 0.281247202077425, 0.00059088959376353); 
            
        testProbabilitySuccess(d, 5, 3, 0.449841161385531, 0.0963468106096722); 
        testProbabilitySuccess(d, 7, 1, 0.0184143957065398, 0.0161679417185586);
            
        testProbabilitySuccess(d, 9, 7, 0.630473334730567, 0.0254614533507798);
        testProbabilitySuccess(d, 10, 2, 0.239169835731067, 0.0408961778677963);
        
        testProbabilitySuccess(d, -1, 10, 0.5, 0.0);
    }
    
    private void testProbabilitySuccess(NegativeBinomialDistribution d, int x, int n, double p, double expected) throws NumericException {
        d.setNumberOfSuccesses(n);
        d.setProbabilityOfSuccess(p);
        double actual = d.probability(x);
        assertRelativelyEquals(expected, actual, 1.0e-12);
    }
    
    private void testCumulativeProbabilitySuccess(NegativeBinomialDistribution d, int x, int n, double p, double expected) throws NumericException {
        d.setNumberOfSuccesses(n);
        d.setProbabilityOfSuccess(p);
        double actual = d.cumulativeProbability(x);
        assertRelativelyEquals(expected, actual, 1.0e-12);
    }
    
    public void testCumulativeProbability() throws NumericException {
        NegativeBinomialDistribution d = new NegativeBinomialDistribution();
        testCumulativeProbabilitySuccess(d, 1, 6, 0.648951807435951, 0.232015264561596);
        testCumulativeProbabilitySuccess(d, 2, 3, 0.696570036966026, 0.832352617740667); 
        testCumulativeProbabilitySuccess(d, 2, 6, 0.811977252443637, 0.822672150561347); 
        testCumulativeProbabilitySuccess(d, 3, 9, 0.817677887279727, 0.839324555719862);
        testCumulativeProbabilitySuccess(d, 4, 10, 0.281247202077425, 0.000957182051753575); 
        testCumulativeProbabilitySuccess(d, 5, 3, 0.449841161385531, 0.779597645819536); 
        testCumulativeProbabilitySuccess(d, 7, 1, 0.0184143957065398, 0.138162386922285);
        testCumulativeProbabilitySuccess(d, 9, 2, 0.784993629340154, 0.999998131670689);
        testCumulativeProbabilitySuccess(d, 9, 7, 0.630473334730567, 0.966243419407232);
        testCumulativeProbabilitySuccess(d, 10, 2, 0.239169835731067, 0.820454125160484);
        testCumulativeProbabilitySuccess(d, -1, 10, 0.5, 0.0);
    }
    
    public void testInveseCumulativeProbability() throws NumericException {
        NegativeBinomialDistribution d = new NegativeBinomialDistribution();
        testInveseCumulativeProbabilitySuccess(d, 0.0165420409292659, 3, 0.617216676090787, -1); 
        testInveseCumulativeProbabilitySuccess(d, 0.253807630873735, 6, 0.642433878982014, 1); 
        testInveseCumulativeProbabilitySuccess(d, 0.486301284425628, 6, 0.123987178207096, 38);
        testInveseCumulativeProbabilitySuccess(d, 0.504715680132168, 10, 0.405234380284522, 13); 
        testInveseCumulativeProbabilitySuccess(d, 0.668623397145901, 5, 0.470500690764804, 6);
        testInveseCumulativeProbabilitySuccess(d, 0.713112077895292, 3, 0.0670578374763177, 51); 
        testInveseCumulativeProbabilitySuccess(d, 0.737275542966513, 10, 0.346482979642836, 22);
        testInveseCumulativeProbabilitySuccess(d, 0.798802051722491, 7, 0.84997054156796, 1); 
        testInveseCumulativeProbabilitySuccess(d, 0.910410034829213, 4, 0.730657017809646, 3);
        testInveseCumulativeProbabilitySuccess(d, 0.952281913626359, 10, 0.716009644912269, 7);
        testInveseCumulativeProbabilitySuccess(d, Double.NaN, 10, 0.5, Integer.MIN_VALUE);
        testInveseCumulativeProbabilitySuccess(d, -1.0, 10, 0.5, Integer.MIN_VALUE);
        testInveseCumulativeProbabilitySuccess(d, 0.0, 10, 0.5, -1);
        testInveseCumulativeProbabilitySuccess(d, 1.0, 10, 0.5, Integer.MAX_VALUE);
        testInveseCumulativeProbabilitySuccess(d, 2.0, 10, 0.5, Integer.MIN_VALUE);
    }
    
    private void testInveseCumulativeProbabilitySuccess(NegativeBinomialDistribution d, double q, int n, double p, int expected) throws NumericException {
        d.setNumberOfSuccesses(n);
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
