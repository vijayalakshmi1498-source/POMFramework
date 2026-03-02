package base;
//Driver initialization Base class la maintain pannuren to avoid duplicate code.
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	public WebDriver driver;
	
	@BeforeMethod
	public void Setup()
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		driver = new ChromeDriver(options);
		
		//System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/login");
		driver.manage().window().maximize();
		
	}
	
	@AfterMethod
	public void teardown()
	{
		if (driver != null) {
            driver.quit();
	}
}}
