package day6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class day6part2 {

    // Split the input file into separate groups.
    // For each group, count the number of unique characters.
    // Add the count to a running total and print the total out at the end.

    public static void main(String[] args) throws FileNotFoundException {
        String rawString = processInputFile("C:/Users/jdh10/Documents/AdventOfCode/day6/day6input.txt");
        // Split the raw string by three-space gaps to get individual groups
        String[] groups = rawString.split("   ");
        int answerSum = 0; 

        //Go through each group and count the number of questions for which all members answered yes
        for(int i = 0; i < groups.length; i++) {
            groups[i] = groups[i].trim(); 
            int commonCharacters = findCommonCharacters(groups[i]); 
            answerSum += commonCharacters; 
        }
        System.out.println("The sum of the counts of questions to which everyone answered yes for all groups is " + answerSum + "."); 
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

    //Helper function to find the number of characters in common between all strings in an array
    public static int findCommonCharacters(String s) {
        int commonCharacters = 0; 
        String[] sArr = s.split(" "); 
        String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"}; 
        for(String letter: alphabet) {
            boolean isInAllStrings = true; 
            for(String person: sArr) {
                if(!person.contains(letter)) {
                    isInAllStrings = false; 
                }
            }
            if(isInAllStrings == true) {
                commonCharacters++; 
            }
        }
        return commonCharacters; 
    }
}