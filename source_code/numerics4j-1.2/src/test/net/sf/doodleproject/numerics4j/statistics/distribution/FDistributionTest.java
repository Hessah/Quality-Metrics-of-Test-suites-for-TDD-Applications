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

/**
 * @version $Revision: 1.5 $ $Date: 2004/08/29 03:14:33 $
 */
public class FDistributionTest extends NumericTestCase {

    public void testConstructor() {
        testConstructorFailure(Double.NaN, 1.0);
        testConstructorFailure(-1.0, 1.0);
        testConstructorFailure(0.0, 1.0);
        testConstructorSuccess(1.0, 1.0);
        testConstructorFailure(0.0, Double.NaN);
        testConstructorFailure(0.0, -1.0);
        testConstructorFailure(0.0, 0.0);
    }
    
    private void testConstructorFailure(double dfn, double dfd) {
        try {
            new FDistribution(dfn, dfd);
            fail("Invalid constructor values.");
        } catch (IllegalArgumentException ex) {
            // success
        }
    }
    
    private void testConstructorSuccess(double dfn, double dfd) {
        try {
            FDistribution d = new FDistribution(dfn, dfd);
            assertEquals(dfn, d.getNumeratorDegreesOfFreedom(), 0.0);
            assertEquals(dfd, d.getDenominatorDegreesOfFreedom(), 0.0);
        } catch (IllegalArgumentException ex) {
            fail("Valid constructor values.");
        }
    }
    
    public void testCumulativeProbability() throws NumericException {
        FDistribution d = new FDistribution();
        testCumulativeProbabilitySuccess(d, 0.349190344480171, 9.83679924729768, 6.70782169134761, 0.066564841982377); 
        testCumulativeProbabilitySuccess(d, 1.08708230791422, 3.14627807573062, 7.04725117763018, 0.582440408790137); 
        testCumulativeProbabilitySuccess(d, 1.37500262547569, 4.14344907188263, 5.94944313926537, 0.652629405874352); 
        testCumulativeProbabilitySuccess(d, 2.21678032814905, 6.04733218683229, 0.693940351094141, 0.45645964365545); 
        testCumulativeProbabilitySuccess(d, 5.62073938343339, 6.62112135512531, 5.72655306311386, 0.97104079798657);
        testCumulativeProbabilitySuccess(d, 6.18204370840945, 7.57538610373613, 0.748074500128928, 0.624883293508164); 
        testCumulativeProbabilitySuccess(d, 6.35968597904321, 3.00393031021787, 2.79669733070886, 0.910081340378548); 
        testCumulativeProbabilitySuccess(d, 7.71290305383934, 5.38325617651089, 5.86814710072249, 0.985992568012647); 
        testCumulativeProbabilitySuccess(d, 7.89078716720703, 3.87861105271327, 8.39635806209569, 0.993652211072449); 
        testCumulativeProbabilitySuccess(d, 9.76739943085593, 2.77380424074404, 9.08872474716875, 0.996330398898855);
        testCumulativeProbabilitySuccess(d, Double.NaN, 1.0, 1.0, Double.NaN);
        testCumulativeProbabilitySuccess(d, -1.0, 1.0, 1.0, 0.0);
        testCumulativeProbabilitySuccess(d, 0.0, 1.0, 1.0, 0.0);
        testCumulativeProbabilitySuccess(d, Double.POSITIVE_INFINITY, 1.0, 1.0, 1.0);
    }
    
    private void testCumulativeProbabilitySuccess(FDistribution d, double x, double dfn, double dfd, double expected) throws NumericException {
        d.setNumeratorDegreesOfFreedom(dfn);
        d.setDenominatorDegreesOfFreedom(dfd);
    
        double actual = d.cumulativeProbability(x);
        assertRelativelyEquals(expected, actual, 1.0e-10);
    }
    
    public void testDenominatorDegreesOfFreedom() {
        FDistribution d = new FDistribution();
        testDenominatorDegreesOfFreedomFailure(d, Double.NaN);
        testDenominatorDegreesOfFreedomFailure(d, -1.0);
        testDenominatorDegreesOfFreedomFailure(d, 0.0);
        testDenominatorDegreesOfFreedomSuccess(d, 1.0);
    }
    
