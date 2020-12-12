package day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class day4test {
    public static void main(String[] args) throws FileNotFoundException {
        String passport = "iyr:2015 cid:189 ecl:oth byr:1947 hcl:#6c4ab1 eyr:2026 hgt:174cm pid:526744288";
        String[] fields = passport.split(" ");
        Arrays.sort(fields);
        System.out.println(Arrays.toString(fields));
        System.out.println(pidValid(fields)); 
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
