package com.firmex.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



import com.firmex.base.TestBase;

public class FirmexHomePage extends TestBase {

	@FindBy (xpath="//a[@class='button login']")
	public WebElement loginBtn;

	@FindBy (className="custom-logo")
	public WebElement hpLogoImage;

	public FirmexHomePage(){

		PageFactory.initElements(driver, this);
	}

	public String homePageTitle(){
		return driver.getTitle();
	}

	public boolean homePageLogoImage() {
		return hpLogoImage.isDisplayed();
	}

	public boolean loginBtnPresent() {

		return loginBtn.isDisplayed();
	}

	public FirmexLoginPage clickOnLoginBtn() {

		loginBtn.click();

		return new FirmexLoginPage();
	}

}