    public void testNumeratorDegreesOfFreedom() {
        FDistribution d = new FDistribution();
        testNumeratorDegreesOfFreedomFailure(d, Double.NaN);
        testNumeratorDegreesOfFreedomFailure(d, -1.0);
        testNumeratorDegreesOfFreedomFailure(d, 0.0);
        testNumeratorDegreesOfFreedomSuccess(d, 1.0);
    }

    private void testNumeratorDegreesOfFreedomFailure(FDistribution d, double dfd) {
        try {
            d.setNumeratorDegreesOfFreedom(dfd);
            fail("Invalid degrees of freedom.");
        } catch (IllegalArgumentException ex) {
            // success
        }
    }

    private void testNumeratorDegreesOfFreedomSuccess(FDistribution d, double dfn) {
        try {
            d.setNumeratorDegreesOfFreedom(dfn);
            assertEquals(dfn, d.getNumeratorDegreesOfFreedom(), 0.0);
        } catch (IllegalArgumentException ex) {
            fail("Valid degrees of freedom.");
        }
    }

    private void testDenominatorDegreesOfFreedomFailure(FDistribution d, double dfd) {
        try {
            d.setDenominatorDegreesOfFreedom(dfd);
            fail("Invalid degrees of freedom.");
        } catch (IllegalArgumentException ex) {
            // success
        }
    }

    private void testDenominatorDegreesOfFreedomSuccess(FDistribution d, double dfd) {
        try {
            d.setDenominatorDegreesOfFreedom(dfd);
            assertEquals(dfd, d.getDenominatorDegreesOfFreedom(), 0.0);
        } catch (IllegalArgumentException ex) {
            fail("Valid degrees of freedom.");
        }
    }
    
    public void testInverseCumulativeProbability() throws NumericException {
        FDistribution d = new FDistribution();
        testInverseCumulativeProbabilitySuccess(d, 0.00481056075340358, 5.0527988689465, 8.43832127277833, 0.0721596108643888);
        testInverseCumulativeProbabilitySuccess(d, 0.24672254909398, 6.9047814650634, 6.18104054876582, 0.579434059407608);
        testInverseCumulativeProbabilitySuccess(d, 0.279836537177273, 3.31646430781504, 3.46775461454663, 0.497023675886245);
        testInverseCumulativeProbabilitySuccess(d, 0.402735053051066, 1.8560041140011, 0.849348162335339, 0.967399907535097); 
        testInverseCumulativeProbabilitySuccess(d, 0.425213512233533, 9.37104734987016, 2.4461884474621, 1.01501292325979); 
        testInverseCumulativeProbabilitySuccess(d, 0.465047026865016, 2.35819070594042, 5.38097510438004, 0.753439898984955);
        testInverseCumulativeProbabilitySuccess(d, 0.50900421434744, 6.01665606904717, 5.2558615342352, 1.03773603739869);
        testInverseCumulativeProbabilitySuccess(d, 0.558873219474722, 2.51513153763082, 3.76568379362687, 1.09041296206275);
        testInverseCumulativeProbabilitySuccess(d, 0.97383332631162, 8.1229588425212, 7.83460256734849, 4.41669242083418);
        testInverseCumulativeProbabilitySuccess(d, 0.99789629565223, 8.68395072968383, 6.334090988865, 13.1838201310607);
        testInverseCumulativeProbabilitySuccess(d, -1.0,  1.0, 1.0, Double.NaN);
        testInverseCumulativeProbabilitySuccess(d, 0.0, 1.0, 1.0, 0.0);
        testInverseCumulativeProbabilitySuccess(d, 1.0, 1.0, 1.0, Double.POSITIVE_INFINITY);
        testInverseCumulativeProbabilitySuccess(d, 2.0,  1.0, 1.0, Double.NaN);
        testInverseCumulativeProbabilitySuccess(d, Double.NaN,  1.0, 1.0, Double.NaN);
    }
    
    private void testInverseCumulativeProbabilitySuccess(FDistribution d, double p, double dfn, double dfd, double expected) throws NumericException {
        d.setNumeratorDegreesOfFreedom(dfn);
        d.setDenominatorDegreesOfFreedom(dfd);
    
        double actual = d.inverseCumulativeProbability(p);
        assertRelativelyEquals(expected, actual, 1.0e-10);
    }
}
