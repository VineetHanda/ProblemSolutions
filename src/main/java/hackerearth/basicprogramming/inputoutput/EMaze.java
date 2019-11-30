package hackerearth.basicprogramming.inputoutput;

/*
Problem Link: https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/e-maze-in-1aa4e2ac/
Input:

Input contains a single string.

Output:

Print the final point where he came out.

Constraints:

1 ≤ |S| ≤ 200

SAMPLE INPUT
LLRDDR
SAMPLE OUTPUT
0 -2

*/

import java.util.Scanner;

public class EMaze {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputString = sc.nextLine();

        int xDistance = 0;
        int yDistance = 0;

        for(int i = 0; i < inputString.length(); i++){
            if(inputString.charAt(i) == 'L')
                xDistance-=1;
            else if(inputString.charAt(i) == 'R')
                xDistance+=1;
            else if(inputString.charAt(i) == 'U')
                yDistance+=1;
            else
                yDistance-=1;
        }
        System.out.println(xDistance+" "+yDistance);
    }
}
