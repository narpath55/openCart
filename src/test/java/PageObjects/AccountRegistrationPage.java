package PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{
	
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	//PageObjects
	@FindBy(xpath="//input[@name='firstname']") WebElement Txt_FirstName;
	@FindBy(xpath="//input[@name='lastname']") WebElement Txt_LastName;
	@FindBy(xpath="//input[@name='email']") WebElement Txt_Email;
	@FindBy(xpath="//input[@name='password']") WebElement Txt_Password;
	@FindBy(xpath="//button[@class='btn btn-primary' and text()='Continue']") WebElement Btn_Continue;
	@FindBy(xpath="//input[@name='agree']") WebElement Btn_ChkPolicy;
	
	//Actions
	public void setFirstName(String Name)
	{
		Txt_FirstName.sendKeys(Name);
	}
	
	public void setLastName(String Name)
	{
		Txt_LastName.sendKeys(Name);
	}
	
	public void setEmail(String Name)
	{
		Txt_Email.sendKeys(Name);
	}

	public void setPassword(String Name)
	{
		Txt_Password.sendKeys(Name);
	}
	
	public void setPolicyCheck()
	{
		Btn_ChkPolicy.click();
	}
	
	public void clickContinue()
	{
		//Btn_Continue.click();
		//Actions act = new Actions(driver);
		//act.click(Btn_Continue).build().perform();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", Btn_Continue);
	}
}
