import java.util.*; 

public class fcfs {
    static class process{
        int id,arrival,burst,completion;
        process(int id,int arrival, int burst){
            this.id=id;
            this.arrival=arrival;
            this.burst=burst;
        }
    }
    static process p[];
    static int n;

    static void readArray(process array[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("for arrival:");
        for(int i=0;i<n;i++){
            System.out.println("element "+(i+1)+" :");
            array[i]=new process(i+1, sc.nextInt(), 0);
         }
         System.out.println("for burst:");
         for(int i=0;i<n;i++){
            System.out.println("element "+(i+1)+" :");
            array[i].burst=sc.nextInt();    
        }
        sc.close();
    }
    static void sort(process array[]){
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(array[i].arrival>array[j].arrival){
                    process temp=array[i];
                    array[i]=array[j];
                    array[j]=temp;
                }
            }
        }
    }
    static void firstComeFirstServe(process array[]){
        sort(array);
        float turn=0;
        float wait=0;
        int time=0;
        for(int i=0;i<n;i++){
            array[i].completion=time+array[i].burst;
            time=array[i].completion;
        }
        System.out.println("Process Arrival Burst Completion Turn Wait");
        for(int i=0;i<n;i++){
            System.out.print(array[i].id+"\t"+array[i].arrival+"\t"+array[i].burst+"\t"+array[i].completion+"\t"+(array[i].completion-array[i].arrival)+"\t"+(array[i].completion-array[i].arrival-array[i].burst)+"\n");
            turn+=array[i].completion-array[i].arrival;
            wait+=array[i].completion-array[i].arrival-array[i].burst;
        }
        System.out.println("average turnaround time="+turn/n);
        System.out.println("average waiting time="+wait/n);

    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the number of processes:");
        n=sc.nextInt();
        p=new process[n];
        readArray(p);
        firstComeFirstServe(p);
        sc.close();    
    }
    
}
