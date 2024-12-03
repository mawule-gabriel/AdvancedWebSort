package org.example.advancedwebsort.model;

/**
 * Represents the result of a sorting operation.
 * Contains the sorted data, the sorting algorithm used, and the execution time.
 */
public class SortingData {


    private int[] sortedData; // The sorted data
    private String algorithmName; // The algorithm used for sorting
    private long executionTime; // The time taken for the sorting operation


    /**
     * Constructor to initialize the sorting result with sorted data, algorithm name, and execution time.
     *
     * @param sortedData the sorted data.
     * @param algorithmName the sorting algorithm used.
     * @param executionTime the time taken for the sorting operation.
     */
    public SortingData(int[] sortedData, String algorithmName, long executionTime) {
        this.sortedData = sortedData;
        this.algorithmName = algorithmName;
        this.executionTime = executionTime;
    }

    /**
     * Gets the sorted data.
     *
     * @return the sorted data.
     */
    public int[] getSortedData() {
        return sortedData;
    }

    /**
     * Sets the sorted data.
     *
     * @param sortedData the sorted data.
     */
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

    /**
     * Sets the time taken for the sorting operation.
     *
     * @param executionTime the execution time in milliseconds.
     */
    public void setExecutionTime(long executionTime) {
        this.executionTime = executionTime;
    }

    /**
     * Provides a string representation of the sorting result.
     *
     * @return a string representation of the sorting result.
     */
    @Override
    public String toString() {
        return "SortingResponse{" +
                "sortedData=" + arrayToString(sortedData) +
                ", algorithmName='" + algorithmName + '\'' +
                ", executionTime=" + executionTime +
                '}';
    }


    /**
     * Converts an integer array to a string representation.
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
