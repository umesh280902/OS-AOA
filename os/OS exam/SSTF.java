import java.util.*;

public class SSTF {
    static Scanner sc = new Scanner(System.in);
    
    static void sstf(ArrayList<Integer> req, int n, int head) {
        int seektime = 0;
        // Add the head position to the list of requests
        req.add(head);
        // Sort the list of requests
        Collections.sort(req);
        // Get the index of the head in the sorted list of requests
        int index = req.indexOf(head);
        System.out.println("SSTF Policy:");
        while (!req.isEmpty()) {
            // Print the current head position
            System.out.println("TRACK: " + head);
            if (req.size() == 1) {
                // If there is only one request left, calculate the seek time and break out of the loop
                seektime += Math.abs(req.get(0) - head);
                break;
            } else {
                // Calculate the distances between the head and the requests on either side of it
                int left = (index > 0) ? Math.abs(req.get(index - 1) - head) : Integer.MAX_VALUE;
                int right = (index < req.size() - 1) ? Math.abs(req.get(index + 1) - head) : Integer.MAX_VALUE;
                if (left < right) {
                    // If the left request is closer, add its seek time to the total and move the head to that position
                    seektime += left;
                    head = req.get(index - 1);
                    // Remove the processed request from the list of requests
                    req.remove(index);
                    // Update the index of the head position in the list of requests
                    index--;
                } else {
                    // If the right request is closer, add its seek time to the total and move the head to that position
                    seektime += right;
                    head = req.get(index + 1);
                    // Remove the processed request from the list of requests
                    req.remove(index);
                }
            }
        }
        System.out.println("Total seek time: " + seektime);
    }
    
    public static void main(String args[]) {
        System.out.println("Enter the number of tracks:");
        int n = sc.nextInt();
        System.out.println("Enter the head position:");
        int head = sc.nextInt();
        System.out.println("Enter the track positions:");
        ArrayList<Integer> req = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            req.add(sc.nextInt());
        }
        sstf(req, n, head);
    }
}
