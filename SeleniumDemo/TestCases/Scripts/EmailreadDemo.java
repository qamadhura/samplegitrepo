package Scripts;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Store;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EmailreadDemo {
	static JavascriptExecutor jse;
	static WebDriver driver;
	public static void main(String[] args) {
		try {
			Properties props= new Properties();
			
			props.put("mail.host", "imap.gmail.com");
			props.put("mail.port", "993");
			//props.setProperty("mail.imap.socketFactory.class", "MySocketFactory");
	//		props.put("mail.imap.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	//		props.setProperty("mail.imap.socketFactory.fallback","false");
//			props.setProperty("mail.imap.socketFactory.port", "993");
			props.put("mail.transport.protocol", "imap");
			
			Session session = Session.getInstance(props);
			
			Store store = session.getStore("imaps");
			
			store.connect("qsuryawanshi@gmail.com", "madhura123");
			
			Folder folder = store.getFolder("Inbox");
			folder.open(Folder.READ_ONLY);
			
			
//			String s = folder.getMessage(1).getSubject();
//			System.out.println(s);
			Message[] msgs = folder.getMessages();
			int i1 = folder.getMessageCount();
				Message msg = msgs[i1-1];
				System.out.println(msg.getSubject());
				Object content = msg.getContent();
				
				Multipart multipart = (Multipart) content;
				BodyPart bodyPart = multipart.getBodyPart(0);
				
				Object o = bodyPart.getContent();
				String line = (String) o;
				System.out.println(line);
				
			if(line.contains("View this email")){
				
				int i = line.indexOf("View");
				 i=line.indexOf("\n", i) + 2;
			
				 int j = line.indexOf(">",line.indexOf("View"));
		
			 String hrf = line.substring(i, j);
			 System.out.println(hrf);
		 
				
				
			
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\Neouser\\Downloads\\chromedriver_win32\\chromedriver.exe");
				driver = new ChromeDriver();
				
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
				driver.get(hrf);
				Thread.sleep(3000);
				
//				Runnable takeScreenshot = new Runnable()
//				{
//				        public void run() {
//				            try {
	//			            	takeScreenshot(driver,"D:\\Java_Test\\SeleniumDemo\\Screenshot\\");
//								 jse = (JavascriptExecutor)driver;
//								jse.executeScript("window.scrollBy(0,400)", "");
//				            } catch (IOException e) {
//				                e.printStackTrace();
//				            }
//				        }
//				 };
//				    ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
//				    executor.scheduleAtFixedRate(takeScreenshot, 0, 3, TimeUnit.SECONDS);
//				

				
				
			}
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		

	}
	public static void takeScreenshot(WebDriver driver, String filewithpath) throws IOException{
		
		TakesScreenshot scrShot = (TakesScreenshot) driver;
		
		File Srcfile = scrShot.getScreenshotAs(OutputType.FILE);
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		File DestFile=new File(filewithpath+formater.format(calendar.getTime())+".jpg");
		FileUtils.copyFile(Srcfile, DestFile);
	}

}
