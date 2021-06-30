import java.util.Scanner;

//import java.util.*;

public class RR {
	

    
    static void WaitingTime(int p[], int n, int bt[], int wt[], int q) 
    { 

    	
        int rem_bt[] = new int[n]; //To store remaining burst time
        
        for (int i = 0 ; i < n ; i++) 
        {
            rem_bt[i] =  bt[i]; //initially copy all burst time on it
        }
        
        int end = 0; //end time of processes , initially equal zero
       
      
        while(true) 
        { 
            boolean done = true;  //initially 
       
          //traverse all processes
            for (int i = 0 ; i < n; i++) 
            { 
            	//need to process further
                if (rem_bt[i] > 0) //not equal zero
                { 
                    done = false; //there is a pending processes
                    
                  //if the process still have cycles to add q (take one cycle now)
                    if (rem_bt[i] > q) 
                    { 
                       
                        end += q; //increase the end of current process with q
       
                
                        rem_bt[i] -= q; //decrease remaining burst time of current process
                    } 
       
                  //last cycle of a process
                    else
                    { 
                       
                        end+= rem_bt[i]; //increase the end of current process with the remaining burst time
       
                      
                        wt[i] = end - bt[i]; //waiting time =end time of process - burst time 
       
                 
                        rem_bt[i] = 0; //the end of this process
                    } 
                } 
            } 
       
            
            if (done == true) //all processes are done (break from while)
              break; 
        } 
    } 
       

    static void TurnAroundTime(int p[], int n,int bt[], int wt[], int tat[]) 
    { 
        
        for (int i = 0; i < n ; i++) 
        {
         tat[i] = bt[i] + wt[i]; //Turn around time = burst time + waiting time
        }
    } 
       
    
    static void Average(int processes[], int n, int bt[], int q) 
    { 
    	//waiting time
        int wt[] = new int[n];

        //Turn around time
        int tat[] = new int[n]; 
        
        int total_waiting = 0;
        int total_turnaround = 0; 
       
      
        WaitingTime(processes, n, bt, wt, q); //call
        TurnAroundTime(processes, n, bt, wt, tat); //call
       
        // Display processes along with all details 
        System.out.println("Processes " + " Burst time " + 
                      " Waiting time " + " Turn around time"); 
       
        
        // Calculate and display total waiting time and total turn around time
        for (int i=0; i<n; i++) 
        { 
        	total_waiting+=wt[i]; 
            total_turnaround+=  tat[i]; 
            System.out.println(" " + (i+1) + "\t\t" + bt[i] +"\t " + 
                              wt[i] +"\t\t " + tat[i]); 
        } 
        
        
        	//calculate average waiting and turn around time 
      		float avg_waitng = (float)total_waiting/(float)n; 
      		float avg_turnaround =(float)total_turnaround/(float)n;
       
    		//display average waiting and turn around time 
            System.out.println("Average waiting time = " + (avg_waitng)); 
            System.out.println("Average turn around time = " + (avg_turnaround));
    } 
      
  
    public static void main(String[] args) 
    { 
    	 /*
        int p[] = { 1, 2, 3}; 
        int n = p.length;
        int bt[] = {24, 3, 3}; 
        int q = 4;
        */
       
    	Scanner input = new Scanner(System.in);
		System.out.println("enter number of process");
		System.out.print("Enter size:");
		int n=input.nextInt();
		input.close();
		int bt[] = new int[n];
		int p[] = new int[n];
		int q=4;
		for(int i=0;i<n;i++)
		{
			//random burst time from 1 to 20
			//(int)(Math.random() * (max - min + 1) + min);
			int rand1=(int)(Math.random() * (20 - 1 + 1) + 1);
			bt[i]=rand1;
			
			//process index
			p[i] = i+1;	
		}
		
        
        
       Average(p, n, bt, q); 
    } 
} 
