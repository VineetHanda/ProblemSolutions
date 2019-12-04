package hackerearth.basicprogramming.inputoutput;
/*
Problem Link: https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/doctors-secret/
Input:

2 integers-

First denoting length of Secret Book.

Second is number of pages in Book.

Output:

If Cheeku should take medicine, print - "Take Medicine"

Else print - "Don't take Medicine".



SAMPLE INPUT
10 600
SAMPLE OUTPUT
Take Medicine
Explanation
10 is less than 23.

600 is between 500 and 1000.
*/

import java.util.Scanner;

public class DoctorSecret {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] inputString = sc.nextLine().split(" ");
        int lengthOfBook = Integer.parseInt(inputString[0]);
        int numPages = Integer.parseInt(inputString[1]);
        if(lengthOfBook <= 23 && numPages >= 500 && numPages <= 1000)
            System.out.print("Take Medicine");
        else
            System.out.print("Don't take Medicine");
    }
}
