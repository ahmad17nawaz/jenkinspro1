package vtiger.Object.Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.WebDriverUtility;

public class HomePage extends WebDriverUtility {
	//Declaration
	@FindBy(linkText = "Organizations")
	private WebElement OrganizationLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement ContactsLink;
	
	@FindBy(linkText = "Opportunities")
	private WebElement OpportunitiesLink;
	
	@FindBy(linkText="Products")
	private WebElement ProductsLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministratorImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement SignOutLink;
	
	//Initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization - Getters & Business Library
	
	public WebElement getOrganizationLink() {
		return OrganizationLink;
	}

	public WebElement getContactsLink() {
		return ContactsLink;
	}

	public WebElement getOpportunitiesLink() {
		return OpportunitiesLink;
	}

	public WebElement getProductsLink() {
		return ProductsLink;
	}

	public WebElement getAdministratorImg() {
		return AdministratorImg;
	}

	public WebElement getSignOutLink() {
		return SignOutLink;
	}
	
	//Business Logic
	/**
	 * This method will click on Organizations Link
	 */
	public void clickOnOrganizationsLink()
	{
		OrganizationLink.click();
	}
	
	/**
	 * This method will click on Contacts Link
	 */
	public void clickOnContactsLink()
	{
		 ContactsLink.click();
	}
	
	/**
	 * This method will click on Products Link
	 */
	public void clickOnProductsLink()
	{
		ProductsLink.click();
	}
	
	 /**
	 * This method will Sign-out of Application
	 */
	public void signOutOfApp(WebDriver driver)
	{
		mouseHover(driver, AdministratorImg);
		SignOutLink.click();
	}
	
}
