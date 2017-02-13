package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.SalesForceWrappers;

public class TC010_CreateLeadeWithSaveAndNew extends SalesForceWrappers{
	
	@BeforeClass
	public void setValues(){
		browserName = "chrome";
		testCaseName = "Verify create lead with save and new";
		testDescription = "Verify create lead with save and new";
		category = "smoke";
		authors = "sathya";
		dataSheetName = "TC010";

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
		.clickNewToCreateLead()
		.enterLastName(lastName)
		.enterCompanyName(companyName)
		.selectLeadStatus(leadStatus)
		.clickSaveAndNew();
		
	}

}
