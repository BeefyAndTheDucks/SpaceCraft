package com.spacecraftteam.spacecraft.util;

public class StringUtil {
	public static String uppercaseFirstLetter(String str) {
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}
}
