package Scripts;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

public class MsgSendDemo {

	public static void main(String[] args) {
		 Properties props = new Properties();
		  props.put("mail.store.protocol", "pop3");
		    props.put("mail.pop3.host", "pop.gmail.com");
		    props.put("mail.pop3.port", "995");
		    props.put("mail.from", "neovaqa.madhura@gmail.com");
		    Session session = Session.getDefaultInstance(props);

		    try {
		        MimeMessage msg = new MimeMessage(session);
		        msg.setFrom();
		        msg.setRecipients(Message.RecipientType.TO,
		                          "qsuryawanshi@gmail.com");
		        msg.setSubject("JavaMail hello world example");
		        msg.setSentDate(new Date());
		        msg.setText("Hello, world!\n");
		        Transport.send(msg);
		    } catch (MessagingException mex) {
		        System.out.println("send failed, exception: " + mex);
		    }

	}

}
