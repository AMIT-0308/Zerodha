package Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import POM.AssertionOnZerodhaloginPage;
import Pojo.Browser;
import Utilities.Excel;

public class AssertionOnZerodhaloginTest {
	WebDriver driver;
	
	@BeforeMethod
	public void LaunchBrowser() {
		driver = Browser.openBrowser("https://kite.zerodha.com/");
	}
	
	@Test
	public void LoginPageValidation() throws EncryptedDocumentException, IOException {
		AssertionOnZerodhaloginPage validation=new AssertionOnZerodhaloginPage(driver);
		String actualText = validation.logintokiteText();
		String expectedText = "Login to Kite";
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualText, expectedText);
		
		String userName=Excel.getData(0, 1, "Credentials");
		validation.enterUsername(userName);
		String password=Excel.getData(1, 1, "Credentials");
		validation.enterPassword(password);
		validation.clickOnloginButton();
		String PiN=Excel.getData(2, 1, "Credentials");
		validation.enterPin(PiN,driver);
		validation.clickOnContinueButton();
		
		validation.dashboardgetTitle(driver);
		String title=driver.getTitle();
		String actualTitle= title;
		String expectedTitle="Dashboard / Kite";
		Assert.assertEquals(actualTitle, expectedTitle, actualText);
		softAssert.assertAll();
		validation.serchStock("ACC");
		validation.selectACCStock(driver);
		validation.clickOnBuy();
		
	}

}
