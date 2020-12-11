package day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day4test {
    public static void main(String[] args) throws FileNotFoundException {
        File input = new File("C:/Users/jdh10/Documents/AdventOfCode/day4/day4input.txt");
        Scanner sc = new Scanner(input); 
        while(sc.hasNextLine() && !sc.nextLine().equals(" ")) {
            System.out.println(sc.nextLine()); 
        }
    }
}

