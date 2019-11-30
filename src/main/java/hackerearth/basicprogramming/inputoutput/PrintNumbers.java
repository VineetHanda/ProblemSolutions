package hackerearth.basicprogramming.inputoutput;

import java.util.Scanner;

/*
Problem Link: https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/print-the-numbers/

Input:

First line contains integer N - denoting total count of numbers that are to be printed.

Second line contains N space separated integers.

Output:

Print the numbers in input.

Constraints:

1 <= N <= 100

SAMPLE INPUT
5
56 30 3 94 58
SAMPLE OUTPUT
56 30 3 94 58
*/
public class PrintNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalCount = Integer.parseInt(sc.nextLine());
        String integers = sc.nextLine();
        String[] inputIntegers = integers.split(" ");
        for(int i = 0; i < totalCount; i++){
            System.out.print(inputIntegers[i]+" ");
        }
    }
}
