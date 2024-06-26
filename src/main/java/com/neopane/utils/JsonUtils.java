package com.neopane.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.neopane.constants.FrameworkConstants;
import com.neopane.enums.ConfigProperties;
import com.neopane.exceptions.JsonFileUsageException;

public final  class  JsonUtils {
	
	
	private JsonUtils() {}
	
	
	private static Map<String, String> CONFIG_MAP = new HashMap<>();
	
	 
    static {
    	try(FileInputStream fis = new FileInputStream(FrameworkConstants.getJsonConfigPath())) {
    		
    		CONFIG_MAP = new ObjectMapper().readValue(fis, new TypeReference<HashMap<String, String>>(){});
 
    	}
    	 
    	catch(IOException e) {
    		   e.printStackTrace();
    		    System.exit(0);    	
    		 }
   }
    
    
    public static String get(ConfigProperties key) {
    	
    	 if(Objects.isNull(key)|| Objects.isNull(CONFIG_MAP.get(key.name().toLowerCase()))) {
    		 throw new JsonFileUsageException(" The Propertry name " +key + "is not found!, please check");
    	 }
		return CONFIG_MAP.get(key.name().toLowerCase());
    }

}
