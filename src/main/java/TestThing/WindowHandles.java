package TestThing;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandles {
public static void main(String[] args) {
	// To handle window thing what I have to do 
	// I need site urls here And store in one Iterator<String>
	
	List<String> liUrls=new ArrayList<String>();
	
	liUrls.add("https://www.google.co.in/");
	liUrls.add("https://www.linkedin.com/");
	liUrls.add("https://www.naukri.com/");
//	liUrls.add("https://www.monsterindia.com/");
	liUrls.add("https://in.indeed.com/");
//	liUrls.add("");
//	liUrls.add("");
//	liUrls.add("");
	Iterator<String> urls=liUrls.iterator(); // How to handle window things 
	
	System.setProperty("webdriver.chrome.driver", "/home/venkat/Softwares/Browsers/chromedriver");
	
	WebDriver dri=new ChromeDriver();
	dri.manage().deleteAllCookies();
	dri.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	dri.manage().window().maximize();
	Robot robot =null;
		/*
		 * Set<String> windowId=new HashSet<String>();
		 * 
		 * String pId=dri.getWindowHandle(); windowId.add(pId);
		 */
	
	try {
		robot=new Robot();System.out.println("Robot class is loaded");	} catch (AWTException e1) {System.out.println("Robot class is not loaded");		e1.printStackTrace();	}
	
	for(int i=0;i<liUrls.size()-1;i++) 
	{
		robot.keyPress(KeyEvent.VK_CONTROL);robot.keyPress(KeyEvent.VK_T); // this is for press only 
		// Here I want to release the those who are pressed keys for that
		robot.keyRelease(KeyEvent.VK_T);robot.keyRelease(KeyEvent.VK_CONTROL);
		try {Thread.sleep(1000);	} catch (InterruptedException e) {	e.printStackTrace();	}
		
		System.out.println("New tab is opened Now I want to change the windnow ");
	// How to change the with out window Id's // current focus on parentWindowId	 
		// for this not possible at time pass the url of the application then what I have to do in the sence 
	// first Window are opened the I will pass the URLs by using robot class passing the CTRL+TAB
	
	}
	
	Set<String> winId=dri.getWindowHandles(); // Here I will get the widow Id's 
	// Then what I have to do for each window I have to pass the URL of the application 
	// How to implement this 
	for(String wi:winId) // Here I got the each window and pass the rul of the application
	{
		// By this wach window Id I had assigned one url of the application
		// first Of all I have to change the window For that 
		// Here what I have to do 
		robot.keyPress(KeyEvent.VK_CONTROL);robot.keyPress(KeyEvent.VK_TAB); // How it will work
		// Release those things 
		robot.keyRelease(KeyEvent.VK_TAB);robot.keyRelease(KeyEvent.VK_CONTROL) ;  // there are must be 
		
		try {Thread.sleep(500);	} catch (InterruptedException e) {	e.printStackTrace();	}
		
		dri.switchTo().window(wi); // Here change the window 
		try {Thread.sleep(100);	} catch (InterruptedException e) {	e.printStackTrace();	}
		
		dri.get(urls.next()); // Here I have to pass the new url of the application 
		try {Thread.sleep(1200);	} catch (InterruptedException e) {	e.printStackTrace();	}
		System.out.println("title :: "+dri.getTitle());
	}
	
	// Here My requirement is how to open a new window like ctrl+t for that purpose I will use the Robot class 
	
	
	
	try {	Thread.sleep(1000);	} catch (InterruptedException e) {		e.printStackTrace();	}
	
	//dri.quit(); // check this later on which I will use 
	dri.close();// only current working window
	
	
	
	
	
	
	
	
	
	
	
	
}
}
