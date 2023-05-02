import java.util.*;

public class LRU {
    static int miss = 0;
    static int n, f;
    static int r[];
    static ArrayList<Integer> frame;

    // function to check if a page is present in the frame
    static boolean present(ArrayList<Integer> frame, int p) {
        for (int i : frame) {
            if (i == p) {
                return true;
            }
        }
        return false;
    }

    // function to find the index of the least recently used page in the frame
    static int least_Used(ArrayList<Integer> frame, int curr) {
        boolean[] visited = new boolean[f]; // boolean array to keep track of visited pages
        int count = 0; // count of pages visited
        // loop through the pages in reverse order from the current page
        for (int i = curr - 1; i >= 0; i--) {
            // check if the page is present in the frame
            for (int j = 0; j < f; j++) {
                if (r[i] == frame.get(j)) {
                    count++; // increment count if the page is found
                    visited[j] = true; // mark the page as visited
                    break;
                }
            }
            if (count == f - 1) { // if all pages have been visited, break out of the loop
                break;
            }
        }
        // loop through the frame to find the first unvisited page
        for (int k = 0; k < f; k++) {
            if (visited[k] == false) {
                return k; // return the index of the unvisited page
            }
        }
        return 0; // if all pages have been visited, return the index of the first page in the frame
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
        System.out.println("Enter the size of the frame:");
        f = sc.nextInt();
        frame = new ArrayList<>(f);
        int hit = 0;
        System.out.println("LRU Page replacement Policy");
        for (int i = 0; i < n; i++) {
            if (frame.size() == 0) {
                frame.add(r[i]);
            } else {
                if (present(frame, r[i])) {
                    hit++;
                } else {
                    if (frame.size() < f) {
                        frame.add(r[i]);
                    } else {
                        frame.set(least_Used(frame, i), r[i]);
                    }
                }
            }
            System.out.print("\n" + r[i] + "-->");
            for (int j = 0; j < frame.size(); j++) {
                System.out.print(frame.get(j) + " ");
            }
        }
        System.out.println("\nnumber of hits:" + hit);
        System.out.println("hit ratio:" + (float) hit / n);
        System.out.println("no of faults:" + (n - hit));
        System.out.println("miss ratio:" + (float) (n - hit) / n);
    }
}
