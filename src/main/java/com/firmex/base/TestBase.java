package com.firmex.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TestBase {

	public static WebDriver driver; 
	public static Properties prop;
	public static Properties prop1;
	public TestBase() {

		try {
			prop = new Properties();
			FileInputStream fs = new FileInputStream(
					"C:\\Selenium_Workspace\\FirmexProject\\src\\main\\java\\com\\firmex\\config\\config.properties");
			prop.load(fs);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {

			prop1 = new Properties();
			FileInputStream ds = new FileInputStream(
					"C:\\Selenium_Workspace\\FirmexProject\\src\\main\\java\\com\\firmex\\testdata\\testdata.properties");
			prop1.load(ds);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {


		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium_Workspace\\FirmexProject\\Driver\\drivers\\chromedriver.exe");
			driver = new ChromeDriver(); 

		} else if (browserName.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Selenium_Workspace\\FirmexProject\\Driver\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));
	}
}