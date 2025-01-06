package com.uem_automation.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utilities {

	public static final int IMPLICIT_WAIT_TIME = 10;
	public static final int PAGE_WAIT_TIME = 10;
	public static final int EXPLICIT_WAIT_TIME = 10;
	public static final int FLUENT_WAIT_TIME = 10;

	// class for creating random email with timestamp
	public static String generateEmailWithTimeStamp() {
		Date date = new Date();
		String dateText = date.toString();
		String dateTextWithoutSpaces = dateText.replace(" ", "_");
		return "prajwal" + dateTextWithoutSpaces + "@vdi.com";
	}

	// class for creating current timestamp string
	public static String generateTimeStamp() {
		Date date = new Date();
		String dateText = date.toString();
		String dateTextWithoutSpaces = dateText.replace(" ", "_"); // Tue_Nov_26_18:57:47_IST_2024
		String dateTextWithoutCollon = dateTextWithoutSpaces.replace(":", "_");
		return dateTextWithoutCollon;
	}

	// class for getting test data from excel for login
	public static Object[][] getTestDataFromExcel(String sheetName) {

		File excelFile = new File(System.getProperty("user.dir")
				+ ("\\src\\main\\java\\com\\uem_automation\\qa\\testdata\\UEM_AUTOMATION_TESTDATA.xlsx"));
		
		XSSFWorkbook workbook = null;
		
		try {
			FileInputStream fisExcel = new FileInputStream(excelFile);
			workbook = new XSSFWorkbook(fisExcel);
		} 
		catch (Throwable e) {
			e.printStackTrace();
		}
		
		XSSFSheet sheet = workbook.getSheet(sheetName);

		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getLastCellNum();

		Object[][] data = new Object[rows][cols];

		for (int i = 0; i < rows; i++) {
		
			XSSFRow row = sheet.getRow(i + 1);

			for (int j = 0; j < cols; j++) {
			
				XSSFCell cell = row.getCell(j);
				CellType cellType = cell.getCellType();

				switch (cellType) 
				{
				case STRING:
					data[i][j] = cell.getStringCellValue();
					break;
				case NUMERIC:
					data[i][j] = Integer.toString((int) cell.getNumericCellValue());
					break;
				case BOOLEAN:
					data[i][j] = cell.getBooleanCellValue();
					break;
				case FORMULA:
					data[i][j] = cell.getRawValue(); // string
					break;
				default:
					break;
				}
			}
		}
		return data;
	}
	
	// class for taking screenshot
	public static String captureScreenshot(WebDriver driver, String testName) {

		// take screenshot
		File srcScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationScreenshotPath = System.getProperty("user.dir") + "\\Screenshots\\" + testName
				+ ".png";

		try {
			FileHandler.copy(srcScreenshot, new File(destinationScreenshotPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return destinationScreenshotPath;

	}

	// getting test data from multiple sheets
	public static Object[][] getTestDataFromMultipleSheets(String[] sheetNames) {
		List<Object[]> allData = new ArrayList<>();

		for (String sheet : sheetNames) {
			Object[][] sheetData = getTestDataFromExcel(sheet);  // Assumes getTestDataFromExcel is a static method
			for (Object[] row : sheetData) {
				allData.add(row);
			}
		}

		return allData.toArray(new Object[0][0]);
	}
}
