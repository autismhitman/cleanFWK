package com.neopane.listeners;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import com.neopane.constants.FrameworkConstants;
import com.neopane.utils.ExcelUtils;

public class MyMethodInterceptor implements IMethodInterceptor{

	@Override
	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
		 
		 List<IMethodInstance> result = new ArrayList<>();
		 
		 List<Map<String, String>> list =  getTestDetails();
	 	    
	 	 for(int i= 0; i<methods.size(); i++) {
			 
			 for( int j=0; j<list.size(); j++) {
			      if(methods.get(i).getMethod().getMethodName().equalsIgnoreCase(list.get(j).get("TestCaseName"))) {
				 
				 if(list.get(j).get("Execute").equalsIgnoreCase("Yes")) {
					 
					 methods.get(i).getMethod().setInvocationCount(Integer.parseInt(list.get(j).get("Count")));
					 result.add(methods.get(i));
				 }
			 }
			 
		   }
		 }
		
		return result;
	}

	private List<Map<String, String>> getTestDetails( ) {
		 List<Map<String, String>> list = new ArrayList<>();
	     ExcelUtils ex = new ExcelUtils(FrameworkConstants.getExcelPath());
		 int row = ex.getTotalRow("RunManager");
		 int col = ex.getTotalColumn("RunManager");
		 
		 Map<String, String> hmap = null;
		 
		 for( int i=1; i<=row; i++) {
			 hmap = new HashMap<>();
			 for( int j= 0; j<col; j++) {
				 
				 String key = ex.readData(0, j);
				 String value = ex.readData(i, j);
				 hmap.put(key, value);
			 }
			 list.add(hmap);
		 }
		 
		 return list;
	}

}
