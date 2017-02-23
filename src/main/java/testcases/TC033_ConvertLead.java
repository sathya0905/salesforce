package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.SalesForceWrappers;

public class TC033_ConvertLead extends SalesForceWrappers{
	
	@BeforeClass
	public void setValues(){
		browserName = "chrome";
		testCaseName = "Convert Lead";
		testDescription = "Convert Lead";
		category = "smoke";
		authors = "sathya";
		dataSheetName = "TC033";

	}
	
	@Test(dataProvider="fetchData")
	public void login(String username, String password, String verify, String emailUsername, String emailPassword, String leadName, String verifyLeadname,String subject, String dueDate, String priority){

		new LoginPage(driver, test)
		.enterUserName(username)
		.enterPassword(password)
		.clickLogin()
		.verifyText(verify)
		.enterCode(emailUsername, emailPassword)
		.clickVerify()
		.clickHomeTab()
		.clickLeadTab()
		.clickGo()
		.searchAndClick(leadName)
		.verifyLeadName(verifyLeadname)
		.convertLead()
		.enterSubject(subject)
		.enterDueDate(dueDate)
		.selectPriority(priority)
		.convertLead()
		.clickUserMenuButtonFromAccountSpecPage()
		.clickLogoutFromAccountSpecPage();
	
			
	}

}
