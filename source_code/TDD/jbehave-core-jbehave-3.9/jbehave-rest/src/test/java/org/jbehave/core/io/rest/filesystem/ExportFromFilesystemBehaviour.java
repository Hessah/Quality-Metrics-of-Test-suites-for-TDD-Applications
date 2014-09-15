package org.jbehave.core.io.rest.filesystem;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.jbehave.core.io.rest.Resource;
import org.jbehave.core.io.rest.ResourceExporter;
import org.jbehave.core.io.rest.ResourceIndexer;
import org.jbehave.core.io.rest.ResourceUploader;
import org.jbehave.core.io.rest.filesystem.ExportFromFilesystem;
import org.junit.Test;

public class ExportFromFilesystemBehaviour {

    @Test
    public void canExportFromFilesystem() throws IOException {

        // Given
        ResourceIndexer indexer = mock(ResourceIndexer.class);
        ResourceUploader uploader = mock(ResourceUploader.class);
        String rootURI = "http://wiki";
        String text1 = "story1";
        String text2 = "story2";
        String sourcePath = "target/stories";
        String sourceExt = ".story";
        File file1 = new File(sourcePath + "/A_story" + sourceExt);
        write(text1, file1);
        File file2 = new File(sourcePath + "/Another_story" + sourceExt);
        write(text2, file2);
        String indexPath = "src/test/resources/redmine-index.json";
        String indexEntity = FileUtils.readFileToString(new File(indexPath));
        Map<String, Resource> index = new HashMap<String, Resource>();
        index.put("A_story", new Resource(rootURI + "/A_story"));
        index.put("Another_story", new Resource(rootURI + "/Another_story"));
        when(indexer.indexResources(rootURI, indexEntity)).thenReturn(index);

        // When
        ResourceExporter exporter = new ExportFromFilesystem(indexer, uploader, sourcePath, sourceExt, indexPath);
        exporter.exportResources(rootURI);

        // Then
        verify(uploader).uploadResourceAsText(rootURI + "/A_story", text1);
        verify(uploader).uploadResourceAsText(rootURI + "/Another_story", text2);
    }

    private void write(String text, File file) throws IOException {
        file.getParentFile().mkdirs();
        FileWriter w = new FileWriter(file);
        w.write(text);
        w.close();
    }

}
