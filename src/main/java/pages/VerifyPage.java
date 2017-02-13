package pages;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Flags.Flag;
import javax.mail.search.FlagTerm;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.SalesForceWrappers;

public class VerifyPage extends SalesForceWrappers{

	String code = "";

	public VerifyPage(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		if(!verifyTitle("Verify Your Identity | Salesforce")){
			reportStep("This is not Verify Page", "FAIL");
		}

	}

	public String getCode(boolean isImap, String username, String password)
	{
		//Create all the needed properties empty
		Properties conProp = new Properties();
		//Create the session
		Session session = Session.getDefaultInstance(conProp, null);
		try{
			System.out.print("Connecting to the server...");
			//Connection to the server
			//Set the store depending on the parameter value
			String storeName = isImap?"imaps":"pop3";
			Store store = session.getStore(storeName);
			//Set the server depending on the parameter value
			String server = isImap?"imap.gmail.com":"pop.gmail.com";
			store.connect(server, username, password);
			System.out.println("done!");
			//Get Inbox folder
			Folder inbox = store.getFolder("INBOX");
			//Open inbox and set read-only mode
			inbox.open(Folder.READ_WRITE);
			//Get the total count of unread message.
			System.out.println("Total unread messages : "+inbox.getUnreadMessageCount());
			//Get the messages
			Message[] messages = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
			System.out.println("Reading messages....");
			//Display the messages
			for(Message message:messages){

				for(Address add:message.getFrom())
				{
					//System.out.println(add.toString());
					if(add.toString().contains("info@salesforcedevs.com"))
					{
						String msg = message.getContent().toString();

						String[] splitmsg = msg.split("\\s+");

						for(int i=0;i<splitmsg.length;i++)
						{
							if(splitmsg[i].equals("Code:"))
							{

								code=splitmsg[i+1];  

								//System.out.println("Verification code is = "+code);
							}
						}

						message.setFlag(Flag.SEEN, true);
					}
				}
			}


		}catch(Exception e)
		{
			e.printStackTrace();
		}

		System.out.println("Verification code is = "+code);

		return code;

	}


	public VerifyPage enterCode(String username, String password)
	{
		String code = getCode(true, username, password);

		enterById("emc", code);

		return this;
	}
	
	public LandingPage clickVerify()
	{
		clickById("save");
		
		return new LandingPage(driver,test);
	}
	
	public VerifyPage verifyText(String text)
	{
		verifyTextById("header", text);
		
		return this;
	}
	
	

}
