package vtiger.Practise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateOrganisationTest {

	public static void main(String[] args) {
		
		//Step 1: Launch the browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://localhost:8888/");
		
		//Step 2: Login to the Application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("root");
		driver.findElement(By.id("submitButton")).click();
		
		//Step3 : Navigate to Organization Link
		driver.findElement(By.linkText("Organizations")).click();
		
		//Step 4: Click on create Organization Look up image
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		//Step 5: Create Organization with mandatory fields
		driver.findElement(By.name("accountname")).sendKeys("MyOffice");
		
		
		//Step 6: Save
		driver.findElement(By.name("button")).click();

	}

}
