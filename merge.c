#include<stdio.h>
#include<math.h>
int count=0;
int number;
int array[10];
int b[10];
void readArray()
{
for(int i=0;i<number;i++)
{
scanf("%d",&array[i]);
}
}
void displayArray()
{
	printf("\nthe array elements are as follows:\n");
	for(int i=0;i<number;i++)
	{
	printf("%d\n",array[i]);
}
}
void merge(int low,int mid,int high)
{
	int h=low;
	int i=low;
	int j=mid+1;
	while((h<=mid)&&(j<=high))
	{
		if(array[h]<=array[j])
		{
			b[i++]=array[h++];
		}
		else
		{
			b[i++]=array[j++];
		}
	}
	
	if(h>mid)
	{
		for(int k=j;k<=high;k++)
		{
			b[i++]=array[k];
		}
	}
	else
	{
		for(int k=h;k<=mid;k++)
		{
			b[i++]=array[k];
		}
	}
	for(int k=low;k<=high;k++)
	{
		array[k]=b[k];
	}
	
}
void mergesort(int low,int high)
{
    count++;
	if(low<high)
	{
		int mid=(low+high)/2;
		mergesort(low,mid);
		mergesort(mid+1,high);
		merge(low,mid,high);
	}
}
int main()
{ 
	printf("enter the size of array:");
	scanf("%d",&number);
	printf("enter the array elements:");
	readArray();
	displayArray();
	mergesort(0,number-1);
     printf("\nAfter Sorting\n");
	displayArray();
	printf("the mergesort has been called %d times",count);
}