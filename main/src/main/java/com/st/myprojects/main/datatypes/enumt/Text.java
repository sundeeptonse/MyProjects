/**
 * 
 */
package com.st.myprojects.main.datatypes.enumt;

import java.util.EnumSet;
import java.util.Set;

/**
 * @author sundeeptonse
 * Usage of EnumSet , basically a set of Enum's
 */
public class Text {

	public enum Style {
		BOLD, ITALIC, UNDERLINE, STRIKETHROUGH
	}

	public void applyStyles(Set<Style> styles) {
		for(Style style : styles){
			System.out.println("Styles:" + style);
		}
	}

	public static void main(String... args) {
		Text text = new Text();
		text.applyStyles(EnumSet.of(Style.BOLD, Style.ITALIC));
	}

}
