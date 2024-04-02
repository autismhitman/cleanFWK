package com.neopane.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.neopane.exceptions.FrameworkException;
import com.neopane.exceptions.InvalidPathForExcelException;

public final class ExcelUtils {

	   XSSFWorkbook book;

	   XSSFSheet sheet;

	public ExcelUtils(String path) {

		 
		File file = new File(path);
		 
		try(FileInputStream fis=new FileInputStream(file)) {
			 
			book = new XSSFWorkbook(fis);
			
		} catch (FileNotFoundException e) {

		    throw new InvalidPathForExcelException("File path not found ");
		} catch (IOException e) {

			 throw new FrameworkException("Some IO exception");
		}

	}

	public  int getTotalRow(String name) {
		sheet = book.getSheet(name);
		 
		return sheet.getLastRowNum();
	}

	public  int getTotalColumn(String name) {
		sheet = book.getSheet(name);

		return sheet.getRow(0).getLastCellNum();
	}

	public String readData(int row, int col) {

		return sheet.getRow(row).getCell(col).getStringCellValue();
	}

}
