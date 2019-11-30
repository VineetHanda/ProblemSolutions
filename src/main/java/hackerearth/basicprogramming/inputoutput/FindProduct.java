package hackerearth.basicprogramming.inputoutput;

import java.util.Scanner;

/*
Problem Link: https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/find-product/

Input Format:
The first line contains a single integer N denoting the size of the array. The next line contains N space separated integers denoting the elements of the array

Output Format:
Print a single integer denoting the product of all the elements of the array Modulo .

Constraints:
1 <= N <= 1000
1 <= A[i] <= 1000

SAMPLE INPUT
5
1 2 3 4 5
SAMPLE OUTPUT
120
*/

public class FindProduct {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arraySize = Integer.parseInt(sc.nextLine());
        String elements = sc.nextLine();
        int[] array = new int[arraySize];
        int i = 0;
        for(String element:elements.split(" ")){
            array[i++] = Integer.parseInt(element);
        }
        System.out.print(findProduct(array));

    }

    private static long findProduct(int[] array){
        long answer = 1;
        for(int element:array){
            answer = (answer*element)%(1000000000+7);
        }

        return answer;
    }
}
