package JavaFinalProject;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.ArrayList;
import JavaFinalProject.Utils;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import java.io.File;

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
		System.out.println("함수부");
		System.out.println("path1 = " + path1 + " path2 = " + path2 + " argck = " + argck);
		try
		{
			if(argck == false)
			 throw new NotEnoughArgumentException(); // inputPath 와 outputPath를 설정해주지 않았다면, error message 출력 
			
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
		    //Library lib = new Library();
		    
		    while(entries.hasMoreElements())
		    {
		    	ZipArchiveEntry entry = entries.nextElement();
		    	
		    	InputStream stream = zipFile.getInputStream(entry);
		    	temp.addAll(myReader.getData(stream));
		    }

		    ut.writeAFile(temp, path2);
	        
		} catch (IOException e) 
		{
			// TODO Auto-generated catch block
			System.out.println("There is no input Path!");
			e.printStackTrace();
		} catch (NullPointerException e)
		{
			System.out.println("There is NullPointerException Error!");
			e.printStackTrace();
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
