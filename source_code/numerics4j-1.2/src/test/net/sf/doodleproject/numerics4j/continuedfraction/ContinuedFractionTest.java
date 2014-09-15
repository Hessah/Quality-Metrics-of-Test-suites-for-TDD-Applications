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
package net.sf.doodleproject.numerics4j.continuedfraction;

import net.sf.doodleproject.numerics4j.IterativeMethod;
import net.sf.doodleproject.numerics4j.iterativeMethTest;
import net.sf.doodleproject.numerics4j.exception.NumericException;

public class ContinuedFractionTest extends iterativeMethTest {

    protected IterativeMethod createIterativeMethod() {
        return exponential;
    }
    
    private ContinuedFraction exponential = new ContinuedFraction() {
        public double getA(int n, double x) {
            if (n == 0) {
                return 1.0;
            } else if (n % 2 == 0) { // even
                return 2.0;
            } else { // odd
                return n;
            }
        }
        
        public double getB(int n, double x) {
            if (n % 2 == 0) { // even
                return x;
            } else { // odd
                return -x;
            }
        }
    };

    public void testGoldenRatio() throws NumericException {
        ContinuedFraction goldenRatio = new ContinuedFraction() {
            public double getA(int n, double x) {
                return 1.0;
            }

            public double getB(int n, double x) {
                return 1.0;
            }
        };
        assertRelativelyEquals(1.6180339887499, goldenRatio.evaluate(0.0), 1.0e-10);
    }

    public void testE() throws NumericException {
        ContinuedFraction e = new ContinuedFraction() {
            public double getA(int n, double x) {
                return n + 1.0;
            }

            public double getB(int n, double x) {
                return n;
            }
        };
        assertRelativelyEquals(Math.E, 2.0 + 1.0 / e.evaluate(0.0), 1.0e-10);
    }
    
    public void testExponential() throws NumericException {
        assertRelativelyEquals(Double.NaN, exponential.evaluate(Double.NaN), 1.0e-10);
        assertRelativelyEquals(Math.exp( -2.0), exponential.evaluate(  2.0), 1.0e-10);
        assertRelativelyEquals(Math.exp( -4.0), exponential.evaluate(  4.0), 1.0e-10);
        assertRelativelyEquals(Math.exp( -8.0), exponential.evaluate(  8.0), 1.0e-10);
        assertRelativelyEquals(Math.exp(  2.0), exponential.evaluate( -2.0), 1.0e-10);
        assertRelativelyEquals(Math.exp(  4.0), exponential.evaluate( -4.0), 1.0e-10);
        assertRelativelyEquals(Math.exp(  8.0), exponential.evaluate( -8.0), 1.0e-10);
    }
}
