package sortingdemo.mainElem;

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
        this.sortTarget = sortTarget;
    }
    
    
}
