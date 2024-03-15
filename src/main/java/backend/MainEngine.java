package backend;

import dom2app.SimpleTableModel;
import FileProcessor.FileLoader;
import parser.*;
import exporter.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;


public class MainEngine implements IMainController 
{
	
	private ArrayList<String[]> all_tasks= new ArrayList<String[]>();
	private final String[] pcolNames = {"TaskId","TaskText","MamaId","Start","End","Cost"};
	private TaskOrganiser to;
	private TaskComputer tc;
	private String fileName;

	@Override
	public SimpleTableModel load(String fileName, String delimiter) 
	{
		this.fileName=fileName;
		ArrayList<String[]> tasks=new ArrayList<String[]>();
		FileLoader f= new FileLoader(fileName,delimiter);
		
		try
		{
			tasks = f.load();
		} 
		catch (FileNotFoundException e) 
		{
			
			e.printStackTrace();
		}
		
		 to = new TaskOrganiser(tasks);
		
		all_tasks = to.sort();
		
	
		return new SimpleTableModel(fileName,"GanttManager",pcolNames,all_tasks);
	}

	
	@Override
	public SimpleTableModel getTasksByPrefix(String prefix) 
	{
		TaskComputer tc = new TaskComputer(all_tasks);
		ArrayList<String[]> prefixTasks = tc.prefixSearch(prefix);
		
		
		return new SimpleTableModel(fileName,"GanttManager",pcolNames,prefixTasks);
	}

	@Override
	public SimpleTableModel getTaskById(int id) 
	{
		 tc = new TaskComputer(all_tasks);
		ArrayList<String[]> idTasks = tc.taskIdSearch(id);
		
		
		return new SimpleTableModel(fileName,"GanttManager",pcolNames,idTasks);
	}

	@Override
	public SimpleTableModel getTopLevelTasks() 
	{
		tc = new TaskComputer(all_tasks);
		ArrayList<String[]> topLevelTasks = tc.getTopLevel();
		
		
		return new SimpleTableModel(fileName,"GanttManager",pcolNames,topLevelTasks);
	}

	@Override
	public int createReport(String path, ReportType type) 
	{
		
		Report r = new Report(path,type,all_tasks);
		try
		{
			return r.createReport();
		} 
		catch (IOException e) 
		{
			
			e.printStackTrace();
		}
		
		return -1;
	}
	
	
	

}
