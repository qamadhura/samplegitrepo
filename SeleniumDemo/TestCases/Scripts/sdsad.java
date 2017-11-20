package Scripts;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Store;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class sdsad {
	static String Username = "sdxcentral@yahoo.com";
	static String Password = "neova@1234";
	static String sEmailHost = "imap.mail.yahoo.com";
	static String sEMailStoreType = "imaps";
	String sUrl;
	String Box_Email_address = "qa-team@sdxcentral.com";
	String Box_Password = "neova@123";
	private WebDriver driver;
	public static String Box_Link = "https://sdncentral.app.box.com/files/0/f/21617524326/Email_Images";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Properties props = new Properties();
			props.put("mail.host", sEmailHost);
			props.setProperty("mail.imap.port", "993");
			props.setProperty("mail.store.protocol", sEMailStoreType);
			props.put("mail.imap.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.setProperty("mail.imap.socketFactory.fallback", "false");
			props.setProperty("mail.imap.socketFactory.port", "993");
			
			Session session = Session.getInstance(props);
			Store store = session.getStore(sEMailStoreType);
			store.connect(Username, Password);
			Folder inbox = store.getFolder("Daily News");
			inbox.open(Folder.READ_ONLY);
			
			Message[] messages = inbox.getMessages();//.getReceivedDate();
			int i1=inbox.getMessageCount();
			Message msg = messages[i1-1];
			System.out.println(msg.getReceivedDate());
			
		//	System.out.println(msg.getReceivedDate());
//			Date message_max_Date = msg.getReceivedDate();
//			for (int i = 1; i <= inbox.getMessageCount(); i++) {
//				if (inbox.getMessage(i).getReceivedDate().after(message_max_Date)) {
//					message_max_Date = inbox.getMessage(i).getReceivedDate();
//					System.out.println(message_max_Date);
//				}
//			}
			String sTodaysDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			if (new SimpleDateFormat("yyyy-MM-dd").format(msg.getReceivedDate()).equals(sTodaysDate)) {
				System.out.println("Daily NewsLetter Email Received For " + sTodaysDate);
				Message msg1 = inbox.getMessage(inbox.getMessageCount());
				Multipart mp = (Multipart) msg.getContent();
				BodyPart bp = mp.getBodyPart(0);
				String sContent = (String) bp.getContent();
				if (sContent.contains("View this email in your browser")) {
					int i = sContent.indexOf("View this email in your browser");
					i = sContent.indexOf("http", i);
					int j = sContent.indexOf("\n", i) - 2;
				String	sUrl = sContent.substring(i, j);
					System.out.println(sUrl);
//					InitializeDriver = new InitializeDriver("production");
//					driver = InitializeDriver.driver;
//					driver.get(sUrl);
//					Thread.sleep(1000);
//					File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//					sTodayssDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString();
//					FileUtils.copyFile(scrFile,
//							new File("C:/SDX_Data/Email_Images/" + sTodayssDate + "-Daily-Newsletter" + ".png"));
//					// FileUtils.copyFile(scrFile, new File(
//					// "C:/Users/jenkins/Box Sync/Email_Images/" + sTodayssDate
//					// + "-Daily-Newsletter" + ".png"));
//					driver.close();
//				} else {
//					System.out.println("Daily NewsLetter Email Link Parsing Failed " + sTodaysDate);
//					Assert.fail();
//				}
//			} else {
//				System.out.println("Daily NewsLetter Email Not Received For " + sTodaysDate);
//				Assert.fail();
//			}
//	
				}			
			}		} catch (Exception e) {
			System.out.println(  e.getMessage());
		//	Assert.fail();
		}
	}
}
