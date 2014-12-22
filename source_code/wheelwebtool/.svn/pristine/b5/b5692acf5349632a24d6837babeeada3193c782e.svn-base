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
package wheel.components;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.io.FilenameUtils;
import wheel.MultipartEngineImpl;
import wheel.WheelException;
import wheel.util.FileUploadMetadata;

import java.io.File;

//todo documentation
public class FileInput extends FormElement {
    private int maxMemoryFileSize = 1000;
    private String tempFileLocation = System.getProperty("java.io.tmpdir");
    private int maxRequestSize = 1000;

    private ElExpression metadataBind;

    FileInput(Component parent, String elementName, String componentId) {
        super(parent, elementName, componentId);

        attribute("type", "file");
    }

    public String defaultTagName() {
        return "input";
    }

    public int getMaxMemoryFileSize() {
        return maxMemoryFileSize;
    }

    public void setMaxMemoryFileSize(int maxMemoryFileSize) {
        this.maxMemoryFileSize = maxMemoryFileSize;
    }

    public String getTempFileLocation() {
        return tempFileLocation;
    }

    public void setTempFileLocation(String tempFileLocation) {
        this.tempFileLocation = tempFileLocation;
    }

    public int getMaxRequestSize() {
        return maxRequestSize;
    }

    public void setMaxRequestSize(int maxRequestSize) {
        this.maxRequestSize = maxRequestSize;
    }

    public void setMetadataBind(ElExpression metadataBind) {
        this.metadataBind = metadataBind;
    }

    @Override
    public void _setSubmitValue(String[] value) {
        this.value = value;

        super.validate();

        if (!isValid())
            return;
        
        MultipartEngineImpl multipartServer = (MultipartEngineImpl) getEngine();

        if (multipartServer.getUploadedFiles() != null) {

            for (FileItem fileItem : multipartServer.getUploadedFiles()) {
                if (fileItem.getFieldName().equals(getComponentId())) {
                    ElExpression binding = (ElExpression)getBinding();
                    if (metadataBind != null)
                        metadataBind.store(_getTopLevelComponent(true), this, new FileUploadMetadata(FilenameUtils.getName(fileItem.getName()), fileItem.getContentType(), fileItem.getSize()));

                    
                    Object target = binding.eval(_getTopLevelComponent(true), this);

                    if (target != null && (target instanceof File)) {
                        File file = (File)target;

                        if (file != null) {
                            try {
                                fileItem.write(file);
                            } catch (Exception e) {
                                throw new WheelException("Could not write uploaded file to '" + file.getPath() + "'", e, this);
                            }
                        }
                    }
                    else {
                        try {
                            binding.store(_getTopLevelComponent(true), this, fileItem.getInputStream());
                        } catch (Exception e) {
                            try {
                                File file = new File(tempFileLocation + "/" + FilenameUtils.getName(fileItem.getName()));
                                binding.store(_getTopLevelComponent(true), this, file);
                                fileItem.write(file);
                            } catch (Exception e1) {
                                try {
                                    binding.store(_getTopLevelComponent(true), this, fileItem.get());
                                } catch (Exception e2) {
                                    throw new WheelException("Could not bind file upload. Supported binding types are java.io.File, java.io.InputStream and byte[]", e2, this);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
