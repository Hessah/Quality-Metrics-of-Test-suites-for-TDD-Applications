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

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MultipartEngineImpl extends EngineImpl {
    private List<FileItem> uploadedFiles;

    public MultipartEngineImpl(HttpServletRequest request, HttpServletResponse response, ServletContext context) {
        super(request, response, context);
    }

    @Override
    protected Map readRequestParameters(HttpServletRequest request) {
        Map parameters = new HashMap();

        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);

        List items = null;
        try {
            items = upload.parseRequest(request);
        } catch (FileUploadException e) {
            throw new WheelException("Could not parse multipart request.", e, null);
        }

        for (int i = 0; i < items.size(); i++) {
            FileItem fileItem = (FileItem) items.get(i);

            if (fileItem.isFormField()) {
                if (parameters == null)
                    parameters = new HashMap();

                parameters.put(fileItem.getFieldName(), new String[]{fileItem.getString()});
            }
            else {
                if (uploadedFiles == null)
                    uploadedFiles = new LinkedList<FileItem>();

                uploadedFiles.add(fileItem);

                parameters.put(fileItem.getFieldName(), new String[]{FilenameUtils.getName(fileItem.getName())});
            }
        }

        return parameters;
    }

    public List<FileItem> getUploadedFiles() {
        return uploadedFiles;
    }
}


