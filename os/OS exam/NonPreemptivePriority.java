import java.util.Scanner;
public class NonPreemptivePriority {
    static Scanner sc=new Scanner(System.in);
    static class process{
        int id,arrival,burst,priority,completion;
        process(int id,int arrival,int burst,int priority,int completion){
            this.id=id;
            this.arrival=arrival;
            this.burst=burst;
            this.priority=priority;
            this.completion=completion;
        }
    }
    static int n;
     static process p[];
     static void sort(process p[]){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(p[i].arrival<p[j].arrival){
                    process temp=p[i];
                    p[i]=p[j];
                    p[j]=temp;
                }
            }
        }
     }
     static boolean visit[];
     static int min_priority(int time){
        int min=10000,index=-1;
        for(int i=0;i<n;i++){
            if(p[i].arrival<=time && !visit[i] && min>p[i].priority){
                min=p[i].priority;
                index=i;
            }
        }
        return index;
     }
     static void priorityAlgo(process p[]){
        sort(p);
        int time=0;
        visit=new boolean[n];
        for(int i=0;i<n;i++){
            visit[i]=false;
        }
        for(int i=0;i<n;i++){
            int index=min_priority(time);
            if(index!=-1){
                visit[index]=true;
                p[index].completion=p[index].burst+time;
                time=p[index].completion;
            }else{
                time++;
                i--;
            }
        }
        float turn=0,wait=0;
        System.out.println("process arrival burst prior comp turn wait");
        for(int i=0;i<n;i++){
            System.out.print(p[i].id+"\t"+p[i].arrival+"\t"+p[i].burst+"\t"+p[i].priority+"\t"+p[i].completion+"\t"+(p[i].completion-p[i].arrival)+"\t"+(p[i].completion-p[i].arrival-p[i].burst)+"\n");
            turn+=p[i].completion-p[i].arrival;
            wait+=p[i].completion-p[i].arrival-p[i].burst;
        }
        System.out.println("turn around time average:"+turn/n);
        System.out.println("waiting time average:"+wait/n);

     }
    public static void main(String args[]){
        System.out.println("enter total number of process:");
        n=sc.nextInt();
        p=new process[n];
        System.out.print("enter the burst time for all processes:");
        for(int i=0;i<n;i++){
            p[i]=new process(i+1,0,sc.nextInt(),0,0);
        }
        System.out.print("enter the arrival time for all processes:");
        for(int i=0;i<n;i++){
            p[i].arrival=sc.nextInt();
        }
            System.out.print("enter the priority for all processes:");
            for(int i=0;i<n;i++){
            p[i].priority=sc.nextInt();
            
        }
        priorityAlgo(p);
    }
}
