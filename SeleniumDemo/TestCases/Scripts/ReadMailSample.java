package Scripts;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Flags.Flag;
import javax.mail.search.FlagTerm;


public class ReadMailSample {
Properties properties = null;
private Session session = null;
private Store store = null;
private Folder inbox = null;
private String userName = "neovaqa.madhura@gmail.com";// provide user name
private String password = "neova123";// provide password


public void readMails() {
properties = new Properties();
properties.setProperty("mail.host", "imap.gmail.com");
properties.setProperty("mail.port", "995");
properties.setProperty("mail.transport.protocol", "imaps");
session = Session.getInstance(properties,
new javax.mail.Authenticator() {
protected PasswordAuthentication getPasswordAuthentication() {
return new PasswordAuthentication(userName, password);
}
});

try {
store = session.getStore("imaps");
store.connect();
inbox = store.getFolder("INBOX");
inbox.open(Folder.READ_ONLY);
Message messages[] = inbox.search(new FlagTerm(
new Flags(Flag.SEEN), false));

System.out.println("Number of mails = " + messages.length);
for (int i = 0; i < messages.length; i++) {
	Message message = messages[i];
	Address[] from = message.getFrom();
	Address[] replyto = message.getReplyTo();
System.out.println("-------------------------------");
System.out.println("Date : " + message.getSentDate());
System.out.println("From : " + from[0]); 
System.out.println("Subject: " + message.getSubject());
System.out.println();
System.out.println("Content :");

System.out.println("--------------------------------"); 
}
inbox.close(true); 
store.close(); 
} 
catch (NoSuchProviderException e) { e.printStackTrace(); }
catch (MessagingException e) { e.printStackTrace(); } 
}



}