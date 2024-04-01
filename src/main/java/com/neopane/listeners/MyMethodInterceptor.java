package com.neopane.listeners;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import com.neopane.constants.FrameworkConstants;
import com.neopane.utils.ExcelDataUtils;
import com.neopane.utils.ExcelUtils;

public class MyMethodInterceptor implements IMethodInterceptor{

	@Override
	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
		 
		 List<IMethodInstance> result = new ArrayList<>();
		 
		 List<Map<String, String>> list =  ExcelDataUtils.getTestDetails("RunManager");
	 	    
	 	 for(int i= 0; i<methods.size(); i++) {
			 
			 for( int j=0; j<list.size(); j++) {
			      if(methods.get(i).getMethod().getMethodName().equalsIgnoreCase(list.get(j).get("TestCaseName")) 
				    && list.get(j).get("Execute").equalsIgnoreCase("Yes")) {
					 
					 methods.get(i).getMethod().setInvocationCount(Integer.parseInt(list.get(j).get("Count")));
					 result.add(methods.get(i));
				 }
			  
			 
		   }
		 }
		
		return result;
	}

	 

}
