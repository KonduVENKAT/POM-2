package LinkedInTestPages;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import LinkedInPages.FormFeedBox;
import LinkedInPages.GoogleHomePage;
import LinkedInPages.LinkedInPage;
import LinkedInPages.LinkedInSiteLogOut;
import LinkedInPages.LinkedinSignPage;
import LinkedInPages.SiteMenuBar;
import LinkedInPages.UserHomePage;
import LinkedInPages.UserLinkedInDetails;
import customListeners.ExtentReport;

public class LinkedInBaseTest {
	String screenshotFolder="./Screenshots/";
	String elementsScreenshotFolder="./Screenshots/ElementByElementScreenshots/"; // I will update about this later on 
	
	String date=null;  // this is use full for creating screenshot folder for each and every run of the program and 
	String screenshotDate=null; // I will check about this 
	
	// here declare Pages for references 
	GoogleHomePage ghp=null;
	LinkedinSignPage lsp=null;
	UserHomePage uhp=null;
	UserLinkedInDetails uld=null;
	//--------------------------------
	
	FormFeedBox ffb=null;
	LinkedInPage lip=null;
	LinkedInSiteLogOut lislo;
	
	SiteMenuBar smb=null;
	
	
	
	// it's ,must be static for taking screenshots and it not support parallel Browser  execution 
	public static WebDriver driver ; // this initialization we will see in its subclasses  
	
	
	public JavascriptExecutor jse;
	
	public static Logger logger; // this is created at @BeforeClass level  initiate later on .
 	
	public Properties prop;   
	
	
					  //./configurationFiles/Config.properties
	String propFileLoc="./configurationFiles/Config.properties"; // proper file location 
	
	
	Actions act; // for mouse over actions and later we pass the driver 
	
	// for Properties file recognize create a Constructor time execution 
	
	public LinkedInBaseTest()
	{
		date=getCurrentDateTime();// this will execute only once per execution 
		screenshotDate=date;
		System.out.println("******************************************************************");
		System.out.println(" ---------------   Date and Time is "+date+"  ------------------- ");
		System.out.println("see failure images in this Screenshots folder --"+date+" --  here ");
		System.out.println("******************************************************************");
		File file=new File(propFileLoc);
		FileInputStream fis;	
		
			
		try {fis=new FileInputStream(file); System.out.println("  -----   Propertes file is loaded  ------- ");
			System.out.println("Properties file is loaded ");
			prop=new Properties();
			prop.load(fis);
			
		} catch (FileNotFoundException e) {
		System.out.println("----- Config Propertiese file is not loaded properly chek it once ");
		e.printStackTrace();
		
		} catch (IOException e) {
			System.out.println("--- Config Propertiese file is loaded ( 2nd step ) but prop.load is problem check once ");
			e.printStackTrace();
		}
	
	
	
	
	}  // current class constructor close 
	
	//  ******************************************************    *************************************
	
