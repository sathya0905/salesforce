package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.SalesForceWrappers;

public class LeadsHome extends SalesForceWrappers{
	
	public LeadsHome(RemoteWebDriver driver, ExtentTest test)
	{
		this.driver = driver;
		this.test = test;
		if(!verifyTitle("Leads: Home ~ Salesforce - Developer Edition")){
			reportStep("This is not Leads Home page", "FAIL");
		}
	}
	
	
	public NewLeadCreatePage clickNewToCreateLead()
	{
		clickByName("new");
		return new NewLeadCreatePage(driver,test);
	}
	
	
	public LeadsCollectionPage selectViewType(String data)
	{
		selectVisibileTextById("fcf", data);
		
		return new LeadsCollectionPage(driver,test);
	}
	
	public LeadsCollectionPage clickGo()
	{
		clickByName("go");
		
		return new LeadsCollectionPage(driver,test);
	}
	
	public LeadsHome clickUserMenuButtonFromLeadHome()
	{
		clickById("userNavButton");
		
		return this;
	}
	
	public LoginPage clickLogoutFromLeadHome()
	{
		clickByLink("Logout");
		
		return new LoginPage(driver,test);
	}

}
