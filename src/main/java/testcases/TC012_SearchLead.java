package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.SalesForceWrappers;

public class TC012_SearchLead extends SalesForceWrappers {
	
	@BeforeClass
	public void setValues(){
		browserName = "chrome";
		testCaseName = "Search lead in table";
		testDescription = "Search lead in table";
		category = "smoke";
		authors = "sathya";
		dataSheetName = "TC012";

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
		.searchLeadInTable(leadName)
		.clickUserMenuButtonFromLeadCollectionPage()
		.clickLogoutFromLeadCollectionPage();
			
	}

}
