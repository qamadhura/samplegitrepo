package Scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.expectThrows;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class DatePickerTest {

	private static WebDriver driver;

	// Setup Driver
	@BeforeClass
	public static void setupTest() {
		driver = new FirefoxDriver();
		driver.get("https://www-rc.sdxcentral.com/?staging_key=123");
		driver.manage().window().maximize();
		Cookie name = new Cookie("rc_cache", "disable");
		driver.manage().addCookie(name);
		driver.findElement(By.xpath("//*[@class='header__user-menu']//*[text()='Login']")).click();
		driver.findElement(By.xpath("//input[@id='navigation__login-username-input']")).click();
		driver.findElement(By.xpath("//input[@id='navigation__login-username-input']"))
				.sendKeys("qa-team+manager@sdxcentral.com");
		driver.findElement(By.xpath("//*[@id='navigation__login-username']/div[2]/button")).click();
		driver.findElement(By.xpath("//input[@id='navigation__login-password-input']")).click();
		driver.findElement(By.xpath("//input[@id='navigation__login-password-input']")).sendKeys("sds@neova123");
		driver.findElement(By.xpath("//*[@id='navigation__login-password']/div[2]/button")).click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.navigate()
				.to("https://www-rc.sdxcentral.com/wp-admin/admin.php?page=sdx_optins");
		driver.manage().window().maximize();
	}

	@Test
	public void datePickerTest() {
		try {

			// Declare a implicit wait for synchronisation
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[@name='end']")).click();
			String defaultvalue = driver.findElement(By.xpath("//*[@name='end']")).getAttribute("value");
			System.out.println(defaultvalue);
			DateFormat d = new SimpleDateFormat("yyyy-MM-dd"); 
			Date stDate;
			stDate = d.parse(defaultvalue);
			String smonth = new SimpleDateFormat("MM").format(stDate);
			Calendar calendar = Calendar.getInstance();
			Date today = calendar.getTime();
			calendar.add(Calendar.DAY_OF_YEAR, 2);
			Date nextdate = calendar.getTime();

			String scurrentMonth = new SimpleDateFormat("MM").format(nextdate);
			System.out.println(scurrentMonth);
			String l = new SimpleDateFormat("MMMM d, yyyy").format(nextdate);
			System.out.println(l);

			if(smonth.equals(scurrentMonth)) {
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@class='flatpickr-calendar animate showTimeInput open arrowBottom']//span[contains(@class,'flatpickr-day ')][@aria-label='November 11, 2017']")).click();
				
			}
			else {
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@class='flatpickr-next-month']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@class='flatpickr-calendar animate showTimeInput open arrowBottom']//span[contains(@class,'flatpickr-day ')][@aria-label='November 11, 2017']']//span[contains(@class,'flatpickr-day ')][@aria-label='"+l+"']")).click();
			
			}
		
		
			
			
//			driver.findElement(By.xpath("//*[@name='start']")).click();
//			String defaultvalue = driver.findElement(By.xpath("//*[@name='start']")).getAttribute("value");
//			DateFormat d = new SimpleDateFormat("yyyy-MM-dd"); 
//			Date stDate;
//			stDate = d.parse(defaultvalue);
//			String smonth = new SimpleDateFormat("MM").format(stDate);
//			
//			System.out.println(smonth);
//			
//			Calendar calendar = Calendar.getInstance();
//			Date today = calendar.getTime();
//			calendar.add(Calendar.DAY_OF_YEAR, -1);
//			Date nextdate = calendar.getTime();
//
//			String scurrentMonth = new SimpleDateFormat("MM").format(nextdate);
//			System.out.println(scurrentMonth);
//			String l = new SimpleDateFormat("MMMM d, yyyy").format(nextdate);
//			System.out.println(l);
//			if(smonth.equals(scurrentMonth)) {
//				Thread.sleep(4000);
//				driver.findElement(By.xpath("//span[contains(@class,'flatpickr-day ')][@aria-label='"+l+"']")).click();
//				
//			}
//			else {
//				Thread.sleep(4000);
//				driver.findElement(By.xpath("//*[@class='flatpickr-next-month']")).click();
//				Thread.sleep(4000);
//				driver.findElement(By.xpath("//span[contains(@class,'flatpickr-day ')][@aria-label='"+l+"']")).click();
//
//			}
//			// driver.findElement(By.xpath("//*[@class='flatpickr-day
//			// nextMonthDay'][text()='"+sDate+"']")).click();
//		Thread.sleep(2000);
//
//			try {
//
//				driver.findElement(By.xpath("//span[contains(@class,'flatpickr-day ')][@aria-label='"+sDate+"']")).click();
//											
//			} catch (Exception e) {
//
//				System.out.println("Element not found" + e.getMessage());
//				driver.findElement(By.xpath("//*[@class='flatpickr-prev-month']")).click();
//				Thread.sleep(3000);
//				driver.findElement(By.xpath("//span[contains(@class,'flatpickr-day ')][@aria-label='"+sDate+"']")).click();
//			} 

			// TODO: handle exception
			// }
			// if( driver.findElement(By.xpath("//span[contains(@class,'flatpickr-day
			// ')][text()='"+sDate+"']")).isDisplayed()){
			//
			// driver.findElement(By.xpath("//*[@class='flatpickr-day
			// nextMonthDay'][text()='"+sDate+"']")).click();
			// }
			// else {
			// driver.findElement(By.xpath("//*[@class='flatpickr-prev-month']")).click();
			// driver.findElement(By.xpath("//*[@class='flatpickr-day
			// nextMonthDay'][text()='"+sDate+"']")).click();
			//
			// }

//			Thread.sleep(5000);
//			System.exit(0);
//			WebElement element = driver.findElement(By.xpath("//*[@class='flatpickr-day today']"));
//			String currentdate = element.getText();
//			String currentmonth = driver.findElement(By.xpath("//*[@class='cur-month']")).getText();
//
//			String arai = driver.findElement(By.xpath("//span[@class='flatpickr-day today']"))
//					.getAttribute("aria-label");
//			DateFormat df = new SimpleDateFormat("MMMM dd, yyyy");
//			DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
//			Date startDate, a;

			

			// span[contains(@class,'flatpickr-day ')][text()='2']
			// span[text()='2']//..//..//..//..//..//*[@class='cur-month']
			// System.out.println(arai);

			System.exit(0);
		} catch (Exception e) {
			System.out.println("Exception while selecting data" + e.getMessage());
			Assert.fail();
		}
	}

	// Close Driver
	@AfterClass
	public static void quitDriver() {
		// driver.quit();
	}

	// Get The Current Day
	private String getCurrentDay() {
		// Create a Calendar Object
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

		// Get Current Day as a number
		int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
		System.out.println("Today's dtae " + todayInt + "\n");

		// Integer to String Conversion
		String todayStr = Integer.toString(todayInt);
		System.out.println("Today Str: " + todayStr + "\n");

		return todayStr;
	}

}