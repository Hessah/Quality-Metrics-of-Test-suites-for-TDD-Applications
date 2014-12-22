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
package wheel.testing;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

public class MockHttpServletResponse implements HttpServletResponse {
    private MockServletOutputStream outputStream;
    private DocumentBuilder docBuilder;
    private String redirectTarget;

    public void addCookie(Cookie cookie) {
    }

    public boolean containsHeader(String string) {
        return false;
    }

    public String encodeURL(String string) {
        return string;
    }

    public String encodeRedirectURL(String string) {
        return string;
    }

    public String encodeUrl(String string) {
        return string;
    }

    public String encodeRedirectUrl(String string) {
        return string;
    }

    public void sendError(int i, String string) throws IOException {
    }

    public void sendError(int i) throws IOException {
    }

    public void sendRedirect(String string) throws IOException {
        redirectTarget = string;
    }

    public void setDateHeader(String string, long l) {
    }

    public void addDateHeader(String string, long l) {
    }

    public void setHeader(String string, String string1) {
    }

    public void addHeader(String string, String string1) {
    }

    public void setIntHeader(String string, int i) {
    }

    public void addIntHeader(String string, int i) {
    }

    public void setStatus(int i) {
    }

    public void setStatus(int i, String string) {
    }

    public String getCharacterEncoding() {
        return "UTF-8";
    }

    public String getContentType() {
        return "text/html";
    }

    public ServletOutputStream getOutputStream() throws IOException {
        if (outputStream == null) {
            outputStream = new MockServletOutputStream();
        }

        return outputStream;
    }

    public PrintWriter getWriter() throws IOException {
        return null;
    }

    public void setCharacterEncoding(String string) {
    }

    public void setContentLength(int i) {
    }

    public void setContentType(String string) {
    }

    public void setBufferSize(int i) {
    }

    public int getBufferSize() {
        return 0;
    }

    public void flushBuffer() throws IOException {
        if (outputStream != null)
            outputStream.output.reset();
    }

    public void resetBuffer() {
        if (outputStream != null)
            outputStream.output.reset();
    }

    public boolean isCommitted() {
        return false;
    }

    public void reset() {
        if (outputStream != null)
            outputStream.output.reset();
    }                                               

    public void setLocale(Locale locale) {
    }

    public Locale getLocale() {
        return Locale.getDefault();
    }

    public void resetMock() {
        if (outputStream != null)
            outputStream.output.reset();

        redirectTarget = null;
    }

    public String getRedirectTarget() {
        return redirectTarget;
    }

    public Document getResponseAsDocument() throws IOException, SAXException {
        if (docBuilder == null) {
            try {
                docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            }
        }

        docBuilder.reset();

        return docBuilder.parse(new ByteArrayInputStream(outputStream.output.toByteArray()));
    }

    public String getResponseAsString() {
        return outputStream.output.toString();
    }

    private class MockServletOutputStream extends ServletOutputStream {
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        @Override
        public void print(String s) throws IOException {
            output.write(s.getBytes());
        }

        @Override
        public void print(boolean b) throws IOException {
            output.write(b ? "true".getBytes() : "false".getBytes());
        }

        @Override
        public void print(char c) throws IOException {
            output.write(c);
        }

        @Override
        public void print(int i) throws IOException {
            output.write(i);
        }

        @Override
        public void print(long l) throws IOException {
            output.write(new Long(l).byteValue());
        }

        @Override
        public void print(float v) throws IOException {
            output.write(new Float(v).byteValue());
        }

        @Override
        public void print(double v) throws IOException {
            output.write(new Double(v).byteValue());
        }

        @Override
        public void println() throws IOException {
            output.write("\n".getBytes());
        }

        @Override
        public void println(String s) throws IOException {
            output.write((s + "\n").getBytes());
        }

        @Override
        public void println(boolean b) throws IOException {
            output.write(b ? "true\n".getBytes() : "false\n".getBytes());
        }

        @Override
        public void println(char c) throws IOException {
            output.write((c + "\n").getBytes());
        }

        @Override
        public void println(int i) throws IOException {
            output.write((i + "\n").getBytes());
        }

        @Override
        public void println(long l) throws IOException {
            output.write((l + "\n").getBytes());
        }

        @Override
        public void println(float v) throws IOException {
            output.write((v + "\n").getBytes());
        }

        @Override
        public void println(double v) throws IOException {
            output.write((v + "\n").getBytes());
        }

        @Override
        public void write(byte[] bytes) throws IOException {
            output.write(bytes);
        }

        @Override
        public void write(byte[] bytes, int i, int i1) throws IOException {
            output.write(bytes, i, i1);
        }

        @Override
        public void flush() throws IOException {
            //output.flush();
        }

        @Override
        public void close() throws IOException {
            //output.close();
        }

        public void write(int i) throws IOException {
            output.write(i);
        }

    }
}


