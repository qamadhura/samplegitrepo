package Scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioDemo {
	WebDriver driver;
	JavascriptExecutor jse;
	
	public void invokeBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Neouser\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
//		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		driver.get("http://toolsqa.com/automation-practice-form");
		Thread.sleep(2000);
		searhElement();

	}
	
	public void searhElement() {
		
	//
		WebElement rdionBtn = driver.findElement(By.xpath("//input[@id='exp-0']"));
		rdionBtn.click();
		driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("20-10-1962");
		WebElement chkBtn = driver.findElement(By.xpath("//input[@id='profession-1']"));
		chkBtn.click();
	
	}
	public static void main(String[] args) throws InterruptedException {
		RadioDemo ifd = new RadioDemo();
		
		ifd.invokeBrowser();
		
	}

}
