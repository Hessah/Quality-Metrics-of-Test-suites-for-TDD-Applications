package org.jbehave.core.reporters;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.custommonkey.xmlunit.XMLUnit;
import org.jbehave.core.i18n.LocalizedKeywords;
import org.jbehave.core.io.IOUtils;
import org.junit.Test;
import org.xml.sax.SAXException;

public class TemplateableOutputBehaviour {

    @Test
    public void shouldReportEventsToHtmlOutput() throws IOException {
        // Given
        File file = new File("target/story.html");
        StoryReporter reporter = new HtmlTemplateOutput(file, new LocalizedKeywords());

        // When
        StoryNarrator.narrateAnInterestingStory(reporter, true);

        // Then
        String expected = IOUtils.toString(new FileReader(new File("src/test/resources/story.html")), true);
        String out = IOUtils.toString(new FileReader(file), true);
        assertThatOutputIs(out, expected);
    }

    @Test
    public void shouldReportEventsToXmlOutput() throws IOException, SAXException {
        // Given
        File file = new File("target/story.xml");
        StoryReporter reporter = new XmlTemplateOutput(file, new LocalizedKeywords());

        // When
        StoryNarrator.narrateAnInterestingStory(reporter, true);

        // Then
        String expected = IOUtils.toString(new FileReader(new File("src/test/resources/story.xml")), true);
        String out = IOUtils.toString(new FileReader(file), true);

        // will throw SAXException if the xml file is not well-formed
        XMLUnit.buildTestDocument(out);
        assertThatOutputIs(out, expected);
    }

    private void assertThatOutputIs(String out, String expected) {
        assertEquals(dos2unix(expected), dos2unix(out));
    }

    private String dos2unix(String string) {
        return string.replace("\r\n", "\n");
    }

}
