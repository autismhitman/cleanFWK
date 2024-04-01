package com.neopane.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.neopane.constants.FrameworkConstants;

public class ExcelDataUtils {
 
	
	public static List<Map<String, String>> getTestDetails(String sheetName ) {
		 List<Map<String, String>> list = new ArrayList<>();
	     ExcelUtils ex = new ExcelUtils(FrameworkConstants.getExcelPath());
		 int row = ex.getTotalRow(sheetName );
		 int col = ex.getTotalColumn(sheetName );
		 
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
