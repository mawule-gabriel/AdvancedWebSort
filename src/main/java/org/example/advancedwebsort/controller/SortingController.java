package org.example.advancedwebsort.controller;

import org.example.advancedwebsort.dto.SortingLogDTO;
import org.example.advancedwebsort.dto.SortingDataDto;
import org.example.advancedwebsort.service.HeapSortService;
import org.example.advancedwebsort.service.MergeSortService;
import org.example.advancedwebsort.service.QuickSortService;
import org.example.advancedwebsort.service.RadixSortService;
import org.example.advancedwebsort.service.BucketSortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for handling sorting operations using various algorithms.
 */
@RestController
@RequestMapping("/api/sort")
public class SortingController {

    @Autowired
    private QuickSortService quickSortService;

    @Autowired
    private HeapSortService heapSortService;

    @Autowired
    private MergeSortService mergeSortService;

    @Autowired
    private RadixSortService radixSortService;

    @Autowired
    private BucketSortService bucketSortService;

    /**
     * Sorts the provided data using Bucket Sort algorithm.
     *
     * @param sortingDataDto the sorting data DTO containing the data to be sorted.
     * @return a SortingLogDTO with sorting results and logs.
     */
    @PostMapping("/bucketSort")
    public SortingLogDTO bucketSort(@RequestBody SortingDataDto sortingDataDto) {
        return bucketSortService.sort(sortingDataDto.getData());
    }

    /**
     * Sorts the provided data using Heap Sort algorithm.
     *
     * @param sortingDataDto the sorting data DTO containing the data to be sorted.
     * @return a SortingLogDTO with sorting results and logs.
     */
    @PostMapping("/heapSort")
    public SortingLogDTO heapSort(@RequestBody SortingDataDto sortingDataDto) {
        return heapSortService.sort(sortingDataDto.getData());
    }

    /**
     * Sorts the provided data using Quick Sort algorithm.
     *
     * @param sortingDataDto the sorting data DTO containing the data to be sorted.
     * @return a SortingLogDTO with sorting results and logs.
     */
    @PostMapping("/quickSort")
    public SortingLogDTO quickSort(@RequestBody SortingDataDto sortingDataDto) {
        return quickSortService.sort(sortingDataDto.getData());
    }

    /**
     * Sorts the provided data using Merge Sort algorithm.
     *
     * @param sortingDataDto the sorting data DTO containing the data to be sorted.
     * @return a SortingLogDTO with sorting results and logs.
     */
    @PostMapping("/mergeSort")
    public SortingLogDTO mergeSort(@RequestBody SortingDataDto sortingDataDto) {
        return mergeSortService.sort(sortingDataDto.getData());
    }

    /**
     * Sorts the provided data using Radix Sort algorithm.
     *
     * @param sortingDataDto the sorting data DTO containing the data to be sorted.
     * @return a SortingLogDTO with sorting results and logs.
     */
    @PostMapping("/radixSort")
    public SortingLogDTO radixSort(@RequestBody SortingDataDto sortingDataDto) {
        return radixSortService.sort(sortingDataDto.getData());
    }
}
