package Scripts;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ObjectRepository.PhpMyTravelsHotels;
import reusable.Login;
import reusable.ScrollToElement;

public class Hotels {
	private String username = "user@phptravels.com";
	private String password = "demouser";
	private WebDriver driver;

	@BeforeClass
	public void beforeMethod() {
		try {

			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Neouser\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

			// driver.get("http://phptravels.net");
			driver.get("http://www.phptravels.net/hotels");
			new Login().login_page(driver, username, password);
		} catch (Exception e) {
			System.out.println("Exception in before test" + e.getMessage());
			Assert.fail();
		}
	}

	@Test
	public void f() {
		try {
			new PhpMyTravelsHotels(driver).btnHotel.click();

			List<WebElement> ele = new PhpMyTravelsHotels(driver).btnDetails;
			Random random = new Random();
			int i = random.nextInt(ele.size());
			System.out.println(i);
			new PhpMyTravelsHotels(driver);
			Thread.sleep(3000);
			ScrollToElement.scrollAndClick(driver, ele.get(i));
			Thread.sleep(3000);
			
			List<WebElement> elem = new PhpMyTravelsHotels(driver).btnBooking;
			int j = random.nextInt(elem.size());
			System.out.println(j);
			
			Thread.sleep(3000);
			 ScrollToElement.scrollAndClick(driver, elem.get(j));
			
			
		} catch (Exception e) {
			System.out.println("exception while booking hotel" + e.getMessage());
			Assert.fail();
		}

	}

	@AfterClass
	public void closeDriver() throws InterruptedException {
		Thread.sleep(3000);
	//	driver.quit();
	}
}
