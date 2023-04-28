#include<stdio.h>
#define inf 999
int g[10][10];
int d[10][10];
int p[10][10];
int v,e;
void readArray(int g[10][10]){
    printf("enter the array details:\n");
    for(int i=1;i<=v;i++){
        for(int j=1;j<=v;j++){
            scanf("%d",&g[i][j]);
        }
    }

}
void displayArray(int g[10][10]){
    printf("array details:\n");
        for(int i=1;i<=v;i++){
            for(int j=1;j<=v;j++){
                printf("%d\t",g[i][j]);
        }
        printf("\n");
    }
}
void initialize(){
    for(int i=1;i<=v;i++){
        for(int j=1;j<=v;j++){
            if(i==j){
                d[i][j]=0;
                p[i][j]=-1;
            }
            else if(g[i][j]==0){
                d[i][j]=inf;
                p[i][j]=-1;
            }
            else{
                d[i][j]=g[i][j];
                p[i][j]=i;
            }
        }
    }
    
}

void floydwarshall(){
    for(int k=1;k<=v;k++){
        for(int i=1;i<=v;i++){
            for(int j=1;j<=v;j++){
                if(d[i][j]<=d[i][k]+d[k][j]){
                    continue;
                }
                    else{
                    d[i][j]=d[i][k]+d[k][j];
                    p[i][j]=p[k][j];
                }
            }
        }
        printf("after iteration %d",(k+1));
        printf("\nd matrix\n");
      displayArray(d);
      printf("\np matrix\n");
      displayArray(p);  
    }
}
void printpath(int s,int v){
if(s==v){
    printf("%d",s);
}
else if(p[s][v]==-1){
    printf("no path exists\n");
}
else{
    printpath(s,p[s][v]);
    printf("->");
    printf("%d",v);
}
}

void main(){
    printf("enter the size of the matrix:");
    scanf("%d",&v);
    readArray(g);
    displayArray(g);
    initialize();
    printf("after initializing the d matrix:\n");
    displayArray(d);
    printf("after initializing the p matrix:\n");
    displayArray(p);
    floydwarshall();
    printf("after floydwarshall the d matrix:\n");
    displayArray(d);
    printf("after floydwarshall the p matrix:\n");
    displayArray(p);
    printf("printing the path as followed:\n");
    for(int i=1;i<=v;i++){
        for(int j=1;j<=v;j++){
            if(i==j)
            continue;
            printf("path from %d to %d is ",i,j);
            printpath(i,j);
            printf("\n");
        }
    }  
}