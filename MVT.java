import java.util.*;

class MVT{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the memory available (in Bytes)");
		int total = sc.nextInt();
		
		ArrayList <Integer> allocated = new ArrayList <>();
		int index = 0, temp = total;
		
		while(true){
			System.out.println("\nEnter the size of process " + (index+1));
			int size = sc.nextInt();
			
			if(size <= total){
				System.out.println("Memory allocated for process " + (index+1));
				total -= size;
				allocated.add(size);
				index++;
				
				System.out.println("\nDo you want to add more processes? (y/n)");
				char c = sc.next().charAt(0);
				
				if(c == 'n'){
					break;
				}
			}
			else{
				System.out.println("Memory is Full");
				break;
			}
		}
		System.out.println("Process\t\tMemory Allocated");
		
		for(int i=0; i<index; i++){
			System.out.println(i+1 + "\t\t" + allocated.get(i));
		}		
		
		System.out.println("Total Memory Allocated is " + (temp-total));
		System.out.println("Total External Fragmentation is " + total);
	}
}