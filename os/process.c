#include <stdio.h>
struct process{
  int burst,priority,id,wait_time,turn_around;
}p[100];
int n;
void input()
{
  printf("Enter the Priority of all process:");    
  for(int i=0;i<n;i++)
  {
    scanf("%d",&p[i].priority);  
    p[i].id=i+1;
  }
  printf("Enter the burst time of all process:");   
  for(int i=0;i<n;i++)
  {
    scanf("%d",&p[i].burst);    
  }
}
void sort()
{
    for(int i=0;i<n;i++)
    {
        for(int j=i+1;j<n;j++)
        {
            if(p[i].priority>p[j].priority)
            {
                struct process temp=p[i];
                p[i]=p[j];
                p[j]=temp;
            }
        }
    }
}
void Printprocess()
{
    printf("\n\n\n----------------------------------------\n");
    printf("Process Priority Burst Wait Turn");
    printf("\n----------------------------------------\n");
    for(int i=0;i<n;i++)
    {
       printf("  P%d\t%d\t%d\t%d\t%d\n",p[i].id,p[i].priority,p[i].burst,p[i].wait_time,p[i].turn_around);
    }
}
void algorithm()
{
    int turn=0,turnsum=0,waitsum=0;
    printf("Gantt Chart:\n---------------------------------------------------------\n");
    for(int i=0;i<n;i++)
    {
        printf("    P%d\t",p[i].id);
    }
    printf("\n---------------------------------------------------------\n");
    for(int i=0;i<n;i++)
    {
        printf("%d\t",turn);
        turn+=p[i].burst;
        p[i].turn_around=turn;
        turnsum+=p[i].turn_around;
        p[i].wait_time=(p[i].turn_around-p[i].burst);
        waitsum+=p[i].wait_time;
    }
    printf("%d",turn);
    Printprocess();
    printf("\nAvg Turnaround time:%.3f",((float)turnsum)/n);
    printf("\nAvg Waiting time:%.3f",((float)waitsum)/n); 
}

int main()
{
    printf("Enter number of proccess:");
    scanf("%d",&n);
    input();
    sort();
    algorithm();
    return 0;
}
