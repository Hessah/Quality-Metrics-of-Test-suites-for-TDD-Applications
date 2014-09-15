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
package net.sf.doodleproject.numerics4j.integration;

import net.sf.doodleproject.numerics4j.IterativeMethod;
import net.sf.doodleproject.numerics4j.iterativeMethTest;
import net.sf.doodleproject.numerics4j.exception.NumericException;
import net.sf.doodleproject.numerics4j.function.Function;

/**
 * TODO add javadoc comment.
 * @version $Revision: 1.1 $ $Date: 2005/06/23 12:25:32 $
 */
public class AdaptiveIntegratorTest extends iterativeMethTest {

    Function sine = new Function() {
        public double evaluate(double x) {
            return Math.sin(x);
        }
    };

    public void testConstructor() {
        testConstructorFailure(null, 1, 1.0);
        testConstructorFailure(sine, -1, 1.0);
        testConstructorFailure(sine, 0, 1.0);
        testConstructorFailure(sine, 1, Double.NaN);
        testConstructorFailure(sine, 1, Double.NEGATIVE_INFINITY);
        testConstructorFailure(sine, 1, -1.0);
        testConstructorFailure(sine, 1, 0.0);
        testConstructorSuccess(sine, 1, 1.0);
        testConstructorSuccess(sine, 1, Double.POSITIVE_INFINITY);
    }
    
    public void testFindRoot() throws NumericException {
        testFindRootSuccess(sine, 0.0, Math.PI, 2.0);
        testFindRootSuccess(sine, Math.PI / 2.0, Math.PI, 1.0);
        testFindRootSuccess(sine, Double.NaN, 1.0, Double.NaN);
        testFindRootSuccess(sine, 0.0, Double.NaN, Double.NaN);
    }
    
    protected IterativeMethod createIterativeMethod() {
        return new AdaptiveIntegrator(sine);
    }

    private void testConstructorFailure(Function f, int iterations, double error) {
        try {
            new AdaptiveIntegrator(f, iterations, error);
            fail("Invalid constructor values.");
        } catch (IllegalArgumentException ex) {
            // success
        }
    }

    private void testConstructorSuccess(Function f, int iterations, double error) {
        try {
            AdaptiveIntegrator s = new AdaptiveIntegrator(f, iterations, error);
            assertEquals(f, s.getFunction());
            assertEquals(iterations, s.getMaximumIterations());
            assertEquals(error, s.getMaximumRelativeError(), 0.0);
        } catch (IllegalArgumentException ex) {
            fail("Valid constructor values.");
        }
    }

    private void testFindRootFailure(Function function, double a, double b, Class exception) throws NumericException {
        try {
            AdaptiveIntegrator s = new AdaptiveIntegrator(function);
            s.integrate(a, b);
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

    private void testFindRootSuccess(Function function, double a, double b, double expected) throws NumericException {
        AdaptiveIntegrator s = new AdaptiveIntegrator(function);
        assertRelativelyEquals(expected, s.integrate(a, b), s.getMaximumRelativeError());
    }
}
