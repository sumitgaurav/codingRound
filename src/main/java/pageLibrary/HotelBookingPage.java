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
    
    @FindBy(id = "ui-id-1")
    private WebElement localityList;
     
    @FindBy(xpath = "//td[not(contains(@class,'ui-datepicker-unselectable'))]/a[text()='16']")
    private WebElement fromDate;
  
    @FindBy(xpath = "//td[not(contains(@class,'ui-datepicker-unselectable'))]/a[text()='18']")
    private WebElement toDate;
    
    @FindBy(id = "showNearByBox")
    public WebElement searchTextBox;
    
    

    public HotelBookingPage(WebDriver driver){
    	PageFactory.initElements(driver, this);
    }
    
    public void clickOnHotelsTab(){
    	hotelLink.click();
    }
    
    public void enterLocalityAndCityName(String name){
    	localityTextBox.sendKeys(name);
    	waitFor(5);
    	localityList.findElements(By.tagName("li")).get(1).click();
    }
    
    public void enterCheckInDate(){
    	CheckInDateField.click();
    	fromDate.click();
    }
    
    
    
    public void enterCheckOutDate(){
    	CheckOutDateField.click();
    	toDate.click();
    }
    
    
    public void selectTravellers(String traveller){
    	new Select(travellerSelection).selectByVisibleText(traveller);
    }
    
    public void clickOnSearchButton(){
    	searchButton.click();
    }
    
}
