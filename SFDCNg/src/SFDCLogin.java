import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random; 
import java.util.Arrays;
import java.util.Set;
import org.openqa.selenium.JavascriptExecutor;	

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterClass;


public class SFDCLogin {
	@BeforeClass
	public void Initialize() {
		//InitializeDriver();
		
		helper.InitializeDriver();
		helper.createReport();
	}
	


 @Test(priority = 1, description = "LoginToSF_Test2")
		public void LoginToSF2() throws InterruptedException {
	    	
			helper.logger = helper.report.startTest("LoginToSF_Test2");
			helper.OpenUrl("https://login.salesforce.com/");
			Thread.sleep(2000);
		    helper.enter_by_id("marinad@xyz.com","username");
		    helper.clear_before_password_by_id("Ramina_1","password" );
		    helper.click_btn_by_xpath("//*[@id=\"Login\"]");
		    Thread.sleep(2000);
			String title = helper.getTitle();
			helper.logger.log(LogStatus.INFO, "successfully on page " +title);
			String expected = "Home Page ~ Salesforce - Developer Edition";
			Assert.assertEquals(title, expected);
			Thread.sleep(2000);


}
		@AfterClass
		public void CloseTest() {
			helper.CloseBrowser();
			helper.CloseReport();
		}
		//helper.driver.quit();
		//helper.CloseReport();

}





