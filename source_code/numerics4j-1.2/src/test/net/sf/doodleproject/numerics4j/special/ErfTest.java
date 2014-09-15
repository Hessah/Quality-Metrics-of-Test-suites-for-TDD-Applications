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

public class ErfTest extends NumericTestCase {

    public void testErf() throws NumericException {
        testErfSuccess(-5.23772557599988,  -0.999999999999871);
        testErfSuccess(-4.702037183662,    -0.999999999970628);
        testErfSuccess(-4.269598197279637, -0.999999998440835);
        testErfSuccess(-3.449651934156366, -0.999998931284735);
        testErfSuccess(-2.983623530833467, -0.999975513449339);
        testErfSuccess(-1.834633774713653, -0.990528901197634);
        testErfSuccess(-1.639381270154122, -0.979574320545155);
        testErfSuccess(-0.889945218028979, -0.7918152499607719); 
        testErfSuccess(1.419747723529646,   0.955338266702449);
        testErfSuccess(5.822180576103501,   1.0);
        testErfSuccess(0.0, 0.0);
        testErfSuccess(Double.POSITIVE_INFINITY, 1.0);
        testErfSuccess(Double.NEGATIVE_INFINITY, -1.0);
        testErfSuccess(Double.NaN, Double.NaN);
    }

    private void testErfSuccess(double x, double expected) throws NumericException {
        double actual = Erf.erf(x);
        assertRelativelyEquals(expected, actual, 1e-10);

        actual = Erf.erf(-x);
        assertRelativelyEquals(-expected, actual, 1e-10);
    }

    private void testErfcSuccess(double x, double expected) throws NumericException {
        double actual = Erf.erfc(x);
        assertRelativelyEquals(expected, actual, 1e-10);
    }

    public void testErfc() throws NumericException {
        testErfcSuccess(-5.23772557599988,  1.999999999999871);
        testErfcSuccess(-4.702037183662,    1.999999999970628);
        testErfcSuccess(-4.269598197279637, 1.999999998440835);
        testErfcSuccess(-3.449651934156366, 1.999998931284735);
        testErfcSuccess(-2.983623530833467, 1.999975513449339);
        testErfcSuccess(-1.834633774713653, 1.990528901197634);
        testErfcSuccess(-1.639381270154122, 1.979574320545155);
        testErfcSuccess(-0.889945218028979, 1.7918152499607719); 
        testErfcSuccess(1.419747723529646,  0.044661733297551);
        testErfcSuccess(5.822180576103501,  0.0);
        testErfcSuccess(0.0, 1.0);
        testErfcSuccess(Double.POSITIVE_INFINITY, 0.0);
        testErfcSuccess(Double.NEGATIVE_INFINITY, 2.0);
        testErfcSuccess(Double.NaN, Double.NaN);
    }

    public void testInverseErf() throws NumericException {
        testInverseErfSuccess(0.0, 0.0);
        testInverseErfSuccess(1.0, Double.POSITIVE_INFINITY);
        testInverseErfSuccess(-1.0, Double.NEGATIVE_INFINITY);
        testInverseErfSuccess(Double.NaN, Double.NaN);
        testInverseErfSuccess(2.0, Double.NaN);
        testInverseErfSuccess(-2.0, Double.NaN);
    }

    private void testInverseErfSuccess(double y, double expected) throws NumericException {
        double actual = Erf.inverseErf(y);
        assertRelativelyEquals(expected, actual, 1e-10);

        actual = Erf.inverseErf(-y);
        assertRelativelyEquals(-expected, actual, 1e-10);
    }
}
