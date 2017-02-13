package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.SalesForceWrappers;

public class LoginPage extends SalesForceWrappers{

	public LoginPage(RemoteWebDriver driver, ExtentTest test){
		
		this.driver = driver;
		
		this.test = test;
		//if(!verifyTitle("Login | Salesforce")){
		//	reportStep("This is not Login Page", "FAIL");
		//}
	}
	
	public LoginPage enterUserName(String data){
		enterById("username", data);
		return this;
	}
	
	public LoginPage enterPassword(String data){
		enterById("password", data);
		return this;
	}
	
	public VerifyPage clickLogin(){
		clickById("Login");
		return new VerifyPage(driver,test);
	}
	
	public LoginPage clickLoginForFailure(){
		clickById("Login");
		return this;
	}
	
	public LoginPage checkRemember()
	{
		if(isNotSelectedByID("rememberUn")){
		clickById("rememberUn");
		}
		return this;
	}
	
	public LoginPage verifyLoginErrorMessage(String message)
	{
		verifyTextById("error", message);
		
		return this;
	}
	
	
}
