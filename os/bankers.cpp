#include <bits/stdc++.h>
using namespace std;
int n,p;
string Safe = "";
bool check(vector<int> &v,vector<int> &v1) {
    for(int i=0; i<v.size(); i++) {
        return true;
    }
    bool safety_test(vector<pair<pair<int,vector<int>>,pair<vector<int>,vector<int>>>> &v,vector<int>
                     &curr_avail,vector<int> &visit) {
        int c=v.size();
        while(c--) {
            for(int i=0; i<v.size(); i++) {
                if(check(curr_avail,v[i].second.second) and !visit[i]) {
                    visit[i] = true;
                    for(int j=0; j<curr_avail.size(); j++) {
                        curr_avail[j] += v[i].second.first[j];
                    }
                    Safe = Safe +"P"+to_string(v[i].first.first)+" ";
                    break;
                }
            }
        }
        for(int i=0; i<visit.size(); i++) {
            if(visit[i] == false) {
                return false;
            }
        }
        return true;
    }
    void printTable(vector<pair<pair<int,vector<int>>,pair<vector<int>,vector<int>>>> &v) {
        for(auto &it: v) {
            cout<<it.first.first<<"\t";
            for(auto &i: it.first.second) {
                cout<<i<<" ";
            }
            cout<<"\t";
            for(auto &i: it.second.first) {
                cout<<i<<" ";
            }
            cout<<"\t";
            for(auto &i: it.second.second) {
                cout<<i<<" ";
            }
            cout<<"\n";
        }
    }
    int main()
    {
        int n,p;
        cout<<"Enter the no of resources: ";
        cin>>n;
        vector<int> resource(n);
        cout<<"Enter the no of instances for each resource: \n";
        for(int i=0; i<n; i++) {
            cin>>resource[i];
        }
        cout<<"Enter the total no of processes: ";
        cin>>p;
        vector<pair<pair<int,vector<int>>,pair<vector<int>,vector<int>>>> tab(p);
        vector<int> visit(p,false);
        for(int i=0; i<p; i++) {
            cout<<"Enter max resources demanded by P"<<i+1<<" for all the resources: ";
            vector<int> maxim;
            for(int j=0; j<n; j++) {
                int n;
                cin>>n;
                maxim.push_back(n);
            }
            cout<<"Enter currently allocated resources by P"<<i+1<<": ";
            vector<int> allo;
            for(int j=0; j<n; j++) {
                int n;
                cin>>n;
                allo.push_back(n);
            }
            vector<int> need;
            for(int j=0; j<n; j++) {
                need.push_back(maxim[j]-allo[j]);
            }
            tab[i] = {{i+1,maxim},{allo,need}};
        }
        vector<int> curr_avail(n);
        for(int i=0; i<n; i++) {
            int sum = 0;
            for(int j=0; j<p; j++) {
                sum += tab[j].second.first[i];
            }
            curr_avail[i] =resource[i]-sum;
        }
        printTable(tab);
        cout<<"\n";
        cout<<"curr_available\n";
        for(auto &it: curr_avail) {
            cout<<it<<" ";
        }
        if(safety_test(tab,curr_avail,visit)) {
            cout<<"Safety String is : "<<Safe<<"\n";
            cout<<"No deadlocks\n";
            cout<<"curr_available: ";
            for(auto &it: curr_avail) {
                cout<<it<<" ";
            }
        } else {
            cout<<"\nThere is a deadlock\n";
        }
        return 0;
    }
    if(v1[i] > v[i]) {
        return false;
    }
}
