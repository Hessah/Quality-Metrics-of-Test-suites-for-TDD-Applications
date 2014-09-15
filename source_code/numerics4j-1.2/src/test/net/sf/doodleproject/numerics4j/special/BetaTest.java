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
package net.sf.doodleproject.numerics4j.special;

import net.sf.doodleproject.numerics4j.NumericTestCase;
import net.sf.doodleproject.numerics4j.exception.NumericException;

public class BetaTest extends NumericTestCase {

    public void testRegularizedBeta() throws NumericException {
        testRegularizedBetaSuccess(0.128081585315241, 2.21404069288, 7.93405975147728, 0.265834907793674);
        testRegularizedBetaSuccess(0.151951987283813, 4.30271266092603, 0.898582322391601, 0.000243731249989457); 
        testRegularizedBetaSuccess(0.609265174559327, 6.33041781357296, 8.69199091179996, 0.929475503711192); 
        testRegularizedBetaSuccess(0.64971981227587, 4.81106516625307, 8.39146429185784, 0.982901899614317); 
        testRegularizedBetaSuccess(0.687194441901971, 5.03975012108193, 2.45233772463648, 0.496510286416675); 
        testRegularizedBetaSuccess(0.731698828632427, 7.13736678126979, 6.26459755361462, 0.935208370115631); 
        testRegularizedBetaSuccess(0.758486940699711, 7.48018903902659, 0.429545089922175, 0.0367539650418383); 
        testRegularizedBetaSuccess(0.842946586483206, 0.0308316303293133, 5.13110964056659, 0.999999448977749); 
        testRegularizedBetaSuccess(0.933434812379083, 1.48868824250882, 9.17160302035944, 0.999999999945834); 
        testRegularizedBetaSuccess(0.934246278200795, 3.35092004702808, 7.76381398862289, 0.999999960246638);
        testRegularizedBetaSuccess(Double.NaN, 1.0, 1.0, Double.NaN);
        testRegularizedBetaSuccess(-1.0, 1.0, 1.0, Double.NaN);
        testRegularizedBetaSuccess(0.0, 1.0, 1.0, 0.0);
        testRegularizedBetaSuccess(1.0, 1.0, 1.0, 1.0);
        testRegularizedBetaSuccess(2.0, 1.0, 1.0, Double.NaN);
        testRegularizedBetaSuccess(0.5, Double.NaN, 1.0, Double.NaN);
        testRegularizedBetaSuccess(0.5, -1.0, 1.0, Double.NaN);
        testRegularizedBetaSuccess(0.5, 0.0, 1.0, Double.NaN);
        testRegularizedBetaSuccess(0.5, 1.0, Double.NaN, Double.NaN);
        testRegularizedBetaSuccess(0.5, 1.0, -1.0, Double.NaN);
        testRegularizedBetaSuccess(0.5, 1.0, 0.0, Double.NaN);
    }
    
    public void testRegularizedBetaSuccess(double x, double a, double b, double expected) throws NumericException {
        double actual = Beta.regularizedBeta(x, a, b);
        assertRelativelyEquals(expected, actual, 1.0e-10);
    }
    
    public void testLogBeta() {
        testLogBetaSuccess(0.900835237199167, 4.28675332209954, -1.23535750018304); 
        testLogBetaSuccess(4.34087774355614, 1.26028117183755, -1.98642356314763);
        testLogBetaSuccess(4.50331530214351, 0.682958079645089, -0.721973462923632); 
        testLogBetaSuccess(5.90144445238951, 6.63262396629364, -8.29703535108844); 
        testLogBetaSuccess(6.91061972313555, 9.97233650721099, -11.1920885331656); 
        testLogBetaSuccess(7.99903091510986, 3.36467129014254, -6.38800940690844); 
        testLogBetaSuccess(8.37179997370552, 5.42525349315594, -8.90386213213309); 
        testLogBetaSuccess(8.3799229497048, 3.25234135534842, -6.37140871968212);
        testLogBetaSuccess(8.68539626768308, 6.97312792019366, -10.5010511463192); 
        testLogBetaSuccess(9.00107498075703, 3.66627375808316, -7.15561303473862);
        testLogBetaSuccess(Double.NaN, 1.0, Double.NaN);
        testLogBetaSuccess(-1.0, 1.0, Double.NaN);
        testLogBetaSuccess(0.0, 1.0, Double.NaN);
        testLogBetaSuccess(1.0, Double.NaN, Double.NaN);
        testLogBetaSuccess(1.0, -1.0, Double.NaN);
        testLogBetaSuccess(1.0, 0.0, Double.NaN);
    }
    
    private void testLogBetaSuccess(double a, double b, double expected) {
        double actual = Beta.logBeta(a, b);
        assertRelativelyEquals(expected, actual, 1.0e-10);
    }
}
