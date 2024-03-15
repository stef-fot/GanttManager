package parser;

import java.util.ArrayList;


public class TaskOrganiser {
	
	private ArrayList<String[]> list = new ArrayList<String[]>();

	
	
	public TaskOrganiser(ArrayList<String[]> l)
	{
		list=l;
	}
	
	
	public ArrayList<String[]> sort()
	{	
		ArrayList<String[]> topTaskList = new ArrayList<String[]>();
		ArrayList<ArrayList<String[]>> subtask = new ArrayList<ArrayList<String[]>>();
		
		
		//sort by taskId		
		for(int i=0;i<list.size();i++)
		{
					
			for(int j=i+1;j<list.size();j++)
			{
							
				if(Integer.valueOf(list.get(i)[0])>Integer.valueOf(list.get(j)[0]))
				{
							
					String s[] = list.get(j);
					list.set(j,list.get(i));
					list.set(i,s);							
				}
											
			}
		}
		
		//add topTasks to topTaskList
		for(int i=0;i<list.size();i++)
		{
			
			if(Integer.valueOf(list.get(i)[2])==0)
			{
				
				
				
				if(list.get(i).length>3)
				{
					
					topTaskList.add(list.get(i));
				}else 
				{
					
					String[] tp = new String[6];
					tp[0]=list.get(i)[0];
					tp[1]=list.get(i)[1];
					tp[2]=list.get(i)[2];
					tp[3]="";
					tp[4]="";
					tp[5]="";
					topTaskList.add(tp);
				}
			}
			
			
		}
		
		
		
		
		
		
		
		
		
		
	
		
		
		
		//add subtasks to subtask list.
		//all subtasks of the TopTask will be retrieved with the same index
		//as the index of topTask in the topTask list.
		int v=0;
		int start=Integer.MAX_VALUE;
		int end=0;
		double cost=0;
	
		
		ArrayList<String[]> tst = new ArrayList<String[]>();
		for(int q=0;q<list.size();q++)
		{
			
			
			if(Integer.valueOf(list.get(q)[2])==0 && topTaskList.get(v)[3]!="")
			{
				
				subtask.add(null);
				
				v++;
			}
			else
			{
			
				if(Integer.valueOf(list.get(q)[2])!=0)
				{
					
					cost+=Double.valueOf(list.get(q)[5]);
					
					if(Integer.valueOf(list.get(q)[3])<start)
					{
						start=Integer.valueOf(list.get(q)[3]);
					}
					if(Integer.valueOf(list.get(q)[4])>end)
					{
						end=Integer.valueOf(list.get(q)[4]);
					}
					String[] st=list.get(q);
					
					tst.add(st);
				}
				else if(Integer.valueOf(list.get(q)[2])==0 && q!=0)
				{
					
					subtask.add(tst);
					tst=new ArrayList<String[]>();
					
					
					topTaskList.get(v)[3]=String.valueOf(start);
					topTaskList.get(v)[4]=String.valueOf(end);
					topTaskList.get(v)[5]=String.valueOf((double)cost);
					
					
					start=Integer.MAX_VALUE;
					end=0;
					cost=0;
					v++;
				 }
				if(q==list.size()-1)
				 {
					
					subtask.add(tst);
					tst=new ArrayList<String[]>();
						
					topTaskList.get(v)[3]=String.valueOf(start);
					topTaskList.get(v)[4]=String.valueOf(end);
					topTaskList.get(v)[5]=String.valueOf((double)cost);
						
						
					start=Integer.MAX_VALUE;
					end=0;
					cost=0;
					v++;
				  }
							
			}
												
		}
		
		
		
	
		
		
		
		
		
		
		
		//topTask sort by start element
		for(int i=0;i<topTaskList.size();i++)
		{
			for(int j=i+1;j<topTaskList.size();j++)
			{
				if(Integer.valueOf(topTaskList.get(i)[3])>Integer.valueOf(topTaskList.get(j)[3]))
				{
					String[] t = topTaskList.get(j);
					topTaskList.set(j,topTaskList.get(i));
					topTaskList.set(i,t);
					
					
					ArrayList<String[]> temp1 = subtask.get(i);
					ArrayList<String[]> temp2 = subtask.get(j);
					subtask.set(i, temp2);
					subtask.set(j, temp1);
				}								
			}
		}
		
		
		
		
		//subtask sort by start element
		for(int i=0;i<subtask.size();i++)
		{
			ArrayList<String[]> temp= subtask.get(i);
			if(temp!=null)
			{
				for(int j=0;j<temp.size();j++)
				{
					for(int b=j+1;b<temp.size();b++)
					{
						if(Integer.valueOf(temp.get(j)[3])>Integer.valueOf(temp.get(b)[3]))
						{
							String[] t= temp.get(b);
							temp.set(b, temp.get(j));
							temp.set(j, t);
						}
					}
				}
			}
			subtask.set(i, temp);
		}
		
		
	
		
		ArrayList<String[]> f_list = new ArrayList<String[]>();
		
		for(int i=0;i<topTaskList.size();i++)
		{
			f_list.add(topTaskList.get(i));
			f_list.get(i)[5]=String.valueOf(Double.valueOf(f_list.get(i)[5]));
			ArrayList<String[]> temp = subtask.get(i);
			if(temp!=null)
			{
				for(int j=0;j<temp.size();j++)
				{
					temp.get(j)[5]=String.valueOf(Double.valueOf(temp.get(j)[5]));
					
					f_list.add(temp.get(j));
					
					
				}
			}
		}
		
		
		
		
		
		
		return f_list;
		
	}
	
	
		
}
