package sortingdemo.mainElem;

import java.util.Scanner;

/**
 * This class handles the text based user interface
 *
 * @author juri
 */
public class UI {

    private Scanner scanner;
    private IntegerSelector intSelect;

    public UI() {
        scanner = new Scanner(System.in);
        intSelect = new IntegerSelector(scanner);
    }

    /**
     * The whole program is started with this method.
     */
    public void start() {
        String command = "";
        boolean exitCommandIsNotGiven = true;
        System.out.println("\nSorting Algorithms Demonstration\n");

        while (exitCommandIsNotGiven) {
            command = initialMenu(command);
            exitCommandIsNotGiven = handleStartMenuCommands(command);
        }
    }

    /**
     * this string
     *
     * @param command
     * @return
     */
    private String initialMenu(String command) {
        System.out.println("1: Visual demo");
        System.out.println("2: Time comparison");
        System.out.println("x: Stop the program\n");

        command = scanner.nextLine();

        return command;
    }

    /**
     * Checks which command was typed in the first menu and acts accordingly.
     *
     *
     * @param command the typed command as a string
     * @return
     */
    private boolean handleStartMenuCommands(String command) {
        if (command.equals("1")) {
            demoMenu();
        } else if (command.equals("2")) {
            comparisonMenu();
        } else if (command.equalsIgnoreCase("x")) {
            return false;
        } else {
            System.out.println("\nWrong Input\n");
        }
        return true;
    }

    /**
     * Shows the demo menu.
     */
    private void demoMenu() {
        System.out.println("\nChoose an algorithm");
        boolean backCommandIsNotGiven = true;

        while (backCommandIsNotGiven) {
            System.out.println("1: Merge sort");
            System.out.println("2: Heapsort");
            System.out.println("3: Quicksort");
            System.out.println("x: Back\n");

            String command = scanner.nextLine();
            backCommandIsNotGiven = handleDemoMenuCommands(command, backCommandIsNotGiven);

            if (intSelect.ArrayWasInitializedProperly()) {
                runDemo(command);
            }
        }
    }

    private boolean handleDemoMenuCommands(String command, boolean backCommandIsNotGiven) {
        boolean anAlgorithmWasSelected = command.equals("1") || command.equals("2") || command.equals("3");

        if (anAlgorithmWasSelected) {
            intSelect.start();
        } else if (command.equalsIgnoreCase("x")) {
            backCommandIsNotGiven = false;
        }
        return backCommandIsNotGiven;
    }

    private void runDemo(String command) {
        boolean choseMergeSort = command.equals("1");
        boolean choseHeapSort = command.equals("2");
        boolean choseQuicksort = command.equals("3");

        if (choseMergeSort) {
        } else if (choseHeapSort) {
        } else if (choseQuicksort) {
        }
    }

    private void comparisonMenu() {
        System.out.println("\nWork In Progress\n");
    }
}
