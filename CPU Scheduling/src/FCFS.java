import java.util.*;

public class FCFS {
	
	//calculate waiting time for each process
	static void WaitingTime(int p[],int n,int b[],int w[])
	{
		w[0]=0; //No waiting for first process
		
		for(int i=1;i<n;i++) //waiting starts from second process
		{
			w[i]=b[i-1]+w[i-1]; //burst of last process + waiting of last process
		}
	}
	
	//calculate turn around time for each process
	static void TurnaroundTime(int p[],int n,int b[],int w[],int t[])
	{
		for(int i=0;i<n;i++)
		{
			t[i]=w[i]+b[i]; //waiting of current process + burst of current process
		}
	}
	
	//print each process' waiting and turn around time
	//calculate average then print it
	static void Average(int p[],int n , int b[])
	{
		int w[] = new int[n];
		int t[]=new int[n];
		int total_waiting=0;
		int total_turnaround=0;
		
		WaitingTime(p,n,b,w); //call 
		
		TurnaroundTime(p,n,b,w,t); //call
		
		//print each process with its waiting time and turn around time 
		for(int i=0;i<n;i++)
		{
			System.out.println("Process"+" " + (p[i]) + ": " + b[i]);
			System.out.println("waitng time"+" " + (p[i]) + ": " + (w[i]));
			System.out.println("turnaround time"+" " + (p[i]) + ": " + (t[i]) );
			
		}
		
		//calculate total waiting and turn around time
		for(int i=0;i<n;i++)
		{
			total_waiting+=w[i];
			total_turnaround+=t[i];
		}
		
		//calculate average waiting and turn around time 
		float avg_waitng = (float)total_waiting/(float)n; 
		float avg_turnaround =(float)total_turnaround/(float)n;
		
		//print average waiting and turn around time 
		System.out.print("Average Waitng Time: ");
		System.out.println(avg_waitng);
		System.out.print("Average Turnaround Time: ");
		System.out.println(avg_turnaround);
		
		
		
		
	}

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		//enter number of process
		System.out.println("Enter size:");
		int n=input.nextInt();
		input.close();	
		
		//processes indexes 
		int p[]= new int[n];
		for(int i=0;i<n;i++)
		{
			p[i]=i+1;
				
		}
		
		

		
		//random burst time
		//int b[]= {24,3,3};
		
		
		int b[]=new int[n];
		Random r= new Random(); 
		for(int i=0;i<n;i++)
		{
			int rand=r.nextInt(50);
			b[i]=rand;	
		}
		
		
		Average(p,n,b);
		
		

		
		
		
		
		
	

	}

}
