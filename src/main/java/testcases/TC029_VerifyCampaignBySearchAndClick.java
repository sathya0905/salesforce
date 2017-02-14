package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.SalesForceWrappers;

public class TC029_VerifyCampaignBySearchAndClick extends SalesForceWrappers{
	
	@BeforeClass
	public void setValues(){
		browserName = "chrome";
		testCaseName = "Verify campaign by Seacrh and Click in Collection page";
		testDescription = "Verify campaign by Seacrh and Click in Collection page";
		category = "smoke";
		authors = "sathya";
		dataSheetName = "TC029";

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
		.clickGo()
		.searchAndClick(campaignName)
		.verifyCampaignName(campaignName)
		.clickUserMenuButtonFromCampaignSpecificPage()
		.clickLogoutFromCampaignSpecificPage();
	}

}
