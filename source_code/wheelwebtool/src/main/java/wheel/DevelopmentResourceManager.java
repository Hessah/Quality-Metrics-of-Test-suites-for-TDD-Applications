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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import wheel.enhance.WheelClassLoader;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;

public class DevelopmentResourceManager extends DefaultResourceManager {
    private final Logger log = LoggerFactory.getLogger(DevelopmentResourceManager.class);
    private File root;

    public DevelopmentResourceManager(ServletContext context) {
        super(context);

        root = new File(context.getRealPath("/"));

        scanForUpdates();
    }


    @Override
    protected Set getResources(String path) {
        Set result = new HashSet();

        if (root != null) {
            File f = new File(root.getAbsolutePath() + path);
            File[] files = f.listFiles();

            if (files == null)
                return result;

            for (int i = 0; i < files.length; i++) {
                File file = files[i];

                if (file.getName().startsWith("."))
                    continue;

                if (file.isDirectory())
                    result.add(path + file.getName() + "/");
                else
                    result.add(path + file.getName());
            }
        }

        return result;
    }

    @Override
    public InputStream loadAsset(String path) {
        if (path.startsWith("file/")) {
            try {
                return new FileInputStream(root.getAbsolutePath() + "/" + path.replace("file/", ""));
            } catch (FileNotFoundException e) {
                throw new WheelException("Could not find asset.", e, null);
            }
        }

        return loader.getResourceAsStream(path);
    }

    @Override
    protected void createClassLoader() {
        loader = (WheelClassLoader)context.getAttribute("wheelClassLoader");

        if (loader == null) {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

            loader = new WheelClassLoader(getClassPathUrls(), classLoader);
            loader.setApplicationPackages((Set<String>)context.getAttribute("wheelApplicationPackages"));
            context.setAttribute("wheelClassLoader", loader);
        }
    }

    private void scanForUpdates() {
        boolean updated = false;
        long lastModified = 0L;

        Long lastModifiedL = (Long)context.getAttribute("wheelLastUpdate");

        if (lastModifiedL != null)
            lastModified = lastModifiedL.longValue();

        if ((System.currentTimeMillis() - lastModified) < 500)
            return;

        updated = hasBeenModified(new File(root.getAbsolutePath() + "/" + context.getAttribute("wheelCssPath")), lastModified);

        if (!updated)
            updated = hasBeenModified(new File(root.getAbsolutePath() + "/" + context.getAttribute("wheelJsPath")), lastModified);


        if (!updated) {
            URL[] urls = getClassPathUrls();

            for (int i = 0; i < urls.length; i++) {
                try {
                    updated = hasBeenModified(new File(urls[i].toURI()), lastModified);

                    if (updated)
                        break;
                } catch (URISyntaxException e) {
                    log.error("Could not check location for update.", e);
                }
            }
        }

        if (updated) {
            log.info("Reloading application...");

            context.setAttribute("wheelAssetCache", null);

            Enumeration contextKeys = context.getAttributeNames();
            List<String> toBeRemoved = new LinkedList<String>();

            if (contextKeys != null) {
                while (contextKeys.hasMoreElements()) {
                    String key = (String) contextKeys.nextElement();

                    if (key.startsWith("wheelMessagesCache"))
                        toBeRemoved.add(key);
                }
            }

            for (String key : toBeRemoved) {
                context.removeAttribute(key);
            }

            context.setAttribute("wheelClassLoader", null);
            createClassLoader();
            context.setAttribute("wheelLastUpdate", new Long(System.currentTimeMillis()));
        }
    }

    private boolean hasBeenModified(File file, long lastModified) {
        if (!file.isDirectory()) {
            if (file.lastModified() > lastModified) {
                return true;
            }

            return false;
        }

        File[] ls = file.listFiles();

        for (int i = 0; i < ls.length; i++) {
            File f = ls[i];

            if (hasBeenModified(f, lastModified))
                return true;
        }

        return false;
    }

    private URL[] getClassPathUrls() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        if (classLoader instanceof URLClassLoader) {
            URLClassLoader urlClassLoader = (URLClassLoader)classLoader;

            return urlClassLoader.getURLs();
        }
        else {
            try {
                return new URL[] {context.getResource("/WEB-INF/classes/"), context.getResource("/WEB-INF/lib/")};
            } catch (MalformedURLException e) {
                log.error("Could not resolve WEB-INF/classes or WEB-INF/lib", e);
            }
        }

        throw new WheelException("Could not resolve classpath for development mode. It might be that the servlet container that you're using doesn't work with Wheel's development mode.", null);
    }
}
 