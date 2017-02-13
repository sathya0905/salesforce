package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.SalesForceWrappers;

public class TC001_Login extends SalesForceWrappers{
	
	@BeforeClass
	public void setValues(){
		browserName = "chrome";
		testCaseName = "Login";
		testDescription = "Login to sales force";
		category = "smoke";
		authors = "sathya";
		dataSheetName = "TC001";
		
	}
	
	@Test(dataProvider="fetchData")
	public void login(String username, String password, String verify){
		new LoginPage(driver, test)
		.enterUserName(username)
		.enterPassword(password)
		.clickLogin()
		.verifyText(verify);
		/*.enterPassword(password)
		.clickLogin()
		.verifyText(verify);*/
		
	}
}
