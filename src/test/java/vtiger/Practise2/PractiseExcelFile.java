package vtiger.Practise2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class PractiseExcelFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream("./ExcelPractise.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
	
		Sheet sht = wb.getSheet("Sheet1");
		
		Row r = sht.getRow(0);
		
		Cell c = r.getCell(0);
		
		String value = c.getStringCellValue();
		
		System.out.println(value);
		
		
		
		
	}
	
}
