package org.example.advancedwebsort.service;

import org.example.advancedwebsort.dto.SortingLogDTO;
import org.springframework.stereotype.Service;

/**
 * Service for performing Quick Sort on an array of integers.
 * Returns a SortingLogDTO containing the input data, sorted data, algorithm name, and execution time.
 */
@Service
public class QuickSortService {

    /**
     * Sorts the given data using the Quick Sort algorithm.
     *
     * @param data the array of integers to sort.
     * @return a SortingLogDTO containing the input data, sorted data, algorithm name, and execution time.
     */
    public SortingLogDTO sort(int[] data) {
        long startTime = System.nanoTime();
        quickSort(data, 0, data.length - 1);
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        return new SortingLogDTO(data, data, "QuickSort", executionTime);
    }

    /**
     * Recursively divides the array and applies Quick Sort on subarrays.
     *
     * @param data the array to be sorted.
     * @param low the starting index of the subarray.
     * @param high the ending index of the subarray.
     */
    private void quickSort(int[] data, int low, int high) {
        if (low < high) {
            int pi = partition(data, low, high);
            quickSort(data, low, pi - 1);
            quickSort(data, pi + 1, high);
        }
    }

    /**
     * Partitions the array by selecting a pivot and arranging the elements such that
     * elements less than the pivot are on the left, and elements greater than the pivot are on the right.
     *
     * @param data the array to partition.
     * @param low the starting index of the subarray.
     * @param high the ending index of the subarray.
     * @return the index of the pivot element after partitioning.
     */
    private int partition(int[] data, int low, int high) {
        int pivot = data[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (data[j] < pivot) {
                i++;
                int temp = data[i];
                data[i] = data[j];
                data[j] = temp;
            }
        }
        int temp = data[i + 1];
        data[i + 1] = data[high];
        data[high] = temp;
        return i + 1;
    }
}