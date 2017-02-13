package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.SalesForceWrappers;

public class TC021_VerifyUpdatedLeadValues extends SalesForceWrappers{
	
	@BeforeClass
	public void setValues(){
		browserName = "chrome";
		testCaseName = "Verify Updated Lead Values";
		testDescription = "Verify the Updated Lead Values";
		category = "smoke";
		authors = "sathya";
		dataSheetName = "TC021";

	}
	
	@Test(dataProvider="fetchData")
	public void login(String username, String password, String verify, String emailUsername, String emailPassword, String leadName, String verifyLeadname, String leadStatus, String leadRating){

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
		.verifyLeadStatus(leadStatus)
		.verifyRatings(leadRating)
		.clickUserMenuButtonFromLeadSpecPage()
		.clickLogoutFromLeadSpecPage();
	}

}
