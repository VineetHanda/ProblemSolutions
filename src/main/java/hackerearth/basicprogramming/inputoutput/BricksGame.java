package hackerearth.basicprogramming.inputoutput;

import java.util.Scanner;

/*
Problem Link: https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/bricks-game-5140869d/

Input:

First line contains an integer N.

Output:

Output "Patlu" (without the quotes) if Patlu puts the last bricks ,"Motu"(without the quotes) otherwise.

Constraints:

1 ≤ N ≤ 10000

SAMPLE INPUT
13
SAMPLE OUTPUT
Motu


*/
public class BricksGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfBricks = sc.nextInt();

        int addedBricks = 0;

        int i = 1;
        for(; addedBricks <= numberOfBricks; i++){
            addedBricks+=i;
            if(addedBricks >= numberOfBricks){
                System.out.println("Patlu");
                break;
            }
            addedBricks+=i*2;
            if(addedBricks >= numberOfBricks){
                System.out.println("Motu");
                break;
            }
        }

    }
}
