package Logics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileReading
{
	private String src = System.getenv("AppData")+"\\SimulationEngine\\";
	private String name = "save.txt";
	private ArrayList<String> file = new ArrayList<String>();

	public FileReading()
	{
		read();
	}

	private void read()
	{
		try
		{
			String sCurrentLine;

			BufferedReader br = new BufferedReader(new FileReader(src+name));

			while ((sCurrentLine = br.readLine()) != null)
			{
				file.add(sCurrentLine);
			}

		} catch (IOException e)
		{
			File f = new File(src);
			if(!f.exists())
			{
				f.mkdir();
				read();
			}else
			{
				f = new File(src + name);
				try
				{
					f.createNewFile();

					read();
				} catch (IOException e1){}
			}
		}
	}
}
