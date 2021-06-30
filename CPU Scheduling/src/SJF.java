import java.util.*;
 
public class SJF {
	static void Average(int p[],int n,int bt[],int at[])
	{
		//completion time
		int ct[] = new int[n]; 
		//turn around time
		int tat[] = new int[n]; 
		//waiting time
		int wt[] = new int[n]; 
		//process completed or not
		int comp_or_not[] = new int[n]; 
		//start time
		int st=0; 
		
		int tot=0; //are we finished or not
		float total_waitng=0;
		float total_turnaround=0;
		
		for(int i=0;i<n;i++)
		{
			comp_or_not[i] = 0;
		}
		
		while(true)
		{
			int c=n; //knowing processing index
			int min=999; //use first time only
			
			
			if (tot == n) // total no of process = completed then we finished (break from while)
				break;
			
			//find the minimum burst time with first arrival time
			for (int i=0; i<n; i++)
			{
				//find least arrival time or first equals to zero
				//find least burst time
				//check its not completed
				if ((at[i] <= st) && (comp_or_not[i] == 0) && (bt[i]<min))
				{
					min=bt[i];
					c=i;
				}
			}
			
			//here we have the minimum burst time with first arrival time process
			
			//arrival of first process not equal zero
			if (c==n) 
				st++;
			else
			{
				//for each process
				ct[c]=st+bt[c]; //completion time =last start + burst of this process
				st+=bt[c]; // the new start for the next process
				tat[c]=ct[c]-at[c]; //turn around time = completion - arrival
				wt[c]=tat[c]-bt[c]; //waiting time= turn around - burst
				comp_or_not[c]=1; //completed 
				tot++; //increment to next process or ends for last process
			}
		}
		
		//calculate total time
		//print process information
		System.out.println("\npid  arrival brust  complete turn waiting");
		for(int i=0;i<n;i++)
		{
			total_waitng+= wt[i];
			total_turnaround+= tat[i];
			System.out.println(p[i]+"\t"+at[i]+"\t"+bt[i]+"\t"+ct[i]+"\t"+tat[i]+"\t"+wt[i]);
		}
		//calculate average
		float avg_waitng=(float)(total_waitng/n);
		float avg_turnaround=(float)(total_turnaround/n);
		System.out.println ("\naverage turnaroun time is "+ avg_turnaround);
		System.out.println ("average waiting time is "+ avg_waitng);
		
	}
	
	
	
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		//number of processes
		System.out.print("enter size:");
		int n = input.nextInt();
		
		//process indexes 
		int p[] = new int[n];
		
		//burst time
		int bt[] = new int[n]; 
		
		//arrival time
		int at[] = new int[n]; 
		
		Random r = new Random();
		for(int i=0;i<n;i++)
		{
			//random burst time from 1 to 20
			//(int)(Math.random() * (max - min + 1) + min);
			int rand1=(int)(Math.random() * (20 - 1 + 1) + 1);
			bt[i]=rand1;
			
			//random arrival time from 0 to 10
			int rand2=r.nextInt(10);
			at[i]=rand2;
			
			//process index
			p[i] = i+1;
			
		}
		
		/*
		for(int i=0;i<n;i++)
		{
			System.out.println ("enter process " + (i+1) + " arrival time:");
			at[i] = input.nextInt();
			System.out.println ("enter process " + (i+1) + " brust time:");
			bt[i] = input.nextInt();
			p[i] = i+1;
			
		}
		*/
		
		Average(p,n,bt,at);
		
		input.close();
	
}
	
		
		
	}
	
	
