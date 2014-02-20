package sortingdemo.mainElem;

import java.util.Arrays;

/**
 * This class handles the merge sort operations.
 *
 * @author juri
 */
public class MergeSort {

    private Integer[] sortTarget;

    public MergeSort() {
        this.sortTarget = new Integer[0];
    }

    public void insertArray(Integer[] sortTarget) {
        this.sortTarget = sortTarget.clone();
    }

    public void sort() {
        sort(1, sortTarget.length);
    }

    public void sort(int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            sort(low, mid);
            sort(mid + 1, high);
            merge(low, mid, high);
        }
    }

    private void merge(int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;
        int[] left = new int[n1 + 1];
        int[] right = new int[n2 + 1];
        for (int i = 0; i < n1; i++) {
            left[i] = sortTarget[low + i - 1];
        }
        left[n1] = Integer.MAX_VALUE / 2;
        for (int i = 0; i < n2; i++) {
            right[i] = sortTarget[mid + i];
        }
        right[n2] = Integer.MAX_VALUE / 2;
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
}
