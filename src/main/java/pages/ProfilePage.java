package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.SalesForceWrappers;

public class ProfilePage extends SalesForceWrappers{
	
	public ProfilePage(RemoteWebDriver driver, ExtentTest test)
	{
		this.driver = driver;
		
		this.test = test;
	}
	
	public ProfilePage clickEditDropdown()
	{
		clickById("moderatorMutton");
		
		return this;
	}
	
	public ProfilePage verifyUserProfileName(String text)
	{
		verifyTextContainsById("tailBreadcrumbNode", text);
		
		return this;
	}
	
	public ProfilePage clickEditProfile()
	{
		//switchToFrameById(idVal);
		clickByLink("Edit Profile");
		
		return this;
	}
	
	public ProfilePage goToEditPop()
	{
		switchToFrameById("aboutMeContentId");
		
		return this;
	}
	
	public ProfilePage enterTitle(String data)
	{
		enterById("title", data);
		
		return this;
	}
	
	public ProfilePage enterAboutMe(String data)
	{
		enterById("aboutMe", data);
		
		return this;
	}
	
	public ProfilePage clickContactTab()
	{
		clickByLink("Contact");
		
		return this;
	}
	
	public ProfilePage verifyEmail(String data)
	{
		verifyValuebyId("email", data);
		
		return this;
	}
	
	public ProfilePage enterStreet(String data)
	{
		enterById("street", data);
		
		return this;
	}
	
	public ProfilePage enterCity(String data)
	{
		enterById("city", data);
		
		return this;
	}
	
	public ProfilePage enterState(String data)
	{
		enterById("state", data);
		
		return this;
	}
	
	public ProfilePage clickSaveAll()
	{
		clickByXpath("//input[@value='Save All']");
		
		return this;
	}
	
	public ProfilePage clickCancelFromContact()
	{
		clickById("editContactInfoCancelButton");
		
		return this;
	}
	
	public ProfilePage clickOverview()
	{
		clickByLink("Overview");
		
		return this;
	}
	
	public ProfilePage verifyAboutSection(String data)
	{
		verifyTextContainsByXpath("(//div[@class='profileSectionBody'])[2]", data);
		
		return this;
	}
	
	public HomePage clickHomeTabFromProfile()
	{
		clickByLink("Home");
		
		return new HomePage(driver,test);
	}
	
	
	
}
