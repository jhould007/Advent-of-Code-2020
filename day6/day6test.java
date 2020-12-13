package day6;

import java.util.ArrayList;

public class day6test {
    public static void main(String[] args) {
        findCommonCharacters("abc fff asdfblk"); //Expected: 0
        findCommonCharacters("abc abc abc abc"); //Expected: 3
        findCommonCharacters("xyz xy x"); //Expected: 1
        findCommonCharacters("abc"); //Expected: 3
        findCommonCharacters("qesdpalbnfjyrzhim xocesfutkghymvb"); 
        findCommonCharacters("abcdefg abcd"); //Expected: 4
    }

    //Helper function to find the number of characters in common between all strings in an array
    public static int findCommonCharacters(String s) {
        int commonCharacters = 0; 
        String[] personArr = s.split(" "); 
        String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"}; 
        for(String letter: alphabet) {
            boolean isInAllStrings = true; 
            for(String person: personArr) {
                if(!person.contains(letter)) {
                    isInAllStrings = false; 
                }
            }
            if(isInAllStrings == true) {
                commonCharacters++; 
            }
        }
        System.out.println("The number of common characters between the separate strings in " + s + " is " + commonCharacters + "."); 
        return commonCharacters; 
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
