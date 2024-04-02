package com.neopane.utils;

import org.bouncycastle.util.encoders.Base64;

public final  class DecodeStringUtils {
	
	private DecodeStringUtils() {}
	
	public static String getDecodedString(String string) {
		
		return new String(Base64.decode(string));
	}

}
