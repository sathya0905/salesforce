package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.SalesForceWrappers;

public class TC031_CampaignEditAndSave extends SalesForceWrappers{
	
	@BeforeClass
	public void setValues(){
		browserName = "chrome";
		testCaseName = "Edit campaign and save";
		testDescription = "Edit campaign and save";
		category = "smoke";
		authors = "sathya";
		dataSheetName = "TC031";

	}
	
	@Test(dataProvider="fetchData")
	public void login(String username, String password, String verify, String emailUsername, String emailPassword, String campaignName, String endDate, String desc){

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
		.modifyEndDate(endDate)
		.modifyDescription(desc)
		.save()
		.clickUserMenuButtonFromCampaignCollectionPage()
		.clickLogoutFromCampaignCollectionPage();
		
		
	}

}
