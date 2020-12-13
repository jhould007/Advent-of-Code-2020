package day6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class day6 {

    // Split the input file into separate groups.
    // For each group, count the number of unique characters.
    // Add the count to a running total and print the total out at the end.

    public static void main(String[] args) throws FileNotFoundException {
        String rawString = processInputFile("C:/Users/jdh10/Documents/AdventOfCode/day6/day6input.txt");
        // Split the raw string by three-space gaps to get individual groups
        String[] groups = rawString.split("   ");
        // Replace blank spaces between each person's answers for purposes of counting
        // unique characters in each group, then do the counting and add the number to the total. 
        int answerSum = 0; 

        for (int i = 0; i < groups.length; i++) {
            groups[i] = groups[i].replace(" ", "");
            answerSum += countUniqueCharacters(groups[i]); 
        }
        System.out.println("The sum of the counts of questions to which anyone answered yes for all groups is " + answerSum + "."); 
    }

    // Function to process input file into a string
    public static String processInputFile(String filePath) throws FileNotFoundException {
        // Parse input file into a string and represent blank lines with three spaces
        File input = new File(filePath);
        Scanner sc = new Scanner(input);
        String s = "";
        while (sc.hasNextLine()) {
            String cur = sc.nextLine();
            if (cur.isEmpty()) {
                s += "   ";
            } else {
                s += (cur += " ");
            }
        }
        sc.close();
        return s;
    }

    // Helper function to count the number of unique characters in a string
    public static int countUniqueCharacters(String s) {
        ArrayList<Character> uniqueCharacters = new ArrayList<Character>(); 
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i); 
            if(!uniqueCharacters.contains(c)) {
                uniqueCharacters.add(c); 
            }
        }
        return uniqueCharacters.size(); 
    }
}