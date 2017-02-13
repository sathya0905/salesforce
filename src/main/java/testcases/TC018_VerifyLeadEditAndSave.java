package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.SalesForceWrappers;

public class TC018_VerifyLeadEditAndSave extends SalesForceWrappers{

	@BeforeClass
	public void setValues(){
		browserName = "chrome";
		testCaseName = "Click Lead Edit and Save";
		testDescription = "Click Lead Edit and Save";
		category = "smoke";
		authors = "sathya";
		dataSheetName = "TC018";

	}

	@Test(dataProvider="fetchData")
	public void login(String username, String password, String verify, String emailUsername, String emailPassword, String leadName, String verifyLeadname, String leadStatus){

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
		.modifyLeadStatus(leadStatus)
		.updateLead()
		.clickUserMenuButtonFromLeadCollectionPage()
		.clickLogoutFromLeadCollectionPage();

	}
}
