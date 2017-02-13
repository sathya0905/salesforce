package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.SalesForceWrappers;

public class TC022_VerifySearchAndDelee extends SalesForceWrappers{
	
	@BeforeClass
	public void setValues(){
		browserName = "chrome";
		testCaseName = "Verify search and Delete lead";
		testDescription = "Verify search and Delete lead";
		category = "smoke";
		authors = "sathya";
		dataSheetName = "TC022";

	}
	
	@Test(dataProvider="fetchData")
	public void login(String username, String password, String verify, String emailUsername, String emailPassword, String leadName){

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
		.searchLeadAndDelete(leadName)
		.clickUserMenuButtonFromLeadCollectionPage()
		.clickLogoutFromLeadCollectionPage();
		
	}

}
