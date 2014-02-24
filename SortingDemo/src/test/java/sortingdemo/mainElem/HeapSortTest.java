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
public class HeapSortTest {
    private HeapSort hs;
    
    public HeapSortTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        hs = new HeapSort();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void ArrayInsertWorks() {
        Integer[] arr = {1, 4, 5, 6, 87};
        hs.insertArray(arr);
        
        for (int i = 0; i < arr.length; i++) {
            int num = hs.getSortTarget()[i];
            assertTrue(arr[i] == num);
        }
    }
    
    @Test
    public void canSortSimpleArrays() {
        Integer[] arr = {3, 4, 2, 1};
        hs.insertArray(arr);
        
        assertFalse("Something went wrong with the test", checkIfSorted(hs.getSortTarget()));
        hs.sort();
        assertTrue("Sorting failed", checkIfSorted(hs.getSortTarget()));
    }
    
    @Test
    public void canSortLongArrays() {
        Integer[] arr = generateArrayWithRandomNumbers(1000000);
        hs.insertArray(arr);
        assertFalse("Something went wrong with the test", checkIfSorted(hs.getSortTarget()));
        hs.sort();
        assertTrue("Sorting failed", checkIfSorted(hs.getSortTarget()));
    }
    
    @Test
    public void canSortReverseArray() {
        Integer[] arr = {10,9,8,7,6,5,4,3,2,1};
        hs.insertArray(arr);
        hs.insertArray(arr);
        assertFalse("Something went wrong with the test", checkIfSorted(hs.getSortTarget()));
        hs.sort();
        assertTrue("Sorting failed", checkIfSorted(hs.getSortTarget()));
    }
    
    @Test
    public void canSortAnArrayWithNoDifferingValues() {
        Integer[] arr = new Integer[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = 1;
        }
        
        hs.insertArray(arr);
        hs.sort();
        assertTrue("Sorting failed", checkIfSorted(hs.getSortTarget()));
    }
    
    @Test
    public void wontCrashWhenHandlingAnArrayWithASingleInteger() {
        Integer[] arr = {1};
        hs.insertArray(arr);
        
        
        try {
            hs.sort();
            assertTrue(true);
        } catch (Exception e) {
            assertFalse(e.getMessage(),true);
        }        
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