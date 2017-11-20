package Scripts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class PhpMyTravel {

	WebDriver driver;
	JavascriptExecutor jse;

	public void invokeBrowser() throws InterruptedException {
		try {

			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Neouser\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			driver.get("http://phptravels.net");
			Thread.sleep(2000);
			searchCode();
			// Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		// driver.quit();

	}

	public void searchCode() {

		try {
			//Thread.sleep(3000);
			
		//	driver.findElement(By.xpath("//*[@class='col-md-6']//a[@href='//www.phptravels.net']")).click();
//			String handle = driver.getWindowHandle();
		/*	for (String handle1 : driver.getWindowHandles()) {

	        	System.out.println(handle1);

	        	driver.switchTo().window(handle1);

	        	}*/
//			System.out.println(handle);
			System.out.println(driver.getTitle());
			
			 driver.findElement(By.xpath("//*[@class='navbar-collapse collapse']//ul/li[@id='li_myaccount']/a")) .click();
			  //Thread.sleep(2000);
			 driver.findElement(By.xpath("//*[@class='navbar-collapse collapse']/ul/ul/li/ul/li[1]/a")).click();
			 driver.findElement(By.xpath("//*[@class='wow fadeIn animated']/div/div/input[@name='username']")). sendKeys("user@phptravels.com"); 
			 driver.findElement(By.xpath("//*[@class='wow fadeIn animated']/div/div/input[@name='password']")).sendKeys("demouser");
			  Thread.sleep(2000);

			 driver.findElement(By.xpath("//*[@class='wow fadeIn animated']/button")).click();
			 Thread.sleep(3000);
			// driver.findElement(By.xpath("//*[@class='nav profile-tabs']/li[2]/a")).click(); 
			// driver.findElement(By.xpath("//*[@class='form-group']/div/input[@name='phone']")).sendKeys("96969696");
			/* WebElement element = driver.findElement(By.xpath("//a[@class='dropdown-toggle go-text-right']//i[@class='icon-money-2 go-right']"));
			 Actions action = new Actions(driver);
			 action.moveToElement(element).moveToElement(driver.findElement(By.xpath("//a[@class='go-text-right'][contains(text(),'KWD')]"))).click();*/
			/* Select select = new Select(element);
			 Thread.sleep(3000);
			 select.selectByValue("KWD");*/
			// System.exit(0);
		/*	 driver.findElement(By.xpath("(//*[@id='bookings']//a[contains(text(),'Invoice')])[1]")).click();
			 String sHandle = driver.getWindowHandle();
			 driver.switchTo().window(sHandle);*/
			 driver.findElement(By.xpath("//ul[@class='nav navbar-nav navbar-left go-right']//li[7]//a")).click();
			 Thread.sleep(2000);
			 driver.findElement(By.xpath("//*[@class='col-md-8'][1]//a")).click();
			 WebElement elemImg = driver.findElement(By.xpath("//*[@class='panel-body']//img[@class='img-responsive']"));
			 
			 Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", elemImg);
			 if (!ImagePresent)
		        {
		             System.out.println("Image not displayed.");
		        }
		        else
		        {
		            System.out.println("Image displayed.");
		        }
			
			 
	} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	/*public void scrollFunction() {
	
			jse.executeScript("arguments[0].scrollIntoView(true);",ele);
			ele.click();
	}*/

	public static void main(String[] args) throws InterruptedException {

		PhpMyTravel pm = new PhpMyTravel();
		pm.invokeBrowser();

	}

}
