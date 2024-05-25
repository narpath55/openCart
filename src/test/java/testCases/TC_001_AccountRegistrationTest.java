package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObjects.AccountRegistrationPage;
import PageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {
	
	
	@Test(groups= {"regression", "master"})
	public void verify_AccountRegistration() throws InterruptedException
	{
		logger.info("**** Starting TC_001_AccountRegistrationTest ****");
		
		logger.debug("Application logs started....");
		try 
		{
		HomePage hp = new HomePage(driver);
		
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount link");
		
		hp.clickRegister();
		logger.info("Clicked on Register link");
		
		Thread.sleep(10000);
		AccountRegistrationPage ap = new AccountRegistrationPage(driver);
		ap.setFirstName(randomString());
		ap.setLastName(randomString());
		ap.setEmail(randomString()+"@gmail.com");
		ap.setPassword(randomAlphaNumeric());
		
		ap.setPolicyCheck();
		logger.info("Clicked on Policy Check link");
		
		ap.clickContinue();
		logger.info("Clicked on Continue link");
		
		}
		catch(Exception e)
		{
			logger.error("Test case is failed");
			Assert.fail();
		}
		
		logger.debug("Application logs are ended........");
		logger.info("++++ Ending TC_001_AccountRegistrationTest ++++");
	}
	
	
}
