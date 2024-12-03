package org.example.advancedwebsort.controller;

import org.example.advancedwebsort.dto.SortingLogDTO;
import org.example.advancedwebsort.service.HeapSortService;
import org.example.advancedwebsort.service.MergeSortService;
import org.example.advancedwebsort.service.QuickSortService;
import org.example.advancedwebsort.service.RadixSortService;
import org.example.advancedwebsort.service.BucketSortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Controller for handling user requests related to sorting operations.
 * Displays sorting page and processes sorting based on selected algorithm.
 */
@Controller
public class ViewController {

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
     * Displays the sorting page.
     *
     * @return the name of the view (sort.jsp).
     */
    @GetMapping("/sort")
    public String sortPage() {
        return "sort";
    }

    /**
     * Executes the selected sorting algorithm and adds the result to the model.
     *
     * @param algorithm the name of the sorting algorithm to use.
     * @param data the input data (comma-separated values) to be sorted.
     * @param model the Spring model to add attributes for rendering.
     * @return the name of the view (sort.jsp) with the sorting result.
     */
    @PostMapping("/sort")
    public String executeSorting(@RequestParam String algorithm, @RequestParam String data, Model model) {
        // Convert input string to an integer array
        int[] inputData = parseData(data);

        SortingLogDTO result = null;

        // Perform sorting based on the selected algorithm
        switch (algorithm) {
            case "quickSort":
                result = quickSortService.sort(inputData);
                break;
            case "mergeSort":
                result = mergeSortService.sort(inputData);
                break;
            case "heapSort":
                result = heapSortService.sort(inputData);
                break;
            case "radixSort":
                result = radixSortService.sort(inputData);
                break;
            case "bucketSort":
                result = bucketSortService.sort(inputData);
                break;
            default:
                break;
        }

        // Add the sorting result to the model for rendering
        model.addAttribute("sortingResult", result);

        // Return the view name (sort.jsp)
        return "sort";
    }

    /**
     * Helper method to parse the input data string into an integer array.
     *
     * @param data the input data as a comma-separated string.
     * @return an array of integers parsed from the input string.
     */
    private int[] parseData(String data) {
        String[] dataArray = data.split(",");
        int[] result = new int[dataArray.length];
        for (int i = 0; i < dataArray.length; i++) {
            result[i] = Integer.parseInt(dataArray[i].trim());
        }
        return result;
    }
}
