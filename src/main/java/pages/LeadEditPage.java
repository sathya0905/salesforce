package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.SalesForceWrappers;

public class LeadEditPage extends SalesForceWrappers{
	
	public LeadEditPage(RemoteWebDriver driver, ExtentTest test)
	{
		this.driver = driver;
		
		this.test = test;
		
	}
	
	public LeadEditPage verifyLeadInEdit(String text)
	{
		verifyTextContainsByClassName("pageDescription", text);
		
		return this;
	}
	
	public LeadEditPage modifyFirstName(String data)
	{
		enterById("name_firstlea2", data);
		
		return this;
	}
	
	public LeadEditPage modifyLastName(String data)
	{
		enterById("name_lastlea2", data);
		
		return this;
	}
	
	public LeadEditPage modifyLeadStatus(String data)
	{
		selectVisibileTextById("lea13", data);
		
		return this;
	}
	
	public LeadEditPage modifyLeadRating(String data)
	{
		selectVisibileTextById("lea14", data);
		
		return this;
	}
	
	public LeadsCollectionPage updateLead()
	{
		clickByName("save");
		
		return new LeadsCollectionPage(driver, test);
		
	}
	
	public LeadEditPage clickUserMenuButtonFromLeadEditPage()
	{
		clickById("userNavButton");
		
		return this;
	}
	
	public NewLeadCreatePage clickSaveandNewinEdit()
	{
		clickByName("save_new");
		
		return new NewLeadCreatePage(driver, test);
	}
	
	public LoginPage clickLogoutFromLeadEditPage()
	{
		clickByLink("Logout");
		
		return new LoginPage(driver,test);
	}
}
