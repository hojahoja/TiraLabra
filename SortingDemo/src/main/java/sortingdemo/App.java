package sortingdemo;

import sortingdemo.mainElem.MergeSort;
import sortingdemo.mainElem.UI;
import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
//        UI ui = new UI();
//        ui.start();
        
        Integer[] a = {20, 3, 1,2, 5,7};
        MergeSort ms = new MergeSort();
        ms.insertArray(a);
        ms.sort();
        
        System.out.println(Arrays.toString(a));
        
    }
}
