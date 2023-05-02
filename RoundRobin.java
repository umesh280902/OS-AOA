import java.util.*;

class RoundRobin{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of proccesses: ");
		int n = sc.nextInt();
		
		int burstTime[] = new int[n];
		int remTime[] = new int[n];
		int waitingTime[] = new int[n];
		int turnaroundTime[] = new int[n];
		boolean flag[] = new boolean[n];
		double avgWaiting = 0, avgTurnaround = 0;
		int time = 0, count = 0;
		
		System.out.println("Enter the burst time of all the proccesses");
		
		for(int i=0; i<n; i++){
			burstTime[i] = sc.nextInt();
			remTime[i] = burstTime[i];
		}
		
		System.out.println("Enter the time quantum: ");
		int quantum = sc.nextInt();
		
		while(count != n){
			for(int i=0; i<n; i++){
				if(flag[i] == false){
					if(remTime[i] > quantum){
						remTime[i] -= quantum;
						time += quantum;
					}
					else{
						time += remTime[i];
						turnaroundTime[i] = time;
						remTime[i] = 0;
						flag[i] = true;
						count++;
					}
				}
			}
		}
		
		for(int i=0; i<n; i++){
			waitingTime[i] = turnaroundTime[i] - burstTime[i];
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