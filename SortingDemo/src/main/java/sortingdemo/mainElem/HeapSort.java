package sortingdemo.mainElem;

/**
 * This class handles the Heap-Sort operations.
 *
 * @author juri
 */
public class HeapSort implements SortingAlgorithm{

    private Integer[] sortTarget;
    private  int heapSize;
    private  int left;
    private  int right;
    private  int largest;

    public HeapSort() {
        this.sortTarget = new Integer[0];
    }

    public void insertArray(Integer[] sortTarget) {
        this.sortTarget = sortTarget.clone();
    }
    
    public void sort() {
        buildheap();
        
        for( int i = heapSize; i > 0 ; i--){
            swap(0, i);
            heapSize--;
            heapify(0);
        }
    }
    
    private void buildheap(){
        heapSize = sortTarget.length-1;
        for(int i= heapSize/2 ; i >= 0; i--){
            heapify(i);
        }
    }
    
    
    private void heapify(int i) {
        left=2*i;
        right=2*i+1;
        if(left <= heapSize && sortTarget[left] > sortTarget[i]){
            largest=left;
        }
        else{
            largest=i;
        }
        
        if(right <= heapSize && sortTarget[right] > sortTarget[largest]){
            largest=right;
        }
        
        if (largest != i) {
            swap(i, largest);
            heapify(largest);
        }
    }
    
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
