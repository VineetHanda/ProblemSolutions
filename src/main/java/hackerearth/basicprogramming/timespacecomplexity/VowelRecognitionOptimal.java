package hackerearth.basicprogramming.timespacecomplexity;
/*
Problem Link: https://www.hackerearth.com/practice/basic-programming/complexity-analysis/time-and-space-complexity/practice-problems/algorithm/vowel-game-f1a1047c/
Input

First line contains an integer T, denoting the number of test cases.

Each of the next lines contains a string, string contains both lower case and upper case .

Output

Print the vowel sum
Answer for each test case should be printed in a new line.

Input Constraints

1<=T<=10

1<=|S|<=100000





SAMPLE INPUT
1
baceb
SAMPLE OUTPUT
16
Explanation
First line is number of input string, In given example, string is "baceb" so the substrings will be like -"b, ba, bac, bace, a, ac, ace, aceb, c, ce, ceb, e, eb, baceb" now the number of vowels in each substring will be 0, 1, 1, 2, 1, 1, 2, 2, 0, 1, 1, 1, 1, 2  and the total number will be sum of all presence which is 16.
*/

import java.util.Scanner;

public class VowelRecognitionOptimal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < testCases; i++){
            System.out.println(getVowelCountInSubstrings(sc.nextLine().toLowerCase()));
        }
    }

    private static int getVowelCountInSubstrings(String inputString){
        int sum = 0;
        int previousCount = 0;
        int currentIterationCount = 0;
        for(int i = 0; i < inputString.length()-1; i++){
            for(int j = i; j < inputString.length(); j++)
            {
                currentIterationCount = countVowels(inputString.charAt(j));;
                sum = sum + currentIterationCount + previousCount;
                previousCount = currentIterationCount + previousCount;
            }
            previousCount = 0;
        }
        sum+=countVowels(inputString.charAt(inputString.length()-1));

        return sum;
    }

    private static int countVowels(char input){
        int vowelCount = 0;
        switch (input){
            case 'a':
                vowelCount+=1;
                break;
            case 'e':
                vowelCount+=1;
                break;
            case 'i':
                vowelCount+=1;
                break;
            case 'o':
                vowelCount+=1;
                break;
            case 'u':
                vowelCount+=1;
                break;
             default:
                 break;
        }

        return vowelCount;
    }
}
