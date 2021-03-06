import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random; 

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class helper {
	///////////////////////
	static ExtentTest logger;
	static ExtentReports report;
	static WebDriver driver;

	/* name of the method:   InitializeDriver
	 * BriefDescription  :  Initialize Chrome Driver
	 * Arguments         :  none
	 *  createdby        :  Automation team 
	 *  created date     :02/20/20 
	 *  LastModified Date:02/22/20          
	 */ 
	public static void InitializeDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

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

		
		public static void createReport() {
			String filename = new SimpleDateFormat("'SFDC_report'YYYYMMddHHmm'.html'").format(new Date());
			System.out.println(filename);
			String path = "/Users/vlad/tmp/marina/" + filename;
			System.out.println(path);
			report = new ExtentReports(path);
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
			public static void  enter_btn_by_id(WebDriver driver, String id) {
				WebElement btn = driver.findElement(By.id(id));
				check_null_isdisplayed_click(btn ,id);

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
				String title = helper.getTitle();
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
			helper.click_btn_by_name(driver, "new");
			 
			 //make public to share with test 27

			 String i_to_str = i+"";
			 String name_account = "AAA_account"+i_to_str;
			 helper.enter_by_name(driver, name_account, "acc2");
			 helper.click_btn_by_name(driver, "save");
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
public static char random_char() {
	
        String alphabet = "bcdefghijklmnopqrstuvwxyz";
        Random rnd = new Random();
        char ch = alphabet.charAt(rnd.nextInt(alphabet.length()));
        return ch;
      
    }
public static String random_last_name(char replaceWith) {
	String str = "Hello";

	StringBuffer aBuffer = new StringBuffer(str);
	aBuffer.setCharAt(aBuffer.length()-1, replaceWith);
	return aBuffer.toString();
}

		
}

