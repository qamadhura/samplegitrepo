package Scripts;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class CsvDemo {
	
	public static void ReadCsv() {
		try {
			CsvReader reader = new CsvReader("D:\\Java_Test\\SeleniumDemo\\Files\\csvdemo.csv");
			
			reader.readHeaders();
			while(reader.readRecord()) {
				String productID = reader.get("id");
				String productName = reader.get("name");
				
				
				System.out.println(productID+":"+productName);
				
			}
			reader.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void WriteCsv() {
		String outputFile = "D:\\Java_Test\\SeleniumDemo\\Files\\csvdemo.csv";
		
		boolean alreadyExist = new File(outputFile).exists();
				
				try {
					CsvWriter writer = new CsvWriter(new FileWriter(outputFile,true),',');
					if(!alreadyExist) {
						
						writer.write("id");
						writer.write("name");
						writer.endRecord();
						
					}
					writer.write("1");
					writer.write("abc");
					writer.endRecord();
					
					writer.write("2");
					writer.write("mno");
					writer.endRecord();
					
					writer.close();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
	}
	public static void main(String[] args) {
		//WriteCsv();
		ReadCsv();
	}

}
