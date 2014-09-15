package org.lunivore.tyburn.asciigrid;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import org.junit.Test;

public class ImageToAsciiGridConverterBehaviour {
	private static final String NL = System.getProperty("line.separator");

	@Test
	public void shouldRenderAGridAsAscii() {
		// Given
		BufferedImage image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_BGR);
		Graphics2D graphics = image.createGraphics();
		
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, 100, 100);
		
		graphics.setColor(Color.BLACK);
		graphics.fillRect(20, 20, 20, 20);
		graphics.fillRect(60, 80, 20, 20);
		
		// When
		String asciiGrid = new ImageToAsciiGridConverter(ColorScheme.BLACK_ON_WHITE).convert(image, 20);
		
		// Then
		assertThat(asciiGrid, equalTo(
				"....." + NL +
				".X..." + NL +
				"....." + NL +
				"....." + NL +
				"...X."
				));
		
		// When (half the scale)
		asciiGrid = new ImageToAsciiGridConverter(ColorScheme.BLACK_ON_WHITE).convert(image, 10);
		
		// Then
		assertThat(asciiGrid, equalTo(
				".........." + NL +
				".........." + NL +
				"..XX......" + NL +
				"..XX......" + NL +
				".........." + NL +
				".........." + NL +
				".........." + NL +
				".........." + NL +
				"......XX.." + NL +
				"......XX.."
				));
	}
}
