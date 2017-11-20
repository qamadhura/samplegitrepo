package ObjectRepository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PhpMyTravelsFlight {
	
	@FindBy(xpath = "//*[@class='go-right  '][2]//a")
	public WebElement btnFlight;
	
	@FindBy(xpath = "//span[text()='Modify']")
	public WebElement btnModify;
	
//	@FindBy(xpath = "//label[text()='Origin']//..//a[@class='select2-choice']")
	@FindBy(xpath = "//*[@id=\"s2id_autogen1\"]/a/span[1]")
	public WebElement selectSource;
	
	@FindBy(xpath = "//*[@id='select2-drop']//input")
	public WebElement inputSource ;
	
	@FindAll({@FindBy(xpath = "//*[@id='select2-drop']//ul//li") })
	public List<WebElement> listsource;
	
	
	@FindBy(xpath = "//*[@id=\"s2id_autogen3\"]/a/span[1]")//*[@id='select2-drop']
	public WebElement selectDestination;
	
	@FindBy(xpath = "//*[@id='select2-drop']//input")
	public WebElement inputDestination;
	
	@FindBy(xpath = "//*[@id='select2-drop']//ul//li[1]")
	public WebElement listDestination;
	
	@FindBy(xpath = "//*[@class='form input-lg departureTime']")
	public WebElement inputDate;
	
	@FindAll({@FindBy(xpath = "//*[@class='datepicker-days']//table//tr") })
	public List<WebElement> calendarpick;
	
	@FindBy(xpath="//button[text()=' Search            ']")
	public WebElement btnSearch;
	
	@FindAll({ @FindBy(xpath = "//*[@class='flight-price-grid']//button") })
	public List<WebElement> btnBook;
	
	@FindBy(xpath = "//input[@id='email']")
	public WebElement inputEmail; 
	
	@FindBy(xpath = "//button[@id='confirmBooking']")
	public WebElement btnConfirm;
	
	public PhpMyTravelsFlight(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
}
