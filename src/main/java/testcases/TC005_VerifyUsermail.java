package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.SalesForceWrappers;

public class TC005_VerifyUsermail extends SalesForceWrappers{
	
	@BeforeClass
	public void setValues(){
		browserName = "chrome";
		testCaseName = "Verify User Email";
		testDescription = "Verify the code";
		category = "smoke";
		authors = "sathya";
		dataSheetName = "TC005";

	}
	
	@Test(dataProvider="fetchData")
	public void login(String username, String password, String verify, String emailUsername, String emailPassword, String verifyUserMail){

		new LoginPage(driver, test)
		.enterUserName(username)
		.enterPassword(password)
		.clickLogin()
		.verifyText(verify)
		.enterCode(emailUsername, emailPassword)
		.clickVerify()
		.clickHomeTab()
		.clickUserMenuButton()
		.clickMyProfile()
		.clickEditDropdown()
		.clickEditProfile()
		.goToEditPop()
		.clickContactTab()
		.verifyEmail(verifyUserMail)
		.clickCancelFromContact()
		.clickHomeTabFromProfile()
		.clickUserMenuButton()
		.clickLogout();
	}

	
	

}
