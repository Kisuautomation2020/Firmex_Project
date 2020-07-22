package com.firmex.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.firmex.base.TestBase;

public class FirmexLoginPage extends TestBase {

	FirmexLoginPage loginpage;

	@FindBy (className="loginLogo")
	public WebElement lpLogoImage;

	@FindBy (name="email")
	public WebElement email;

	@FindBy (xpath="//input[@value='next']")
	public WebElement emailNext;

	@FindBy (name="password")
	public WebElement password;

	@FindBy (xpath="//input[@value='Log In']")
	public WebElement passwordNext;

	@FindBy (xpath="//p[contains(text(),'Please enter a valid email address.')]")
	public WebElement emailError;

	@FindBy (xpath="//p[@class='pwd-error']/span")
	public WebElement passwordError;



	public FirmexLoginPage() {

		PageFactory.initElements(driver, this);
	}


	public String verifyfxloginPageTitle() {

		return driver.getTitle();
	}

	public void enterEmail(String e) {

		email.sendKeys(e);
		emailNext.click();
	}

	public void enterPassword(String p) {

		password.sendKeys(p);
		passwordNext.click();			

	}

}
