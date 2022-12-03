package vtiger.OrganizationsTest;

import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtility.ExcelFileUtility;
import vtiger.GenericUtility.JavaUtility;
import vtiger.GenericUtility.PropertyFileUtility;
import vtiger.GenericUtility.WebDriverUtility;
import vtiger.Object.Repository.CreateNewOrganizationPage;
import vtiger.Object.Repository.HomePage;
import vtiger.Object.Repository.LoginPage;
import vtiger.Object.Repository.OrganizationInfoPage;
import vtiger.Object.Repository.OrganizationsPage;

public class CreateOrgWithIndustry {

	public static void main(String[] args) throws IOException {
		
	WebDriver driver=null;
	
	//Step 1: Create object of all the Utilities
	JavaUtility jutil = new JavaUtility();
	PropertyFileUtility pUtil = new PropertyFileUtility();
	ExcelFileUtility eUtil = new ExcelFileUtility();
	WebDriverUtility wUtil = new WebDriverUtility();
	
	//Step 2:read all the data required for the test script
	String BROWSER = pUtil.readDataFromPFile("browser");
	String URL = pUtil.readDataFromPFile("url");
	String USERNAME = pUtil.readDataFromPFile("username");
	String PASSWORD = pUtil.readDataFromPFile("password");
	
	String ORGNAME = eUtil.readDataFromExcel("Organization", 4, 2)+jutil.getRandomNumber();
	String INDUSTRY = eUtil.readDataFromExcel("Organization", 4, 3);
	
	//launch the browser - Run Time Polymorphism
	if(BROWSER.equalsIgnoreCase("CHROME"))
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	else if(BROWSER.equalsIgnoreCase("FIREFOX"))
	{
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}
	else
	{
		System.out.println("invalid browser name");
	}
	
	wUtil.maximizeWindow(driver);
	wUtil.waitForDOMLoad(driver);
	driver.get(URL);
	
	//login To App
	LoginPage lp = new LoginPage(driver);
	lp.loginToApp(USERNAME, PASSWORD);
	
	//Navigate To Organizations Link
	HomePage hp = new HomePage(driver);
	hp.clickOnOrganizationsLink();
	
	//Click On Create New Organization
	OrganizationsPage op = new OrganizationsPage(driver);
    op.clickOnCreateOrgImg();
    
	//Create New Organization with industry and save
    CreateNewOrganizationPage cnp = new CreateNewOrganizationPage(driver);
    cnp.createNewOrg(ORGNAME,INDUSTRY);
    
    //validate
    OrganizationInfoPage oip = new OrganizationInfoPage(driver);
   String OrgHeader = oip.getOrgHeader();
    System.out.println(OrgHeader);
    if(OrgHeader.contains(ORGNAME))
    {
    	System.out.println("Pass");
    }
    else
    {
    	System.out.println("Fail");
    }
    
    //Sign-out
    hp.signOutOfApp(driver);
	}

	
	}

	