package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.SalesForceWrappers;

public class TC019_VerifyLeadEditSaveAndNew extends SalesForceWrappers{
	
	@BeforeClass
	public void setValues(){
		browserName = "chrome";
		testCaseName = "Click Lead Edit and Save/New";
		testDescription = "Click Lead Edit and Save/New";
		category = "smoke";
		authors = "sathya";
		dataSheetName = "TC019";

	}
	
	
	@Test(dataProvider="fetchData")
	public void login(String username, String password, String verify, String emailUsername, String emailPassword, String leadName, String verifyLeadname, String leadRating){

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
		.searchLeadAndEdit(leadName)
		.verifyLeadInEdit(verifyLeadname)
		.modifyLeadRating(leadRating)
		.clickSaveandNewinEdit()
		.clickUserMenuButtonFromLeadCreatePage()
		.clickLogoutFromLeadCreatePage();
		

	}

}
