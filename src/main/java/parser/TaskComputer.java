package parser;

import java.util.ArrayList;
public class TaskComputer {
	
	private ArrayList<String[]> tasks;
	
	
	
	public TaskComputer(ArrayList<String[]> tasks)
	{
		this.tasks=tasks;
		
	}
	
	
	
	public ArrayList<String[]> prefixSearch(String prefix)
	{
		
		ArrayList<String[]> prefixTasks=new ArrayList<String[]>();
		for(int i=0;i<tasks.size();i++)
		{
			if(tasks.get(i)[1].startsWith(prefix))
			{
				prefixTasks.add(tasks.get(i));
			}
		}
		
		return prefixTasks;
	}
	
	
	public ArrayList<String[]> taskIdSearch(int taskId)
	{
		ArrayList<String[]> taskIdTasks=new ArrayList<String[]>();
		for(int i=0;i<tasks.size();i++)
		{
			if(Integer.valueOf(tasks.get(i)[0])==taskId)
			{
				taskIdTasks.add(tasks.get(i));
			}
		}
		
		return taskIdTasks;
	}
	
	
	public ArrayList<String[]> getTopLevel()
	{
		
		ArrayList<String[]> topLevelTasks = new ArrayList<String[]>();
		for(int i=0;i<tasks.size();i++)
		{
			if(Integer.valueOf(tasks.get(i)[2])==0)
			{
				topLevelTasks.add(tasks.get(i));
			}
		}
		
		return topLevelTasks;
	}
	
	
}
