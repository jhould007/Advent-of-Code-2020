package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class day2 {

    public static void main(String[] args) throws FileNotFoundException {
        // Parse the text file into a String array for easy access
        File input = new File("C:/Users/jdh10/Documents/AdventOfCode/day2/day2input.txt");
        Scanner sc = new Scanner(input);
        ArrayList<String> passwords = new ArrayList<String>();
        while (sc.hasNextLine()) {
            passwords.add(sc.nextLine());
        }
        sc.close();

        // Process the list of passwords and find out how many are valid
        System.out.println(validPasswordCount2(passwords));
    }

    /*
     * Go through each line and parse the string, saving the password, min and max
     * number of occurrences, and letter to look for. Parse the password and find
     * the number of occurrences of the given character. If it is between min and
     * max, increment the valid password counter.
     */

    public static int validPasswordCount(ArrayList<String> passwords) {
        int validCount = 0;
        for (int i = 0; i < passwords.size(); i++) {
            String s = passwords.get(i);

            // Split the line into the range, character to look for, and password
            String[] pieces = s.split(" ");
            String[] minMax = pieces[0].split("-");
            int min = Integer.parseInt(minMax[0]);
            int max = Integer.parseInt(minMax[1]);
            char c = pieces[1].charAt(0);
            String password = pieces[2];

            // Parse the password, seeing if the number of occurrences of the given
            // character is within the range given.
            int charCount = 0;
            for (int j = 0; j < password.length(); j++) {
                if (password.charAt(j) == c) {
                    charCount++;
                }
            }

            if ((charCount >= min) && (charCount <= max)) {
                validCount++;
            }
        }
        return validCount;
    }

    // Method for part 2, where x-y represents the two indexes that need to be
    // checked rather than min-max number of occurrences
    public static int validPasswordCount2(ArrayList<String> passwords) {
        int validCount = 0;
        for (int i = 0; i < passwords.size(); i++) {
            String s = passwords.get(i);

            // Split the line into the indexes, character to look for, and password
            String[] pieces = s.split(" ");
            String[] indexes = pieces[0].split("-");
            int firstIndex = Integer.parseInt(indexes[0]);
            int secondIndex = Integer.parseInt(indexes[1]);
            char c = pieces[1].charAt(0);
            String password = pieces[2];

            // Check if the given character is present at the indexes. It needs to be
            // present at exactly one index for the password to be considered valid.
            //First and not second = valid
            //Second and not first = valid
            //Both = invalid
            //Neither = invalid

            boolean firstAndNotSecond = (password.charAt(firstIndex - 1)) == c && (password.charAt(secondIndex - 1) != c); 
            boolean secondAndNotFirst = (password.charAt(firstIndex - 1) != c) && (password.charAt(secondIndex - 1) == c); 

            //If c is present in exactly one index, the password is valid. 
            if(firstAndNotSecond ^ secondAndNotFirst) {
                validCount++; 
            }

        }
        return validCount;
    }

}