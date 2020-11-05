package LinkedInPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedInPage {
	
	public WebDriver lDriver;
	public LinkedInPage(WebDriver rDriver)
	{
		this.lDriver=rDriver;
		PageFactory.initElements(rDriver, this);// check this rDriver or lDriver 
	}
	/// Declare Page object Object  repository 
//	WebElement googleSearchBox,	googleSearchBttod,logInSignUpLink,signUpLink;
	
	// // Here I have to declare Locators 
	// later i will update this class 
	@FindBy(name="q")
	@CacheLookup
	WebElement googleSearchBox;
	
	
	@FindBy(name="q")
	@CacheLookup
	WebElement googleSearchButton;
	
	@FindBy(partialLinkText="Log In or Sign Up")
	@CacheLookup
	WebElement loginSignLink;
	
	
	@FindBy(linkText="Sign Up")
	@CacheLookup
	WebElement signUpLink;
	
	
	/*
	@FindBy(name="q")
	@CacheLookup
	WebElement googleSearchBox;
	
	
	@FindBy(name="q")
	@CacheLookup
	WebElement googleSearchBox;
	
	
	@FindBy(name="q")
	@CacheLookup
	WebElement googleSearchBox;
	
	
	@FindBy(name="q")
	@CacheLookup
	WebElement googleSearchBox;
	
	@FindBy(name="q")
	@CacheLookup
	WebElement googleSearchBox;
	
	@FindBy(name="q")
	@CacheLookup
	WebElement googleSearchBox;
	
	*/
	
	
	

}
