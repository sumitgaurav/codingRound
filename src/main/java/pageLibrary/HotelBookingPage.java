package pageLibrary;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import testBase.TestBase;

public class HotelBookingPage extends TestBase {

    WebDriver driver;
    
    @FindBy(linkText = "Hotels")
    private WebElement hotelLink;

    @FindBy(id = "Tags")
    public WebElement localityTextBox;
    
    @FindBy(id = "CheckInDate")
    public WebElement CheckInDateField;
    
    @FindBy(id = "CheckOutDate")
    public WebElement CheckOutDateField;

    
    @FindBy(id = "travellersOnhome")
    private WebElement travellerSelection;
    
    @FindBy(id = "SearchHotelsButton")
    private WebElement searchButton;

  

    public HotelBookingPage(WebDriver driver){
    	PageFactory.initElements(driver, this);
    }
    
    public void clickOnHotelsTab(){
    	hotelLink.click();
    }
    
    public void enterLocalityAndCityName(String name){
    	localityTextBox.sendKeys(name);
    	waitFor(5);
    	List<WebElement> list = driver.findElement(By.id("ui-id-1")).findElements(By.tagName("li"));
    	list.get(1).click();
    }
    
    public void enterCheckInDate(String day){
    	CheckInDateField.click();
    	selectDate(day);
    }
    
    
    
    public void enterCheckOutDate(String day){
    	CheckOutDateField.click();
    	selectDate(day);
    }
    
    public void selectDate(String day){
    	By calendarXpath = By.xpath("//td[not(contains(@class,'ui-datepicker-unselectable'))]/a[text()='"+ day+"']");
    	driver.findElement(calendarXpath).click();
    }
    
    public void selectTravellers(String traveller){
    	new Select(travellerSelection).selectByVisibleText(traveller);
    }
    
    public void clickOnSearchButton(){
    	searchButton.click();
    }
    
}
