package POM;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
		@FindBy(xpath="//input[@id='userid']")private WebElement userName;
		@FindBy(xpath="//input[@id='password']")private WebElement password;
		@FindBy(xpath="//button[@type='submit']")private WebElement login;
		@FindBy(xpath="//input[@label='PIN']")private WebElement pin;
		@FindBy(xpath="//button[@type='submit']")private WebElement continueButton;
		@FindBy(xpath="//a[text()='Forgot user ID or password?']")private WebElement forgotpass;
		@FindBy(xpath="//a[text()=\"Don't have an account? Signup now!\"]")private WebElement signup;
		public LoginPage(WebDriver driver) {
			PageFactory.initElements(driver,this);
			}
		public void enterUsername(String name) {
			userName.sendKeys(name);
		}
		public void enterPassword(String Pass) {
			password.sendKeys(Pass);
		}
		public void clickOnloginButton() {
			login.click();
		}
	
		public void enterPin(String Pin, WebDriver driver) {
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(1000));
			wait.until(ExpectedConditions.visibilityOf(pin));
			pin.sendKeys(Pin);
		}
		public void clickOnContinueButton() {
			
			
			continueButton.click();
		}
		public void clickOnForgotPass() {
			forgotpass.click();
		}
		public void clickOnSignUp() {
			signup.click();
		}

}
