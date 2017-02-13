package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.SalesForceWrappers;

public class TC006_EditUserProfile extends SalesForceWrappers{
	
	@BeforeClass
	public void setValues(){
		browserName = "chrome";
		testCaseName = "Update Profile";
		testDescription = "Verify the code";
		category = "smoke";
		authors = "sathya";
		dataSheetName = "TC006";

	}
	
	
	@Test(dataProvider="fetchData")
	public void login(String username, String password, String verify, String emailUsername, String emailPassword, String title, String aboutMe, String verifyUserMail, String street, String city, String state){

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
		.enterTitle(title)
		.enterAboutMe(aboutMe)
		.clickContactTab()
		.verifyEmail(verifyUserMail)
		.enterStreet(street)
		.enterCity(city)
		.enterState(state)
		.clickSaveAll()
		.clickHomeTabFromProfile()
		.clickUserMenuButton()
		.clickLogout();
	}

}
