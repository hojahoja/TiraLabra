package sortingdemo.mainElem;

import java.util.Arrays;

/**
 * This class handles the merge sort operations.
 *
 * @author juri
 */
public class MergeSort implements SortingAlgorithm {

    /**
     * The array to be sorted.
     *
     */
    private Integer[] sortTarget;

    public MergeSort() {
        this.sortTarget = new Integer[0];
    }

    /**
     * Clones a target array so that the same values can be used by multiple
     * algorithms
     *
     * @param sortTarget
     */
    public void insertArray(Integer[] sortTarget) {
        this.sortTarget = sortTarget.clone();
    }

    /**
     * This method starts the sorting algorithm.
     */
    public void sort() {
        sort(1, sortTarget.length);
    }

    /**
     * This is the recursive call of mergesort which is used to split values
     * into two different parts. Afterwards they are sorted with the merge
     * method
     *
     * @param low the lowest index
     * @param high the highest index
     */
    public void sort(int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            sort(low, mid);
            sort(mid + 1, high);
            merge(low, mid, high);
        }
    }

    /**
     * The main sorting is done here.
     *
     * @param low index
     * @param mid index
     * @param high index
     */
    private void merge(int low, int mid, int high) {
        // The first part creates two extra arrays which contain the values from the current given low-high range split by the mid index
        int n1 = mid - low + 1;
        int n2 = high - mid;
        int[] left = new int[n1 + 1];
        int[] right = new int[n2 + 1];
        for (int i = 0; i < n1; i++) {
            left[i] = sortTarget[low + i - 1];
        }
        left[n1] = 101;
        for (int i = 0; i < n2; i++) {
            right[i] = sortTarget[mid + i];
        }
        right[n2] = 101;

        // This portion compares the two arrays and inserts the smaller of the two integers in to the main array.
        // Runs until all of the comparisons are done.
        int i = 0;
        int j = 0;
        for (int k = low - 1; k < high; k++) {
            if (left[i] <= right[j]) {
                sortTarget[k] = left[i];
                i++;
            } else {
                sortTarget[k] = right[j];
                j++;
            }
        }
    }

    public Integer[] getSortTarget() {
        return sortTarget;
    }

    public String toString() {
        return "MergeSort";
    }
}
