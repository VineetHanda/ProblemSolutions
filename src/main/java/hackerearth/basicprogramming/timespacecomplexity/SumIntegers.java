package hackerearth.basicprogramming.timespacecomplexity;
import java.math.BigInteger;
import java.util.Scanner;

/*
Problem Link: https://www.hackerearth.com/practice/basic-programming/complexity-analysis/time-and-space-complexity/practice-problems/algorithm/a-b-4/
Input Format

Each line contains two integers,  and . One input file may contain several pairs  where .

Output Format

Output a single integer per line - The sum of  and .

Constraints
0 <= A,B <= 10^98
SAMPLE INPUT
1 2
2 5
10 14
SAMPLE OUTPUT
3
7
24
 */
public class SumIntegers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            String[] inputStringArray = sc.nextLine().split(" ");
            BigInteger num1 = new BigInteger(inputStringArray[0]);
            BigInteger num2 = new BigInteger(inputStringArray[1]);
            System.out.println(num1.add(num2));
        }
        sc.close();
    }
}
