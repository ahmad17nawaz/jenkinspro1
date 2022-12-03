package Srivallimam;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FbButtonIsEnabled {
public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.facebook.com/");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	WebElement searchButton=driver.findElement(By.xpath("//button[.='Log in']"));
	if(searchButton.isEnabled())
		System.out.println("Search button is enabled");
	else
		System.out.println("Search button is disabled");
	driver.quit();
}
}
