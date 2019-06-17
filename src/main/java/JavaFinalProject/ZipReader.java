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
	
	public void run(String[] args)
	{
		path1 = args[0];
		path2 = args[1];
	}

	public void readFileInZip(String path) 
	{
		System.out.println("여기는 함수부");
		/*
		ZipFile zipFile;
		try 
		{
			zipFile = new ZipFile(path);
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
			e.printStackTrace();
		}*/
	}
}
