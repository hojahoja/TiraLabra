package sortingdemo.mainElem;

import java.util.Scanner;

/**
 * This class is used by the UI to help create the Arrays that will be sorted
 *
 * @author juri
 */
public class IntegerSelector {

    private Integer[] input;
    private Scanner scanner;

    public IntegerSelector(Scanner scanner) {
        this.scanner = scanner;
    }   

    public void start() {
        System.out.println("\nChoose input method for integers");
        boolean exitCommandIsNotGiven = true;
        
        while (exitCommandIsNotGiven) {
            System.out.println("1: Randomly generate a set amount");
            System.out.println("2: Select each number one by one");
            System.out.println("x: ");
            
            String command = "";
            
            exitCommandIsNotGiven = handleMenuCommands(command);
        }
    }

    private boolean handleMenuCommands(String command) {
        System.out.println("\nGiving a wrong input will return you to input selection menu");
        
        if (command.equals("1")) {
            selectOneByOne();
        } else if (command.equals("2")) {
            
        } else if (command.equalsIgnoreCase("x")){
            return false;
        }
        
        return true;
    }

    private void selectOneByOne() {
        System.out.println("\nEnter the amount of integers you want sorted");
        
        
    }
}
