package LinkedInPages;

import java.util.Iterator;

import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserHomePage {
	JavascriptExecutor lJse;
	WebDriver lDriver;

	Actions action;
	Logger logg;
	public UserHomePage(WebDriver rDriver,Logger log)
	{
		this.lDriver=rDriver;		 //For WebDriver Instance 
		this.logg=log;               // For loggers 
		action=new Actions(lDriver); // Mouse Hover Actions 
		PageFactory.initElements(rDriver, this);
	System.out.println(" Object is created UserHomePage in Page classes ");// this statement is not esxcuting 
	logg.info("*****************************************************");
	logg.info("****** UserHomePage class Object is created *********");
	logg.info("*****************************************************");
	
	// if it is work later on I will update mouseOver element thing 
	}
	
	// below this is not working  Later on May be updated with JavaScriptExecutor 
	@FindBy(id="global-nav-icon--classic__down-arrow") // check this mouse over Action then perform actions later I will implemented 
	@CacheLookup
	WebElement meBtn; //for logOut functionality
	
	@FindBy(xpath="//img[@id='ember38']") // this is also not working
	@CacheLookup
	WebElement userIcon; // for this I Have to  add the thing 
 	
	
	@FindBy(id="ember36") // this is also not working
	@CacheLookup
	WebElement userIconID;    //These three condition not working 
	//----------------------------------------------------------------
	@FindBy(id="//div[@id='ember39']")
	@CacheLookup
	WebElement userLogOutLink;
	//  ---------------------**********************************-----------------------------------------------------------------
	@FindBy(xpath="//img[@id='ember253']") // big image in side the left of the page 
	@CacheLookup
	WebElement userLogo;
	
	// bellow this some complex think where we have to use think first I have to assert  then think about assert ok 
	@FindBy(xpath="//button[@id='ember486']//li-icon[@type='chevron-down-icon']//*[local-name()='svg']//*[name()='path' and contains(@d,'M1 5l7 4.6')]")
	@CacheLookup
	WebElement messegeDownCilick;
	
	@FindBy(xpath="//div[@class='profile-rail-card__actor-link t-16 t-black t-bold']")// for user Logo name in user home page 
	@CacheLookup
	WebElement userName;
	

	@FindBy(xpath="//p[@class='identity-headline t-12 t-black--light t-normal mt1']")
	@CacheLookup
	WebElement userDet;

	@FindBy(xpath="//svg[@class='background']") // check this through assertions  
	@CacheLookup
	WebElement LinkinLogo;

	@FindBy()
	@CacheLookup
	WebElement home;

	@FindBy()
	@CacheLookup
	WebElement network;

	@FindBy()
	@CacheLookup
	WebElement jobs;

	@FindBy()
	@CacheLookup
	WebElement messaging;

	@FindBy()
	@CacheLookup
	WebElement notification;
	
	
	@FindBy()
	@CacheLookup
	WebElement meBtn2;

	@FindBy()
	@CacheLookup
	WebElement workMenu;

	@FindBy(xpath="//button[@class='artdeco-button artdeco-button--muted artdeco-button--4 artdeco-button--tertiary share-box-feed-entry__trigger--v2']")
	@CacheLookup
	WebElement textFeild;// first click and then type text 

	@FindBy(xpath="//div[@aria-label='What do you want to talk about?']//p")
	@CacheLookup
	WebElement textFeildText;  // first click textFeild and then pass text this sendKeys 

	
	// check the svg things in naveen automation labs 
	@FindBy(xpath="//button[@id='ember846']//li-icon[@type='cancel-icon']//*[local-name()='svg']")
	@CacheLookup
	WebElement textFeildTextClose;
// then afete it will open one alert box I have to handle it
	
	
	@FindBy()
	@CacheLookup
	WebElement alertDiscard;

	/*
	@FindBy()
	@CacheLookup
	WebElement ele1;

	@FindBy()
	@CacheLookup
	WebElement ele1;

	@FindBy()
	@CacheLookup
	WebElement ele1;

	@FindBy()
	@CacheLookup
	WebElement ele1;
	
	
	
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//  ---------------------**********************************-----------------------------------------------------------------
	
	public void logOutUser(JavascriptExecutor jse, Actions act)
	{
		lDriver.manage().window().maximize();
		try {	Thread.sleep(1000);	} catch (InterruptedException e) {		e.printStackTrace();	}
		/*
		 * dri.findElement(By.xpath("//svg[@class='mercado-match']")).click(); // this  not working or not
		 * System.out.println(" I down the messege field in to taht page ");
		 */
		
		
		// Here I want to do logout functionality 
		
		
		
		userIcon=lDriver.findElement(By.xpath("//button[@id='ember36']"));
		
		act.moveToElement(userIcon);
		try {	Thread.sleep(1000);	} catch (InterruptedException e) {		e.printStackTrace();	}
		
		userIcon.click();
		
		System.out.println(" For logout i clicked on the top of Me button in tha home page ");
		try {	Thread.sleep(1000);	} catch (InterruptedException e) {		e.printStackTrace();	}
		
		
		userLogOutLink=lDriver.findElement(By.xpath("//div[@id='ember39']"));
		
		act.moveToElement(userLogOutLink);
		try {	Thread.sleep(5000);	} catch (InterruptedException e) {		e.printStackTrace();	}
		userLogOutLink.click();
		
		System.out.println(" I clilk on logout link through xpath ");
	
		
		
	}
	
	public void userHomePageDown(JavascriptExecutor jse)
	{
		for(int i=0;i<10;i++)
		{
			jse.executeScript("window.scrollBy(0,1000)");// 
			try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();		}
			
		System.out.println("Page is down by the programm ");	
			}
		
		
	}
	
	
	public void menuItems(List<WebElement> li) // By using this assign WebElements assigning the values I wil check weather it is working or not 
	{
		
		// later on I will update this thing
		WebElement menu1;
		WebElement menu2;
		WebElement menu3;
		WebElement menu4;
		WebElement menu5;
		WebElement menu6;
		WebElement menu7;
		
		List<WebElement> list=li; // here I'm accessing the WebElemtn objects and later on I will assign as per their names 
		Iterator<WebElement> itr=list.iterator();// this is for iterating one by one or any other way to do that 
		
		
		
	}
	
	
	public void testScerrn()
	{
		System.out.println("I created User Home Page Object is created and I,m taking screen shot ");
	}
	// later on I will update this page things 										// by this I'm passing web elements also for clicking that elements of courses it is not not Required 
	public UserLinkedInDetails userLinkedInDetailsPage(WebDriver driver,Logger log,UserHomePage userHomePage) // this return current page object 
	{
		
		logg.info("**************************************************************");
		logg.info("******** I am goint to lounch UserLinkedDetails Page **********");
		logg.info("**************************************************************");
		UserHomePage uhp=userHomePage;// pass the userHomePage reference 
		
		if(uhp.userIconID.isDisplayed())
		{
			System.out.println("User Icon is displayed and I want to click on thet element ");
			
			uhp.userIconID.click();
			logg.info("UserIconID is displayed and I clicked for go to the UserLinkedInDetails");
						// click on viewProfile
			//After do some operations 
			
		WebElement viewProfile=lDriver.findElement(By.xpath("//div[@id='ember40']")); // check this is working or not 
		
			if(viewProfile.isDisplayed())
			{
				System.out.println("ViewProfile is displayed and I want to click");
				viewProfile.click(); // After this I wil go to the UserLinkedInDetails page  
try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
				System.out.println("Titile of the page is :: "+lDriver.getTitle());
				logg.info("ViewProfile inside the UserIcon list is displayed I want to clicked thet viewProfile element ");
			}else
			{
				System.out.println("ViewProfile is not click I want to check the WebElement uerIcon");
				System.out.println("ViewProfile in side Click is not visible ");
				log.info("ViewProfile in userHomePage is not displaying inside the UserIcon button element Check this  ");
			}
				
		}else
		{
			System.out.println("UserIconID is Not displayed");
			logg.info("UserIconID  in UserHomePage is not displayed and not able to interact check this ");
		}
		
		return new UserLinkedInDetails(lDriver,logg); // this is possible check this where I have to specify 
	}							// checking which WebDeiver instance is going to pass object is 
								// The above is valid or not including logger file also it is applicable 

}
