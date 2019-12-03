package hackerearth.basicprogramming.inputoutput;

/*
Problem Link: https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/lift-queries/
INPUT

First line contains a integer T denoting the number of test cases.

Next T lines contains a single integer N denoting the floor from which lift is called.

OUTPUT

Output T lines containing one character "A" if the first lift goes to N th floor or "B" for the second lift.

CONTRAINTS

0 <= N <= 7

1 <= T <= 100000



SAMPLE INPUT
2
3
5
SAMPLE OUTPUT
A
A
*/


import java.util.HashMap;
import java.util.Scanner;

public class LiftQueries {

    static HashMap<String, Integer> liftStatus = new HashMap<String, Integer>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = Integer.parseInt(sc.nextLine());
        int[] inputFloors = new int[testCases];
        char[] outputArray = new char[testCases];

        liftStatus.put("A", 0);
        liftStatus.put("B", 7);

        for(int i =0; i < testCases; i++){
            inputFloors[i] = Integer.parseInt(sc.nextLine());
            outputArray[i] = returnNearestLiftPath(inputFloors[i]);
        }
        for(char output:outputArray){
            System.out.println(output);
        }
    }

    private static char returnNearestLiftPath(int callingFloor){
        char result = 'A';
        int liftAStatus = Math.abs(liftStatus.get("A") - callingFloor);
        int liftBStatus = Math.abs(liftStatus.get("B") - callingFloor);

        if(liftAStatus <= liftBStatus){
            result = 'A';
            liftStatus.put("A", callingFloor);
        }
        else{
            result = 'B';
            liftStatus.put("B", callingFloor);
        }
        return result;
    }
}
