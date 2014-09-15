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

public class LogisticDistributionTest extends NumericTestCase {

    public void testConstructor() {
        testConstructorFailure(Double.NaN, 1.0);
        testConstructorSuccess(-1.0, 1.0);
        testConstructorSuccess(0.0, 1.0);
        testConstructorSuccess(1.0, 1.0);
        testConstructorFailure(0.0, Double.NaN);
        testConstructorFailure(0.0, -1.0);
        testConstructorFailure(0.0, 0.0);
    }
    
    private void testConstructorFailure(double mean, double scale) {
        try {
            new LogisticDistribution(mean, scale);
            fail("Invalid constructor values.");
        } catch (IllegalArgumentException ex) {
            // success
        }
    }
    
    private void testConstructorSuccess(double mean, double scale) {
        try {
            LogisticDistribution d = new LogisticDistribution(mean, scale);
            assertEquals(mean, d.getMean(), 0.0);
            assertEquals(scale, d.getScale(), 0.0);
        } catch (IllegalArgumentException ex) {
            fail("Valid constructor values.");
        }
    }
    
    public void testInverseCumulativeProbability() throws NumericException {
        LogisticDistribution d = new LogisticDistribution();
        testInverseCumulativeProbabilitySuccess(d, 0.0357227335514962, -2.04298030661867, 2.86242916540439, -11.4763778019019); 
        testInverseCumulativeProbabilitySuccess(d, 0.044957729059793, -2.79396543787, 2.30156633744184, -9.82762790547908);
        testInverseCumulativeProbabilitySuccess(d, 0.192970363800031, 2.22184644302037, 1.11266933186168, 0.629812715023398); 
        testInverseCumulativeProbabilitySuccess(d, 0.538391111626402, 0.747977297215563, 1.66975824119243, 1.00489848734353); 
        testInverseCumulativeProbabilitySuccess(d, 0.678098754995351, 1.92432837131865, 2.05012560360293, 3.45177061382542);
        testInverseCumulativeProbabilitySuccess(d, 0.681043562115222, 0.723348877874616, 2.94567964845825, 2.95785820504594); 
        testInverseCumulativeProbabilitySuccess(d, 0.731466045595784, 1.98999589587874, 2.10114153939236, 4.09549401845066);
        testInverseCumulativeProbabilitySuccess(d, 0.879156629086133, -2.76181504042746, 1.2917941361021, -0.198291147152802); 
        testInverseCumulativeProbabilitySuccess(d, 0.99072395127607, -0.657395035234736, 2.23573474163753, 9.78572254153543);
        testInverseCumulativeProbabilitySuccess(d, 0.991169264876679, 0.927141409593494, 0.867282539427468, 5.02127617759336);        
        testInverseCumulativeProbabilitySuccess(d, 0.0, 1.0, 1.0, Double.NEGATIVE_INFINITY);
        testInverseCumulativeProbabilitySuccess(d, 0.5, 1.0, 1.0, 1.0);
        testInverseCumulativeProbabilitySuccess(d, 1.0, 1.0, 1.0, Double.POSITIVE_INFINITY);
        testInverseCumulativeProbabilitySuccess(d, Double.NaN,  1.0, 1.0, Double.NaN);
        testInverseCumulativeProbabilitySuccess(d, -1.0,  1.0, 1.0, Double.NaN);
        testInverseCumulativeProbabilitySuccess(d, 2.0,  1.0, 1.0, Double.NaN);
    }
    
    private void testInverseCumulativeProbabilitySuccess(LogisticDistribution d, double p, double mean, double scale, double expected) throws NumericException {
        d.setMean(mean);
        d.setScale(scale);
    
        double actual = d.inverseCumulativeProbability(p);
        assertRelativelyEquals(expected, actual, 1.0e-10);
    }

    public void testCumulativeProbability() throws NumericException {
        LogisticDistribution d = new LogisticDistribution();
        testCumulativeProbabilitySuccess(d, -1.97129790472901, -1.6269717008678, 0.612513724553279, 0.363049528106882);
        testCumulativeProbabilitySuccess(d, -0.618208581763377, 0.811502481653768, 2.63652461201881, 0.367659428218549); 
        testCumulativeProbabilitySuccess(d, 1.38417472141184, 0.880226810561334, 2.56010810149547, 0.549053292252776); 
        testCumulativeProbabilitySuccess(d, 1.92791022291877, 1.30601829843977, 2.82386304500485, 0.554835393997163);
        testCumulativeProbabilitySuccess(d, 2.61172691334765, -2.94690666850357, 2.00642314792459, 0.941056253818783); 
        testCumulativeProbabilitySuccess(d, 3.17646633613659, 1.98732401427508, 1.30887331697824, 0.712697954414337);
        testCumulativeProbabilitySuccess(d, 3.48104227790956, -1.51210013191816, 2.70437866364314, 0.863694188198778); 
        testCumulativeProbabilitySuccess(d, 3.66088284793044, 2.97615144173644, 2.18671571058857, 0.577649644951203);
        testCumulativeProbabilitySuccess(d, 3.75542518282255, -2.65475634790251, 2.51648453720108, 0.927390323756556);
        testCumulativeProbabilitySuccess(d, 3.92206933740963, 0.409844885584621, 0.941164980317752, 0.976610119436969);        
        testCumulativeProbabilitySuccess(d, Double.NEGATIVE_INFINITY, 0.0, 1.0, 0.0);
        testCumulativeProbabilitySuccess(d, 1.0, 1.0, 1.0, 0.5);
        testCumulativeProbabilitySuccess(d, Double.POSITIVE_INFINITY, 0.0, 1.0, 1.0);
        testCumulativeProbabilitySuccess(d, Double.NaN, 0.0, 1.0, Double.NaN);
    }
    
    private void testCumulativeProbabilitySuccess(LogisticDistribution d, double x, double mean, double scale, double expected) throws NumericException {
        d.setMean(mean);
        d.setScale(scale);
    
        double actual = d.cumulativeProbability(x);
        assertRelativelyEquals(expected, actual, 1.0e-10);
    }
    
    public void testMean() {
        LogisticDistribution d = new LogisticDistribution();
        testMeanFailure(d, Double.NaN);
        testMeanSuccess(d, -1.0);
        testMeanSuccess(d, 0.0);
        testMeanSuccess(d, 1.0);
    }
    
    public void testScale() {
        LogisticDistribution d = new LogisticDistribution();
        testScaleFailure(d, Double.NaN);
        testScaleFailure(d, -1.0);
        testScaleFailure(d, 0.0);
        testScaleSuccess(d, 1.0);
    }

    private void testScaleFailure(LogisticDistribution d, double scale) {
        try {
            d.setScale(scale);
            fail("Invalid scale.");
        } catch (IllegalArgumentException ex) {
            // success
        }
    }

    private void testScaleSuccess(LogisticDistribution d, double scale) {
        try {
            d.setScale(scale);
            assertEquals(scale, d.getScale(), 0.0);
        } catch (IllegalArgumentException ex) {
            fail("Valid scale.");
        }
    }

    private void testMeanFailure(LogisticDistribution d, double mean) {
        try {
            d.setMean(mean);
            fail("Invalid mean.");
        } catch (IllegalArgumentException ex) {
            // success
        }
    }

    private void testMeanSuccess(LogisticDistribution d, double mean) {
        try {
            d.setMean(mean);
            assertEquals(mean, d.getMean(), 0.0);
        } catch (IllegalArgumentException ex) {
            fail("Valid mean.");
        }
    }
}
