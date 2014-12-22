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
package wheel.util;

import java.io.*;

public class ProjectCreator {
    private static String projectNameS;
    private static String basePackageS;
    private static String type;
    private static String baseDir;
    private static String webAppDir;


    public static void main(String[] args) throws IOException {
        projectNameS = args[0];
        basePackageS = args[1];
        type = args[2];

        baseDir = new File("").getAbsolutePath().replace("\\", "\\\\");

        if (type.equals("simple")) {
            webAppDir = ".";
            processFile(".project");
            processFile("build.xml");
            processFile("src/Home.java");

            new File("src/" + basePackageS.replace('.', '/') + "/" + projectNameS + "/pages").mkdirs();
            new File("src/" + basePackageS.replace('.', '/') + "/" + projectNameS + "/pages/Home.java").createNewFile();

            copyFile("src/Home.java", "src/" + basePackageS.replace('.', '/') + "/" + projectNameS + "/pages/Home.java");

            new File("pom.xml").delete();
        }
        else if (type.equals("maven2")) {
            webAppDir = "src/main/webapp";
            processFile("pom.xml");
            processFile("src/Home.java");
            
            new File("src/main/java/" + basePackageS.replace('.', '/') + "/" + projectNameS + "/pages").mkdirs();
            new File("src/main/java/" + basePackageS.replace('.', '/') + "/" + projectNameS + "/pages/Home.java").createNewFile();

            copyFile("src/Home.java", "src/main/java/" + basePackageS.replace('.', '/') + "/" + projectNameS + "/pages/Home.java");

            new File("build.xml").delete();
        }

        processFile("jetty.launch");
        processFile("src/Home.java");
        processFile("WEB-INF/web.xml");

        new File("src/Home.java").delete();
    }

    private static void processFile(String file) throws IOException {
        FileInputStream in = new FileInputStream(file);

        int read = 0;
        byte[] buf = new byte[2048];

        ByteArrayOutputStream bout = new ByteArrayOutputStream();

        while((read = in.read(buf)) > 0)
            bout.write(buf, 0, read);

        in.close();

        String converted = bout.toString().replaceAll("@project.name@", projectNameS).replaceAll("@base.package@", basePackageS).replaceAll("@base.dir@", baseDir).replaceAll("@webapp.dir@", webAppDir).replaceAll("path=\"target/classes\"", "path=\"src/main/webapp/WEB-INF/classes\"");
        FileOutputStream out = new FileOutputStream(file);
        out.write(converted.getBytes());
        out.close();

    }

    private static void copyFile(String from, String to) throws IOException {
        FileReader in = new FileReader(from);
        FileWriter out = new FileWriter(to);
        int c;

        while ((c = in.read()) != -1)
            out.write(c);

        in.close();
        out.close();
    }
}
