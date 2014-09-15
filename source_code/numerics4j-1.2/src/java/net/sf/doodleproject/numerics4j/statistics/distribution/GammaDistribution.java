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

import net.sf.doodleproject.numerics4j.exception.NumericException;
import net.sf.doodleproject.numerics4j.special.Gamma;

/**
 * <p>
 * The Gamma distribution (1).
 * </p>
 * 
 * <p>
 * References:
 * <ol>
 * <li>
 * Eric W. Weisstein. "Gamma Distribution." From MathWorld--A
 * Wolfram Web Resource. <a target="_blank" 
 * href="http://mathworld.wolfram.com/GammaDistribution.html">
 * http://mathworld.wolfram.com/GammaDistribution.html</a>
 * </li>
 * </ol>
 * </p>
 * 
 * @version $Revision: 1.10 $ $Date: 2005/06/24 15:39:14 $
 */
public class GammaDistribution extends ContinuousDistribution {

    /** The alpha parameter. */
    private double alpha;

    /** The beta parameter. */
    private double beta;

    /**
     * Default constructor.  Alpha and beta are both set to 1.
     */
    public GammaDistribution() {
        this(1.0, 1.0);
    }

    /**
     * Create a distribution with the given alpha and beta values.
     * @param a the alpha parameter.
     * @param b the beta parameter.
     */
    public GammaDistribution(double a, double b) {
        super();
        setAlpha(a);
        setBeta(b);
    }

    /**
     * The CDF for this distribution. This method returns P(X &lt; x).
     * @param x the value at which the CDF is evaluated.
     * @return CDF for this distribution. 
     * @throws NumericException if the cumulative probability can not be
     *         computed.
     */
    public double cumulativeProbability(double x) throws NumericException {
        double ret;

        if (x <= 0.0) {
            ret = 0.0;
        } else if (Double.isInfinite(x)) {
            ret = 1.0;
        } else {
            ret = Gamma.regularizedGammaP(getAlpha(), x / getBeta());
        }

        return ret;
    }

    /**
     * Access the alpha parameter.
     * @return the alpha parameter.
     */
    public double getAlpha() {
        return alpha;
    }

    /**
     * Access the beta parameter.
     * @return the beta parameter.
     */
    public double getBeta() {
        return beta;
    }

    /**
     * The inverse CDF for this distribution.  This method returns x such that,
     * P(X &lt; x) = p.
     * @param p the cumulative probability.
     * @return x
     * @throws NumericException if the inverse cumulative probability can not
     *         be computed.
     */
    public double inverseCumulativeProbability(double p)
        throws NumericException
    {
        double ret;

        if (p < 0.0 || p > 1.0 || Double.isNaN(p)) {
            ret = Double.NaN;
        } else if (p == 0.0) {
            ret = 0.0;
        } else if (p == 1.0) {
            ret = Double.POSITIVE_INFINITY;
        } else if (p <= 0.5) {
            ret = findInverseCumulativeProbability(p, 0.0,
                    0.5 * getAlpha() * getBeta(), getAlpha() * getBeta());
        } else {
            ret = findInverseCumulativeProbability(p, 0.0,
                    getAlpha() * getBeta(), Double.POSITIVE_INFINITY);
        }
        
        return ret;
    }

    /**
     * Modify the alpha parameter.
     * @param a the new alpha value.
     */
    public void setAlpha(double a) {
        if (a <= 0.0 || Double.isNaN(a)) {
            throw new IllegalArgumentException("Alpha must be positive.");
        }
        this.alpha = a;
    }

    /**
     * Modify the beta parameter.
     * @param b the new beta value.
     */
    public void setBeta(double b) {
        if (b <= 0.0 || Double.isNaN(b)) {
            throw new IllegalArgumentException("Beta must be positive.");
        }
        this.beta = b;
    }
}
