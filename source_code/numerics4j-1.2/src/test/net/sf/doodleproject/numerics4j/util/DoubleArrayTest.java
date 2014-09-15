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
package net.sf.doodleproject.numerics4j.util;

import java.util.Arrays;

import junit.framework.TestCase;

/**
 * @version $Revision: 1.1 $ $Date: 2005/06/24 15:31:01 $
 */
public class DoubleArrayTest extends TestCase {

    public void testAdd() {
        DoubleArray array = new DoubleArray();
        
        array.add(Double.NaN);
        array.add(1.0);
        for (int i = 1; i <= 20; ++i) {
            array.add(i * 2.0);
        }
        assertEquals(22, array.getSize());
    }

    public void testClear() {
        DoubleArray array = new DoubleArray();
        
        array.add(Double.NaN);
        assertEquals(1, array.getSize());
        array.clear();
        assertEquals(0, array.getSize());
    }

    public void testGet() {
        DoubleArray array = new DoubleArray();
        
        array.add(0.0);
        array.add(1.0);
        array.add(2.0);
        
        try {
            array.get(-1);
            fail();
        } catch (ArrayIndexOutOfBoundsException ex) {
            // success
        }
        try {
            array.get(3);
            fail();
        } catch (ArrayIndexOutOfBoundsException ex) {
            // success
        }
        assertEquals(0.0, array.get(0), 0.0);
        assertEquals(1.0, array.get(1), 0.0);
        assertEquals(2.0, array.get(2), 0.0);
    }

    public void testToArray() {
        DoubleArray array = new DoubleArray();
        
        double[] a = array.toArray();
        assertNotNull(a);
        assertEquals(0, a.length);

        array.add(0.0);
        array.add(1.0);
        array.add(2.0);

        a = array.toArray();
        assertNotNull(a);
        assertEquals(3, a.length);
        assertTrue(Arrays.equals(new double[]{0.0, 1.0, 2.0}, a));
    }

    public void testSet() {
        DoubleArray array = new DoubleArray();
        
        assertEquals(0, array.getSize());
        array.set(5, 5.0);
        assertEquals(6, array.getSize());
        array.set(20, 20.0);
        assertEquals(21, array.getSize());
        array.set(10, 10.0);
        assertEquals(21, array.getSize());
        
        try {
            array.set(-1, 0.0);
            fail();
        } catch (ArrayIndexOutOfBoundsException ex) {
            // success
        }
    }

    public void testSetSize() {
        DoubleArray array = new DoubleArray();
        
        assertEquals(0, array.getSize());
        array.setSize(5);
        assertEquals(5, array.getSize());
        array.setSize(20);
        assertEquals(20, array.getSize());
        array.setSize(10);
        assertEquals(10, array.getSize());
        
        try {
            array.setSize(-1);
            fail();
        } catch (IllegalArgumentException ex) {
            // success
        }
    }
}
