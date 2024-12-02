package org.example.advancedwebsort.service;

import org.example.advancedwebsort.dto.SortingLogDTO;
import org.springframework.stereotype.Service;

@Service
public class RadixSortService {

    public SortingLogDTO sort(int[] data) {
        long startTime = System.nanoTime();
        radixSort(data);
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        return new SortingLogDTO(data, data, "RadixSort", executionTime);
    }

    private void radixSort(int[] data) {
        int max = getMax(data);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(data, exp);
        }
    }

    private int getMax(int[] data) {
        int max = data[0];
        for (int i = 1; i < data.length; i++) {
            if (data[i] > max) {
                max = data[i];
            }
        }
        return max;
    }

    private void countingSort(int[] data, int exp) {
        int n = data.length;
        int[] output = new int[n];
        int[] count = new int[10];

        for (int i = 0; i < n; i++) {
            count[(data[i] / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            output[count[(data[i] / exp) % 10] - 1] = data[i];
            count[(data[i] / exp) % 10]--;
        }

        System.arraycopy(output, 0, data, 0, n);
    }
}