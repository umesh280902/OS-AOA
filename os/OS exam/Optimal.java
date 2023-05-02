import java.util.ArrayList;
import java.util.Scanner;

public class Optimal {
    static Scanner sc = new Scanner(System.in);
    static int n, f, hit = 0;
    static int r[];
    static ArrayList<Integer> frame;

    // Function to check if a page is present in the frame
    static boolean present(ArrayList<Integer> frame, int num) {
        for (int it : frame)
            if (it == num)
                return true;
        return false;
    }

    static int optimal_used(ArrayList<Integer> frame, int curr) {
        ArrayList<Boolean> visit = new ArrayList<Boolean>();
        for (int i = 0; i < f; i++)
            visit.add(false);

        int count = 0;
        for (int i = curr + 1; i < n; i++) {
            for (int j = 0; j < f; j++) {
                if (r[i] == frame.get(j)) {
                    count++;
                    visit.set(j, true);
                    break;
                }
            }
            if (count == f - 1)
                break;
        }
        for (int k = 0; k < f; k++) {
            if (visit.get(k) == false)
                return k;
        }
        return 0;
    }

    public static void main(String args[]) {
        System.out.println("Enter the length of reference string:");
        n = sc.nextInt();

        r = new int[n];
        System.out.println("Enter reference string:");
        for (int i = 0; i < n; i++) {
            r[i] = sc.nextInt();
        }

        System.out.println("Enter frame size:");
        f = sc.nextInt();
        frame = new ArrayList<Integer>(f);

        System.out.println("\nOptimal page replacement policy:");
        for (int i = 0; i < n; i++) {
            if (frame.size() == 0) {
                frame.add(r[i]);
            } else {
                if (present(frame, r[i]))
                    hit++;
                else {
                    if (frame.size() < f)
                        frame.add(r[i]);
                    else
                        frame.set(optimal_used(frame, i), r[i]);
                }
            }
            // Printing frame
            System.out.print("\n" + r[i] + " ---> ");
            for (int it : frame) {
                System.out.print(it + " ");
            }
        }
        System.out.println("\n\nNumber of Hits: " + hit);
        System.out.println("Hit ratio: " + (float) hit / n);
        System.out.println("Number of faults: " + (n - hit));
        System.out.println("Miss ratio: " + (float) (n - hit) / n);
    }
}
