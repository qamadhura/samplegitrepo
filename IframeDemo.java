package com.selenium.webdriver.basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class IframeDemo {
	WebDriver driver;
	JavascriptExecutor jse;
	
	public void invokeBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Neouser\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
//		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		driver.get("http://demo.guru99.com/selenium/guru99home/");
		Thread.sleep(2000);
		searchElement();
	}
	public void searchElement() throws InterruptedException {
		
		/*WebElement element = driver.findElement(By.xpath("//*h3"));
		jse.executeScript("arguments[0].scrollIntoView(true)", element);*/
	/*	driver.findElement(By.xpath("//*[@id='a077aa5e']"));

		driver.switchTo().frame("a077aa5e");
		*/
		jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0,2000)");
		Thread.sleep(3000);
		driver.switchTo().frame("a077aa5e");
		driver.findElement(By.xpath("//a[@href='http://www.guru99.com/live-selenium-project.html']")).click();
		for (String handle : driver.getWindowHandles()) {

        	System.out.println(handle);

        	driver.switchTo().window(handle);

        	}
		WebElement element = driver.findElement(By.xpath("//ul[@class=' maximenuck']//li[3]//a"));
		Actions action = new Actions(driver);
		
		action.moveToElement(element).perform();
		action.click().perform();
		WebElement subelement = driver.findElement(By.xpath("//ul[@class='maximenuck2']//a[@href='/selenium-tutorial.html']"));
		action.moveToElement(subelement);
		action.click();
		action.perform();

		
		
		
	}
	public static void main(String[] args) {
		IframeDemo idf = new IframeDemo();
		try {
			idf.invokeBrowser();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}

}
