package sortingdemo.mainElem;

/**
 * This class handles the Heap-Sort operations.
 *
 * @author juri
 */
public class HeapSort implements SortingAlgorithm {

    /**
     * The array to be sorted. Used as the heap structure.
     *
     */
    private Integer[] sortTarget;
    // These integers are used by the heap methods to implement the heap inside this class
    private int heapSize;
    private int left;
    private int right;
    private int largest;

    public HeapSort() {
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
     * This method starts the sorting algorithm. Swaps the position of the first and the last integers
     * according to "heapSize". Uses decreasing heapSize with the heapify() method
     * to eventually sort the whole array.
     *
     */
    public void sort() {
        buildheap();

        for (int i = heapSize; i > 0; i--) {
            swap(0, i);
            heapSize--;
            heapify(0);
        }
    }

    /**
     * Turns the array into a maximum heap by setting up the heapSize value and 
     * heapifying the array from it's middle index to it's first.
     * 
     */
    private void buildheap() {
        heapSize = sortTarget.length - 1;
        for (int i = heapSize / 2; i >= 0; i--) {
            heapify(i);
        }
    }

    /**
     * Used to keep the array as a heap.
     * 
     * @param i index
     */
    private void heapify(int i) {
        left = 2 * i; // left child of the index
        right = 2 * i + 1; // right child of the index
        if (left <= heapSize && sortTarget[left] > sortTarget[i]) {
            largest = left;
        } else {
            largest = i;
        }

        if (right <= heapSize && sortTarget[right] > sortTarget[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(i, largest);
            heapify(largest);
        }
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
        return "HeapSort";
    }
}
