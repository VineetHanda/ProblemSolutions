package hackerearth.basicprogramming.inputoutput;

import java.math.BigInteger;
import java.util.Scanner;

/*
Problem Link: hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/divisibe-or-2d8e196a/
Input format

First line: A single integer  denoting the size of array
Second line:  space-separated integers denoting the elements of array
Output format
If the newly-generated number is divisible by , then print . Otherwise, print .

Constraints
1 <= N <= 10^5
1 <= A[i] <= 10^5

SAMPLE INPUT
6
15478 8452 8232 874 985 4512
SAMPLE OUTPUT
OUI
Explanation
The first digit of 15478 is 1.
The first digit of 8452 is 8.
The first digit of 8232 is 8.
The last digit of 874 is 4.
The last digit of 985 is 5.
The last digit of 4512 is 2.
The newly generated number will be 188452 which is divisible by 11.

 */
public class Divisible {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arraySize = Integer.parseInt(sc.nextLine());
        int[] arrayElements = new int[arraySize];

        String[] arrayElementsString = sc.nextLine().split(" ");
        int i = 0;
        for(String s:arrayElementsString){
            arrayElements[i++] = Integer.parseInt(s);
        }
        System.out.println(isDivisible(arraySize, arrayElementsString));
    }

    private static String isDivisible(int arraySize, String[] arrayElementsString){
        String result = "NON";
        StringBuilder concatString = new StringBuilder();
        for(int i = 0; i < arraySize; i++){
            if(i >= arraySize/2){
                concatString.append(arrayElementsString[i].charAt(arrayElementsString[i].length()-1));
            }else{
                concatString.append(arrayElementsString[i].charAt(0));
            }
        }
        BigInteger num = new BigInteger(concatString.toString());

        if(num.remainder(new BigInteger("11")).equals(new BigInteger("0")))
            result = "OUI";
        else
            result = "NON";
        return result;
    }
}
