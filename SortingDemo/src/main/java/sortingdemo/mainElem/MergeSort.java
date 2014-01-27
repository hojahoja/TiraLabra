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
    
    public void sort() {
        int length = 1;
        while (length < sortTarget.length) {            
            int start = 1;
            while (start + length <= sortTarget.length) {                
                int low = start;
                int mid = start+length;
                int high = Math.min(mid+length, sortTarget.length);
                merge(low, mid, high);
                start = start + 2 * length;
            }
            length = 2 * length;
        }
    }
    
    private void merge(int low, int mid, int high) {
        
    }
    
    
}
