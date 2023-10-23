package com.RunnerClass;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.Maven_Cowin.Cowin_Base;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src//test//java//com//feature//Cowin.feature",
glue = "com.StepDefinition",
monochrome = true,plugin = {"pretty", "html:Report/fb_htmlreport.html","json:Report/fb_jsonreport.json","junit:Report/fb_junitreport.xml"})
public class Cowin_Runner extends Cowin_Base {

	@BeforeClass
	public static void setUp() {
		browserLaunch("chrome");
	}

	@AfterClass
	public static void tearDown() {
		close();
	}
	
}
