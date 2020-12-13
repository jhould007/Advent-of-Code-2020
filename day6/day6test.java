package day6;

import java.util.ArrayList;

public class day6test {
    public static void main(String[] args) {
        countUniqueCharacters("abcdef"); //Expected: 6
        countUniqueCharacters("xyzaaabt"); //Expected: 6
        countUniqueCharacters("a"); //Expected: 1
        countUniqueCharacters(""); //Expected: 0
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
        System.out.println("There are " + uniqueCharacters.size() + " unique characters in the string " + s + "."); 
        return uniqueCharacters.size(); 
    }
}
