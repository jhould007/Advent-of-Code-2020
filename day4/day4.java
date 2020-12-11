package day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class day4 {

    public static void main(String[] args) throws FileNotFoundException {

        String rawString = processInputFile("C:/Users/jdh10/Documents/AdventOfCode/day4/day4input.txt");

        //Split the raw string by three-space gaps to get individual passports
        String[] passports = rawString.split("   "); 
        printPassports(passports);
        int validPassports = 0; 
        for(String passport: passports) {
            if(reqFieldsPresent(passport)) {
                //This is where fields must be checked for validity
                validPassports++; 
            }
        }
        System.out.println("The number of valid passports is " + validPassports + "."); 
    }

    // Function to check if all required passport fields are present
    // Passports must contain ecl, pid, eyr, hcl, byr, iyr, and hgt.
    public static boolean reqFieldsPresent(String passport) {
        boolean ecl = passport.contains("ecl");
        boolean pid = passport.contains("pid");
        boolean eyr = passport.contains("eyr");
        boolean hcl = passport.contains("hcl");
        boolean byr = passport.contains("byr");
        boolean iyr = passport.contains("iyr");
        boolean hgt = passport.contains("hgt");

        if (ecl && pid && eyr && hcl && byr && iyr && hgt) {
            return true;
        }
        return false;
    }

    //Helper function to print passports in an orderly fashion 
    public static void printPassports(String[] passports) {
        for(int i = 0; i < passports.length; i++) {
            System.out.println("Passport " + (i + 1) + ": " + passports[i]); 
        }
    }

    //Function to process input file into a string
    public static String processInputFile(String filePath) throws FileNotFoundException {
        //Parse input file into a string and represent blank lines with three spaces
        File input = new File(filePath);
        Scanner sc = new Scanner(input);
        String s = "";
        while (sc.hasNextLine()) {
            String cur = sc.nextLine(); 
            if(cur.isEmpty()) {
                s += "   "; 
            } else {
                s += (cur += " "); 
            }
        }
        sc.close(); 
        return s; 
    }
}