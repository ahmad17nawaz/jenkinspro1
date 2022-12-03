package vtiger.Practise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PractisePropertyFile {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = new FileInputStream("./Practise.properties");
		
		Properties p= new Properties();
		
		p.load(fis);
		
		 String NAME = p.getProperty("Name");
		 System.out.println(NAME);
		
		String AGE = p.getProperty("Age");
		System.out.println(AGE);
		String LOCATION = p.getProperty("Location");
		System.out.println(LOCATION);
	}

}
