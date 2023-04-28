#include<bits/stdc++.h>
using namespace std;
void scan_right(vector<int>v,int head)
{
	int head_movement=0,count=1,index=0,n=v.size()+1;
	v.push_back(head);
	sort(v.begin(),v.end());
	for(int i=0;i<n;i++)
	{
		if(v[i]==head)
		{
			index=i;
			break;
		}
	}
	head_movement+=(v[n-1]-head)+(v[n-1]-v[0]);
	//Towards the Right
	for(int i=index;i<n;i++)
	{
		cout<<"STEP "<<count++<<": "<<v[i]<<"\n";
	}
    for(int i=index-1;i>=0;i--)
	{
		cout<<"STEP "<<count++<<": "<<v[i]<<"\n";
	}
	cout<<"\nTotal head movement:"<<head_movement<<"\n";
}
void scan_left(vector<int>v,int head)
{
	int head_movement=0,count=1,index=0,n=v.size()+1;
	v.push_back(head);
	sort(v.begin(),v.end());
	for(int i=0;i<n;i++)
	{
		if(v[i]==head)
		{
			index=i;
			break;
		}
	}
	head_movement=head_movement+(head-v[0])+(v[n-1]-v[0]);
	for(int i=index;i>=0;i--)
	{
		cout<<"STEP "<<count++<<": "<<v[i]<<"\n";
	}
    for(int i=index+1;i<n;i++)
	{
		cout<<"STEP "<<count++<<": "<<v[i]<<"\n";
	}
	cout<<"\nTotal head movement:"<<head_movement<<"\n";
}
int main()
{
	int n,head;
	cout<<"Enter the number of process:";
	cin>>n;
	vector<int>v(n);
	cout<<"Enter the process track no.:";
	for(int i=0;i<n;i++)
	{
		cin>>v[i];
	}
	cout<<"Enter the starting position of head:";
	cin>>head;
	cout<<"\n-------------------------------------------------\n";
	cout<<"\t\tTowards Right end\n";
	cout<<"-------------------------------------------------\n";
	scan_right(v,head);
	cout<<"\n-------------------------------------------------\n";
	cout<<"\t\tTowards Left end\n";
	cout<<"-------------------------------------------------\n";
	scan_left(v,head);
}
