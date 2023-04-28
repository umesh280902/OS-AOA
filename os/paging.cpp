#include <bits/stdc++.h>
using namespace std;
int main(int argc, char **argv)
{
 int processSize, pageSize, mainSize;
 cout<<"Size of a process: ";
 cin>>processSize;
 cout<<"Page Size: ";
 cin>>pageSize;
 cout<<"Size of phy memory: ";
 cin>>mainSize;


 cout<<"Total no. of frames in memory: "<< (20+log2(mainSize))-
log2(pageSize)<<endl;

 cout<<"Num of entries in page table: "<< pow(2,(10+log2(processSize))-
log2(pageSize))<<endl;

 cout<<"No of bits in physical address: "<< 20+log2(mainSize)<<endl;

 cout<<"No. of bits in logical address: "<< 10+log2(processSize)<<endl;

 int n = (10+log2(processSize))-log2(pageSize)+1;

 int pageTable[n][3];

 for(int i=0; i<n; i++) {
 cout<<"Page entry "<<i<<endl;
 cout<<"Page no.: ";
 cin>>pageTable[i][0];
 cout<<"Frame no. ";
 cin>>pageTable[i][1];
 cout<<"Valid bit: ";
 cin>>pageTable[i][2];
 }

 int logadd;
 cout<<"Enter logical address: ";
 cin>>logadd;
 string log = to_string(logadd);
 int page = stoi(log.substr(0,(10+log2(processSize))-log2(pageSize)));
 if(pageTable[page][2]==1)
 cout<<"Present";
 else cout<<"Not present";


 return 0;
} 
