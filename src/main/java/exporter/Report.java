package exporter;


import backend.ReportType;
import java.io.IOException;
import java.io.FileWriter;
import java.util.ArrayList;
public class Report {
	
	private ReportType e;
	private ArrayList<String[]> list;
	private FileWriter myw;
	public Report(String path,ReportType e,ArrayList<String[]> list)
	{
		this.e=e;
		
		this.list=list;
		 try {
			myw = new FileWriter(path);
		} catch (IOException e1) {
			
			System.out.println("path invalid");
		}
	}
	
	
	public int createReport() throws IOException
	{
		if(e== ReportType.TEXT)
		{
			return textReport();
			
		}else if(e==ReportType.HTML)
		{
			return htmlReport();
		}else if(e==ReportType.MD)
		{
			return mdReport();
		}
		return -1;
	}
	
	
	
	private int textReport() throws IOException 
	{
		if(list.isEmpty()) {return -1;}
		int tasks=0;
		
		
		String temp="";
		
		temp+="TaskId"+"\t"+"TaskText"+"\t"+"MamaId"+"\t"+"Start"+"\t"+"End"+"\t"+"Cost"+"\n";
		for(int i=0;i<list.size();i++)
		{
			for(int j=0;j<list.get(i).length;j++)
			{
				temp+=list.get(i)[j]+"\t";
				
			}
			tasks++;
			temp+="\n";
		}
		
		myw.write(temp);
		myw.close();
		return tasks;
		
		
		
	}
	
	
	private int htmlReport() throws IOException 
	{
		if(list.isEmpty()) {return -1;}
		int tasks=0;
		String temp="";
		temp+="<table>";
		temp+="<tr>";
		temp+="<td>TaskId</td>"+"\t"+"<td>TaskText</td>"+"\t"+"<td>MamaId</td>"+"\t"+"<td>Start</td>"+"\t"+"<td>End</td>"+"\t"+"<td>Cost</td>";
		temp+="</tr>";
		
		
		for(int i=0;i<list.size();i++)
		{
			temp+="<tr>";
			for(int j=0;j<list.get(i).length;j++)
			{
				temp+="<td>"+list.get(i)[j]+"</td>";
				
			}
			tasks++;
			temp+="</tr>";
		}
		
		temp+="</table>";
		myw.write(temp);
		myw.close();
		return tasks;
		
	}
	
	private int mdReport() throws IOException 
	{
		if(list.isEmpty()) {return -1;}
		int tasks=0;
		String temp="";
		
		temp+="*TaskId*"+"\t"+"*TaskText*"+"\t"+"*MamaId*"+"\t"+"*Start*"+"\t"+"*End*"+"\t"+"*Cost*"+"\n";
		
		
		for(int i=0;i<list.size();i++)
		{
			for(int j=0;j<list.get(i).length;j++)
			{
				if(Integer.valueOf(list.get(i)[2])==0)
				{
					temp+="**"+list.get(i)[j]+"**"+"\t";
					
				}else 
				{
					temp+=list.get(i)[j]+"\t";
					
				}
				
			}
			tasks++;
			temp+="\n";
		}
		myw.write(temp);
		myw.close();
		
		return tasks;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	

}
