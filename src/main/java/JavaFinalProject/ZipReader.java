package JavaFinalProject;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import java.io.File;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipFile;


public class ZipReader 
{
	String path1, path2;

	public void readFileInZip(String path1, String path2, boolean argck) 
	{
		System.out.println("함수부");
		try
		{
			if(argck == false)
			 throw new NotEnoughArgumentException(); // argument가 부족할시 throw해줌
			
		} catch (NotEnoughArgumentException e)
		{
			System.out.println(e.getMessage());
			System.exit(0);
		}
		
		ZipFile zipFile;
		try 
		{
			zipFile = new ZipFile(path1);
			Enumeration<? extends ZipArchiveEntry> entries = zipFile.getEntries();

		    while(entries.hasMoreElements())
		    {
		    	ZipArchiveEntry entry = entries.nextElement();
		        InputStream stream = zipFile.getInputStream(entry);
		    
		        ExcelReader myReader = new ExcelReader();
		        
		        for(String value:myReader.getData(stream)) 
		        {
		        	System.out.println(value);
		        }
		    }
		} catch (IOException e) 
		{
			// TODO Auto-generated catch block
			System.out.println("There is no input Path!");
			e.printStackTrace();
		}
	}
}
