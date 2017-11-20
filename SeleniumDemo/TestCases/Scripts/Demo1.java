package Scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo1 {
	
	WebDriver driver;  //to declare the driver
	JavascriptExecutor jse;
	
	public void invokeBrowser() {
		try {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Neouser\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();       //to instantiate the driver 
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();   //for maximizing window
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);   //for page synch
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			//Thread.sleep(3000);
			
			//to fetch the url
			driver.get("http://www.edureka.co");
			System.out.println(driver.getCurrentUrl());
			searchCode();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void searchCode() throws InterruptedException {
		driver.findElement(By.id("homeSearchBar")).sendKeys("Java");  //to find the element and send the data
		driver.findElement(By.id("homeSearchBarIcon")).click();
		Thread.sleep(2000);
		jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0,700)" );
		
		driver.findElement(By.xpath("//label[contains(text(),'Weekend')]")).click();
		
		
	}
	
	public static void main(String[] args) {
		
		Demo1 d = new Demo1();
		d.invokeBrowser();
		
				
	}

}
