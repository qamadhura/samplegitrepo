package Scripts;

import java.io.IOException;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.InternetAddress;

public class SDXDemo {
	public static void check(String host, String Storetype, String user, String password) throws MessagingException, IOException {
		try {
		Properties  props = new Properties();
		
		props.put("mail.pop3.host", "host");
		
		props.put("mail.pop3.port", "995");
		props.put("mail.pop3.starttls.enable", "true");
		
		Session emailsession = Session.getDefaultInstance(props);
		
		Store store = emailsession.getStore("pop3s");
		
		store.connect(host, user, password);
		
		Folder emailfolder = store.getFolder("INBOX");
		emailfolder.open(Folder.READ_ONLY);
		
		Message[] msgs = emailfolder.getMessages();
		System.out.println(msgs.length);
		
		Message msg = msgs[0];
		
		
		System.out.println("FROM:"+ msg.getFrom()[0]);
		   System.out.println("To: " + msg.getAllRecipients()[0].toString());
		System.out.println("SUBJECT:"+msg.getSubject());
		
		String replyto = InternetAddress.toString(msg.getReplyTo());
		System.out.println("REPLY TO:"+replyto);
		
		System.out.println(msg.getContent());
		 System.out.println("Message : ");
		 

		  Multipart multipart = (Multipart) msgs[0].getContent();
		  
		  for (int x = 0; x < multipart.getCount(); x++) {
		  BodyPart bodyPart = multipart.getBodyPart(x);

		  String disposition = bodyPart.getDisposition();

		  if (disposition != null && (disposition.equals(BodyPart.ATTACHMENT))) {
		  System.out.println("Mail have some attachment : ");

		  DataHandler handler = bodyPart.getDataHandler();
		  System.out.println("file name : " + handler.getName());
		  } else {
		  System.out.println(bodyPart.getContent());
		  }
		  
		  	System.out.println();
		  }
		
		
//		}
		
		
		emailfolder.close();
		store.close();
		
	}catch(Exception e) {
		System.out.println(e);	
		
			}
}
	public static void main(String[] args) throws MessagingException, IOException {
		String host = "pop.gmail.com";
		String user = "neovaqa.madhura@gmail.com";
		String password = "neova123";
		String Storetype = "pop3";
		
		check(host, Storetype, user, password);
				
	}

}
