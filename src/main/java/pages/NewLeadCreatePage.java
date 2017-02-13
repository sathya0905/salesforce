package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.SalesForceWrappers;

public class NewLeadCreatePage extends SalesForceWrappers{
	
	public NewLeadCreatePage(RemoteWebDriver driver, ExtentTest test)
	{
		this.driver = driver;
		this.test = test;
		if(!verifyTitle("Lead Edit: New Lead ~ Salesforce - Developer Edition")){
			reportStep("This is not New Lead Create page", "FAIL");
		}
	}
	
	
	public NewLeadCreatePage selectSalutation(String data)
	{
		selectVisibileTextById("name_salutationlea2", data);
		
		return this;
	}
	
	public NewLeadCreatePage enterFirstName(String data)
	{
		enterById("name_firstlea2", data);
		
		return this;
	}
	
	public NewLeadCreatePage enterLastName(String data)
	{
		enterById("name_lastlea2", data);
		
		return this;
	}
	
	public NewLeadCreatePage enterCompanyName(String data)
	{
		enterById("lea3", data);
		
		return this;
	}
	
	public NewLeadCreatePage enterTitle(String data)
	{
		enterById("lea4", data);
		
		return this;
	}
	
	public NewLeadCreatePage selectLeadSource(String data)
	{
		selectVisibileTextById("lea5", data);
		
		return this;
	}
	
	public NewLeadCreatePage selectIndustry(String data)
	{
		selectVisibileTextById("lea6", data);
		
		return this;
	}
	
	public NewLeadCreatePage enterAnnualRevenue(String data)
	{
		enterById("lea7", data);
		
		return this;
	}
	
	public NewLeadCreatePage enterPhoneNumber(String data)
	{
		enterById("lea8", data);
		
		return this;
	}
	
	public NewLeadCreatePage enterMobileNumber(String data)
	{
		enterById("lea9", data);
		
		return this;
	}
	
	public NewLeadCreatePage enterFax(String data)
	{
		enterById("lea10", data);
		
		return this;
	}
	
	public NewLeadCreatePage enterEmail(String data)
	{
		enterById("lea11", data);
		
		return this;
	}
	
	public NewLeadCreatePage selectLeadStatus(String data)
	{
		selectVisibileTextById("lea13", data);
		
		return this;
	}
	
	public NewLeadCreatePage selectRating(String data)
	{
		selectVisibileTextById("lea14", data);
		
		return this;
	}
	
	public NewLeadCreatePage enterNoOfEmployees(String data)
	{
		enterById("lea15", data);
		
		return this;
	}
	
	public NewLeadCreatePage enterStreet(String data)
	{
		enterById("lea16street", data);
		
		return this;
	}
	
	public NewLeadCreatePage enterCity(String data)
	{
		enterById("lea16city", data);
		
		return this;
	}
	
	public NewLeadCreatePage enterState(String data)
	{
		enterById("lea16state", data);
		
		return this;
	}
	
	public NewLeadCreatePage enterZIP(String data)
	{
		enterById("lea16zip", data);
		
		return this;
	}
	
	public NewLeadCreatePage enterCountry(String data)
	{
		enterById("lea16country", data);
		
		return this;
	}
	
	public NewLeadCreatePage enterDescription(String data)
	{
		enterById("lea17", data);
		
		return this;
	}
	
	public LeadsHome clickCancel()
	{
		clickByName("cancel");
		
		return new LeadsHome(driver,test);
	}
	
	public NewLeadCreatePage clickSaveAndNew()
	{
		clickByName("save_new");
		
		return this;
	}
	
	public LeadSpecificPage clickSave()
	{
		clickByName("save");
		
		return new LeadSpecificPage(driver,test);
	}
	
	public NewLeadCreatePage clickUserMenuButtonFromLeadCreatePage()
	{
		clickById("userNavButton");
		
		return this;
	}
	
	public LoginPage clickLogoutFromLeadCreatePage()
	{
		clickByLink("Logout");
		
		return new LoginPage(driver,test);
	}
	
	
	
	
	
}
