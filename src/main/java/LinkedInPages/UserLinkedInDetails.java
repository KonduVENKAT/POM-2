package LinkedInPages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserLinkedInDetails {
WebDriver lDriver;
Logger logg;
Actions act;
//UserHomePage userHomePage;


	public UserLinkedInDetails(WebDriver rDriver ,Logger logger)
	{
		
		this.lDriver=rDriver;
		this.logg=logger;
	//	this.userHomePage=uhp;
		this.act=new Actions(lDriver); // this is also another way to add to pass webDriver lDriver

		PageFactory.initElements(rDriver, this);// this or Current class .class file later on I will check
		logg.info("**************************************************************");
		logg.info("**** UserLinkedInDetails class object is created *************");
		logg.info("**************************************************************");
		}
	
	@FindBy(xpath="//button[@id='ember590']")
	@CacheLookup
	WebElement addProfileSection1;
	
	
	@FindBy(xpath="//span[contains(text(),'Add profile section')]") // check both element 
	@CacheLookup
	WebElement addProSection2;  // Aftet clicking this button is it possible to get the list of the inside of this element check
	
	//After clicking that button I want to get that screenshot and drowDownAzailable list 
	 @FindBy(xpath="//ul[@id='pe-hub-section']") // for taking screenshot of the particular web element
	@CacheLookup
	WebElement dropDownListImage;
	
	 
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
	
	public void pageTitleTest() // this test at MyTest class depends to remaining test 
	{
		System.out.println("Title of this UserLinkedInDetails Page is ::"+lDriver.getTitle());
		
		//Assert.assertEquals("actual", "expected","message");
		logg.info(lDriver.getTitle()+"  Title of the page found by ");
	}
	// Flow first click on Me button-->ViewProfile-->it's open this userLinkInPage --->>
	// wait page loade 10 Sec explicitly wait Click on AddprofileSelecton DropDown 
	// get the all det and click on each drop down get the list 
	
	//for got to this page I have to click cilickMe button in userHome page and 
	// And then click on viewProfile button 
// Not possible to access this method without creating the object of this class I will do another through another way I declare this method in UserHomePage  
	/*
	public UserLinkedInDetails userHomePage(WebDriver driver,Logger log,UserHomePage userHomePage) // this return current page object 
	{
		
		logg.info("***************************");
		logg.info("********I am goint to lounch UserLinkedDetails Page **********");
		logg.info("***************************");
		UserHomePage uhp=userHomePage;// pass the userHomePage reference 
		
		if(uhp.userIcon.isDisplayed())
		{
			System.out.println("User Icon is displayed and I want to click on thet element ");
			
			uhp.userIcon.click();
			logg.info("UserIcon is displayed and I clicked for go to the UserLinkedInDetails");
						// click on viewProfile
			//After do some operations 
			
		WebElement viewProfile=lDriver.findElement(By.xpath(""));
		
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
			System.out.println("User Icon is Not displayed");
			logg.info("UserIcon in UserHomePage is not displayed and not able to interact check this ");
		}
		
		return new UserLinkedInDetails(lDriver,logg); // this is possible check this where I have to specify 
	}
	*/
	public void addProfileSelectionDropDown()
	{
		//Click on AddprofileSelection DropDown button
		//get the list and select each one 
	
		
		//List<WebElement> drop=lDriver.findElements(dropDownListImage);
		List<WebElement> drop=lDriver.findElements(By.xpath("//ul[@id='pe-hub-section']"));
		
		// Here i want to get the element text of the each <li> of inside of the <ul> how to do that 
		
		for(WebElement ele:drop)
		{
			WebElement ele2=ele;
			String eleText=ele2.getText();
			System.out.println("<li> ::"+eleText+" ::</li>" );
		}
	}
}
