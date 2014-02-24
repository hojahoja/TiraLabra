package sortingdemo.mainElem;

/**
 * This class handles the Quicksort operations.
 *
 * @author juri
 */
public class QuickSort implements SortingAlgorithm {

    /**
     * The array to be sorted.
     *
     */
    private Integer[] sortTarget;

    public QuickSort() {
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
        this.sort(0, sortTarget.length - 1);
    }

    /**
     * Splits the handling the array recursively into two with a splitPoint
     * generated in the partition algorithm
     *
     * @param low
     * @param high
     */
    public void sort(int low, int high) {
        if (low < high) {
            int splitPoint = partition(low, high);
            sort(low, splitPoint);
            sort(splitPoint + 1, high);
        }

    }

    /**
     * Sorts the integers by comparing values to the given pivot and swapping
     * them around as needed. Stops right and left pointers meet and creates a
     * split point in that Index
     *
     * @param low index
     * @param high index
     * @return The split point.
     */
    public int partition(int low, int high) {
        int pivot = sortTarget[low];
        int i = low - 1;
        int j = high + 1;
        while (i < j) {
            while (true) {
                j--;

                if (sortTarget[j] <= pivot) {
                    break;
                }
            }
            while (true) {
                i++;

                if (sortTarget[i] >= pivot) {
                    break;
                }
            }

            if (i < j) {
                swap(i, j);
            }
        }
        return j;
    }

    /**
     * Swaps the position of index1 and index2 inside the array.
     *
     * @param index1
     * @param index2
     */
    private void swap(int index1, int index2) {
        int temp = sortTarget[index1];
        sortTarget[index1] = sortTarget[index2];
        sortTarget[index2] = temp;
    }

    public Integer[] getSortTarget() {
        return sortTarget;
    }

    public String toString() {
        return "QuickSort";
    }
}
