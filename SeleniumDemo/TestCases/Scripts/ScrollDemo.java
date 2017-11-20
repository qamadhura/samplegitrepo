package Scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class ScrollDemo {
	WebDriver driver;
	JavascriptExecutor jse;
	
	public void invokeBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Neouser\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.get("http://www.360logica.com/blog/multiple-ways-to-scroll-a-page-using-selenium-webdriver");
		searchElement();
//		Thread.sleep(5000);
//		driver.close();
	}
	
	public void searchElement() {
		try {
			jse = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//a[@id='gaq']"));
	//	jse.executeScript("arguments[0].scrollIntoView()", element);
	//	scrollElement(element);
		
	
		scrollElement(element);
		
		Thread.sleep(2000);
		element.click();
		}
		catch(Exception ex){
			System.out.println(ex);
		}
		
	}
	
	public void scrollElement(WebElement element){
		int x = element.getLocation().getX();
		int y= element.getLocation().getY()-100;
		jse.executeScript("window.scrollBy("+x+","+y+")","");


	}
	public static void main(String[] args) throws InterruptedException {
		ScrollDemo sd = new ScrollDemo();
		sd.invokeBrowser();
	}

}
