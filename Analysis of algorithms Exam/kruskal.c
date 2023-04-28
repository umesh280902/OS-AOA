#include<stdio.h>
int parent[10],rank[10],g[10][10],edge[10][3];
int v,e,totalcost=0;
void readGraph(){
    for(int i=1;i<=v;i++){
        for(int j=1;j<=v;j++){
            scanf("%d",&g[i][j]);
            if(g[i][j]!=0 && i<j){
                e++;
                }
        }
    }
}
void displaygraph(){
    printf("\nThe Graph is:\n");
    for(int i=1;i<=v;i++){
        for(int j=1;j<=v;j++){
            printf("%d  ",g[i][j]);
        }
        printf("\n");
    }
}
void makeset(int x){
    parent[x]=x;
    rank[x]=0;
}

void createTable(){
    int k=1;
    for(int i=1;i<=v;i++){
        for(int j=1;j<=v;j++){
            if(g[i][j]!=0 && i<j){
                edge[k][0]=i;
                edge[k][1]=j;
                edge[k][2]=g[i][j];
                k++;
            }
        }
    }
}

void printEdgeTable(){
    printf("\nThe Edge Table is:\n");
    for(int i=1;i<=e;i++){
        printf("%d-->%d:%d\n",edge[i][0],edge[i][1],edge[i][2]);
    }
}

void bubblesort(){
    int i,j;
    for(i=1;i<=e-1;i++){
        for(j=1;j<=e-i-1;j++ ){
            if(edge[j][2]>edge[j+1][2]){
                int temp=edge[j][0];
                edge[j][0]=edge[j+1][0];
                edge[j+1][0]=temp;
                temp=edge[j][1];
                edge[j][1]=edge[j+1][1];
                edge[j+1][1]=temp;
                temp=edge[j][2];
                edge[j][2]=edge[j+1][2];
                edge[j+1][2]=temp;
            }
        }
    }
}
int findset(int x){
    if(x!=parent[x])
        parent[x]=findset(parent[x]);
    return parent[x];
}
void link(int x,int y){
    if(rank[x]<rank[y]){
        parent[y]=x;
    }
    else{
        parent[x]=y;
        if(rank[x]==rank[y]){
            rank[y]+=1;
        }
    }
}
void unionop(int x,int y){
    link(findset(x),findset(y));
}

void print1DArray(char *str,int a[]){
    printf("\n%s []: ",str);
    for(int i=1;i<=v;i++){
        printf("%d\t",a[i]);
    }

}
void main(){
    printf("enter the number of vertices:");
    scanf("%d",&v);
    printf("\n");
    readGraph();
    displaygraph();
    printf("no of vertices:%d\n",v);
    printf("no of edges:%d\n",e);
    for(int i=0;i<v;i++){
        makeset(i);
    }
    createTable();
    printf("edge before sorting:\n");
    printEdgeTable();
    bubblesort();
    printf("edge after sorting:\n");
    printEdgeTable();
    for(int i=1;i<=v;i++){
        if(findset(edge[i][0])!=findset(edge[i][1])){
            unionop(edge[i][0],edge[i][1]);
            totalcost+=edge[i][2];
            printf("\nEdge (%d,%d) : %d",edge[i][0],edge[i][1],edge[i][2]);
        }
    }
    print1DArray("\n Parent Array",parent);
    print1DArray("\n Rank Array",rank);
    printf("\nThe total cost of the tree is:%d",totalcost);

}