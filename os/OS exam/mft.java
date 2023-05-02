import java.util.*;

public class mft {
    static Scanner sc = new Scanner(System.in);
    public static void print(List<List<Integer>> mm) {
        System.out.println("\n\tMAIN MEMORY");
        System.out.println("\t-----------------");
        for (int i = 0; i < mm.size(); i++) {
            if (mm.get(i).get(1) == -1)
                System.out.println("Block" + i + "\t|\t\t| " + mm.get(i).get(0) + " MB");
            else
                System.out.println("Block" + i + "\t|\t" + "P" + mm.get(i).get(1) + "\t| " + mm.get(i).get(0) + " MB");
            System.out.println("\t-----------------");
        }
    }
    public static void equal_partition(int memsize) {
        int bsize, t, x = 0, internal_fragment = 0;
        System.out.print("Enter the size of block(MB): ");
        bsize = sc.nextInt();
        int part = memsize / bsize;
        List<List<Integer>> mm = new ArrayList<List<Integer>>();
        for (int i = 0; i < part; i++) {
            mm.add(new ArrayList<Integer>(Arrays.asList(bsize, -1)));
        }
        print(mm);
        System.out.print("Enter the number of processes you want to enter: ");
        t = sc.nextInt();
        while (t-- > 0) {
            int p, id;
            System.out.print("\nEnter the process id and size: ");
            id = sc.nextInt();
            p = sc.nextInt();
            if (p > bsize) {
                System.out.println("\nProcess is larger than block size......");
            }
            else if (x >= part) {
                System.out.println("ALL Blocks are filled.....\nWait......");
            }
            else {
                mm.get(x++).set(1, id);
                internal_fragment += bsize - p;
                print(mm);
            }
        }
        System.out.println("\nTotal Internal fragmentation: " + internal_fragment + " MB");
    }
    public static void unequal_partion() {
        int t, internal_fragment = 0, part;
        System.out.print("Enter the total no. of partitions:");
        part = sc.nextInt();
        List<List<Integer>> mm = new ArrayList<List<Integer>>();
        for (int i = 0; i < part; i++) {
            mm.add(new ArrayList<Integer>());
            System.out.print("Enter the size of block " + i + " (MB):");
            mm.get(i).add(sc.nextInt());
            mm.get(i).add(-1);
            mm.get(i).add(1);
        }
        print(mm);
        System.out.print("Enter the number of processes you want to enter:");
        t = sc.nextInt();
        while (t-- > 0) {
            int p, id;
            System.out.print("\nEnter the process id and size:");
            id = sc.nextInt();
            p = sc.nextInt();
            if (p > mm.get(part - 1).get(0)) {
                System.out.println("\nProcess is larger than largest block size......");
            } else {
                int i;
                for (i = 0; i < part; i++) {
                    if (mm.get(i).get(2) == 1 && p <= mm.get(i).get(0)) {
                        mm.get(i).set(1, id);
                        mm.get(i).set(2, 0);
                        internal_fragment += mm.get(i).get(0) - p;
                        print(mm);
                        break;
                    }
                }
                if (i == part) {
                    System.out.println("No blocks are available.....\nWait......");
                }
            }
        }
        System.out.println("\nTotal Internal fragmentation: " + internal_fragment + " MB");
    }
    public static void main(String[] args) {
        int memsize, ch;
        System.out.print("Enter the total size of main memory(MB):");
        memsize = sc.nextInt();
        System.out.println("\n1.EQUAL PARTITIONS\n2.UNEQUAL PARTITIONS\nEnter the choice:");
        ch = sc.nextInt();
        switch (ch) {
            case 1:
                equal_partition(memsize);
                break;
            case 2:
                unequal_partion();
                break;
            default:
                System.out.println("\nINVALID OPTION....");
                break;
        }
    }   
}
