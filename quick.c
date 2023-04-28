#include<stdio.h>
int count;
void readArray(int n,int array[n])
{
for(int i=0;i<n;i++)
{
scanf("%d",&array[i]);
}
}
void displayArray(int n,int array[n])
{
	printf("\nthe array elements are as follows:\n");
	for(int i=0;i<n;i++)
	{
	printf("%d\n",array[i]);
}
}
int parition(int Array[10],int p,int r)
{
	int x=Array[r];
	int i=p-1;
	for(int j=p;j<=r-1;j++)
	{
		if(Array[j]<=x)
		{
			i=i+1;
			int temp=Array[i];
			Array[i]=Array[j];
			Array[j]=temp;
		}
	}
     int temp1=Array[i+1];
     Array[i+1]=Array[r];
     Array[r]=temp1;
	return i+1;
}
void quicksort(int Array[10],int p,int r)
{
	int q;
		count++;
	if(p<r)
	{
		q=parition(Array,p,r);
		quicksort(Array,p,q-1);
		quicksort(Array,q+1,r);
	}
	
		
}

int main()
{
	int number;
	printf("\nenter the array size:\n");
	scanf("%d",&number);
	int array[number];
	readArray(number,array);
	displayArray(number,array);
	quicksort(array,0,number-1);
    printf("\nAfter Sorting\n");
	displayArray(number,array);
	printf("the quicksort has been called %d times",count);
}