import java.util.*;

class FCFS{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
			
		System.out.println("Enter the number of proccesses: ");
		int n = sc.nextInt();
		
		int burstTime[] = new int[n];
		int waitingTime[] = new int[n];
		int turnaroundTime[] = new int[n];
		double avgWaiting = 0, avgTurnaround = 0;
		
		System.out.println("Enter the burst time of all the proccesses");
		
		for(int i=0; i<n; i++){
			burstTime[i] = sc.nextInt();
		}
		
		waitingTime[0] = 0;
		
		for(int i=1; i<n; i++){
			waitingTime[i] = burstTime[i-1] + waitingTime[i-1];
			avgWaiting += waitingTime[i];
		}
		
		for(int i=0; i<n; i++){
			turnaroundTime[i] = burstTime[i] + waitingTime[i];
			avgTurnaround += turnaroundTime[i];
		}
		
		System.out.println("Proccess\tWaiting Time\tTurnround Time");
		
		for(int i=0; i<n; i++){
			System.out.println(i+1 + "\t\t" + waitingTime[i] + "\t\t" + turnaroundTime[i]);
		}
		
		System.out.println();
		
		System.out.println("The Average Waiting Time of all the processes is " + String.format("%.4f", avgWaiting/n));
		System.out.println("The Average Turnaround Time of all the processes is " + String.format("%.4f", avgTurnaround/n));
	}
}