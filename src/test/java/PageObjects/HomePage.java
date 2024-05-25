package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	//PageObjects
	@FindBy(xpath="//span[@class='d-none d-md-inline' and text()='My Account']")
	WebElement Btn_MyAccount;
	
	@FindBy(xpath="//a[@class='dropdown-item' and text()='Register']") 
	WebElement Btn_Register;

	@FindBy(xpath="//a[@class='dropdown-item' and text()='Login']") 
	WebElement Btn_Login;

	//Actions
	public void clickMyAccount()
	{
		Btn_MyAccount.click();
	}
	
	public void clickRegister()
	{
		Btn_Register.click();
	}
	
	public void clickLogin()
	{
		Btn_Login.click();
	}


}
