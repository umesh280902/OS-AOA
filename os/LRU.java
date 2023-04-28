import java.util.*;

public class LRU {
	
	public static void display(ArrayList<Integer> arr, int n){
        for(int i : arr){
		    System.out.print(i+" ");
		}
    }
    
	public static void main(String[] args) {
		//int capacity = 3;
		//int arr[] = {7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2};
		//int arr[] = {1,2,3,4,5};
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of pages");
		int n = sc.nextInt();
		System.out.println("\nNow enter the pages");
		int arr[] = new int[n];
		for(int i = 0; i<n; i++){
		    arr[i] = sc.nextInt();
		}
		System.out.println("\nNow enter capacity");
		int capacity = sc.nextInt();
		
		
		ArrayList<Integer> s=new ArrayList<>(capacity);
		int count=0;
		int pagehits = 0;
		int page_faults=0;
		System.out.println("\nBelow is the array status");
		for(int i:arr)
		{
			if(!s.contains(i))
			{		
				
				if(s.size()==capacity)
				{
					s.remove(0);
					s.add(capacity-1,i);
				}
				else
					s.add(count,i);
					page_faults++;
					++count;
			
				}
			else
			{
				s.remove((Object)i);
				s.add(s.size(),i);	
				pagehits++;	
				System.out.println("Page hit!");
			}
			display(s, s.size());			
			System.out.println();

		}
		System.out.println("No. of page faults: "+page_faults);
		System.out.println("No. of page hits: "+pagehits);
	}
}


