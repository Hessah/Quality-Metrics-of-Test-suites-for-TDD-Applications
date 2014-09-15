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

public class CauchyDistributionTest extends NumericTestCase {

    public void testConstructor() {
        testConstructorFailure(Double.NaN, 1.0);
        testConstructorSuccess(-1.0, 1.0);
        testConstructorSuccess(0.0, 1.0);
        testConstructorSuccess(1.0, 1.0);
        testConstructorFailure(0.0, Double.NaN);
        testConstructorFailure(0.0, -1.0);
        testConstructorFailure(0.0, 0.0);
    }
    
    private void testConstructorFailure(double median, double scale) {
        try {
            new CauchyDistribution(median, scale);
            fail("Invalid constructor values.");
        } catch (IllegalArgumentException ex) {
            // success
        }
    }
    
    private void testConstructorSuccess(double median, double scale) {
        try {
            CauchyDistribution d = new CauchyDistribution(median, scale);
            assertEquals(median, d.getMedian(), 0.0);
            assertEquals(scale, d.getScale(), 0.0);
        } catch (IllegalArgumentException ex) {
            fail("Valid constructor values.");
        }
    }
    
    public void testInverseCumulativeProbability() throws NumericException {
        CauchyDistribution d = new CauchyDistribution();
        testInverseCumulativeProbabilitySuccess(d, 0.109603191580378, 0.460990948849357, 0.24798531235913, -0.230518312470654); 
        testInverseCumulativeProbabilitySuccess(d, 0.343092695860498, -2.05620211666193, 2.9347828684621, -3.63267656873003); 
        testInverseCumulativeProbabilitySuccess(d, 0.411083450027078, 0.68381261654042, 1.97484227057403, 0.117349979146179);
        testInverseCumulativeProbabilitySuccess(d, 0.446293678961971, -2.37870035644048, 1.72542161431669, -2.67261363680866); 
        testInverseCumulativeProbabilitySuccess(d, 0.709943923061706, 2.0746557859056, 2.83903712576446, 4.27603773615518);
        testInverseCumulativeProbabilitySuccess(d, 0.742994454230716, -4.25842693847355, 2.87022994501239, -1.51183517663303); 
        testInverseCumulativeProbabilitySuccess(d, 0.769464219265177, 3.02118709993674, 1.20661146345066, 4.38518400200316); 
        testInverseCumulativeProbabilitySuccess(d, 0.789803109387972, 1.5315633827134, 0.525091428702761, 2.20764325174851); 
        testInverseCumulativeProbabilitySuccess(d, 0.82432832049246, 2.3965862929667, 0.708290365049829, 3.54695528994997);
        testInverseCumulativeProbabilitySuccess(d, 0.915286302627292, 2.50171014339815, 2.34874594287762, 11.1177197982713);
        testInverseCumulativeProbabilitySuccess(d, 0.0, 1.0, 1.0, Double.NEGATIVE_INFINITY);
        testInverseCumulativeProbabilitySuccess(d, 0.5, 1.0, 1.0, 1.0);
        testInverseCumulativeProbabilitySuccess(d, 1.0, 1.0, 1.0, Double.POSITIVE_INFINITY);
        testInverseCumulativeProbabilitySuccess(d, Double.NaN,  1.0, 1.0, Double.NaN);
        testInverseCumulativeProbabilitySuccess(d, -1.0,  1.0, 1.0, Double.NaN);
        testInverseCumulativeProbabilitySuccess(d, 2.0,  1.0, 1.0, Double.NaN);
    }
    
    private void testInverseCumulativeProbabilitySuccess(CauchyDistribution d, double p, double median, double scale, double expected) throws NumericException {
        d.setMedian(median);
        d.setScale(scale);
    
        double actual = d.inverseCumulativeProbability(p);
        assertRelativelyEquals(expected, actual, 1.0e-10);
    }

    public void testCumulativeProbability() throws NumericException {
        CauchyDistribution d = new CauchyDistribution();
        testCumulativeProbabilitySuccess(d, -2.26789567142583, 1.71424820730408, 0.996853419912297, 0.0780782374477473); 
        testCumulativeProbabilitySuccess(d, -2.08335058433055, -2.68844813682993, 0.038441456826194, 0.979805117975728); 
        testCumulativeProbabilitySuccess(d, -1.74721957866686, -1.92515518413297, 0.431685821204149, 0.624449202819811); 
        testCumulativeProbabilitySuccess(d, -1.16285779498899, -4.5213991805695, 2.14404451717883, 0.819146803126939);
        testCumulativeProbabilitySuccess(d, -0.763692913651974, -4.38001359325383, 2.56731900421656, 0.803489324551282);
        testCumulativeProbabilitySuccess(d, -0.206775920848895, 2.96993600975562, 0.635154052642291, 0.0628148125848262); 
        testCumulativeProbabilitySuccess(d, 0.681903714861793, -3.48086109371836, 0.851607024605756, 0.935767333335662); 
        testCumulativeProbabilitySuccess(d, 1.40253367985895, -1.80304449607267, 2.42783456431069, 0.79366950551322);
        testCumulativeProbabilitySuccess(d, 2.31594476605277, -0.191355101252356, 1.49705030414125, 0.828664217772023); 
        testCumulativeProbabilitySuccess(d, 2.94672222673885, -3.58437338592336, 0.147554465197656, 0.992809773578539);
        testCumulativeProbabilitySuccess(d, Double.NEGATIVE_INFINITY, 0.0, 1.0, 0.0);
        testCumulativeProbabilitySuccess(d, 1.0, 1.0, 1.0, 0.5);
        testCumulativeProbabilitySuccess(d, Double.POSITIVE_INFINITY, 0.0, 1.0, 1.0);
        testCumulativeProbabilitySuccess(d, Double.NaN, 0.0, 1.0, Double.NaN);
    }
    
    private void testCumulativeProbabilitySuccess(CauchyDistribution d, double x, double median, double scale, double expected) throws NumericException {
        d.setMedian(median);
        d.setScale(scale);
    
        double actual = d.cumulativeProbability(x);
        assertRelativelyEquals(expected, actual, 1.0e-10);
    }
    
    public void testMedian() {
        CauchyDistribution d = new CauchyDistribution();
        testMedianFailure(d, Double.NaN);
        testMedianSuccess(d, -1.0);
        testMedianSuccess(d, 0.0);
        testMedianSuccess(d, 1.0);
    }
    
    public void testScale() {
        CauchyDistribution d = new CauchyDistribution();
        testScaleFailure(d, Double.NaN);
        testScaleFailure(d, -1.0);
        testScaleFailure(d, 0.0);
        testScaleSuccess(d, 1.0);
    }

    private void testScaleFailure(CauchyDistribution d, double scale) {
        try {
            d.setScale(scale);
            fail("Invalid scale.");
        } catch (IllegalArgumentException ex) {
            // success
        }
    }

    private void testScaleSuccess(CauchyDistribution d, double scale) {
        try {
            d.setScale(scale);
            assertEquals(scale, d.getScale(), 0.0);
        } catch (IllegalArgumentException ex) {
            fail("Valid scale.");
        }
    }

    private void testMedianFailure(CauchyDistribution d, double median) {
        try {
            d.setMedian(median);
            fail("Invalid median.");
        } catch (IllegalArgumentException ex) {
            // success
        }
    }

    private void testMedianSuccess(CauchyDistribution d, double median) {
        try {
            d.setMedian(median);
            assertEquals(median, d.getMedian(), 0.0);
        } catch (IllegalArgumentException ex) {
            fail("Valid median.");
        }
    }
}
