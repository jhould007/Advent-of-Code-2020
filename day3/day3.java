package day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day3 {
    public static void main(String[] args) throws FileNotFoundException {
        // Read in the input file and generate a 2D array with the contents
        File input = new File("C:/Users/jdh10/Documents/AdventOfCode/day3/day3input.txt");
        Scanner sc = new Scanner(input);

        // Read input file into an array (my input file is 323 rows by 31 columns)
        char[][] grid = new char[323][15500]; // 15500 = 31*500
        int currentRow = 0;
        int currentColumn = 0;
        while (sc.hasNextLine()) {
            String currentLine = sc.nextLine();
            String currentLineExtended = multiplyString(currentLine, 500);
            for (int i = 0; i < currentLineExtended.length(); i++) {
                grid[currentRow][i] = currentLineExtended.charAt(i);
            }
            currentRow++;
        }

        // printMatrix(grid);
         System.out.println(traverse(grid));
    }

    // Traverses the input grid to calculate how many trees will be hit on a
    // diagonal path with slope 1/3
    public static int traverse(char[][] grid) {
        int row = 0;
        int col = 0;
        int treesHit = 0;
        while (row < 323) {
            if (grid[row][col] == '#') {
                treesHit++;
            }
            row += 2; 
            col += 1; 
        }
        return treesHit;
    }

    // Helper function to multiply a string for the purposes of extending the grid
    // to the right many times
    public static String multiplyString(String s, int x) {
        String sCopy = s;
        for (int i = 0; i < x - 1; i++) {
            s += sCopy;
        }
        return s;
    }

    // Prints a matrix
    public static void printMatrix(char[][] grid) {
        int row = 1;
        for (int j = 0; j < grid.length; j++) {
            for (int k = 0; k < grid[0].length; k++) {
                System.out.print(grid[j][k]);
            }
            System.out.print(" (row " + row + ")");
            System.out.println();
            row++;
        }
    }

}
