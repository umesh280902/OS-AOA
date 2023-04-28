#include<stdio.h>
int noofsol=0,count=0;
int w[10];
int x[10]={0};
int m,n;
//this is just to displat the solution with some style 
void displayset(int x[],int k,int num){
    printf("Subset %d:{ ",num);
    for(int i=0;i<=k;i++){
        if(x[i]==1){
            printf("%d ",w[i]);
        }

    }
    printf("}\n_________________________________________");
}
//this is also displaying solution for 1 to n means from 0 to k(inclusive) and from k to size of the subset
void display(int x[],int k){
    noofsol+=1;
    printf("\n\nSolution %d:{",noofsol);
    //this for loop is going from 0 to k to print the vector
    for(int i=0;i<=k;i++){
        printf(" %d ",x[i]);
        }
    //printing from k to n if exists
    if(k<n){
        for(int i=k+1;i<n;i++){
                printf(" 0 ");
            }
    }
    printf("}\n");
    displayset(x,k,noofsol);
}
void sumOfSubset(int Sum,int remaining,int k){
    count+=1;
    x[k]=1;
    //if adding the sum and the new sum is fullfilled then we are displaying the solution
    if(Sum+w[k]==m)
        display(x,k);
    //if adding the sum and by adding the next element and if the sum is less than the required sum  we are the function again
    else if(Sum+w[k]+w[k+1]<=m)
    //we are sending the sum with the current element and reducing the remaining by element and sending the incremented k 
        sumOfSubset(Sum+w[k],remaining-w[k],k+1);
    //if sum and remaining after removal of current weight is greater then m and sum of sum and next element is less than m we are setting x as 0 and calling the sumofsubset function by subtracting the remaining 
    if((Sum+remaining-w[k]>=m)&&(Sum+w[k+1]<=m)){
    x[k]=0;
    sumOfSubset(Sum,remaining-w[k],k+1);
    }   

}
void main(){
    printf("enter the total sum required:");
    scanf("%d",&m);
    printf("\n");
    printf("enter the size of the subset:");
    scanf("%d",&n);
    printf("\n");
    int r=0;
    for(int i=0;i<n;i++){
        printf("enter element %d:",(i+1));
        scanf("%d",&w[i]);
        r+=w[i];
    }
    sumOfSubset(0,r,0);
    printf("\nThe number of calls int this program to sumOfSubset function is:%d",count);
}
