import java.util.*;

public class quicksort {
    static int array[];
    static int number;
    static int count=0;
    static void readArray(int number) {
        Scanner sc = new Scanner(System.in);
        array = new int[number];
        for (int i = 0; i < number; i++) {
            array[i] = sc.nextInt();
        }
    }

    static void displayArray(int number) {
        System.out.println("Array details");
        System.out.println();
        System.out.print("{" + "\t");
        for (int i = 0; i < number; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.print("}");
        System.out.println();
    }

    static void quickSort(int array[], int low, int high) {
        count++;
        if (low < high) {
            int part = partition(array, low, high);
            quickSort(array, low, part - 1);
            quickSort(array, part + 1, high);
        }
    }

    static int partition(int array[], int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j <= high - 1; j++) {
            if (array[j] <= pivot) {
                i = i + 1;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        number = sc.nextInt();
        System.out.println("__________________________________________________________________________________");
        System.out.println("Enter the array details");
        readArray(number);
        System.out.println("__________________________________________________________________________________");
        displayArray(number);
        System.out.println("__________________________________________________________________________________");
        quickSort(array, 0, number - 1);
        System.out.println("__________________________________________________________________________________");
        displayArray(number);
        System.out.println("The number of calls to the quicksort is: "+count);
    }
}
