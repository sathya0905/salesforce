package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.SalesForceWrappers;

public class NewCampaignCreatepage extends SalesForceWrappers{
	
	public NewCampaignCreatepage(RemoteWebDriver driver,ExtentTest test)
	{
		this.driver = driver;
		
		this.test = test;
		
		if(!verifyTitle("Campaign Edit: New Campaign ~ Salesforce - Developer Edition")){
			reportStep("This is not campaigns create page", "FAIL");
		}
	}
	
	public NewCampaignCreatepage enterCampaignName(String data)
	{
		enterById("cpn1", data);
		return this;
	}
	
	public NewCampaignCreatepage clickActive()
	{
		clickById("cpn16");
		
		return this;
	}
	
	public NewCampaignCreatepage selectCampaignType(String data)
	{
		selectVisibileTextById("cpn2", data);
		
		return this;
	}
	
	public NewCampaignCreatepage selectCampaignStatus(String data)
	{
		selectVisibileTextById("cpn3", data);
		
		return this;
	}
	
	public NewCampaignCreatepage selectStartDate(String date)
	{
		enterById("cpn5", date);
		
		return this;
	}
	
	public NewCampaignCreatepage selectEndDate(String date)
	{
		enterById("cpn6", date);
		
		return this;
	}
	
	public NewCampaignCreatepage enterExpectedRevenue(String data)
	{
		enterById("cpn8", data);
		
		return this;
	}
	
	public NewCampaignCreatepage enterBudgetCost(String data)
	{
		enterById("cpn9", data);
		
		return this;
	}
	
	public NewCampaignCreatepage enterActualCost(String data)
	{
		enterById("cpn10", data);
		
		return this;
	}
	
	public NewCampaignCreatepage enterDescription(String data)
	{
		enterById("cpn4", data);
		
		return this;
	}
	
	public CampaignSpecificPage save()
	{
		clickByName("save");
		
		return new CampaignSpecificPage(driver,test);
	}
	
	public NewCampaignCreatepage saveAndNew()
	{
		clickByName("save_new");
		
		return this;
	}
	
	public void cancel()
	{
		clickByName("cancel");
	}
	
	public NewCampaignCreatepage clickUserMenuButtonFromCampaignCreatePage()
	{
		clickById("userNavButton");
		
		return this;
	}
	
	public LoginPage clickLogoutFromCampaignCreatePage()
	{
		clickByLink("Logout");
		
		return new LoginPage(driver,test);
	}
	

}
