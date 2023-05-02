import java.util.*;

public class RoundRobin {
    static Scanner sc = new Scanner(System.in);
    static int n, quantum_time = Integer.MAX_VALUE;

    static class Process {
        int id, a, b, c, rem;

        Process(int id, int a, int b, int c, int rem) {
            this.id = id;
            this.a = a;
            this.b = b;
            this.c = c;
            this.rem = rem;
        }
    }

    static Process p[];

    static void sort() {
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (p[i].a > p[j].a) {
                    Process temp = p[i];
                    p[i] = p[j];
                    p[j] = temp;
                }
            }
        }
    }

    static void roundrobin() {
        sort();
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        int time = 0, i, pointer = 1;
        while (!q.isEmpty()) {
            i = q.remove();
            if (p[i].rem == quantum_time) {
                time += quantum_time;
                p[i].rem = 0;
                p[i].c = time;
            } else if (p[i].rem < quantum_time) {
                time += p[i].rem;
                p[i].rem = 0;
                p[i].c = time;
            } else {
                time += quantum_time;
                p[i].rem -= quantum_time;
                while (pointer < n && p[pointer].a <= time) {
                    q.add(pointer++);
                }
                q.add(i);
            }
        }
        float turn = 0, wait = 0;
        System.out.println("\nProcess\tArrival\tBurst\tComp\tTurn\tWait\n");
        for (int j = 0; j < n; j++) {
            System.out.println((p[j].id + 1) + "\t" + p[j].a + "\t" + p[j].b + "\t" + p[j].c + "\t" + (p[j].c - p[j].a) + "\t" + (p[j].c - p[j].a - p[j].b));
            turn += p[j].c - p[j].a;
            wait += p[j].c - p[j].a - p[j].b;
        }
        System.out.println("\nAvg Turnaround time:" + turn / n + "\nAvg Waiting time:" + wait / n);
    }

    public static void main(String args[]) {
        System.out.println("Enter the number of process:");
        n = sc.nextInt();
        p = new Process[n];
        System.out.print("Enter the arrival time of all process:");
        for (int i = 0; i < n; i++) {
            p[i] = new Process(i, sc.nextInt(), 0, 0, 0);
        }
        System.out.print("Enter the burst time of all process:");
        for (int i = 0; i < n; i++) {
            p[i].b = sc.nextInt();
            p[i].rem = p[i].b;
        }
        System.out.println("Enter time slice of process:");
        quantum_time = sc.nextInt();
        roundrobin();
    }
}
