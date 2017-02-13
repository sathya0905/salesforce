package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.SalesForceWrappers;

public class TC013_CreateLeadFromLeadCollection extends SalesForceWrappers{
	
	@BeforeClass
	public void setValues(){
		browserName = "chrome";
		testCaseName = "Verify create lead from Lead collection page";
		testDescription = "Verify create lead from Lead collection page";
		category = "smoke";
		authors = "sathya";
		dataSheetName = "TC013";

	}
	
	@Test(dataProvider="fetchData")
	public void login(String username, String password, String verify, String emailUsername, String emailPassword, String lastName, String companyName, String leadStatus){

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
		.createNewLead()
		.enterLastName(lastName)
		.enterCompanyName(companyName)
		.selectLeadStatus(leadStatus)
		.clickSave()
		.clickUserMenuButtonFromLeadSpecPage()
		.clickLogoutFromLeadSpecPage();
	}

}
