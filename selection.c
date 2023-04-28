#include<stdio.h>
#include<conio.h>
void readArray(int n,int array[n])
{
    printf("\nEnter the array elements :\n");
    for(int i=0;i<n;i++)
    {
     scanf("%d",&array[i]);
    }
    
}
void displayArray(int n,int array[n])
{
    printf("\nThe array elements are as follows:\n");
    for(int i=0;i<n;i++)
    {
    printf("%d \n",array[i]); 
    }
    
}
void selectionSort(int n, int array[n])
{
for(int i=0;i<n;i++)
{
    int j=i;
    for(int k=i+1;k<n;k++)
    {
        if(array[k]<array[j])
        {
            j=k;
        }
      
    }
        printf("after iteration %d",i+1);
        int temp=array[i];
        array[i]=array[j];
        array[j]=temp;
        displayArray(n,array);
}
}
void main(){
   int n;
   printf("enter the array size:");
   scanf("%d",&n);
   int array[n];
   readArray(n,array);
   printf("\nbefore swapping the array elements:\n");
   displayArray(n,array);
   selectionSort(n,array);
   displayArray(n,array);
}