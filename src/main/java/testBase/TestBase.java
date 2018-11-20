package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.sun.javafx.PlatformUtil;

/**
 * @author Sumit Kumar Sharma
 * @created at 20-Nov-2018
 * This java class contains the setup methods, Browser initialization methods.
 */
public abstract class TestBase {
	public static WebDriver driver;
	public static Properties repository = new Properties();
	public File fis;
	public FileInputStream file;
	
	public abstract void setUp() throws IOException;
	
	/**
	 * This method is used to initialize the Chrome browser and redirecting to URL.
	 * @throws IOException 
	 */
	public void initBrowser() throws IOException{
		loadPropertiesFile();
		Map<String, Object> preference = new HashMap<String, Object>();
		preference.put("profile.default_content_setting_values.notifications", 2);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", preference);
		driver = new ChromeDriver(options);
		setDriverPath();
		driver.get(repository.getProperty("URL"));
	}
	
	public void loadPropertiesFile() throws IOException{
		fis = new File(System.getProperty("user.dir")+"/src/main/java/properties/ObjectProperties");
		file=new FileInputStream(fis);
		repository.load(file);
	}
	/**
	 * This method is used to wait explicitly for some time duration until element to be clickable.
	 * @param driver 
	 * @param time
	 * @param element
	 * @return
	 */
	public WebElement waitForElement(WebDriver driver,long time, WebElement element ){
		WebDriverWait wait = new WebDriverWait(driver, time);
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * This method is used to wait explicitly for some time duration until element to be visible.
	 * @param driver 
	 * @param time
	 * @param element
	 * @return
	 */
	public WebElement waitForElementToVisible(WebDriver driver, int time, WebElement element){
		WebDriverWait wait = new WebDriverWait(driver, time);
		return wait.until(ExpectedConditions.visibilityOf(element));	
	}
	
	/**
	 * This method is used to switch to frame based on frame name.
	 * @param frameName
	 */
	public void switchToFrame(String frameName){
		driver.switchTo().frame(frameName);
	}
	
	/**
	 * This method is used to set the driver based on system requirement.
	 */
	private void setDriverPath() {
	        if (PlatformUtil.isMac()) {
	            System.setProperty("webdriver.chrome.driver", "chromedriver");
	        }
	        if (PlatformUtil.isWindows()) {
	            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	        }
	        if (PlatformUtil.isLinux()) {
	            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
	        }
	    }
	

}
