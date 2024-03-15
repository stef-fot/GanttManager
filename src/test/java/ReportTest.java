import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

import backend.MainEngine;
import backend.ReportType;
import exporter.Report;

public class ReportTest {

	@Test
	public void createReportHd() 
	{
		MainEngine e = new MainEngine();
		e.load("./src/main/resources/input/Eggs.tsv","\t");
		int i=e.createReport("./src/test/resources/output/Eggs.tsv", ReportType.TEXT);
		int j=e.createReport("./src/test/resources/output/Eggs.html", ReportType.HTML);
		int v=e.createReport("./src/test/resources/output/Eggs.md", ReportType.MD);
		
		
	
		
		assertTrue(i==14);
		assertTrue(j==14);
		assertTrue(v==14);
	}
	
	@Test
	public void taskListEmptyOnReportConstructor() throws IOException

	{
		ArrayList<String[]> empty = new ArrayList<String[]>();
		Report r = new Report("./src/test/resources/output/Eggs.tsv", ReportType.TEXT,empty);
		int i=r.createReport();
		
		
		assertTrue(i==-1);
		
	}
	
	
	@Test
	public void nullEnumerator() throws IOException
	{
		ArrayList<String[]> doesnt_matter = new ArrayList<String[]>();
		String[] s= {"aaaa","bbb","ccccc"};
		doesnt_matter.add(s);
		Report r = new Report("./src/test/resources/output/Eggs.tsv", null,doesnt_matter);
		int i=r.createReport();
		assertTrue(i==-1);
	}
	
	
	
	@Test(expected=NullPointerException.class)
	public void outputPathNotFound() throws IOException
	{
		ArrayList<String[]> doesnt_matter = new ArrayList<String[]>();
		String[] s= {"aaaa","bbb","ccccc"};
		doesnt_matter.add(s);
		Report r = new Report("./srZ/testZ/resourZes/outputZ/EggZ.tsv", ReportType.TEXT,doesnt_matter);
		int i=r.createReport();
		assertTrue(i==-1);
	}
}
