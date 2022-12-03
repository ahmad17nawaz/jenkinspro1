package Srivallimam;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OlympicsLogoisDisplayedOrNot {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.actitime.com/login.do");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement checkBox = driver.findElement(By.id("keepLoggedInCheckBox"));
	if(checkBox.isSelected())
		System.out.println("Pass:Selected");
	else
		System.out.println("Failed:Not Selected");
	driver.quit();
	}
	}


