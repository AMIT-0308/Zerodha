package Test;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Utilities.ScreenShot;

public class ListenerTest extends BaseTest implements ITestListener {

	public void onTestStart(ITestResult Result) {//This will run at the start of every test
		System.out.println("Test has started"+Result.getName());
	}
	
	public void onTestSuccess(ITestResult Result) {//it will execute when test passes
		System.out.println(Result.getName()+ "Test is passed");
	}
	
	public void onTestFailure(ITestResult Result) {//It will execute when test fails
		try {
			ScreenShot.TakesShot(driver, Result.getName());
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void onTestSkipped(ITestResult Result) {//will execute when test skipped
		System.out.println(Result.getName()+" Test skipped");
	}

}
