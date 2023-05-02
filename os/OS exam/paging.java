// Importing required libraries
import java.util.*;

public class paging {
    static Scanner sc = new Scanner(System.in);
public static void main(String[] args) {

// Accepting input from the user
System.out.print("Enter the process size(KB):");
int prosize = sc.nextInt();
System.out.print("Enter the page size(B):");
int pagesize = sc.nextInt();
System.out.print("Enter the physical size(KB):");
int physize = sc.nextInt();

// Calculating the number of pages, bits required for page number and page size
int pageno = (prosize * 1024) / pagesize;
int pageno_bit = (int) Math.floor(Math.log(pageno) / Math.log(2)) + 1;
int pagesize_bit = (int) Math.floor(Math.log(pagesize) / Math.log(2)) + 1;

// Calculating the number of bits required for physical memory size and logical address
int physize_bit = (int) Math.floor(Math.log(physize * 1024) / Math.log(2)) + 1;
int logic_bit = pageno_bit + pagesize_bit;
int frameno_bit = physize_bit - pagesize_bit;

// Displaying the calculated values
System.out.println("\nTotal no of frames:" + Math.pow(2, frameno_bit));
System.out.println("Total no of enteries:" + pageno);
System.out.println("Number of bits physical address:" + physize_bit);
System.out.println("Number of bits in logical address:" + logic_bit);

// Accepting input for page table
int filled;
System.out.print("Enter the no. of enteries:");
filled = sc.nextInt();
int[][] page_table = new int[pageno][2];
for (int i = 0; i < pageno; i++) {
  page_table[i][0] = -1;
  page_table[i][1] = 0;
}
for (int i = 0; i < filled; i++) {
  int pno;
  System.out.print("Enter the page no.:");
  pno = sc.nextInt();
  System.out.print("Enter the frame on:");
  page_table[pno][0] = sc.nextInt();
  System.out.print("page is avilable or not in MM:");
  page_table[pno][1] = sc.nextInt();
}

// Accepting input for logical address and checking for page hit or page fault
System.out.print("Enter the logical address:");
String s = sc.next();
int pno = Integer.parseInt(s.substring(0, pageno_bit));
if (page_table[pno][1] == 1) {
  System.out.println("Pagr Hit....");
  System.out.println("Page is present in frame no:" + page_table[pno][0]);
} else {
  System.out.println("Page Fault...");
}
}
}





