package reusable;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScrollToElement {
	public static void scrollAndClick(WebDriver driver, WebElement element) {
		try {
		((JavascriptExecutor) driver).executeScript("javascript:window.scrollTo(" + element.getLocation().getX()
		+ " , " + (element.getLocation().getY() + 100) + ")");
		element.click();
		} catch (Exception e) {
		System.out.println("Exception occured while scrolling to element and clicking - " + e.getMessage());
		}
		}
	
	public static void scrollToElement(WebDriver driver, WebElement element) {
		try {
			((JavascriptExecutor) driver).executeScript("javascript:window.scrollTo(" + element.getLocation().getX()
			+ " , " + (element.getLocation().getY() + 100) + ")");
			
			} catch (Exception e) {
			System.out.println("Exception occured while scrolling to element and clicking - " + e.getMessage());
			}
			}

}


