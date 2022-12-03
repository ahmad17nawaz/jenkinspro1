package vtiger.Practise;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPractise {
	
	@Test
public void createCustomerTest()
	{
	//Assert.fail();
	System.out.println("customer created");//passed
	}	//failed
	
	@Test
	public void modifyCustomerTest()
	{
		//Assert.fail();
		System.out.println("customer modified");
	}
	
	@Test(enabled = false)
	public void deleteCustomerTest()
	{
		//Assert.fail();
		System.out.println("custromer deleted");
	}
}
