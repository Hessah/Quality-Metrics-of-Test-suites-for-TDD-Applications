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
 * Neither the name of DoodleProject nor the names of its contributors
 * may be used to endorse or promote products derived from this
 * software without specific prior written permission.
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

public class LaplaceDistributionTest extends NumericTestCase {

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
            new LaplaceDistribution(mean, scale);
            fail("Invalid constructor values.");
        } catch (IllegalArgumentException ex) {
            // success
        }
    }
    
    private void testConstructorSuccess(double mean, double scale) {
        try {
            LaplaceDistribution d = new LaplaceDistribution(mean, scale);
            assertEquals(mean, d.getMean(), 0.0);
            assertEquals(scale, d.getScale(), 0.0);
        } catch (IllegalArgumentException ex) {
            fail("Valid constructor values.");
        }
    }
    
    public void testInverseCumulativeProbability() throws NumericException {
        LaplaceDistribution d = new LaplaceDistribution();
        testInverseCumulativeProbabilitySuccess(d, 0.077213095459833, -2.20760841250756, 2.05741009921913, -6.05093076924157);
        testInverseCumulativeProbabilitySuccess(d, 0.194678229333858, -0.356167616579394, 2.45959848740617, -2.67620850736373); 
        testInverseCumulativeProbabilitySuccess(d, 0.307688720366853, 0.328000180932865, 1.90778117179366, -0.598264731357657); 
        testInverseCumulativeProbabilitySuccess(d, 0.515350627000995, 1.04631041596938, 1.99220717769307, 1.10843223938693);
        testInverseCumulativeProbabilitySuccess(d, 0.570837261719276, -0.308490757335332, 0.542315524918508, -0.225640179793172); 
        testInverseCumulativeProbabilitySuccess(d, 0.666853864915345, -1.21463981870972, 1.67336052334661, -0.535210498750618); 
        testInverseCumulativeProbabilitySuccess(d, 0.849000941422332, -2.58971646066831, 0.864665039691711, -1.55442318097718); 
        testInverseCumulativeProbabilitySuccess(d, 0.884469180569959, 2.20539906567291, 2.38209885781766, 5.69534247151649);
        testInverseCumulativeProbabilitySuccess(d, 0.945032011183555, -0.318179777325718, 1.15849016829298, 2.2396009708269); 
        testInverseCumulativeProbabilitySuccess(d, 0.997215194315679, 0.308645467243713, 1.53178124631924, 8.25924880113817);
        testInverseCumulativeProbabilitySuccess(d, 0.0, 1.0, 1.0, Double.NEGATIVE_INFINITY);
        testInverseCumulativeProbabilitySuccess(d, 0.5, 1.0, 1.0, 1.0);
        testInverseCumulativeProbabilitySuccess(d, 1.0, 1.0, 1.0, Double.POSITIVE_INFINITY);
        testInverseCumulativeProbabilitySuccess(d, Double.NaN,  1.0, 1.0, Double.NaN);
        testInverseCumulativeProbabilitySuccess(d, -1.0,  1.0, 1.0, Double.NaN);
        testInverseCumulativeProbabilitySuccess(d, 2.0,  1.0, 1.0, Double.NaN);
    }
    
    private void testInverseCumulativeProbabilitySuccess(LaplaceDistribution d, double p, double mean, double scale, double expected) throws NumericException {
        d.setMean(mean);
        d.setScale(scale);
    
        double actual = d.inverseCumulativeProbability(p);
        assertRelativelyEquals(expected, actual, 1.0e-13);
    }

    public void testCumulativeProbability() throws NumericException {
        LaplaceDistribution d = new LaplaceDistribution();
        testCumulativeProbabilitySuccess(d, -3.9644125382033, -2.62432221148929, 2.26450609249118, 0.276670618566181);
        testCumulativeProbabilitySuccess(d, -3.79423569736442, -1.73949533254963, 0.610492355143383, 0.0172687389325689); 
        testCumulativeProbabilitySuccess(d, -2.93717742601218, -0.638453400142387, 2.80912886501791, 0.220589422952664); 
        testCumulativeProbabilitySuccess(d, -1.84084480560779, -2.21880881310495, 1.88615613392616, 0.590793632984841);
        testCumulativeProbabilitySuccess(d, -1.24438222946038, 0.547500447568128, 0.709874273120722, 0.0400601746506566); 
        testCumulativeProbabilitySuccess(d, 0.121774421018714, 0.135278391826134, 1.48841462195256, 0.49548415590301);
        testCumulativeProbabilitySuccess(d, 3.01334185836417, -0.359266743471791, 2.28190123264877, 0.885951220188115); 
        testCumulativeProbabilitySuccess(d, 3.15326127711717, 0.291781923229408, 1.11200720870335, 0.961856629056837); 
        testCumulativeProbabilitySuccess(d, 3.15601733032704, 1.04163835890707, 2.47176216543221, 0.787446334763897); 
        testCumulativeProbabilitySuccess(d, 4.53501178327309, -2.56766860391698, 2.28573796326429, 0.977641252796277);
        testCumulativeProbabilitySuccess(d, Double.NEGATIVE_INFINITY, 0.0, 1.0, 0.0);
        testCumulativeProbabilitySuccess(d, 1.0, 1.0, 1.0, 0.5);
        testCumulativeProbabilitySuccess(d, Double.POSITIVE_INFINITY, 0.0, 1.0, 1.0);
        testCumulativeProbabilitySuccess(d, Double.NaN, 0.0, 1.0, Double.NaN);
    }
    
    private void testCumulativeProbabilitySuccess(LaplaceDistribution d, double x, double mean, double scale, double expected) throws NumericException {
        d.setMean(mean);
        d.setScale(scale);
    
        double actual = d.cumulativeProbability(x);
        assertRelativelyEquals(expected, actual, 1.0e-14);
    }
    
    public void testMean() {
        LaplaceDistribution d = new LaplaceDistribution();
        testMeanFailure(d, Double.NaN);
        testMeanSuccess(d, -1.0);
        testMeanSuccess(d, 0.0);
        testMeanSuccess(d, 1.0);
    }
    
    public void testScale() {
        LaplaceDistribution d = new LaplaceDistribution();
        testScaleFailure(d, Double.NaN);
        testScaleFailure(d, -1.0);
        testScaleFailure(d, 0.0);
        testScaleSuccess(d, 1.0);
    }

    private void testScaleFailure(LaplaceDistribution d, double scale) {
        try {
            d.setScale(scale);
            fail("Invalid scale.");
        } catch (IllegalArgumentException ex) {
            // success
        }
    }

    private void testScaleSuccess(LaplaceDistribution d, double scale) {
        try {
            d.setScale(scale);
            assertEquals(scale, d.getScale(), 0.0);
        } catch (IllegalArgumentException ex) {
            fail("Valid scale.");
        }
    }

    private void testMeanFailure(LaplaceDistribution d, double mean) {
        try {
            d.setMean(mean);
            fail("Invalid mean.");
        } catch (IllegalArgumentException ex) {
            // success
        }
    }

    private void testMeanSuccess(LaplaceDistribution d, double mean) {
        try {
            d.setMean(mean);
            assertEquals(mean, d.getMean(), 0.0);
        } catch (IllegalArgumentException ex) {
            fail("Valid mean.");
        }
    }
    }
