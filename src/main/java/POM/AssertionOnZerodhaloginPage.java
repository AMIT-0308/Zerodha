package POM;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AssertionOnZerodhaloginPage {
	
	@FindBy(xpath="//div[@class=\"form-header text-center\"]")private WebElement logintokite;
	@FindBy(xpath="//input[@id='userid']")private WebElement userName;
	@FindBy(xpath="//input[@id='password']")private WebElement password;
	@FindBy(xpath="//button[@type='submit']")private WebElement login;
	@FindBy(xpath="//input[@label='PIN']")private WebElement pin;
	@FindBy(xpath="//button[@type='submit']")private WebElement continueButton;
	@FindBy(xpath="//a[text()='Forgot user ID or password?']")private WebElement forgotpass;
	@FindBy(xpath="//a[text()=\"Don't have an account? Signup now!\"]")private WebElement signup;
	@FindBy(xpath="//a[@href='/dashboard']")private WebElement dashboard;
	@FindBy(xpath="//input[@icon='search']")private WebElement searchBox;
	@FindBy(xpath="//ul[@class='omnisearch-results']//div//li[1]")private WebElement accStock;
	@FindBy(xpath="(//button[@type=\"button\"])[1]")private WebElement buy;
	public AssertionOnZerodhaloginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		}
	
	public String logintokiteText() {
		 return logintokite.getText();	
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
	
	public String dashboardgetTitle(WebDriver driver) {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofMillis(2000));
		wait.until(ExpectedConditions.visibilityOf(dashboard));
		return dashboard.getText();
	}
	public void serchStock(String stockName) {
		searchBox.sendKeys(stockName);
	}
	public void selectACCStock(WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(2000));
		wait.until(ExpectedConditions.visibilityOf(accStock));
		Actions action=new Actions(driver);
		action.moveToElement(accStock);
		action.perform();
	}
	public void clickOnBuy() {
		buy.click();
	}

}

