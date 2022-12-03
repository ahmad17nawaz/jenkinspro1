package vtiger.Practise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import vtiger.GenericUtility.WebDriverUtility;
import vtiger.Object.Repository.CreateNewContactPage;
import vtiger.Object.Repository.HomePage;
import vtiger.Object.Repository.LoginPage;

public class PomPractise {

	private static String lastname;
	private static String leadsource;

	public static void main(String[] args) throws InterruptedException {
		WebDriverUtility wdu = new WebDriverUtility();
		WebDriver driver = new ChromeDriver();
		 Thread.sleep(3000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 Thread.sleep(3000);
		driver.get("http://localhost:8888");
		
		LoginPage lp = new LoginPage(driver);
	//	lp.getUserNameEdt().sendKeys("admin");
	//  lp.getPasswordEdt().sendKeys("root");
	//	lp.getSubmitBtn().click();
		
		 Thread.sleep(3000);
		lp.loginToApp("admin","root");
	
	//	HomePage hp = new HomePage(driver);
	//	hp.getProductsLink().click();
		
	//	wdu.mouseHover(driver, hp.getAdministratorImg());
	//   hp.getSignOutLink().click();
	
//	    hp.clickOnProductsLink();
	//    Thread.sleep(3000);
	  //  hp.signOutOfApp(driver);
	
	 	CreateNewContactPage c = new CreateNewContactPage(driver);
	 	c.createNewContact(lastname, leadsource, driver)	; 	
	 	
}
}
