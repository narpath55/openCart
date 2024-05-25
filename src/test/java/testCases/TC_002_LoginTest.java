package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass{
	
	@Test(groups= {"sanity", "master"})
	public void verify_login()
	{
		logger.info("***** Starting Login Test*******");
		logger.debug("Capturing application debug logs....");
		try
		{
		HomePage hp = new HomePage(driver);
		
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount link");
		
		hp.clickLogin();
		logger.info("Clicked on Login Page");
		Thread.sleep(15000);
		
		LoginPage lp = new LoginPage(driver);
		
		lp.setEmailAddress(p.getProperty("username"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		logger.info("Entered correct login Credentials");
		
		}
		catch(Exception e)
		{
			logger.error("Test failed !!!!!");
			Assert.fail();
		}
		logger.info("***Ended Login Test*******");
		
	}

}
