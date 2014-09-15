package net.sf.lavalamp;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import org.apache.tools.ant.util.FileUtils;
import org.junit.Test;

public class AptTest {
	
	@Test
	public void config() throws IOException {
		Reader reader = new FileReader(new File("src/test/resources/test.yml"));
		
		Writer writer = new FileWriter(new File("src/site/apt/config.apt"));
		writer.write("------\n");
		writer.write(FileUtils.readFully(reader));
		writer.flush();
		writer.close();
	}
	
	


}
