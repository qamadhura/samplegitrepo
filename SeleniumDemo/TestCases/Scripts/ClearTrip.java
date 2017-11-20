package Scripts;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClearTrip {

	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Neouser\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://www.cleartrip.com");
		driver.findElement(By.xpath("//input[@id='RoundTrip']")).click();
		driver.findElement(By.xpath("//input[@id='FromTag']")).sendKeys("Pune, IN - Lohegaon (PNQ)");
		driver.findElement(By.xpath("//input[@id='ToTag']")).sendKeys("New Delhi, IN - Indira Gandhi Airport (DEL)");
		driver.findElement(By.xpath("//input[@id='DepartDate']")).click();
		driver.findElement(By.xpath("//div[@class='monthBlock first']//a[text()='13']")).click();
		driver.findElement(By.xpath("//input[@id='ReturnDate']")).click();
		driver.findElement(By.xpath("//div[@class='monthBlock first']//a[text()='16']")).click();
		driver.findElement(By.xpath("//select[@id='Adults']")).sendKeys("1");
		driver.findElement(By.xpath("//input[@id='SearchBtn']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.pollingEvery(1, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@style='display: block;']//button[@type='submit'][text()='Book']")));
		WebElement fisrtSpiceJetFlight = driver.findElements(By.xpath("//div[@data-leg='1']//span[contains(text(),'SpiceJet')]")).get(0);
		fisrtSpiceJetFlight.click();
		Thread.sleep(2000);
		//WebElement fisrtVistaraFlight = driver.findElements(By.xpath("//div[@data-leg='2']//span[contains(text(),'Vistara')]")).get(0);
		//fisrtVistaraFlight.click();
		//Thread.sleep(2000);
		
		WebElement ele =driver.findElement(By.xpath("//div[@style='display: block;']//button[@type='submit'][text()='Book']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", ele);
		ele.click();
	}

}
