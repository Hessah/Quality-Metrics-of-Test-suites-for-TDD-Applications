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

/**
 * @version $Revision: 1.1 $ $Date: 2005/06/24 15:31:02 $
 */
public class UniformDistributionTest extends NumericTestCase {

    public void testConstructor() {
        testConstructorFailure(Double.NaN, 1.0);
        testConstructorSuccess(0.0, 1.0);
        testConstructorSuccess(1.0, 1.0);
        testConstructorFailure(0.0, Double.NaN);
        testConstructorFailure(1.0, 0.0);
    }
    
    private void testConstructorFailure(double low, double up) {
        try {
            new UniformDistribution(low, up);
            fail("Invalid constructor values.");
        } catch (IllegalArgumentException ex) {
            // success
        }
    }
    
    private void testConstructorSuccess(double low, double up) {
        try {
            UniformDistribution d = new UniformDistribution(low, up);
            assertEquals(low, d.getLower(), 0.0);
            assertEquals(up, d.getUpper(), 0.0);
        } catch (IllegalArgumentException ex) {
            fail("Valid constructor values.");
        }
    }
    
    public void testCumulativeProbability() throws NumericException {
        UniformDistribution d = new UniformDistribution();
        testCumulativeProbabilitySuccess(d, 0.0, -1.0, 1.0, 0.5);
        testCumulativeProbabilitySuccess(d, Double.NaN, 0.0, 1.0, Double.NaN);
        testCumulativeProbabilitySuccess(d, 0.0, 0.0, 1.0, 0.0);
        testCumulativeProbabilitySuccess(d, 1.0, 0.0, 1.0, 1.0);
        testCumulativeProbabilitySuccess(d, -1.0, 0.0, 1.0, 0.0);
        testCumulativeProbabilitySuccess(d, 2.0, 0.0, 1.0, 1.0);
    }
    
    private void testCumulativeProbabilitySuccess(UniformDistribution d, double x, double low, double up, double expected) throws NumericException {
        d.setLower(low);
        d.setUpper(up);
    
        double actual = d.cumulativeProbability(x);
        assertRelativelyEquals(expected, actual, 1.0e-10);
    }
    
    public void testUpper() {
        UniformDistribution d = new UniformDistribution(0.0, 1.0);
        testUpperFailure(d, Double.NaN);
        testUpperFailure(d, -1.0);
        testUpperSuccess(d, 0.0);
        testUpperSuccess(d, 2.0);
    }
    
    public void testLower() {
        UniformDistribution d = new UniformDistribution(0.0, 1.0);
        testLowerFailure(d, Double.NaN);
        testLowerFailure(d, 2.0);
        testLowerSuccess(d, 1.0);
        testLowerSuccess(d, -1.0);
    }

    private void testLowerFailure(UniformDistribution d, double low) {
        try {
            d.setLower(low);
            fail("Invalid lower bound.");
        } catch (IllegalArgumentException ex) {
            // success
        }
    }

    private void testLowerSuccess(UniformDistribution d, double low) {
        try {
            d.setLower(low);
            assertEquals(low, d.getLower(), 0.0);
        } catch (IllegalArgumentException ex) {
            fail("Valid lower bound.");
        }
    }

    private void testUpperFailure(UniformDistribution d, double up) {
        try {
            d.setUpper(up);
            fail("Invalid upper bound.");
        } catch (IllegalArgumentException ex) {
            // success
        }
    }

    private void testUpperSuccess(UniformDistribution d, double up) {
        try {
            d.setUpper(up);
            assertEquals(up, d.getUpper(), 0.0);
        } catch (IllegalArgumentException ex) {
            fail("Valid upper bound.");
        }
    }
    
    public void testInverseCumulativeProbability() throws NumericException {
        UniformDistribution d = new UniformDistribution();
        testInverseCumulativeProbabilitySuccess(d, 0.5, 0.0, 2.0, 1.0);
        testInverseCumulativeProbabilitySuccess(d, -1.0, 0.0, 1.0, Double.NaN);
        testInverseCumulativeProbabilitySuccess(d, 0.0, 0.0, 1.0, 0.0);
        testInverseCumulativeProbabilitySuccess(d, 1.0, 0.0, 1.0, 1.0);
        testInverseCumulativeProbabilitySuccess(d, 2.0, 0.0, 1.0, Double.NaN);
        testInverseCumulativeProbabilitySuccess(d, Double.NaN, 0.0, 1.0, Double.NaN);
    }
    
    private void testInverseCumulativeProbabilitySuccess(UniformDistribution d, double p, double low, double up, double expected) throws NumericException {
        d.setLower(low);
        d.setUpper(up);
    
        double actual = d.inverseCumulativeProbability(p);
        assertRelativelyEquals(expected, actual, 1.0e-10);
    }
}
