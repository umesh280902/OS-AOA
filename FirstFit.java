import java.util.*;

class FirstFit{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of blocks: ");
		int blocks = sc.nextInt();
		
		System.out.println("Enter the number of processes: ");
		int processes = sc.nextInt();
		
		int block[] = new int[blocks];
		int process[] = new int[processes];
		int allocated[] = new int[processes];
		
		System.out.println("Enter the size of blocks");
		
		for(int i=0; i<blocks; i++){
			block[i] = sc.nextInt();
		}
		
		System.out.println("Enter the size of processes");
		
		for(int i=0; i<processes; i++){
			process[i] = sc.nextInt();
		}
		
		for(int i=0; i<processes; i++){
			for(int j=0; j<blocks; j++){
				if(block[j] >= process[i]){
					allocated[i] = j+1;
					block[j] -= process[i];
					break;
				}
			}
		}
		
		System.out.println("Process No\t\tProcess Size\t\tBlock No");
		
		for(int i=0; i<processes; i++){
			if(allocated[i] == 0){
				System.out.println(i+1 + "\t\t\t" + process[i] + "\t\t\tNot Allocated");
			}
			else{
				System.out.println(i+1 + "\t\t\t" + process[i] + "\t\t\t" + allocated[i]);
			}
		}
	}
}