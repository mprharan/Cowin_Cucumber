package com.StepDefinition;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.Maven_Cowin.Cowin_Base;
import com.RunnerClass.Cowin_Runner;
import com.web.pom.Cowin_HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Cowin_StepDefinition extends Cowin_Base {
	public static WebDriver driver = Cowin_Runner.driver;
	Cowin_HomePage home=new Cowin_HomePage(driver);
	JavascriptExecutor executor = (JavascriptExecutor) driver;

	@Given("User Launch The Site")
	public void user_launch_the_site() {
		launchUrl("https://www.cowin.gov.in/");
		implicitlyWait();
	}

	@When("Click Select By District")
	public void click_select_by_district() {
		executor.executeScript("arguments[0].click();", home.getCategory());
	}

	@When("Click Select State")
	public void click_select_state() throws InterruptedException {
		executor.executeScript("arguments[0].click();", home.getState());
		sleep();
	}

	@When("Verify The List and Select State")
	public void verify_the_list_and_select_state() throws InterruptedException {
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

	@When("CLick Select District")
	public void c_lick_select_district() {
		executor.executeScript("arguments[0].click();", home.getStateList());
	}

	@Then("Verify The List and Select District and Click Search")
	public void verify_the_list_and_select_district_and_click_search() throws InterruptedException {
		String expected1 = "Coimbatore";
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

	@Given("Click and Verify The Age")
	public void click_and_verify_the_age() {
		clickOnElement(home.getAge());
		if (getText(home.getResultAge()).replace(" ", "").equalsIgnoreCase(getText(home.getAge()))) {
			System.out.println("Age Verified: " +getText(home.getAge()));
		}
	}

	@When("Click and Verify The Dose")
	public void click_and_verify_the_dose() {
		clickOnElement(home.getDose());
		if (getText(home.getResultDose()).equalsIgnoreCase(getText(home.getDose()).replace("Dose ", ""))) {
			System.out.println("Dosage Verified: " + getText(home.getDose()));
		}
	}

	@When("Click and Verify The Cost")
	public void click_and_verify_the_cost() {
		clickOnElement(home.getCost());
		if (getText(home.getResultCost()).equalsIgnoreCase(getText(home.getCost()))) {
			System.out.println("Cost Verified: " + getText(home.getCost()));
		}
	}

	@When("Click and Verify The Vaccine")
	public void click_and_verify_the_vaccine() {
		clickOnElement(home.getVaccine());
		if (getText(home.getResultVaccine()).equalsIgnoreCase(getText(home.getVaccine()))) {
			System.out.println("Vaccine Verified: " + getText(home.getVaccine()));
		}
	}

	@Then("Verify The Hospital Shown")
	public void verify_the_hospital_shown() {
		System.out.println(getText(home.getCentres()));
	}
}
