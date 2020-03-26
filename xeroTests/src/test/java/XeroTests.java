package test.java;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class XeroTests extends Helper{
	
	@BeforeClass
	public void Initialize() {
		
	//InitializeDriver();
	createReport();

	}
	 @Parameters({ "browser" })

	 @BeforeTest
	 public void changeDriver(String browser) throws Exception {
	 	
	      beforetest(browser);

	 	}


 @Test(priority = 1, description = "LoginToXeroIncorrectUN")
		public void LoginToXeroIncorrectUN() throws InterruptedException, IOException {
	    	
			logger = report.startTest("LoginToXeroIncorrectUN");
			OpenUrl(" https://login.xero.com/");
            boolean page_loaded = false;
            boolean page_loaded_expected = true;
            String title = "Login | Xero Accounting Software";
            if (wait_for( title)) {
            	page_loaded = true;
            }
            if( page_loaded ==  page_loaded_expected)
 	       {
 	    	   logger.log(LogStatus.INFO, "Login | Xero Accounting Software page was  loaded");

 	       }
 	       else {
 	    	   logger.log(LogStatus.FAIL, "Test Failed -  Login | Xero Accounting Software page was not loaded on time");
 	       }
 	       Assert.assertEquals(page_loaded,page_loaded_expected);
 	       
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
		Thread.sleep(10000);
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
		Thread.sleep(10000);
		enter_by_id("gopala.anumanchipalli@gmail.com", "email");
     enter_by_id("password12","password");
     click_btn_by_id("submitButton");
     Thread.sleep(10000);
     String title= getTitle();
     String title_expected =  "Xero | Dashboard | self";
     
     if( title.equals(title_expected))
     {
       logger.log(LogStatus.INFO, "Successfully open Home page  "  +logger.addScreenCapture(takeScreenShot())); 
 
     }
     else {
  	   logger.log(LogStatus.FAIL, "Test Failed");
     }
     Assert.assertEquals(title , title_expected );
     
     
    // click_btn_by_xpath("//a[@class='username']");
     click_btn_by_xpath("//*[@id='header']/header/div/ol[2]/li[5]/button/div/img");
     Thread.sleep(2000);
    // click_btn_by_xpath("//a[contains(text(),'Logout')]");
     click_btn_by_xpath("//*[@id='header']/header/div/ol[2]/li[5]/div/div[2]/div/ol/li[5]/a");
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
		Thread.sleep(10000);
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

  @Test(priority = 4, description = "LoginToXero")
	public void LoginToXero() throws InterruptedException, IOException  {
 	
		logger = report.startTest("LoginToXero");
		OpenUrl(" https://login.xero.com/");
		Thread.sleep(10000);
		enter_by_id("gopala.anumanchipalli@gmail.com", "email");
	    enter_by_id("password12","password");
	    click_btn_by_id("submitButton");
	    Thread.sleep(10000);
	    String title= getTitle();
	    String title_expected =  "Xero | Dashboard | self";
	     
	     if( title.equals(title_expected))
	     {
	       logger.log(LogStatus.INFO, "Successfully open Home page  "  +logger.addScreenCapture(takeScreenShot())); 
	       logger.log(LogStatus.PASS, "Test Pass");
	 
	     }
	     else {
	  	   logger.log(LogStatus.FAIL, "Test Failed -wrong title");
	     }
	     Assert.assertEquals(title , title_expected );


} 
  
  @Test(priority = 3, description = "LoginToXeroForgotPw")
	public void LoginToXeroForgotPw() throws InterruptedException, IOException  {
	
		logger = report.startTest("LoginToXeroForgotPw");
		OpenUrl(" https://login.xero.com/");
		Thread.sleep(10000);
		click_btn_by_xpath("//a[@class='forgot-password-advert']");
		Thread.sleep(10000);
	    enter_by_id("hello@gmail.com","UserName");
	    click_btn_by_xpath("//a[@class='x-btn blue']");
	    Thread.sleep(10000);
	    boolean message_displayed = false;
	    boolean message_displayed_expected =true; 
	    message_displayed =check_element_by_xpath("//p[contains(text(),'A link to reset your password has been sent to:')]").isDisplayed();

	     if( message_displayed == message_displayed_expected)
	       {
	    	 logger.log(LogStatus.INFO, "message on a page:    " + check_element_by_xpath("//p[contains(text(),'A link to reset your password has been sent to:')]").getText());
				logger.log(LogStatus.INFO, "message on a page:    "  +logger.addScreenCapture(takeScreenShot()));
	   
	       }
	       else {
	    	   logger.log(LogStatus.FAIL, "Test Failed");
	       }
         Assert.assertEquals(message_displayed,message_displayed_expected);
         message_displayed =false;
         message_displayed =check_element_by_xpath("//strong[contains(text(),'hello@gmail.com')]").isDisplayed();
         if( message_displayed == message_displayed_expected)
	       {
	    	 logger.log(LogStatus.INFO, "message on a page:     " + check_element_by_xpath("//strong[contains(text(),'hello@gmail.com')]").getText());
				logger.log(LogStatus.INFO, "message on a page:      "  +logger.addScreenCapture(takeScreenShot()));
	    	   logger.log(LogStatus.PASS, "Test Pass");
	       }
	       else {
	    	   logger.log(LogStatus.FAIL, "Test Failed -No message regarding link sent");
	       }
       Assert.assertEquals(message_displayed,message_displayed_expected);
	    
	    
} 

  @Test(priority = 6, description = "TryXeroAllEmpty")
	public void TryXeroAllEmpty() throws InterruptedException, IOException {
	
		logger = report.startTest("TryXeroAllEmpty");
		OpenUrl(" https://www.xero.com/us/");
		Thread.sleep(2000);
		click_element_by_linkText("Try Xero for free");
		Thread.sleep(4000);
		
		String title =check_element_by_linkText("Free trial").getText();
		System.out.println(title);
		String title_expected= "Free trial";
		if( title.equals(title_expected))
	     {
	       logger.log(LogStatus.INFO, "Successfully open Free trail  "  +logger.addScreenCapture(takeScreenShot())); 
	     	 
	     }
	     else {
	  	   logger.log(LogStatus.FAIL, "Test Failed -- No Free trail page");
	     }
	     Assert.assertEquals(title , title_expected );
		
	     //Submit with empty fields
	     click_btn_by_xpath("//span[@class='g-recaptcha-submit']");
	     
	     Thread.sleep(6000);
	     //Check error messages
	     String message_1 =check_element_by_id("signup-form-error-message-1").getText();
	     String message_1_expected = "First name can't be empty";
	     if( message_1.equals(message_1))
	     {
	       logger.log(LogStatus.INFO, "First name can't be empty --- message  is shown "  +logger.addScreenCapture(takeScreenShot())); 
	       logger.log(LogStatus.PASS, "Test Pass");
	     }
	     else {
	  	   logger.log(LogStatus.FAIL, "Test Failed -- First name can't be empty --- message  is NOT shown");
	     }
	     Assert.assertEquals(message_1 , message_1_expected);
	  
  
  }
  @Test(priority = 5, description = "TryXeroFullOfferDetails")
	public void TryXeroFullOfferDetails() throws InterruptedException, IOException {
	
		logger = report.startTest("TryXeroFullOfferDetails");
		OpenUrl(" https://www.xero.com/us/");
		Thread.sleep(2000);
		click_element_by_linkText("Try Xero for free");
		Thread.sleep(4000);
		//String title = check_element_by_xpath("//div[@class='title-text']").getText();
		String title =check_element_by_linkText("Free trial").getText();
		System.out.println(title);
		String title_expected= "Free trial";
		if( title.equals(title_expected))
	     {
	       logger.log(LogStatus.INFO, "Successfully open Free trail  "  +logger.addScreenCapture(takeScreenShot())); 
	     	 
	     }
	     else {
	  	   logger.log(LogStatus.FAIL, "Test Failed -- No Free trail page");
	     }
	     Assert.assertEquals(title , title_expected );
		//click to see full offer
	    Helper.click_element_by_linkText("See full offer details");
	     
	     Thread.sleep(8000);
	     //Check  new page "Offer details" was loaded
	       String winHandleBefore = driver.getWindowHandle();
	        for(String winHandle : driver.getWindowHandles()){
	            driver.switchTo().window(winHandle);
	        }
	     logger.log(LogStatus.INFO, "Successfully open ---Offer details page   "  +logger.addScreenCapture(takeScreenShot()));
	     String title1 = getTitle();
	     System.out.println(title1);
			String title1_expected= "Offer details | Xero US";
			if( title1.equals(title1_expected))
		     {
		       logger.log(LogStatus.INFO, "Successfully open ---Offer details page   "  +logger.addScreenCapture(takeScreenShot())); 
		       logger.log(LogStatus.PASS, "Test Pass"); 
		     }
		     else {
		  	   logger.log(LogStatus.FAIL, "Test Failed -- No Offer details page");
		     }
		     Assert.assertEquals(title1 , title1_expected );
	
	        

}
  
	@AfterClass
	public void CloseTest() {
	    CloseBrowser();
		CloseReport();
	}
}
