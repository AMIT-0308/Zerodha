package POM;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	@FindBy(xpath="//input[@icon='search']")private WebElement searchBox;
	@FindBy(xpath="//ul[@class='omnisearch-results']//div//li[1]")private WebElement hdfcStock;
	@FindBy(xpath="//button[@data-balloon='Buy']")private WebElement buy;
	@FindBy(xpath="//span[text()='Holdings']")private WebElement holdings;
	@FindBy(xpath="//input[@value='BSE']")private WebElement BSE;
	@FindBy(xpath="//input[@value='NSE']")private WebElement NSE;
	@FindBy(xpath="//label[text()='AMO']")private WebElement AMO;
	@FindBy(xpath="//label[text()='Iceberg']")private WebElement Iceberg;
	@FindBy(xpath="//label[text()='Regular']")private WebElement regular;
	@FindBy(xpath="//input[@value='MIS']")private WebElement intraday;
	@FindBy(xpath="//input[@value='CNC']")private WebElement longterm;
	@FindBy(xpath="//input[@value='MARKET']")private WebElement market;
	@FindBy(xpath="//input[@value='LIMIT']")private WebElement limit;
	@FindBy(xpath="//input[@value='SL']")private WebElement sl;
	@FindBy(xpath="//input[@value='SL-M']")private WebElement slm;
	@FindBy(xpath="//span[@data-balloon='More options']")private WebElement moreOptions;
	@FindBy(xpath="//span[text()='Stoploss']")private WebElement stoploss;
	@FindBy(xpath="//input[@label='Target']")private WebElement target;
	@FindBy(xpath="//button[@type='submit']")private WebElement submit;
	@FindBy(xpath="//label[@class='su-switch-control']")private WebElement switc;
	@FindBy(xpath="//label[text()='Cover']")private WebElement cover;
	@FindBy(xpath="//input[@label='Qty.']")private WebElement qty;
	@FindBy(xpath="//input[@label='Price']")private WebElement price;
	@FindBy(xpath="(//span[text()='Sell'])[2]")private WebElement sell;
	@FindBy(xpath="//button[@class='button-outline cancel']")private WebElement cancel;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public String getTextHoldings(WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(2000));
		wait.until(ExpectedConditions.visibilityOf(holdings));
		return holdings.getText();
	}
	public void enterStockNmaeInSearchBox(String stockName) {
		searchBox.sendKeys(stockName);	
	}
	public void selectHdfcStock(WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(2000));
		wait.until(ExpectedConditions.visibilityOf(hdfcStock));
		Actions action=new Actions(driver);
		action.moveToElement(hdfcStock);
		action.perform();
	}
	public void clickOnBuy() {
		buy.click();
	}
}
