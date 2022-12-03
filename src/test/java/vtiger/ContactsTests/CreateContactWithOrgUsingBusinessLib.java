package vtiger.ContactsTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtility.ExcelFileUtility;
import vtiger.GenericUtility.JavaUtility;
import vtiger.GenericUtility.PropertyFileUtility;
import vtiger.GenericUtility.WebDriverUtility;
import vtiger.Object.Repository.ContactInfoPage;
import vtiger.Object.Repository.ContactsPage;
import vtiger.Object.Repository.CreateNewContactPage;
import vtiger.Object.Repository.CreateNewOrganizationPage;
import vtiger.Object.Repository.HomePage;
import vtiger.Object.Repository.LoginPage;
import vtiger.Object.Repository.OrganizationInfoPage;
import vtiger.Object.Repository.OrganizationsPage;

public class CreateContactWithOrgUsingBusinessLib {



		public static void main(String[] args) throws IOException {
			
			WebDriver driver=null;
			
			//Create object of all the Utilities
			JavaUtility jUtil = new JavaUtility();
			PropertyFileUtility pUtil = new PropertyFileUtility();
			ExcelFileUtility eUtil = new ExcelFileUtility();
			WebDriverUtility wUtil = new WebDriverUtility();
			
			//read all the data required for the test script
			String BROWSER = pUtil.readDataFromPFile("browser");
			String URL = pUtil.readDataFromPFile("url");
			String USERNAME = pUtil.readDataFromPFile("username");
			String PASSWORD = pUtil.readDataFromPFile("password");
			
			String ORGNAME = eUtil.readDataFromExcel("Contact", 4, 3)+jUtil.getRandomNumber();
			String LASTNAME = eUtil.readDataFromExcel("Contact", 4, 2);
			
			//launch the browser
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
			
			//Navigate to Organizations link
			HomePage hp = new HomePage(driver);
			hp.clickOnOrganizationsLink();
			
			//click on create organization look up image
			OrganizationsPage op = new OrganizationsPage(driver);
			op.clickOnCreateOrgImg();
			
			//Create organization with mandatory fields and save
			CreateNewOrganizationPage cnp = new CreateNewOrganizationPage(driver);
			cnp.createNewOrg(ORGNAME);
			
			//Validate for Organization

			OrganizationInfoPage oip = new OrganizationInfoPage(driver);
			   String OrgHeader = oip.getOrgHeader();
			    System.out.println(OrgHeader);
			    if(OrgHeader.contains(ORGNAME))
			    {
			    	System.out.println("Organization Created");
			    }
			    else
			    {
			    	System.out.println("Organization not Created");
			    }
			
				
			//Navigate to contacts link
			    hp.clickOnContactsLink();
			    
			//Click on create contact look up image
			    ContactsPage cp = new ContactsPage(driver);
			    cp.clickOnCreateContactImage();
			    
			//Create contact with Organization and save
			    CreateNewContactPage cnc = new CreateNewContactPage(driver);
			    cnc.createNewContact(LASTNAME, ORGNAME, driver);
			
			
			//validate for contacts
		    ContactInfoPage cip = new ContactInfoPage(driver);
		    String contactHeader = cip.getContactHeader();
		    System.out.println(contactHeader);
		    
			if(contactHeader.contains(LASTNAME))
			{
				System.out.println("Contact Created -- PASS");
			}
			else
			{
				System.out.println("Contact not created --- FAIL");
			}
			
			//Logout
			hp.signOutOfApp(driver);
			System.out.println("sign out successfull");
			
		}
}
