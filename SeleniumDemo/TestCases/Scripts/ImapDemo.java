package Scripts;

import java.util.Properties;
import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Store;

public class ImapDemo {

	public static void main(String[] args) {
		try {
		Properties props = new Properties();
		
		props.setProperty("mail.host", "imap.gmail.com");
		props.setProperty("mail.port", "995");
		props.setProperty("mail.transport.protocol", "imaps");
		
		Session session = Session.getInstance(props);
		
		Store store = session.getStore("imaps");
		
		store.connect("neovaqa.madhura@gmail.com", "neova123");
		
		Folder folder = store.getFolder("INBOX");
		folder.open(Folder.READ_ONLY);
		
		Message[] msgs = folder.getMessages();
		
		for(int i =0; i<msgs.length;i++) {
			Message msg = msgs[i];
			
			//Address from[] = msg.getFrom();
		//	System.out.println("FROM:"+from[0]);
		//	System.out.println("SUBJECT:"+msg.getSubject());
		//	System.out.println("TO:"+msg.getAllRecipients()[0]);
			
		//	String replyto = InternetAddress.toString(msg.getReplyTo());
		//	System.out.println("REPLY TO:"+replyto);
			Object content  = msg.getContent();
			Multipart multipart = (Multipart) content;
			BodyPart bodypart = multipart.getBodyPart(0);
//			int cnt = bodypart.getLineCount();
//			System.out.println(cnt);
			Object o;
		
			o = bodypart.getContent();
		String line="";
//		
//			
	 line = (String) o;
	/* if (line.contains("Username:")) {
		 int i1 = line.indexOf("Password:");
		 i1 = line.indexOf(" ", i1) + 1;
	//	 System.out.println(i1);
		 int j = line.indexOf("\n", line.indexOf("Password:")) - 1;
		 String spassword = line.substring(i1, j);
		 System.out.println(spassword);
		 }*/
	 
	 if(line.contains("Auto-login link")) {
		 int i1=line.indexOf("Auto-login link:");
		// System.out.println(i1);
		 i1=line.indexOf(" ", i1) + 8;
		 int j = line.indexOf("This link ",line.indexOf("Auto-login link"))-1;
		 String slink =line.substring(i1, j);
		 System.out.print(slink);
	 }
	 
//	 System.out.println(line);
	 
	
	//	 System.out.println("y");
	//	 System.out.println(line.charAt(0));
//		 int i1 = line.indexOf("Password:");
////		 System.out.println(i1+2);
//		 for(int a=0;a<27;a++) {
//			 System.out.println(a);
////		 System.out.print(line.charAt(i1+a));
//	 }
	
	//	System.out.println(line);
			
//		 BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//			for(int i1=0; i1<cnt; i1++) {
//			    while ((line = reader.readLine()) != null) {
//			        if(line.equals("Password"));{
//			        	System.out.println(line);
//			        }
//			        
//			    }
//		
//		}	
			  //  String messageBody = .getContent().toString();
			
//			Object content = msg.getContent();
//			System.out.println(content.toString());
//			if(content instanceof String) {
//				System.out.println(content);
//				}
//			else if(content instanceof Multipart) {
//				Multipart multipart = (Multipart) content;
//				processMultipart(multipart);
//				}
//			else if(content instanceof InputStream){
//				InputStream input = (InputStream) content;
//				int ch;
//				while((ch=input.read())!=-1) {
//					System.out.println(ch);
//				}
//			}
		folder.close();
		store.close();
			
		
		}			
		
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}		
}				
		



