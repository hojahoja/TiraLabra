package sortingdemo.mainElem;

/**
 * This class handles the Quicksort operations.
 *
 * @author juri
 */
public class QuickSort {

    private Integer[] sortTarget;

    public QuickSort() {
        this.sortTarget = new Integer[0];
    }

    public void insertArray(Integer[] sortTarget) {
        this.sortTarget = sortTarget.clone();
    }

    public void sort() {
        this.sort(0, sortTarget.length-1);
    }

    public void sort(int low, int high) {
        if (low < high) {
            int splitPoint = partition(low, high);
            sort(low, splitPoint);
            sort(splitPoint + 1, high);
        }
            
    }

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

    private void swap(int index1, int index2) {
        int temp = sortTarget[index1];
        sortTarget[index1] = sortTarget[index2];
        sortTarget[index2] = temp;
    }

    public Integer[] getSortTarget() {
        return sortTarget;
    }
}
