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

public class BetaDistributionTest extends NumericTestCase {

    public void testConstructor() {
        testConstructorFailure(Double.NaN, 1.0);
        testConstructorFailure(-1.0, 1.0);
        testConstructorFailure(0.0, 1.0);
        testConstructorSuccess(1.0, 1.0);
        testConstructorFailure(0.0, Double.NaN);
        testConstructorFailure(0.0, -1.0);
        testConstructorFailure(0.0, 0.0);
    }
    
    private void testConstructorFailure(double alpha, double beta) {
        try {
            new BetaDistribution(alpha, beta);
            fail("Invalid constructor values.");
        } catch (IllegalArgumentException ex) {
            // success
        }
    }
    
    private void testConstructorSuccess(double alpha, double beta) {
        try {
            BetaDistribution d = new BetaDistribution(alpha, beta);
            assertEquals(alpha, d.getAlpha(), 0.0);
            assertEquals(beta, d.getBeta(), 0.0);
        } catch (IllegalArgumentException ex) {
            fail("Valid constructor values.");
        }
    }
    
    public void testInverseCumulativeProbability() throws NumericException {
        BetaDistribution d = new BetaDistribution();
        testInverseCumulativeProbabilitySuccess(d, 0.0173041044161243, 2.32105201058652,  5.32246739130766, 0.0481444195773413);
        testInverseCumulativeProbabilitySuccess(d, 0.325515142328873,  4.73985850257449,  3.7289934820417,  0.48463462488469);
        testInverseCumulativeProbabilitySuccess(d, 0.329777580695219,  7.24645831673735,  8.20520942835152, 0.411243174911182);
        testInverseCumulativeProbabilitySuccess(d, 0.330116243610706,  4.15476531478376,  3.76418971213202, 0.446407579029491); 
        testInverseCumulativeProbabilitySuccess(d, 0.455102122794986,  6.00869310655139,  6.53464907422297, 0.461679606602562);
        testInverseCumulativeProbabilitySuccess(d, 0.476343688302511,  1.68184255220119,  3.07458536689954, 0.318318977733686); 
        testInverseCumulativeProbabilitySuccess(d, 0.525969362151353,  8.51341812103313,  7.84879703490206, 0.529321120315483);
        testInverseCumulativeProbabilitySuccess(d, 0.755378221216321,  0.150252196023197, 8.18642834408223, 0.0136366993802526); 
        testInverseCumulativeProbabilitySuccess(d, 0.87611998806534,   1.90580219416357,  3.38221400125351, 0.602718498483703);
        testInverseCumulativeProbabilitySuccess(d, 0.981943394361081,  0.519835118939037, 4.78442463899142, 0.464635189510949);
        testInverseCumulativeProbabilitySuccess(d, 0.0,  1.0, 1.0, 0.0);
        testInverseCumulativeProbabilitySuccess(d, 1.0,  1.0, 1.0, 1.0);
        testInverseCumulativeProbabilitySuccess(d, Double.NaN,  1.0, 1.0, Double.NaN);
        testInverseCumulativeProbabilitySuccess(d, -1.0,  1.0, 1.0, Double.NaN);
        testInverseCumulativeProbabilitySuccess(d, 2.0,  1.0, 1.0, Double.NaN);
    }
    
    private void testInverseCumulativeProbabilitySuccess(BetaDistribution d, double p, double alpha, double beta, double expected) throws NumericException {
        d.setAlpha(alpha);
        d.setBeta(beta);
    
        double actual = d.inverseCumulativeProbability(p);
        assertRelativelyEquals(expected, actual, 1.0e-10);
    }

    public void testCumulativeProbability() throws NumericException {
        BetaDistribution d = new BetaDistribution();
        testCumulativeProbabilitySuccess(d, 0.110094134463049, 3.37702621482959, 0.343482023038851, 0.000103130124959682); 
        testCumulativeProbabilitySuccess(d, 0.122177501074424, 0.400303922606712, 3.51558949072195, 0.711870673222429);
        testCumulativeProbabilitySuccess(d, 0.405916240048495, 0.0348173240506738, 1.46772444917487, 0.981850398994756); 
        testCumulativeProbabilitySuccess(d, 0.559998836050256, 3.15614695480253, 2.0657435231204, 0.397729761619099);
        testCumulativeProbabilitySuccess(d, 0.616932803943868, 3.42343346694049, 1.21183771913155, 0.244131401003776);
        testCumulativeProbabilitySuccess(d, 0.644491177829056, 0.468737278593673, 1.24238586258789, 0.866345319021733); 
        testCumulativeProbabilitySuccess(d, 0.682368707776053, 1.81120647221372, 3.09648424887615, 0.924293411430234);
        testCumulativeProbabilitySuccess(d, 0.800758929921276, 0.597223317567202, 3.87982976964388, 0.999229502958237); 
        testCumulativeProbabilitySuccess(d, 0.947149658748988, 4.47801945011866, 4.85802364540425, 0.999958068937745);
        testCumulativeProbabilitySuccess(d, 0.993470685403249, 0.162227771996546, 2.58005187255772, 0.999999822465349);
        testCumulativeProbabilitySuccess(d, Double.NaN, 1.0, 1.0, Double.NaN);
        testCumulativeProbabilitySuccess(d, -1.0, 1.0, 1.0, 0.0);
        testCumulativeProbabilitySuccess(d, 0.0, 1.0, 1.0, 0.0);
        testCumulativeProbabilitySuccess(d, 1.0, 1.0, 1.0, 1.0);
        testCumulativeProbabilitySuccess(d, 2.0, 1.0, 1.0, 1.0);
    }
    
    private void testCumulativeProbabilitySuccess(BetaDistribution d, double x, double alpha, double beta, double expected) throws NumericException {
        d.setAlpha(alpha);
        d.setBeta(beta);
    
        double actual = d.cumulativeProbability(x);
        assertRelativelyEquals(expected, actual, 1.0e-10);
    }
    
    public void testAlpha() {
        BetaDistribution d = new BetaDistribution();
        testAlphaFailure(d, Double.NaN);
        testAlphaFailure(d, -1.0);
        testAlphaFailure(d, 0.0);
        testAlphaSuccess(d, 1.0);
    }
    
    public void testBeta() {
        BetaDistribution d = new BetaDistribution();
        testBetaFailure(d, Double.NaN);
        testBetaFailure(d, -1.0);
        testBetaFailure(d, 0.0);
        testBetaSuccess(d, 1.0);
    }

    private void testBetaFailure(BetaDistribution d, double beta) {
        try {
            d.setBeta(beta);
            fail("Invalid beta.");
        } catch (IllegalArgumentException ex) {
            // success
        }
    }

    private void testBetaSuccess(BetaDistribution d, double beta) {
        try {
            d.setBeta(beta);
            assertEquals(beta, d.getBeta(), 0.0);
        } catch (IllegalArgumentException ex) {
            fail("Valid beta.");
        }
    }

    private void testAlphaFailure(BetaDistribution d, double alpha) {
        try {
            d.setAlpha(alpha);
            fail("Invalid alpha.");
        } catch (IllegalArgumentException ex) {
            // success
        }
    }

    private void testAlphaSuccess(BetaDistribution d, double alpha) {
        try {
            d.setAlpha(alpha);
            assertEquals(alpha, d.getAlpha(), 0.0);
        } catch (IllegalArgumentException ex) {
            fail("Valid alpha.");
        }
    }
}
