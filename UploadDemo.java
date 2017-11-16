package Scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UploadDemo {

	public static void main(String[] args) {
		try {
	WebDriver driver;
	System.setProperty("webdriver.chrome.driver", "D:\\Java_Test\\SeleniumDemo\\drivers\\chromedriver1.exe");
	
	driver = new ChromeDriver();
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	driver.get("https://imgur.com/upload");


	driver.findElement(By.xpath("//*[@class='browse-btn']")).click();
	Runtime.getRuntime().exec("D:\\Java_Test\\SeleniumDemo\\FileUpload.exe"); //this is executable script which does the auto upload
	
	Thread.sleep(2000);
	driver.close();
	
		}catch(Exception e) {
			System.out.println("Not able to upload"+e.getMessage());
		}
	}

}
