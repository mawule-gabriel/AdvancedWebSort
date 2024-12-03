package org.example.advancedwebsort.service;

import org.example.advancedwebsort.dto.SortingLogDTO;
import org.springframework.stereotype.Service;

/**
 * Service for performing Merge Sort on an array of integers.
 * Returns a SortingLogDTO containing the input data, sorted data, algorithm name, and execution time.
 */
@Service
public class MergeSortService {

    /**
     * Sorts the given data using the Merge Sort algorithm.
     *
     * @param data the array of integers to sort.
     * @return a SortingLogDTO containing the input data, sorted data, algorithm name, and execution time.
     */
    public SortingLogDTO sort(int[] data) {
        long startTime = System.nanoTime();
        mergeSort(data, 0, data.length - 1);
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        return new SortingLogDTO(data, data, "MergeSort", executionTime);
    }

    /**
     * Recursively splits the array and sorts it using the merge method.
     *
     * @param data the array to be sorted.
     * @param left the left index of the subarray.
     * @param right the right index of the subarray.
     */
    private void mergeSort(int[] data, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(data, left, mid);
            mergeSort(data, mid + 1, right);
            merge(data, left, mid, right);
        }
    }

    /**
     * Merges two sorted subarrays into a single sorted array.
     *
     * @param data the array containing the subarrays to merge.
     * @param left the left index of the subarray.
     * @param mid the middle index that divides the two subarrays.
     * @param right the right index of the subarray.
     */
    private void merge(int[] data, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];
        System.arraycopy(data, left, leftArray, 0, n1);
        System.arraycopy(data, mid + 1, rightArray, 0, n2);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                data[k] = leftArray[i];
                i++;
            } else {
                data[k] = rightArray[j];
                j++;
            }
            k++;
        }
        // Copy remaining elements of leftArray
        while (i < n1) {
            data[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy remaining elements of rightArray
        while (j < n2) {
            data[k] = rightArray[j];
            j++;
            k++;
        }
    }
}