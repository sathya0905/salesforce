package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.SalesForceWrappers;

public class TC017_VerifyClickEditLead extends SalesForceWrappers{
	
	@BeforeClass
	public void setValues(){
		browserName = "chrome";
		testCaseName = "Click Edit Lead";
		testDescription = "Click Edit Lead";
		category = "smoke";
		authors = "sathya";
		dataSheetName = "TC017";

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
		.searchLeadAndEdit(leadName)
		.verifyLeadInEdit(verifyLeadname)
		.clickUserMenuButtonFromLeadEditPage()
		.clickLogoutFromLeadEditPage();

}
	
}
