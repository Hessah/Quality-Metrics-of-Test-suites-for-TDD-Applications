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
import net.sf.doodleproject.numerics4j.exception.NumericException;

public class NormalDistributionTest extends NumericTestCase {

    public void testConstructor() {
        testConstructorFailure(Double.NaN, 1.0);
        testConstructorSuccess(-1.0, 1.0);
        testConstructorSuccess(0.0, 1.0);
        testConstructorSuccess(1.0, 1.0);
        testConstructorFailure(0.0, Double.NaN);
        testConstructorFailure(0.0, -1.0);
        testConstructorFailure(0.0, 0.0);
    }
    
    private void testConstructorFailure(double mean, double std) {
        try {
            new NormalDistribution(mean, std);
            fail("Invalid constructor values.");
        } catch (IllegalArgumentException ex) {
            // success
        }
    }
    
    private void testConstructorSuccess(double mean, double std) {
        try {
            NormalDistribution d = new NormalDistribution(mean, std);
            assertEquals(mean, d.getMean(), 0.0);
            assertEquals(std, d.getStandardDeviation(), 0.0);
        } catch (IllegalArgumentException ex) {
            fail("Valid constructor values.");
        }
    }
    
    public void testCumulativeProbability() throws NumericException {
        NormalDistribution d = new NormalDistribution();
        testCumulativeProbabilitySuccess(d, -1.34369037691967, 0.356557413339566, 1.11722795257193, 0.0640239596116414); 
        testCumulativeProbabilitySuccess(d, -0.729023252658162, 0.692592595268866, 1.79268081551582, 0.213885667699407); 
        testCumulativeProbabilitySuccess(d, -0.522081032515724, 1.30642289649413, 0.391509153919264, 1.50307689972262e-6); 
        testCumulativeProbabilitySuccess(d, -0.166599448430024, -1.29645504165951, 0.229996332207619, 0.999999550374233); 
        testCumulativeProbabilitySuccess(d, -0.148728936223449, -0.508222926766348, 1.19927847425967, 0.617819337235851); 
        testCumulativeProbabilitySuccess(d, -0.145199135490345, 0.889037084583733, 1.49899362160134, 0.245111646937756);
        testCumulativeProbabilitySuccess(d, -0.143392322354286, -0.230329283103255, 1.04770336984908, 0.533065722898791); 
        testCumulativeProbabilitySuccess(d, 0.603384986769523, 1.70824825058753, 0.605508078397984, 0.0340240701475813); 
        testCumulativeProbabilitySuccess(d, 1.0997091050195, 0.526977655075845, 1.96026332525098, 0.614921932328044); 
        testCumulativeProbabilitySuccess(d, 1.54981013583799, 1.24183459290567, 0.288814036251887, 0.856866251886108);
        testCumulativeProbabilitySuccess(d, Double.NaN, 0.0, 1.0, Double.NaN);
        testCumulativeProbabilitySuccess(d, Double.NEGATIVE_INFINITY, 0.0, 1.0, 0.0);
        testCumulativeProbabilitySuccess(d, Double.POSITIVE_INFINITY, 0.0, 1.0, 1.0);
    }
    
    private void testCumulativeProbabilitySuccess(NormalDistribution d, double x, double mean, double std, double p) throws NumericException {
        d.setMean(mean);
        d.setStandardDeviation(std);
    
        double actual = d.cumulativeProbability(x);
        assertRelativelyEquals(p, actual, 1.0e-10);
    }
    
    public void testMean() {
        NormalDistribution d = new NormalDistribution();
        testMeanFailure(d, Double.NaN);
        testMeanSuccess(d, -1.0);
        testMeanSuccess(d, 0.0);
        testMeanSuccess(d, 1.0);
    }
    
    public void testStandardDeviation() {
        NormalDistribution d = new NormalDistribution();
        testStandardDeviationFailure(d, Double.NaN);
        testStandardDeviationFailure(d, -1.0);
        testStandardDeviationFailure(d, 0.0);
        testStandardDeviationSuccess(d, 1.0);
    }

    private void testStandardDeviationFailure(NormalDistribution d, double std) {
        try {
            d.setStandardDeviation(std);
            fail("Invalid standard deviation.");
        } catch (IllegalArgumentException ex) {
            // success
        }
    }

    private void testStandardDeviationSuccess(NormalDistribution d, double std) {
        try {
            d.setStandardDeviation(std);
            assertEquals(std, d.getStandardDeviation(), 0.0);
        } catch (IllegalArgumentException ex) {
            fail("Valid standard deviation.");
        }
    }

    private void testMeanFailure(NormalDistribution d, double mean) {
        try {
            d.setMean(mean);
            fail("Invalid mean.");
        } catch (IllegalArgumentException ex) {
            // success
        }
    }

    private void testMeanSuccess(NormalDistribution d, double mean) {
        try {
            d.setMean(mean);
            assertEquals(mean, d.getMean(), 0.0);
        } catch (IllegalArgumentException ex) {
            fail("Valid mean.");
        }
    }
    
    public void testInverseCumulativeProbability() throws NumericException {
        NormalDistribution d = new NormalDistribution();
        testInverseCumulativeProbabilitySuccess(d, 0.0657196621483069, -0.262817269170976, 0.778367385264996, -1.43694576472746); 
        testInverseCumulativeProbabilitySuccess(d, 0.251268996617415, -0.154022463268354, 0.0314405095555465, -0.175103379847939); 
        testInverseCumulativeProbabilitySuccess(d, 0.441272810254576, 2.89095526099124, 0.399348970390967, 2.83195425901421);
        testInverseCumulativeProbabilitySuccess(d, 0.456113499493886, -1.17351868239976, 1.7428562686176, -1.36563366667873); 
        testInverseCumulativeProbabilitySuccess(d, 0.498124339059803, 1.37616979175392, 1.3107020201109, 1.37000739242591);
        testInverseCumulativeProbabilitySuccess(d, 0.589631347907142, -1.27383194766784, 1.03604246668214, -1.03906807120026); 
        testInverseCumulativeProbabilitySuccess(d, 0.739446586439525, 0.646832826451615, 0.176040380386418, 0.759787410782222); 
        testInverseCumulativeProbabilitySuccess(d, 0.740496489071072, 1.13286667341523, 0.73010518849707, 1.60369457720128);
        testInverseCumulativeProbabilitySuccess(d, 0.74389179719353, 2.4432295558414, 0.3614387933882, 2.68011308534075);
        testInverseCumulativeProbabilitySuccess(d, 0.865106697045585, 2.88241392806408, 0.952311607270427, 3.93334131872335);
        testInverseCumulativeProbabilitySuccess(d, -1.0,  1.0, 1.0, Double.NaN);
        testInverseCumulativeProbabilitySuccess(d, 0.0, 1.0, 1.0, Double.NEGATIVE_INFINITY);
        testInverseCumulativeProbabilitySuccess(d, 1.0, 1.0, 1.0, Double.POSITIVE_INFINITY);
        testInverseCumulativeProbabilitySuccess(d, 2.0, 1.0, 1.0, Double.NaN);
        testInverseCumulativeProbabilitySuccess(d, Double.NaN,  1.0, 1.0, Double.NaN);
    }
    
    private void testInverseCumulativeProbabilitySuccess(NormalDistribution d, double p, double mean, double std, double expected) throws NumericException {
        d.setMean(mean);
        d.setStandardDeviation(std);
    
        double actual = d.inverseCumulativeProbability(p);
        assertRelativelyEquals(expected, actual, 1.0e-10);
    }
}
