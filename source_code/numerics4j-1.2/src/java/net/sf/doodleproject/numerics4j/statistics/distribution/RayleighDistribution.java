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
package net.sf.doodleproject.numerics4j.statistics.distribution;

/**
 * <p>
 * The Rayleigh distribution.
 * </p>
 * 
 * <p>
 * References:
 * <ol>
 * <li>
 * Eric W. Weisstein. "Rayleigh Distribution." From MathWorld--A
 * Wolfram Web Resource. <a target="_blank" 
 * href="http://mathworld.wolfram.com/RayleighDistribution.html">
 * http://mathworld.wolfram.com/RayleighDistribution.html</a>
 * </li>
 * </ol>
 * </p>
 * 
 * @since 1.2
 * @version $Revision: 1.2 $ $Date: 2005/10/28 22:27:47 $
 */
public class RayleighDistribution extends ContinuousDistribution {
    
    /** the scale parameter. */
    private double scale;
    
    /**
     * Default constructor.  The scale parameter is set to one.
     */
    public RayleighDistribution() {
        this(1.0);
    }
    
    /**
     * Create a distribution with the scale parameter.
     * @param s the scale parameter.
     */
    public RayleighDistribution(double s) {
        super();
        setScale(s);
    }
    
    /**
     * The CDF for this distribution. This method returns P(X &lt; x).
     * @param x the value at which the CDF is evaluated.
     * @return CDF for this distribution. 
     */
    public double cumulativeProbability(double x) {
        double ret;
        
        if (Double.isNaN(x)) {
            ret = Double.NaN;
        } else if (x <= 0.0) {
            ret = 0.0;
        } else if (Double.isInfinite(x)) {
            ret = 1.0;
        } else {
            double r = x / scale;
            ret = 1.0 - Math.exp(-r * r / 2.0);
        }
        
        return ret;
    }
    
    /**
     * Access the scale parameter.
     * @return the scale parameter.
     */
    public double getScale() {
        return scale;
    }

    /**
     * The inverse CDF for this distribution.  This method returns x such that,
     * P(X &lt; x) = p.
     * @param p the cumulative probability.
     * @return x
     */
    public double inverseCumulativeProbability(double p) {
        double ret;
        
        if (p < 0.0 || p > 1.0 || Double.isNaN(p)) {
            ret = Double.NaN;
        } else if (p == 0.0) {
            ret = 0.0;
        } else if (p == 1.0) {
            ret = Double.POSITIVE_INFINITY;
        } else {
            double q = 1.0 - p;
            ret = scale * Math.sqrt(Math.log(1.0 / (q * q)));
        }
        
        return ret;
    }
    
    /**
     * Modify the scale parameter.
     * @param s The new scale parameter value.
     */
    public void setScale(double s) {
        if (s <= 0.0 || Double.isNaN(s)) {
            throw new IllegalArgumentException(
                "scale parameter must be positive.");
        }
        this.scale = s;
    }
}
