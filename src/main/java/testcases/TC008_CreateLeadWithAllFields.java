package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.SalesForceWrappers;

public class TC008_CreateLeadWithAllFields extends SalesForceWrappers{
	
	@BeforeClass
	public void setValues(){
		browserName = "chrome";
		testCaseName = "Verify create lead with all fields";
		testDescription = "Verify create lead with all fields";
		category = "smoke";
		authors = "sathya";
		dataSheetName = "TC008";

	}
	
	@Test(dataProvider="fetchData")
	public void login(String username, String password, String verify, String emailUsername, String emailPassword, String salutation,String firstName, String lastName, String companyName, String title, String leadSource, String industry, String annualRevenue, String phoneNum, String mobileNum, String leadStatus, String rating, String numofemployees){

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
		.selectSalutation(salutation)
		.enterFirstName(firstName)
		.enterLastName(lastName)
		.enterCompanyName(companyName)
		.enterTitle(title)
		.selectLeadSource(leadSource)
		.selectIndustry(industry)
		.enterAnnualRevenue(annualRevenue)
		.enterPhoneNumber(phoneNum)
		.enterMobileNumber(mobileNum)
		.selectLeadStatus(leadStatus)
		.selectRating(rating)
		.enterNoOfEmployees(numofemployees)
		.clickSave()
		.clickUserMenuButtonFromLeadSpecPage()
		.clickLogoutFromLeadSpecPage();
	}

}
