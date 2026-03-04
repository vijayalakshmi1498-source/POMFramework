package base;
import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.edge.EdgeDriver;
import java.util.Properties;

//Driver initialization Base class la maintain pannuren to avoid duplicate code.
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	public WebDriver driver;
	
	@BeforeMethod
	public void Setup() throws IOException
	{
		String env=System.getProperty("environment");// Get environment from Maven/Jenkins
		if(env==null)//If no environment passed, default = qa
		{
			env="qa";
		}
		//Load respective property file
		FileInputStream fis=new FileInputStream("config/config-"+ env +".properties");
		Properties prop=new Properties();
		prop.load(fis);
		String browser=prop.getProperty("browser");//Get browser from property file
		
		//Launch browser based on property value
		if(browser.equalsIgnoreCase("chrome"))
		{
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			driver = new ChromeDriver(options);
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		else
			throw new RuntimeException("Browser not supported : " +browser);
		
	driver.get(prop.getProperty("url"));
	driver.manage().window().maximize();
}	
	
	@AfterMethod
	public void teardown()
	{
		if (driver != null) {
            driver.quit();
	}
}}
