package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.SalesForceWrappers;

public class TC016_VerifyLeadFilter extends SalesForceWrappers{
	
	@BeforeClass
	public void setValues(){
		browserName = "chrome";
		testCaseName = "Verify view type";
		testDescription = "Verify view type";
		category = "smoke";
		authors = "sathya";
		dataSheetName = "TC016";

	}
	
	@Test(dataProvider="fetchData")
	public void login(String username, String password, String verify, String emailUsername, String emailPassword, String viewType){

		new LoginPage(driver, test)
		.enterUserName(username)
		.enterPassword(password)
		.clickLogin()
		.verifyText(verify)
		.enterCode(emailUsername, emailPassword)
		.clickVerify()
		.clickHomeTab()
		.clickLeadTab()
		.selectViewType(viewType);
		
			
	}

}
