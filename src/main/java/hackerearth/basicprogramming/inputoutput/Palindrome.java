package hackerearth.basicprogramming.inputoutput;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        if(checkPalindrome(input))
            System.out.println("YES");
        else
            System.out.println("NO");
    }

    private static boolean checkPalindrome(String input){
        for(int i = 0, j = input.length()-1; i < input.length()/2;i++,j--){
            if(input.charAt(i)!=input.charAt(j))
                return false;
        }
        return true;
    }
}
