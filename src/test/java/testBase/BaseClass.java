package testBase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public static WebDriver driver;
	public Logger logger;
	public Properties p;
	
	@BeforeClass(groups = {"sanity", "regression", "master"})
	@Parameters({"os", "browser"})
	public void setUp(String os, String br) throws IOException
	{
		//****loading config.properties file
		FileReader file = new FileReader(".//src/test/resources/config.properties");
		p = new Properties();
		p.load(file);
		
		//loading log4j file
		//this.getclass() = to get the TC name everytime dynamically
		logger = LogManager.getLogger(this.getClass());
		
		
		//to run on Slenium Grid
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities = new DesiredCapabilities();
			
			if(os.equalsIgnoreCase("Windows"))
			{
				capabilities.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("mac"))
			{
				capabilities.setPlatform(Platform.MAC);
			}
			else
			{
				System.out.println("Browser is not matching !!!!");
			}
			
			switch(br.toLowerCase())
			{
				case "chrome" :
					capabilities.setBrowserName("chrome");
					break;
					
				case "edge" :
					capabilities.setBrowserName("MicrosoftEdge");
					break;
				default : System.out.println("No matching browser...");
				break;
					
			}
			WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wb/hub"), capabilities);
			
		}
		//if execution is local
		else if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{
			switch(br.toLowerCase())
			{
			case "chrome" :
				driver = new ChromeDriver();
				break;
			case "edge" :
				driver = new EdgeDriver();
				break;
			default : 
				System.out.println("Browsers are not matching");
				break;
			}
		}
		
		
		//launching browser based on conditions
		
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get(p.getProperty("appUrl"));
		driver.manage().window().maximize();
	}

	@AfterClass(groups = {"sanity", "regression", "master"})
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.close();
	}
	
	public String randomString()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	public String randomNumber()
	{
		String generatedNumber = RandomStringUtils.randomNumeric(10);
		return generatedNumber;
	}
	
	public String randomAlphaNumeric()
	{
		String num = RandomStringUtils.randomNumeric(3);
		String str = RandomStringUtils.randomAlphabetic(3);
		return (str + "@" + num);
	}
	
	public String captureScreen(String tname)
	{
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String TargetFilePath = System.getProperty("user.dir")+"\\Screenshots\\"+ tname + "_" +timeStamp;
		File TargetFile = new File(TargetFilePath);
	
		sourceFile.renameTo(TargetFile);
		
		return TargetFilePath;
	}

}
