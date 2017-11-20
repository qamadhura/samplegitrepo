package Scripts;

import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Store;

public class GmailRead {
	Folder folder = null;
	Store store = null;
	public void automatedGmail(final String USERNAME, final String PASSWORD)  {
		try {
		
		
		Properties prop = new Properties();
		prop.put("mail.store.protocol", "imaps");
		Session session = Session.getInstance(prop);
		store = session.getStore("imaps");
		store.connect("imap.gmail.com", USERNAME, PASSWORD);
		folder = store.getFolder("INBOX");
		folder.open(Folder.READ_ONLY);
		Message[] messages = folder.getMessages();
		System.out.println("no. of mails:"+folder.getMessageCount());
		System.out.println("no. of unread mails:"+ folder.getUnreadMessageCount());
		
			Message msg = messages[5];
	String strMailBody = "";
			String strSubject="";
			String sReply="";
			Object subject = msg.getSubject();
			Object content = msg.getContent();
			Object a = msg.getFolder();
			if (content instanceof Multipart)
			{
			    Multipart multipart = (Multipart) content;
			    System.out.println(multipart);
			}
			else
			{
				strMailBody =  (String) content;
				System.out.println(strMailBody);
			}
		sReply = (String) a;
			strSubject = (String) subject;
			System.out.println(strSubject);
			System.out.println(sReply);
		//	System.out.println(strMailBody);

			
		}catch(Exception e) {
			System.out.println(e);
		}
		finally {
		if(folder!=null) {
			try {
				folder.close();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(store!=null) {
			try {
				store.close();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}
		
	}
	public static void main(String[] args) {
		GmailRead gr = new GmailRead();
		gr.automatedGmail("qsuryawanshi", "madhura123");
	}

}
