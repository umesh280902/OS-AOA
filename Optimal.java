import java.util.*;

class Optimal{
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
		boolean flag = false, fault = false;
		
		for(int i=0; i<frames; i++){
			frame[i] = -1;
		}
		
		System.out.println("The Optimal Page Replacement Policy is");
		System.out.println();
		
		for(int i=0; i<n; i++){
			flag = false;
			fault = false;
			for(int j=0; j<frames; j++){
				if(frame[j] == ref[i]){
					flag = true;
					break;
				}
				
				if(frame[j] == -1){
					frame[j] = ref[i];
					flag = true;
					fault = true;
					faults++;
					break;
				}
			}
			
			if(flag != true){				
				int max = Integer.MIN_VALUE, maxi = 0;
				HashMap <Integer, Integer> map = new HashMap <> ();
				
				for(int j=0; j<frames; j++){
					for(int k=i+1; k<n; k++){
						if(!map.containsKey(ref[k]))
							map.put(ref[k], k);
					}
				}
				
				for(int j=0; j<frames; j++){
					if(map.containsKey(frame[j])){
						if(map.get(frame[j]) > max){
							max = map.get(frame[j]);
							maxi = j;
						}
					}
					else{
						maxi = j;
						break;
					}
				}
				
				frame[maxi%frames] = ref[i];
				faults++;
				fault = true;
			}
			
			for(int j=0; j<frames; j++){
				System.out.print(frame[j] + "\t\t");
			}
			if(fault == true){
				System.out.print("Fault No " + faults);
			}
			
			System.out.println();
		}
		
		System.out.println();
		System.out.println("Page Fault Ratio is " + (float) faults/n);
		System.out.println("Page Hit Ratio is " + (float) (n-faults)/n);
	}
}