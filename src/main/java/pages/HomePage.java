package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.SalesForceWrappers;

public class HomePage extends SalesForceWrappers{
	
	public HomePage(RemoteWebDriver driver, ExtentTest test)
	{
		this.driver = driver;
		this.test = test;
		//if(!verifyTitle("Force.com Home Page ~ Salesforce - Developer Edition")){
			//reportStep("This is not sales force home page", "FAIL");
		//}
	}
	
	//click lead tab 
	public LeadsHome clickLeadTab()
	{
		clickByLink("Leads");
		return new LeadsHome(driver,test);
	}
	
	public CampaignsHome clickCampaignsTab()
	{
		clickByLink("Campaigns");
		
		return new CampaignsHome(driver,test);
	}
	
	public HomePage verifyUser(String user)
	{
		verifyTextById("userNavLabel", user);
		
		return this;
	}
	
	
	public HomePage clickUserMenuButton()
	{
		clickById("userNavButton");
		
		return this;
	}
	
	public LoginPage clickLogout()
	{
		clickByLink("Logout");
		
		return new LoginPage(driver,test);
	}
	
	public ProfilePage clickMyProfile()
	{
		clickByLink("My Profile");
		
		return new ProfilePage(driver,test);
	}
	
	

}
