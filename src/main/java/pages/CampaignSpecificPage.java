package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.SalesForceWrappers;

public class CampaignSpecificPage extends SalesForceWrappers{
	
	public CampaignSpecificPage(RemoteWebDriver driver, ExtentTest test)
	{
		this.driver = driver;
		
		this.test = test;
	}
	
	public CampaignSpecificPage verifyCampaignName(String text)
	{
		verifyTextContainsByClassName("pageDescription", text);
		
		return this;
	}

}
