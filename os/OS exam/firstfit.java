import java.util.Scanner;

public class firstfit {
    static int n;
    static  Scanner sc=new Scanner(System.in);
    static class information{
        int id,memory,status,process;
        information(int id,int memory,int status,int process){
            this.id=id;
            this.memory=memory;
            this.status=status;
            this.process=process;
        }
    }
    static int m;
    static information info[];
    static void print(information info[]){
        System.out.println("Sr.No\tMemory\tStatus\tProcess\n");
        for(int i=0;i<n;i++){
            System.out.println(info[i].id+"\t"+info[i].memory+"\t"+info[i].status+"\t"+info[i].process);
        }
    }
    static void firstFit(){
            System.out.println("enter the process id");
            int id=sc.nextInt();
            System.out.println("enter the process size");
            int size=sc.nextInt();
            int i;
            for(i=0;i<n;i++){
                if(size<=info[i].memory && info[i].status==1){
                    info[i].memory-=size;
                    info[i].status=0;
                    info[i].process=id;
                    break;
                }
            }
                if(i==n){
                    System.out.println("process must wait");
                }
                else{
                    print(info);
                }
            }
    public static void main(String args[]){
        System.out.println("enter the number of blocks");
        n=sc.nextInt();
        System.out.println(n);
        info=new information[n];
        for(int i=0;i<n;i++){
            System.out.println("enter the memory size:");
            info[i]=new information(i+1, sc.nextInt(), 0, 0);
            System.out.println("is free(1)/not free(0):");
            info[i].status=sc.nextInt();
            if(info[i].status==0){
                System.out.println("Allocated process id:");
                info[i].process=sc.nextInt();
            }else{
                info[i].process=-1;
            }
        }
        print(info);
        System.out.println("enter the no of waiting process:");
        m=sc.nextInt();
        for(int i=0;i<m;i++){
            firstFit();
        }

    }
}
