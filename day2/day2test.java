package day2;
import java.util.Arrays; 

public class day2test {
    public static void main(String[] args) {
        String s = "4-6 d: dddxdfd"; 
        String[] pieces = s.split(" "); 
        String[] minMax = pieces[0].split("-"); 
        System.out.println("The minimum number of occurrences is " + minMax[0] + " and the max number is " + minMax[1]);  
        System.out.println("Character to look for: " + pieces[1].charAt(0)); 
        System.out.println("The password is: " + pieces[2]); 
    }
}

//Need to split min-max part again to get out min and max values
//Character to look for: 1st character of 2nd string