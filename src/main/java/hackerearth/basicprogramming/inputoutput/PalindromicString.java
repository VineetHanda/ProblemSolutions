package hackerearth.basicprogramming.inputoutput;

import java.util.Scanner;

/*
Problem Link: https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/palindrome-check-2/

Input Format
The first and only line of input contains the String S. The String shall consist of lowercase English alphabets only.

Output Format
Print the required answer on a single line.

Constraints
1 <= |S| <= 100

Note
String S consists of lowercase English Alphabets only.

SAMPLE INPUT
aba
SAMPLE OUTPUT
YES
*/

public class PalindromicString {
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
