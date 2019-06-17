package JavaFinalProject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader 
{	
	public ArrayList<String> getData(InputStream is) 
	{
		ArrayList<String> values = new ArrayList<String>();
		
		try (InputStream inp = is) 
		{
		    
		        Workbook wb = WorkbookFactory.create(inp);
		        
		        Sheet sheet = wb.getSheetAt(0);
		        Row row;
		        Cell cell;
		        int numRow = sheet.getPhysicalNumberOfRows();
		         String temp = "";
		        
		        for (int i=0; i<numRow; i++)
		        {
		        	row = sheet.getRow(i);
		        	for (int j=0; j<row.getPhysicalNumberOfCells(); j++)
		        	{
		        		cell = row.getCell(j);
		        		switch(cell.getCellType())
		        		{
		        			case NUMERIC:
		        			 temp = temp + Double.toString((int)cell.getNumericCellValue()) + ",";
		        			 //values.add(Double.toString((int)cell.getNumericCellValue()));
		        			 break;
		        		
		        			case STRING:
		        			 if (cell.getStringCellValue().contains(","))
		        			 {
		        				 temp = temp + "\"" + cell.getStringCellValue() + "\"" + ",";
		        				 break;
		        			 }
		        			 if (cell.getStringCellValue() == null)
		        			 {
		        				 System.out.println("공백을 발견했다.");
		        				 temp = temp + ",";
		        				 break;
		        			 }
		        			 
		        			  temp = temp + cell.getStringCellValue() + ",";
		        			 
		        			 break;
		        		
		        			default:
		        			 break;
		        		}
		        	}
		        	values.add(temp);
	        		temp = "";
		        }
		        
		        
		    } catch (FileNotFoundException e) 
		{
				// TODO Auto-generated catch block
				e.printStackTrace();
		} catch (IOException e) 
		{
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		
		return values;
	}
}
