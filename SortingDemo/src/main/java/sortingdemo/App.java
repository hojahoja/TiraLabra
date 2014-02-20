package sortingdemo;

import sortingdemo.mainElem.MergeSort;
import sortingdemo.mainElem.UI;
import java.util.Arrays;
import sortingdemo.mainElem.HeapSort;
import sortingdemo.mainElem.QuickSort;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
//        UI ui = new UI();
//        ui.start();
//        
        Integer[] a = {20, 3, 1,2, 5,7, 3};
        HeapSort hs = new HeapSort();
        hs.insertArray(a);
        hs.sort();
        
        System.out.println(Arrays.toString(hs.getSortTarget()));
        
        int i = 0;
        while (i < 10) i++;
        System.out.println(i);
    }
}
