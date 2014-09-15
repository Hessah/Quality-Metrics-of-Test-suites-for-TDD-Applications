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
 * Neither the name of DoodleProject nor the names of its contributors
 * may be used to endorse or promote products derived from this
 * software without specific prior written permission.
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

import net.sf.doodleproject.numerics4j.NumericTestCase;
import junit.framework.TestCase;

public class SaddlePointApproximationTest extends NumericTestCase {

    public void testGetDeviancePart() {
        testGetDeviancePartSuccess(85, 129.10489211706900000000, 8.57710767120289570000);
        testGetDeviancePartSuccess(26, 91.42857142857143100000, 32.73457270737145600000);
        testGetDeviancePartSuccess(78, 100.25745414593950000000, 2.67691194628075380000);
        testGetDeviancePartSuccess( 5, 71.81615649891658400000, 53.49279870300181700000);
        testGetDeviancePartSuccess(44, 38.40717795342875700000, 0.38876965401889524000);
        testGetDeviancePartSuccess(77, 51.75499740592670200000, 5.34589821871819030000);
        testGetDeviancePartSuccess(76, 46.46388134403515800000, 7.86029502925410380000);
        testGetDeviancePartSuccess(26, 55.04049806207464700000, 9.54120774102932500000);
        testGetDeviancePartSuccess(37, 120.82842493972593000000, 40.04063985387821800000);
        testGetDeviancePartSuccess(89, 108.08532975249489000000, 1.79399717199782850000);
        testGetDeviancePartSuccess(69, 44.37000640888699400000, 5.83645924764122980000);
        testGetDeviancePartSuccess(71, 69.02066103091525000000, 0.02811375541314815500);
        testGetDeviancePartSuccess(25, 77.61241492965483200000, 24.29112553636893100000);
        testGetDeviancePartSuccess(75, 73.75365459150974300000, 0.01047202358072543700);
        testGetDeviancePartSuccess(10, 47.09933774834436800000, 21.60259927449666200000);
    }

    private void testGetDeviancePartSuccess(int x, double np, double expected) {
        assertRelativelyEquals(expected, SaddlePointExpansion.getDeviancePart(x, np), 1.0e-15);
    }
    
    public void testGetStirlingError() {
        testGetStirlingErrorSuccess( 3, 0.02767792568499833800);
        testGetStirlingErrorSuccess( 6, 0.01387612882307074800);
        testGetStirlingErrorSuccess( 7, 0.01189670994589177000);
        testGetStirlingErrorSuccess(10, 0.00833056343336287080);
        testGetStirlingErrorSuccess(11, 0.00757367548795184060);
        testGetStirlingErrorSuccess(12, 0.00694284010720952990);
        testGetStirlingErrorSuccess(13, 0.00640899418800420710);
        testGetStirlingErrorSuccess(15, 0.00555473355196301960);
        testGetStirlingErrorSuccess(16, 0.00520765591960974800);
        testGetStirlingErrorSuccess(17, 0.00490139594843479270);
        testGetStirlingErrorSuccess(18, 0.00462915374933405790);
        testGetStirlingErrorSuccess(19, 0.00438556024923234060);
        testGetStirlingErrorSuccess(21, 0.00396795421864086510);
        testGetStirlingErrorSuccess(22, 0.00378761806844443760);
        testGetStirlingErrorSuccess(23, 0.00362296022468309650);
        testGetStirlingErrorSuccess(24, 0.00347202138297876770);
        testGetStirlingErrorSuccess(26, 0.00320497022805503850);
        testGetStirlingErrorSuccess(28, 0.00297606398355040880);
        testGetStirlingErrorSuccess(29, 0.00287344936235246630);        
    }

    private void testGetStirlingErrorSuccess(double z, double expected) {
        double actual = SaddlePointExpansion.getStirlingError(z);
        assertRelativelyEquals(expected, actual, 1.0e-13);
    }
}
