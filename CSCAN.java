import java.util.*;

class CSCAN{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of requests");
		int n = sc.nextInt();
		
		System.out.println("Enter the maximum number of tracks");
		int max = sc.nextInt();
		
		int req[] = new int[n];
		int seq[] = new int[n+2];
		int total = 0, k = 0, i = 0;
		
		System.out.println("Enter the request queue");
		
		for(i=0; i<n; i++){
			req[i] = sc.nextInt();
		}
		
		System.out.println("Enter the initial head position");
		int head = sc.nextInt();
		
		System.out.println("Enter the direction (left/right)");
		String direction = sc.next();
		
		Arrays.sort(req);
		
		System.out.println("Seek Sequence is");
		
		if(direction.equals("left")){
			int min = Integer.MAX_VALUE, mini = 0;
			
			for(i=0; i<n; i++){
				if(req[i] <= head){
					int curr = head - req[i];
					
					if(curr <= min){
						min = curr;
						mini = i;
					}
				}
			}
			
			for(int j = mini; j >= 0; j--){
				seq[k++] = req[j];
				total += Math.abs(head - req[j]);
				head = req[j];
			}
			
			seq[k++] = 0;
			total += Math.abs(head - 0);
			head = 0;
			
			seq[k++] = max;
			total += Math.abs(head - max);
			head = max;
			
			for(int j = n-1; j > mini; j--){
				seq[k++] = req[j];
				total += Math.abs(head - req[j]);
				head = req[j];
			}
		}
		else{
			for(i=0; i<n; i++){
				if(req[i] >= head){
					for(int j = i; j < n; j++){
						seq[k++] = req[j];
						total += Math.abs(head - req[j]);
						head = req[j];
					}
					break;
				}
			}
			
			seq[k++] = max;
			total += Math.abs(head - max);
			head = max;
			
			seq[k++] = 0;
			total += Math.abs(head - 0);
			head = 0;
			
			for(int j = 0; j < i; j++){
				seq[k++] = req[j];
				total += Math.abs(head - req[j]);
				head = req[j];
			}
			
		}			
		
		for(i=0; i<n+2; i++){
			System.out.print(seq[i] + " ");
		}
			
		System.out.println();
		System.out.println("Total head movement is " + total);
	}
}