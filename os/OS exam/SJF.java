import java.util.*;

public class SJF {
    static class Process {
        int id, arrival, burst, completion;
        Process(int id, int arrival, int burst) {
            this.id = id;
            this.arrival = arrival;
            this.burst = burst;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of processes: ");
        int n = sc.nextInt();
        Process[] processes = new Process[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter arrival time for process " + (i + 1) + ": ");
            int arrival = sc.nextInt();
            System.out.print("Enter burst time for process " + (i + 1) + ": ");
            int burst = sc.nextInt();
            processes[i] = new Process(i + 1, arrival, burst);
        }
        sc.close();

        // Sort the processes by arrival time
        Arrays.sort(processes, Comparator.comparingInt(p -> p.arrival));

        // Run the SJF algorithm
        int time = 0;
        float turn = 0, wait = 0;
        System.out.println("Process Arrival Burst Completion Turn Wait");
        for (Process process : processes) {
            process.completion = time + process.burst;
            time = process.completion;
            System.out.println(process.id + "\t" + process.arrival + "\t" + process.burst + "\t" + process.completion + "\t" + (process.completion - process.arrival) + "\t" + (process.completion - process.arrival - process.burst));
            turn += process.completion - process.arrival;
            wait += process.completion - process.arrival - process.burst;
        }
        System.out.println("Average turnaround time = " + turn / n);
        System.out.println("Average waiting time = " + wait / n);
    }
}
