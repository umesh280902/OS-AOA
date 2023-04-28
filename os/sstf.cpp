#include<bits/stdc++.h>
using namespace std;
void sstf(vector<int>&v,int head)
{
	int head_movement=0,count=1;
	set<int>s;
	s.insert(head);
	for(auto i:v)  {        s.insert(i);        }
	auto it=s.find(head);
	while(!s.empty())
	{
		cout<<"STEP "<<count++<<": "<<*it<<"\n";
		if(s.size()==1)
		     break;
		if(it==s.begin())
                     {
			auto next=it;
			next++;
			head_movement+=abs(*it-*next);
			s.erase(it);
			it=next;
			continue;
		}
		auto prev=it;
		prev--;
		auto next=it;
		next++;
		if(next==s.end())
		{
			head_movement+=abs(*it-*prev);
			s.erase(it);
			it=prev;
			continue;
		}
		if(abs(*prev-*it)<=abs(*next-*it))
		{
			head_movement+=abs(*prev-*it);
			s.erase(it);
			it=prev;
		}else{
			head_movement+=abs(*next-*it);
			s.erase(it);
			it=next;
		}
	}
	cout<<"\nTotal head movement:"<<head_movement;
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
	cout<<endl;
	sstf(v,head);
}
