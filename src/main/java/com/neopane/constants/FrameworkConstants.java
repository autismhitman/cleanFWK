package com.neopane.constants;

public final class FrameworkConstants {

	private FrameworkConstants() {
	}

	private static final String CONFIG_PATH = System.getProperty("user.dir")
			+ "//src//test//resources//config//config.properties";

	private static final String JSONCONFIG_PATH = System.getProperty("user.dir")
			+ "//src//test//resources//config//config2.json";

	public static String getConfigPath() {

		return CONFIG_PATH;
	}

	public static String getJsonConfigPath() {

		return JSONCONFIG_PATH ;
	}

}
