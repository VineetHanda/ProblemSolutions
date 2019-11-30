package hackerearth.basicprogramming.inputoutput;

import java.util.Scanner;

/*
Problem Link: https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/prime-number-8/description/

Input Format

The first and only line of the input contains a single integer N denoting the number till where you need to find the series of prime number.

Output Format

Print the desired output in single line separated by spaces.

Constraints

1<=N<=1000

SAMPLE INPUT
9
SAMPLE OUTPUT
2 3 5 7
*/

public class PrimeNumbers {
    public static void main(String[] args) {
        //Scanner
        Scanner s = new Scanner(System.in);
        int limit = s.nextInt();               // Reading input from STDIN
        for(int i = 2; i <= limit; i++){
            if(checkPrime(i))
                System.out.print(i+" ");
        }

    }

    public static boolean checkPrime(int number){
        for(int i = 2; i <= number/2 ; i++){
            if(number%i == 0){
                return false;
            }
        }
        return true;
    }
}
