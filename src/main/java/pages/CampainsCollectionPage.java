package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
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
	
	public CampaignSpecificPage searchAndClick(String campaignName)
	{
		try{
			List<WebElement> tables = driver.findElements(By.tagName("table"));
			
			for(WebElement table : tables)
			{
				List<WebElement> rows = table.findElements(By.tagName("tr"));
				
				for(int i = 0;i<rows.size();i++)
				{
					List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));
					
					for(int j = 0;j<columns.size();j++)
					{
						if(columns.get(j).getText().equals(campaignName))
						{
							columns.get(j).click();
							
							break;
							
						}
					}
				}
			}
			
			}catch(StaleElementReferenceException e)
			{
				e.printStackTrace();
				System.out.println("Stale element reference exception");
			}
		
		return new CampaignSpecificPage(driver, test);
	}
	
	public CampaignEditPage searchCampaignAndEdit(String campaignName)
	{
		try{
			List<WebElement> tables = driver.findElements(By.tagName("table"));
			
			for(WebElement table : tables)
			{
				List<WebElement> rows = table.findElements(By.tagName("tr"));
				
				for(int i = 0;i<rows.size();i++)
				{
					List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));
					
					for(int j = 0;j<columns.size();j++)
					{
						if(columns.get(j).getText().equals(campaignName))
						{
							List<WebElement> links = columns.get(j-1).findElements(By.tagName("a"));
							
							for(WebElement link : links)
							{
								if(link.getText().equals("Edit")){
									link.click();
									break;
								}
							}
						}
					}
				}
			}
			
			}catch(StaleElementReferenceException e)
			{
				e.printStackTrace();
				System.out.println("Stale element reference exception");
			}
		
		return new CampaignEditPage(driver,test);
	}
	
	public CampainsCollectionPage searchCampaignAndDelete(String campaignName)
	{
		wait(5000);
		try{
			List<WebElement> tables = driver.findElements(By.tagName("table"));
			
			for(WebElement table : tables)
			{
				List<WebElement> rows = table.findElements(By.tagName("tr"));
				
				for(int i = 0;i<rows.size();i++)
				{
					List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));
					
					for(int j = 0;j<columns.size();j++)
					{
						if(columns.get(j).getText().equals(campaignName))
						{
							List<WebElement> links = columns.get(j-1).findElements(By.tagName("a"));
							
							for(WebElement link : links)
							{
								if(link.getText().equals("Del")){
									link.click();
									wait(5000);
									acceptAlert();
									break;
								}
							}
						}
					}
				}
			}
			
			}catch(StaleElementReferenceException e)
			{
				e.printStackTrace();
				System.out.println("Stale element reference exception");
			}
		
		return this;
	}
	
	
	public CampainsCollectionPage clickUserMenuButtonFromCampaignCollectionPage()
	{
		clickById("userNavButton");
		
		return this;
	}
	
	public LoginPage clickLogoutFromCampaignCollectionPage()
	{
		clickByLink("Logout");
		
		return new LoginPage(driver,test);
	}
	

}
