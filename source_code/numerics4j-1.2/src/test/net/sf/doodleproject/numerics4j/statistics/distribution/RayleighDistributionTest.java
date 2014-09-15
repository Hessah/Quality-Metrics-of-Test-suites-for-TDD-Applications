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

public class RayleighDistributionTest extends NumericTestCase {

    public void testConstructor() {
        testConstructorSuccess(1.0);
        testConstructorFailure(Double.NaN);
        testConstructorFailure(-1.0);
        testConstructorFailure(0.0);
    }
    
    private void testConstructorFailure(double scale) {
        try {
            new RayleighDistribution(scale);
            fail("Invalid constructor values.");
        } catch (IllegalArgumentException ex) {
            // success
        }
    }
    
    private void testConstructorSuccess(double scale) {
        try {
            RayleighDistribution d = new RayleighDistribution(scale);
            assertEquals(scale, d.getScale(), 0.0);
        } catch (IllegalArgumentException ex) {
            fail("Valid constructor values.");
        }
    }
    
    public void testInverseCumulativeProbability() throws NumericException {
        RayleighDistribution d = new RayleighDistribution();
        testInverseCumulativeProbabilitySuccess(d, 0.182265246129643, 3.29780835259369, 2.0920546409322); 
        testInverseCumulativeProbabilitySuccess(d, 0.38900937893634, 2.20891403435152, 2.19267108115885);
        testInverseCumulativeProbabilitySuccess(d, 0.428349918392474, 3.06731163113827, 3.24389985868383); 
        testInverseCumulativeProbabilitySuccess(d, 0.460408614220256, 2.1659351609688, 2.40593013402546);
        testInverseCumulativeProbabilitySuccess(d, 0.494482864771106, 3.85024936555811, 4.49729347002263); 
        testInverseCumulativeProbabilitySuccess(d, 0.625425554367585, 2.03189470913756, 2.84750265213535); 
        testInverseCumulativeProbabilitySuccess(d, 0.689554952584965, 3.53336322547289, 5.40442516611163); 
        testInverseCumulativeProbabilitySuccess(d, 0.725017900470562, 3.49073545525574, 5.6092312411311);
        testInverseCumulativeProbabilitySuccess(d, 0.881659185949648, 4.20852146566471, 8.69482279089254); 
        testInverseCumulativeProbabilitySuccess(d, 0.937800493057936, 4.69809304150537, 11.0727748279781);
        testInverseCumulativeProbabilitySuccess(d, 0.0, 1.0, 0.0);
        testInverseCumulativeProbabilitySuccess(d, 1.0, 1.0, Double.POSITIVE_INFINITY);
        testInverseCumulativeProbabilitySuccess(d, Double.NaN,  1.0, Double.NaN);
        testInverseCumulativeProbabilitySuccess(d, -1.0,  1.0, Double.NaN);
        testInverseCumulativeProbabilitySuccess(d, 2.0,  1.0, Double.NaN);
    }
    
    private void testInverseCumulativeProbabilitySuccess(RayleighDistribution d, double p, double scale, double expected) throws NumericException {
        d.setScale(scale);
    
        double actual = d.inverseCumulativeProbability(p);
        assertRelativelyEquals(expected, actual, 1.0e-10);
    }

    public void testCumulativeProbability() throws NumericException {
        RayleighDistribution d = new RayleighDistribution();
        testCumulativeProbabilitySuccess(d, 1.92104233364683, 2.67515824019182, 0.227278679196732); 
        testCumulativeProbabilitySuccess(d, 3.36008521534221, 3.28182142090422, 0.407930957907776); 
        testCumulativeProbabilitySuccess(d, 4.43160308237942, 3.73408635654386, 0.50551761443426); 
        testCumulativeProbabilitySuccess(d, 4.68432919381773, 4.4310514200013, 0.428101278911674); 
        testCumulativeProbabilitySuccess(d, 5.09450574665462, 3.6307814103671, 0.626338595289235); 
        testCumulativeProbabilitySuccess(d, 5.2260812116232, 2.46784211946343, 0.893782696992251); 
        testCumulativeProbabilitySuccess(d, 6.12823678821457, 4.6417278998934, 0.581688437547356); 
        testCumulativeProbabilitySuccess(d, 7.21856631909387, 3.1318731916249, 0.929786669615276);
        testCumulativeProbabilitySuccess(d, 9.64537052114404, 2.04262777021715, 0.999985607912796); 
        testCumulativeProbabilitySuccess(d, 9.81638691839479, 2.10716296070231, 0.999980618336695);
        testCumulativeProbabilitySuccess(d, -1.0, 1.0, 0.0);
        testCumulativeProbabilitySuccess(d, 0.0, 1.0, 0.0);
        testCumulativeProbabilitySuccess(d, Double.POSITIVE_INFINITY, 1.0, 1.0);
        testCumulativeProbabilitySuccess(d, Double.NaN, 1.0, Double.NaN);
    }
    
    private void testCumulativeProbabilitySuccess(RayleighDistribution d, double x, double scale, double expected) throws NumericException {
        d.setScale(scale);
    
        double actual = d.cumulativeProbability(x);
        assertRelativelyEquals(expected, actual, 1.0e-10);
    }
    
    public void testScale() {
        RayleighDistribution d = new RayleighDistribution();
        testScaleFailure(d, Double.NaN);
        testScaleFailure(d, -1.0);
        testScaleFailure(d, 0.0);
        testScaleSuccess(d, 1.0);
    }

    private void testScaleFailure(RayleighDistribution d, double scale) {
        try {
            d.setScale(scale);
            fail("Invalid scale.");
        } catch (IllegalArgumentException ex) {
            // success
        }
    }

    private void testScaleSuccess(RayleighDistribution d, double scale) {
        try {
            d.setScale(scale);
            assertEquals(scale, d.getScale(), 0.0);
        } catch (IllegalArgumentException ex) {
            fail("Valid scale.");
        }
    }
}
