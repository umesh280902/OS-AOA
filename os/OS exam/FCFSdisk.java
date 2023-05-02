import java.util.Scanner;

public class FCFSdisk {
    static Scanner sc=new Scanner(System.in);
    public static void main(String args[]){
        int head,n;
        System.out.println("enter the number of request processes:");
        n=sc.nextInt();
        System.out.print("enter head position :");
        head=sc.nextInt();
        System.out.println("enter the track of positions");
        int[] req=new int[n];
        for(int i=0;i<n;i++){
            req[i]=sc.nextInt();
        }
        int seek=0;
        System.out.println("FCFS Policy");
        for(int i=0;i<n;i++){
            System.out.println("STEP "+(i+1)+":"+req[i]);
            seek+=Math.abs(head-req[i]);
            head=req[i];
        }
        System.out.println("Total Seek Time:"+seek);
    }
    
}
