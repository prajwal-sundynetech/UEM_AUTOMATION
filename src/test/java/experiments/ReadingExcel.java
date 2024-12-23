package experiments;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingExcel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File excelFile = new File(System.getProperty("user.dir")
				+ ("\\src\\main\\java\\com\\uem_automation\\qa\\testdata\\UEM_AUTOMATION_TESTDATA.xlsx"));

		XSSFWorkbook workbook = null;

		try {
			FileInputStream fisExcel = new FileInputStream(excelFile);
			workbook = new XSSFWorkbook(fisExcel);
		} catch (Throwable e) {
			e.printStackTrace();
		}

		XSSFSheet sheet = workbook.getSheet("Template");

		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getLastCellNum();

		Object[][] data = new Object[rows][cols];

		for (int i = 0; i < rows; i++) {

			XSSFRow row = sheet.getRow(i + 1);

			for (int j = 0; j < cols; j++) {

				XSSFCell cell = row.getCell(j);
				CellType cellType = cell.getCellType();

				switch (cellType) {
				case STRING:
					data[i][j] = cell.getStringCellValue();
//					System.out.println(cell.getStringCellValue());
					break;
				case NUMERIC:
					data[i][j] = Integer.toString((int) cell.getNumericCellValue());
//					System.out.println(Integer.toString((int) cell.getNumericCellValue()));
					break;
				case BOOLEAN:
					data[i][j] = cell.getBooleanCellValue();
//					System.out.println(cell.getBooleanCellValue());
					break;
				default:
					break;
				}
				System.out.println(data[i][j]);
			}
		}
		
	}

}
