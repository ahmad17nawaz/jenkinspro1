package vtiger.Practise;

import java.io.IOException;

import org.openqa.selenium.WebElement;

import vtiger.GenericUtility.ExcelFileUtility;
import vtiger.GenericUtility.JavaUtility;
import vtiger.GenericUtility.PropertyFileUtility;
import vtiger.GenericUtility.WebDriverUtility;

public class GenericUtilityPractise {

	public static void main(String[] args) throws IOException {
	
		JavaUtility jLib = new JavaUtility();
		 int random = jLib.getRandomNumber();
		System.out.println(random);
		
		String date = jLib.getSystemDate();
		System.out.println(date);
		
		String d = jLib.getSystemDateInFormat();
		System.out.println(d);
		
		PropertyFileUtility pLib = new PropertyFileUtility();
		String browser = pLib.readDataFromPFile("browser");
		System.out.println(browser);
		
		ExcelFileUtility eLib = new ExcelFileUtility();
		String orgName = eLib.readDataFromExcel("organization", 4, 3);
		System.out.println(orgName);
		eLib.writeDataIntoExcel("organization", 4, 6,"Nawaz");
		System.out.println("data written");
		

	
	}
	
}
