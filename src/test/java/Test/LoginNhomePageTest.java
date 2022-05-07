package Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import POM.AssertionOnZerodhaloginPage;
import POM.LoginNhomePage;
import Pojo.Browser;
import Utilities.Excel;
import Utilities.ScreenShot;

public class LoginNhomePageTest {
WebDriver driver;

	
	@BeforeMethod
	public void LoginNhomePageTest() throws EncryptedDocumentException, IOException{
		driver = Browser.openBrowser("https://kite.zerodha.com/");
		LoginNhomePage loginPage=new LoginNhomePage(driver);
		String actualText = loginPage.logintokiteText();
		String expectedText = "Login to Kite";
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualText, expectedText);
		
		String userName=Excel.getData(0, 1, "Credentials");
		loginPage.enterUsername(userName);
		String password=Excel.getData(1, 1, "Credentials");
		loginPage.enterPassword(password);
		loginPage.clickOnloginButton();
		ScreenShot.TakesShot(driver, "Login");
		String PiN=Excel.getData(2, 1, "Credentials");
		loginPage.enterPin(PiN,driver);
		loginPage.clickOnContinueButton();
		softAssert.assertAll();
		ScreenShot.TakesShot(driver, "ZerodhaHomePage");

	}
	@Test
	public void buyStockTest() throws InterruptedException, IOException {
		LoginNhomePage homePage=new LoginNhomePage(driver);
		homePage.dashboardgetTitle(driver);
		String title=driver.getTitle();
		String actualTitle= title;
		String expectedTitle="Dashboard / Kite";
		Assert.assertEquals(actualTitle, expectedTitle, title);
		homePage.serchStock("ACC");
		homePage.selectACCStock(driver);
		homePage.clickOnBuy();
		Thread.sleep(1000);
		ScreenShot.TakesShot(driver, "ACC Stock");
		homePage.clickOnRadioBSE(driver);
		Thread.sleep(1000);
		homePage.clickOnRadioNSE(driver);
		Thread.sleep(1000);
		homePage.clickOnSubmit(driver);
		Thread.sleep(1000);
		homePage.clickOnSwitch(driver);
		Thread.sleep(1000);
		homePage.clickOnSell(driver);
		ScreenShot.TakesShot(driver, "ACC StockSell");
		Thread.sleep(1000);
		homePage.clickOnCancel();
	
	}
	

}
