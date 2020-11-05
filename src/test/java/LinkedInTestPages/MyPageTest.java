package LinkedInTestPages;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import LinkedInPages.GoogleHomePage;
import LinkedInPages.UserLinkedInDetails;
// here I have to add listener class name is to added for tacking the screenshot and some more things
// to be added in feature like blink only working WebElement etc....
@Listeners(MyCustomListener.class)  // for presently tacking the screenshots only  in this class only
public class MyPageTest extends LinkedInBaseTest{

	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("\t --@BeforeMethod ------ ");
		//initialization("chrome"); // late on pass this value form method level By passing parameters 
		
	}
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("\t -- @AfterMethod  --------");
	}
	
	@Test(priority=1)
	public void googleHomePageTest() // next time separate things  below things 
	{
		System.out.println("This is test the application ");
		ghp=new GoogleHomePage(driver,logger); // here I return GoogleHomePage class 
		System.out.println("Google Home Page ogject is created ");
		logger.info("GoogleHomePage object is created ");
		
		/*
		 * lsp=ghp.passText(driver, "Linkedin.com");//Here this passText() return
		 * LinkedInSignPage class object
		 * System.out.println("LinkedInSignUp Page Object is created ");
		 * uhp=lsp.logInDet(driver, "konduvenkatarao999@gmail.com","9885861920"); //
		 * this return some class object
		 * System.out.println("UserHomePage object is created "); uhp.testScerrn();
		 * //screenshot("googleHomePageTest");
		 * System.out.println("---------------------------------------------------");
		 */
	//	Assert.assertTrue(false);// intensnolly I'm failaing the  this for taking screenshot 
		try {Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace();	}
	// the above code   The above code is working fine implement new things and do some more things
	}
	
	@Test(priority=2)
	public void linkedInSignPageTest()
	{
		lsp=ghp.passText(driver, "LinkedIn.com");
		System.out.println("Linkedin Sign In Page Object is created");
	//Assert.assertTrue(false);
		logger.info("LinkedInLogInSite page obeject is created ");
	try {Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace();	}

	}
	@Test(priority=3)
	public void userHomePageTest()
	{
		uhp=lsp.logInDet(driver, "konduvenkatarao999@gmail.com", "9885861920");
		System.out.println("User home Page object is created ");
	//	Assert.assertTrue(false);
		logger.info("UserHomePage object is created ");
		
		try {Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace();	}

	}
	
	//@Test(dependsOnMethods="userHomePageTest")
	
	
	
	@Test(priority=4)
	public void userHomePageDown()
	{
		// Here I Have to execute the down page like 10 tims how to do that 
		 // For the above requirement I have to use JavascriptExecutor thind 
		
		uhp.userHomePageDown(jse);
		System.out.println("user home page is down the page ");
		logger.info("User Home page is down the page up to 10 times ");
	
	}
	
	@Test(priority=5)
	public void userLinkedInDetailsTest()
	{
		//uld=uhp.userLinkedInDetailsPage(driver, logger);
	
		UserLinkedInDetails uld=uhp.userLinkedInDetailsPage(driver, logger, uhp);
		System.out.println("User Home Page object is passed and UserLinkedInDetails class obejct is crated ");
		// I will use userLinkedInDetails class object for next details 
		
		uld.pageTitleTest();
		logger.info("Title is tested ");
		uld.addProfileSelectionDropDown();
		
	}
	
	
	/// below this method is  Not working fine as per my expectation 
	// insted of logout it click the button at in settings page I will check later on  about this 
	
	
	//@Test(priority=5) // otherwise It will execution first s
	public void userLogOut()
	{
		System.out.println("Here I;m performing logout functionality ");
		try {Thread.sleep(5000);} catch (InterruptedException e) {e.printStackTrace();	}
// for this I want to perform mouse over actions on top or MENU BAR in that user Home Page 
//		
// I have to add some more information on that User home page go and do that operations 
// here I want to do logout 
			
		uhp.logOutUser(jse,act);
		
		System.out.println("Logout the fuction successful");
	//	Assert.assertTrue(false, "This Assertion My self I Intensionally provide this Don't bother about it ");
		
		
		
		
	}
	
	
}
