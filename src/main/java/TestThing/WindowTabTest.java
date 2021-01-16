package TestThing;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WindowTabTest {
public static void main(String[] args) {
	
//	WebDriverManager.chromedriver().setup(); // this is not working as per my expectation 
	
	System.setProperty("webdriver.chrome.driver","/home/venkat/Softwares/Browsers/chromedriver");
	WebDriver driver=new ChromeDriver();
	Actions act=new Actions(driver); 
//	Action a=new Action();// the purpose of this later on I will know about this 
	///
	// by using the Action class we can perform the mouse houver action 
	
	// By using the Action class we can define N number Web element stored those are ready to perform the Action things
	driver.get("https://google.co.in"); // Yes I'm open the browser 
	
	
	System.out.println("Title of the page :: "+driver.getTitle());
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	
	 Robot rb=null; // I will use this later on about handling the new tab and chagne the curser window is to next tab
	try {
		rb=new Robot(); System.out.println("Robot claass is loaded this class ");
	} catch (AWTException e1) {
System.out.println("Robot Class is not loaded");
e1.printStackTrace();
	}

	// 
	String parentWindowId=driver.getWindowHandle(); // this retrive the widow Id for change the widow workig later on 
	
	
	WebElement ele=driver.findElement(By.name("q"));
	
	 try {	Thread.sleep(200);	} catch (InterruptedException e) {	e.printStackTrace();	}
	
	/// Here I want to open the new widnow for that what I have to do 
	 //act.sendKeys(Keys.CONTROL+"t").perform(); // check this will it work or not
	 // the above line just send the t character in the query box 
//	act.keyDown(Keys.CONTROL).sendKeys("t").build().perform(); // this is not working then what I have to do 
	ele.sendKeys("Hi kondu venkatarao This is about hadling the Keyboard And Mouse things");

	 try {	Thread.sleep(200);	} catch (InterruptedException e) {	e.printStackTrace();	}
	
	
	//Action query=act.moveToElement(ele).build(); // this is for mouse move to the web element 
	//Action query=(Action)act;
//	queryy.moveToWebElement(ele).build().perform(); //Not working I'm getting the class cast exception Then what I have to do Here
	
	
	//query.perform(); // this is another way we have to use 
	
	//query. we can use small thing 
	//only just we can perform only 
	// then what I have to do here
	// for right click purpose what I have to do 
System.out.println("mouse pointer is moved to the element");
	 try {	Thread.sleep(200);	} catch (InterruptedException e) {	e.printStackTrace();	}
	
	//act.contextClick().build().perform(); // without moving mouse over to the web element initially it will be at 0, 0 co-ordiantes will be present Then what  I have to do 
	System.out.println("right click is clicked ");
// the above code is just pressed the right click of the mouse button  

	 try {	Thread.sleep(200);	} catch (InterruptedException e) {	e.printStackTrace();	}
	// Here I want to release the previous click things
	 
	// act.release().build().perform();
	// System.out.println("Mouse righ click is released");
	
	 //  How to perform ctrl+t for new tab how to do this 
	 // Here I'm using robot class
	 
	 rb.keyPress(KeyEvent.VK_CONTROL);
	 rb.keyPress(KeyEvent.VK_T);
	 //for release
	 rb.keyRelease(KeyEvent.VK_T);
	 rb.keyRelease(KeyEvent.VK_CONTROL);
	  
	 
	 System.out.println("New tab is opened ");
	 //Yes the above is working fine as per my expectation then what 
	 // I want to pass the new url of that tab how to do that 
	 
	// driver.get("https://Nuakri.com"); this is not working How to do this 
	 // May be can I use windowHandels or any other things I will check
	 
	 System.out.println("Title of the site is ::"+driver.getTitle());
	 
	 // After that I want to change the window tab to google how to do this by using Robot class

	 try {	Thread.sleep(1000);	} catch (InterruptedException e) {	e.printStackTrace();	}
	 
	 rb.keyPress(KeyEvent.VK_CONTROL);rb.keyPress(KeyEvent.VK_TAB);
	 rb.keyRelease(KeyEvent.VK_TAB);rb.keyRelease(KeyEvent.VK_CONTROL);
System.out.println("Change window focos to google :: "+driver.getTitle());	 

try {	Thread.sleep(500);	} catch (InterruptedException e) {	e.printStackTrace();	}

	 //Here I will check How many window are opened  These are working fine as per my expectation 


 
	Set<String> wind=driver.getWindowHandles();
	 
	for(String wi:wind)
	{
		if(!wi.equals(parentWindowId))// this or any other thin
		{
		driver.switchTo().window(wi);
		System.out.println("title :: "+driver.getTitle());
		 try {	Thread.sleep(500);	} catch (InterruptedException e) {	e.printStackTrace();	}

		driver.get("https://facebook.com");

		System.out.println("title :: "+driver.getTitle());

		 try {	Thread.sleep(500);	} catch (InterruptedException e) {	e.printStackTrace();	}
		}
	} // Here I will checkl 
	 
		// after that change the focus into the parent window How to do this'
	
//	driver.switchTo().window(parentWindowId);  // any other way is there
	
//	driver.switchTo().defaultContent(); // I will check this  // this is not working 
	
	// Any  other thigns are there I will check it 
	System.out.println("title :: "+driver.getTitle());
	 try {	Thread.sleep(2000);	} catch (InterruptedException e) {	e.printStackTrace();	}
	driver.quit();
}
}
