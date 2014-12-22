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
package wheel;

import wheel.components.StandaloneComponent;
import wheel.enhance.WheelClassLoader;
import wheel.util.ActionRegistry;

import javax.servlet.ServletContext;
import java.io.InputStream;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultResourceManager implements IResourceManager {
    private final Logger log = LoggerFactory.getLogger(DefaultResourceManager.class);
    protected WheelClassLoader loader;
    protected ServletContext context;
    protected ActionRegistry actionRegistry;

    public DefaultResourceManager(ServletContext context) {
        this.context = context;

        createClassLoader();
    }

    public StandaloneComponent loadPage(String className) {
        try {
            Class clazz = loader.loadClass(className, true);
            return (StandaloneComponent)clazz.newInstance();
        } catch (ClassNotFoundException e) {
            log.error("Could not find page class with name '" +
                    className + "'. Check that the package of the desired page is configured as an applicationPackage.", e);
            throw new WheelException("Could not find page class with name '" +
                    className + "'. Check that the package of the desired page is configured as an applicationPackage.", e, null);
        } catch (IllegalAccessException e) {
            log.error("Could not access page class with name '" +
                    className + "'. Check that the package of the desired page is configured as an applicationPackage.", e);
            throw new WheelException("Could not access page class with name '" +
                    className + "'. Check that the package of the desired page is configured as an applicationPackage.", e, null);
        } catch (InstantiationException e) {
            log.error("Could not instantiate page class with name '" +
                    className + "'. Check that the package of the desired page is configured as an applicationPackage.", e);
            throw new WheelException("Could not instantiate page class with name '" +
                    className + "'. Check that the package of the desired page is configured as an applicationPackage.", e, null);
        }
    }

    public InputStream loadAsset(String path) {
        return Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
    }

    public ActionRegistry getActionRegistry() {
        if (actionRegistry == null) {
            actionRegistry = new ActionRegistry();

            Set<String> entries = loader.getActionRegistry();

            for (String entry : entries) {
                String[] split = entry.split("\\:");

                actionRegistry.addEntry(split[0], split[1], split[2].equals("true"));
            }
        }

        return actionRegistry;
    }

    public Set getResourcesFromPath(String path) {
        path = "/" + path + "/";
        Set resources = getResources(path);
        Set resourceFiles = new HashSet();

        if (resources == null)
            return resourceFiles;

        resourceFiles.addAll(resources);
        Set tempSet = new HashSet();
        Set removed = new HashSet();

        boolean foundDirectory;

        do {
            foundDirectory = false;

            for (Iterator iterator = resourceFiles.iterator(); iterator.hasNext();) {
                String s = (String) iterator.next();

                if (s.endsWith("/")) {
                    removed.add(s);
                    tempSet.addAll(getResources(s));
                    foundDirectory = true;
                }
            }

            resourceFiles.removeAll(removed);
            resourceFiles.addAll(tempSet);
            tempSet.clear();
            removed.clear();
        } while (foundDirectory);

        Set fixed = new HashSet();

        for (Iterator iterator = resourceFiles.iterator(); iterator.hasNext();) {
            String s = (String) iterator.next();
            fixed.add(s.substring(s.indexOf(path) + path.length(), s.length()));
        }

        return fixed;
    }

    public Class loadClass(String className) throws ClassNotFoundException {
        return loader.loadClass(className, true);
    }

    protected Set getResources(String path) {
        return context.getResourcePaths(path);
    }

    protected void createClassLoader() {
        loader = (WheelClassLoader)context.getAttribute("wheelClassLoader");

        if (loader == null) {
            loader = new WheelClassLoader(Thread.currentThread().getContextClassLoader());
            loader.setApplicationPackages((Set<String>)context.getAttribute("wheelApplicationPackages"));
            context.setAttribute("wheelClassLoader", loader);
        }
    }
}
