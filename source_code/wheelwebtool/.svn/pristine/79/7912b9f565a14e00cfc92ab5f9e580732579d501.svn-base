package functional.forms;

import functional.BaseTestPage;

import java.io.*;

import wheel.util.FileUploadMetadata;

public class FileInput extends BaseTestPage {
    private byte[] file1;
    private InputStream file2;
    private File file3;
    private FileUploadMetadata metadata;

    public void buildComponent() {
        form("fileInputForm").
                fileInput("file1").fieldBinding("file1").end().
                fileInput("file2").fieldBinding("file2").end().
                fileInput("file3", el("metadata")).fieldBinding("file3");


        if (file1 != null)
            h1(new String(file1));

        if (file2 != null) {
            byte[] inB = new byte[256];
            int read = 0;

            try {
                read = file2.read(inB);
            } catch (IOException e) {}

            h2(new String(inB, 0, read));
        }

        if (file3 != null) {
            try {
                InputStream in = new FileInputStream(file3);

                byte[] inB = new byte[256];
                int read = 0;

                try {
                    read = in.read(inB);
                } catch (IOException e) {}

                h3(new String(inB, 0, read));
                h4(metadata.getFileName());
                h4(metadata.getSize());
                h4(metadata.getContentType());
            } catch (FileNotFoundException e) {}
        }
    }
}
