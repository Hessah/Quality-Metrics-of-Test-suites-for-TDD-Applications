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
import net.sf.doodleproject.numerics4j.exception.ConvergenceException;
import net.sf.doodleproject.numerics4j.exception.NumericException;
import net.sf.doodleproject.numerics4j.function.Function;

/**
 * <p>
 * The extended trapezoidal rule for numerically integrating functions.
 * </p>
 * 
 * <p>
 * For example, to evaluate definite integrals for sine, first a
 * {@link net.sf.doodleproject.numerics4j.function.Function} is defined:
 * <pre>Function sine = new Function() {
 *    public double evaluate(double x) {
 *        return Math.sin(x);
 *    }}
 * };</pre>
 * </p>
 * 
 * <p>
 * Then, a trapezoidal integrator is created with the above function:
 <pre>TrapezoidalIntegrator integrator = new TrapezoidalIntegrator(sine);</pre>
 * </p>
 * 
 * <p>
 * Lastly, evaluating definite integrals is accomplished using the
 * {@link #integrate} method:
 * <pre>// integrate sine from 0 to Pi.
 * double two = integrator.integrate(0.0, Math.PI);
 * 
 * // integrate sine from Pi/2 to 2 Pi.
 * double one = integrator.integrate(Math.PI / 2.0, Math.PI);</pre>
 * </p>

 * <p>
 * References:
 * <ol>
 * <li>
 *   Eric W. Weisstein. "Newton-Cotes Formulas." From MathWorld--A Wolfram Web
 *   Resource. <a target="_blank"
 *     href="http://mathworld.wolfram.com/Newton-CotesFormulas.html">
 *   http://mathworld.wolfram.com/Newton-CotesFormulas.html</a>
 * </li>
 * <li>
 *   Eric W. Weisstein. "Trapezoidal Rule." From MathWorld--A Wolfram Web
 *   Resource. <a target="_blank"
 *     href="http://mathworld.wolfram.com/TrapezoidalRule.html">
 *   http://mathworld.wolfram.com/TrapezoidalRule.html</a>
 * </li>
 * </ol>
 * </p>
 * 
 * @version $Revision: 1.2 $ $Date: 2005/06/24 15:39:15 $
 * @since 1.1
 */
public class TrapezoidalIntegrator extends IterativeMethod {

    /**
     * The internal state used during root finding. 
     */
    static class IterativeState {
        
        /** The target function. */
        private Function function;
        
        /** The lower limit of integration. */
        private double a;
        
        /** The upper limit of integration. */
        private double b;
        
        /** The current iteration. */
        private int n;
        
        /** The current definite integral approximation. */
        private double s;
        
        /** The number of inner abscissa points in the evaluation. */
        private int k;
        
        /**
         * Create a state object for the given initial root approximation.
         * @param f the target function.
         * @param low the lower limit of integration.
         * @param up the upper limit of integration.
         * @throws NumericException if <tt>function</tt> cannot be evaluated at
         *         the limits of integration.
         */
        IterativeState(Function f, double low, double up)
            throws NumericException
        {
            super();
            this.a = low;
            this.b = up;
            this.function = f;
            double fa = f.evaluate(low);
            double fb = f.evaluate(up);
            s = (up - low) * (fa / 2.0 + fb / 2.0);
            n = 0;
            k = 2;
        }

        /**
         * Access the current iteration.
         * @return the current iteration.
         */
        public int getIterations() {
            return n;
        }
        
        /**
         * Perform the next iteration of finding a root. The current state is
         * updated with the newly compuated root data.
         * @throws NumericException if the function could not be evaluated.
         */
        public void iterate() throws NumericException {
            ++n;
            
            // compute function at next set of points
            double sn = 0.0;
            double h = (b - a) / k;
            for (int i = k - 1; i >= 1; i -= 2) {
                double x = a + (i * h);
                sn += function.evaluate(x);
            }
            sn = (0.5 * s) + (h * sn);

            k *= 2;
            s = sn;
        }

        /**
         * Access the result of this root finding.
         * @return the root.
         */
        public double getResult() {
            return s;
        }
    }
    
    /** the target function. */ 
    private Function function;

    /**
     * Create an integrator for the given function.
     * @param f the target function.
     */
    public TrapezoidalIntegrator(Function f) {
        this(f, 100, 1.0e-10);
    }

    /**
     * Create an integrator for the given function.
     * @param f the target function.
     * @param iterations maximum number of iterations.
     * @param error maximum relative error.
     */
    public TrapezoidalIntegrator(Function f, int iterations, double error) {
        super(iterations, error);
        setFunction(f);
    }

    /**
     * Access the target function.
     * @return the target function.
     */
    public Function getFunction() {
        return function;
    }

    /**
     * Evaluate the definite integral from <tt>a</tt> to <tt>b</tt>.
     * @param a the lower limit of integration.
     * @param b the upper limit of integration.
     * @return the definite integral from <tt>a</tt> to <tt>b</tt>.
     * @throws NumericException if the integral can not be evaluated.
     */
    public double integrate(double a, double b) throws NumericException {
        IterativeState state = new IterativeState(function, a, b);

        double s = state.getResult();
        double sn = s;
        double error = Double.MAX_VALUE;
        do {
            state.iterate();
            sn = state.getResult();
            error = Math.abs(sn / s - 1.0);
            s = sn;
        } while (state.getIterations() < getMaximumIterations() &&
            error > getMaximumRelativeError());
        
        if (state.getIterations() >= getMaximumIterations()) {
            throw new ConvergenceException(
               "Trapezoidal integration failed to converge.");
        }
        
        return s;
    }
    
    /**
     * Modify the target function.
     * @param f the new target function.
     */
    public void setFunction(Function f) {
        if (f == null) {
            throw new IllegalArgumentException("Function can not be null.");
        }
        this.function = f;
    }
}
