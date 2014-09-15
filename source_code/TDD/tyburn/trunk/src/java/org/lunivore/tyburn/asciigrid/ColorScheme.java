package org.lunivore.tyburn.asciigrid;

import java.awt.Color;

public interface ColorScheme {

	public static final ColorScheme BLACK_ON_WHITE = new ColorScheme() {
		public char getCharRepresentationOf(int color) { return Color.BLACK.getRGB() == color ? 'X' : '.';  }
	};

	char getCharRepresentationOf(int color);

}
