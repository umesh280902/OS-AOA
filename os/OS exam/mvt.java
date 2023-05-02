// Importing required packages
import java.util.ArrayList;
import java.util.Scanner;
// Function to print the contents of the main memory
    public class mvt {
        static Scanner sc = new Scanner(System.in);
    public static void print(ArrayList<ArrayList<Integer>> mm, int memsize, int total) {
System.out.println("\n\tMAIN MEMORY");
System.out.println("\t-----------------");
// Iterating through each block in the main memory
for (int i = 0; i < mm.size(); i++) {
// If the block is empty
if (mm.get(i).get(1) == -1) {
System.out.println("Block " + i + "\t|\t\t| " + mm.get(i).get(0) + " MB");
}
// If the block is allocated to a process
else {
System.out.println("Block " + i + "\t|\tP" + mm.get(i).get(1) + "\t| " + mm.get(i).get(0) + " MB");
}
System.out.println("\t-----------------");
}
System.out.println("Block n\t|\t\t| " + (memsize - total) + " MB");
System.out.println("\t-----------------");
}

// Function to allocate memory to processes using MVT technique
public static void MVT(int memsize) {
    int t, external_fragment = 0, total = 0;
    ArrayList<ArrayList<Integer>> mm = new ArrayList<ArrayList<Integer>>();
    System.out.print("Enter the number of processes you want to enter: ");
    t = sc.nextInt();
    // Allocating memory to each process in the main memory
    while (t-- > 0) {
        int p, id;
        System.out.print("\nEnter the process id and size: ");
        id = sc.nextInt();
        p = sc.nextInt();
        total += p;
        if (total > memsize) {
            System.out.println("\nMemory is full....\n");
            break;
        } else {
            mm.add(new ArrayList<Integer>());
            mm.get(mm.size()-1).add(p);
            mm.get(mm.size()-1).add(id);
            print(mm, memsize, total);
        }
    }
    // Swapping memory blocks to allocate to new processes
    System.out.print("Enter the number of processes you want to swap: ");
    t = sc.nextInt();
    while(t-- > 0) {
        int id, count = -1;
        System.out.print("\nEnter the process id: ");
        id = sc.nextInt();
        // Searching for the process in the main memory
        for (int i = 0; i < mm.size(); i++) {
            if (mm.get(i).get(1) == id) {
                count = i;
                break;
            }
        }
        if (count == -1) {
            System.out.println("Process not found.....");
        } else {
            external_fragment += mm.get(count).get(0);
            mm.get(count).set(1, -1);
            print(mm, memsize, total);
        }
    }
    System.out.println("\nTotal External fragmentation: " + external_fragment + " MB");
}

// Main function to execute the program
public static void main(String[] args) {
    int memsize;
    System.out.print("Enter the total size of main memory (MB): ");
    memsize = sc.nextInt();
    MVT(memsize);
}
}
    

