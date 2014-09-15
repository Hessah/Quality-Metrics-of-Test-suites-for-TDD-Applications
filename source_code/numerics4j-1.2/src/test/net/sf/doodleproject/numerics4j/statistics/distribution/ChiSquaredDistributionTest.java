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
 * @version $Revision: 1.8 $ $Date: 2004/08/29 03:14:33 $
 */
public class ChiSquaredDistributionTest extends NumericTestCase {

    public void testConstructor() {
        testConstructorFailure(Double.NaN);
        testConstructorFailure(-1.0);
        testConstructorFailure(0.0);
        testConstructorSuccess(1.0);
    }
    
    private void testConstructorFailure(double df) {
        try {
            new ChiSquaredDistribution(df);
            fail("Invalid constructor values.");
        } catch (IllegalArgumentException ex) {
            // success
        }
    }
    
    private void testConstructorSuccess(double df) {
        try {
            ChiSquaredDistribution c = new ChiSquaredDistribution(df);
            assertEquals(df, c.getDegreesOfFreedom(), 0.0);
        } catch (IllegalArgumentException ex) {
            fail("Valid constructor values.");
        }
    }
    
    public void testInverseCumulativeProbability() throws NumericException {
        ChiSquaredDistribution d = new ChiSquaredDistribution();
        testInverseCumulativeProbabilitySuccess(d, 0.0281315430831787, 5.74915207542907, 1.18627532865574); 
        testInverseCumulativeProbabilitySuccess(d, 0.111882546216028, 1.12145735112401, 0.0330112672516439); 
        testInverseCumulativeProbabilitySuccess(d, 0.384964689069679, 2.87914125409447, 1.69683080002959);
        testInverseCumulativeProbabilitySuccess(d, 0.429453685338204, 4.56561923258922, 3.44917742599092); 
        testInverseCumulativeProbabilitySuccess(d, 0.442487961699935, 9.445675260033, 8.19922659261559);
        testInverseCumulativeProbabilitySuccess(d, 0.559691101609897, 8.42821694835925, 8.3745692288459); 
        testInverseCumulativeProbabilitySuccess(d, 0.579912967039238, 5.28348411108464, 5.26730920503512); 
        testInverseCumulativeProbabilitySuccess(d, 0.798384200496276, 9.70420942617087, 13.0571793484648); 
        testInverseCumulativeProbabilitySuccess(d, 0.823683098052095, 7.4835926687735, 10.8293789697278);
        testInverseCumulativeProbabilitySuccess(d, 0.859415417729917, 1.80519600179266, 3.60495068277546);
        testInverseCumulativeProbabilitySuccess(d, -1.0,  1.0, Double.NaN);
        testInverseCumulativeProbabilitySuccess(d, 0.0, 1.0, 0.0);
        testInverseCumulativeProbabilitySuccess(d, 1.0, 1.0, Double.POSITIVE_INFINITY);
        testInverseCumulativeProbabilitySuccess(d, 2.0,  1.0, Double.NaN);
        testInverseCumulativeProbabilitySuccess(d, Double.NaN,  1.0, Double.NaN);
    }
    
    private void testInverseCumulativeProbabilitySuccess(ChiSquaredDistribution d, double p, double df, double expected) throws NumericException {
        d.setDegreesOfFreedom(df);
    
        double actual = d.inverseCumulativeProbability(p);
        assertRelativelyEquals(expected, actual, 1.0e-10);
    }
    
    public void testCumulativeProbability() throws NumericException {
        ChiSquaredDistribution d = new ChiSquaredDistribution();
        testCumulativeProbabilitySuccess(d, 1.714310279296882, 6.458901327665999, 0.0397057484336155);
        testCumulativeProbabilitySuccess(d, 2.668540043927866, 6.585911241498980, 0.1093621243952067); 
        testCumulativeProbabilitySuccess(d, 4.479842159409987, 1.488383971056973, 0.9353192388956070); 
        testCumulativeProbabilitySuccess(d, 4.549383721059684, 1.024460662384594, 0.9658173161435070); 
        testCumulativeProbabilitySuccess(d, 5.058053044933789, 3.319159018948410, 0.7983887989861623); 
        testCumulativeProbabilitySuccess(d, 6.240574836940490, 6.798017846567968, 0.5110070616488192); 
        testCumulativeProbabilitySuccess(d, 6.856093863316644, 8.540044017071950, 0.3924410819349338); 
        testCumulativeProbabilitySuccess(d, 8.190033748871050, 3.010630814115636, 0.9573983968232830); 
        testCumulativeProbabilitySuccess(d, 8.631106101298820, 1.172527568304890, 0.9955640001642520);
        testCumulativeProbabilitySuccess(d, 8.859415153043210, 8.412574497841120, 0.6063150218267455);
        testCumulativeProbabilitySuccess(d, Double.NaN, 1.0, Double.NaN);
        testCumulativeProbabilitySuccess(d, -1.0, 1.0, 0.0);
        testCumulativeProbabilitySuccess(d, 0.0, 1.0, 0.0);
        testCumulativeProbabilitySuccess(d, Double.POSITIVE_INFINITY, 1.0, 1.0);
    }
    
    private void testCumulativeProbabilitySuccess(ChiSquaredDistribution d, double x, double df, double p) throws NumericException {
        d.setDegreesOfFreedom(df);
    
        double actual = d.cumulativeProbability(x);
        assertRelativelyEquals(p, actual, 1.0e-10);
    }
    
    public void testDegreesOfFreedom() {
        ChiSquaredDistribution d = new ChiSquaredDistribution();
        testDegreesOfFreedomFailure(d, Double.NaN);
        testDegreesOfFreedomFailure(d, -1.0);
        testDegreesOfFreedomFailure(d, 0.0);
        testDegreesOfFreedomSuccess(d, 1.0);
    }

    private void testDegreesOfFreedomFailure(ChiSquaredDistribution d, double df) {
        try {
            d.setDegreesOfFreedom(df);
            fail("Invalid degrees of freedom.");
        } catch (IllegalArgumentException ex) {
            // success
        }
    }

    private void testDegreesOfFreedomSuccess(ChiSquaredDistribution d, double df) {
        try {
            d.setDegreesOfFreedom(df);
            assertEquals(df, d.getDegreesOfFreedom(), 0.0);
        } catch (IllegalArgumentException ex) {
            fail("Valid degrees of freedom.");
        }
    }
}
