package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.SalesForceWrappers;

public class TC014_SearchAndSelectLead extends SalesForceWrappers{
	
	@BeforeClass
	public void setValues(){
		browserName = "chrome";
		testCaseName = "Search and Select lead";
		testDescription = "Search and Select lead";
		category = "smoke";
		authors = "sathya";
		dataSheetName = "TC014";

	}
	
	@Test(dataProvider="fetchData")
	public void login(String username, String password, String verify, String emailUsername, String emailPassword, String leadName, String verifyLeadname){

		new LoginPage(driver, test)
		.enterUserName(username)
		.enterPassword(password)
		.clickLogin()
		.verifyText(verify)
		.enterCode(emailUsername, emailPassword)
		.clickVerify()
		.clickHomeTab()
		.clickLeadTab()
		.clickGo()
		.searchAndClick(leadName)
		.verifyLeadName(verifyLeadname)
		.clickUserMenuButtonFromLeadSpecPage()
		.clickLogoutFromLeadSpecPage();
	
			
	}

}
