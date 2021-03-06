package hackerearth.basicprogramming.inputoutput;

import java.util.Scanner;

/*

Problem Link: https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/find-factorial/

Input Format:
The first and only line of the input contains a single integer N denoting the number whose factorial you need to find.

Output Format
Output a single line denoting the factorial of the number N.

Constraints
1 <= N <= 10

SAMPLE INPUT
2
SAMPLE OUTPUT
2
*/

public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        System.out.println(findFactorial(number));
    }

    private static int findFactorial(int number){
        int result = 1;
        for(int i = 1; i <= number; i++){
            result = result*i;
        }
        return result;
    }
}
