/*
 * $Header$
 * $Revision: 1255 $
 * $Date: 2006-11-09 12:20:12 -0600 (Thu, 09 Nov 2006) $
 *
 * ====================================================================
 *
 * Copyright 2000-2002 bob mcwhirter & James Strachan.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 * 
 *   * Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 * 
 *   * Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 * 
 *   * Neither the name of the Jaxen Project nor the names of its
 *     contributors may be used to endorse or promote products derived 
 *     from this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A
 * PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER
 * OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * ====================================================================
 * This software consists of voluntary contributions made by many 
 * individuals on behalf of the Jaxen Project and was originally 
 * created by bob mcwhirter <bob@werken.com> and 
 * James Strachan <jstrachan@apache.org>.  For more information on the 
 * Jaxen Project, please see <http://www.jaxen.org/>.
 * 
 * $Id: SingleObjectIterator.java 1255 2006-11-09 18:20:12Z elharo $
 */


package org.jaxen.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Simple utility class that wraps an iterator around one object.
 * This is a little more efficent than creating a one-object list.
 *
 */
public class SingleObjectIterator implements Iterator
{
    
    private Object  object;
    private boolean seen;

    /**
     * Creates a new single object iterator.
     * 
     * @param object the object to iterate over
     */
    public SingleObjectIterator(Object object)
    {
        this.object = object;
        this.seen   = false;
    }


    /**
     * Returns true if this iterator's element has not yet been seen; false if it has.
     * 
     * @return true if this iterator has another element; false if it doesn't
     * 
     * @see java.util.Iterator#hasNext()
     */
    public boolean hasNext()
    {
        return ! this.seen;
    }

    /**
     * Returns the single element in this iterator if it has not yet
     * been seen. 
     * 
     * @return the next element in this iterator
     * 
     * @throws NoSuchElementException if the element has already been seen
     * 
     * @see java.util.Iterator#next()
     */
    public Object next()
    {
        if ( hasNext() )
        {
            this.seen = true;
            return this.object;
        }

        throw new NoSuchElementException();
    }

    /**
     * This operation is not supported.
     * 
     * @throws UnsupportedOperationException always
     */
    public void remove()
    {
        throw new UnsupportedOperationException();
    }
    
}
