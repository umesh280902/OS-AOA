import java.util.*;

class LOOK{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of requests");
		int n = sc.nextInt();
		
		int req[] = new int[n];
		int seq[] = new int[n];
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
			
			for(int j = mini + 1; j < n; j++){
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
			
			for(int j = i - 1; j >= 0; j--){
				seq[k++] = req[j];
				total += Math.abs(head - req[j]);
				head = req[j];
			}
			
		}			
		
		for(i=0; i<n; i++){
			System.out.print(seq[i] + " ");
		}
			
		System.out.println();
		System.out.println("Total head movement is " + total);
	}
}