package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.SalesForceWrappers;

public class TC007_VerifyProfileUpdate extends SalesForceWrappers{
	
	
	@BeforeClass
	public void setValues(){
		browserName = "chrome";
		testCaseName = "Verify profile updated value";
		testDescription = "Verify the code";
		category = "smoke";
		authors = "sathya";
		dataSheetName = "TC007";

	}
	
	@Test(dataProvider="fetchData")
	public void login(String username, String password, String verify, String emailUsername, String emailPassword, String aboutMe){

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
		.clickOverview()
		.verifyAboutSection(aboutMe)
		.clickHomeTabFromProfile()
		.clickUserMenuButton()
		.clickLogout();
	}

}
