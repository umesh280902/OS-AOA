import java.util.*;

class FIFO{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter length of reference string");
		int n = sc.nextInt();
		
		int ref[] = new int[n];

		System.out.println("Enter the reference string");
		
		for(int i=0; i<n; i++){
			ref[i] = sc.nextInt();
		}
		
		System.out.println("Enter the number of frames");
		int frames = sc.nextInt();
		
		int frame[] = new int[frames];
		int faults = 0;
		boolean flag = false;
		
		for(int i=0; i<frames; i++){
			frame[i] = -1;
		}
		
		System.out.println("The FIFO Page Replacement Policy is");
		System.out.println();
		
		for(int i=0; i<n; i++){
			int curr = ref[i];
			flag = false;
			
			for(int j=0; j<frames; j++){
				if(frame[j] == curr){
					flag = true;
					break;
				}
			}
			
			if(flag != true){
				int mod = faults%frames;
				frame[mod] = curr;
				faults++;
			}
			
			for(int j=0; j<frames; j++){
				System.out.print(frame[j] + "\t\t");
			}
			if(flag != true){
				System.out.print("Fault No " + faults);
			}
			
			System.out.println();
		}
		
		System.out.println();
		System.out.println("Page Fault Ratio is " + (float) faults/n);
		System.out.println("Page Hit Ratio is " + (float) (n-faults)/n);
	}
}