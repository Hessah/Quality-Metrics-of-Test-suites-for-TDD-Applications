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

public class GeometricDistributionTest extends NumericTestCase {

    public void testConstructor() {
        testConstructorFailure(Double.NaN);
        testConstructorFailure(-1.0);
        testConstructorFailure(0.0);
        testConstructorSuccess(0.5);
        testConstructorFailure(1.0);
        testConstructorFailure(2.0);
    }

    private void testConstructorFailure(double p) {
        try {
            new GeometricDistribution(p);
            fail();
        } catch (IllegalArgumentException ex) {
            // success
        }
    }

    private void testConstructorSuccess(double p) {
        try {
            GeometricDistribution d = new GeometricDistribution(p);
            assertEquals(p, d.getProbabilityOfSuccess(), 0.0);
        } catch (IllegalArgumentException ex) {
            fail();
        }
    }

    public void testProbabilityOfSuccess() {
        GeometricDistribution d = new GeometricDistribution();
        testProbabilityOfSuccessFailure(d, Double.NaN);
        testProbabilityOfSuccessFailure(d, -1.0);
        testProbabilityOfSuccessFailure(d, 0.0);
        testProbabilityOfSuccessSuccess(d, 0.5);
        testProbabilityOfSuccessFailure(d, 1.0);
        testProbabilityOfSuccessFailure(d, -2.0);
    }

    private void testProbabilityOfSuccessSuccess(GeometricDistribution d, double p) {
        try {
            d.setProbabilityOfSuccess(p);
            assertEquals(p, d.getProbabilityOfSuccess(), 0.0);
        } catch (IllegalArgumentException ex) {
            fail();
        }
    }

    private void testProbabilityOfSuccessFailure(GeometricDistribution d, double p) {
        try {
            d.setProbabilityOfSuccess(p);
            fail();
        } catch (IllegalArgumentException ex) {
            // success
        }
    }
    
    public void testProbability() throws NumericException {
        GeometricDistribution d = new GeometricDistribution();
        testProbabilitySuccess(d, 1, 0.392490645111708, 0.238441738611503);
        testProbabilitySuccess(d, 2, 0.487924803910914, 0.127944133153281); 
        testProbabilitySuccess(d, 4, 0.44568095624306, 0.0420787929907484); 
        testProbabilitySuccess(d, 5, 0.119425178279162, 0.0632305873297533); 
        testProbabilitySuccess(d, 5, 0.227885155642957, 0.0625353445205185);
        testProbabilitySuccess(d, 7, 0.0650084545498834, 0.040609124681252); 
        testProbabilitySuccess(d, 7, 0.132483538749494, 0.0489898365378509);
        testProbabilitySuccess(d, 7, 0.321789501729848, 0.021238479810942);
        testProbabilitySuccess(d, 10, 0.198742485439546, 0.0216776336420868);
        testProbabilitySuccess(d, 10, 0.418160354062904, 0.00185941340537903);
        testProbabilitySuccess(d, -1, 0.5, 0.0);
        testProbabilitySuccess(d, 0, 0.5, 0.5);
    }
    
    private void testProbabilitySuccess(GeometricDistribution d, int x, double p, double expected) throws NumericException {
        d.setProbabilityOfSuccess(p);
        double actual = d.probability(x);
        assertRelativelyEquals(expected, actual, 1.0e-12);
    }
    
    private void testCumulativeProbabilitySuccess(GeometricDistribution d, int x, double p, double expected) throws NumericException {
        d.setProbabilityOfSuccess(p);
        double actual = d.cumulativeProbability(x);
        assertRelativelyEquals(expected, actual, 1.0e-12);
    }
    
    public void testCumulativeProbability() throws NumericException {
        GeometricDistribution d = new GeometricDistribution();
        testCumulativeProbabilitySuccess(d, 3, 0.162574491423058, 0.50820428242133);
        testCumulativeProbabilitySuccess(d, 5, 0.493988312715897, 0.98321337894093); 
        testCumulativeProbabilitySuccess(d, 5, 0.850088517149674, 0.999988649646174);
        testCumulativeProbabilitySuccess(d, 6, 0.0361836519596368, 0.227390544259153); 
        testCumulativeProbabilitySuccess(d, 8, 0.307023245855793, 0.963147411457407);
        testCumulativeProbabilitySuccess(d, 8, 0.327559125528925, 0.971888311080692); 
        testCumulativeProbabilitySuccess(d, 8, 0.540443072917549, 0.999085773404594);
        testCumulativeProbabilitySuccess(d, 8, 0.619826704845357, 0.999834104554266); 
        testCumulativeProbabilitySuccess(d, 8, 0.716838895906141, 0.999988296860725);
        testCumulativeProbabilitySuccess(d, 9, 0.941332442581317, 0.999999999999517);        
        testCumulativeProbabilitySuccess(d, -1, 0.5, 0.0);
    }
    
    public void testInveseCumulativeProbability() throws NumericException {
        GeometricDistribution d = new GeometricDistribution();
        testInveseCumulativeProbabilitySuccess(d, 0.0698426610652659, 0.212363337443944, -1);
        testInveseCumulativeProbabilitySuccess(d, 0.142840544118575, 0.135701590985866, 0); 
        testInveseCumulativeProbabilitySuccess(d, 0.250111439041442, 0.037894435942401, 6); 
        testInveseCumulativeProbabilitySuccess(d, 0.641919150995471, 0.159696628965942, 4);
        testInveseCumulativeProbabilitySuccess(d, 0.678212571696118, 0.120246717032039, 7); 
        testInveseCumulativeProbabilitySuccess(d, 0.724207090893921, 0.571726247570751, 0); 
        testInveseCumulativeProbabilitySuccess(d, 0.796300465305981, 0.0360162614804262, 42);
        testInveseCumulativeProbabilitySuccess(d, 0.819332707586163, 0.225162345666193, 5); 
        testInveseCumulativeProbabilitySuccess(d, 0.897839554941632, 0.226081528000537, 7);
        testInveseCumulativeProbabilitySuccess(d, 0.922557213801627, 0.305239091912661, 6);
        testInveseCumulativeProbabilitySuccess(d, Double.NaN, 0.5, Integer.MIN_VALUE);
        testInveseCumulativeProbabilitySuccess(d, -1.0, 0.5, Integer.MIN_VALUE);
        testInveseCumulativeProbabilitySuccess(d, 0.0, 0.5, -1);
        testInveseCumulativeProbabilitySuccess(d, 1.0, 0.5, Integer.MAX_VALUE);
        testInveseCumulativeProbabilitySuccess(d, 2.0, 0.5, Integer.MIN_VALUE);
    }
    
    private void testInveseCumulativeProbabilitySuccess(GeometricDistribution d, double q, double p, int expected) throws NumericException {
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
