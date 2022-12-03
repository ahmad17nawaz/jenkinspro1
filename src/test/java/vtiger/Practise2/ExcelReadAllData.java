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

public class ExcelReadAllData {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = new FileInputStream("./ExcelPractise.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
	
		Sheet sht = wb.getSheet("Sheet1");
		
		long rowcount = sht.getLastRowNum()-sht.getFirstRowNum();
		
		for(int i=0;i<=rowcount;i++)
		{
			
			long cellcount = sht.getRow(i).getLastCellNum();
			
			System.out.println("Row"+ i +" data is : ");
			
			for(int j=0;j<cellcount;j++)
			{
				System.out.print(sht.getRow(i).getCell(j).getStringCellValue() +",");	
			}
			System.out.println();
		}		
		}
		}
