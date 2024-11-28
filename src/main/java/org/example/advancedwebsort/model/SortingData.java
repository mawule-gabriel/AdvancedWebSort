package org.example.advancedwebsort.model;

public class SortingData {

    private int[] sortedData; // The sorted data
    private String algorithmName; // The algorithm used for sorting
    private long executionTime; // The time taken for the sorting operation

    // Constructor
    public SortingData(int[] sortedData, String algorithmName, long executionTime) {
        this.sortedData = sortedData;
        this.algorithmName = algorithmName;
        this.executionTime = executionTime;
    }

    // Getters and Setters
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
        return "SortingResponse{" +
                "sortedData=" + arrayToString(sortedData) +
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
