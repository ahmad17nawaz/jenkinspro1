package vtiger.Object.Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {

	//Declaration
	@FindBy(xpath = "//img[@alt='Create Contact...']")
	private WebElement CreateContactLookUpImage;
	
	//Initialization
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	
	public WebElement getCreateContactLookUpImage() {
		return CreateContactLookUpImage;
	}

	/**
	 * This method will click on create new contact look-up image 
	 */
	//Business Logic
	public void clickOnCreateContactImage()
	{
		CreateContactLookUpImage.click();
	}
}
