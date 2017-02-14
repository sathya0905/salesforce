package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.SalesForceWrappers;

public class CampaignsHome extends SalesForceWrappers{
	
	public CampaignsHome(RemoteWebDriver driver,ExtentTest test)
	{
		this.driver = driver;
		
		this.test = test;
		
		if(!verifyTitle("Campaigns: Home ~ Salesforce - Developer Edition")){
			reportStep("This is not campaigns home page", "FAIL");
		}
	}
	
	public NewCampaignCreatepage clickNew()
	{
		clickByName("new");
		
		return new NewCampaignCreatepage(driver,test);
	}
	
	public CampainsCollectionPage clickGo()
	{
		clickByName("go");
		
		return new CampainsCollectionPage(driver, test);
	}
	
	public CampaignsHome clickUserMenuButtonFromCampaignHomePage()
	{
		clickById("userNavButton");
		
		return this;
	}
	
	public LoginPage clickLogoutFromCampaignHomePage()
	{
		clickByLink("Logout");
		
		return new LoginPage(driver,test);
	}

}
