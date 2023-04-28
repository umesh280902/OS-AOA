#include <stdio.h>

#define PAGE_SIZE 1024
#define MEMORY_SIZE 1024

int main() {
    int n_pages, page_table[MEMORY_SIZE/PAGE_SIZE], n_processes, process_size;
    int offset_mask = PAGE_SIZE - 1;
    int page_number_mask = ~(offset_mask);

    printf("Enter number of pages: ");
    scanf("%d", &n_pages);

    printf("Enter page table:\n");
    for (int i = 0; i < n_pages; i++) {
        scanf("%d", &page_table[i]);
    }

    printf("Enter process size: ");
    scanf("%d", &process_size);

    int n_frames = MEMORY_SIZE/PAGE_SIZE;
    int frames[n_frames];

    for (int i = 0; i < n_frames; i++) {
        frames[i] = -1;
    }

    int n_misses = 0, n_hits = 0;

    for (int i = 0; i < process_size; i++) {
        int address;
        printf("\nEnter virtual address: ");
        scanf("%d", &address);

        int page_number = (address & page_number_mask) / PAGE_SIZE;
        int offset = address & offset_mask;

        if (page_table[page_number] == -1) {
            n_misses++;

            for (int j = 0; j < n_frames; j++) {
                if (frames[j] == -1) {
                    frames[j] = page_number;
                    page_table[page_number] = j;
                    break;
                }
            }
        } else {
            n_hits++;
        }

        int physical_address = (page_table[page_number] * PAGE_SIZE) + offset;
        printf("Physical address: %d\n", physical_address);
    }

    printf("\nHits: %d, Misses: %d, Hit rate: %.2f\n", n_hits, n_misses, (float)n_hits/(n_hits+n_misses));

 return 0;
}