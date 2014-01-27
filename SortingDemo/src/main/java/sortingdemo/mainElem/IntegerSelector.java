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
        this.rng = new Random();
    }

    public void start() {
        System.out.println("\nChoose input method for integers");
        boolean exitCommandIsNotGiven = true;

        while (exitCommandIsNotGiven) {
            System.out.println("1: Select each number one by one");
            System.out.println("2: Randomly generate a set amount");
            System.out.println("x: Back\n");

            String command = this.scanner.nextLine();

            exitCommandIsNotGiven = handleMenuCommands(command);
        }
    }

    private boolean handleMenuCommands(String command) {
        System.out.println("\nGiving a wrong input will return you to previous menu");

        if (command.equals("1")) {
            Integer quantity = chooseQuantity();
            enterOneByOne(quantity);
        } else if (command.equals("2")) {
            Integer quantity = chooseQuantity();
            generateRandomIntegers(quantity);
        } else if (command.equalsIgnoreCase("x")) {
            return false;
        }

        if (this.ArrayWasInitializedProperly()) {
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

        this.sortTarget = new Integer[quantity];
        System.out.println("Type a number and press enter until done:\n");
        for (int i = 0; i < quantity; i++) {
            Integer current = addInteger();

            if (current != null) {
                this.sortTarget[i] = current;
            } else {
                System.out.println("\nNot a number. Try again\n");
                i--;
            }
        }
    }

    private void generateRandomIntegers(Integer quantity) {
        if (quantity == null) {
            System.out.println("\nWrong Input\n");
            return;
        }

        this.sortTarget = new Integer[quantity];
        for (int i = 0; i < quantity; i++) {
            Integer current = rng.nextInt(10);
            this.sortTarget[i] = current;
        }
    }

    private Integer addInteger() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public boolean ArrayWasInitializedProperly() {
        if (sortTarget != null) {
            for (int i = 0; i < sortTarget.length; i++) {
                if (sortTarget[i] == null) {
                    return false;
                }
            }
        }
        return true;
    }
}
