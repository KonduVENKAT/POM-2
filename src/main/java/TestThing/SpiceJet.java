package TestThing;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SpiceJet {
	
	
	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver", "/home/venkat/Softwares/Browsers/chromedriver");
		WebDriver dri=new ChromeDriver();
		
		dri.get("https://www.spicejet.com/");
		dri.manage().window().maximize();
		Actions act=new Actions(dri);
		Thread.sleep(5000);
		
	//	WebElement drop=dri.findElement(By.id("ctl00_mainContent_ddl_originStation1"));
							//				   ctl00_mainContent_ddl_originStation1 Element is ok but why it is not interacting that element 
		
		
		//WebElement drop=dri.findElement(By.xpath("//div[contains(@id,'ctl00_mainContent_ddl_originStation1')]"));
		
		WebElement drop2=dri.findElement(By.xpath("//span[contains(@id,'ctl00_mainContent_ddl_originStation1_CTXTaction')]"));
		drop2.click();
		
		Thread.sleep(1000);
		
		drop2.click();
		
		System.out.println("Element is located ");
		
		//act.moveToElement(drop).build().perform();
		System.out.println("Mouse is moved to the element Then what I will do ");
		//act.click(drop);
		
		String val=drop2.getAttribute("value");
		
		Select sel=new Select(drop2); // this is drop down things How to do select the 0 rth index at the same time 
		System.out.println("Element is passed to the Select Class ");
		sel.selectByIndex(2);			// How to click the drop down options 
		
		System.out.println("Element is clicked ");
	}

}
