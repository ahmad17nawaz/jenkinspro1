package vtiger.Object.Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement Orgheader;
	
	public OrganizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgheader() {
		return Orgheader;
	}
	
	//Business LIbrary
	public String getOrgHeader()
	{
		return Orgheader.getText();
	}

}
