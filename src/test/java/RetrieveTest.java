import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;


import org.junit.Test;

import FileProcessor.FileLoader;

import parser.TaskComputer;
import parser.TaskOrganiser;

public class RetrieveTest {

	@Test
	public void getTopLevelHd() throws FileNotFoundException 
	{
		
		FileLoader f = new FileLoader("./src/main/resources/input/Eggs.tsv","\t");
		ArrayList<String[]> tasks = f.load();
		TaskOrganiser to = new TaskOrganiser(tasks);
		ArrayList<String[]> tasks_sorted=to.sort();
		TaskComputer tc = new TaskComputer(tasks_sorted);
		ArrayList<String[]> actual=tc.getTopLevel();
		
		
		ArrayList<String[]> expected=new ArrayList<String[]>();
		
		String[] s1= {"100","Prepare Fry","0","1","12","60.0"};
		String[] s2= {"200","Prepare the bread","0","10","12","20.0"};
		String[] s3= {"300","Serve eggs","0","13","20","30.0"};
		
		expected.add(s1);expected.add(s2);expected.add(s3);
		for(int i=0;i<actual.size();i++)
		{
			
			assertArrayEquals(expected.get(i),actual.get(i));
		}
	}
	
	
	
	
	@Test
	public void getTaskByIdHd() throws FileNotFoundException
	{
		FileLoader f = new FileLoader("./src/main/resources/input/Eggs.tsv","\t");
		ArrayList<String[]> tasks = f.load();
		TaskOrganiser to = new TaskOrganiser(tasks);
		ArrayList<String[]> tasks_sorted=to.sort();
		TaskComputer tc = new TaskComputer(tasks_sorted);
		ArrayList<String[]> actual=tc.taskIdSearch(100);
		
		
		ArrayList<String[]> expected=new ArrayList<String[]>();
		
		String[] s1= {"100","Prepare Fry","0","1","12","60.0"};
		
		
		expected.add(s1);
		for(int i=0;i<actual.size();i++)
		{
			
			assertArrayEquals(expected.get(i),actual.get(i));
		}
		
	}
	
	
	@Test
	public void getTaskByPrefixHd() throws FileNotFoundException
	{
		FileLoader f = new FileLoader("./src/main/resources/input/Eggs.tsv","\t");
		ArrayList<String[]> tasks = f.load();
		TaskOrganiser to = new TaskOrganiser(tasks);
		ArrayList<String[]> tasks_sorted=to.sort();
		TaskComputer tc = new TaskComputer(tasks_sorted);
		ArrayList<String[]> actual=tc.prefixSearch("P");
		
		
		ArrayList<String[]> expected=new ArrayList<String[]>();
		
		String[] s1= {"100","Prepare Fry","0","1","12","60.0"};
		String[] s2= {"200","Prepare the bread","0","10","12","20.0"};
		String[] s3= {"301","Put bread in plate","300","13","13","10.0"};
		String[] s4= {"302","Put eggs on bread","300","14","14","10.0"};
		
		
		expected.add(s1);expected.add(s2);expected.add(s3);expected.add(s4);
		for(int i=0;i<actual.size();i++)
		{
			
			assertArrayEquals(expected.get(i),actual.get(i));
		}
	}
	
	@Test
	public void invalidTaskId() throws FileNotFoundException
	{
		FileLoader f = new FileLoader("./src/main/resources/input/Eggs.tsv","\t");
		ArrayList<String[]> tasks = f.load();
		TaskOrganiser to = new TaskOrganiser(tasks);
		ArrayList<String[]> tasks_sorted=to.sort();
		TaskComputer tc = new TaskComputer(tasks_sorted);
		ArrayList<String[]> actual=tc.taskIdSearch(500);
		
		assertTrue(actual.isEmpty());
	}
	
	@Test
	public void invalidPre() throws FileNotFoundException 
	{
		FileLoader f = new FileLoader("./src/main/resources/input/Eggs.tsv","\t");
		ArrayList<String[]> tasks = f.load();
		TaskOrganiser to = new TaskOrganiser(tasks);
		ArrayList<String[]> tasks_sorted=to.sort();
		TaskComputer tc = new TaskComputer(tasks_sorted);
		ArrayList<String[]> actual=tc.prefixSearch("Popozo");
		
		assertTrue(actual.isEmpty());
	}
}
