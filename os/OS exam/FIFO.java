import java.util.ArrayList;
import java.util.Scanner;

public class FIFO {
    static int miss = 0;
    static int n, f;
    static int r[];
    static boolean ishit(ArrayList<Integer> frame, int p) {
        for (int i : frame) {
            if (i == p) {
                return true;
            }
        }
        return false;
    }

    static void fifo(ArrayList<Integer> frame) {
        int k = 0;
        System.out.println("\n---------------\nPage\tFrame\n---------------");
        for (int i = 0; i < n; i++) {
            System.out.print("\n" + r[i] + " ---> ");
            if (!ishit(frame, r[i])) {
                miss++;
                frame.set(k, r[i]);
                k = (k + 1) % f;
                if (i < f) {
                    for (int j = 0; j <= i; j++) {
                        System.out.print(frame.get(j) + " ");
                    }
                } else {
                    for (int it : frame) {
                        System.out.print(it + " ");
                    }
                }
            }
        }
        System.out.println("\n\nHit ratio:" + String.format("%.2f", (float) (n - miss) / n));
        System.out.println("Miss ratio:" + String.format("%.2f", (float) (miss) / n));
    }

    static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) {
        System.out.println("Enter the length of reference string:");
        n = sc.nextInt();
        r = new int[n];
        System.out.println("Enter the reference string:");
        for (int i = 0; i < n; i++) {
            r[i] = sc.nextInt();
        }
        System.out.println("Enter the no. of frame:");
        f = sc.nextInt();
        ArrayList<Integer> frame = new ArrayList<Integer>(f);
        for (int i = 0; i < f; i++) {
            frame.add(-1);
        }
        fifo(frame);
    }
}
