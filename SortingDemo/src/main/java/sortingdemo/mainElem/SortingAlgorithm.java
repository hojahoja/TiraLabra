package sortingdemo.mainElem;

/**
 * An interface for an algorithm class. Made for easier handling of multiple
 * algorithms.
 *
 * @author juri
 */
public interface SortingAlgorithm {

    public void insertArray(Integer[] sortTarget);

    public void sort();
    
    public Integer[] getSortTarget();
}
