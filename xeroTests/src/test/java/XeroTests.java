package test.java;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class XeroTests extends Helper{
	
	@BeforeClass
	public void Initialize() {
		
	InitializeDriver();
	createReport();

	}

 @Test(priority = 1, description = "LoginToXeroIncorrectUN")
		public void LoginToXeroIncorrectUN() throws InterruptedException, IOException {
	    	
			logger = report.startTest("LoginToXeroIncorrectUN");
			OpenUrl(" https://login.xero.com/");
			Thread.sleep(2000);
			enter_by_id("User@gmail.com", "email");
	        enter_by_id("pwd","password");
	        click_btn_by_id("submitButton");
	        Thread.sleep(2000);
	        boolean message_displayed = false;
	        boolean message_displayed_expected =true; 
	         message_displayed =check_element_by_xpath("//p[contains(text(),'Your email or password is incorrect')]").isDisplayed();
	         //logger.log(LogStatus.INFO, "warning shown on login page " + check_element_by_xpath("//p[contains(text(),'Your email or password is incorrect')]").getText());
			 //logger.log(LogStatus.INFO, "warning shown on login page  "  +logger.addScreenCapture(takeScreenShot()));
	       if( message_displayed == message_displayed_expected)
	       {
	    	   logger.log(LogStatus.INFO, "warning shown on login page " + check_element_by_xpath("//p[contains(text(),'Your email or password is incorrect')]").getText());
			   logger.log(LogStatus.INFO, "warning shown on login page  "  +logger.addScreenCapture(takeScreenShot()));
	    	   logger.log(LogStatus.PASS, "Test Pass");
	       }
	       else {
	    	   logger.log(LogStatus.FAIL, "Test Failed");
	       }
	       Assert.assertEquals(message_displayed,message_displayed_expected);

}

 @Test(priority = 2, description = "LoginToXeroIncorrectPW")
	public void LoginToXeroIncorrectPW() throws InterruptedException, IOException {
 	
		logger = report.startTest("LoginToXeroIncorrectPW");
		OpenUrl(" https://login.xero.com/");
		Thread.sleep(2000);
		enter_by_id("gopala.anumanchipalli@gmail.com", "email");
        enter_by_id("password","password");
        click_btn_by_id("submitButton");
        Thread.sleep(2000);
        boolean message_displayed = false;
        boolean message_displayed_expected =true; 
        message_displayed =check_element_by_xpath("//p[contains(text(),'Your email or password is incorrect')]").isDisplayed();
		
		if( message_displayed == message_displayed_expected)
	       {
	    	   logger.log(LogStatus.INFO, "warning shown on login page " + check_element_by_xpath("//p[contains(text(),'Your email or password is incorrect')]").getText());
			   logger.log(LogStatus.INFO, "warning shown on login page  "  +logger.addScreenCapture(takeScreenShot()));
	    	   logger.log(LogStatus.PASS, "Test Pass");
	       }
	       else {
	    	   logger.log(LogStatus.FAIL, "Test Failed");
	       }
     Assert.assertEquals(message_displayed,message_displayed_expected);
        
	   

}
 
 @Test(priority = -1, description = "LoginToXeroLogout")
	public void LoginToXeroLogout() throws InterruptedException, IOException {
 	
		logger = report.startTest("LoginToXeroLogout");
		OpenUrl(" https://login.xero.com/");
		Thread.sleep(2000);
		enter_by_id("gopala.anumanchipalli@gmail.com", "email");
     enter_by_id("password12","password");
     click_btn_by_id("submitButton");
     Thread.sleep(10000);
     String title= getTitle();
     String title_expected =  "My Xero | Home";
     
     if( title.equals(title_expected))
     {
       logger.log(LogStatus.INFO, "Successfully open Home page  "  +logger.addScreenCapture(takeScreenShot())); 
 
     }
     else {
  	   logger.log(LogStatus.FAIL, "Test Failed");
     }
     Assert.assertEquals(title , title_expected );
     click_btn_by_xpath("//a[@class='username']");
     Thread.sleep(2000);
     click_btn_by_xpath("//a[contains(text(),'Logout')]");
     Thread.sleep(6000);
     String text = check_element_by_xpath("//h2[@class='x-boxed noBorder']").getText();
     String text_expected =  "Welcome to Xero";
     if( text.equals(text_expected))
     {
       logger.log(LogStatus.INFO, "Successfully Logout "  +logger.addScreenCapture(takeScreenShot()));
  	   logger.log(LogStatus.PASS, "Test Pass");
     }
     else {
  	   logger.log(LogStatus.FAIL, "Test Failed");
     }
     
     Assert.assertEquals(text,text_expected);
     

}
 
 
 @Test(priority = 1, description = "TryXero")
	public void TryXero() throws InterruptedException, IOException {
 	
		logger = report.startTest("TryXero");
		OpenUrl(" https://www.xero.com/us/");
		Thread.sleep(2000);
		enter_by_id("User@gmail.com", "email");
     enter_by_id("pwd","password");
     click_btn_by_id("submitButton");
     Thread.sleep(2000);
     boolean message_displayed = false;
     boolean message_displayed_expected =true; 
      message_displayed =check_element_by_xpath("//p[contains(text(),'Your email or password is incorrect')]").isDisplayed();
		logger.log(LogStatus.INFO, "warning shown on login page " + check_element_by_xpath("//p[contains(text(),'Your email or password is incorrect')]").getText());
		logger.log(LogStatus.INFO, "warning shown on login page  "  +logger.addScreenCapture(takeScreenShot()));
     Assert.assertEquals(message_displayed,message_displayed_expected);
     
	   

}
 /* @Test(priority = 1, description = "LoginToXero")
	public void LoginToXero() throws InterruptedException {
 	
		logger = report.startTest("LoginToXero");
		OpenUrl(" https://login.xero.com/");
		Thread.sleep(2000);
		enter_by_id("User@gmail.com", "email");
     enter_by_id("pwd","password");
     click_btn_by_id("submitButton");
	   //need to create valoid login
     
	    //clear_before_password_by_id("marina","password" );
	    click_btn_by_xpath("/html/body/app-root/div/div[2]/app-login/div/form/div[3]/button");
	    Thread.sleep(2000);
		String title = getTitle();
		System.out.println(title);
		logger.log(LogStatus.INFO, "successfully on page " +title);
		logger.log(LogStatus.INFO, "successfully on page " +title +logger.addScreenCapture(takeScreenShot()));
		String expected = "Apitesting";
		Assert.assertEquals(title, expected);
		Thread.sleep(2000);


}*/ 
 
	@AfterClass
	public void CloseTest() {
	    CloseBrowser();
		CloseReport();
	}
}
