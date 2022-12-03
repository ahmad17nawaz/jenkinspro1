package vtiger.Practise;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class CreateContactAll {


	
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
					WebElement dropdown = driver.findElement(By.name("salutationtype"));
					Select s1 = new Select(dropdown);
					s1.selectByVisibleText("Mr.");
					
					Thread.sleep(3000);
					driver.findElement(By.xpath("//input[@class='detailedViewTextBox']")).sendKeys("Ahmed");			
					
					Thread.sleep(3000);
					driver.findElement(By.name("lastname")).sendKeys("Nawaaz");
						
					
					//Step 6: Choose any existing Organization
					driver.findElement(By.xpath("(//img[@align='absmiddle'])[3]")).click();
					
					
					String parentWin = driver.getWindowHandle();
					Set<String> childWin = driver.getWindowHandles();
				
					for(String winHandle:childWin) {
						
						driver.switchTo().window(winHandle);//switch to child window
					}
					driver.findElement(By.linkText("QSpider")).click();
				
					
					driver.switchTo().window(parentWin);//switch back to parent window
					
					//Other Actions on Parent page
					
					Thread.sleep(3000);
					WebElement dd2 = driver.findElement(By.name("leadsource"));
					Select s2=new Select(dd2);
					s2.selectByIndex(4);
					
					driver.findElement(By.id("department")).sendKeys("Testing");//department
					Thread.sleep(3000);
					driver.findElement(By.id("email")).sendKeys("Testing@gmail.com");//email id
					
					driver.findElement(By.id("mobile")).sendKeys("12345467890");//mobile no.
					
					JavascriptExecutor js =(JavascriptExecutor)driver;
					
					js.executeScript("window.scrollBy(0,5000)");
	
					driver.findElement(By.name("portal")).click();
					
				
					driver.findElement(By.xpath("(//textarea[@class='detailedViewTextBox'])[1]")).sendKeys("102, Park Circus, West");
					
					Thread.sleep(3000);
					driver.findElement(By.id("mailingcity")).sendKeys("Kolkata");
					
					Thread.sleep(3000);
					driver.findElement(By.id("mailingstate")).sendKeys("West Bengal");
					
					Thread.sleep(3000);
					driver.findElement(By.xpath("(//input[@name='cpy'])[2]")).click();
					
					
					js.executeScript("window.scrollBy(0,-5000)");
					
					Thread.sleep(3000);
					driver.findElement(By.id("jscal_trigger_birthday")).click();//birthday calendar
					Thread.sleep(3000);
					WebElement button = driver.findElement(By.xpath("//td[@class='button nav']/../td[1]"));//year button
					Thread.sleep(3000);
					for (int i=0; i < 29; i ++) {
						  button.click();
						}
					Thread.sleep(3000);
					WebElement butt2 = driver.findElement(By.xpath("//td[@class='button nav']/../td[2]"));//month button			
					Thread.sleep(3000);
					for (int j=0; j < 5; j ++) {
						
						  butt2.click();
						}
					Thread.sleep(3000);
					driver.findElement(By.xpath("//td[text()='21']/../td[2]")).click();
					
	
					
					//Step 7: Save
					driver.findElement(By.xpath("//input[@accesskey='S']")).click();
					
					//Step 8: Logout
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
