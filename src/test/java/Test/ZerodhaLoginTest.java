package Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import POM.LoginPage;
import Pojo.Browser;
import Utilities.Excel;
import Utilities.Reports;
@Listeners(ListenerTest.class)
public class ZerodhaLoginTest extends BaseTest{
	ExtentReports reports;
	ExtentTest test;
	@BeforeClass
	public void configureExtentReport() {
	 reports=Reports.addReport();
	}

	@BeforeMethod
	public void LaunchBrowser() {
		driver = Browser.openBrowser("https://kite.zerodha.com/");
	}
	@Test
	public void LoginWithValidCredentials() throws EncryptedDocumentException, IOException, InterruptedException {
		test= reports.createTest("LoginWithValidCredentials");
		LoginPage loginpage=new LoginPage(driver);
		
		String userName=Excel.getData(0, 1, "Credentials");
		loginpage.enterUsername(userName);
		String password=Excel.getData(1, 1, "Credentials");
		loginpage.enterPassword(password);
		loginpage.clickOnloginButton();
		String PiN=Excel.getData(2, 1, "Credentials");
		loginpage.enterPin(PiN,driver);
		loginpage.clickOnContinueButton();
	
	}
	
	@Test
	public void ForgotIDorPassword() {
		test= reports.createTest("ForgotIDorPassword");
		LoginPage forgotidorpassword=new LoginPage(driver);
		forgotidorpassword.clickOnForgotPass();
		Assert.assertTrue(false);
	
		
	}
	@Test(dependsOnMethods = {"ForgotIDorPassword"})
	public void SignUpNow() {
		test= reports.createTest("SignUpNow");
		LoginPage signupnow=new LoginPage(driver);
		signupnow.clickOnSignUp();
		
	}
	@AfterMethod
	public void addTestResult(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
			test.log(Status.FAIL, result.getName());
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getName());
		}
		else {
			test.log(Status.SKIP, result.getName());
		}
	}
	@AfterClass
	public void fiushResults() {
		reports.flush();
	}
}
