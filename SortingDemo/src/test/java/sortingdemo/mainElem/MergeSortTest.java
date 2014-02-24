/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingdemo.mainElem;

import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author juri
 */
public class MergeSortTest {

    private MergeSort ms;

    public MergeSortTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        ms = new MergeSort();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void ArrayInsertWorks() {
        Integer[] arr = {1, 4, 5, 6, 87};
        ms.insertArray(arr);
        
        for (int i = 0; i < arr.length; i++) {
            int num = ms.getSortTarget()[i];
            assertTrue(arr[i] == num);
        }
    }
    
    @Test
    public void canSortSimpleArrays() {
        Integer[] arr = {3, 4, 2, 1};
        ms.insertArray(arr);
        
        assertFalse("Something went wrong with the test", checkIfSorted(ms.getSortTarget()));
        ms.sort();
        assertTrue(checkIfSorted(ms.getSortTarget()));
    }
    
    @Test
    public void canSortLongArrays() {
        Integer[] arr = generateArrayWithRandomNumbers(1000000);
        ms.insertArray(arr);
        assertFalse("Something went wrong with the test", checkIfSorted(ms.getSortTarget()));
        ms.sort();
        assertTrue("Sorting failed", checkIfSorted(ms.getSortTarget()));
    }
    
    private boolean checkIfSorted(Integer[] arr) {
        int current = arr[0];
        for (int i = 0; i < arr.length-1; i++) {
            if (current > arr[i+1]) {
                return false;
            }
            current = arr[i+1];
        }
        return true;
    }
    
    private Integer[] generateArrayWithRandomNumbers(int quantity) {
        Random rng = new Random();
        Integer[] arr = new Integer[quantity];
        for (int i = 0; i < quantity; i++) {
            Integer current = rng.nextInt(100);
            arr[i] = current;
        }
        return arr;
    }
}