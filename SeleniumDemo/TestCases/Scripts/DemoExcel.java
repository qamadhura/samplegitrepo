package Scripts;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DemoExcel 
{
	public void readExcel() throws IOException{

		String FilePath = "D:\\Java_Test\\SeleniumDemo\\Files\\Demo.xlsx"; 
		
	    //Create an object of FileInputStream class to read excel file

	    FileInputStream fi = new FileInputStream(FilePath);
	    
	    //If it is xls file then create object of HSSFWorkbook class

	    Workbook wb =  new XSSFWorkbook(fi);
	
	    //Read sheet inside the workbook by its name

	    Sheet sh = wb.getSheet("Sheet1");

	    //Find number of rows in excel file

	    int rowCount=  sh.getLastRowNum()-sh.getFirstRowNum();
	   
	    System.out.println("Row count is : "+rowCount);
	    //Create a loop over all the rows of excel file to read it

	    for (int i = 0; i < rowCount+1; i++) 
	    {
	        Row row = sh.getRow(i);
	        
	        //Create a loop to print cell values in a row
	       
	        for (int j = 0; j < row.getLastCellNum(); j++) 
	        {	
	            System.out.print(row.getCell(j).getStringCellValue()+"  ");				//Print Excel data in console
	        }
	        System.out.println();
	    }
	    }
	
	public void writeExcel() throws IOException
	{
			String[] value = {"Parmeshwar","Nanded"};
		
			String FilePath = "D:\\Java_Test\\SeleniumDemo\\Files\\Demo.xlsx"; 			//filepath	
			
			FileInputStream fi = new FileInputStream(FilePath);		//fileinputstream		
			
			Workbook wb = new XSSFWorkbook(fi);					//specifying type of worksheet 
			
			Sheet sh = wb.getSheet("Sheet1");				//Name of Sheet
			
			int rowCount = sh.getLastRowNum()-sh.getFirstRowNum();
			System.out.println(rowCount);
			
			Row row = sh.getRow(0);						//will come at first row in the sheet
			
			Row newRow = sh.createRow(rowCount+1);				// will create a new row and add at the last position
			
			for (int j=0; j<row.getLastCellNum();j++)
			{
				Cell cell = newRow.createCell(j);
				
				cell.setCellValue(value[j]);
				
				FileOutputStream fo = new FileOutputStream(FilePath); 			//create object for writing data in excel file;
				
				wb.write(fo);													//write data in excel file
			}
			
	}
	
	    public static void main(String args[]) throws IOException
	    {
	    	DemoExcel objExcelFile = new DemoExcel();
	
	    	objExcelFile.readExcel();
	    	objExcelFile.writeExcel();
	    	objExcelFile.readExcel();
	    }

	}
