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

public class VowelRecognition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < testCases; i++){
            System.out.println(getVowelCountInSubstrings(sc.nextLine()));
        }
    }

    private static int getVowelCountInSubstrings(String inputString){
        int sum = 0;
        for(int i = 0; i < inputString.length()-1; i++){
            for(int j = i+1; j <= inputString.length(); j++)
            {
                sum+=countVowels(inputString.substring(i, j));
            }
        }
        sum+=countVowels(String.valueOf(inputString.charAt(inputString.length()-1)));
        return sum;
    }

    private static int countVowels(String input){
        int vowelCount = 0;
        StringBuilder inputString = new StringBuilder(input.toLowerCase());
        while(inputString.indexOf("a")!=-1){
            vowelCount+=1;
            inputString.deleteCharAt(inputString.indexOf("a"));
        }
        while(inputString.indexOf("e")!=-1){
            vowelCount+=1;
            inputString.deleteCharAt(inputString.indexOf("e"));
        }
        while(inputString.indexOf("i")!=-1){
            vowelCount+=1;
            inputString.deleteCharAt(inputString.indexOf("i"));
        }
        while(inputString.indexOf("o")!=-1){
            vowelCount+=1;
            inputString.deleteCharAt(inputString.indexOf("o"));
        }
        while(inputString.indexOf("u")!=-1){
            vowelCount+=1;
            inputString.deleteCharAt(inputString.indexOf("u"));
        }
        return vowelCount;
    }
}
