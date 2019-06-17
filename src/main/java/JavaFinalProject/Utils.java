package JavaFinalProject;

import java.util.ArrayList;
import java.io.*;

public class Utils
{
	public void writeAFile(ArrayList<String> lines, String targetFileName)
	{
		PrintWriter fileOut = null;
		
		try
		{
			fileOut = new PrintWriter(targetFileName);
		} catch (FileNotFoundException e)
		{
			System.out.println("Error opening the file" + targetFileName);
			System.exit(0);
		}
		for (int i=0; i<lines.size(); i++)
		{
			fileOut.println(lines.get(i));
		}
		fileOut.close();
	}
}