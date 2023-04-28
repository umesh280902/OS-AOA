import java.util.Scanner;

class insertion{
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
    static void insertionSort(int a[],int n){
        for(int j=1;j<n;j++){
            int i=j-1;
            int key=a[j];
            while(i>=0 && a[i]>key){
                a[i+1]=a[i];
                i--;
            }
            a[i+1]=key;
            System.out.println("__________________________________________________________________________________");
            System.out.println();
            System.out.println("after pass "+(j));
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
        insertionSort(a, n);
        System.out.println("__________________________________________________________________________________");
        displayArray(a, n);
    }
}