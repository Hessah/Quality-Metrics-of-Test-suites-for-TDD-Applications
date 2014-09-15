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

/**
 * @version $Revision: 1.3 $ $Date: 2005/06/24 15:39:16 $
 */
public class TDistributionTest extends NumericTestCase {

    public void testConstructor() {
        testConstructorFailure(Double.NaN);
        testConstructorFailure(-1.0);
        testConstructorFailure(0.0);
        testConstructorSuccess(1.0);
    }
    
    private void testConstructorFailure(double df) {
        try {
            new TDistribution(df);
            fail("Invalid constructor values.");
        } catch (IllegalArgumentException ex) {
            // success
        }
    }
    
    private void testConstructorSuccess(double df) {
        try {
            TDistribution c = new TDistribution(df);
            assertEquals(df, c.getDegreesOfFreedom(), 0.0);
        } catch (IllegalArgumentException ex) {
            fail("Valid constructor values.");
        }
    }
    
    public void testCumulativeProbability() throws NumericException {
        TDistribution d = new TDistribution();
        testCumulativeProbabilitySuccess(d, -1.75713367655859, 6.01095473792268, 0.064658604525827); 
        testCumulativeProbabilitySuccess(d, -1.6699530518211, 0.21318993068321, 0.331829048512905);
        testCumulativeProbabilitySuccess(d, -1.27486370958668, 7.03279887864183, 0.121428959400443);
        testCumulativeProbabilitySuccess(d, -0.918969387614193, 8.36480417711878, 0.191922774278109); 
        testCumulativeProbabilitySuccess(d, 1.70079866311403, 1.68042706752853, 0.872964140013452); 
        testCumulativeProbabilitySuccess(d, 2.18493761073913, 7.91339023708643, 0.969620151619884); 
        testCumulativeProbabilitySuccess(d, 2.40431974998152, 3.46781396056708, 0.958058429109669); 
        testCumulativeProbabilitySuccess(d, 2.76087076249611, 6.34884438620239, 0.984518796429036); 
        testCumulativeProbabilitySuccess(d, 2.81914336504045, 6.84785218914985, 0.986798579003063); 
        testCumulativeProbabilitySuccess(d, 2.87573444009899, 9.53806589299288, 0.991359251105572);
        testCumulativeProbabilitySuccess(d, Double.NaN, 1.0, Double.NaN);
        testCumulativeProbabilitySuccess(d, Double.NEGATIVE_INFINITY, 1.0, 0.0);
        testCumulativeProbabilitySuccess(d, 0.0, 1.0, 0.5);
        testCumulativeProbabilitySuccess(d, Double.POSITIVE_INFINITY, 1.0, 1.0);
    }
    
    private void testCumulativeProbabilitySuccess(TDistribution d, double x, double df, double p) throws NumericException {
        d.setDegreesOfFreedom(df);
    
        double actual = d.cumulativeProbability(x);
        assertRelativelyEquals(p, actual, 1.0e-10);
    }
    
    public void testDegreesOfFreedom() {
        TDistribution d = new TDistribution();
        testDegreesOfFreedomFailure(d, Double.NaN);
        testDegreesOfFreedomFailure(d, -1.0);
        testDegreesOfFreedomFailure(d, 0.0);
        testDegreesOfFreedomSuccess(d, 1.0);
    }

    private void testDegreesOfFreedomFailure(TDistribution d, double df) {
        try {
            d.setDegreesOfFreedom(df);
            fail("Invalid degrees of freedom.");
        } catch (IllegalArgumentException ex) {
            // success
        }
    }

    private void testDegreesOfFreedomSuccess(TDistribution d, double df) {
        try {
            d.setDegreesOfFreedom(df);
            assertEquals(df, d.getDegreesOfFreedom(), 0.0);
        } catch (IllegalArgumentException ex) {
            fail("Valid degrees of freedom.");
        }
    }
    
    public void testInverseCumulativeProbability() throws NumericException {
        TDistribution d = new TDistribution();
        testInverseCumulativeProbabilitySuccess(d, 0.1210998307604, 9.81971932238251, -1.24449839973111);
        testInverseCumulativeProbabilitySuccess(d, 0.124882437339962, 7.56356080711969, -1.24659985132956); 
        testInverseCumulativeProbabilitySuccess(d, 0.142181686533736, 6.69415444228903, -1.16363853840063); 
        testInverseCumulativeProbabilitySuccess(d, 0.179180456904038, 7.9582108254354, -0.974786623239565);
        testInverseCumulativeProbabilitySuccess(d, 0.256435805649304, 0.223356562649871, -5.07127788823572); 
        testInverseCumulativeProbabilitySuccess(d, 0.533951027202651, 0.530471993447585, 0.124735090347712); 
        testInverseCumulativeProbabilitySuccess(d, 0.641933955444217, 3.11777014297183, 0.398289700686817); 
        testInverseCumulativeProbabilitySuccess(d, 0.857123017457806, 6.66251027230888, 1.16044667681502); 
        testInverseCumulativeProbabilitySuccess(d, 0.924300447179368, 2.63136902486481, 2.00467657066824); 
        testInverseCumulativeProbabilitySuccess(d, 0.945307519243488, 5.11863497173841, 1.9354009229415);
        testInverseCumulativeProbabilitySuccess(d, -1.0,  1.0, Double.NaN);
        testInverseCumulativeProbabilitySuccess(d, 0.0, 1.0, Double.NEGATIVE_INFINITY);
        testInverseCumulativeProbabilitySuccess(d, 1.0, 1.0, Double.POSITIVE_INFINITY);
        testInverseCumulativeProbabilitySuccess(d, 2.0,  1.0, Double.NaN);
        testInverseCumulativeProbabilitySuccess(d, Double.NaN,  1.0, Double.NaN);
    }
    
    private void testInverseCumulativeProbabilitySuccess(TDistribution d, double p, double df, double expected) throws NumericException {
        d.setDegreesOfFreedom(df);
    
        double actual = d.inverseCumulativeProbability(p);
        assertRelativelyEquals(expected, actual, 1.0e-10);
    }
}
