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
package net.sf.doodleproject.numerics4j.special;

import net.sf.doodleproject.numerics4j.NumericTestCase;

/**
 * @version $Revision: 1.2 $ $Date: 2005/10/14 14:48:12 $
 */
public class TrigonometricTest extends NumericTestCase {
    
    public void testAcosh() {
        assertRelativelyEquals(Trigonometric.acosh(Double.NaN), Double.NaN, 0.0);
        assertRelativelyEquals(Trigonometric.acosh(-1.0), Double.NaN, 0.0);
        assertRelativelyEquals(Trigonometric.acosh(0.0), Double.NaN, 0.0);
        assertRelativelyEquals(Trigonometric.acosh(1.32888506805353), 0.790302244974749, 1.e-10);
        assertRelativelyEquals(Trigonometric.acosh(1.47429536517826), 0.939068938341224, 1.e-10);
        assertRelativelyEquals(Trigonometric.acosh(2.29840268333175), 1.47427325906754, 1.e-10);
        assertRelativelyEquals(Trigonometric.acosh(2.76804842141016), 1.67693791257118, 1.e-10);
        assertRelativelyEquals(Trigonometric.acosh(4.36730085534818), 2.15391955183645, 1.e-10);
        assertRelativelyEquals(Trigonometric.acosh(4.57364241596148), 2.20128565741278, 1.e-10);
        assertRelativelyEquals(Trigonometric.acosh(5.14506369690267), 2.32160421081548, 1.e-10);
        assertRelativelyEquals(Trigonometric.acosh(5.54795815165274), 2.39835416020829, 1.e-10);
        assertRelativelyEquals(Trigonometric.acosh(9.02589597048518), 2.89016199872632, 1.e-10);
        assertRelativelyEquals(Trigonometric.acosh(9.5178085583514), 2.94354058798459, 1.e-10);
    }
    
    public void testAsinh() {
        assertRelativelyEquals(Trigonometric.asinh(Double.NaN), Double.NaN, 0.0);
        assertRelativelyEquals(Trigonometric.asinh(-8.19275152171396), -2.80010095155102, 1.e-10);
        assertRelativelyEquals(Trigonometric.asinh(-8.16117345439139), -2.79626767237975, 1.e-10);
        assertRelativelyEquals(Trigonometric.asinh(-6.59831605604345), -2.58565495754514, 1.e-10);
        assertRelativelyEquals(Trigonometric.asinh(-2.6123291225405), -1.68815992285789, 1.e-10);
        assertRelativelyEquals(Trigonometric.asinh(3.15087908021589), 1.86510867725933, 1.e-10);
        assertRelativelyEquals(Trigonometric.asinh(4.23683882351552), 2.15060931233017, 1.e-10);
        assertRelativelyEquals(Trigonometric.asinh(8.07003028357055), 2.78512124681541, 1.e-10);
        assertRelativelyEquals(Trigonometric.asinh(9.14218635765965), 2.90902457452919, 1.e-10);
        assertRelativelyEquals(Trigonometric.asinh(9.82206048459794), 2.9803594928638, 1.e-10);
        assertRelativelyEquals(Trigonometric.asinh(9.9144879574155), 2.98967796056672, 1.e-10);
    }
    
    public void testAtanh() {
        assertRelativelyEquals(Trigonometric.atanh(Double.NaN), Double.NaN, 0.0);
        assertRelativelyEquals(Trigonometric.atanh(-2.0), Double.NaN, 0.0);
        assertRelativelyEquals(Trigonometric.atanh(2.0), Double.NaN, 0.0);
        assertRelativelyEquals(Trigonometric.atanh(-1.0), Double.NEGATIVE_INFINITY, 0.0);
        assertRelativelyEquals(Trigonometric.atanh(1.0), Double.POSITIVE_INFINITY, 0.0);
        assertRelativelyEquals(Trigonometric.atanh(-0.774839699295632), -1.03232639573311, 1.e-10);
        assertRelativelyEquals(Trigonometric.atanh(-0.456075692978638), -0.49234505933561, 1.e-10);
        assertRelativelyEquals(Trigonometric.atanh(-0.422905939280691), -0.451225612771806, 1.e-10);
        assertRelativelyEquals(Trigonometric.atanh(-0.286566464782831), -0.294821507116488, 1.e-10);
        assertRelativelyEquals(Trigonometric.atanh(-0.239608130864234), -0.244358333738593, 1.e-10);
        assertRelativelyEquals(Trigonometric.atanh(-0.0265506203293687), -0.0265568617938862, 1.e-10);
        assertRelativelyEquals(Trigonometric.atanh(0.00196746484644805), 0.00196746738508559, 1.e-10);
        assertRelativelyEquals(Trigonometric.atanh(0.107366434886062), 0.107781869423228, 1.e-10);
        assertRelativelyEquals(Trigonometric.atanh(0.749734502101823), 0.97234849819124, 1.e-10);
        assertRelativelyEquals(Trigonometric.atanh(0.782951301616758), 1.05295178000244, 1.e-10);
    }
    
