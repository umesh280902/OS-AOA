import java.util.*;;
public class WorstFit {
    static int n;
    static Scanner sc = new Scanner(System.in);
    static class information {
        int id, memory, status, process;
        information(int id, int memory, int status, int process) {
            this.id = id;
            this.memory = memory;
            this.status = status;
            this.process = process;
        }
    }
    static int m;
    static information info[];
    static void print(information info[]) {
        System.out.println("Sr.No\tMemory\tStatus\tProcess");
        for (int i = 0; i < n; i++) {
            System.out.println(info[i].id + "\t" + info[i].memory + "\t" + info[i].status + "\t" + info[i].process);
        }
    }
    static void worstfit() {
        System.out.println("Enter the process id:");
        int id = sc.nextInt();
        System.out.println("Enter the size of the process:");
        int size = sc.nextInt();
        int worst = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < n; i++) {
            if (size <= info[i].memory && info[i].status == 1 && worst < info[i].memory) {
                worst = info[i].memory;
                index = i;
            }
        }
        if (index == -1) {
            System.out.println("Process must wait");
        } else {
            info[index].memory -= size;
            info[index].process = id;
            //info[index].status = 0;
            print(info);
        }
    }
    public static void main(String args[]) {
        System.out.println("Enter the number of blocks:");
        n = sc.nextInt();
        info = new information[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the memory size:");
            info[i] = new information(i + 1, sc.nextInt(), 0, 0);
            System.out.println("Is free(1)/Not free(0):");
            info[i].status = sc.nextInt();
            if (info[i].status == 0) {
                System.out.println("Allocated process id:");
                info[i].process = sc.nextInt();
            } else {
                info[i].process = -1;
            }
        }
        print(info);
        System.out.println("Enter the no of waiting process:");
        m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            worstfit();
        }
    }    
}
