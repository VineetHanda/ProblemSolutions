package hackerearth.basicprogramming.inputoutput;

import java.util.HashMap;
import java.util.Scanner;

/*
Problem Link: https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/mojtaba-prepares-contest-29b2a044/

Input format

First line: T that denotes the number of test cases (1 <= T <= 10)
For each test case:
First line: Cost of green and purple-colored balloons
Second line: n that denotes the number of participants (1 <= n <= 10)
Next n lines: Contain the status of users. For example, if the value of the jth integer in the ith row is 0, then it depicts that the ith participant has not solved the jth problem. Similarly, if the value of the jth integer in the ith row is 1, then it depicts that the  participant has solved the jth problem.
Output format
For each test case, print the minimum cost that you have to pay to purchase balloons.

SAMPLE INPUT
2
9 6
10
1 1
1 1
0 1
0 0
0 1
0 0
0 1
0 1
1 1
0 0
1 9
10
0 1
0 0
0 0
0 1
1 0
0 1
0 1
0 0
0 1
0 0
SAMPLE OUTPUT
69
14


*/

public class CostOfBaloons {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = Integer.parseInt(sc.nextLine());
        int[] cost = new int[2];

        HashMap<Integer,String[]> participantData = new HashMap<Integer, String[]>();

        int[] outputArray = new int[testCases];

        for(int i = 0; i< testCases; i++){
            String[] inputCosts = sc.nextLine().split(" ");
            int j = 0;
            for(String inputCost:inputCosts){
                cost[j++] = Integer.parseInt(inputCost);
            }
            //System.out.println("Costs of "+i+" TestCase are:"+cost[0]+" and "+cost[1]);
            int numParticipants = Integer.parseInt(sc.nextLine());

            for(int k = 0; k < numParticipants; k++){
                String[] participantStatus = sc.nextLine().split(" ");
                participantData.put(k, participantStatus);
            }
            //System.out.println("Participant Data:"+participantData);
            outputArray[i] = calculateCost(cost,participantData);
            //System.out.println("Minimum Cost of "+i+" TestCase is:"+outputArray[i]);
        }
        for(int output:outputArray){
            System.out.println(output);
        }
    }

    private static int calculateCost(int[] cost, HashMap<Integer,String[]> participantData){
        int problemFirstSolutions = 0;
        int problemSecondSolutions = 0;
        for(Integer participantId: participantData.keySet()){
            String[] status = participantData.get(participantId);
            problemFirstSolutions+=Integer.parseInt(status[0]);
            problemSecondSolutions+=Integer.parseInt(status[1]);
        }
        return findMin(cost,problemFirstSolutions,problemSecondSolutions);
    }

    private static int findMin(int[] cost, int problemFirstSolutions, int problemSecondSolutions){
        //System.out.println("\nCosts:"+cost[0]+" and "+cost[1]);
        //System.out.println("FirstProblemSolvers:"+problemFirstSolutions+" \nSecondProblemSolvers:"+problemSecondSolutions);
        return cost[0]*problemFirstSolutions+cost[1]*problemSecondSolutions<cost[0]*problemSecondSolutions+cost[1]*problemFirstSolutions?
                cost[0]*problemFirstSolutions+cost[1]*problemSecondSolutions:
                cost[0]*problemSecondSolutions+cost[1]*problemFirstSolutions;
    }
}
