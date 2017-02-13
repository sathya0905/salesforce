package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.SalesForceWrappers;

public class TC002_LoginFailure extends SalesForceWrappers{
	
	@BeforeClass
	public void setValues(){
		browserName = "chrome";
		testCaseName = "Login Failure";
		testDescription = "Login to sales force failure case";
		category = "smoke";
		authors = "sathya";
		dataSheetName = "TC002";
		
	}
	
	@Test(dataProvider="fetchData")
	public void login(String username, String password, String message){
		new LoginPage(driver, test)
		.enterUserName(username)
		.enterPassword(password)
		.clickLoginForFailure()
		.verifyLoginErrorMessage(message);
		
		
	}
	
	

}
