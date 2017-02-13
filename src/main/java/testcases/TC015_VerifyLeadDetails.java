package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.SalesForceWrappers;

public class TC015_VerifyLeadDetails extends SalesForceWrappers{
	
	@BeforeClass
	public void setValues(){
		browserName = "chrome";
		testCaseName = "Verify Lead Details";
		testDescription = "Verify Lead Details";
		category = "smoke";
		authors = "sathya";
		dataSheetName = "TC015";

	}
	
	@Test(dataProvider="fetchData")
	public void login(String username, String password, String verify, String emailUsername, String emailPassword, String leadName, String verifyLeadname, String leadTitle, String leadStatus, String rating){

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
		.verifyLeadTitle(leadTitle)
		.verifyLeadStatus(leadStatus)
		.verifyRatings(rating)
		.clickUserMenuButtonFromLeadSpecPage()
		.clickLogoutFromLeadSpecPage();
	
			
	}

}
