package Scripts;

import static org.testng.Assert.fail;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ObjectRepository.PhpMyTravelsFlight;
import reusable.Login;
import reusable.ScrollToElement;

public class FlightBooking {
	private String username = "user@phptravels.com";
	private String password = "demouser";
	private String Source = "Delhi";
	private String Destination = "BOM";
	private WebDriver driver;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeMethod(String browser) {
		try {
			if(browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"D:\\Java_Test\\SeleniumDemo\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			}
			else if(browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.firefox.driver", "D:\\Java_Test\\SeleniumDemo\\drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
			}
			else {
				System.out.println("driver not found");
			}
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

			// driver.get("http://phptravels.net");
			driver.get("http://www.phptravels.net/flight");
			new Login().login_page(driver, username, password);
		} catch (Exception e) {
			System.out.println("Exception in before test" + e.getMessage());
			Assert.fail();
		}
	}

	@Test
	public void Book_Flight() {
		try {

			new PhpMyTravelsFlight(driver).btnFlight.click();

			new PhpMyTravelsFlight(driver).btnModify.click();
		
			Thread.sleep(2000);
			new PhpMyTravelsFlight(driver).selectSource.click();
			new PhpMyTravelsFlight(driver).inputSource.sendKeys(Source);
			
			//new PhpMyTravelsFlight(driver).listsource.click();
			
//			Thread.sleep(2000);
//			new PhpMyTravelsFlight(driver).selectDestination.click();
//			new PhpMyTravelsFlight(driver).inputDestination.sendKeys(Destination);
//			Thread.sleep(2000);
//			new PhpMyTravelsFlight(driver).listDestination.click();
//			
//			Thread.sleep(2000);
//			new PhpMyTravelsFlight(driver).btnSearch.click();

			Thread.sleep(2000);
//			Calendar calendar = Calendar.getInstance();
//			Date today = calendar.getTime();
//			calendar.add(Calendar.DAY_OF_YEAR, 1);
//			Date tomorrow = calendar.getTime();
//			DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
//			String tomorrowAsString = dateFormat.format(tomorrow);
			//	new PhpMyTravelsFlight(driver).inputDate.click();
			
			List<WebElement> element = new PhpMyTravelsFlight(driver).listsource;
			
			int i = element.size();
			System.out.println(i);
			Thread.sleep(2000);
			element.get(i-1).click();
			


			// new PhpMyTravelsFlight(driver).inputDate.send
			Thread.sleep(2000);
			new PhpMyTravelsFlight(driver).selectDestination.click();
			 new PhpMyTravelsFlight(driver).inputDestination.sendKeys(Destination);
			 Thread.sleep(2000);
				new PhpMyTravelsFlight(driver).listDestination.click();
				
				Thread.sleep(2000);
				new PhpMyTravelsFlight(driver).btnSearch.click();
				
//				WebDriverWait wait = new WebDriverWait(driver, 60);
//				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='flight-price-grid']//button")));
//			 List<WebElement> ele = new PhpMyTravelsFlight(driver).btnBook;
//			 Random random = new Random();
//			 int ibtn = random.nextInt(ele.size());
//			 
//			 Thread.sleep(3000);
//			//
//			 ScrollToElement.scrollAndClick(driver, ele.get(ibtn));
//			 Thread.sleep(10000);
//			 WebElement elem = new PhpMyTravelsFlight(driver).inputEmail;
//			 System.out.println(elem.getText());
//			  ScrollToElement.scrollToElement(driver, elem);
//			 elem.sendKeys(username);
//			 Thread.sleep(3000);
//			//
//			//
//			 WebElement btnconfirm= new PhpMyTravelsFlight(driver).btnConfirm;
//			 ScrollToElement.scrollAndClick(driver, btnconfirm);
		} catch (Exception e) {
			System.out.println("Exception in flight Booking:" + e.getMessage());
			Assert.fail();
		}
	}

}
