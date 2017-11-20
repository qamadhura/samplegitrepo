package Scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FbDemo {
	WebDriver driver;
	
	public void invokeBrowser() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Neouser\\Downloads\\chromedriver_win32\\chromedriver.exe" );
		driver = new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("http://www.facebook.com/");
		searchElement();
	}
	
	public void searchElement() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//*[contains(@id,'email')]")).sendKeys("qsuryawanshi@gmail.com");
		driver.findElement(By.xpath("//*[@id='pass']")).sendKeys("madhura123");
		driver.findElement(By.xpath("//*[@id='loginbutton']/input[@type='submit']")).click();

		
	}
	public static void main(String[] args) {
		FbDemo f = new FbDemo();
		f.invokeBrowser();
	}

}
