package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.SalesForceWrappers;

public class TC030_VerifySearchCampaignAndClickEdit extends SalesForceWrappers{
	
	@BeforeClass
	public void setValues(){
		browserName = "chrome";
		testCaseName = "Verify search campaign and Click Edit in Collection page";
		testDescription = "Verify search campaign and Click Edit in Collection page";
		category = "smoke";
		authors = "sathya";
		dataSheetName = "TC030";

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
		.searchCampaignAndEdit(campaignName)
		.verifyCampaignName(campaignName)
		.clickUserMenuButtonFromCampaignEditPage()
		.clickLogoutFromCampaignEditPage();
		
	}

}
