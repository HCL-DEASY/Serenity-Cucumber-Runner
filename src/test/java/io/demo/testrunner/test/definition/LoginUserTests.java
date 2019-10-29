package io.demo.testrunner.test.definition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.demo.testrunner.test.steps.LoginSteps;
import io.demo.testrunner.test.tdmdata.FindTDMData;
import net.serenitybdd.cucumber.suiteslicing.TestScenarioResult;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.model.TestTag;
import net.thucydides.core.steps.StepEventBus;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.Set;

import org.springframework.core.io.ClassPathResource;


public class LoginUserTests {
	
	@Steps
	private LoginSteps login;
	private FindTDMData tdmData = new FindTDMData();
	private String user;
	private String use= "SystemTest"; 
	private String get = "username";
	private String from = "Login";
	private String where ;
	ClassPathResource resource = new ClassPathResource("application.properties");
	Properties p = new Properties();
	InputStream inputStream = null;
	
	/** Given **/
	@Given("^(.*) is a registered user$")
	public void registeredUser (String persona) {
	
	}
	
	@And("^he or she has an expired account$")
	public void expiredAccount (){
	
	}
	
	@And("^he or she has an account with expired credentials$")
	public void expiredAccountCredentials (){
		// TODO Data provisioning to get or define user with this criteria
	}
	
	@And("^he or she has a locked account$")
	public void lockedAccount (){
		

	}
	
	@And("^he or she has a disabled account$")
	public void disabledAccount (){
	
	}
	
	/** When **/
	@When("^(.*) navigates to the Login page$")
	public void userAtLoginPage (String persona) {
		login.navigateToLoginPage();
	}

	@When("^he or she enters '(.*)' into the login Username field$")
	public void enterUserName (String username) {
		
		
		try {
		login.enterUsername (tdmData.fetchTestData(use, get, from, username));
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	@And("^he or she enters '(.*)' into the login Password field$")
	public void enterPassword (String password){
		login.enterPassword (password);
	}
	
	@And("^he or she clicks the Remember Me checkbox$")
	public void clickRememberMe (){
		login.clickRememberMe();
	}
	
	@And("^he or she submits the login request$")
	public void clickSubmit (){
		login.clickSubmit ();
	}
	
	/** Then **/
	
	@Then("^(.*) verifies he or she is presented with a error message indicating invalid credentials or access denied$")
	public void presentedErrorMessage (String persona){
		login.presentedErrorMessage();
	}
	
	@Then("^(.*) verifies he or she is at the Home page$")
	public void redirectToHomePage (String persona){
		login.redirectedToHomePage();
	}
	
	@And("^he or she verifies the remember-me cookie is not present$")
	public void rememberMeNotPresent (){
		login.remeberMeCookieNotPresent();
	}
	
	@And("^he or she verifies the remember-me cookie is present$")
	public void rememberMeIsPresent (){
		login.remeberMeCookiePresent();
	}
	
	@And("^he or she verifies login (.*) contains (.*)$")
	public void fieldContainsValue (String field, String value){
		login.assertFieldContainsValue(field, value);
	}

		
}
