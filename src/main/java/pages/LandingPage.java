package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.SalesForceWrappers;

public class LandingPage extends SalesForceWrappers {
	 
	public LandingPage(RemoteWebDriver driver,ExtentTest test)
	{
		this.driver = driver;
		
		this.test = test;
		
	}
	
	
	public HomePage clickHomeTab()
	{
		clickByLink("Home");
		
		return new HomePage(driver,test);
	}
	
	
	
	
	

}
