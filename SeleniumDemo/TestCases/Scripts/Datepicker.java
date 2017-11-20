package Scripts;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.text.DateFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Datepicker {

	public void withDefaultvalue(WebDriver driver) {
		try {
		
		driver.findElement(By.xpath("//*[@name='start']")).click();
		String defaultvalue = driver.findElement(By.xpath("//*[@name='start']")).getAttribute("value");
		DateFormat d = new SimpleDateFormat("yyyy-MM-dd"); 
		Date stDate;
		stDate = d.parse(defaultvalue);
		String smonth = new SimpleDateFormat("MM").format(stDate);
		
		System.out.println(smonth);
		
		Calendar calendar = Calendar.getInstance();
		Date today = calendar.getTime();
		calendar.add(Calendar.DAY_OF_YEAR, -1);
		Date previousdate = calendar.getTime();

		String scurrentMonth = new SimpleDateFormat("MM").format(previousdate);
		System.out.println(scurrentMonth);
		String l = new SimpleDateFormat("MMMM d, yyyy").format(previousdate);
		System.out.println(l);
		if(smonth.equals(scurrentMonth)) {
			Thread.sleep(4000);
			driver.findElement(By.xpath("//span[contains(@class,'flatpickr-day ')][@aria-label='"+l+"']")).click();
			
		}
		else {
			Thread.sleep(4000);
			driver.findElement(By.xpath("//*[@class='flatpickr-next-month']")).click();
			Thread.sleep(4000);
			driver.findElement(By.xpath("//span[contains(@class,'flatpickr-day ')][@aria-label='"+l+"']")).click();

		}
		}catch(Exception e) {
			System.out.println("Exception in defaultvalue:"+e.getMessage());
		}
		
	}
	
	public void withoutDefaultValue(WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath("//*[@id='start_date']")).click();
//	
		Calendar calendar = Calendar.getInstance();
		Date today = calendar.getTime();
		calendar.add(Calendar.DAY_OF_YEAR, 30);
		Date sDate = calendar.getTime();
		String l = new SimpleDateFormat("MMMM d, yyyy").format(sDate);
		try {
			
			driver.findElement(By.xpath("//span[contains(@class,'flatpickr-day ')][@aria-label='"+l+"']")).click();
														
			} catch (Exception e) {
				System.out.println("Element not found" + e.getMessage());
				driver.findElement(By.xpath("//*[@class='flatpickr-next-month']")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//span[contains(@class,'flatpickr-day ')][@aria-label='"+l+"']")).click();
						} 
		
		
	}
	
	public void fromTo(WebDriver driver, String fromDate, String toDate){
		try {
		driver.findElement(By.xpath("//*[@id='from_date']")).click();
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.JULY,0);
		String current =driver.findElement(By.xpath("//span[@class='flatpickr-day today']")).getAttribute("aria-label");
		DateFormat d = new SimpleDateFormat("MMMM d,yyyy");
		
			Date cdate = d.parse(current);
			int smonth =Integer.parseInt( new SimpleDateFormat("MM").format(cdate));
			
			Date from = d.parse(fromDate);
			Date to = d.parse(toDate);
			
			while(smonth!=7){
				driver.findElement(By.xpath("//*[@class='flatpickr-prev-month']")).click();
				smonth--;
			}
			
			driver.findElement(By.xpath("//span[contains(@class,'flatpickr-day ')][@aria-label='"+l+"']")).click();
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
