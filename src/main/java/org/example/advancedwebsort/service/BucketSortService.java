package org.example.advancedwebsort.service;

import org.example.advancedwebsort.dto.SortingLogDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Service for performing Bucket Sort on an array of integers.
 * Logs the sorting process and returns a SortingLogDTO with input data, sorted data, algorithm name, and execution time.
 */
@Service
public class BucketSortService {

    private static final Logger logger = LoggerFactory.getLogger(BucketSortService.class);

    /**
     * Sorts the given data using the bucket sort algorithm.
     *
     * @param data the array of integers to sort.
     * @return a SortingLogDTO containing the input data, sorted data, algorithm name, and execution time.
     */
    public SortingLogDTO sort(int[] data) {
        long startTime = System.nanoTime();

        // Store the input data before sorting
        int[] inputData = data.clone();

        // Log the input data
        logger.debug("Input data: {}", arrayToString(inputData));

        // Perform the bucket sort
        bucketSort(data);

        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        // Log the sorted data and execution time
        logger.debug("Sorted data: {}", arrayToString(data));
        logger.debug("Execution time: {} nanoseconds", executionTime);

        // Return the SortingLogDTO which contains all the details
        return new SortingLogDTO(inputData, data, "Bucket Sort", executionTime);
    }

    /**
     * Performs bucket sort on the given data.
     *
     * @param data the array of integers to sort.
     */
    private void bucketSort(int[] data) {
        int n = data.length;
        if (n <= 0) return;

        int max = data[0], min = data[0];
        for (int i = 1; i < n; i++) {
            if (data[i] > max) max = data[i];
            if (data[i] < min) min = data[i];
        }

        int bucketCount = (max - min) / n + 1;
        List<List<Integer>> buckets = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            int index = (data[i] - min) / n;
            buckets.get(index).add(data[i]);
        }

        int index = 0;
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
            for (int num : bucket) {
                data[index++] = num;
            }
        }
    }

    /**
     * Converts an array of integers into a string for logging.
     *
     * @param array the array to convert.
     * @return a string representation of the array.
     */
    private String arrayToString(int[] array) {
        if (array == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}