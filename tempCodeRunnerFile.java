import java.util.*;

class KMP {
    static void lps_func(String txt, int[] lps) {
        int len = 0;
        lps[0] = 0;
        int i = 1;
        while (i < txt.length()) {
            if (txt.charAt(i) == txt.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len == 0) {
                    lps[i] = 0;
                    i++;
                } else {
                    len = lps[len - 1];
                }
            }
        }
    }

    static void search(String p, String s) {
        int n = s.length();
        int m = p.length();
        int[] lps = new int[m];
        lps_func(p, lps);
        int i = 0, j = 0;
        while (i < n) {
            if (p.charAt(j) == s.charAt(i)) {
                i++;
                j++;
            }
            if (j == m) {
                System.out.println("String found at index: " + (i - m));
                j = lps[j - 1];
            } else if (i < n && p.charAt(j) != s.charAt(i)) {
                if (j == 0)
                    i++;
                else
                    j = lps[j - 1];
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the target string: ");
        String s = sc.next();
        System.out.print("Enter the pattern string: ");
        String p = sc.next();
        search(p, s);
        sc.close();
    }
}