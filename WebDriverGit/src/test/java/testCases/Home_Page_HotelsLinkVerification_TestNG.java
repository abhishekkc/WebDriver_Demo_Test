package testCases;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.Reporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//Import the POM class
import pageObjectModel.Home_Page;
import pageObjectModel.Hotels;
//Import the Utility class
import appUtility.webPage;
//import gherkin.formatter.Reporter;

public class Home_Page_HotelsLinkVerification_TestNG {
	 private static WebDriver driver = null;
	 
	 @BeforeMethod
		public void setUp() throws Exception {
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Drivers\\chromedriver\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			String url="http://hotwire.com";
			//navigate to google homepage
			driver.get(url);
			driver.manage().window().maximize();
		}
	 
	 @AfterMethod
		public void tearDown() throws Exception {
			driver.quit();
		}
		@Test
		public void test() {
			//Call the pom method to click on hotels link
			Home_Page.lnk_Hotels(driver).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//verify the location by calling the pom method for destinations
			Assert.assertTrue(Hotels.edit_Destination(driver).isDisplayed());
			Reporter.log("Successfully Verified the hotels page");
			//navigate back to home page using the apputility
			webPage.Nvg_Page(driver,"http://hotwire.com");
		}	
		
	
}