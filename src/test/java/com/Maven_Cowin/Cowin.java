package com.Maven_Cowin;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Cowin {

	public static WebDriver driver = null;

	public static void main(String[] args) throws IOException, InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.cowin.gov.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Click Select By District
//		WebElement category = driver.findElement(By.xpath("//div[@role='tablist']/div/div[@role='tab']"));
//		category.click();
		
		//Click State List
		WebElement state = driver.findElement(
				By.xpath("//div[@class='nearestCentersSection']/descendant::div[@id='mat-select-value-5']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", state);
		Thread.sleep(5000);
		
		//Verify The State Tamilnadu
		String expected = "Tamil Nadu";
		List<WebElement> dropState = driver.findElements(By.xpath(
				"//div[@class='cdk-overlay-container']/descendant::div[@role='listbox']/child::mat-option"));
		for (WebElement drop : dropState) {
			System.out.println(drop.getText());
		}
		for (WebElement drop : dropState) {
			if (expected.equalsIgnoreCase(drop.getText())) {
				drop.click();
				break;
			}
		}
		System.out.println();
		Thread.sleep(2000);
		
		//Click District List
		WebElement stateList = driver.findElement(
				By.xpath("//div[@class='nearestCentersSection']/descendant::div[@id='mat-select-value-7']"));
		executor.executeScript("arguments[0].click();", stateList);
		
		//Verify The Dist Coimbatore
		String expected1="Coimbatore";
		List<WebElement> dropdist = driver.findElements(By.xpath(
				"//div[@class='cdk-overlay-container']/descendant::div[@id='mat-select-6-panel']/child::mat-option[@role='option']"));
		for (WebElement drop1 : dropdist) {
			System.out.println(drop1.getText());
		}
		for (WebElement drop1 : dropdist) {
			if (expected1.equalsIgnoreCase(drop1.getText())) {
				drop1.click();
				break;
			}
		}
		
		//Click Button
		WebElement searchButton = driver.findElement(By.xpath("//button[@tabindex='0']"));
		searchButton.click();
		System.out.println();
		Thread.sleep(1000);

		//Click And Verify The Age
		WebElement age = driver.findElement(By.xpath(
				"//div[@class='form-check']/child::input[@class='chk-btn']/following-sibling::label[text()='18+']"));
		age.click();
		WebElement resultAge = driver.findElement(By.xpath(
				"//div[@class='filter-section pt-4 mb-4 ng-star-inserted']/descendant::li/span[@class='accessibility-plugin-ac']/following-sibling::span[text()='18+ ']"));
		if (resultAge.getText().replace(" ", "").equalsIgnoreCase(age.getText())) {
			System.out.println("Age Verified: " + age.getText());
		}
		
		//Click And Verify The Dose
		WebElement dose = driver.findElement(By.xpath(
				"//div[@class='form-check']/child::input[@class='chk-btn']/following-sibling::label[text()='Dose 1']"));
		dose.click();
		WebElement resultDose = driver.findElement(By.xpath(
				"//li[@class='ng-star-inserted']/span[@class='accessibility-plugin-ac']/following-sibling::span[text()='1']"));
		if (resultDose.getText().equalsIgnoreCase(dose.getText().replace("Dose ", ""))) {
			System.out.println("Dosage Verified: " + dose.getText());
		}
		
		//Click And Verify The Cost
		WebElement cost = driver.findElement(By.xpath(
				"//div[@class='form-check']/child::input[@class='chk-btn']/following-sibling::label[text()='Paid']"));
		cost.click();
		WebElement resultCost = driver.findElement(By.xpath(
				"//li[@class='ng-star-inserted']/span[@class='accessibility-plugin-ac']/following-sibling::span[text()='Paid']"));
		if (resultCost.getText().equalsIgnoreCase(cost.getText())) {
			System.out.println("Cost Verified: " + cost.getText());
		}
		
		//Click And Verify The Vaccine
		WebElement vaccine = driver.findElement(By.xpath(
				"//li[@class='ng-star-inserted']/descendant::div/div/input[@class='chk-btn']/following-sibling::label[text()='Covishield']"));
		vaccine.click();
		WebElement resultVaccine = driver.findElement(By.xpath(
				"//li[@class='ng-star-inserted']/span[@class='accessibility-plugin-ac']/following-sibling::span[text()='COVISHIELD']"));
		if (resultVaccine.getText().equalsIgnoreCase(vaccine.getText())) {
			System.out.println("Vaccine Verified: " + vaccine.getText());
		}
		 System.out.println();

		 //Verify The Hospital
		WebElement centres = driver.findElement(By.xpath(
				"//div[@class='mobile-hide slots-availablity-table ng-star-inserted']/descendant::div[@class='row-disp']/h5[text()=' CRI Trust CVC ']/following-sibling::p[text()=' Saravanampatti Coimbatore, Coimbatore, Tamil Nadu, 641035 ']"));
		System.out.println(centres.getText());
	}
}
