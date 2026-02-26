package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver)//LoginPage object create pannumbodhu automatic ah call aagum
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	
	}
	//locators
	@FindBy(id="username")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(css="button[type='submit']")
	 WebElement loginBtn;
	
	//actions
	public LoginPage enterusername(String user)
	{
		username.sendKeys(user);
		return this;
		//this = LoginPage(current) object,method chaining 
	}
	public LoginPage enterpassword(String pass)
	{
		password.sendKeys(pass);
		return this;
	}
	public HomePage ClickLogin()
	{
		loginBtn.click();
		return new HomePage(driver);
	}

}
