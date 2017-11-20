package Scripts;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class timeex {

	public static void main(String[] args) {
		String dates = "December 12, 2017";
		DateFormat df = new SimpleDateFormat("MMMM dd, yyyy"); 
		Date startDate;
		
		try {
		    startDate = df.parse(dates);
		   String s = new SimpleDateFormat("yyyy-MM-dd").format(startDate);
		} catch (ParseException e) {
		    e.printStackTrace();
		}
	}

}
