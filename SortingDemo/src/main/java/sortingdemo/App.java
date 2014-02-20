package sortingdemo;

import sortingdemo.mainElem.MergeSort;
import sortingdemo.mainElem.UI;
import java.util.Arrays;
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
        Integer[] a = {100,20, 3, 1,2, 5,7, 3};
        QuickSort qs = new QuickSort();
        qs.insertArray(a);
        qs.sort();
        
        System.out.println(Arrays.toString(qs.getSortTarget()));
        
        int i = 0;
        while (i < 10) i++;
        System.out.println(i);
    }
}
