package Scripts;

import java.util.Properties;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;

public class EmailDelete {

	public static void main(String[] args) {
		try {
			Properties props= new Properties();
			
			props.put("mail.host", "imap.gmail.com");
			props.put("mail.port", "993");
props.put("mail.transport.protocol", "imap");
			
			Session session = Session.getInstance(props);
			
			Store store = session.getStore("imaps");
			
			store.connect("neovaqa.madhura@gmail.com", "neova123");
			Folder folder = store.getFolder("Inbox");
			folder.open(Folder.READ_WRITE);
			
			Message msgs[] = folder.getMessages();
			for(int i=0;i<msgs.length;i++) {
				Message msg = msgs[i];
				msg.setFlag(Flags.Flag.DELETED, true);
			}
			System.out.println("successful");
			folder.close();

	}catch (Exception e) {
		System.out.println(e.getMessage());
	}

}
}