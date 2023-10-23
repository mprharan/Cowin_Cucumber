package com.Maven_Cowin;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Cowin_Base {

	public static WebDriver driver = null;
	
	public static WebDriver browserLaunch(String value) {
		if (value.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (value.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (value.equalsIgnoreCase("gecko")) {
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		return driver;
	}

	public static void userInput(WebElement element, String value) {
		element.sendKeys(value);
	}

	public static String getText(WebElement element) {
		String text = element.getText();
		return text;
	}

	public static void clickOnElement(WebElement element) {
		element.click();
	}

	public static void sleep() throws InterruptedException {
		Thread.sleep(3000);
	}

	

	public static void close() {
		driver.close();
	}

	public static void launchUrl(String url) {
		driver.get(url);
	}

	public static void implicitlyWait() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public static String getTitle() {
		String title = driver.getTitle();
		return title;
	}

	public static String getCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	public static void navigateTo(String url) {
		driver.navigate().to(url);
	}

	public static void navigateForward() {
		driver.navigate().forward();
	}

	public static void navigateBack() {
		driver.navigate().back();
	}

	public static void refresh() {
		driver.navigate().refresh();
	}

	public static List<WebElement> dropDownOptions(WebElement element) {
		Select s1 = new Select(element);
		List<WebElement> options = s1.getOptions();
		return options;
	}

	public static void dropDownSelect(String options, WebElement element, String value) {
		Select s = new Select(element);
		if (options.equalsIgnoreCase("value")) {
			s.selectByValue(value);
		} else if (options.equalsIgnoreCase("text")) {
			s.selectByVisibleText(value);
		} else if (options.equalsIgnoreCase("index")) {
			int n = Integer.parseInt(value);
			s.deselectByIndex(n);
		}
	}

	public static void popup(String options) {
		if (options.equalsIgnoreCase("ok")) {
			driver.switchTo().alert().accept();
		} else if (options.equalsIgnoreCase("cancel")) {
			driver.switchTo().alert().dismiss();
		}
	}

	public static void sendKeysAlert(String value) {
		driver.switchTo().alert().sendKeys(value);
	}

	public static void frameSwitch(String element) {
		driver.switchTo().frame(element);
	}

	public static void capture(String name) throws IOException {
		TakesScreenshot scs = (TakesScreenshot) driver;
		File screenshotAs = scs.getScreenshotAs(OutputType.FILE);
		File destination = new File("D:\\Selenium scs\\" + name + ".png");
		FileHandler.copy(screenshotAs, destination);
	}
	
}
