import java.util.*;

public class mergesort {
    static int number;
    static int array[];
    static int barray[];
    static int count=0;

    static void readArray(int number){
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<number;i++){
            array[i]=sc.nextInt();
        }
    }

    static void displayArray(int number){
        System.out.println("Array details");
        System.out.println();
        System.out.print("{"+"\t");
        for(int i=0;i<number;i++){
            System.out.print(array[i]+"\t");
        }
        System.out.print("}");
        System.out.println();
    }

    static void mergeSort(int low,int high){
        count++;
        if(low<high){
            int mid=(low+high)/2;
            mergeSort(low,mid);
            mergeSort(mid+1, high);
            merge(low,mid,high);
        }

    }

    static void merge(int low,int mid,int high){
        int i=low; //iterator over barray
        int h=low; //left half
        int j=mid+1; //right half
        while(h<=mid && j<=high){
            if(array[h]<=array[j]){
                barray[i++]=array[h++];
            }
            else{
                barray[i++]=array[j++];
            }
        }
        if(h>mid){
            for(int k=j;k<=high;k++){ // fix the loop condition
                barray[i++]=array[k];
            }
        }
        if(j>high){
            for(int k=h;k<=mid;k++){ // fix the loop condition
                barray[i++]=array[k];
            }
        }
        for(int k=low;k<=high;k++){ // fix the loop condition
            array[k]=barray[k];
        }
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the size of the array:");
        number=sc.nextInt();
        array = new int[number]; // initialize the array
        barray = new int[number]; // initialize the barray
        System.out.println("__________________________________________________________________________________");
        System.out.println("enter the array details");
        readArray(number);
        System.out.println("__________________________________________________________________________________");
        displayArray(number);
        System.out.println("__________________________________________________________________________________");
        mergeSort(0, number - 1); // fix the upper bound
        System.out.println("__________________________________________________________________________________");
        displayArray(number);
        System.out.println("The number of calls to mergesort are :"+count);
    }

}
