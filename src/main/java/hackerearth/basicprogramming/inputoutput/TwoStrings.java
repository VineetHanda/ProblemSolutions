package hackerearth.basicprogramming.inputoutput;

/*
Problem Link: https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/two-strings-4/
Input :

First line, contains an intger 'T' denoting no. of test cases.
Each test consists of a single line, containing two space separated strings S1 and S2 of equal length.
Output:

For each test case, if any of the permutation of string S1 is equal to the string S2 print YES else print NO.
Constraints:

1<= T <=100
1<= |S1| = |S2| <= 10^5
String is made up of lower case letters only.
Note : Use Hashing Concept Only . Try to do it in O(string length) .

SAMPLE INPUT
3
sumit mitsu
ambuj jumba
abhi hibb
SAMPLE OUTPUT
YES
YES
NO
Explanation
For first test case,

mitsu can be rearranged to form sumit .

For second test case,

jumba can be rearranged to form ambuj .

For third test case,

hibb can not be arranged to form abhi.

*/

import java.util.Scanner;

public class TwoStrings {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = Integer.parseInt(sc.nextLine());
        String[] inputString = new String[testCases];
        String[] outputArray = new String[testCases];

        for(int i = 0; i < testCases; i++){
            inputString[i] = sc.nextLine();
            outputArray[i] = checkTwoStrings(inputString[i].split(" "));
        }

        for(String output:outputArray){
            System.out.println(output);
        }
    }

    private static String checkTwoStrings(String[] inputArray){
        String result = "YES";
        StringBuilder input1 = new StringBuilder(inputArray[0]);
        StringBuilder input2 = new StringBuilder(inputArray[1]);

        for(int i = 0; i < inputArray[0].length(); i++){
            if(input1.indexOf(String.valueOf(inputArray[1].charAt(i))) == -1){
                result = "NO";
                break;
            }
            else{
                input1.deleteCharAt( input1.indexOf(String.valueOf(inputArray[1].charAt(i))) );
                input2.deleteCharAt(input2.indexOf(String.valueOf(inputArray[1].charAt(i))));
            }
        }
        return result;
    }
}
