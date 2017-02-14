package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.SalesForceWrappers;

public class CampaignEditPage extends SalesForceWrappers{
	
	public CampaignEditPage(RemoteWebDriver driver, ExtentTest test)
	{
		this.driver = driver;
		
		this.test = test;
	}
	
	public CampaignEditPage verifyCampaignName(String campaignName)
	{
		//verifyTextContainsByClassName("CampaignEditPage", campaignName);
		verifyTextByXpath("//h2[@class='pageDescription']", campaignName);
		
		return this;
	}
	
	public CampaignEditPage modifyCampaignName(String data)
	{
		enterById("cpn1", data);
		return this;
	}
	
	public CampaignEditPage clickActive()
	{
		clickById("cpn16");
		
		return this;
	}
	
	public CampaignEditPage modifyCampaignType(String data)
	{
		selectVisibileTextById("cpn2", data);
		
		return this;
	}
	
	public CampaignEditPage modifyCampaignStatus(String data)
	{
		selectVisibileTextById("cpn3", data);
		
		return this;
	}
	
	public CampaignEditPage modifyStartDate(String date)
	{
		enterById("cpn5", date);
		
		return this;
	}
	
	public CampaignEditPage modifyEndDate(String date)
	{
		enterById("cpn6", date);
		
		return this;
	}
	
	public CampaignEditPage modifyExpectedRevenue(String data)
	{
		enterById("cpn8", data);
		
		return this;
	}
	
	public CampaignEditPage modifyBudgetCost(String data)
	{
		enterById("cpn9", data);
		
		return this;
	}
	
	public CampaignEditPage modifyActualCost(String data)
	{
		enterById("cpn10", data);
		
		return this;
	}
	
	public CampaignEditPage modifyDescription(String data)
	{
		enterById("cpn4", data);
		
		return this;
	}
	
	public CampainsCollectionPage save()
	{
		clickByName("save");
		
		return new CampainsCollectionPage(driver,test);
	}
	
	public NewCampaignCreatepage saveAndNew()
	{
		clickByName("save_new");
		
		return new NewCampaignCreatepage(driver, test);
	}
	
	public CampainsCollectionPage cancel()
	{
		clickByName("cancel");
		
		return new CampainsCollectionPage(driver, test);
	}
	
	public CampaignEditPage clickUserMenuButtonFromCampaignEditPage()
	{
		clickById("userNavButton");
		
		return this;
	}
	
	public LoginPage clickLogoutFromCampaignEditPage()
	{
		clickByLink("Logout");
		
		return new LoginPage(driver,test);
	}
	

}
