package LinkedInPages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleHomePage {
	WebDriver lDriver;
	Logger logg;
	Actions act;
	
	
	public GoogleHomePage(WebDriver rDriver,Logger log)
	{
		this.lDriver=rDriver;
		this.logg=log;
		this.act=new Actions(lDriver);
		PageFactory.initElements(rDriver, this);// this one is mandatory I have to declare 
	//	lDriver.get("https://google.co.in");
	// check this whenever I create of this class object automaticallly open this google.com Home page 
		logg.info("************************************************************");
		logg.info("***** GoogleHomePage class object is created  **************");
		logg.info("************************************************************");
		
	}

	WebElement penURL;
	
	@FindBy(name="q")   // below these two must required to pass the data and click to go to the next page 
	@CacheLookup
	WebElement qBox;
	
	@FindBy(name="btnK")
	@CacheLookup
	WebElement searchBtn;
	
	
	@FindBy(partialLinkText="Log In or Sign Up")  //   this is for in web page I will get lot of the links text I want to click the partial link text 
 	@CacheLookup
	WebElement SignInLink;				// later on I will see any other way's may be available or not 
		
	
	
	@FindBy(linkText="Sign in")
	@CacheLookup
	WebElement signLink;
	// is it possible to decalre methods for returning the objects here test later on  about this 
	 public LinkedinSignPage passText(WebDriver driver,String query)
	 {
		 lDriver.get("https://google.co.in");
		 
		 try {	Thread.sleep(1000); } catch (InterruptedException e) {	e.printStackTrace();	}
			 
		 qBox.clear();
		 qBox.sendKeys(query);
		 try {	Thread.sleep(2000); } catch (InterruptedException e) {	e.printStackTrace();	}
		
		 searchBtn.click(); // up to this is ok then I have to click to Sign in Link text 
		 
		 //try {	Thread.sleep(2000); } catch (InterruptedException e) {	e.printStackTrace();	}
		 
		 SignInLink.click(); // so this is go to another page so I have to do some more things there
		 
		 try {	Thread.sleep(2000); } catch (InterruptedException e) {	e.printStackTrace();	}
		 
		 signLink.click();
		 
		 try {	Thread.sleep(1000); } catch (InterruptedException e) {	e.printStackTrace();	}
		 
		 
		 return new LinkedinSignPage(driver,logg);
		 
	 }
	
}
