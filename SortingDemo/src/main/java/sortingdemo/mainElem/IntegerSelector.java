package sortingdemo.mainElem;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

/**
 * This class is used by the UI to help create the Arrays that will be sorted
 *
 * @author juri
 */
public class IntegerSelector {

    private Integer[] sortTarget;
    private Scanner scanner;
    private Random rng;

    public IntegerSelector(Scanner scanner) {
        this.scanner = scanner;
        rng = new Random();
    }

    public void start() {
        System.out.println("\nChoose input method for integers");
        boolean exitCommandIsNotGiven = true;

        while (exitCommandIsNotGiven) {
            System.out.println("1: Randomly generate a set amount");
            System.out.println("2: Select each number one by one");
            System.out.println("x: Back\n");

            String command = scanner.nextLine();

            exitCommandIsNotGiven = handleMenuCommands(command);
        }
    }

    private boolean handleMenuCommands(String command) {
        System.out.println("\nGiving a wrong input will return you to previous menu");

        if (command.equals("1")) {
            Integer quantity = chooseQuantity();
            enterOneByOne(quantity);
            System.out.println(Arrays.toString(sortTarget));
        } else if (command.equals("2")) {
            Integer quantity = chooseQuantity();
            generateRandomIntegers(quantity);
            System.out.println(Arrays.toString(sortTarget));
        } else if (command.equalsIgnoreCase("x")) {
            return false;
        }

        return true;
    }

    private Integer chooseQuantity() {
        System.out.println("\nEnter the amount of integers you want sorted:\n");

        return addInteger();
    }

    private void enterOneByOne(Integer quantity) {
        if (quantity == null) {
            System.out.println("\nWrong Input\n");
            return;
        }

        sortTarget = new Integer[quantity];
        for (int i = 0; i < quantity; i++) {
            Integer current = addInteger();

            if (current != null) {
                sortTarget[i] = current;
            }
        }
    }

    private void generateRandomIntegers(Integer quantity) {
        if (quantity == null) {
            System.out.println("\nWrong Input\n");
            return;
        }
        
        sortTarget = new Integer[quantity];
        for (int i = 0; i < quantity; i++) {
            Integer current = rng.nextInt(10);            
        }
    }

    private Integer addInteger() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
