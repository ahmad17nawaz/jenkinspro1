package vtiger.Practise;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		//Step 1: Load the location of the file to file input
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		//Step 2: Create a work book
		Workbook wb = WorkbookFactory.create(fis);
		
		//Step 3: Get into sheet
		Sheet sh = wb.getSheet("Organization");
		
		//Step 4: Get into the row
		Row row = sh.getRow(4);
		
		//Step 5: Get into the cell
		Cell cell = row.getCell(3);
		
		//Step 6: Read the value present in the cell
         String value = cell.getStringCellValue();
         System.out.println(value);
	}

}
