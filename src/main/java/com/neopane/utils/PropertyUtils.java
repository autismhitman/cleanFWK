package com.neopane.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import com.neopane.constants.FrameworkConstants;
import com.neopane.enums.ConfigProperties;

public final  class  PropertyUtils {
	
	
	private PropertyUtils() {}
	
	private static Properties prop = new Properties();
	private static final  Map<String, String> CONFIG_MAP = new HashMap<>();
	
	 
    static {
    	try {
    		FileInputStream fis = new FileInputStream(new File(FrameworkConstants.getConfigPath()));
    		
    		 prop.load(fis);
    		 
    		 prop.entrySet().forEach(entry->CONFIG_MAP.put(String.valueOf(entry.getKey()),String.valueOf(entry.getValue()).trim()));
    		
    	}
    	catch(FileNotFoundException e) {
    		 e.printStackTrace();
    	}
    	catch(IOException e) {
   		 e.printStackTrace();
   	}
   }
    
    
    public static String get(ConfigProperties key) {
    	
    	 if(Objects.isNull(key)|| Objects.isNull(CONFIG_MAP.get(key.name().toLowerCase()))) {
    		 throw new RuntimeException(" The Propertry name " +key + "is not found!, please check");
    	 }
		return CONFIG_MAP.get(key.name().toLowerCase());
    }
	
 /*	public static String getValue(String key)  {
		
		  if(Objects.isNull(key)|| Objects.isNull(prop.getProperty(key))) {
	        	 throw new RuntimeException(" The Propertry name " +key + "is not found!, please check");
	         }
	         else {
	        	 return prop.getProperty(key);
	         }
	         
	    } 
	*/   
		
		
		
		
	 

}
