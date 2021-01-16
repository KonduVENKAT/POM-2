package LinkedInTestPages;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;


// If I access this things I need to create one Listener Annotation in Test class level  or LinkedInBaseTest class level for all sub test classes 
public class MyCustomListener extends LinkedInBaseTest implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		if(result.getStatus()==ITestResult.SUCCESS) // all Ready is it sucess  there is no  need to write this if block 
		{
	
		
		}
		
		
	}
// I am unable to taking the screenshot 
	@Override  /// below I will take screen shot only Full page 
	public void onTestFailure(ITestResult result) { // here I will take screenshot method declared 
				//System.out.println(" I'm in ITestListener onTestFailure()");
		//System.out.println("For taking the screenshot into folder");
		screenshot(result.getMethod().getMethodName()); // class name is not possible without object creation
	
		try {Thread.sleep(1000);} catch (InterruptedException e1) {	e1.printStackTrace();	}
	
	 
		if(result.getStatus()==ITestResult.FAILURE)
		{
			
			
		}
	
// and Here I have to add screenshot for this which one is prefer this one or MyWebDriverEventListener class is suitable for this Let Test 		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println(" ****** Test is skipped ------"+result.getMethod().getMethodName());
				
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {  // where we will use this case 
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {  // What I will do with I context  what I kill do 
		// TODO Auto-generated method stub

	}

}
