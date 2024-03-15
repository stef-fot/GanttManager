import static org.junit.Assert.*;

import org.junit.Test;

import FileProcessor.FileLoader;
import parser.TaskOrganiser;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class FileProcessorTest {

	



	@Test
	public void loadFileHd_getTasksHd() throws FileNotFoundException 
	{
		
		FileLoader f = new FileLoader("./src/main/resources/input/Eggs.tsv","\t");
		ArrayList<String[]> l=f.load();
		
		
		
		
		assertTrue(!l.isEmpty());
		
		
		TaskOrganiser to = new TaskOrganiser(l);
		ArrayList<String[]> tasks_final =to.sort();
		
		List<String[]> expectedList= new ArrayList<String[]>();
		String[] s1= {"100","Prepare Fry","0","1","12","60.0"};
		String[] s2= {"101","Turn on burner (low)","100","1","1","10.0"};
		String[] s3= {"102","Break eggs and pour into fry","100","2","4","10.0"};
		String[] s4= {"103","Steer mixture to avoid sticking","100","5","10","10.0"};
		String[] s5= {"105","Salt, pepper","100","5","5","10.0"};	
		String[] s6= {"104","Throw yellow cheese into fry","100","6","12","10.0"};
		String[] s7= {"106","Turn burner off","100","12","12","10.0"};
		String[] s8= {"200","Prepare the bread","0","10","12","20.0"};
		String[] s9= {"201","Heat bread in toaster","200","10","12","10.0"};
		String[] s10= {"202","Little bit of salt, galric spice to bread","200","12","12","10.0"};
		String[] s11= {"300","Serve eggs","0","13","20","30.0"};
		String[] s12= {"301","Put bread in plate","300","13","13","10.0"};
		String[] s13= {"302","Put eggs on bread","300","14","14","10.0"};
		String[] s14= {"303","Wash fry","300","15","20","10.0"};
		
		expectedList.add(s1);expectedList.add(s2);expectedList.add(s3);
		expectedList.add(s4);expectedList.add(s5);expectedList.add(s6);
		expectedList.add(s7);expectedList.add(s8);expectedList.add(s9);
		expectedList.add(s10);expectedList.add(s11);expectedList.add(s12);
		expectedList.add(s13);expectedList.add(s14);
		
		
		for(int i=0;i<tasks_final.size();i++)
		{
			
			assertArrayEquals(expectedList.get(i),tasks_final.get(i));
		}
		
		
		
	}
	
	
	
	@Test(expected = FileNotFoundException.class)
	public void loadFileRandomPath () throws FileNotFoundException 
	{
		FileLoader f = new FileLoader("./src/main/resources/input/Oggs.tsv","\t");
		f.load();
		
	}
	
	
	


}
