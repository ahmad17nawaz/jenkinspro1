package vtiger.Object.Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//rule 1: Create Java Class Page wise
	
	//rule 2: Identify all type web element in the page using @FindBy,@FindAll,@FindBys

	//Declaraion
	@FindBy(name = "user_name")
	private WebElement UserNameEdt;
	
	@FindBy(name = "user_password")
	private WebElement PasswordEdt;
	
	@FindBy(id = "submitButton")
	private WebElement SubmitBtn;

	//Initialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//Utilization
	public WebElement getUserNameEdt() {
		return UserNameEdt;
	}

	public WebElement getPasswordEdt() {
		return PasswordEdt;
	}

	public WebElement getSubmitBtn() {
		return SubmitBtn;
	}
    //Business Library
	/**This method will login to application
	 * 
	 * @param userName
	 * @param Password
	 */
	public void loginToApp(String userName, String Password )
	{
		UserNameEdt.sendKeys(userName);
		PasswordEdt.sendKeys(Password);
		SubmitBtn.click();
	}

	

}
