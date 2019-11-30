package hackerearth.basicprogramming.inputoutput;

import java.util.Scanner;

/*
Problem Link: https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/the-best-internet-browser-3/

Input format:
The first line contains tc, the number of test cases.
The second line contains the name of websites, as a string.

Output format:
You have to print the ratio of characters you would have typed in Jhool's browser, to your normal browser.

Constraints:
1 <= tc <= 100
1 <= Length of the website <= 200

NOTE: You do NOT need to print the output in its lowest format. You should print in its original fraction format.
The names of all the websites will be in small case only.

Every string will start from *www. and end with *.com, so well!**

SAMPLE INPUT
2
www.google.com
www.hackerearth.com
SAMPLE OUTPUT
7/14
11/19

Explanation
Consider the first case:

In Jhool's browser, you'll only have to type: ggl.com (7 characters) while in a normal browser, you'll have to type www.google.com, which is 14 characters.
*/

public class BestBrowser {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = Integer.parseInt(sc.nextLine());
        String[] outputArray = new String[testCases];
        for(int i =0; i< testCases; i++){
            String inputString = sc.nextLine();
            outputArray[i] = removeVowels(new StringBuilder(inputString))-4+1 +"/"+inputString.length();
        }
        for(String output:outputArray){
            System.out.println(output);
        }
    }

    private static int removeVowels(StringBuilder input){
        int countVowels = 0;
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) == 'a' || input.charAt(i) == 'e' || input.charAt(i) == 'i' || input.charAt(i) == 'o' || input.charAt(i) == 'u'){
                countVowels+=1;
            }
        }
        return input.length()-countVowels;
    }
}
