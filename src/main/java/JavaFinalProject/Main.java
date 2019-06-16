package JavaFinalProject;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipFile;

public class Main 
{
	String path1, path2; // 읽을 파일 경로와 써질 파일.
	
	public static void main(String[] args) 
	{ 

		Main main = new Main();
		main.run(args);
	}
	
	public void run(String[] args)
	{
		path1 = args[0];
		path2 = args[1];
		
		System.out.println("path1 = " + path1);
	}
	
	
	
}
 