package hackerearth.basicprogramming.inputoutput;

import java.util.Scanner;
/*
Problem Link: https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/is-zoo-f6f309e7/
Input format

First line: A word that starts with several Zs and continues by several Os.
Note: The maximum length of this word must be .
Output format

Print Yes if the input word can be considered as the string zoo otherwise, print No.

SAMPLE INPUT
zzzoooooo
SAMPLE OUTPUT
Yes
*/

public class ZoosCheck {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String inputString = sc.next();
        if(checkValid(inputString))
            System.out.println("Yes");
        else
            System.out.println("No");

    }

    private static boolean checkValid(String inputString){
        int zCount = 0;
        char ch;
        for(int i = 0; i< inputString.length(); i++){
            if(inputString.charAt(i) == 'z')
                zCount+=1;
            else
                break;
        }
        if(inputString.length() - zCount == zCount*2)
            return true;

        return false;
    }
}
