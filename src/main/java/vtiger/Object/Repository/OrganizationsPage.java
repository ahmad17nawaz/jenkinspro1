package vtiger.Object.Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {

	//Declaration     
	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement creaOrgImg;
	
	//Initialization
	public OrganizationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	//Utilization
	public WebElement getCreaOrgImg() 
	{
		return creaOrgImg;
	}
	
	/**
	 * This method will click on create organization look-up image
	 */
	//Business Library
	public void clickOnCreateOrgImg()		
	{
		creaOrgImg.click();
}
}
