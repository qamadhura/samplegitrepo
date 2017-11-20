package ObjectRepository;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PhpMyTravelsHotels {

	private static JavascriptExecutor jse;

	@FindBy(xpath = "//*[@class='go-right  '][1]//a")
	public WebElement btnHotel;

	@FindAll({ @FindBy(xpath = "//a//button") })
	public List<WebElement> btnDetails;
	
	@FindAll({ @FindBy(xpath = "//*[@class='col-md-6']//button") })
	public List<WebElement> btnBooking;

	public PhpMyTravelsHotels(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public static void scrollElement(WebDriver driver, WebElement element) {

		try {

			int x = element.getLocation().getX();
			int y = element.getLocation().getY() - 150;
			jse.executeScript("window.scrollBy(" + x + "," + y + ")", "");
			element.click();
			
			
		} catch (Exception e) {
			System.out.println("Exception while scrolling " + e.getMessage());
			Assert.fail();
		}

	}
	public static void scrollAndClick(WebDriver driver, WebElement element) {
		try {
		((JavascriptExecutor) driver).executeScript("javascript:window.scrollTo(" + element.getLocation().getX()
		+ " , " + (element.getLocation().getY() + 100) + ")");
		element.click();
		} catch (Exception e) {
		System.out.println("Exception occured while scrolling to element and clicking - " + e.getMessage());
		}
		}

}
