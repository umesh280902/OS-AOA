#include<bits/stdc++.h>
using namespace std;
struct process{
    int id,arrival,burst,completion;
}p[100];
int n;
void sort(){
    for(int i=0;i<n-1;i++){
        for(int j=i+1;j<n;j++){
            if(p[i].arrival>p[j].arrival)
            {
                swap(p[i],p[j]);
            }
        }
    }
}
void fcfs(){
    sort();
    float averageturn=0,averagewait=0;
    int time=0;
    for(int i=0;i<n;i++){
        p[i].completion=p[i].burst+time;
        time=p[i].completion;
    }
    cout<<"\nprocessNo Arrival Burst Completion Turn Wait"<<endl;
    for(int i=0;i<n;i++){
        cout<<"\t"<<p[i].id<<"\t"<<p[i].arrival<<"\t"<<p[i].burst<<"\t"<<p[i].completion<<"\t"<<p[i].completion-p[i].arrival<<"\t"<<p[i].completion-p[i].arrival-p[i].burst<<endl;
        averageturn+=p[i].completion-p[i].arrival;
        averagewait+=p[i].completion-p[i].arrival-p[i].burst;
    }
    cout<<"Turn around time:"<<averageturn/n<<endl<<"waiting time:"<<averagewait/n<<endl;
}
int main(){
 cout<<"enter total no of process:";
 cin>>n;
 for(int i=0;i<n;i++){
    cout<<"enter the arrival time for the process :"<<(i+1);
    cin>>p[i].arrival;
    p[i].id=i+1;
 }
  for(int i=0;i<n;i++){
    cout<<"enter the burst time for the process :"<<(i+1);
    cin>>p[i].burst;
 }
fcfs();
}