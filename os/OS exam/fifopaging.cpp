#include <bits/stdc++.h>
using namespace std;

int n, f, r[100], miss = 0;

bool ishit(int frame[], int p) {
    for (int i = 0; i < f; i++) {
        if (frame[i] == p) {
            return true;
        }
    }
    return false;
}

void fifo() {
    int frame[f];
    int k = 0;
    cout << "\n---------------\nPage\tFrame\n---------------";
    for (int i = 0; i < n; i++) {
        cout << "\n" << r[i] << " ---> ";
        if (!ishit(frame, r[i])) {
            miss++;
            frame[k] = r[i];
            k = (k + 1) % f;
            if (i < f) {
                for (int j = 0; j <= i; j++) {
                    cout << frame[j] << " ";
                }
            } else {
                for (int j = 0; j < f; j++) {
                    cout << frame[j] << " ";
                }
            }
        }
    }
    cout << "\n\nHit ratio:" << setprecision(2) << (float)(n - miss) / n;
    cout << "\nMiss ratio:" << setprecision(2) << (float)(miss) / n;
}

int main() {
    cout << "Enter the length of reference string:";
    cin >> n;
    cout << "Enter the reference string:";
    for (int i = 0; i < n; i++) {
        cin >> r[i];
    }
    cout << "Enter the no. of frame:";
    cin >> f;
    fifo();
}
