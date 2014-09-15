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
package net.sf.doodleproject.numerics4j.root;

import junit.framework.TestCase;
import net.sf.doodleproject.numerics4j.exception.ConvergenceException;
import net.sf.doodleproject.numerics4j.exception.NumericException;
import net.sf.doodleproject.numerics4j.function.Function;

public class BracketTest extends TestCase {

    Function sine = new Function() {
        public double evaluate(double x) {
            return Math.sin(x);
        }
    };
    
    public void testConstructor() {
        testConstructorFailure(null,  1);
        testConstructorFailure(sine, -1);
        testConstructorFailure(sine,  0);
        testConstructorSuccess(sine,  1);
    }

    public void testBracketOut() throws NumericException {
        testBracketOutSuccess(Double.NaN, 3.5, 4.0, Double.NaN);
        testBracketOutSuccess(3.0, Double.NaN, 4.0, Double.NaN);
        testBracketOutSuccess(3.0, 3.5, Double.NaN, Double.NaN);
        testBracketOutFailure(3.0, 2.0, 4.0, IllegalArgumentException.class);
        testBracketOutFailure(3.0, 5.0, 4.0, IllegalArgumentException.class);
        testBracketOutFailure(3.5, 3.7, 4.0, ConvergenceException.class);
        testBracketOutSuccess(3.0, 3.5, 4.0, Math.PI);
    }
    
    private void testBracketOutSuccess(double lower, double initial, double upper, double root) throws NumericException {
        Bracket b = new Bracket(sine);
        double[] bracket = b.bracketOut(lower, initial, upper);
        if (Double.isNaN(root)) {
            assertTrue(Double.isNaN(bracket[0]));
            assertTrue(Double.isNaN(bracket[1]));
        } else {
            assertTrue(bracket[0] <= bracket[1]);
            assertTrue(bracket[0] <= root);
            assertTrue(root <= bracket[1]);
            assertTrue(sine.evaluate(bracket[0]) * sine.evaluate(bracket[1]) <= 0.0);
        }
    }

    private void testBracketOutFailure(double lower, double initial, double upper, Class exception) throws NumericException {
        try {
            Bracket b = new Bracket(sine);
            b.bracketOut(lower, initial, upper);
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

    private void testConstructorSuccess(Function f, int iterations) {
        try {
            Bracket b = new Bracket(f, iterations);
            assertEquals(f, b.getFunction());
            assertEquals(iterations, b.getMaximumIterations());
        } catch (IllegalArgumentException ex) {
            fail("Valid constructor values.");
        }
    }

    private void testConstructorFailure(Function f, int iterations) {
        try {
            new Bracket(f, iterations);
            fail("Invalid constructor values.");
        } catch (IllegalArgumentException ex) {
            // success
        }
    }

}
