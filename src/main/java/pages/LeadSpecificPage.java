package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.SalesForceWrappers;

public class LeadSpecificPage extends SalesForceWrappers{
	
	public LeadSpecificPage(RemoteWebDriver driver, ExtentTest test)
	{
		this.driver = driver;
		
		this.test = test;
	}
	
	public LeadSpecificPage verifyLeadName(String text)
	{
		verifyTextContainsByXpath("//h2[@class='topName']", text);
		
		return this;
	}
	
	public LeadSpecificPage clickUserMenuButtonFromLeadSpecPage()
	{
		clickById("userNavButton");
		
		return this;
	}
	
	public LoginPage clickLogoutFromLeadSpecPage()
	{
		clickByLink("Logout");
		
		return new LoginPage(driver,test);
	}
	
	public LeadSpecificPage verifyLeadStatus(String leadStatus)
	{
		verifyTextById("lea13_ileinner", leadStatus);
		
		return this;
	}
	
	public LeadSpecificPage verifyLeadTitle(String leadTitle)
	{
		verifyTextById("lea4_ileinner", leadTitle);
		
		return this;
	}
	
	public LeadSpecificPage verifyRatings(String rating)
	{
		verifyTextById("lea14_ileinner", rating);
		
		return this;
	}

}
