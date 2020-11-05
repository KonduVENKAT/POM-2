package testMySelf;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogingTest001 {
	WebDriver driver=null;
	JavascriptExecutor js=null;
	Actions act =null;
	//public static void main(String[] args) {
	//@BeforeMethod
	@BeforeMethod
	public void setUp()
	{
		
		System.setProperty("webdriver.chrome.driver", "/home/venkat/Softwares/Browsers/chromedriver");
		driver=new ChromeDriver();
		act=new Actions(driver);
		
		js=(JavascriptExecutor)driver;
		
//**************************************************************************	
	 //   later on I will check the  bellow functionalities Later on 
		
		
	//	driver.manage().timeouts().wait();
	//	driver.manage().timeouts().wait(timeout);
	//	driver.manage().timeouts().wait(timeout, nanos);
		//**************************************************************************
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();
		System.out.println("Pre thigs are exicuted ");
	//driver.get("google.co.in"); // check this is working or not working 
	System.out.println("Url 1 is passed");

	}
	@Test
	public void linkedSiteClick()
	{
	//https://www.google.co.in/
	//try {	Thread.sleep(5000); } catch (InterruptedException e) {	e.printStackTrace();	}
	
	driver.get("https://www.google.co.in/"); // this is working 
		//driver.findElement(by);
	System.out.println(" URL 2 is passesd");
	System.out.println("URL Is passes");
	
	driver.findElement(By.name("q")).sendKeys("LinkedIn");
	System.out.println("LinkedIn test is passed ");
	//try {	Thread.sleep(2000); } catch (InterruptedException e) {	e.printStackTrace();	}
	
	driver.findElement(By.name("btnK")).click();
	System.out.println("button is clicked");
	
	//try {	Thread.sleep(2000); } catch (InterruptedException e) {	e.printStackTrace();	}
	// searching for  
	driver.findElement(By.partialLinkText("Log In or Sign Up")).click();
	
	//try {	Thread.sleep(2000); } catch (InterruptedException e) {	e.printStackTrace();	}
	System.out.println("log In or Sign Up is clicked ");
	// Here I have to do mouse Over actions 

	//  ***************  For scroll down purpose below these are not working check another things
	//js.executeAsyncScript("arguments[0].ScrollIntoView()", signUp); // this is for horizontal scroll 
//	 js.executeScript("arguments[0].scrollIntoView();", signUp);

	
	// *** Below this scenario is not work because I'm get the exception for this i have to use I'm expecting Exception 
	/*
	WebElement ele=null;
	while(ele==null)
	{	
		WebElement signUp=driver.findElement(By.linkText("Sign Up"));
		
		js.executeScript("window.scrollBy(0,1000)");
	}
	*/
	// Below this code is working fine 
	
	/*
	for(int i=0;i<30;i++) // may chance for Page length is more height  for that purpose write more iteration as part of the reducing the code
	{
		js.executeScript("window.scrollBy(0,200)");

		try {	Thread.sleep(1000);	} catch (InterruptedException e) {	e.printStackTrace();}
		
	}
	/*
	// Below this code is working for scrolling the vertically downwards next  
	  System.out.println("Here I want to perform Window is scrolled down by 0,1000");
	  js.executeScript("window.scrollBy(0,1000)");
	  js.executeScript("window.scrollBy(0,1000)");
	  js.executeScript("window.scrollBy(0,1000)");
*  System.out.println("Window is scrolled down by 0,1000");
	
*/
	// But  My requirement I want to scroll down the page till ends And I know the webElement is at down of the page How to do that 
	// for this purpose I have to use JavascriptExecutor 
	// js.executeScript("window.scrollTo(0,document.body.scroleHight)");
	  
	
	
	
	//	System.out.println("Window is scrolled down by Till End of the page ");
	 // js.executeScript("window.scrollTo(0,document.body.scrollHeight)"); // I'm checking this is working or not 
	 // the above is working fine as per my expectations I Perform clicking operations 
	
	  //the above code is working is fine and m
	  
	  // and my requiremnet is i want to scroll down the page untill element is found
	  
	  // for that 

		WebElement signUp=driver.findElement(By.linkText("Sign Up"));// this is only declaration
  
	  //js.executeScript("argumetns[0].scrollIntoView()",signUp);

      //This will scroll the page till the element is found		
      js.executeScript("arguments[0].scrollIntoView();", signUp); // actually web element is here is checked is it there are not 
	  
	System.out.println(" Here I want to find  SignUp link is found or not ");
	
	//	driver.findElement(Keys.DOWN); // this is not working 

	System.out.println(" Here I want ot perform  SignUp link is founded  and mouse moveto that link and click  ");
	act.moveToElement(signUp).build().perform();
	try {	Thread.sleep(2000); } catch (InterruptedException e) {	e.printStackTrace();	}
	
	signUp.click();
	//act.keyDown(driver.findElement(By.partialLinkText("SignUp")));
	
	
	//act.moveToElement(driver.findElement(By.partialLinkText("SignUp"))).build().perform();
	System.out.println(" Mouse cursor is moved to SignUp Link");
	}
	
//	@AfterMethod
	@AfterMethod
	public void tearDown()
	{
	try {	Thread.sleep(2000); } catch (InterruptedException e) {	e.printStackTrace();	}
	driver.close();
	}	
		
		
//}

}
