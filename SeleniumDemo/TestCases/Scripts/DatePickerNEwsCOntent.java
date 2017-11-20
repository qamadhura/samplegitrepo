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

public class DatePickerNEwsCOntent {

	private static WebDriver driver;
	private static String fromDate = "2017-07-01";
	private static String toDate = "2017-07-31";

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
		driver.navigate().to("https://www-rc.sdxcentral.com/wp-admin/admin.php?page=sdx-export-news-content");
		driver.manage().window().maximize();
	}

	@Test
	public void datePickerTest() {

		datepic(fromDate, toDate);
	}

	@AfterClass
	public static void quitDriver() {
		// driver.quit();
	}

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

	public void datepic(String fromDate, String toDate) {
		// for "from" calendar
		try {
			driver.findElement(By.xpath("//*[@id='from_date']")).click();
			Calendar calendar = Calendar.getInstance();
			Date today = calendar.getTime();

			int prev = Integer.parseInt(new SimpleDateFormat("MM").format(today));

			while (prev != 7) {
				driver.findElement(By.xpath("//*[@class='flatpickr-prev-month']")).click();
				prev--;
			}
			DateFormat d = new SimpleDateFormat("yyyy-MM-dd");
			Date required = d.parse(fromDate);
			String l = new SimpleDateFormat("MMMM d, yyyy").format(required);
			System.out.println(l);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//span[contains(@class,'flatpickr-day ')][@aria-label='" + l + "']")).click();

			Thread.sleep(3000);

			// for "to" calendar

			driver.findElement(By.xpath("//*[@id='to_date']")).click();
			Calendar cal = Calendar.getInstance();
			Date today1 = cal.getTime();

			int prev1 = Integer.parseInt(new SimpleDateFormat("MM").format(today1));

			while (prev1 != 7) {
				List<WebElement> we = driver.findElements(By.xpath("//*[@class='flatpickr-prev-month']"));
				we.get(1).click();
				prev1--;
			}

			Date required1 = d.parse(toDate);
			String l1 = new SimpleDateFormat("MMMM d, yyyy").format(required1);
			System.out.println(l1);

//		
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@class='flatpickr-calendar animate arrowTop open']//span[contains(@class,'flatpickr-day ')][@aria-label='"+l1+"']")).click();
			
		} catch (Exception e) {
			System.out.println("Exception while selecting Element" + e.getMessage());
			Assert.fail();
		}
	}

}