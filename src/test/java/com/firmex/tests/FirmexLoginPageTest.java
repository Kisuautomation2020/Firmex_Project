package com.firmex.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.firmex.base.TestBase;
import com.firmex.pages.FirmexHomePage;
import com.firmex.pages.FirmexLoginPage;

public class FirmexLoginPageTest extends TestBase {

	FirmexHomePage fxhomepage;
	FirmexLoginPage fxloginpage;


	public FirmexLoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUP() {

		initialization();
		fxhomepage=new FirmexHomePage();
		fxloginpage=new FirmexLoginPage();
		fxloginpage=fxhomepage.clickOnLoginBtn();

	}

	@Test (priority=1)
	public void verifyfirmexLoginPageTest() throws InterruptedException {
		Thread.sleep(2000);

		String actualTitle=fxloginpage.verifyfxloginPageTitle();
		String expectedTitle=prop1.getProperty("LoginpageTitle");
		Assert.assertEquals(actualTitle, expectedTitle);	
	}


	@Test (priority=2, dependsOnMethods= {"verifyfirmexLoginPageTest"})
	public void verifyloginwithInvalidEmail() {

		fxloginpage.enterEmail(prop1.getProperty("emailWrong"));

		String expectedErrorMsg=prop1.getProperty("emailErrorMessage");
		String actualErrorMsg=fxloginpage.emailError.getText();
		Assert.assertEquals(actualErrorMsg, expectedErrorMsg);		
	}


	@Test (priority=3,dependsOnMethods= {"verifyloginwithInvalidEmail","verifyfirmexLoginPageTest"} )
	public void verifyloginwithInvalidPassword() throws InterruptedException {

		fxloginpage.enterEmail(prop1.getProperty("emailRight"));

		Thread.sleep(2000);

		fxloginpage.enterPassword(prop1.getProperty("Password"));

		String expectedpwdErrorMsg=prop1.getProperty("passwordErrorMessage");
		String actualpwdErroMsg=fxloginpage.passwordError.getText();

		Assert.assertEquals(actualpwdErroMsg, expectedpwdErrorMsg);		
	}

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
