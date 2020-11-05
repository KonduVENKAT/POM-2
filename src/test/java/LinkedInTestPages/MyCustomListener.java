package LinkedInTestPages;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


// If I access this things I need to create one Listener Annotation in Test class level  or LinkedInBaseTest class level for all sub test classes 
public class MyCustomListener extends LinkedInBaseTest implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override  /// below I will take screen shot only Full page 
	public void onTestFailure(ITestResult result) { // here I will take screenshot method declared 
		//System.out.println(" I'm in ITestListener onTestFailure()");
		//System.out.println("For taking the screenshot into folder");
		screenshot(result.getMethod().getMethodName()); // class name is not possible without object creation
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
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {  // What I will do with I context  what I kill do 
		// TODO Auto-generated method stub

	}

}
