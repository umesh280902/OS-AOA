import java.util.*;

class Bankers{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of processes");
		int n = sc.nextInt();
		
		System.out.println("Enter the number of resources");
		int res = sc.nextInt();
		
		int allocated[][] = new int[n][res];
		int max[][] = new int[n][res];
		int need[][] = new int[n][res]; 
		int avail[] = new int[res];
		int safeSequence[] = new int[n];
		
		System.out.println("Enter the max resources required by each process");
		
		for(int i=0; i<n; i++){
			for(int j=0; j<res; j++){
				max[i][j] = sc.nextInt();
			}
		}
		
		System.out.println("Enter the number of resouces allocated to each process");
		
		for(int i=0; i<n; i++){
			for(int j=0; j<res; j++){
				allocated[i][j] = sc.nextInt();
			}
		}
		
		System.out.println("Enter the number of resources available");
		
		for(int i=0; i<res; i++){
			avail[i] = sc.nextInt();
		}
		
		for(int i=0; i<n; i++){
			for(int j=0; j<res; j++){
				need[i][j] = max[i][j] - allocated[i][j];
			}
		}
		
		boolean flag[] = new boolean[n];
		int count = 0, index = 0;
		
		while(count != n){
			for(int i=0; i<n; i++){
				if(flag[i] == false){
					int curr = 0;
					for(int j=0; j<res; j++){
						if(need[i][j] <= avail[j]){
							curr++;
						}
						else{
							break;
						}
					}
					if(curr == res){
						count++;
						flag[i] = true;
						for(int j=0; j<res; j++){
							avail[j] += allocated[i][j];
						}
						safeSequence[index++] = i;
					}
				}
			}
		}
		
		System.out.println("The Safe Sequence is");
		
		for(int i=0; i<n; i++){
			System.out.print("P" + safeSequence[i] + " ");
		}
	}
}