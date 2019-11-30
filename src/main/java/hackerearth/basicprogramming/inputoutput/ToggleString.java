package hackerearth.basicprogramming.inputoutput;

import java.util.Scanner;
/*
Problem Link: https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/modify-the-string/
Input Format
The first and only line of input contains the String S

Output Format
Print the resultant String on a single line.

Constraints
1 <= |S| <= 100 where S denotes the length of string S.
 */
public class ToggleString {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        String inputString = sc.nextLine();
        System.out.println(convertString(inputString));
    }

    private static StringBuilder convertString(String inputString){
        StringBuilder outputString = new StringBuilder();
        for(int i = 0; i < inputString.length(); i++){
            if((int)inputString.charAt(i) >= 97)
                outputString.append(String.valueOf(inputString.charAt(i)).toUpperCase());
            else
                outputString.append(String.valueOf(inputString.charAt(i)).toLowerCase());
        }
        return outputString;
    }
}
