package Scripts;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class sdf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Calendar calendar = Calendar.getInstance();
//		Date today = calendar.getTime();
//		calendar.add(Calendar.DAY_OF_YEAR, -1);
//		Date tomorrow = calendar.getTime();
//		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		String tomorrowAsString = dateFormat.format(tomorrow);
		Calendar calendar = Calendar.getInstance();
		Date today = calendar.getTime();
		calendar.add(Calendar.DAY_OF_YEAR, -6);
		Date tomorrow = calendar.getTime();

		String sDate = new SimpleDateFormat("MMMM dd, yyyy").format(tomorrow);
		System.out.println(sDate);

		
		
//
//		String sDateNow = new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString();
//		
//		System.out.println(sDateNow);

	}

}
