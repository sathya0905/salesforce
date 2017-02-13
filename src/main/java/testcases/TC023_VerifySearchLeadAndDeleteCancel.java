package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.SalesForceWrappers;

public class TC023_VerifySearchLeadAndDeleteCancel extends SalesForceWrappers{
	
	@BeforeClass
	public void setValues(){
		browserName = "chrome";
		testCaseName = "Verify search lead and Delete cancel";
		testDescription = "Verify search lead and Delete cancel";
		category = "smoke";
		authors = "sathya";
		dataSheetName = "TC023";

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
		.searchLeadAndDeleteCancel(leadName)
		.clickUserMenuButtonFromLeadCollectionPage()
		.clickLogoutFromLeadCollectionPage();
		
	}

}
