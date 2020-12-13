package day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import java.util.Scanner;

public class day5 {
    public static void main(String[] args) throws FileNotFoundException {
        File input = new File("C:/Users/jdh10/Documents/AdventOfCode/day5/day5input.txt");
        Scanner sc = new Scanner(input);

        int[] rows = generateRowArray();
        int[] columns = { 0, 1, 2, 3, 4, 5, 6, 7 };
        ArrayList<Integer> seatIDs = new ArrayList<Integer>();

        while (sc.hasNextLine()) {
            //Get boarding pass and column portion from it
            String boardingPass = sc.nextLine();
            String columnCode = boardingPass.substring(7, boardingPass.length());
            int row = findRow(rows, boardingPass);
            int column = findColumn(columns, columnCode);
           //  System.out.println("For the boarding pass " + boardingPass + ", The row is " + row + ", and the column is " + column + ".");
            int seatID = (row * 8) + column;
            seatIDs.add(seatID);
        }

        //Find largest and smallest seat IDs 
        int maxSeatID = Collections.max(seatIDs); 
        int minSeatID = Collections.min(seatIDs); 
        int mySeatID = 0; 
        System.out.println("The highest seat ID is " + maxSeatID + ".");
        System.out.println("The lowest seat ID is " + minSeatID + "."); 

        //Go through all numbers from lowest seat ID to highest, and if any number isn't present in the seatIDs arraylist, it is your seat ID. 
        for(int i = minSeatID; i <= maxSeatID; i++) {
            if(!seatIDs.contains(i)) {
                mySeatID = i; 
            }
        }
        System.out.println("My seat ID is " + mySeatID + "."); 
        sc.close(); 
    }

    // Finds row number given entire boarding pass code
    public static int findRow(int[] rows, String code) {

        // Defining current character, midpoint of array, and string to call function
        // recursively with to eliminate redundancy.
        char c = code.charAt(0);
        int mid = rows.length / 2;
        String remainingString = code.substring(1, code.length());

        // Process the last B or F to determine return value when the array is down to
        // two elements
        if (code.length() == 4) {
            if (c == 'F') {
                return rows[0];
            } else if (c == 'B') {
                return rows[1];
            }
        }

        // If F is encountered, take the lower half of the array
        else if (c == 'F') {
            return findRow(Arrays.copyOfRange(rows, 0, mid), remainingString);
        }

        // If B is encountered, take the upper half of the array
        if (c == 'B') {
            return findRow(Arrays.copyOfRange(rows, mid, rows.length), remainingString);
        }

        return 0;
    }

    // Finds column number given three-character column part of boarding pass code
    public static int findColumn(int[] columns, String columnCode) {
        char c = columnCode.charAt(0);
        int mid = columns.length / 2;
        String remainingString = columnCode.substring(1, columnCode.length());

        // Process the last L or R to determine return value when the array is down to
        // two elements
        if (columnCode.length() == 1) {
            if (c == 'L') {
                return columns[0];
            } else if (c == 'R') {
                return columns[1];
            }
        }

        // If L is encountered, take the lower half of the array
        if (c == 'L') {
            return findColumn(Arrays.copyOfRange(columns, 0, mid), remainingString);
        }

        // If R is encountered, take the upper half of the array
        else if (c == 'R') {
            return findColumn(Arrays.copyOfRange(columns, mid, columns.length), remainingString);
        }

        return 0;
    }

    // Helper function to fill in the row array
    public static int[] generateRowArray() {
        int[] rows = new int[128];
        for (int i = 0; i < rows.length; i++) {
            rows[i] = i;
        }
        return rows;
    }

}
