import java.util.*;

class Priority{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of proccesses: ");
		int n = sc.nextInt();
		
		int burstTime[] = new int[n];
		int priority[] = new int[n];
		int waitingTime[] = new int[n];
		int turnaroundTime[] = new int[n];
		boolean flag[] = new boolean[n];
		double avgWaiting = 0, avgTurnaround = 0;
		int wait = 0;
		
		System.out.println("Enter the burst time of all the proccesses");
		
		for(int i=0; i<n; i++){
			burstTime[i] = sc.nextInt();
		}
		
		System.out.println("Enter the priority of all the proccesses");
		
		for(int i=0; i<n; i++){
			priority[i] = sc.nextInt();
		}
		
		for(int i=0; i<n; i++){
			int ind = 0, shortest = Integer.MAX_VALUE;
			for(int j=0; j<n; j++){
				if(priority[j] < shortest && flag[j] == false){
					shortest = priority[j];
					ind = j;
				}
			}
			flag[ind] = true;
			waitingTime[ind] = wait;
			wait += burstTime[ind];
			turnaroundTime[ind] = wait;
		}
		
		for(int i=0; i<n; i++){
			avgWaiting += waitingTime[i];
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