    public void testCosh() {
        assertRelativelyEquals(Trigonometric.cosh(Double.NaN), Double.NaN, 0.0);
        assertEquals(Trigonometric.cosh(0), 1.0, 0.0);
        assertEquals(Trigonometric.cosh(0.447233825252133), 1.10168716939168, 1.0e-10); 
        assertEquals(Trigonometric.cosh(0.569350918665), 1.16650615228394, 1.0e-10); 
        assertEquals(Trigonometric.cosh(0.732769934738127), 1.28070619706079, 1.0e-10); 
        assertEquals(Trigonometric.cosh(1.37866405710923), 2.11075490183773, 1.0e-10); 
        assertEquals(Trigonometric.cosh(2.87908563258551), 8.92708897375499, 1.0e-10); 
        assertEquals(Trigonometric.cosh(2.90346223608424), 9.14600532534927, 1.0e-10); 
        assertEquals(Trigonometric.cosh(3.62431146666934), 18.7627812411064, 1.0e-10); 
        assertEquals(Trigonometric.cosh(4.11210129875235), 30.5456464061917, 1.0e-10); 
        assertEquals(Trigonometric.cosh(4.5674711248312), 48.1553272038219, 1.0e-10); 
        assertEquals(Trigonometric.cosh(4.88321920386677), 66.0313326098937, 1.0e-10);
    }

    public void testSinh() {
        assertRelativelyEquals(Trigonometric.sinh(Double.NaN), Double.NaN, 0.0);
        assertEquals(Trigonometric.sinh(0), 0.0, 0.0);
        assertEquals(Trigonometric.sinh(0.174855710943919), 0.17574809562542, 1.0e-10); 
        assertEquals(Trigonometric.sinh(0.270323788107573), 0.273628154586043, 1.0e-10); 
        assertEquals(Trigonometric.sinh(0.840848498515684), 0.943494435870354, 1.0e-10); 
        assertEquals(Trigonometric.sinh(0.878914597481086), 0.996525483456715, 1.0e-10); 
        assertEquals(Trigonometric.sinh(0.980275310513398), 1.14499105487484, 1.0e-10); 
        assertEquals(Trigonometric.sinh(1.14703440082933), 1.41563183431439, 1.0e-10); 
        assertEquals(Trigonometric.sinh(2.60057047633438), 6.6985948756008, 1.0e-10); 
        assertEquals(Trigonometric.sinh(3.36906296596674), 14.508435186782, 1.0e-10); 
        assertEquals(Trigonometric.sinh(3.85365009532941), 23.5718518086835, 1.0e-10); 
        assertEquals(Trigonometric.sinh(4.96036028875678), 71.3190848464235, 1.0e-10);
    }
    
    public void testTanh() {
        assertRelativelyEquals(Trigonometric.tanh(Double.NaN), Double.NaN, 0.0);
        assertEquals(Trigonometric.tanh(0), 0.0, 0.0);
        assertEquals(Trigonometric.tanh(0.285536109485994), 0.278021094504239, 1.0e-10); 
        assertEquals(Trigonometric.tanh(0.745225834083834), 0.632292111643589, 1.0e-10);
        assertEquals(Trigonometric.tanh(0.971886875918442), 0.749532288579846, 1.0e-10);
        assertEquals(Trigonometric.tanh(1.25890773719743), 0.850762703802917, 1.0e-10);
        assertEquals(Trigonometric.tanh(1.34305950703044), 0.872405145670092, 1.0e-10);
        assertEquals(Trigonometric.tanh(1.45724961991265), 0.897117099123835, 1.0e-10);
        assertEquals(Trigonometric.tanh(1.66400888874696), 0.930755155131329, 1.0e-10);
        assertEquals(Trigonometric.tanh(1.81119293227803), 0.947952932298378, 1.0e-10);
        assertEquals(Trigonometric.tanh(2.011727926549), 0.964846867299976, 1.0e-10);
        assertEquals(Trigonometric.tanh(3.52575677478725), 0.998269304782297, 1.0e-10);
    }
}
