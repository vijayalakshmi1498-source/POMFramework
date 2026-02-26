package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.WaitUtils;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver)//Object create pannumbodhu automatically call aagum//eg HomePage home = new HomePage(driver);
	{
		this.driver=driver;//Outside irukkura driver-a ,Indha class driver variable ku assign pannrom
		PageFactory.initElements(driver, this);//@FindBy annotations la irukkura elements,Runtime la find pannum
	}
	@FindBy(css = "div.flash.success")//success msg= Adha identify panna xpath use pannrom
	WebElement SuccessMessage;
	
	//why boolean-Test class la assertion panna use aagum.
	public boolean isLoginSuccessful()//Login success aagiducha nu check panna method,boolean return pannrom,
	{
		WaitUtils.WaitForElement(driver, SuccessMessage);//Direct ah check panna fail aagalam so explicit wait	
		
		return SuccessMessage.isDisplayed();//Screen la visible ah irundha true,illati false
	}
	
	

}
