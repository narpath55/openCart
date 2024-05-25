package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class MyAccountPage extends BasePage {
	
	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}
	
	//pageobjects
	@FindBy(xpath="//*[text()='myaccount']") WebElement lbl_myAccount;
	@FindBy(xpath="//button[@name='logout']") WebElement btn_logout;
	
	//Actions
	public boolean getLoginConfirmation()
	{
		try {
		boolean b = lbl_myAccount.isDisplayed();
		return b;
		}
		catch(Exception e)
		{
			Assert.fail();
			return false;
		}
	}
	
	public void clickLogOut()
	{
		btn_logout.click();
	}

}
