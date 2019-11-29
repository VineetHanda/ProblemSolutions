package hackerearth.basicprogramming.inputoutput;

import java.util.Scanner;

public class CheckAsciiValueUtil {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter any Character:");
        String input = sc.next();
        System.out.println("Ascii Value of "+input+" is:"+(int)input.charAt(0));
    }
}
