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
package net.sf.doodleproject.numerics4j;

/**
 * @version $Revision: 1.4 $ $Date: 2004/08/23 15:16:33 $
 */
public class iterativeMethTest extends NumericTestCase {
    
    private IterativeMethod method;

    protected IterativeMethod createIterativeMethod() {
        return new IterativeMethod(){
        };
    }
    
    protected void setUp() throws Exception {
        method = createIterativeMethod();
    }

    protected void tearDown() throws Exception {
        method = null;
    }
    
    public void testMaximumIterations() {
        testMaximumIterationsFailure(-1);
        testMaximumIterationsFailure( 0);
        testMaximumIterationsSuccess( 1);
    }
    
    private void testMaximumIterationsFailure(int iterations) {
        try {
            method.setMaximumIterations(iterations);
            fail("Invalid maximum iterations: " + iterations);
        } catch (IllegalArgumentException ex) {
            // success
        }
    }
    
    private void testMaximumIterationsSuccess(int iterations) {
        try {
            method.setMaximumIterations(iterations);
            assertEquals(iterations, method.getMaximumIterations());
        } catch (IllegalArgumentException ex) {
            fail("Valid maximum iterations: " + iterations);
        }
    }
    
    public void testMaximumRelativeError() {
        testMaximumRelativeErrorFailure(Double.NEGATIVE_INFINITY);
        testMaximumRelativeErrorFailure(Double.NaN);
        testMaximumRelativeErrorFailure(-1.0);
        testMaximumRelativeErrorFailure( 0.0);
        testMaximumRelativeErrorSuccess( 1.0);
        testMaximumRelativeErrorSuccess(Double.POSITIVE_INFINITY);
    }
    
    private void testMaximumRelativeErrorFailure(double error) {
        try {
            method.setMaximumRelativeError(error);
            fail("Invalid maximum relative error: " + error);
        } catch (IllegalArgumentException ex) {
            // success
        }
    }
    
    private void testMaximumRelativeErrorSuccess(double error) {
        try {
            method.setMaximumRelativeError(error);
            assertEquals(error, method.getMaximumRelativeError(), 0.0);
        } catch (IllegalArgumentException ex) {
            fail("Valid maximum relative error: " + error);
        }
    }
}
