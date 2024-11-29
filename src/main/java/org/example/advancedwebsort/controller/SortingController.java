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

    @PostMapping("/bucketSort")
    public SortingLogDTO bucketSort(@RequestBody SortingDataDto sortingDataDto) {
        return bucketSortService.sort(sortingDataDto.getData());
    }

    @PostMapping("/heapSort")
    public SortingLogDTO heapSort(@RequestBody SortingDataDto sortingDataDto) {
        return heapSortService.sort(sortingDataDto.getData());
    }

    @PostMapping("/quickSort")
    public SortingLogDTO quickSort(@RequestBody SortingDataDto sortingDataDto) {
        return quickSortService.sort(sortingDataDto.getData());
    }

    @PostMapping("/mergeSort")
    public SortingLogDTO mergeSort(@RequestBody SortingDataDto sortingDataDto) {
        return mergeSortService.sort(sortingDataDto.getData());
    }

    @PostMapping("/radixSort")
    public SortingLogDTO radixSort(@RequestBody SortingDataDto sortingDataDto) {
        return radixSortService.sort(sortingDataDto.getData());
    }
}