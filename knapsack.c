#include<stdio.h>
int number;
int knapsack;
int remainingcapacity;
struct weighted{
	float weight;
	float profit;
	float ratio;
	int object;
}quantity[10];
void readArray(struct weighted array[10])
{
   printf("\nEnter Weights\n");
	for(int i=0;i<number;i++)
	{
		printf("Enter weight of %d :  ",(i+1));
		scanf("%f,",&array[i].weight);
		array[i].object=i+1;
	}
	printf("\nEnter Values\n");
	for(int i=0;i<number;i++)
	{
		printf("Enter value of %d :  ",(i+1));
		scanf("%f,",&array[i].profit);
	}
	

}
void displayArray(struct weighted array[10])
{
	printf("\nObject\tWeight\tValue\tRatio\n");
	for(int i=0;i<number;i++)
	{
		printf("  %d\t  %.0f\t  %.0f\t %f\n",array[i].object,array[i].weight,array[i].profit,array[i].ratio);
	}
}

void sort(struct weighted array[10])
{
    for(int i=0;i<number;i++)
    {
        for(int j=0;j<i;j++)
        {
            if(array[i].ratio>array[j].ratio)
            {
                struct weighted temp=array[i];
				array[i]=array[j];
				array[j]=temp;
                
             
            }
        }
    }
	
}

void greedyKnapsack(struct weighted array[10])
{
	int i;
	float items_in_knapsack[10];
	float profit=0;
	printf("\nItems in knapsack: ");
	for( i=0;i<number;i++)
	{
		items_in_knapsack[i]=0;
	}
		remainingcapacity=knapsack;
		for(i=0;i<number;i++)
		{
			if(array[i].weight>remainingcapacity){
			break;
			}
			printf("%d ",array[i].object);
		     items_in_knapsack[i]=1;
			remainingcapacity-=array[i].weight;
			profit=profit+array[i].profit;
		}
		if(i<number){
		items_in_knapsack[i]=remainingcapacity/array[i].weight;
		printf("%d ",array[i].object);
		profit=profit+items_in_knapsack[i]*(array[i].profit);
		printf("(%.2f)\n",items_in_knapsack[i]);
		}
		printf("The profit is:%f",profit);
	
}
	


void main()
{
	
	printf("Enter knapsack capacity:");
	scanf("%d",&knapsack);
	printf("enter number of objects:");
	scanf("%d",&number);
	readArray(quantity);
	printf("\nObject\tWeight\tValue\n");
	for(int i=0;i<number;i++)
	{
		printf("  %d\t  %.0f\t  %.0f\n",quantity[i].object,quantity[i].weight,quantity[i].profit);
	}
	printf("\ncalculating ratio\n");
	for(int i=0;i<number;i++)
	{
		quantity[i].ratio=quantity[i].profit/quantity[i].weight;
	}
	displayArray(quantity);
	printf("\nSorting\n");
	sort(quantity);
	displayArray(quantity);
	greedyKnapsack(quantity);
    
}