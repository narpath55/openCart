package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	//PageObjects
	@FindBy(xpath="//input[@name='email']") WebElement Txt_EmailAddres;
	@FindBy(xpath="//input[@name='password']") WebElement Txt_password;
	@FindBy(xpath="//button[@class='btn btn-primary' and text()='Login']")
	WebElement Btn_Login;
	
	//Actions
	public void setEmailAddress(String name)
	{
		Txt_EmailAddres.sendKeys(name);
	}
	
	public void setPassword(String name)
	{
		Txt_password.sendKeys(name);
	}
	
	public void clickLogin()
	{
		Btn_Login.click();
	}
	
	

}
