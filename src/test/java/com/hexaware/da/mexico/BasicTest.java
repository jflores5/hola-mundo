package com.hexaware.da.mexico.seleniumTest;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class BasicTest {

	@Test
	public void test() {
		String DriverPath = "/home/jaflores/Selenium_3.11/drivers/chromedriver";
		//String DriverPath = "/home/jaflores/Selenium_3.11/drivers/geckodriver";
		WebDriver driver = null;

		System.setProperty("webdriver.chrome.driver", DriverPath);
		//System.setProperty("webdriver.gecko.driver", DriverPath);

		// create a new instance of the driver
		try {
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), new ChromeOptions());
		}
		catch (Exception e) {}
		//driver = new ChromeDriver();
		//driver = new FirefoxDriver();

		// Open the page we want to open
		driver.get("https://www.cleartrip.com/");
		driver.findElement(By.cssSelector("input#RoundTrip.tripType")).click();
		driver.findElement(By.xpath("//input[@title='Depart date']")).click();
		driver.findElement(By.xpath("//div[@class='monthBlock first']//a[text()[. = '30']]")).click();
		driver.findElement(By.xpath("//input[@title='Return date']")).click();
		String css = driver.findElement(By.xpath("//input[@title='Return date']")).getAttribute("title");
		driver.findElement(By.xpath("//div[@class='monthBlock last']//a[text()[. = '10']]")).click();
		System.out.println("CSS: " + css);
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File screenshotFile = screenshot.getScreenshotAs(OutputType.FILE);
		driver.quit();
	}
}
