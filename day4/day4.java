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
        int validPassports = 0; 
        for(String passport: passports) {
            if(reqFieldsPresent(passport)) {
                //This is where fields must be checked for validity
                //Convert each passport into a string array, sort it, and then process it to see if the fields are valid 
                String[] fields = passport.split(" "); 
                if(byrValid(fields) && eclValid(fields) && eyrValid(fields) && hclValid(fields) && hgtValid(fields) && iyrValid(fields) && pidValid(fields)) {
                    validPassports++; 
                }
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

    //Helper function to get the value of a specific field
    public static String getFieldValue(String fieldName, String[] fields) { 
        String s = ""; 
        for(String field: fields) {
            if(field.contains(fieldName)) {
                s = field; 
            }
        }
        //Pull the value of the field out
        String value = s.substring(4, s.length()); 
        return value; 
    }

    // Byr is valid if it is between 1920 and 2002 (inclusive)
    public static boolean byrValid(String[] fields) {
        int byr = Integer.parseInt(getFieldValue("byr", fields)); 
        if(byr >= 1920 && byr <= 2002) {
            return true; 
        }
        return false; 
    }

    //Possible eye colors: amb blu brn gry grn hzl oth
    //Ecl is valid if it is one of these values. 
    public static boolean eclValid(String[] fields) {
        String[] eyeColors = {"amb", "blu", "brn", "gry", "grn", "hzl", "oth"}; 
        String ecl = getFieldValue("ecl", fields);
        for(String eyeColor: eyeColors) {
            if(eyeColor.equals(ecl)) {
                return true; 
            }
        }
        return false; 
    }

    //Eyr is valid if it is between 2020 and 2030 (inclusive) 
    public static boolean eyrValid(String[] fields) {
        int eyr = Integer.parseInt(getFieldValue("eyr", fields)); 
        if(eyr >= 2020 && eyr <= 2030) {
            return true; 
        }
        return false; 
    }

    //Helper function to determine whether an element exists in an array
    public static boolean elementPresent(char c, char[] values) {
        for(int i = 0; i < values.length; i++) {
            if(values[i] == c) {
                return true; 
            }
        }
        return false; 
    }

    //Hcl is valid if it is a hexadecimal value with a # sign and exactly six hex digits
    public static boolean hclValid(String[] fields) {
        String hcl = getFieldValue("hcl", fields);
        if(!hcl.contains("#")) {return false;}
        if(hcl.length() != 7) {return false;}

        char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'}; 
        for(int i = 1; i < hcl.length(); i++) {
            if(!elementPresent(hcl.charAt(i), hexDigits)) {
                return false; 
            }
        }
        return true; 
    }

    //Hgt is valid if it is between 150 and 193 cm (inclusive), or between 59 and 76 in (inclusive) 
    public static boolean hgtValid(String[] fields) {
        String hgt = getFieldValue("hgt", fields);

        if(!hgt.contains("cm") && !hgt.contains("in")) {
            return false; 
        }

        else if(hgt.contains("cm")) {
            String hgtCmString = ""; 
            int i = 0; 
            while(hgt.charAt(i) != 'c') {
                hgtCmString += hgt.charAt(i); 
                i++; 
            }
            int hgtCm = Integer.parseInt(hgtCmString); 
            if(hgtCm >= 150 && hgtCm <= 193) {
                return true; 
            }
        }

        else if(hgt.contains("in")) {
            String hgtInString = ""; 
            int i = 0; 
            while(hgt.charAt(i) != 'i') {
                hgtInString += hgt.charAt(i); 
                i++; 
            }
            int hgtIn = Integer.parseInt(hgtInString); 
            if(hgtIn >= 59 && hgtIn <= 76) {
                return true; 
            }
        }
        return false; 
    }

    //Iyr is valid if it is between 2010 and 2020 (inclusive) 
    public static boolean iyrValid(String[] fields) {
        int iyr = Integer.parseInt(getFieldValue("iyr", fields)); 
        if(iyr >= 2010 && iyr <= 2020) {
            return true; 
        }
        return false; 
    }

    //Pid is valid if it is a 9-digit number
    public static boolean pidValid(String[] fields) {
        String pid = getFieldValue("pid", fields);
        boolean isNumber = true;

        //Check if the value of pid is purely comprised of digits
        for(int i = 0; i < pid.length(); i++) {
            if(!Character.isDigit(pid.charAt(i))) {
                isNumber = false; 
            }
        }

        if(isNumber && pid.length() == 9) {
            return true; 
        }
        return false; 
    }

    
}