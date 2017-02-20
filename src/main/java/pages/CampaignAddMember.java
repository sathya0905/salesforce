package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.SalesForceWrappers;

public class CampaignAddMember extends SalesForceWrappers{

	public CampaignAddMember(RemoteWebDriver driver, ExtentTest test) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		
		this.test = test;
		
		if(!verifyTitle("Campaign: Add Members ~ Salesforce - Developer Edition")){
			reportStep("This is not add campaign member", "FAIL");
		}
		
		
	}
	
	
	public CampaignAddMember addCampaignlookup()
	{
		clickByClassName("lookupIcon");
		
		return this;
	}
	

}
