package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.SalesForceWrappers;

public class LeadsCollectionPage extends SalesForceWrappers{

	public LeadsCollectionPage(RemoteWebDriver driver, ExtentTest test)
	{
		this.driver = driver;
		
		this.test = test;
		
		if(!verifyTitle("Leads ~ Salesforce - Developer Edition")){
			reportStep("This is not leads collection page", "FAIL");
		}
	}
	
	public LeadEditPage searchLeadAndEdit(String leadName)
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
						if(columns.get(j).getText().equals(leadName))
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
		
		return new LeadEditPage(driver,test);
	}
	
	public LeadsCollectionPage searchLeadAndDelete(String leadName)
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
						if(columns.get(j).getText().equals(leadName))
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
	
	
	public LeadsCollectionPage searchLeadAndDeleteCancel(String leadName)
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
						if(columns.get(j).getText().equals(leadName))
						{
							List<WebElement> links = columns.get(j-1).findElements(By.tagName("a"));
							
							for(WebElement link : links)
							{
								if(link.getText().equals("Del")){
									link.click();
									wait(5000);
									dismissAlert();
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
	
	
	public LeadsCollectionPage clickOkForDeleteConfirm()
	{
		acceptAlert();
		
		return this;
	}
	
	public LeadsCollectionPage clickCancelForDeleteConfirm()
	{
		dismissAlert();
		
		return this;
	}
	
	public NewLeadCreatePage createNewLead()
	{
		clickByName("new");
		
		return new NewLeadCreatePage(driver, test);
	}
	
	public LeadsCollectionPage searchLeadInTable(String leadName)
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
						if(columns.get(j).getText().equals(leadName))
						{
							reportStep("Lead"+ leadName +"matched in the table", "PASS");
							break;
						}else{
							reportStep("Lead"+ leadName +"does not match in the table", "FAIL");
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
	
	public LeadSpecificPage searchAndClick(String leadName)
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
						if(columns.get(j).getText().equals(leadName))
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
		
		return new LeadSpecificPage(driver, test);
	}
	
	public LeadsCollectionPage clickUserMenuButtonFromLeadCollectionPage()
	{
		clickById("userNavButton");
		
		return this;
	}
	
	public LoginPage clickLogoutFromLeadCollectionPage()
	{
		clickByLink("Logout");
		
		return new LoginPage(driver,test);
	}
		
	
}
