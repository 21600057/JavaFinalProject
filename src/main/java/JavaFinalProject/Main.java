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
import JavaFinalProject.NotEnoughArgumentException;

public class Main 
{
	String path1, path2;
	boolean argck=false;
	boolean help;
	
	public static void main(String[] args) 
	{
		Main finalMain = new Main();
		finalMain.run(args);
	}
	
	public void run(String[] args)
	{	
		Options options = createOptions();
		
		if(parseOptions(options, args))
		{
			if (help)
			{
				printHelp(options);
				return;
			}
			
			ZipReader readZipFile = new ZipReader();
			readZipFile.readFileInZip(path1,path2,argck);
		}
	
	}
	
	
	
	public boolean parseOptions(Options options, String[] args) 
	{
		CommandLineParser parser = new DefaultParser();

		try 
		{

			CommandLine cmd = parser.parse(options, args);
			
			path1 = cmd.getOptionValue("i");
			path2 = cmd.getOptionValue("o");
			
			if (path1 != null && path2 != null)
				argck=true;

			
			help = cmd.hasOption("h");

		} catch (Exception e) 
		{
			printHelp(options);
			return false;
		}

		return true;
	}
	
	// Definition Stage
	public Options createOptions() 
	{
		Options options = new Options();

		// add options by using OptionBuilder
		options.addOption(Option.builder("i").longOpt("inputPath")
				.desc("Set a inputPath of a directory or a file to display")
				.hasArg()
				.argName("inputPath name to display")
				.build());
		
		// add options by using OptionBuilder
				options.addOption(Option.builder("o").longOpt("outputPath")
						.desc("Set a outputPath of a directory or a file to display")
						.hasArg()
						.argName("outputPath name to display")
						.build());
			
		// add options by using OptionBuilder
		options.addOption(Option.builder("h").longOpt("help")
		        .desc("Help")
		        .build());
		 		return options;
	}
		
	public void printHelp(Options options) 
	{
		// automatically generate the help statement
		HelpFormatter formatter = new HelpFormatter();
		String header = "Helper";
		String footer ="\nPlease report issues at https://github.com/lifove/CLIExample/issues";
		formatter.printHelp("CLIExample", header, options, footer, true);
	}
		
}
 