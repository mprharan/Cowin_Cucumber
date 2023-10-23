package com.testng;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.Maven_Cowin.Cowin_Base;
import com.web.pom.Cowin_HomePage;

public class Cowin_TestNg extends Cowin_Base {
	public static WebDriver driver=null;
	Cowin_HomePage home = new Cowin_HomePage(driver);

	@Test(priority = -2)
	private void launchBrowser() throws InterruptedException {
		browserLaunch("chrome");
		launchUrl("https://www.cowin.gov.in/");
		implicitlyWait();
		sleep();
	}

	@Test(priority = -1)
	private void click_select_by_district() throws InterruptedException {
		sleep();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", home.getCategory());
	}

	@Test(priority = 0)
	private void click_select_state() throws InterruptedException {
		JavascriptExecutor executor = (JavascriptExecutor) driver;

		executor.executeScript("arguments[0].click();", home.getState());
		sleep();
	}

	@Test(priority = 1)
	private void verify_the_list_and_select_state() throws InterruptedException {
		String expected = "Tamil Nadu";
		for (WebElement drop : home.getDropState()) {
			System.out.println(getText(drop));
		}
		for (WebElement drop : home.getDropState()) {
			if (expected.equalsIgnoreCase(getText(drop))) {
				clickOnElement(drop);
				break;
			}
		}
		sleep();
		System.out.println();
	}

	@Test(priority = 2)
	private void c_lick_select_district() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;

		executor.executeScript("arguments[0].click();", home.getStateList());
	}

	@Test(priority = 3)
	private void verify_the_list_and_select_district_and_click_search() throws InterruptedException {
		String expected1 = "Coimbatore";
		sleep();
		for (WebElement drop1 : home.getDropdist()) {
			System.out.println(getText(drop1));
		}
		for (WebElement drop1 : home.getDropdist()) {
			if (expected1.equalsIgnoreCase(getText(drop1))) {
				clickOnElement(drop1);
				break;
			}
		}

		clickOnElement(home.getSearchButton());
		System.out.println();
		sleep();
	}

	@Test(priority = 4)
	private void click_and_verify_the_age() {
		clickOnElement(home.getAge());
		if (getText(home.getResultAge()).replace(" ", "").equalsIgnoreCase(getText(home.getAge()))) {
			System.out.println("Age Verified: " + getText(home.getAge()));
		}
	}

	@Test(priority = 5)
	private void click_and_verify_the_dose() {
		clickOnElement(home.getDose());
		if (getText(home.getResultDose()).equalsIgnoreCase(getText(home.getDose()).replace("Dose ", ""))) {
			System.out.println("Dosage Verified: " + getText(home.getDose()));
		}
	}

	@Test(priority = 6)
	private void click_and_verify_the_cost() {
		clickOnElement(home.getCost());
		if (getText(home.getResultCost()).equalsIgnoreCase(getText(home.getCost()))) {
			System.out.println("Cost Verified: " + getText(home.getCost()));
		}
	}

	@Test(priority = 7)
	private void click_and_verify_the_vaccine() {
		clickOnElement(home.getVaccine());
		if (getText(home.getResultVaccine()).equalsIgnoreCase(getText(home.getVaccine()))) {
			System.out.println("Vaccine Verified: " + getText(home.getVaccine()));
		}
	}

	@Test(priority = 8)
	private void verify_the_hospital_shown() {
		System.out.println(getText(home.getCentres()));

	}

	@Test(priority = 9)
	private void closeBrowser() {
		close();
	}

}
