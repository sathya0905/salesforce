package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.SalesForceWrappers;

public class CampainsCollectionPage extends SalesForceWrappers{
	
	public CampainsCollectionPage(RemoteWebDriver driver, ExtentTest test)
	{
		this.driver = driver;
		
		this.test = test;
		
		if(!verifyTitle("Campaigns ~ Salesforce - Developer Edition")){
			reportStep("This is not campaings collection page.", "FAIL");
		}
	}
	
	public NewCampaignCreatepage clickNewFromCollectionPage()
	{
		clickByName("new");
		
		return new NewCampaignCreatepage(driver, test);
	}
	
	

}
