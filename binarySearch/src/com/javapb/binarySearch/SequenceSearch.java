package com.javapb.binarySearch;

public class SequenceSearch {
    private Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    public Integer getPoint(Integer l, Integer r) {

        if (r >= l) {
            int mid = l + (r - l) / 2;
            if (mid == arr.length - 1 || mid == 0) {
                return -1;
            }
            if (arr[mid] >= arr[mid - 1] && arr[mid] > arr[mid + 1])
                return arr[mid];

            if (arr[mid] < arr[l])
                return getPoint(l, mid - 1);

            return getPoint(mid + 1, r);
        }
        return -1;

    }

    public Integer getArrayDimension() {
        return arr.length - 1;
    }
}
