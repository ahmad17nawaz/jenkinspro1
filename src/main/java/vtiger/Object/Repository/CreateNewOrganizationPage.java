package vtiger.Object.Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility {

	@FindBy(name = "accountname")
	private WebElement OrgNameEdt;
	
	@FindBy(name = "industry")
	private WebElement industryDropDown;
	
	@FindBy(name = "accounttype")
	private WebElement typeDropDown;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	
	//Initialization
	public CreateNewOrganizationPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getOrgNameEdt() {
		return OrgNameEdt;
	}

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	public WebElement getTypeDropDown() {
		return typeDropDown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	
	//Business LIbrary
	/**
	 * This method will create new organization
	 * @param Orgname
	 */
	public void createNewOrg(String Orgname)
	{
		OrgNameEdt.sendKeys(Orgname);
		saveBtn.click();
	}
	
	/**
	 * his method will create Organization with industry
	 * @param Orgname
	 * @param indType
	 */
	public void createNewOrg(String Orgname, String indType)
	{
		OrgNameEdt.sendKeys(Orgname);
		handleDropdown(indType, industryDropDown);
		saveBtn.click();
	}
	
	/**
	 * This method will create Organization with industry and type
	 * Drop-Downs
	 * @param Orgname
	 * @param indType
	 * @param Type
	 */
	public void createNewOrg(String Orgname, String indType, String Type)
	{
		OrgNameEdt.sendKeys(Orgname);
		handleDropdown(indType, industryDropDown);
		handleDropdown(Type, typeDropDown);
		saveBtn.click();
	}
	
	
}
