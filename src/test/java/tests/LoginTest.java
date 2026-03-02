package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest//BaseTest la irukkura @BeforeMethod run aagum
{

	@Test
	public void verifyloginpage()//TestNG indha method-a identify pannum,ethu oru test case
	{
		LoginPage login=new LoginPage(driver);//Constructor call aagum,PageFactory elements initialize aagum
		
		HomePage home=login.enterusername("tomsmith")
							.enterpassword("SuperSecretPassword!")//Same LoginPage object return aagum
							.ClickLogin();//method return type HomePage
		
		Assert.assertTrue(home.isLoginSuccessful());//Success message visible ah irundha true eg Test PASS
		//Assert.assertFalse(home.isLoginSuccessful(),"Forcing failure");//
		
		    }
	}


