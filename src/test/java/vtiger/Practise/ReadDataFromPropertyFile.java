package vtiger.Practise;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFile {

	public static void main(String[] args) throws IOException
 {
	
		//Step 1: Load the file location into file input stream
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		
		//Step 2: Create an object of properties
		Properties pobj=new Properties();
		
		//Step 3: Load the data into properties
		pobj.load(fis);
		
		//Step 4: Use the key and read the value
		String BROWSER = pobj.getProperty("browser");
		System.out.println(BROWSER);
		
		String URL=pobj.getProperty("url");
		System.out.println(URL);
	}

}
 