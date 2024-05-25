package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass{
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class)
	public void verify_loginDDT(String email, String password, String result) throws InterruptedException
	{
		logger.info("*** Starting TC_003_LoginDDT******");
		
		HomePage hp = new HomePage(driver);
		
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount link");
		
		hp.clickLogin();
		logger.info("Clicked on Login Page");
		Thread.sleep(15000);
		
		LoginPage lp = new LoginPage(driver);
		
		lp.setEmailAddress(email);
		lp.setPassword(password);
		lp.clickLogin();
		
		/**MyAccountPage mp = new MyAccountPage(driver);
		boolean targetPage = mp.getLoginConfirmation();
		
		if(result.equalsIgnoreCase("valid"))
		{
			if(targetPage==true)
			{
				mp.clickLogOut();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		if(result.equalsIgnoreCase("Invalid"))
		{
			if(targetPage==false)
			{
				Assert.assertTrue(true);
			}
			else
			{
				mp.clickLogOut();
				Assert.assertTrue(false);
			}
		}**/
	}

}
