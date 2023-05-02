import java.util.*;

class SSTF{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of requests");
		int n = sc.nextInt();
		
		int req[] = new int[n];
		int seq[] = new int[n];
		int total = 0;
		
		System.out.println("Enter the request queue");
		
		for(int i=0; i<n; i++){
			req[i] = sc.nextInt();
		}
		
		System.out.println("Enter the initial head position");
		int head = sc.nextInt();
		
		Arrays.sort(req);
		
		System.out.println("Seek Sequence is");
		
		for(int i=0; i<n; i++){
			int min = Integer.MAX_VALUE, mini = 0;
			
			for(int j=0; j<n; j++){
				int curr = Math.abs(req[j] - head);
				
				if(curr < min){
					min = curr;
					mini = j;
				}
			}
			seq[i] = req[mini];
			total += Math.abs(head - req[mini]);
			head = req[mini];
			req[mini] = Integer.MAX_VALUE;
			System.out.print(seq[i] + " ");			
		}
		
		System.out.println();
		
		System.out.println("Total head movement is " + total);
	}
}