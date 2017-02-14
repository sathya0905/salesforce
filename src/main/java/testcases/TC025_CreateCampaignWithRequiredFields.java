package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.SalesForceWrappers;

public class TC025_CreateCampaignWithRequiredFields extends SalesForceWrappers{
	
	@BeforeClass
	public void setValues(){
		browserName = "chrome";
		testCaseName = "Verify create campaigns with required fields";
		testDescription = "Verify create campaigns with required fields";
		category = "smoke";
		authors = "sathya";
		dataSheetName = "TC025";

	}

	@Test(dataProvider="fetchData")
	public void login(String username, String password, String verify, String emailUsername, String emailPassword, String campaignName){

		new LoginPage(driver, test)
		.enterUserName(username)
		.enterPassword(password)
		.clickLogin()
		.verifyText(verify)
		.enterCode(emailUsername, emailPassword)
		.clickVerify()
		.clickHomeTab()
		.clickCampaignsTab()
		.clickNew()
		.enterCampaignName(campaignName)
		.save()
		.verifyCampaignName(campaignName)
		.clickUserMenuButtonFromCampaignSpecificPage()
		.clickLogoutFromCampaignSpecificPage();
	}

}
