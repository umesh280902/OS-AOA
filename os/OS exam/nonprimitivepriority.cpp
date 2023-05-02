#include<bits/stdc++.h>
using namespace std;
struct Process{
    int id,burst,completion,arrival,priority;
}process[100];
int n;

void readProcess(struct Process process[]){
    cout<<"enter the arrival time for the processes"<<endl;
    for(int i=0;i<n;i++){
        cin>>process[i].arrival;
        process[i].id=i+1;
    }
    cout<<endl<<"enter the burst time for the processes"<<endl;
    for(int i=0;i<n;i++){
        cin>>process[i].burst;
    }
    cout<<endl<<"enter the priority for the processes"<<endl;
    for(int i=0;i<n;i++){
        cin>>process[i].priority;
    }
}
void nonPrimtivePriority(struct Process process[]){
    cout<<"Process Arrival Burst Priority Completion Turn Wait"<<endl;
    int time=0;
    for(int i=0;i<n;i++){
        process[i].completion=process[i].burst+time;
        time=process[i].completion;
    }
    float turn=0,wait=0;
    for(int i=0;i<n;i++){
        cout<<process[i].id<<"\t"<<process[i].arrival<<"\t"<<process[i].burst<<"\t"<<process[i].priority<<"\t"<<process[i].completion<<"\t"<<process[i].completion-process[i].arrival<<"\t"<<process[i].completion-process[i].arrival-process[i].burst;
        turn+=process[i].completion-process[i].arrival;
        wait+=process[i].completion-process[i].arrival-process[i].burst;
    }
    cout<<endl;
}
int main(){
    cout<<"enter number of processes:";
    cin>>n;
    
    
    return 0;
}