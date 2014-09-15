/*
 * Copyright (c) 2004-2005, DoodleProject
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

public class GammaDistributionTest extends NumericTestCase {

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
            new GammaDistribution(alpha, beta);
            fail("Invalid constructor values.");
        } catch (IllegalArgumentException ex) {
            // success
        }
    }
    
    private void testConstructorSuccess(double alpha, double beta) {
        try {
            GammaDistribution d = new GammaDistribution(alpha, beta);
            assertEquals(alpha, d.getAlpha(), 0.0);
            assertEquals(beta, d.getBeta(), 0.0);
        } catch (IllegalArgumentException ex) {
            fail("Valid constructor values.");
        }
    }
    
    public void testCumulativeProbability() throws NumericException {
        GammaDistribution d = new GammaDistribution();
        testCumulativeProbabilitySuccess(d, 0.0305310516087268, 1.37972778912648, 0.959524981686095, 0.00688079744364483); 
        testCumulativeProbabilitySuccess(d, 0.508676640137489, 2.41134753388183, 1.74128149223179, 0.0138944694473523); 
        testCumulativeProbabilitySuccess(d, 0.979332810455055, 1.97359300490484, 1.44519170188691, 0.153601766025975);
        testCumulativeProbabilitySuccess(d, 1.39224862361645, 0.877085382997285, 0.346514489444894, 0.986404708256613); 
        testCumulativeProbabilitySuccess(d, 1.43226670165041, 1.42800935916783, 0.648149361688986, 0.798017488600489); 
        testCumulativeProbabilitySuccess(d, 1.81216121795583, 0.660679854100038, 1.68644853197027, 0.796808415052706); 
        testCumulativeProbabilitySuccess(d, 2.36029414991429, 2.89104925874919, 1.0191826367226, 0.435242752550186);
        testCumulativeProbabilitySuccess(d, 2.3809873423175, 2.91195732153601, 0.598029596194154, 0.774760187472746); 
        testCumulativeProbabilitySuccess(d, 2.47521319817065, 1.48320876691701, 2.54453476930429, 0.422515534595972); 
        testCumulativeProbabilitySuccess(d, 2.8030065802852, 1.61721223291675, 0.867461821787099, 0.893154088248128);
        testCumulativeProbabilitySuccess(d, Double.NaN, 1.0, 1.0, Double.NaN);
        testCumulativeProbabilitySuccess(d, -1.0, 1.0, 1.0, 0.0);
        testCumulativeProbabilitySuccess(d, 0.0, 1.0, 1.0, 0.0);
        testCumulativeProbabilitySuccess(d, Double.POSITIVE_INFINITY, 1.0, 1.0, 1.0);
    }
    
    private void testCumulativeProbabilitySuccess(GammaDistribution d, double x, double alpha, double beta, double expected) throws NumericException {
        d.setAlpha(alpha);
        d.setBeta(beta);
    
        double actual = d.cumulativeProbability(x);
        assertRelativelyEquals(expected, actual, 1.0e-10);
    }
    
    public void testAlpha() {
        GammaDistribution d = new GammaDistribution();
        testAlphaFailure(d, Double.NaN);
        testAlphaFailure(d, -1.0);
        testAlphaFailure(d, 0.0);
        testAlphaSuccess(d, 1.0);
    }
    
    public void testBeta() {
        GammaDistribution d = new GammaDistribution();
        testBetaFailure(d, Double.NaN);
        testBetaFailure(d, -1.0);
        testBetaFailure(d, 0.0);
        testBetaSuccess(d, 1.0);
    }

    private void testBetaFailure(GammaDistribution d, double beta) {
        try {
            d.setBeta(beta);
            fail("Invalid beta.");
        } catch (IllegalArgumentException ex) {
            // success
        }
    }

    private void testBetaSuccess(GammaDistribution d, double beta) {
        try {
            d.setBeta(beta);
            assertEquals(beta, d.getBeta(), 0.0);
        } catch (IllegalArgumentException ex) {
            fail("Valid beta.");
        }
    }

    private void testAlphaFailure(GammaDistribution d, double alpha) {
        try {
            d.setAlpha(alpha);
            fail("Invalid alpha.");
        } catch (IllegalArgumentException ex) {
            // success
        }
    }

    private void testAlphaSuccess(GammaDistribution d, double alpha) {
        try {
            d.setAlpha(alpha);
            assertEquals(alpha, d.getAlpha(), 0.0);
        } catch (IllegalArgumentException ex) {
            fail("Valid alpha.");
        }
    }
    
    public void testInverseCumulativeProbability() throws NumericException {
        GammaDistribution d = new GammaDistribution();
        testInverseCumulativeProbabilitySuccess(d, 0.00690969577277472, 5.62923581591936, 7.00045128027236, 10.2458303645405);
        testInverseCumulativeProbabilitySuccess(d, 0.00803214368551496, 6.99473407229226, 4.00972093600293, 8.93745787771901); 
        testInverseCumulativeProbabilitySuccess(d, 0.0592052344453365, 1.28800619769547, 2.27107430332343, 0.300298760473685);
        testInverseCumulativeProbabilitySuccess(d, 0.0839601303928541, 1.99024034024726, 4.43793840531368, 2.10563733933315); 
        testInverseCumulativeProbabilitySuccess(d, 0.1167929118698, 6.11830392378173, 1.07691610109378, 3.64665453355277);
        testInverseCumulativeProbabilitySuccess(d, 0.284179181730492, 0.110553996334224, 6.84752514861457, 0.0000478533343112333);
        testInverseCumulativeProbabilitySuccess(d, 0.622885792011596, 7.92444124970834, 5.00457853075169, 42.4693728011879); 
        testInverseCumulativeProbabilitySuccess(d, 0.62336643293765, 0.245485996792482, 6.98341430530081, 0.745505871363156);
        testInverseCumulativeProbabilitySuccess(d, 0.70365803964374, 1.92043490623631, 2.14121245400787, 5.0547056152343); 
        testInverseCumulativeProbabilitySuccess(d, 0.877091420137519, 2.59630582051244, 3.12713969103342, 13.975748684015);
        testInverseCumulativeProbabilitySuccess(d, -1.0,  1.0, 1.0, Double.NaN);
        testInverseCumulativeProbabilitySuccess(d, 0.0, 1.0, 1.0, 0.0);
        testInverseCumulativeProbabilitySuccess(d, 1.0, 1.0, 1.0, Double.POSITIVE_INFINITY);
        testInverseCumulativeProbabilitySuccess(d, 2.0,  1.0, 1.0, Double.NaN);
        testInverseCumulativeProbabilitySuccess(d, Double.NaN,  1.0, 1.0, Double.NaN);
    }
    
    private void testInverseCumulativeProbabilitySuccess(GammaDistribution d, double p, double alpha, double beta, double expected) throws NumericException {
        d.setAlpha(alpha);
        d.setBeta(beta);
    
        double actual = d.inverseCumulativeProbability(p);
        assertRelativelyEquals(expected, actual, 1.0e-10);
    }
}
