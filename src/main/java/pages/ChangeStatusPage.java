package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.SalesForceWrappers;

public class ChangeStatusPage extends SalesForceWrappers{
	
	public ChangeStatusPage(RemoteWebDriver driver, ExtentTest test)
	{
		this.driver = driver;
		
		this.test = test;
		
		if(!verifyTitle("Leads ~ Salesforce - Developer Edition")){
			reportStep("This is not leads collection page", "FAIL");
		}
	}
	
	public ChangeStatusPage selectNewStatus(String status)
	{
		selectVisibileTextById("p0", status);
		
		return this;
	}
	
	public LeadsCollectionPage saveStatus()
	{
		clickByName("save");
		
		return new LeadsCollectionPage(driver, test);
	}
	
	public LeadsCollectionPage cancelStatusUpdate()
	{
		clickByName("cancel");
		
		return new LeadsCollectionPage(driver, test);
	}

}
