import java.util.*;;
public class clook {
    static Scanner sc = new Scanner(System.in);
    
    public static void Clook(List<Integer> req, int head) {
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
        System.out.println("\nC-LOOK POLICY:\n");
        System.out.println("------------------------------------");
        System.out.println("\tLEFT TO RIGHT");
        System.out.println("------------------------------------");
        for (int i = index; i < n; i++) {
            System.out.println("TRACK: " + req.get(i));
        }
        for (int i = 0; i <index; i++) {
            System.out.println("TRACK: " + req.get(i));
        }
        System.out.println("total seek time:"+(req.get(n-1)-head+req.get(n-1)-req.get(0)+req.get(index-1)-req.get(0)));
        System.out.println("\nC-LOOK POLICY:\n");
        System.out.println("------------------------------------");
        System.out.println("\tRIGHT TO LEFT");
        System.out.println("------------------------------------");
        for (int i = index; i >=0; i--) {
            System.out.println("TRACK: " + req.get(i));
        }
        for (int i = n-1; i >index ; i--) {
            System.out.println("TRACK: " + req.get(i));
        }
        System.out.println("total seek time:"+(head-req.get(0)+req.get(n-1)-req.get(0)+req.get(n-1)-req.get(index+1)));
    }
    
    public static void main(String[] args) {
        int head, n;
        System.out.print("Enter the number of request processes: ");
        n = sc.nextInt();
        System.out.print("Enter head position: ");
        head = sc.nextInt();
        List<Integer> req = new ArrayList<>();
        System.out.print("Enter the track of processes: ");
        for (int i = 0; i < n; i++) {
            req.add(sc.nextInt());
        }
        Clook(req, head);
    }
    
}
