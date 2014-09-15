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
package net.sf.doodleproject.numerics4j.series;

import net.sf.doodleproject.numerics4j.IterativeMethod;
import net.sf.doodleproject.numerics4j.iterativeMethTest;
import net.sf.doodleproject.numerics4j.exception.NumericException;

public class SeriesTest extends iterativeMethTest {
    
    private Series sine = new Series() {
        
        protected double getTerm(int n, double x) {
            return Math.pow(-1.0, n) * Math.pow(x, 2.0 * n + 1.0) / factorial(2.0 * n + 1.0);
        }
        
        private double factorial(double n) {
            double f = 1.0;
            while(n > 0.0) {
                f *= n;
                n = n - 1.0;
            }
            return f;
        }
    };

    class Test extends Series {
        public Test() {
            super();
        }

        public Test(int iterations, double error) {
            super(iterations, error);
        }

        protected double getTerm(int n, double x) {
            return 0;
        }
    }
    

    protected IterativeMethod createIterativeMethod() {
        return sine;
    }
    
    public void testConstructor() {
        testConstructorFailure(-1,  1.0);
        testConstructorFailure( 0,  1.0);
        testConstructorFailure( 1, Double.NaN);
        testConstructorFailure( 1, Double.NEGATIVE_INFINITY);
        testConstructorFailure( 1, -1.0);
        testConstructorFailure( 1,  0.0);
        testConstructorSuccess( 1,  1.0);
        testConstructorSuccess( 1, Double.POSITIVE_INFINITY);
    }

    private void testConstructorSuccess(int iterations, double error) {
        try {
            Test s = new Test(iterations, error);
            assertEquals(iterations, s.getMaximumIterations());
            assertEquals(error, s.getMaximumRelativeError(), 0.0);
        } catch (IllegalArgumentException ex) {
            fail("Valid constructor values.");
        }
    }

    private void testConstructorFailure(int iterations, double error) {
        try {
            new Test(iterations, error);
            fail("Invalid constructor values.");
        } catch (IllegalArgumentException ex) {
            // success
        }
    }
    
    public void testEvaluate() throws NumericException {
        testEvaluateSuccess(Math.PI / 2.0, 1.0);
        testEvaluateSuccess(Double.NaN, Double.NaN);
    }

    private void testEvaluateSuccess(double x, double expected) throws NumericException {
        assertRelativelyEquals(expected, sine.evaluate(x), sine.getMaximumRelativeError()); 
    }
    
    private void testEvaluateFailure(double x, Class exception) throws NumericException {
        try {
            sine.evaluate(x);
            fail();
        } catch (NumericException ex) {
            if (!exception.equals(ex.getClass())) {
                throw ex;
            }
        } catch (RuntimeException ex) {
            if (!exception.equals(ex.getClass())) {
                throw ex;
            }
        }
    }
}
