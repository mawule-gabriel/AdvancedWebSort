package org.example.advancedwebsort.service;

import org.example.advancedwebsort.dto.SortingLogDTO;
import org.springframework.stereotype.Service;

/**
 * Service for performing Radix Sort on an array of integers.
 * Returns a SortingLogDTO containing the input data, sorted data, algorithm name, and execution time.
 */
@Service
public class RadixSortService {

    /**
     * Sorts the given data using the Radix Sort algorithm.
     *
     * @param data the array of integers to sort.
     * @return a SortingLogDTO containing the input data, sorted data, algorithm name, and execution time.
     */
    public SortingLogDTO sort(int[] data) {
        long startTime = System.nanoTime();
        radixSort(data);
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        return new SortingLogDTO(data, data, "RadixSort", executionTime);
    }

    /**
     * Performs Radix Sort on the array of data.
     * This method processes the data by sorting it based on individual digits from least significant to most significant.
     *
     * @param data the array to be sorted.
     */
    private void radixSort(int[] data) {
        int max = getMax(data);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(data, exp);
        }
    }

    /**
     * Finds the maximum value in the array.
     *
     * @param data the array to check for the maximum value.
     * @return the maximum value in the array.
     */
    private int getMax(int[] data) {
        int max = data[0];
        for (int i = 1; i < data.length; i++) {
            if (data[i] > max) {
                max = data[i];
            }
        }
        return max;
    }

    /**
     * Performs Counting Sort on the array based on the digit represented by exp (1s, 10s, 100s, etc.).
     *
     * @param data the array to be sorted.
     * @param exp the current digit (1s, 10s, etc.).
     */
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