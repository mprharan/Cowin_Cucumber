package com.web.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cowin_HomePage {
	public WebDriver driver = null;

	@FindBy(xpath = "//div[@role='tablist']/div/div[@role='tab']")
	private WebElement category;

	@FindBy(xpath = "//div[@class='nearestCentersSection']/descendant::div[@id='mat-select-value-5']")
	private WebElement state;
	
	@FindBy(xpath = "//div[@class='cdk-overlay-container']/descendant::div[@role='listbox']/child::mat-option")
	private List<WebElement> dropState;
	
	@FindBy(xpath = "//div[@class='nearestCentersSection']/descendant::div[@id='mat-select-value-7']")
	private WebElement stateList;
	
	@FindBy(xpath = "//div[@class='cdk-overlay-container']/descendant::div[@id='mat-select-6-panel']/child::mat-option[@role='option']")
	private List<WebElement> dropdist;
	
	@FindBy(xpath = "//button[@tabindex='0']")
	private WebElement searchButton;
	
	@FindBy(xpath = "//div[@class='form-check']/child::input[@class='chk-btn']/following-sibling::label[text()='18+']")
	private WebElement age;
	
	@FindBy(xpath = "//div[@class='filter-section pt-4 mb-4 ng-star-inserted']/descendant::li/span[@class='accessibility-plugin-ac']/following-sibling::span[text()='18+ ']")
	private WebElement resultAge;
	
	@FindBy(xpath = "//div[@class='form-check']/child::input[@class='chk-btn']/following-sibling::label[text()='Dose 1']")
	private WebElement dose;

	@FindBy(xpath = "//li[@class='ng-star-inserted']/span[@class='accessibility-plugin-ac']/following-sibling::span[text()='1']")
	private WebElement resultDose;

	@FindBy(xpath = "//div[@class='form-check']/child::input[@class='chk-btn']/following-sibling::label[text()='Paid']")
	private WebElement cost;
	
	@FindBy(xpath = "//li[@class='ng-star-inserted']/span[@class='accessibility-plugin-ac']/following-sibling::span[text()='Paid']")
	private WebElement resultCost;
	
	@FindBy(xpath = "//li[@class='ng-star-inserted']/descendant::div/div/input[@class='chk-btn']/following-sibling::label[text()='Covishield']")
	private WebElement vaccine;
	
	@FindBy(xpath = "//li[@class='ng-star-inserted']/span[@class='accessibility-plugin-ac']/following-sibling::span[text()='COVISHIELD']")
	private WebElement resultVaccine;
	
	@FindBy(xpath = "//div[@class='mobile-hide slots-availablity-table ng-star-inserted']/descendant::div[@class='row-disp']/h5[text()=' CRI Trust CVC ']/following-sibling::p[text()=' Saravanampatti Coimbatore, Coimbatore, Tamil Nadu, 641035 ']")
	private WebElement centres;
	
	public WebElement getCategory() {
		return category;
	}

	public WebElement getState() {
		return state;
	}

	public List<WebElement> getDropState() {
		return dropState;
	}

	public WebElement getStateList() {
		return stateList;
	}

	public List<WebElement> getDropdist() {
		return dropdist;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	public WebElement getAge() {
		return age;
	}

	public WebElement getResultAge() {
		return resultAge;
	}

	public WebElement getDose() {
		return dose;
	}

	public WebElement getResultDose() {
		return resultDose;
	}

	public WebElement getCost() {
		return cost;
	}

	public WebElement getResultCost() {
		return resultCost;
	}

	public WebElement getVaccine() {
		return vaccine;
	}

	public WebElement getResultVaccine() {
		return resultVaccine;
	}

	public WebElement getCentres() {
		return centres;
	}

	public Cowin_HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
