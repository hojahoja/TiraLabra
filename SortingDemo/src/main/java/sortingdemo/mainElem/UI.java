package sortingdemo.mainElem;

import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class handles the text based user interface
 *
 * @author juri
 */
public class UI {

    private Scanner scanner;
    private IntegerSelector intSelect;
    private MergeSort mergeSort;
    private QuickSort quickSort;
    private HeapSort heapSort;
    private boolean showArray;
    private boolean selected[];

    public UI() {
        scanner = new Scanner(System.in);
        intSelect = new IntegerSelector(scanner);
        mergeSort = new MergeSort();
        quickSort = new QuickSort();
        heapSort = new HeapSort();
        selected = new boolean[3];
    }

    /**
     * The whole program is started with this method.
     *
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
     * Prints the initial menu commands and asks for the command.
     *
     * @param command
     * @return
     */
    private String initialMenu(String command) {
        System.out.println("1: Show Arrays On/Off");
        System.out.println("2: Time comparison");
        System.out.println("x: Stop the program\n");

        command = scanner.nextLine();

        return command;
    }

    /**
     * Checks which command was typed in the first menu and acts accordingly.
     *
     * @param command the typed command as a string
     * @return
     */
    private boolean handleStartMenuCommands(String command) {
        if (command.equals("1")) {
            toggleVisibleArrays();
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
     * A help method created to toggle the boolean showArray.
     *
     */
    private void toggleVisibleArrays() {
        if (showArray == true) {
            showArray = false;
        } else {
            showArray = true;
        }
    }

    /**
     * Shows the demo menu.
     *
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

    /**
     * Handles the demo menu commands
     *
     * @param command
     * @param backCommandIsNotGiven
     * @return true if back Command was given
     */
    private boolean handleDemoMenuCommands(String command, boolean backCommandIsNotGiven) {
        boolean anAlgorithmWasSelected = command.equals("1") || command.equals("2") || command.equals("3");

        if (anAlgorithmWasSelected) {
            intSelect.start();
        } else if (command.equalsIgnoreCase("x")) {
            backCommandIsNotGiven = false;
        }
        return backCommandIsNotGiven;
    }

    /**
     * Runs the chosen demo.
     *
     * @param command
     */
    private void runDemo(String command) {
        boolean choseMergeSort = command.equals("1");
        boolean choseHeapSort = command.equals("2");
        boolean choseQuicksort = command.equals("3");

        if (choseMergeSort) {
        } else if (choseHeapSort) {
        } else if (choseQuicksort) {
        }
    }

    /**
     * Shows the initial menu for algorithm comparison. Checks for an exception
     * where all arrays were not properly initialized for each algorithm class.
     * The user will be notified of this.
     *
     */
    private void comparisonMenu() {
        comparisonMenuOptions();

        try {
            handeComparisonMenuCommands();
        } catch (Exception ex) {
            System.out.println("\nYou must create the array first\n");
        }
    }

    /**
     * Asks for use input and acts accordingly this. and prints the menu and
     * select options. If the r command is selected before initializing arrays
     * first an exception will be thrown.
     *
     * @throws Exception
     */
    private void handeComparisonMenuCommands() throws Exception {
        printOptionsMessage();

        while (true) {
            String command = scanner.nextLine();



            if (command.equals("1")) {
                toggleSelectedAlgorithm(0);
            } else if (command.equals("2")) {
                toggleSelectedAlgorithm(1);
            } else if (command.equals("3")) {
                toggleSelectedAlgorithm(2);
            } else if (command.equals("s")) {
                intSelect.start();
                startComparison(selected);
                return;
            } else if (command.equals("r")) {
                startComparison(selected);
                return;
            } else if (command.equals("x")) {
                break;
            }

            comparisonMenuOptions();
            printOptionsMessage();
        }
    }

    /**
     * This method helps to toggle the boolean value inside selected array
     *
     * @param index The index of the algorithm.
     */
    private void toggleSelectedAlgorithm(int index) {
        if (selected[index] == true) {
            selected[index] = false;
        } else {
            selected[index] = true;
        }
    }

    /**
     * Prints currently selected algorithms and the "Visible array" option.
     *
     */
    private void printOptionsMessage() {
        System.out.println("\n");
        System.out.print("Visible arrays: ");
        if (showArray == true) {
            System.out.println("On");
        } else {
            System.out.println("Off");
        }

        System.out.println("Selected Algorithms: ");
        if (selected[0] == true) {
            System.out.print(" MergeSort");
        }
        if (selected[1] == true) {
            System.out.print(" QuickSort");
        }
        if (selected[2] == true) {
            System.out.print(" HeapSort");
        }

        System.out.println();
    }

    /**
     * Calls the timedSort method for each selected algorithm.
     *
     * @param selected This array contains information about which algorithm was
     * selected
     * @throws Exception If the arrays are not properly initialized
     */
    private void startComparison(boolean[] selected) throws Exception {

        if (showArray) {
            System.out.println("target array: " + Arrays.toString(intSelect.getArray()) + "\n");
        }


        if (selected[0] == true) {
            timedSort(mergeSort);
        }
        if (selected[1] == true) {
            timedSort(quickSort);
        }
        if (selected[2] == true) {
            timedSort(heapSort);
        }

    }

    /**
     * Runs the sorting algorithm and times it's performance. Prints the
     * information to the user
     *
     * @param algo The algorithm class
     * @throws Exception If the arrays are not properly initialized
     */
    private void timedSort(SortingAlgorithm algo) throws Exception {
        algo.insertArray(intSelect.getArray());
        long start = System.nanoTime();
        algo.sort();
        long elapsedTime = System.nanoTime() - start;

        System.out.print("\n" + algo + ":" + elapsedTime / 1000000.0 + "ms");
        if (showArray) {
            System.out.println(" " + Arrays.toString(algo.getSortTarget()));
        }
        System.out.println();
    }

    /**
     * Prints the comparisonMenuOptions
     */
    private void comparisonMenuOptions() {
        System.out.println("\nChoose the algorithm you want to compare.\n"
                + "Typing the number input again deselects the algorithm");
        System.out.println("1: Merge sort");
        System.out.println("2: Quicksort");
        System.out.println("3: Heapsort");
        System.out.println("s: Start with a new array");
        System.out.println("r: Retry with previous array");
        System.out.println("x: Back\n");
    }
}
