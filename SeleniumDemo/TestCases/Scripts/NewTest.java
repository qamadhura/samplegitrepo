package Scripts;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class NewTest {
	private WebDriver driver;
	@BeforeClass
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Neouser\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("http://phptravels.net");

	}

	@BeforeMethod
	public void checkTitle() {
		String Expected_Title = "PHPTRAVELS | Travel Technology Partner";
		String Actual_title = driver.getTitle();
		Assert.assertEquals(Actual_title, Expected_Title);

	}

	@Test()
	public void f() throws InterruptedException {
		try {

			new PhpMyTravelsHotelBooking(driver).btnMyAccount.click();

			// driver.findElement(By.xpath(weMyAccount)) .click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@class='navbar-collapse collapse']/ul/ul/li/ul/li[1]/a")).click();
			driver.findElement(By.xpath("//*[@class='wow fadeIn animated']/div/div/input[@name='username']"))
					.sendKeys("user@phptravels.com");
			driver.findElement(By.xpath("//*[@class='wow fadeIn animated']/div/div/input[@name='password']"))
					.sendKeys("demouser");
			Thread.sleep(2000);

			driver.findElement(By.xpath("//*[@class='wow fadeIn animated']/button")).click();
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@AfterClass
	public void afterMethod() {
		driver.quit();
	}
}