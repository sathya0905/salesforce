package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.SalesForceWrappers;

public class TC024_CreateCampaignWithAllFields extends SalesForceWrappers{

	@BeforeClass
	public void setValues(){
		browserName = "chrome";
		testCaseName = "Verify create campaigns with all fields";
		testDescription = "Verify create campaigns with all fields";
		category = "smoke";
		authors = "sathya";
		dataSheetName = "TC024";

	}

	@Test(dataProvider="fetchData")
	public void login(String username, String password, String verify, String emailUsername, String emailPassword, String campaignName,String conferenceType, String conferenceStatus, String startDate, String endDate, String expectedRevenue, String budgetCost, String actualCost, String description){

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
		.clickActive()
		.selectCampaignType(conferenceType)
		.selectCampaignStatus(conferenceStatus)
		.selectStartDate(startDate)
		.selectEndDate(endDate)
		.enterExpectedRevenue(expectedRevenue)
		.enterBudgetCost(budgetCost)
		.enterActualCost(actualCost)
		.enterDescription(description)
		.save()
		.verifyCampaignName(campaignName)
		.clickUserMenuButtonFromCampaignSpecificPage()
		.clickLogoutFromCampaignSpecificPage();
	}

}
