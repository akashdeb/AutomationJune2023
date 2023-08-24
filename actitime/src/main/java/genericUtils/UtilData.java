package genericUtils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class UtilData {
	
	
	public String fetchStringDataFromExcel(String sheetName, int row, int cell) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream("C:\\Users\\User\\Desktop\\Scripts\\eclipse-workspace_SatJuly2023\\Automation10am\\testData\\actitimeTestData.xlsx");
		
		return WorkbookFactory.create(fis).getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
		
	}
	
	public double fetchNumericDataFromExcel(String sheetName, int row, int cell) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream("C:\\Users\\User\\Desktop\\Scripts\\eclipse-workspace_SatJuly2023\\Automation10am\\testData\\actitimeTestData.xlsx");
		
		return WorkbookFactory.create(fis).getSheet(sheetName).getRow(row).getCell(cell).getNumericCellValue();
		
	}

}
