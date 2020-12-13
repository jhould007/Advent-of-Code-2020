package day5; 
import java.util.Arrays;

public class day5test {
    public static void main(String[] args) {
        
        //Populate rows array
        int[] rows = new int[128]; 
        for(int i = 0; i < rows.length; i++) {
            rows[i] = i; 
        }
        int[] columns = {0, 1, 2, 3, 4, 5, 6, 7}; 
        String boardingPass = "FFFBBBFRRR"; 
        String columnCode = boardingPass.substring(7, boardingPass.length()); 

        System.out.println("Row: " + findRow(rows, boardingPass)); 
        System.out.println("Column: " + findColumn(columns, columnCode)); 
    }

    //Finds row number given entire boarding pass code
    public static int findRow(int[] rows, String code) {

        //Defining current character, midpoint of array, and string to call function recursively with to eliminate redundancy. 
        char c = code.charAt(0); 
        int mid = rows.length / 2; 
        String remainingString = code.substring(1, code.length()); 

        //Process the last B or F to determine return value when the array is down to two elements
        if(code.length() == 4) {
            if(c == 'F') {
                return rows[0]; 
            } else if(c == 'B') {
                return rows[1]; 
            }
        }

        //If F is encountered, take the lower half of the array
        else if(c == 'F') {
            return findRow(Arrays.copyOfRange(rows, 0, mid), remainingString); 
        }

        //If B is encountered, take the upper half of the array
        if(c == 'B') {
            return findRow(Arrays.copyOfRange(rows, mid, rows.length), remainingString);
        }

        return 0; 
    }

    //Finds column number given three-character column part of boarding pass code
    public static int findColumn(int[] columns, String columnCode) {
        char c = columnCode.charAt(0); 
        int mid = columns.length / 2; 
        String remainingString = columnCode.substring(1, columnCode.length()); 

        //Process the last L or R to determine return value when the array is down to two elements
        if(columnCode.length() == 1) {
            if(c == 'L') {
                return columns[0];
            } else if(c == 'R') {
                return columns[1]; 
            }
        }

        //If L is encountered, take the lower half of the array
        if(c == 'L') {
            return findColumn(Arrays.copyOfRange(columns, 0, mid), remainingString); 
        } 

        //If R is encountered, take the upper half of the array
        else if(c == 'R') {
            return findColumn(Arrays.copyOfRange(columns, mid, columns.length), remainingString); 
        }

        return 0; 
    }

}
//For each line, read the string one character at a time. 'B' means keep upper half of array, 'F' means keep lower half. 
//For the last three characters, 'R' keeps upper half of columns array, 'L' keeps lower half. 
//Arrays.copyOfRange "from" is inclusive, "to" is exclusive. 