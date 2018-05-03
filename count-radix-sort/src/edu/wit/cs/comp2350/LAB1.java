package edu.wit.cs.comp2350;

/**
 * Sorts integers from command line using various algorithms
 * <p>
 * Wentworth Institute of Technology
 * COMP 2350
 * Programming Assignment 0
 *
 * @author Charles Arnaudo
 **/

import java.util.*;

public class LAB1 {

    public final static int MAX_INPUT = 524287;
    public final static int MIN_INPUT = 0;

    /**
     * Counting sort
     *
     * @param a array to be sorted
     * @return sorted array
     */
    public static int[] countingSort(int[] a) {
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }

        //count occurrences of each number, increment corresponding indices
        int[] countOf = new int[max + 1];
        for (int i = 0; i < a.length; i++) {
            countOf[a[i]]++;
        }

        //sort using number of occurrences, adding the number countOf[i] times to sorted[]
        int index = 0;
        int[] sorted = new int[a.length];
        for (int i = 0; i < countOf.length; i++) {
            for (int j = 0; j < countOf[i]; j++) {
                sorted[index] = i;
                index++;
            }
        }
        return sorted;
    }

    /**
     * Linear radix sort
     *
     * @param a array to be sorted
     * @return sorted array
     */
    public static int[] radixSort(int[] a) {
        for (int x = 0; x < 10; x++) {
            int[] count = new int[10];
            int[] pos = new int[10];

            //counting occurrences of digit in digit indices
            for (int i = 0; i < a.length; i++) {
                int index = getDigit(a[i], x);
                count[index]++;
            }

            //pos[i] = sum of all previous entries in count
            for (int i = 0; i < count.length; i++) {
                for (int j = 0; j < i; j++) {
                    pos[i] += count[j];
                }
            }

            //assigning values in a to their new indices
            int[] temp = new int[a.length];
            for (int i = 0; i < a.length; i++) {
                int index = getDigit(a[i], x);
                int newIndex = pos[index];
                pos[index]++;
                temp[newIndex] = a[i];
            }
            a = temp;
        }
        return a;
    }


    /**
     * @param val
     * @param n the indice of val needed
     * @return
     */
    private static int getDigit(int val, int n) {
        for (int i = 0; i < n; i++) {
            val /= 10;
        }
        return val %= 10;
    }

    /********************************************
     *
     * You shouldn't modify anything past here
     *
     ********************************************/

    // example sorting algorithm
    public static int[] insertionSort(int[] a) {

        for (int i = 1; i < a.length; i++) {
            int tmp = a[i];
            int j;
            for (j = i - 1; j >= 0 && tmp < a[j]; j--)
                a[j + 1] = a[j];
            a[j + 1] = tmp;
        }

        return a;
    }

    /* Implementation note: The sorting algorithm is a Dual-Pivot Quicksort by Vladimir Yaroslavskiy,
     *  Jon Bentley, and Joshua Bloch. This algorithm offers O(n log(n)) performance on many data
     *  sets that cause other quicksorts to degrade to quadratic performance, and is typically
     *  faster than traditional (one-pivot) Quicksort implementations. */
    public static int[] systemSort(int[] a) {
        Arrays.sort(a);
        return a;
    }

    // read ints from a Scanner
    // returns an array of the ints read
    private static int[] getInts(Scanner s) {
        ArrayList<Integer> a = new ArrayList<Integer>();

        while (s.hasNextInt()) {
            int i = s.nextInt();
            if ((i <= MAX_INPUT) && (i >= MIN_INPUT))
                a.add(i);
        }

        return toIntArray(a);
    }

    // copies an ArrayList to an array
    private static int[] toIntArray(ArrayList<Integer> a) {
        int[] ret = new int[a.size()];
        for (int i = 0; i < ret.length; i++)
            ret[i] = a.get(i);
        return ret;
    }


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.printf("Enter the sorting algorithm to use ([c]ounting, [r]adix, [i]nsertion, or [s]ystem): ");
        char algo = s.next().charAt(0);

        System.out.printf("Enter the integers that you would like sorted: ");
        int[] unsorted_values = getInts(s);
        int[] sorted_values = {};

        s.close();

        switch (algo) {
            case 'c':
                sorted_values = countingSort(unsorted_values);
                break;
            case 'r':
                sorted_values = radixSort(unsorted_values);
                break;
            case 'i':
                sorted_values = insertionSort(unsorted_values);
                break;
            case 's':
                sorted_values = systemSort(unsorted_values);
                break;
            default:
                System.out.println("Invalid sorting algorithm");
                System.exit(0);
                break;
        }

        System.out.println(Arrays.toString(sorted_values));

    }

}
