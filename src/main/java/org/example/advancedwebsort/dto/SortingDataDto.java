package org.example.advancedwebsort.dto;

/**
 * Data Transfer Object (DTO) for holding an array of integers to be sorted.
 */
public class SortingDataDto {

    private int[] data;

    /**
     * Gets the array of integers to be sorted.
     *
     * @return the array of integers.
     */
    public int[] getData() {
        return data;
    }

    /**
     * Sets the array of integers to be sorted.
     *
     * @param data the array of integers.
     */
    public void setData(int[] data) {
        this.data = data;
    }
}
