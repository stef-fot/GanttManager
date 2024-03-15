import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.junit.Test;
import FileProcessor.FileLoader;
import parser.TaskOrganiser;
public class SortingTest {

	@Test
	public void sortHd() throws FileNotFoundException 
	{
		
		FileLoader f = new FileLoader("./src/main/resources/input/Eggs.tsv","\t");
		ArrayList<String[]> l = f.load();
		
		TaskOrganiser t = new TaskOrganiser(l);	
		ArrayList<String[]> list=t.sort();
		
		
		
		f=new FileLoader("./src/main/resources/output/Eggs.tsv","\t");
		ArrayList<String[]> expected = f.load();
		
		
		
		
		
		//removes pColNames
		expected.remove(0);
		
		
	
		if(expected.size()==list.size())
		{
			
			for(int i=0;i<list.size();i++)
			{
				
				assertArrayEquals(expected.get(i),list.get(i));
			}
		}
	}
	
	
	
	@Test
	public void sortingTestMess() throws FileNotFoundException
	{
		//eggsScrambled exei complete random seira sta tasks
		FileLoader f = new FileLoader("./src/main/resources/input/EggsScrambled.tsv","\t");
		ArrayList<String[]> l = f.load();
		
		TaskOrganiser t = new TaskOrganiser(l);	
		ArrayList<String[]> list=t.sort();
		
		
		f=new FileLoader("./src/main/resources/output/Eggs.tsv","\t");
		ArrayList<String[]> expected = f.load();
		
		expected.remove(0);
		
		

		if(expected.size()==list.size())
		{
			
			for(int i=0;i<list.size();i++)
			{
				
				assertArrayEquals(expected.get(i),list.get(i));
			}
		}
		
		
	}
	
}
