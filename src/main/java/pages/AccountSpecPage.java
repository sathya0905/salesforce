package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.SalesForceWrappers;

public class AccountSpecPage extends SalesForceWrappers{

	public AccountSpecPage(RemoteWebDriver driver, ExtentTest test) {
		// TODO Auto-generated constructor stub
		
		this.driver = driver;
		
		this.test = test;
	}
	
	public AccountSpecPage clickUserMenuButtonFromAccountSpecPage()
	{
		clickById("userNavButton");
		
		return this;
	}
	
	public LoginPage clickLogoutFromAccountSpecPage()
	{
		clickByLink("Logout");
		
		return new LoginPage(driver,test);
	}

}
