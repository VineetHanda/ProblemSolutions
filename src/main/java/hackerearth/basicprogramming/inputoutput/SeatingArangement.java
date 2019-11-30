package hackerearth.basicprogramming.inputoutput;

import java.util.HashMap;
import java.util.Scanner;

/*
Problem Link: https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/seating-arrangement-1/
INPUT
First line of input will consist of a single integer T denoting number of test-cases. Each test-case consists of a single integer N denoting the seat-number.

OUTPUT
For each test case, print the facing seat-number and the seat-type, separated by a single space in a new line.

CONSTRAINTS
1<=T<=105
1<=N<=108
SAMPLE INPUT
2
18
40
SAMPLE OUTPUT
19 WS
45 AS
*/

public class SeatingArangement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer,Integer> hm = new HashMap<Integer, Integer>();
        hm.put(1,11);
        hm.put(2,9);
        hm.put(3,7);
        hm.put(4,5);
        hm.put(5,3);
        hm.put(6,1);
        hm.put(7,1);
        hm.put(8,3);
        hm.put(9,5);
        hm.put(10,7);
        hm.put(11,9);
        hm.put(0,11);

        int testCases = sc.nextInt();
        int[] seatNumber = new int[testCases];
        for(int i = 0; i < testCases; i++) {
            seatNumber[i] = sc.nextInt();
        }
        for(int i = 0; i < testCases; i++){
            int mode = seatNumber[i]%12;
            if(mode <= 6 && mode!=0){
                System.out.print(seatNumber[i]+ (hm.get(mode)) );
            }
            else{
                System.out.print(seatNumber[i]- (hm.get(mode)) );
            }
            System.out.println(printFacingSeat(mode));
        }
    }

    private static String printFacingSeat(int mode){
        if(mode == 1 || mode == 0 || mode == 6 || mode == 7)
            return " WS";
        else if(mode == 2 || mode == 11 || mode == 5 || mode ==8)
            return " MS";
        else
            return " AS";
    }
}
