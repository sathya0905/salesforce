package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.SalesForceWrappers;

public class TC032_CampaignDelete extends SalesForceWrappers{
	
	@BeforeClass
	public void setValues(){
		browserName = "chrome";
		testCaseName = "Delete campaign";
		testDescription = "Delete campaign";
		category = "smoke";
		authors = "sathya";
		dataSheetName = "TC032";

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
		.searchCampaignAndDelete(campaignName)
		.clickUserMenuButtonFromCampaignCollectionPage()
		.clickLogoutFromCampaignCollectionPage();
		
		
	}

}
