#include<bits/stdc++.h>
using namespace std;
int maxtrack;
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
	head_movement+=(maxtrack-head)+(maxtrack-v[0]);
	//Towards the Right
	for(int i=index;i<n;i++)
	{
		cout<<"STEP "<<count++<<": "<<v[i]<<"\n";
	}
	cout<<"STEP "<<count++<<": "<<maxtrack<<"\n";
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
	head_movement+=(head+v[n-1]);
	for(int i=index;i>=0;i--)
	{
		cout<<"STEP "<<count++<<": "<<v[i]<<"\n";
	}
	cout<<"STEP "<<count++<<": "<<0<<"\n";
          for(int i=index+1;i<n;i++)
	{
		cout<<"STEP "<<count++<<": "<<v[i]<<"\n";
	}
	cout<<"\nTotal head movement:"<<head_movement<<"\n";
}
int main()
{
	int n,head;
	cout<<"Enter the maximum tack:";
	cin>>maxtrack;
	maxtrack--;
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
