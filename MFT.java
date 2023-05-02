import java.util.*;

class MFT{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the memory available (in Bytes)");
		int total = sc.nextInt();
		
		System.out.println("Enter the size of the block");
		int size = sc.nextInt();
		
		int blocks = total/size;
		int extFrag = total - (blocks*size);
		
		System.out.println("Enter the number of processes");
		int n = sc.nextInt();
		
		int processSize[] = new int[n];
		int index = 0, intFrag = 0, i = 0, p = 0;
		
		for(i=0; i<n; i++){
			System.out.println("Enter the size of process " + (index+1));
			processSize[i] = sc.nextInt();
		}
		
		System.out.println("\nNo of blocks available in memory are " + blocks);
		
		System.out.println("\n\nProcess\tMemory Required\t Allocated\tInternal Fragmentation");
		
		for(i=0; i<n && p<blocks; i++){
			System.out.print("\n" + (i+1) + "\t\t" + processSize[i]);
			
			if(processSize[i] > size){
				System.out.print("\t\tNO\t\t---");
			}
			else{
				System.out.print("\t\tYES\t" + (size-processSize[i]));
				intFrag = intFrag + size-processSize[i];
				p++;
			}
		}
		if(i<n){
			System.out.println("\nMemory is Full, Remaining Processes cannot be accomodated");
		}
		
		System.out.println("\n\nTotal Internal Fragmentation is " + intFrag);
		System.out.println("\nTotal External Fragmentation is " + extFrag);
	}
}