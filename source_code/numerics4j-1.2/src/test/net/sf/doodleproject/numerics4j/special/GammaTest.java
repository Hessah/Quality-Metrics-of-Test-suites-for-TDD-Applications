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

public class GammaTest extends NumericTestCase {
    
    public void testRegularizedGammaP() throws NumericException {
        testRegularizedGammaPSuccess(0.5087138393639705, 5.305657764452764,  0.998838553931562);
        testRegularizedGammaPSuccess(0.852897526802777,  2.865635330606549,  0.957748317945175);
        testRegularizedGammaPSuccess(2.24562152068159,   3.36338077480359,   0.806656692003562);
        testRegularizedGammaPSuccess(2.310664984136134,  0.1191666862297427, 0.002487944994707823); 
        testRegularizedGammaPSuccess(2.327100938915248,  8.37419015498993,   0.996198929887187);
        testRegularizedGammaPSuccess(2.530424967903314,  4.018296680343976,  0.84128678109217);
        testRegularizedGammaPSuccess(2.848039311236698,  7.489435201415931,  0.983154614617304);
        testRegularizedGammaPSuccess(3.723708034314852,  0.7403452757368534, 0.01150098844754242); 
        testRegularizedGammaPSuccess(3.797799460938393,  9.65870959545519,   0.989525305002402); 
        testRegularizedGammaPSuccess(4.558018857541478,  5.469152697308778,  0.7108001474337225);
        testRegularizedGammaPSuccess(Double.NaN, 5.0, Double.NaN);
        testRegularizedGammaPSuccess(-1.0, 5.0, Double.NaN);
        testRegularizedGammaPSuccess(0.0, 5.0, Double.NaN);
        testRegularizedGammaPSuccess(1.0, Double.NaN, Double.NaN);
        testRegularizedGammaPSuccess(1.0, -1.0, Double.NaN);
        testRegularizedGammaPSuccess(1.0, 0.0, 0.0);
    }
    
    private void testRegularizedGammaPSuccess(double a, double x, double expected) throws NumericException {
        double actual = Gamma.regularizedGammaP(a, x);
        assertRelativelyEquals(expected, actual, 1.0e-10);
    }
    
    public void testRegularizedGammaQ() throws NumericException {
        testRegularizedGammaQSuccess(2.64615374654298, 5.44059710007784, 0.0636314479718894); 
        testRegularizedGammaQSuccess(5.2187198803871, 7.47673291276108, 0.154904332130128);
        testRegularizedGammaQSuccess(5.25552576699027, 3.82487476915053, 0.706194624966418); 
        testRegularizedGammaQSuccess(5.3907157494177, 4.99643017142, 0.511615779988848);
        testRegularizedGammaQSuccess(6.90750067673135, 6.0044602811872, 0.591408627638123);
        testRegularizedGammaQSuccess(7.34389089409345, 8.19721234963564, 0.335163437245351); 
        testRegularizedGammaQSuccess(8.03335800397652, 1.0234555613573, 0.999988743742085); 
        testRegularizedGammaQSuccess(8.05868861310087, 8.8595531162519, 0.348232322592556);
        testRegularizedGammaQSuccess(8.75839656437115, 0.612728302175181, 0.999999962515479); 
        testRegularizedGammaQSuccess(8.8826598214881, 9.21472359825507, 0.412216508842807);
        testRegularizedGammaQSuccess(Double.NaN, 5.0, Double.NaN);
        testRegularizedGammaQSuccess(-1.0, 5.0, Double.NaN);
        testRegularizedGammaQSuccess(0.0, 5.0, Double.NaN);
        testRegularizedGammaQSuccess(1.0, Double.NaN, Double.NaN);
        testRegularizedGammaQSuccess(1.0, -1.0, Double.NaN);
        testRegularizedGammaQSuccess(1.0, 0.0, 1.0);
    }
    
    private void testRegularizedGammaQSuccess(double a, double x, double expected) throws NumericException {
        double actual = Gamma.regularizedGammaQ(a, x);
        assertRelativelyEquals(expected, actual, 1.0e-10);
    }

    public void testLogGamma() {
        testLogGammaSuccess(3.77412649817723, 1.51543471623015); 
        testLogGammaSuccess(4.38370186924482, 2.29391188640506); 
        testLogGammaSuccess(4.73660900416446, 2.78918615580516); 
        testLogGammaSuccess(4.88178891680985, 3.00157400680747); 
        testLogGammaSuccess(6.23650607494512, 5.1959993046656);
        testLogGammaSuccess(6.336060058899, 5.3708873774709);
        testLogGammaSuccess(6.63231918504655, 5.90124377430703); 
        testLogGammaSuccess(8.04334502647185, 8.6126542230766);
        testLogGammaSuccess(8.26200931450601, 9.05779590116424); 
        testLogGammaSuccess(9.13453435095002, 10.8936506143982);
        testLogGammaSuccess(-1.0, Double.NaN);
        testLogGammaSuccess(0.0, Double.NaN);
        testLogGammaSuccess(Double.NaN, Double.NaN);
    }
    
    private void testLogGammaSuccess(double x, double expected) {
        double actual = Gamma.logGamma(x);
        assertRelativelyEquals(expected, actual, 1.0e-10);
    }
}
