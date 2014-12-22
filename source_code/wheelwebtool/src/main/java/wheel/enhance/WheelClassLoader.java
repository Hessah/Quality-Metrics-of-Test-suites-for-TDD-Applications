/*
Copyright (c) 2007-2008, Henri Frilund

All rights reserved.

Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:

    * Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
    * Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
    * Neither the name of the <ORGANIZATION> nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package wheel.enhance;

import wheel.WheelException;
import wheel.asm.ClassReader;
import wheel.asm.ClassWriter;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashSet;
import java.util.Set;

public class WheelClassLoader extends URLClassLoader {
    private Set<String> applicationPackages;
    private Set<String> actionRegistry;

    public WheelClassLoader(ClassLoader classLoader) {
        super(new URL[]{}, classLoader);
        actionRegistry = new HashSet<String>();
    }

    public WheelClassLoader(URL[] urls, ClassLoader classLoader) {
        super(urls, classLoader);
        actionRegistry = new HashSet<String>();
    }

    @Override
    public Class<?> loadClass(String className) throws ClassNotFoundException {
        return loadClass(className, false);
    }


    @Override
    public Class<?> loadClass(String className, boolean resolve) throws ClassNotFoundException {
        boolean loadClass = false;

        for (String applicationPackage : applicationPackages) {
            if (className.startsWith(applicationPackage)) {
                loadClass = true;
                break;
            }
        }

        if (!loadClass) {
            return getParent().loadClass(className);
        }

        if (className.equals(getClass().getName()))
            return getClass();

        Class clazz = findLoadedClass(className);

        if (clazz != null) {
            return clazz;
        }

        synchronized(this) {
            BufferedInputStream bufferedInput = null;

            try {
                ClassWriter cw = new ClassWriter(0);
                //TraceClassVisitor trace = new TraceClassVisitor(cw, new PrintWriter(new FileOutputStream(className + ".txt")));
                WheelClassAdapter wheelClassAdapter = new WheelClassAdapter(cw, actionRegistry, this);

                if (getURLs().length == 0)
                    bufferedInput = new BufferedInputStream(getParent().getResourceAsStream(className.replace('.', '/') + ".class"));
                else
                    bufferedInput = new BufferedInputStream(getResourceAsStream(className.replace('.', '/') + ".class"));

                if (bufferedInput == null)
                    throw new WheelException("Class " + className + " not found. Remember to add all packages to applicationPackages in web.xml.", null);

                ClassReader cr = new ClassReader(bufferedInput);

                if (!className.startsWith("wheel")) {
                    cr.accept(wheelClassAdapter, 0);
                }
                else
                    cr.accept(cw, 0);

                byte[] bytes = cw.toByteArray();
                clazz = defineClass(className, bytes, 0, bytes.length);

            } catch (IOException e) {
                throw new ClassNotFoundException("Error reading class bytecode for class " + className + ".", e);
            } finally {
                if (bufferedInput != null) {
                    try {
                        bufferedInput.close();
                    } catch (IOException e) {}
                }
            }

            if (clazz != null && resolve)
                resolveClass(clazz);

            if (clazz == null)
                throw new ClassNotFoundException(className);

            return clazz;
        }
    }


    public Set<String> getApplicationPackages() {
        return applicationPackages;
    }

    public void setApplicationPackages(Set<String> applicationPackages) {
        this.applicationPackages = applicationPackages;
    }

    public Set<String> getActionRegistry() {
        return actionRegistry;
    }
}
