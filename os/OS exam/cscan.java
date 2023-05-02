import java.util.*;
import java.util.Collections;;
public class cscan {
    static Scanner sc = new Scanner(System.in);

    public static void Cscan(List<Integer> req, int head, int tracks) {
        req.add(head);
        Collections.sort(req);
        int index = 0;
        int n = req.size();
        for (int i = 0; i < n; i++) {
            if (req.get(i) == head) {
                index = i;
                break;
            }
        }
        System.out.println("\nC-SCAN POLICY:\n");
        System.out.println("------------------------------------");
        System.out.println("\tLEFT TO RIGHT");
        System.out.println("------------------------------------");
        for (int i = index; i < n; i++) {
            System.out.println("TRACK: " + req.get(i));
        }
        System.out.println("TRACK: "+tracks);
        System.out.println("TRACK: 0");
        for (int i = 0; i <index; i++) {
            System.out.println("TRACK: " + req.get(i));
        }
        System.out.println("total seek time:"+(tracks-head+tracks+req.get(index-1)));
        System.out.println("\nC-SCAN POLICY:\n");
        System.out.println("------------------------------------");
        System.out.println("\tRIGHT TO LEFT");
        System.out.println("------------------------------------");
        for (int i = index; i >=0; i--) {
            System.out.println("TRACK: " + req.get(i));
        }
        System.out.println("TRACK: 0");
        System.out.println("TRACK: "+tracks);
        for (int i = n-1; i > index; i--) {
            System.out.println("TRACK: " + req.get(i));
        }
        System.out.println("total seek time:"+(head+tracks+tracks-req.get(index+1)));
    }

    public static void main(String[] args) {
        int head, n, tracks;
        System.out.print("Enter the total number of tracks: ");
        tracks = sc.nextInt();
        System.out.print("Enter the number of request processes: ");
        n = sc.nextInt();
        System.out.print("Enter head position: ");
        head = sc.nextInt();
        List<Integer> req = new ArrayList<>();
        System.out.print("Enter the track of processes: ");
        for (int i = 0; i < n; i++) {
            req.add(sc.nextInt());
        }
        Cscan(req, head, tracks-1);
        
    }
    
}
