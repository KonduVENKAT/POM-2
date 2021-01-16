package customListeners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport  {

	public  static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public  static ExtentTest extentTest;
	String extentReportPath="./test-output/extentReports/";
	
	// This method will call at @BeforeSuite in BaseTest class 
	public void extentSetUP(String DateTime)
	{
		
		htmlReporter=new ExtentHtmlReporter(extentReportPath+"Report-"+DateTime+".html");
		System.out.println("ExtentHtmlReporter is startnig with name"+extentReportPath+"Report-"+DateTime+".html");
	//I don't need this below line of code loadXML config file is not requred because I used @Listener at BaseTestClass level 
		//	htmlReporter.loadXMLConfig("./extent-config.xml"); // for load the xml file 
		htmlReporter.config().setDocumentTitle("LinkedIn Report");
		htmlReporter.config().setReportName("LinkedIn Site Report");// I'will check it is working or not 
		htmlReporter.config().setTheme(Theme.DARK);// later on will change as per requirement 
	// And Logo I have to work on later on How to do that 
		
		extent=new ExtentReports();
//		extent.config(htmlReports);
		extent.attachReporter(htmlReporter);
		
		
		// Below these are for Set the Environment configuration Details 
		extent.setSystemInfo("Host Name", "Local Host");
		
		extent.setSystemInfo("Project Name", "LinkedInSite");
		extent.setSystemInfo("Module", "Sysem Base Things");
		extent.setSystemInfo("Tester Name", "Venkat Kondu");
		extent.setSystemInfo("Operating System", "Ubuntu18.O4");
		extent.setSystemInfo("Browser", "Chrome");
//		extent.setSystemInfo(k, v);
//  	extent.setSystemInfo(k, v);
//		extent.setSystemInfo(k, v);
//		extent.setSystemInfo(k, v);
		
		
		
	}
	
	public void endReport()
	{
		System.out.println("I want to close the report ");
		extent.flush();
		//extent.close() is not visible in this list 
		System.out.println(" Report is closed ");
		
	}
	// this is for Entire Screen page 
	public String screenshotForReport(WebDriver dri,String dateTime , String fileName)
	{
		String fileScreenPath=null; // including name I have to specify or only folder I have to mention 
		
//		String extentReportScreenshots="./Screenshots/"+dateTime+"/ExtentReportScreenshot/"+fileName;
		String extentReportScreenshots="./Screenshots/"+dateTime+"/"+fileName;

		TakesScreenshot screen=(TakesScreenshot)dri;
		
	File source=screen.getScreenshotAs(OutputType.FILE);	
	fileScreenPath=extentReportScreenshots+".jpg";  // here I have to mention including .jpg or not 
	File Destination=new File(fileScreenPath);
		
			try {
			FileUtils.copyFile(source, Destination);
			System.out.println("Screenshot is taken for ExtentReport  and stored in Folder - "+extentReportScreenshots);
		} catch (IOException e) {
			System.out.println("Screenshot is not taken for ExtentReport ");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			return fileScreenPath;
	}
	
	
	//For only particular WebElement How to do that and how can I access this method 
	// And I'm unable to take screenshot
		public String elementScreenshotForReport(WebDriver dri,WebElement ele,String dateTime,String fileName)
	{
		
		String fileScreenPath=null;
		// check here which folder I have to store these Screenshots I want to do next sprint or implementation 
		
		String elementScreenshotFolder="./Screenshots/"+dateTime+"/ElementsScreenshotsForExtentReports/";

		// Later on I will check about this elementScreenshotFolder 
	//      String elementScreenshotFolder="./Screenshots/"+dateTime+"/";

		String elementString=ele.getAttribute("attribute name");
		String elementString1=ele.getText();
		
		File source=ele.getScreenshotAs(OutputType.FILE);
		fileScreenPath=elementScreenshotFolder+elementString1+"jpg";         // here Including fileName.jpg or normal file name  
		File destination=new File(fileScreenPath);
		
		try {
			FileUtils.copyFile(source, destination);
			System.out.println("Element screenshot    IS   taken for ExtentReport ");
		} catch (IOException e) {
			System.out.println("Element screenshot is NOT taken for Extent Report ");
			e.printStackTrace();
		}
  		
		
		return fileScreenPath;
	}
	
	
	
	
}
