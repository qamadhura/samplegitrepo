package Scripts;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class a {

	String Username = "";
	String Password = "";
	String sEmailHost = "imap.mail.yahoo.com";
	String sEMailStoreType = "imaps";
	String sUrl;
	String Box_Email_address = "suryawanshi.madhura@yahoo.com";
	String Box_Password = "ms#18695";
	private static WebDriver driver;
	private String sTodayssDate = "2017-07-03";

	public static void main(String[] args) {
		
		SDX_Newsletter_Daily_Scenario();
		
	}
	public static void SDX_Newsletter_Daily_Scenario() {
		try {
					System.setProperty("webdriver.chrome.driver","C:\\Users\\Neouser\\Downloads\\chromedriver_win32\\chromedriver.exe");
					driver = new ChromeDriver();
					driver.manage().window().maximize();
					driver.get("https://in.yahoo.com/?p=us");
					Thread.sleep(1000);
			//		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//					sTodayssDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString();
		//			FileUtils.copyFile(scrFile, new File("D:\\Java_Test\\SeleniumDemo\\Screenshot\\a" + ".png"));
					
					driver.close();
						}
		catch(Exception e)
	{
		System.out.println("Exception" + e.getMessage());
	}
}}
