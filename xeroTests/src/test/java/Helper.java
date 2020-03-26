package test.java;

import java.io.File;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Helper {
	///////////////////////
	static ExtentTest logger;
	static ExtentReports report;
	static WebDriver driver;

	/* name of the method:   InitializeDriver
	 * BriefDescription  :  Initialize Chrome Driver
	 * Arguments         :  none
	 *  createdby        :  Automation team 
	 *  created date     :02/20/20 
	 *  LastModified Date:02/28/20          
	 */ 
	public static void InitializeDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	public static boolean wait_for(String title) {
	WebDriverWait wait = new WebDriverWait(driver, 40);
	boolean expected = wait.until(ExpectedConditions.titleContains(title));
	return expected;
	}
	
	public static void beforetest(String browser) throws Exception
	{
	    try {
	        if (browser.equalsIgnoreCase("Firefox")) {
	            System.out.println(browser);
	            //System.setProperty("webdriver.gecko.driver","path_to\\geckodriver.exe");;
	            driver = new FirefoxDriver();
	        } else if (browser.equalsIgnoreCase("chrome")) {
	            System.out.println(browser);
	            WebDriverManager.chromedriver().setup();
	    		driver = new ChromeDriver();
	            //System.setProperty("webdriver.chrome.driver","path_to\\chromedriver.exe");
	            //driver = new ChromeDriver();
	        } else if (browser.equalsIgnoreCase("Safari")) {
	            //System.setProperty("webdriver.ie.driver", "path_to\\IEDriverServer.exe");
	        	 System.out.println("============   "+browser);
	        	driver =  new SafariDriver();
	        }
	    } catch (WebDriverException e) {
	        System.out.println(e.getMessage());
	    }
	}
	/* name of the method:   OpenUrl
	 * BriefDescription  :  Open Url
	 * Arguments         :  String URL
	 *  createdby        :  Automation team 
	 *  created date     :02/20/20 
	 *  LastModified Date:02/28/20          
	 */ 
	public static void OpenUrl(String url) {
		driver.get(url);
		logger.log(LogStatus.INFO, "URL was oppened successfully!!");
		// driver.manage().window().maximize();
	}

	public static void CloseBrowser() {
		driver.quit();
		logger.log(LogStatus.INFO, "Browser was closed successfully!!");
	}

	public static void CloseReport() {
		report.flush();
	}
	/* name of the method:   createReport
	 * BriefDescription  :  create Report 
	 * Arguments         :  None
	 *  createdby        :  Automation team 
	 *  created date     :02/20/20 
	 *  LastModified Date:02/22/20          
	 */ 
		
		public static void createReport() {
			String filename = new SimpleDateFormat("'Xero_report'YYYYMMddHHmm'.html'").format(new Date());
			System.out.println(filename);
			String path = "/Users/vlad/tmp/marina/" + filename;
			System.out.println(path);
			report = new ExtentReports(path);
		}
		/* name of the method:   takeScreenShot
		 * BriefDescription  :  take Screen Shot to be added to report
		 * Arguments         :  None
		 *  createdby        :  Automation team 
		 *  created date     :02/20/20 
		 *  LastModified Date:03/22/20          
		 */ 
		public static String takeScreenShot() throws IOException{
			TakesScreenshot srcShot =((TakesScreenshot)driver);
			File srcFile = srcShot.getScreenshotAs(OutputType.FILE);
			String filename = new SimpleDateFormat("'ScreenShots_'YYYYMMddHHmmss'.png'").format(new Date());
			System.out.println(filename);
			String imagePath = "/Users/vlad/tmp/marina/" + filename;
			File dstFile =new File(imagePath);
			System.out.println(imagePath);
			FileUtils.copyFile(srcFile ,dstFile);
			return imagePath;
			
		}
		public static  void flushReport(){
			report.flush();
			}
		
		public static  WebDriver  open_page(String page) {
			WebDriver driver; 
			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver();
			driver.get(page);
			return driver;

		}
			public static void check_null_isdisplayed(WebElement un, String who, String password_or_name){
				if(un ==null || !un.isDisplayed()) {
					logger.log(LogStatus.ERROR,who+ " Textbox was not found");
					System.out.println(who+ " Textbox was not found");
				}
				else {
					logger.log(LogStatus.INFO,who+ "Textbox was found");
					System.out.println(who+ " Textbox was found");
					un.sendKeys(password_or_name);
					
				}
			}public static void check_null_isdisplayed_and_clear(WebElement un, String who, String password_or_name){
				if(un ==null || !un.isDisplayed()) {
					logger.log(LogStatus.ERROR,who+ " Textbox was not found");
					System.out.println(who+ " Textbox was not found");
				}
				else {
					logger.log(LogStatus.INFO,who+ "Textbox was found");
					System.out.println(who+ " Textbox was found");
					un.clear();
					un.sendKeys(password_or_name);
					
				}
			}
			public static void check_null_isdisplayed_click(WebElement button, String who){
				if(button ==null || !button.isDisplayed()) {
					logger.log(LogStatus.ERROR,who+ "button  was not found");
					System.out.println(who+ " button was not found");
				}
				else {
					logger.log(LogStatus.INFO,who+ "button was found");
					System.out.println(who+ " button was found");
					button.click();
					
				}
			}
			public static void check_null_isdisplayed(WebElement button, String who){
				if(button ==null || !button.isDisplayed()) {
					logger.log(LogStatus.ERROR,who+ "button  was not found");
					System.out.println(who+ " button was not found");
				}
				else {
					logger.log(LogStatus.INFO,who+ "button was found");
					System.out.println(who+ " button was found");
					
					
				}
			}
			
			public static void  enter_un(WebDriver driver, String name) {
			WebElement un = driver.findElement(By.id("username"));
			if(un ==null || !un.isDisplayed()) {
				logger.log(LogStatus.ERROR,"Username Textbox was not found");
				System.out.println("Username Textbox was not found");
			  }
			else {
				logger.log(LogStatus.INFO,"Username Textbox was found");
				System.out.println("Username Textbox was found");
				un.sendKeys(name);
			   }
			}
			public static void  enter_un_or_pw(WebDriver driver , String password_or_name,String id) {
				WebElement un = driver.findElement(By.id(id));
				check_null_isdisplayed(un, id, password_or_name);

				}
			public static void  enter_by_xpath( String my_input,String xpath) {
				WebElement un = driver.findElement(By.xpath(xpath));
				check_null_isdisplayed(un, xpath, my_input);

				}
			public static void  enter_btn_by_id(WebDriver driver, String id) {
				WebElement btn = driver.findElement(By.id(id));
				check_null_isdisplayed_click(btn ,id);

				}
			public void login_to_xero() throws InterruptedException{
				 
	
						enter_by_xpath( "marina@ta.com","/html/body/app-root/div/div[2]/app-login/div/form/div[1]/input");
						enter_by_xpath( "marina","/html/body/app-root/div/div[2]/app-login/div/form/div[2]/input");
					   
					    //clear_before_password_by_id("marina","password" );
					    click_btn_by_xpath("/html/body/app-root/div/div[2]/app-login/div/form/div[3]/button");
					    Thread.sleep(2000);
						String title = getTitle();
						System.out.println(title);
						logger.log(LogStatus.INFO, "successfully on page " +title);
						String expected = "Apitesting";
						Assert.assertEquals(title, expected);
						Thread.sleep(2000);


			}
			
			public static void  enter_btn_by_id( String id) {
				WebElement btn = driver.findElement(By.id(id));
				check_null_isdisplayed_click(btn ,id);

				}
			public static void click_btn_by_xpath(WebDriver driver, String xpth){
				WebElement loginBtn = driver.findElement(By.xpath(xpth));
				check_null_isdisplayed_click(loginBtn ,xpth);
					
			}
			public static void click_btn_by_xpath( String xpth){
				WebElement loginBtn = driver.findElement(By.xpath(xpth));
				check_null_isdisplayed_click(loginBtn ,xpth);
					
			}
			public static WebElement check_element_by_xpath( String xpth){
				WebElement elem = driver.findElement(By.xpath(xpth));
				check_null_isdisplayed(elem ,xpth);
				return elem;
					
			}
			public static WebElement check_element_by_id( String id){
				WebElement elem = driver.findElement(By.id(id));
				check_null_isdisplayed(elem ,id);
				return elem;
					
			}
			public static WebElement check_element_by_className( String class_name){
				WebElement elem = driver.findElement(By.className(class_name));
				check_null_isdisplayed(elem ,class_name);
				return elem;
					
			}
			public static WebElement check_element_by_linkText( String linkText){
				WebElement elem = driver.findElement(By.linkText(linkText)); 
				check_null_isdisplayed(elem ,linkText);
				return elem;
					
			}
			public static void click_element_by_linkText( String linkText){
				WebElement elem = driver.findElement(By.linkText(linkText)); 
				check_null_isdisplayed_click(elem, linkText);
					
			}
			
			public static void check_btn_by_xpath(WebDriver driver, String xpth){
				WebElement loginBtn = driver.findElement(By.xpath(xpth));
				check_null_isdisplayed_click(loginBtn ,xpth);
					
			}
			public static void login_sf(WebDriver driver, String name, String id_name, String password, String id_password, String xpth) {
				enter_un_or_pw(driver, name, id_name);
				enter_un_or_pw(driver, password, id_password);
				click_btn_by_xpath(driver, xpth);
				
			}
			public static void login_sf( String name, String id_name, String password, String id_password, String xpth) {
				enter_un_or_pw(driver, name, id_name);
				enter_un_or_pw(driver, password, id_password);
				click_btn_by_xpath(driver, xpth);
				
			}
			public static void  click_btn_by_name(WebDriver driver, String name) {
				WebElement btn = driver.findElement(By.name(name));
				check_null_isdisplayed_click(btn ,name);

				}
			public static void  click_btn_by_name(String name) {
				WebElement btn = driver.findElement(By.name(name));
				check_null_isdisplayed_click(btn ,name);

				}
			public static void  click_btn_by_id(WebDriver driver, String id) {
				WebElement btn = driver.findElement(By.id(id));
				check_null_isdisplayed_click(btn ,id);

				}
			public static void  click_btn_by_id( String id) {
				WebElement btn = driver.findElement(By.id(id));
				check_null_isdisplayed_click(btn ,id);

				}
			public static void enter_by_name(WebDriver driver, String input, String name) {
				WebElement elem = driver.findElement(By.name(name));
				check_null_isdisplayed(elem, name, input);
			}
			public static void enter_by_name( String input, String name) {
				WebElement elem = driver.findElement(By.name(name));
				check_null_isdisplayed(elem, name, input);
			}
			public static void clear_before_enter_by_name( String input, String name) {
				WebElement elem = driver.findElement(By.name(name));
				check_null_isdisplayed_and_clear(elem, name, input);
			}
			public static void enter_by_id( String input, String id) {
				WebElement elem = driver.findElement(By.id(id));
				check_null_isdisplayed(elem, id, input);
			}
			public static void clear_before_password_by_id(String input, String id) {
			  WebElement pw = driver.findElement(By.id(id));
				pw.clear();
				pw.sendKeys(input);
			}
			public static void default_login_to_SF() {
				String[] my_str = {"marinad@xyz.com","Ramina_1"};
				enter_by_id(my_str[0],"username");
		        clear_before_password_by_id(my_str[1],"password" );
		        click_btn_by_xpath("//*[@id=\"Login\"]");
			}
			public static void verify_home_page() {
				String title = getTitle();
				String expected = "Home Page ~ Salesforce - Developer Edition";
				Assert.assertEquals(title, expected);
			}
			
				
			public static void click_checkBox_by_id(String id) {
							 
					if ( !driver.findElement(By.id(id)).isSelected() )
					{
					     driver.findElement(By.id(id)).click();
					}
			}
			public static void unclick_checkBox_by_id(String id) {
				 
				if ( driver.findElement(By.id(id)).isSelected() )
				{
				     driver.findElement(By.id(id)).click();
				}
		}
			
			public static String getTitle() {
				String title =driver.getTitle();
				System.out.println(title);
				logger.log(LogStatus.INFO, "successfully on page " +title);
				return title;
			}
		    public static void deal_with_popup(WebDriver driver) throws InterruptedException {
					Thread.sleep(1000);
		 			//System.out.println("Expecting new window handel  " +driver.getWindowHandle());
		 			//WebElement XBtn = driver.findElement(By.xpath("//*[@id=\"tryLexDialog\"]/div[1]/div"));
		 			//System.out.println("active window Xbutton " +XBtn.getText()); 
		 		//commenting does not work
		 			//XBtn.click();
		 			WebElement NoThanksBtn = driver.findElement(By.xpath("//*[@id=\"lexNoThanks\"]"));
		 			NoThanksBtn.click();
		 			Thread.sleep(1000);
		 			WebElement SendBtn = driver.findElement(By.xpath("//*[@id=\"lexSubmit\"]"));
		 			SendBtn.click();
				}
		public static void create_account(WebDriver driver,int i) {
			click_btn_by_name(driver, "new");
			 
			 //make public to share with test 27

			 String i_to_str = i+"";
			 String name_account = "AAA_account"+i_to_str;
			 enter_by_name(driver, name_account, "acc2");
			 click_btn_by_name(driver, "save");
		}
		public static String current_date(){
			String cur_date ="";

		    Format f = new SimpleDateFormat("MM/dd/yyyy");
		    cur_date= f.format(new Date());
			return cur_date;
			
		}
		public static void EnterText(WebElement element, String text, String objName) {
			if (element == null || !element.isDisplayed()) {
				//logger.log(LogStatus.ERROR, objName + " Textbox is not found.");
			} else {
				//logger.log(LogStatus.INFO, objName + " Textbox is found");
				element.sendKeys(text);
			}
		}
		/* name of the method:   mouseOver
		 * BriefDescription  :   mouseOver  
		 * Arguments         :  obj,index 
		 *  createdby        :  Automation team 
		 *  created date     :02/13/19 
		 *  LastModified Date:02/13/19          
		 */ 

		public static void MouseOver(WebElement obj) {
			if(obj.isDisplayed()) {
		   Actions action=new Actions(driver);
		   action.moveToElement(obj).build().perform();
			System.out.println("Pass: "+obj+" is present");
//			logger.log(LogStatus.PASS,  "obj is present" );
			}
		 else {
				System.out.println("Fail:"+obj+" is not present.Please chk application");
//				logger.log(LogStatus.FAIL,  "obj is not present.Please chk application" );
			}
		}

}
