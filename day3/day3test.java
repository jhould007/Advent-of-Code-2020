package day3;

public class day3test {
    public static void main(String[] args) {
        multiplyString("abc", 5); 
    }

    public static String multiplyString(String s, int x) {
        String sCopy = s; 
        for(int i = 0; i < x - 1; i++) {
            s += sCopy; 
        }
        System.out.println(s); 
        return s; 
    }
}
