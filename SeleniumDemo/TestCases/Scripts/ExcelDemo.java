package Scripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDemo {
	Workbook wb = null;
	public void ReadFromSheet(String filepath, String sheetname, String filename) {
		try {
		File file = new File(filepath+"\\"+filename);
		FileInputStream is = new FileInputStream(file);
		String fileextensionname = filename.substring(filename.indexOf("."));
		//System.out.println(fileextensionname);
		if(fileextensionname.equals(".xlsx"))
		{
			wb = new XSSFWorkbook(is);
		
		}
		else if(fileextensionname.equals(".xls")) {
			wb = new HSSFWorkbook(is);
		}
		
		Sheet sheet = wb.getSheet(sheetname);
	//	System.out.println(sheet.getRow(0).toString());
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		System.out.println(rowCount);
		
		
		System.out.println("First row:"+ sheet.getRow(0).toString());
		for(int i=0; i<rowCount+1; i++) {
			Row row = sheet.getRow(i) ;
			Cell k = row.getCell(0);
			
			for(int j=0; j<row.getLastCellNum();j++) {
				System.out.print(row.getCell(j).getStringCellValue()+"||");
			}
			
			System.out.println();
	//		System.out.println("Firct cell of each row:"+k);
		}
		
			
			
		
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void WriteToSheet(String filepath, String sheetname, String filename,  String[] valueToWrite) {
		try {
		File file = new File(filepath+"\\"+filename);
		FileInputStream fis = new FileInputStream(file);
		String fileextensionname = filename.substring(filename.indexOf("."));
		
		if(fileextensionname.equals(".xlsx"))
		{
			wb = new XSSFWorkbook(fis);
		
		}
		else if(fileextensionname.equals(".xls")) {
			wb = new HSSFWorkbook(fis);
		}
		
		Sheet sheet = wb.getSheet(sheetname);
		
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		
		Row row = sheet.getRow(0);
		
		Row newRow = sheet.createRow(rowCount+1);
		
		for(int i=0;i<row.getLastCellNum();++i) {
			Cell cell = newRow.createCell(i);
			
			cell.setCellValue(valueToWrite[i]);
			
		}
		fis.close();
		FileOutputStream fout = new FileOutputStream(file);
		wb.write(fout);
		fout.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		
		
	}
	public static void main(String[] args) {
		 String[] valueToWrite = {" ","123"};
		 File file = new File("D:\\Java_Test\\SeleniumDemo\\Files");
		 file.mkdir();

		ExcelDemo ed = new ExcelDemo();
		ed.ReadFromSheet("D:\\Java_Test\\SeleniumDemo\\Files", "sheet1", "Demo.xlsx");
		ed.WriteToSheet("D:\\Java_Test\\SeleniumDemo\\Files", "sheet1", "Demo.xlsx", valueToWrite);
		//ed.ReadFromSheet("D:\\Java_Test\\SeleniumDemo\\Files", "sheet1", "Demo.xlsx");

	}

}
