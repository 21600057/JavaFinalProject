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
	String path;
	boolean help;
	
	public static void main(String[] args) 
	{ 
		try
		{
			if(args.length<2 || args.length >=3)
			 throw new NotEnoughArgumentException(); // argument가 부족할시 throw해줌
			
		} catch (NotEnoughArgumentException e)
		{
			System.out.println(e.getMessage());
			System.exit(0);
		}
		
		Options options = createOptions();
		
		if(parseOptions(options, args))
		{
			if (help)
			{
				printHelp(options);
				return;
			}
		}
//		ZipReader zipReader = new ZipReader();
//		zipReader.run(args);
	}
	
	public boolean parseOptions(Options options, String[] args) 
	{
		CommandLineParser parser = new DefaultParser();

		try 
		{

			CommandLine cmd = parser.parse(options, args);

			path = cmd.getOptionValue("p");
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
		options.addOption(Option.builder("p").longOpt("path")
				.desc("Set a path of a directory or a file to display")
				.hasArg()
				.argName("Path name to display")
				.required()
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
 