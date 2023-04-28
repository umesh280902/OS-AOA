#include <stdio.h>
int parent[10],rank[10],g[10][10],edge[10][3];
int v,e,totalcost=0;
void readgraph()
{    printf("Enter Adjacent Matrix\n");
    for(int i=0;i<v;i++)
    {   for(int j=0;j<v;j++)
        {   scanf("%d",&g[i][j]);
            if(g[i][j]!=0 && i<j)
                e++;
}  }   }
void displaygraph()
{    printf("\nThe graph is\n");
    for(int i=0;i<v;i++)
    {   for(int j=0;j<v;j++)
                printf("%d\t",g[i][j]);         
        printf("\n");
}   }
void print1darray(char *str,int a[])
{    printf("\n%s [] : ",str);
    for(int i=0;i<v;i++)
        printf("\t%d",a[i]);
}
void makeset(int x)
{   parent[x]=x;
    rank[x]=0;
}
void createtable()
{   int k=0;
    for(int i=0;i<v;i++)
    {   for(int j=0;j<v;j++)
        {    if(g[i][j]!=0 && i<j)
            {    edge[k][0]=i;
                edge[k][1]=j;
                edge[k][2]=g[i][j];
                k++;
}  }   }   }
void printedgetable()
{   printf("\nEdge table\n");
    for(int i=0;i<e;i++)
        printf("%d --> %d : %d\n",edge[i][0],edge[i][1],edge[i][2]);
}
void bubblesort()
{   int i,j;
    for(i=0;i<e-1;i++)
    {   for(j=0;j<e-i-1;j++)
        {   if(edge[j][2]>edge[j+1][2])
            {   int temp=edge[j][0];
                edge[j][0]=edge[j+1][0];
                edge[j+1][0]=temp;
                temp=edge[j][1];
                edge[j][1]=edge[j+1][1];
                edge[j+1][1]=temp;
                temp=edge[j][2];
                edge[j][2]=edge[j+1][2];
                edge[j+1][2]=temp;
}  }   }   }
int findset(int x)
{   if(x!=parent[x])
        parent[x]=findset(parent[x]);
    return parent[x];
}
void link(int x, int y)
{   if(rank[x]<rank[y])
        parent[y]=x;
    else
    {   parent[x]=y;
        if(rank[x]==rank[y])
            rank[y]+=1;
}   }
void unionop(int x, int y)
{   link(findset(x),findset(y));
}
void main() 
{   printf("Enter no. of vertices\n");
    scanf("%d",&v);
    readgraph();
    displaygraph();
    printf("No. of vertices : %d\nNo. of Edges : %d",v,e);
    for(int i=0;i<v;i++)
        makeset(i);
    createtable();
    printf("\n\nEdge table before sorting\n");
    printedgetable();
    bubblesort();
    printf("\n\nEdge table after sorting\n");
    printedgetable();
    for(int i=0;i<e;i++)
    {   if(findset(edge[i][0])!=findset(edge[i][1]))
        {   unionop(edge[i][0],edge[i][1]);
            totalcost+=edge[i][2];
            printf("\n\nEdges (%d,%d) : %d",edge[i][0],edge[i][1],edge[i][2]);
   }   }
    print1darray("\nParent array", parent);
    print1darray("Rank array",rank);
    printf("\n\nTotal Cost : %d",totalcost);
}
