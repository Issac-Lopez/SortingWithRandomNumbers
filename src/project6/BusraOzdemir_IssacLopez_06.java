/**
  CS 2050
  The purpose of this project is to generate random numbers to be sorted via
  shell sorting and quick sorting.
  Busra Ozdemir & Issac Lopez
  Project 6
  12/05/2019
  Windows 10, Asus ZenBook, Intellij IDEA
  benignity [ bih-nig-ni-tee ] noun. a good deed or favor; an instance of kindness.
  "The machine does not isolate man from the great problems of nature but plunges
  him more deeply into them." -Antoine de Saint-Exupery (1900-1944)
 */

package project6;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BusraOzdemir_IssacLopez_06 {

    /**
     * The shellSort method is used to shell sort an array a.
     */
    private static void shellSort(int[] a) {

        int increment = a.length / 2;

        while (increment > 0) {
            for (int i = increment; i < a.length; i++) {

                int j = i;
                int temp = a[i];
                // Shell sort algorithm.
                while (j >= increment && a[j - increment] > temp) {
                    a[j] = a[j - increment];
                    j = j - increment;
                } // End of while

                a[j] = temp;
            } // End of for

            if (increment == 2) {
                increment = 1;
            } else {
                increment *= (5.0 / 11);
            } // End of else
        } // End of while loop
    } // End of shellSort method

    // ************************************************************************************************************

    /**
     * Method to find middle element; sort and merge.
     *
     * @param start // The starting index.
     * @param end   // The ending index.
     * @return Returns the middle most index.
     */
    private static int partitionMid(int[] a, int start, int end) {

        int left;
        int right;
        int temp;
        int middle;
        int flag;

        middle = left = start;
        right = end;
        flag = 0;

        // Compares the middle and right elements.
        while (flag != 1) {
            while ((a[middle] <= a[right]) && (middle != right)) {
                right--;
            } // End while loop
              // Compares middle index and right most index.
            if (middle == right) {
                flag = 1;
            } // End if
              // Compares if middle element is greater than right element.
            else if (a[middle] > a[right]) {

                // Swaps the middle element and right element.
                temp = a[middle];
                a[middle] = a[right];
                a[right] = temp;
                middle = right;

            } // End else if

            // Compares the middle and left elements.
            if (flag != 1) {
                while ((a[middle] >= a[left]) && (middle != left)) {
                    left++;
                } // End while loop
                if (middle == left) {
                    flag = 1;
                } // End if
                else if (a[middle] < a[left]) {
                    // Swaps the middle element and left element.
                    temp = a[middle];
                    a[middle] = a[left];
                    a[left] = temp;
                    middle = left;

                } // End else if
            } // End if
        } // End while

        return middle;

    } // End partitionMid method

    // ************************************************************************************************************

    /**
     * Recursive Quick Sort Implementation.
     *
     * @param left  // The left index.
     * @param right // The right index.
     */
    private static void quickSort(int[] a, int left, int right) {

        int middle;

        if (left < right) {
            // Sets the middle element to the partitionMid method.
            middle = partitionMid(a, left, right);
            // Implements quickSort to the parameters.
            quickSort(a, left, middle - 1);
            quickSort(a, middle + 1, right);

        } // End if
    } // End quickSort Method

    // ***********************************************************************************************************

    /**
     * Main Method -
     * 1) Creates arrays size 100.
     * 2) Scans the input file.
     * 3) Implements shell sort and is sent to output file.
     * 4) Implements quick short and is sent to separate output file.
     * 
     * @throws IOException // Exception.
     */

    public static void main(String[] args) throws IOException {

        int[] array1 = new int[100]; // Array size of 100.
        int[] array2 = new int[100]; // Array size of 100.
        int k = 0; // Constant integer.

        Scanner scanner = null;

        try {
            scanner = new Scanner(new File("2050 Project 06_Input.txt")); // Scans the input file.
        } // End try

        catch (FileNotFoundException e) {
            e.printStackTrace();
        } // End catch

        int i = 0;
        int p = 0;
        int num;
        assert scanner != null;

        // Scans the integers to the arrays.
        while (scanner.hasNextInt()) {

            num = scanner.nextInt();
            array1[i++] = num;
            array2[p++] = num;

        } // End of while

        scanner.close();

        // Call Shell sort.
        shellSort(array1);

        // Write sorted array to output file.
        BufferedWriter wrOutput = new BufferedWriter(new FileWriter("BusraOzdemir_IssacLopez_06_Output_01.txt", false));

        // Try and catch used to make sure there are 10 numbers per line.
        // Also adds a space between each set of numbers.
        try {
            for (int j = 0; j < i; j++) {
                if (k == 10) {
                    wrOutput.newLine(); // New line after 10 numbers in the file.
                    k = 0;
                } // End if

                wrOutput.write(array1[j] + " "); // Number and space between numbers.
                k++;
            } // End for loop
        } // End try
        catch (IOException e) {
            e.printStackTrace();
        } // End catch

        wrOutput.close();

        // Call Quick Sort.
        k = 0;
        quickSort(array2, 0, i - 1);
        wrOutput = new BufferedWriter(new FileWriter("BusraOzdemir_IssacLopez_06_Output_02.txt", false));

        // Try and catch used to make sure there are 10 numbers per line.
        // Also adds a space between each set of numbers.
        try {
            for (int j = 0; j < i; j++) {
                if (k == 10) {
                    wrOutput.newLine(); // New line after 10 numbers in the file.
                    k = 0;
                }

                wrOutput.write(array2[j] + " "); // Number and space between numbers.
                k++;
            } // End for loop

        } // End try
        catch (IOException e) {
            e.printStackTrace();
        } // End catch

        wrOutput.close();

    } // End of main method
} // End of class BusraOzdemir_IssacLopez_06
