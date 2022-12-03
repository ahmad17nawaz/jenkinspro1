package vtiger.Practise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateContactScenario2 {

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
				
				//Step3 : Navigate to Contact Link
				driver.findElement(By.linkText("Contacts")).click();
				
				//Step 4: Click on create Contact Look up image
				driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
				
				//Step 5: Create Contact with mandatory fields
				
				
				Thread.sleep(3000);
				driver.findElement(By.name("lastname")).sendKeys("Nawaz");
				
				
				//Step 6: Save
				driver.findElement(By.xpath("//input[@accesskey='S']")).click();
				
				//Step 7: Logout
				Thread.sleep(3000);
				WebElement hov = driver.findElement(By.xpath("(//img[contains(@style,'padding')])[1]"));
				 Actions a = new Actions(driver);
				 Thread.sleep(3000);
				 a.moveToElement(hov).perform();
				 Thread.sleep(3000);
				driver.findElement(By.linkText("Sign Out")).click();
				
				
				String title=driver.getTitle();
				System.out.println(title);
				
				String url=driver.getCurrentUrl();
				System.out.println(url);
				
				 if(url.equals("http://localhost:8888/index.php?action=Login&module=Users")) {
					 System.out.println("Pass:Successfully contact saved and logout");
				 }
				 else {
					 System.out.println("failed");    
				 }
	}
}
				 

	
