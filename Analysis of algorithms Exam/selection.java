import java.util.*;
public class selection {
    static void readArray(int a[],int n){
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
    }
        static void displayArray(int a[],int n){
       System.out.println("Array details");
       System.out.println();
       System.out.print("{"+"\t");
        for(int i=0;i<n;i++){
            System.out.print(a[i]+"\t");
        }
        System.out.print("}");
        System.out.println();
    }
    static void SelectionSort(int a[],int n){
        for(int i=0;i<n;i++){
            int j=i;
            for(int k=i+1;k<n;k++ ){
                if(a[j]>a[k]){
                    j=k;
                }
            }
            int t=a[i];
            a[i]=a[j];
            a[j]=t;
            System.out.println("__________________________________________________________________________________");
            System.out.println();
            System.out.println("after pass "+(i+1));
            displayArray(a, n);
            System.out.println();
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the size of the array:");
        int n=sc.nextInt();
        int a[]=new int[n];
        System.out.println("__________________________________________________________________________________");
        System.out.println("enter the array details");
        readArray(a, n);
        System.out.println("__________________________________________________________________________________");
        displayArray(a, n);
        System.out.println("__________________________________________________________________________________");
        SelectionSort(a, n);
        System.out.println("__________________________________________________________________________________");
        displayArray(a, n);
    }
    
}
