package hackerearth.basicprogramming.inputoutput;

import java.util.Scanner;

/*
Problem Link: https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/count-divisors/

Input Format
The first and only line of input contains 3 space separated integers l, r and k.

Output Format
Print the required answer on a single line.

Constraints
1 <= l <= r <= 1000
1 <= k <= 1000

SAMPLE INPUT
1 10 1
SAMPLE OUTPUT
10
*/

public class CountDivisors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputLine = sc.nextLine();
        String[] inputIntegers = inputLine.split(" ");
        int divisor = Integer.parseInt(inputIntegers[2]);
        int answer = 0;

        for(int i = Integer.parseInt(inputIntegers[0]); i <= Integer.parseInt(inputIntegers[1]); i++){
            if((i%divisor) == 0)
                answer+=1;
        }

        System.out.println(answer);
    }
}
