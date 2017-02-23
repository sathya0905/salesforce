package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.SalesForceWrappers;

public class ConvertLeadPage extends SalesForceWrappers{

	public ConvertLeadPage(RemoteWebDriver driver, ExtentTest test) {
		// TODO Auto-generated constructor stub
		
		this.driver = driver;
		
		this.test = test;
		
		
	}
	
	public ConvertLeadPage enterSubject(String subject)
	{
		
		enterById("tsk5_fu", subject);
		
		return this;
	}
	
	public ConvertLeadPage enterDueDate(String date)
	{
		enterById("tsk4_fu", date);
		
		return this;
	}
	
	public ConvertLeadPage selectPriority(String priority)
	{
		selectVisibileTextById("tsk13_fu", priority);
		
		return this;
	}
	
	public AccountSpecPage convertLead()
	{
		clickByName("save");
		
		return new AccountSpecPage(driver, test);
		
		
	}

}
