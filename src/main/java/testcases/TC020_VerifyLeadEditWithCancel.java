package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.SalesForceWrappers;

public class TC020_VerifyLeadEditWithCancel extends SalesForceWrappers{
	
	@BeforeClass
	public void setValues(){
		browserName = "chrome";
		testCaseName = "Click Lead Edit with cancel";
		testDescription = "Click Lead Edit with cancel";
		category = "smoke";
		authors = "sathya";
		dataSheetName = "TC020";

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
		.clickCancelinEdit()
		.clickUserMenuButtonFromLeadCollectionPage()
		.clickLogoutFromLeadCollectionPage();

	}
	
	

}
