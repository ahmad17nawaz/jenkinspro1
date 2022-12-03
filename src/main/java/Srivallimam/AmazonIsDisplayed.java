package Srivallimam;

	import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

	public class AmazonIsDisplayed {

		public static void main(String[] args) {


			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.amazon.com/");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			WebElement logo = driver.findElement(By.id("keepLoggedInCheckBox"));
	System.out.println(logo.isDisplayed());
			if(logo.isDisplayed()) {
				System.out.println("Pass:Logo Displayed");
			}
			else
			{
				System.out.println("Fail:Logo is not displayed");
			}
			//driver.quit();
		}
	}

}
