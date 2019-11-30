package hackerearth.basicprogramming.inputoutput;

import java.util.Scanner;

/*
Problem Link: https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/magical-word/

Input format:

First line of input contains an integer T number of test cases. Each test case contains an integer N (denoting the length of the string) and a string S.

Output Format:

For each test case, print Dhananjay's Magical Word in a new line.

Constraints:

1 <= T <= 100

1 <= |S| <= 500

SAMPLE INPUT
1
6
AFREEN
SAMPLE OUTPUT
CGSCCO

Explanation
ASCII values of alphabets in AFREEN are 65, 70, 82, 69 ,69 and 78 respectively which are converted to CGSCCO with ASCII values 67, 71, 83, 67, 67, 79 respectively. All such ASCII values are prime numbers.
*/

public class MagicalWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        StringBuilder[] outputString = new StringBuilder[testCases];
        for(int i = 0; i < testCases; i++){
          int inputLength = sc.nextInt();
          String inputString = sc.next();
          outputString[i] = convertToAsciiString(inputLength,inputString);
        }
        for(StringBuilder output:outputString){
            System.out.println(output);
        }
    }

    private static StringBuilder convertToAsciiString(int inputLength, String inputString){
        StringBuilder outputString = new StringBuilder();
        for(int i = 0; i < inputLength; i++){
            char endCaseChar = ignoreEndCase(inputString.charAt(i));
            if(endCaseChar == inputString.charAt(i)) {
                if (!isPrime(inputString.charAt(i))) {
                    outputString.append(replaceAsciiChar(inputString.charAt(i)));
                } else {
                    outputString.append(inputString.charAt(i));
                }
            }
            else
                outputString.append(endCaseChar);
        }
        return outputString;
    }

    private static boolean isPrime(int inputInteger){
        for(int i = 2; i < inputInteger/2; i++){
            if(inputInteger%i == 0) {
                return false;
            }
        }
        return true;
    }

    private static char replaceAsciiChar(char inputChar){
        char output = getNearestAsciiValue(inputChar);
        return output;
    }

    private static char getNearestAsciiValue(char inputChar) {
        int asciiInput = inputChar;
        if(asciiInput<65)
            return 'C';
        else if(asciiInput>122)
            return 'z';

        int lessDiff = 0;
        int moreDiff = 0;

        boolean primeFound = false;
        for (int i = asciiInput - 1; !primeFound; i--) {
            if (isPrime(i)) {
                primeFound = true;
                lessDiff = asciiInput - i;
            }
        }

        primeFound = false;
        for (int i = (asciiInput + 1); !primeFound; i++) {
            if (isPrime(i)) {
                primeFound = true;
                moreDiff = i - asciiInput;
            }
        }

        char outputGreater = (char) (asciiInput + moreDiff);
        char outputLesser = (char) (asciiInput - lessDiff);

        if(lessDiff <= moreDiff)
            return  outputLesser;
        else if((asciiInput + moreDiff)>=123)
            return outputLesser;
        else
            return outputGreater;
    }

    private static char ignoreEndCase(char input){
        if(((int)input) < 65)
            return 'C';
        else if(((int)input) > 122)
            return 'q';
        else return input;
    }
}
