package hackerearth.basicprogramming.implementation;

import java.util.Scanner;

/*
Problem Link: https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/digit-problem/
Input:

First line of the input contains two integers X and K separated by a single space.

Output:

Print the largest number formed in a single line.

Constraints:
1 <= X <= 10^18
0 <= K <= 9

SAMPLE INPUT
4483 2
SAMPLE OUTPUT
9983
Explanation
First two digits of the number are changed to get the required number.

 */
public class DigitProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        long output = calculateMaximum(Long.parseLong(input.split(" ")[0]), Integer.parseInt(input.split(" ")[1]));
        System.out.print(output);
    }

    private static long calculateMaximum(long num, int places){
        StringBuilder inputString = new StringBuilder(String.valueOf(num));
        for(int i = 0; i < places; i++){
            if(inputString.charAt(i) == '9'){
                places+=1;
                continue;
            }
            inputString.replace(i, i, "9");
            inputString.deleteCharAt(i+1);
        }
        return Long.parseLong(String.valueOf(inputString));
    }
}
