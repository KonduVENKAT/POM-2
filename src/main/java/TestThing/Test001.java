package TestThing;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test001 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","/home/venkat/Softwares/Browsers/chromedriver");//get this value from properties file 
		
		//System.setProperty("webdirver.chrome.driver","/home/venkat/Softwares/Browsers/chromedriver");
							//webdriver.chrome.driver
		WebDriver dri=new ChromeDriver();
	
		dri.get("https://www.linkedin.com/");
		dri.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);

		dri.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);	
		
		dri.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// here I have to write line by line or element by element values I have t give
		
		dri.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
		try {	Thread.sleep(500);	} catch (InterruptedException e) {		e.printStackTrace();	}
		
		dri.findElement(By.xpath("//input[@id='username']")).sendKeys("konduvenkatarao999@gmail.com");
		System.out.println("user name is passed through xpath(//input[@id='username'])");

		try {	Thread.sleep(500);	} catch (InterruptedException e) {		e.printStackTrace();	}
		
		dri.findElement(By.xpath("//input[contains(@id,'password')]")).sendKeys("9885861920");
		System.out.println("Passord is passed through xpath(//input[contains(@id,'password')])");

		try {	Thread.sleep(500);	} catch (InterruptedException e) {		e.printStackTrace();	}
		
		dri.findElement(By.xpath("//span[contains(text(),'Show')]")).click();
		System.out.println("Show button is clicked through xpath(//span[contains(text(),'Show')])");

		try {	Thread.sleep(500);	} catch (InterruptedException e) {		e.printStackTrace();	}
		
		
		// for second time it's hide the password feild
		
		dri.findElement(By.xpath("//span[contains(text(),'Hide')]")).click();
		System.out.println("Hide  button is clicked through xpath(//span[contains(text(),'Show')])");
			

		try {	Thread.sleep(500);	} catch (InterruptedException e) {		e.printStackTrace();	}
		
		dri.findElement(By.xpath("//button[contains(text(),'Sign in')]")).click();
		
		System.out.println("Im in user Home page check the page ");
		
		
		// here I want down  the massage down that one 

		dri.manage().window().maximize();
		try {	Thread.sleep(1000);	} catch (InterruptedException e) {		e.printStackTrace();	}
		/*
		 * dri.findElement(By.xpath("//svg[@class='mercado-match']")).click(); // this  not working or not
		 * System.out.println(" I down the messege field in to taht page ");
		 */
		
		
		// Here I want to do logout functionality 
		
		
		
		dri.findElement(By.xpath("//button[@id='ember36']")).click();  // this is click in setting and privicy 
		System.out.println(" For logout i clicked on the top of Me button in tha home page ");
		try {	Thread.sleep(1000);	} catch (InterruptedException e) {		e.printStackTrace();	}
		
		
	//	dri.findElement(By.xpath("//div[@id='ember39']")).click();
		
		
		//WebElement logout=dri.findElement(By.xpath("//div[@id='ember40']"));  // this is for work menu Item 
		WebElement logout=dri.findElement(By.xpath("//div[@id='ember39']"));  // this is for work menu Item 
		
		String text=logout.getText();
		System.out.println("Text of this tag  :: "+text);
		
		//try {	Thread.sleep(5000);	} catch (InterruptedException e) {		e.printStackTrace();	}
		//logout.click();
		// I want to get the scrren shot perticuler scrren shot 
		
		//WebElement ele=dri.findElement(By.cssSelector("//#ember39"));
			// take a screenshot particular element how to do that  checking 

		// First I'm taking screenshot and then take perticuler screenshot 
		TakesScreenshot screenShot=(TakesScreenshot)dri;
		File src=screenShot.getScreenshotAs(OutputType.FILE);
		File destLoc=new File("./Screenshots/31 Oct 2020/ele1.jpg");
		try {
			FileUtils.copyFile(src, destLoc);
		System.out.println("Scrteenshot is taken ");	
		
		} catch (IOException e1) {
			System.out.println("Screenshot is not taken ");
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		// I want to take screenshot of the particular web element  working fine 
		
		File elesceen=logout.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(elesceen, destLoc);
			System.out.println("Screenshot is taken perticuler webelement ");
		} catch (IOException e1) {
			System.out.println("screenshot is not taken ");
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		//#ember39
		
		
		
		
		
		//div[@id='ember40']
		System.out.println(" I clilk on logout link through xpath ");
	
		try {	Thread.sleep(5000);	} catch (InterruptedException e) {		e.printStackTrace();	}

		System.out.println(" I completed all tasks");
		dri.close();
	}

}
