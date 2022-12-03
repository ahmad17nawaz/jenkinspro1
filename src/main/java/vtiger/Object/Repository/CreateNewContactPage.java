package vtiger.Object.Repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility{

	//Declaration
	@FindBy(name = "lastname")
	private WebElement lastnameEdt;
	
	@FindBy(name = "leadsource")
	private WebElement leadSourceDropdown;
	
	@FindBy(xpath ="//input[@name='account_name']/following-sibling::img[@title='Select']")
	private WebElement OrganizationImg;
	
	@FindBy (name = "search_text")
	private WebElement SearchEdt;
	
	@FindBy (name = "search")
	private WebElement SearchNowButton;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveButton;

	private CharSequence js;
	
	//Utilization
	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Initialization
	public WebElement getLastnameEdt() {
		return lastnameEdt;
	}

	public WebElement getLeadSourceDropdown() {
		return leadSourceDropdown;
	}

	public WebElement getOrganizationImg() {
		return OrganizationImg;
	}

	public WebElement getSearchEdt() {
		return SearchEdt;
	}

	public WebElement getSearchNowButton() {
		return SearchNowButton;
	}

	public WebElement getSaveButton() {
		return SaveButton;
	}


	//Business Library
	
	/**
	 * This method will create contact and save
	 * @param lastname
	 */
	public void createNewContact(String lastname)
	{
		lastnameEdt.sendKeys(lastname);
		SaveButton.click();
	}
	
	/**
	 * This method will create contact with Lead-Source Drop-Down
	 * @param lastname
	 * @param leadSource
	 */
	public void createNewContact(String lastname, String leadSource)
	{
		lastnameEdt.sendKeys(lastname);
		handleDropdown(leadSource, leadSourceDropdown);
		SaveButton.click();
	}

	/**
	 * This method will create contact with Organization
	 * @param lastname
	 * @param leadSource
	 * @param driver
	 */
	public void createNewContact(String lastname, String OrgName, WebDriver driver)
	{
		lastnameEdt.sendKeys(lastname);
		OrganizationImg.click();
		switchToWindow(driver, "Accounts");
		SearchEdt.sendKeys(OrgName);
		SearchNowButton.click();
		driver.findElement(By.xpath("//a[.='"+OrgName+"']")).click();
		switchToWindow(driver, "Contacts");
		SaveButton.click();		
	}
	
}