	public void initialization(String brow)  // Actually here OS also specify how to do that I will check later updates agout this project 
	{
		if(brow.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","/home/venkat/Softwares/Browsers/chromedriver");//get this value from properties file 
			driver=new ChromeDriver();
			act=new Actions(driver);
			jse=(JavascriptExecutor)driver;
			logger.info(brow+" - Browser is launched "+date);
			
			
		}
		else if(brow.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "/home/venkat/Softwares/Browsers/geckodriver");
			driver=new FirefoxDriver();
			driver.manage().window().maximize(); // where are the waits 
			
			act=new Actions(driver);
			jse=(JavascriptExecutor)driver;  // initialize that JavascriptExecutor for feature purpose 
		
			logger.info(brow+" - Browser is launched "+date);
		}
		else
		{
			System.out.println(" You're passing wrong browser name check once : "+brow);

			logger.info(brow+" - This browser is not availble  - Browser is launched "+date);
		}
	
		 
	}// this block closed initialization 
	//********************************************************************************************
	
	@BeforeSuite
	public void beforeSuite()
	{
		System.out.println("\t --@BeforeSuite --");
		// I will call one class for Extnent Report for generating Html Report 
	
		
	}
	@AfterSuite
	public void afterSuite()
	{
		System.out.println("\t  --@AfterSuite --");
	// Here I want to close the Report 
	
	}
	@BeforeTest
	public void beforeTest() 
	{
		System.out.println("\t --@BeforeTest --");
	}
	@AfterTest
	public void afterTest()
	{
		System.out.println("\t --@AfterTest --");
	}

	// Here I to pass browser value to this method I will check later on  
	@BeforeClass   // here Open the browser  for every class level test later on 
	public void beforeClass()
	{
		System.out.println("\t --@BeforeClass --");
		System.out.println("******************************************************************************");
		System.out.println("Here I want to pass the berowser String");
		
		 logger=Logger.getLogger("POM-2");
		 PropertyConfigurator.configure("log4j.properties"); // how many ways to initialize this 
		
		
		initialization("chrome"); // late on pass this value form method level By passing parameters 
		logger.info(" Borwser is passed to  launch the chrome");
		driver.manage().window().maximize();
	/*
		logger.info("message", t);
		
		logger.error("Message"); // check when we will use this 
		logger.debug("Message");
		logger.fatal("message");
		//logger.fatal("message", t);

		logger.setAdditivity("additive=true or false");
		logger.getAdditivity();
		
		logger.setLevel("level");
		logger.getLevel();
		logger.isEnabledFor("level");
		
		logger.setPriority("priority");
		logger.getPriority();
		

		logger.getEffectiveLevel();
		logger.getLoggerRepository();
		logger.getName();
		logger.getParent();
		logger.isTraceEnabled();
		logger.l7dlog("priority", "key", "t");
		logger.l7dlog("priority", "key", "params", "t");
		logger.log("priority", "message");
		logger.log("priority", "message", "t");

		logger.log("callerFQCN", "level", "message", "t");
		logger.removeAllAppenders();
		logger.removeAppender("appender");
		logger.toString();
		
		logger.isTraceEnabled();
		logger.trace("message");
		logger.trace("message", "t");
	
		logger.getLogger("name", "factory");
		logger.getRoot();
		logger.getRootLogger();
		logger.shutdown();
		*
		*/
		
	}
	@AfterClass    // Close the browser  or quite the browser we will see later based on open other browsers 
	public void afterClass()
	{
		System.out.println("\t --@AfterClass --");
		logger.info("Broser is going to close ");
		closeBrowser();
		logger.info("Browser is closed for this run time is "+date);
		logger.info("*************************************************************************");
	}
	//********************************************************************************************
 public void quitBrowser() // for close all open windows in  browser 
 {
	 System.out.println("**********************************************************************");
	 System.out.println("Completed all tasks so I'm quiting the browser ");
	 System.out.println("**********************************************************************");
	 try {Thread.sleep(5000);} catch (InterruptedException e) {e.printStackTrace();}
	 driver.quit();

	 System.out.println("**********************************************************************");
	 System.out.println("Browser is QUIT and check in the console or logger file and index.html file for report  ");
	 System.out.println("**********************************************************************");
	 
 }
 public void closeBrowser() // For only one current working browser
 {
	 System.out.println("**********************************************************************");
	 System.out.println("Completed all tasks so I'm quiting the browser ");
	 System.out.println("**********************************************************************");
	 try {Thread.sleep(5000);} catch (InterruptedException e) {e.printStackTrace();}
	 driver.close();

	 System.out.println("**********************************************************************");
	 System.out.println("Browser is CLOSED and check in the console And  logger file and index.html file for report  ");
	 System.out.println("**********************************************************************");
	 
 }
 // Bellow this method called by at failure level for that purpose I create a ITestListener Class   
 
 // And this will take full lever  Page screenshot only by ITestListener interface 
 public void screenshot(String mName) // for @Test method name I have to pass later on I apply 
  {											// exact background as well RED Mark exactly where it fails   
	 										// By using javaScriptExecutor 
	File img=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	//File screen=((TakesScreenshot)mDriver).getScreenshotAs(OutputType.FILE);
	try {
		 String imgDestinationLocation=screenshotFolder+"/"+screenshotDate+"/"+mName;
		FileUtils.copyFile(img, new File(imgDestinationLocation+".jpg"));
	System.out.println("Screenshot is taken in Screen At : "+imgDestinationLocation);
	// Add this information in logger file next time 
	
	
	} catch (IOException e) {
		System.out.println("Screenshot is not taken By ITestListener  class Check it once ");
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
 }
  
 // I want to take particular screenshot  of the web element only  By MyWebDriverEventListener
  
  public void eleSreenshot(WebElement ele) // I want to call this through WebEDriverInterface onlly 
  {
	  
	  String imgText=ele.getText();
	  
	  File src=ele.getScreenshotAs(OutputType.FILE);
	  
	  File destLocation=new File(elementsScreenshotFolder+screenshotDate+"/"+imgText+".jpj");
	  
	  try {	FileUtils.copyFile(src, destLocation);System.out.println("Screenshot is taken perticuler webelement ");
	} catch (IOException e) {System.out.println("Screenshot is not taken  particuler webelement ");	e.printStackTrace();	}
	  
	  
	  
	  
  }
  
  
 public void changeBacgroundColor() // And  Take the screenshot I will implement later about here I will use JavascriptExecutor concept 
 {
	 // How to do that 
 }
//    ------------------------------------------------------------ 
 public String getCurrentDateTime()
 {
	 String lDateTime=null;
	 String AmPm=null;
	 
	 int hours=LocalTime.now().getHour();
	 int min=LocalTime.now().getMinute();
	 int sec=LocalTime.now().getSecond();
	 
	 LocalDate lDate=LocalDate.now();
	 DateTimeFormatter df=DateTimeFormatter.ofPattern("d MMM uuuu");
	 String myDate=lDate.format(df);
	 
	 
	// lDateTime=myDate+" -Time "+hours+":"+min+":"+sec+"-"+AmPm; // Remove  min and sec here because it create a new folder after a second 
	 															// and well it's not good practice  try another possible way to reduce this problems 
	 										//try this method access by at constructor level 
	 // for screenshot date is 
	//screenshotDate=myDate;
	
	
	if(hours>00&hours<12)
	 {
		 AmPm="AM";
	 }
	 else
	 {
		 AmPm="PM";
	 }
	 
	lDateTime=myDate+" -Time "+hours+":"+min+":"+sec+"-"+AmPm; // Remove  min and sec here because it create a new folder after a second 
	screenshotDate=myDate;
		 
	 return lDateTime;
 }
}
