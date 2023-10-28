package seleniumPrograms;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileReading {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
			
			//Set File path to read the Excel file content 
			String filepath = System.getProperty("user.dir")+"\\TestData\\Login_Data.xlsx";
			FileInputStream fis = new FileInputStream(filepath);
			
			//To retrieve the Users sheet from the excel file
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			int sheetsCount = workbook.getNumberOfSheets();
			XSSFSheet sheet=workbook.getSheetAt(0);
			
			for(int i=0;i<sheetsCount; i++)
			{
				String name = workbook.getSheetName(i);
				if(name.equalsIgnoreCase("Users"))
				{
					sheet=workbook.getSheetAt(i);
				}
			}
			
			
			HashMap<String, String> credentails = new HashMap<String,String>();
			
			//To find out the Username column number
			Iterator<Row> rows = sheet.iterator();
			Row FirstRow = rows.next();
			Iterator<Cell> cols = FirstRow.cellIterator();
			int k=0,column=0;
			
			while(cols.hasNext())
			{
				String value = cols.next().getStringCellValue();
				
				if(value.equalsIgnoreCase("UserName"))
				{
					column=k;
				}
					k++;
			}
			
			
		while(rows.hasNext())
		{
			Row r = rows.next();
			String key = r.getCell(column).getStringCellValue();
			String value = r.getCell(column+1).getStringCellValue();
			credentails.putIfAbsent(key, value);
		}
		

		for(Entry<String,String> e: credentails.entrySet())
		{
			System.out.println(e.getKey()+" "+e.getValue());
		}
			
			
	}

}
