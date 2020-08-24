package com.firmex.tests;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import com.firmex.base.TestBase;
import com.firmex.pages.FirmexHomePage;
import com.firmex.pages.FirmexLoginPage;

public class FirmexHomePageTest extends TestBase {

	FirmexHomePage fxhomepage;
	FirmexLoginPage fxloginpage;

	public FirmexHomePageTest() {
		super();
	}
	

	@BeforeMethod
	public void setUP() {

		initialization();
		fxhomepage=new FirmexHomePage();

	}

	@Test (priority=1)
	public void verifyfirmexHomePageTest()
	{
		String actualtitle=fxhomepage.homePageTitle();
		String expectedtitle=prop1.getProperty("HomepageTitle");
		Assert.assertEquals(actualtitle, expectedtitle );
		Assert.assertTrue(fxhomepage.homePageLogoImage());
	}

	@Test (priority=2, dependsOnMethods= {"verifyfirmexHomePageTest"})
	public void clickonloginBtnTest()
	{
		Assert.assertTrue(fxhomepage.loginBtnPresent());
		fxloginpage=fxhomepage.clickOnLoginBtn();

	}

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
