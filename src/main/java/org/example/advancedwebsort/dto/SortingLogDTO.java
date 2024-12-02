package org.example.advancedwebsort.dto;

public class SortingLogDTO {

    private int[] inputData;  // The input data before sorting
    private int[] sortedData;  // The sorted data after sorting
    private String algorithmName;  // Name of the sorting algorithm
    private long executionTime;  // Time taken for the sorting operation

    // Constructor
    public SortingLogDTO(int[] inputData, int[] sortedData, String algorithmName, long executionTime) {
        this.inputData = inputData;
        this.sortedData = sortedData;
        this.algorithmName = algorithmName;
        this.executionTime = executionTime;
    }

    // Getters and Setters
    public int[] getInputData() {
        return inputData;
    }

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

    @Override
    public String toString() {
        return "SortingLogDTO{" +
                "inputData=" + arrayToString(inputData) +
                ", sortedData=" + arrayToString(sortedData) +
                ", algorithmName='" + algorithmName + '\'' +
                ", executionTime=" + executionTime +
                '}';
    }

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
