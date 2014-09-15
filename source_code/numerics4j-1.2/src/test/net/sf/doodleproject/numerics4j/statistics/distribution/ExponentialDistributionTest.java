/*
 * Copyright (c) 2004, DoodleProject
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

/**
 * @version $Revision: 1.8 $ $Date: 2004/08/29 03:14:33 $
 */
public class ExponentialDistributionTest extends NumericTestCase {

    public void testConstructor() {
        testConstructorFailure(Double.NaN);
        testConstructorFailure(-1.0);
        testConstructorFailure(0.0);
        testConstructorSuccess(1.0);
    }
    
    private void testConstructorFailure(double mean) {
        try {
            new ExponentialDistribution(mean);
            fail("Invalid constructor values.");
        } catch (IllegalArgumentException ex) {
            // success
        }
    }
    
    private void testConstructorSuccess(double mean) {
        try {
            ExponentialDistribution d = new ExponentialDistribution(mean);
            assertEquals(mean, d.getMean(), 0.0);
        } catch (IllegalArgumentException ex) {
            fail("Valid constructor values.");
        }
    }
    
    public void testCumulativeProbability() {
        ExponentialDistribution d = new ExponentialDistribution();
        testCumulativeProbabilitySuccess(d, 0.0214459585835302, 0.128693776964417, 0.153498514501856);
        testCumulativeProbabilitySuccess(d, 0.0479628662706476, 6.49592498556149, 0.00735634012143327); 
        testCumulativeProbabilitySuccess(d, 1.4062714500273, 9.60098332075032, 0.136249743035679);
        testCumulativeProbabilitySuccess(d, 1.82589761773137, 2.69766456789789, 0.491781512228657); 
        testCumulativeProbabilitySuccess(d, 2.00138621088215, 5.46627902435771, 0.306589564623854); 
        testCumulativeProbabilitySuccess(d, 3.71757133358002, 3.16812173163107, 0.690696013381563); 
        testCumulativeProbabilitySuccess(d, 5.31606127599409, 6.09383541373634, 0.582038960895467); 
        testCumulativeProbabilitySuccess(d, 6.52618628777865, 5.32788913433167, 0.706215948973577); 
        testCumulativeProbabilitySuccess(d, 9.06456632066451, 9.0951301728845, 0.630882233917144);
        testCumulativeProbabilitySuccess(d, 9.37201173100142, 1.06017978949928, 0.999855180312055);
        testCumulativeProbabilitySuccess(d, Double.NaN, 1.0, Double.NaN);
        testCumulativeProbabilitySuccess(d, -1.0, 1.0, 0.0);
        testCumulativeProbabilitySuccess(d, 0.0, 1.0, 0.0);
        testCumulativeProbabilitySuccess(d, Double.POSITIVE_INFINITY, 1.0, 1.0);
    }
    
    private void testCumulativeProbabilitySuccess(ExponentialDistribution d, double x, double df, double p) {
        d.setMean(df);
    
        double actual = d.cumulativeProbability(x);
        assertRelativelyEquals(p, actual, 1.0e-10);
    }
    
    public void testMean() {
        ExponentialDistribution d = new ExponentialDistribution();
        testMeanFailure(d, Double.NaN);
        testMeanFailure(d, -1.0);
        testMeanFailure(d, 0.0);
        testMeanSuccess(d, 1.0);
    }

    private void testMeanFailure(ExponentialDistribution d, double mean) {
        try {
            d.setMean(mean);
            fail("Invalid mean.");
        } catch (IllegalArgumentException ex) {
            // success
        }
    }

    private void testMeanSuccess(ExponentialDistribution d, double mean) {
        try {
            d.setMean(mean);
            assertEquals(mean, d.getMean(), 0.0);
        } catch (IllegalArgumentException ex) {
            fail("Valid mean.");
        }
    }
    
    public void testInverseCumulativeProbability() {
        ExponentialDistribution d = new ExponentialDistribution();
        testInverseCumulativeProbabilitySuccess(d, 0.0749632322658274, 4.8557978640842, 0.378372477752757); 
        testInverseCumulativeProbabilitySuccess(d, 0.11898619943351, 4.80334137337726, 0.608496836659674); 
        testInverseCumulativeProbabilitySuccess(d, 0.245328968400513, 4.32528044031947, 1.21745115110116);
        testInverseCumulativeProbabilitySuccess(d, 0.272964088705186, 0.463164289690342, 0.147647237200936); 
        testInverseCumulativeProbabilitySuccess(d, 0.278494813490537, 2.35202659582872, 0.767738436590097);
        testInverseCumulativeProbabilitySuccess(d, 0.394906419858722, 0.893964368606078, 0.449102806343792); 
        testInverseCumulativeProbabilitySuccess(d, 0.434716717021982, 2.54064896919515, 1.44925804110857);
        testInverseCumulativeProbabilitySuccess(d, 0.523939330443421, 0.120473840855724, 0.0894168865085948); 
        testInverseCumulativeProbabilitySuccess(d, 0.821840662835905, 3.83860864272933, 6.62189539133918); 
        testInverseCumulativeProbabilitySuccess(d, 0.998455302125584, 1.59522440229232, 10.3257710062229);
        testInverseCumulativeProbabilitySuccess(d, -1.0,  1.0, Double.NaN);
        testInverseCumulativeProbabilitySuccess(d, 0.0, 1.0, 0.0);
        testInverseCumulativeProbabilitySuccess(d, 1.0, 1.0, Double.POSITIVE_INFINITY);
        testInverseCumulativeProbabilitySuccess(d, 2.0,  1.0, Double.NaN);
        testInverseCumulativeProbabilitySuccess(d, Double.NaN,  1.0, Double.NaN);
    }
    
    private void testInverseCumulativeProbabilitySuccess(ExponentialDistribution d, double p, double mean, double expected) {
        d.setMean(mean);
    
        double actual = d.inverseCumulativeProbability(p);
        assertRelativelyEquals(expected, actual, 1.0e-10);
    }
}
