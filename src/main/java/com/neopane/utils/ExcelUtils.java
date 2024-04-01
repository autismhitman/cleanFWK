package com.neopane.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public final class ExcelUtils {

	public static XSSFWorkbook book;

	public static XSSFSheet sheet;

	public ExcelUtils(String path) {

		 
		File file = new File(path);
		FileInputStream fis;
		try {
			fis = new FileInputStream(file);
			book = new XSSFWorkbook(fis);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public int getTotalRow(String name) {
		sheet = book.getSheet(name);
		 
		return sheet.getLastRowNum();
	}

	public int getTotalColumn(String name) {
		sheet = book.getSheet(name);

		return sheet.getRow(0).getLastCellNum();
	}

	public String readData(int row, int col) {

		return sheet.getRow(row).getCell(col).getStringCellValue();
	}

}
