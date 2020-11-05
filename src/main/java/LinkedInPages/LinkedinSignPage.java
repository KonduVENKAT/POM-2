package LinkedInPages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinSignPage {
	WebDriver lDriver;
	Logger logg;
	Actions act;
	
	public LinkedinSignPage(WebDriver rDriver,Logger log)
	{
		this.lDriver=rDriver;
		this.logg=log;
		this.act=new Actions(lDriver);
		PageFactory.initElements(rDriver, this);
		logg.info("************************************************************");
		logg.info("******* LinkedinSignPage class object is created ***********");
		logg.info("************************************************************");
	}

	
	@FindBy(id="username") // for user name box 
	@CacheLookup
	WebElement userName;
	
	
	@FindBy(id="password") // for password feild 
	@CacheLookup
	WebElement password;
	
	@FindBy(id="password-visibility-toggle") // this is for password visibility  
	@CacheLookup
	WebElement passVisibility;
	
	
				// first check this otherwise I will use xPath concept later on
//	@FindBy(className="btn__primary--large from__button--floating mercado-button--primary") // class name is not working 
	@FindBy(xpath="//button[@aria-label='Sign in']")
	@CacheLookup
	WebElement signInBtn;


	public UserHomePage logInDet(WebDriver driver,String uName,String pwd)
	{
		
		// latter on I will update this things more accurate like if(userName.isVisible ) .// etc....
 		
		userName.clear();
		userName.sendKeys(uName);
		
		//try {Thread.sleep(500);	} catch (InterruptedException e) {e.printStackTrace();	}
		
		password.clear();
		password.sendKeys(pwd);
		
		//try {Thread.sleep(500);	} catch (InterruptedException e) {e.printStackTrace();	}
		passVisibility.click();  // for visibility 
		
		try {Thread.sleep(1000);	} catch (InterruptedException e) {e.printStackTrace();	}
		
		passVisibility.click();  // for visibility 
		
		signInBtn.click(); // this is not working I will use xPath
		
		
		
		return new UserHomePage(driver,logg);
		
	}

}
