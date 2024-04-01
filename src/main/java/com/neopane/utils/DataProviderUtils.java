package com.neopane.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

public class DataProviderUtils {
	
	public static List<Map<String, String>> list = new ArrayList<>();
	
	@DataProvider
	public static Object[] getData(Method m) {
		
		 String testCaseName = m.getName();
		 
		 if(list.isEmpty()) {
			 
			 list= ExcelDataUtils.getTestDetails("DATA");
		 }
		 
		 List<Map<String, String>> smallList = new ArrayList<>();
		 for( int i=0; i<list.size();i++) {
			 
			 if(list.get(i).get("TestCaseName").equalsIgnoreCase(testCaseName)  &&
			  list.get(i).get("Execute").equalsIgnoreCase("yes"))  {
					 
					 smallList.add(list.get(i));
				 }
			  
		 }
		 
	 
		 return smallList.toArray();
		 
	}

}
