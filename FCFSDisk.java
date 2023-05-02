import java.util.*;

class FCFSDisk{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of requests");
		int n = sc.nextInt();
		
		int req[] = new int[n];
		int total = 0;
		
		System.out.println("Enter the request queue");
		
		for(int i=0; i<n; i++){
			req[i] = sc.nextInt();
		}
		
		System.out.println("Enter the initial head position");
		int head = sc.nextInt();
		
		for(int i=0; i<n; i++){
			total += Math.abs(head-req[i]);
			head = req[i];
		}
		
		System.out.println("Seek Sequence is");
		
		for(int i=0; i<n; i++){
			System.out.print(req[i] + " ");
		}
		System.out.println();
		
		System.out.println("Total head movement is " + total);
	}
}