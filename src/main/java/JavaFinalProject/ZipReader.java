package JavaFinalProject;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.ArrayList;
import JavaFinalProject.Utils;

import java.io.FileNotFoundException;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipFile;

public class ZipReader extends Thread
{
	static String path1, path2;
	static boolean argck;

	public void readFileInZip(String path1, String path2, boolean argck) 
	{
		this.path1 = path1;
		this.path2 = path2;
		this.argck = argck;
	}
	
	public void run()
	{
		try
		{
			if(argck == false)
			 throw new NotEnoughArgumentException(); 
			
		} catch (NotEnoughArgumentException e)
		{
			System.out.println(e.getMessage());
			System.exit(0);
		}
		
		ZipFile zipFile;
		
		try 
		{
			Utils ut = new Utils(); 
			zipFile = new ZipFile(path1);
			Enumeration<? extends ZipArchiveEntry> entries = zipFile.getEntries();
	        
	        ArrayList<String> temp = new ArrayList<String>();
		    ExcelReader myReader = new ExcelReader();
		    
		    while(entries.hasMoreElements())
		    {
		    	ZipArchiveEntry entry = entries.nextElement();
		    	InputStream stream = zipFile.getInputStream(entry);
		    	temp.addAll(myReader.getData(stream));
		    }
		    ut.writeAFile(temp, path2);
	        
		} catch (IOException e)
		{
			e.printStackTrace();
		} catch (NullPointerException e)
		{
			System.out.println("There is NullPointerException Error!");
			e.printStackTrace();
			
			PrintWriter fileOut = null;
			try
			{
				fileOut = new PrintWriter("error.csv");
			} catch (FileNotFoundException w)
			{
				System.out.println("Error opening the file");
				System.exit(0);
			}
				fileOut.println(path1);
			
			fileOut.close();
		}
	}
	
	public int getID()
	{
		int id; 
		String convertId;
		convertId = path1.substring(0,4);
		id = Integer.parseInt(convertId);
		return id;
	}
}
