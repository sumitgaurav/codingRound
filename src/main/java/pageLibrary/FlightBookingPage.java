package pageLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class FlightBookingPage extends TestBase {
	WebDriver driver;
	
	 @FindBy(id = "OneWay")
	  private WebElement oneWayRadioBtn;
	 
	 @FindBy(id = "FromTag")
	  private WebElement fromTextField;
	 
	 @FindBy(id = "ToTag")
	  private WebElement toTextField;
	 
	 @FindBy(id = "ui-id-1")
	  private WebElement fromOptions;
	 
	 @FindBy(id = "ui-id-2")
	  private WebElement toOptions;
	 
	 @FindBy(xpath = "//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[3]/td[7]/a")
	  private WebElement calendarDate;
	 
	 @FindBy(id = "SearchBtn")
	  private WebElement searchButton;
	 
	 @FindBy(xpath = "//div[@class='mDeal clearFix']//a")
	  public WebElement flightDealsLink;
	 
	  public FlightBookingPage(WebDriver driver){
	    	PageFactory.initElements(driver, this);
	    }
	  
	  
	  public void selectOneWayRadioButton(){
		  oneWayRadioBtn.click();
	  }
	  
	  public void enterFromCityName(String cityName){
		  fromTextField.clear();
		  fromTextField.sendKeys(cityName);
		  waitFor(5);
		  fromOptions.findElements(By.tagName("li")).get(0).click();
		  
	  }
	  
	  public void enterToCityName(String cityName){
		  toTextField.clear();
		  toTextField.sendKeys(cityName);
		  waitFor(5);
		  toOptions.findElements(By.tagName("li")).get(0).click();
	  }
	  
	  public void selectCalendarDate(){
		  calendarDate.click();
	  }
	  
	  public void clickOnSearchButton(){
		  searchButton.click();
	  }
}
