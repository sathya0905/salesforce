package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.SalesForceWrappers;

public class TC026_CreateCampaignWithSaveAndNew extends SalesForceWrappers{

	@BeforeClass
	public void setValues(){
		browserName = "chrome";
		testCaseName = "Verify create campaigns with save and new";
		testDescription = "Verify create campaigns with save and new";
		category = "smoke";
		authors = "sathya";
		dataSheetName = "TC026";

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
		.saveAndNew()
		.clickUserMenuButtonFromCampaignCreatePage()
		.clickLogoutFromCampaignCreatePage();
	}

}
