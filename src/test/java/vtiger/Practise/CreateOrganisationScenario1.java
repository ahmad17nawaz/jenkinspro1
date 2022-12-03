package vtiger.Practise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateOrganisationScenario1 {

	public static void main(String[] args) throws InterruptedException {
	
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
				driver.findElement(By.name("accountname")).sendKeys("Qsp");
				WebElement dropdown = driver.findElement(By.xpath("//select[@name='industry']"));
				Select s = new Select(dropdown);
			    s.selectByIndex(8);
				
				/*List<WebElement> option = s.getOptions();
				System.out.println(option.size());
				for(WebElement b:option)
				{
					System.out.println(b.getText());
				}
				*/
				
				//Step 6: Save
				driver.findElement(By.name("button")).click();
				
				//Step 7: Logout
				Thread.sleep(3000);
				WebElement hov = driver.findElement(By.xpath("(//img[contains(@style,'padding')])[1]"));
				 Actions a = new Actions(driver);
				 Thread.sleep(3000);
				 a.moveToElement(hov).perform();
				 Thread.sleep(3000);
				driver.findElement(By.linkText("Sign Out")).click();
				 
				 driver.close();
				 System.out.println("Organizations created");

	}

}
