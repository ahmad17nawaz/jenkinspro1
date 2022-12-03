package vtiger.Practise;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractise {
	
	@Test(dataProvider = "phoneData")//read the data of data provider in test script
	public void addPhonesToCartTest(String name, int price)//Store the data in variables
	{
		System.out.println(name+" -> "+price);
	}
	
	//create data provider and load the values
	@DataProvider(name = "phoneData")  //Object is the return type of @DataProvider
	public Object[][]getData()//method name can be anything
	{							  
								//row //column count
		Object[][] data = new Object[3][2];
		
		data[0][0] = "Samsung A71";// hardcoding
		data[0][1] = 28000;
		
		data[1][0] = "IPhone";
		data[1][1] = 50000;
		
		data[2][0] = "Vivo";
		data[2][1] = 16000;
		
		return data;
	}
	
	@DataProvider(name = "brandData")  //Object is the return type of @DataProvider
	public Object[][]getData1()//method name can be anything
	{
		Object[][] data = new Object[3][2];
		
		data[0][0] = "Samsung A71";
		data[0][1] = 28000;
		
		data[1][0] = "IPhone";
		data[1][1] = 50000;
		
		data[2][0] = "Vivo";
		data[2][1] = 16000;
		
		return data;
	}
}
