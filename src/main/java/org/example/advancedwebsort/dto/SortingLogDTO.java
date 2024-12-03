package org.example.advancedwebsort.dto;

/**
 * Data Transfer Object (DTO) for logging the details of a sorting operation.
 * Contains the input data, sorted data, algorithm name, and execution time.
 */
public class SortingLogDTO {

    private int[] inputData;  // The input data before sorting
    private int[] sortedData;  // The sorted data after sorting
    private String algorithmName;  // Name of the sorting algorithm
    private long executionTime;  // Time taken for the sorting operation

    /**
     * Constructor to initialize the sorting log with input data, sorted data, algorithm name, and execution time.
     *
     * @param inputData the input data before sorting.
     * @param sortedData the sorted data after sorting.
     * @param algorithmName the name of the sorting algorithm used.
     * @param executionTime the time taken to perform the sorting.
     */
    public SortingLogDTO(int[] inputData, int[] sortedData, String algorithmName, long executionTime) {
        this.inputData = inputData;
        this.sortedData = sortedData;
        this.algorithmName = algorithmName;
        this.executionTime = executionTime;
    }

    /**
     * Gets the input data before sorting.
     *
     * @return the input data.
     */
    public int[] getInputData() {
        return inputData;
    }

    /**
     * Sets the input data before sorting.
     *
     * @param inputData the input data.
     */
    public void setInputData(int[] inputData) {
        this.inputData = inputData;
    }

    public int[] getSortedData() {
        return sortedData;
    }

    public void setSortedData(int[] sortedData) {
        this.sortedData = sortedData;
    }

    public String getAlgorithmName() {
        return algorithmName;
    }

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }

    public long getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(long executionTime) {
        this.executionTime = executionTime;
    }

    /**
     * Provides a string representation of the SortingLogDTO object.
     *
     * @return a string representation of the sorting log.
     */
    @Override
    public String toString() {
        return "SortingLogDTO{" +
                "inputData=" + arrayToString(inputData) +
                ", sortedData=" + arrayToString(sortedData) +
                ", algorithmName='" + algorithmName + '\'' +
                ", executionTime=" + executionTime +
                '}';
    }

    /**
     * Converts an integer array to a string.
     *
     * @param array the integer array to convert.
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
