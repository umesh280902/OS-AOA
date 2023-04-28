#include <stdio.h>
#include <string.h>

char target[30], pattern[30], text[30];

void LPS(char pattern[], int lps[]) {
    int len = 0;
    lps[0] = 0;
    int i = 1;
    int m = strlen(pattern);
    while (i < m) {
        if (pattern[i] == pattern[len]) {
            len++;
            lps[i] = len;
            i++;
        } else {
            if (len != 0) {
                len = lps[len - 1];
            } else {
                lps[i] = 0;
                i++;
            }
        }
    }
}

void search(char target[], char pattern[]) {
    int n = strlen(target);
    int m = strlen(pattern);
    int i = 0, j = 0;
    int lps[m];
    LPS(pattern, lps);
    while (i < n) {
        if (pattern[j] == target[i]) {
            i++;
            j++;
        }
        if (j == m) {
            printf("Pattern found at index %d\n", i - j);
            j = lps[j - 1];
        } else if (i < n && pattern[j] != target[i]) {
            if (j != 0) {
                j = lps[j - 1];
            } else {
                i++;
            }
        }
    }
}

int main() {
    printf("Enter the target string: ");
    scanf("%s", target);
    printf("Enter the pattern string: ");
    scanf("%s", pattern);
    search(target, pattern);
    return 0;
}
