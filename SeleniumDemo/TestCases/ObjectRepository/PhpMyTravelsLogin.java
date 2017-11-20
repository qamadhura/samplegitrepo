package ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PhpMyTravelsLogin {
	
	@FindBy(xpath="//*[@class='navbar-collapse collapse']//ul/li[@id='li_myaccount']/a")
	public WebElement btnMyAccount;     // Locator For My account button
	
	@FindBy(xpath="//*[@class='navbar-collapse collapse']/ul/ul/li/ul/li[1]/a")
	public WebElement linklogin;
	
	@FindBy(xpath="//*[@class='wow fadeIn animated']/div/div/input[@name='username']")
	public WebElement inputuser;
	
	@FindBy(xpath="//*[@class='wow fadeIn animated']/div/div/input[@name='password']")
	public WebElement inputpassword;
	
	@FindBy(xpath="//*[@class='wow fadeIn animated']/button")
	public WebElement btnlogin;
	
	@FindAll({@FindBy(xpath="//*[@id='input_235_42']/li//label") })
	// Locator For list of "Telecommunications Service Provider, CSP, Enterprise End User or Technology Vendor" radio button field
    public List<WebElement> list_Radiobutton_Telecommunications_Service_Provider_CSP_Enterprise_End_User_Technology_Vendor;
	
	
	// --------------- Instantiating Web Elements Here
	
	public PhpMyTravelsLogin(WebDriver driver){
		PageFactory.initElements(driver, this);
    }

	public void Search(WebDriver driver,String sEmail){
		
	}
	}
	