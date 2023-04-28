import java.util.Scanner;

public class BankersAlgorithm{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        System.out.print("Enter number of resources: ");
        int m = sc.nextInt();

        int[][] max = new int[n][m];
        int[][] allocation = new int[n][m];
        int[][] need = new int[n][m];
        int[] available = new int[m];

        System.out.println("Enter the maximum demand of each process: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter the allocation for each process: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                allocation[i][j] = sc.nextInt();
                need[i][j] = max[i][j] - allocation[i][j];
            }
        }

        System.out.println("Enter the available resources: ");
        for (int i = 0; i < m; i++) {
            available[i] = sc.nextInt();
        }

        boolean[] finished = new boolean[n];
        int[] safeSequence = new int[n];
        int count = 0;

        while (count < n) {
            boolean found = false;
            for (int i = 0; i < n; i++) {
                if (!finished[i]) {
                    boolean canAllocate = true;
                    for (int j = 0; j < m; j++) {
                        if (need[i][j] > available[j]) {
                            canAllocate = false;
                            break;
                        }
                    }

                    if (canAllocate) {
                        for (int j = 0; j < m; j++) {
                            available[j] += allocation[i][j];
                        }

                        safeSequence[count] = i;
                        finished[i] = true;
                        count++;
                        found = true;
                    }
                }
            }

            if (!found) {
                System.out.println("System is not in safe state");
                break;
            }
        }

        if (count == n) {
            System.out.println("No Deadlocks");
            System.out.print("Safe sequence: ");
            for (int i = 0; i < n; i++) {
                System.out.print("P" + safeSequence[i]);
                if (i != n-1) {
                    System.out.print(" -> ");
                }
            }
            System.out.println();
            System.out.println("current available");
            for(int i=0;i<m;i++)
            {
                System.out.println(available[i]+"\t");
            }
            System.out.println();
            
        }
    }
}