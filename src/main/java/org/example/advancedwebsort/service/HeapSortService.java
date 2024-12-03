package org.example.advancedwebsort.service;

import org.example.advancedwebsort.dto.SortingLogDTO;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * Service for performing Heap Sort on an array of integers.
 * Returns a SortingLogDTO containing input data, sorted data, algorithm name, and execution time.
 */
@Service
public class HeapSortService {

    /**
     * Sorts the given data using the Heap Sort algorithm.
     *
     * @param data the array of integers to sort.
     * @return a SortingLogDTO containing the input data, sorted data, algorithm name, and execution time.
     */
    public SortingLogDTO sort(int[] data) {
        // Create a copy of the input data
        int[] originalData = Arrays.copyOf(data, data.length);

        long startTime = System.nanoTime();
        heapSort(data);  // Sort the data in-place
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;


        return new SortingLogDTO(originalData, data, "HeapSort", executionTime);
    }

    /**
     * Performs the Heap Sort algorithm on the given array.
     *
     * @param data the array to be sorted.
     */
    private void heapSort(int[] data) {
        int n = data.length;

        // Build the heap (rearrange the array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(data, n, i);
        }

        // One by one extract elements from heap
        for (int i = n - 1; i >= 0; i--) {
            // Move current root to end
            int temp = data[0];
            data[0] = data[i];
            data[i] = temp;

            // Call heapify on the reduced heap
            heapify(data, i, 0);
        }
    }

    /**
     * Maintains the heap property for a subtree rooted at index i.
     *
     * @param data the array representing the heap.
     * @param n the size of the heap.
     * @param i the index of the root node of the subtree.
     */
    private void heapify(int[] data, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && data[left] > data[largest]) {
            largest = left;
        }
        if (right < n && data[right] > data[largest]) {
            largest = right;
        }
        if (largest != i) {
            int temp = data[i];
            data[i] = data[largest];
            data[largest] = temp;
            heapify(data, n, largest);
        }
    }
}
