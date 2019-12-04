package hackerearth.basicprogramming.inputoutput;

import java.util.Scanner;

/*
Problem Link: https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/friends-relationship-1/
Constraints :

1 ≤  T ≤ 100

1 ≤  N ≤ 30

Input :

First Line contains T i.e. number of test case.
Each of the next T lines contain an integer N.

Output:

For each test case print the pattern of N lines then after a blank line.

SAMPLE INPUT
3
9
2
5
SAMPLE OUTPUT
*################*
**##############**
***############***
****##########****
*****########*****
******######******
*******####*******
********##********
******************

*##*
****

*########*
**######**
***####***
****##****
**********
 */
public class FriendRelationship {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = Integer.parseInt(sc.nextLine());
        int[] inputArray = new int[testCases];
        for(int i =0; i < testCases; i++){
            inputArray[i] = Integer.parseInt(sc.nextLine());
            printPattern(inputArray[i]);
        }

    }

    private static void printPattern(int numLines){
        for(int i = 0; i < numLines; i++){
            for(int j = 0; j < numLines*2; j++){
                if(j < i+1 || j >= (numLines*2)-i-1)
                 System.out.print("*");
                else
                    System.out.print("#");
            }
            System.out.println();
        }
    }
}
