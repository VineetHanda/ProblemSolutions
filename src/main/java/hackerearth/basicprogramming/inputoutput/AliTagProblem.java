package hackerearth.basicprogramming.inputoutput;

import java.util.Scanner;

/*
Problem Link: https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/cartag-948c2b02/
Input Format

The first line contains a string of length 9. The format is "DDXDDD-DD", where D stands for a digit (non zero) and X is an uppercase english letter.

Output Format

Print "valid" (without quotes) if the tag is valid, print "invalid" otherwise (without quotes)

SAMPLE INPUT
12X345-67
SAMPLE OUTPUT
invalid
Explanation
The tag is invalid because the sum of first and second digit of it is odd (also the sum of 4'th and 5'th, 5'th and 6'th and 8'th and 9'th are odd).
 */
public class AliTagProblem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputString = sc.nextLine();
        System.out.println(checkValidString(inputString));
    }

    private static String checkValidString(String inputString){
        String result = "valid";
        if(inputString.charAt(2) == 'A' || inputString.charAt(2) == 'E' || inputString.charAt(2) == 'I' || inputString.charAt(2) == 'O' || inputString.charAt(2) == 'U' || inputString.charAt(2) == 'Y')
            return "invalid";

        for(int i = 0; i < inputString.length()-1; i++){
            if(i == 1 ||  i == 2 || i == 5 || i == 6)
                continue;
            else{
                int num = Integer.parseInt(String.valueOf(inputString.charAt(i))) + Integer.parseInt(String.valueOf(inputString.charAt(i+1)));
                if(!(num%2 == 0)){
                    result = "invalid";
                    break;
                }
            }
        }
        return result;
    }
}
