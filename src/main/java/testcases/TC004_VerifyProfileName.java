package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.SalesForceWrappers;

public class TC004_VerifyProfileName extends SalesForceWrappers{
	
	@BeforeClass
	public void setValues(){
		browserName = "chrome";
		testCaseName = "Verify Profile name";
		testDescription = "Verify the code";
		category = "smoke";
		authors = "sathya";
		dataSheetName = "TC004";

	}
	
	@Test(dataProvider="fetchData")
	public void login(String username, String password, String verify, String emailUsername, String emailPassword, String verifyUser){

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
		.verifyUserProfileName(verifyUser)
		.clickHomeTabFromProfile()
		.clickUserMenuButton()
		.clickLogout();
	}

}
