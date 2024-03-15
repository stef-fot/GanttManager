package FileProcessor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class FileLoader {
	
	
	
	private String path;
	private String del;
	private Scanner inputst;
	
	
	
	
	public FileLoader(String path,String del)
	{
		this.path=path;
		this.del=del;
	}
	
	
	public ArrayList<String[]> load() throws FileNotFoundException
	{
		
		ArrayList<String[]> tasks = new ArrayList<String[]>();
		
		
			File f = new File(path);
			
			inputst= new Scanner(f);			
			while(inputst.hasNext())
			{
				String[] p =inputst.nextLine().split(del);
				
				tasks.add(p);
				
			}
		
		
		
		
	
		
		
		
		return tasks;
	}
}

