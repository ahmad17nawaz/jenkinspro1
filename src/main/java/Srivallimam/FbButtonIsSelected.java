package Srivallimam;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FbButtonIsSelected {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[.='Create New Account']")).click();
		WebElement maleRadio = driver.findElement(By.xpath("//input[@value='2']"));		
		maleRadio.click();
		if(maleRadio.isSelected())
		System.out.println("Pass:Selected");
	else
		System.out.println("Failed:Not Selected");
	driver.quit();
	}
	}


