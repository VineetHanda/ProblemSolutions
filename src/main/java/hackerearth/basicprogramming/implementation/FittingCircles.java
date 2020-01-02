package hackerearth.basicprogramming.implementation;
/*
Problem Link: https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/fitting-circles-c00a5be3/
Input format

First line: An integer  denoting the number of test cases
First line of each test case: Integers  and
Output format

For each test case, print the answer on a new line denoting the maximum number of big circles that can fit in the provided rectangle.

Constraints
1 <= t <= 1000
1 <= a,b <= 10^9
SAMPLE INPUT
1
40 10
SAMPLE OUTPUT
4
Explanation
4 circles of radius 10 can fit inside the rectangle.

 */

import java.util.Scanner;

public class FittingCircles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = Integer.parseInt(sc.nextLine());
        for(int j = 0; j < testCases; j++ ){
            String input = sc.nextLine();
            String[] rectangleParameters = input.split(" ");
            calculateFittingCircles(Integer.parseInt(rectangleParameters[0]), Integer.parseInt(rectangleParameters[1]));
        }
    }

    private static void calculateFittingCircles(int length, int width){
        if(length > width)
            System.out.println(length / width);
        else
            System.out.println(width / length);
    }
}
