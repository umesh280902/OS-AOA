import java.util.*;

class SSTF {
public static void sstf(ArrayList<Integer> v, int head) {
int head_movement = 0, count = 1;
Set<Integer> s = new HashSet<>();
s.add(head);
for(int i : v) {
s.add(i);
}
Iterator<Integer> it = s.iterator();
while(!s.isEmpty()) {
System.out.println("STEP " + count++ + ": " + it.next());
if(s.size() == 1) {
break;
}
if(it == s.iterator()) {
Iterator<Integer> next = s.iterator();
next.next();
head_movement += Math.abs(it.next() - next.next());
it.remove();
it = next;
continue;
}
Iterator<Integer> prev = s.iterator();
prev.next();
prev.next();
Iterator<Integer> next = s.iterator();
next.next();
if(!next.hasNext()) {
head_movement += Math.abs(it.next() - prev.next());
it.remove();
it = prev;
continue;
}
if(Math.abs(prev.next() - it.next()) <= Math.abs(next.next() - it.next())) {
head_movement += Math.abs(prev.next() - it.next());
it.remove();
it = prev;
} else {
head_movement += Math.abs(next.next() - it.next());
it.remove();
it = next;
}
}
System.out.println("\nTotal head movement: " + head_movement);
}

public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
System.out.print("Enter the number of processes: ");
int n = sc.nextInt();
ArrayList<Integer> v = new ArrayList<>();
System.out.print("Enter the process track no.: ");
for(int i = 0; i < n; i++) {
v.add(sc.nextInt());
}
System.out.print("Enter the starting position of head: ");
int head = sc.nextInt();
System.out.println();
sstf(v,head);
}
}