import java.util.*;

public class bankers {

    static Scanner sc = new Scanner(System.in);
    static int n, r;
    static int[][] maximum, need, allocate;
    static int[] available;

    static void bankersAlgo() {
        boolean[] visit = new boolean[n];
        List<Integer> ans = new ArrayList<Integer>();
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                if (!visit[i]) {
                    int j;
                    for (j = 0; j < r; j++) {
                        if (need[i][j] > available[j]) {
                            break;
                        }
                    }
                    if (j == r) {
                        for (int m = 0; m < r; m++) {
                            available[m] += allocate[i][m];
                        }
                        visit[i] = true;
                        ans.add(i + 1);
                    }
                }
            }
        }
        if (ans.size() < n) {
            System.out.println("\nNO SAFE SQUENCE POSSIBLE.....\n DEADLOCK MAY OCCUR\n");
        } else {
            System.out.println("\nPOSSIBLE SAFE SQUENCE: ");
            for (int i : ans) {
                System.out.print("P" + i + " ");
            }
        }
    }

    public static void main(String[] args) {
        System.out.print("Enter the number of processes: ");
        n = sc.nextInt();
        System.out.print("Enter the number of resources: ");
        r = sc.nextInt();
        maximum = new int[n][r];
        need = new int[n][r];
        allocate = new int[n][r];
        available = new int[r];
        System.out.print("Enter the available instances of resources: ");
        for (int i = 0; i < r; i++) {
            available[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            System.out.println("Process " + (i + 1));
            System.out.print("Enter the maximum requirement of resources: ");
            for (int j = 0; j < r; j++) {
                maximum[i][j] = sc.nextInt();
            }
            System.out.print("Enter the allocated instances of resources: ");
            for (int j = 0; j < r; j++) {
                allocate[i][j] = sc.nextInt();
                need[i][j] = maximum[i][j] - allocate[i][j];
            }
        }
        bankersAlgo();
    }
}
