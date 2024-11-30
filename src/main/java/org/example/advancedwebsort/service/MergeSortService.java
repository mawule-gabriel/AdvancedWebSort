package org.example.advancedwebsort.service;

import org.example.advancedwebsort.dto.SortingLogDTO;
import org.springframework.stereotype.Service;

@Service
public class MergeSortService {

    public SortingLogDTO sort(int[] data) {
        long startTime = System.nanoTime();
        mergeSort(data, 0, data.length - 1);
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        return new SortingLogDTO(data, data, "MergeSort", executionTime);
    }

    private void mergeSort(int[] data, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(data, left, mid);
            mergeSort(data, mid + 1, right);
            merge(data, left, mid, right);
        }
    }

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
        while (i < n1) {
            data[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < n2) {
            data[k] = rightArray[j];
            j++;
            k++;
        }
    }
}