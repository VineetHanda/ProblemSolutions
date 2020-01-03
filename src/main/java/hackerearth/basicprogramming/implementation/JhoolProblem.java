package hackerearth.basicprogramming.implementation;
import java.util.Scanner;

/*
Problem Link: https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/psychic-powers/
Input format:

Single line contains a binary number.

Output format:

You need to print "Good luck!" (Without quotes, and WITH exclamation mark!) if the Jhool is going to tell them that they're going to have a good time. Else, print "Sorry, sorry!" if the person is going to be told that he'll have a hard time!

Constraints:

The binary number will be in string format, with the maximum length being 100 characters.

SAMPLE INPUT
0001111110
SAMPLE OUTPUT
Sorry, sorry!
Explanation
Since the binary number given has six consecutive 1s, little Jhool tells the man that he's going to have a bad time!
 */
public class JhoolProblem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.print(checkFuture(input));
    }

    private static String checkFuture(String input){
        char preChar = input.charAt(0);
        int count = 1;
        boolean result = true;
        for(int i = 1; i < input.length(); i++ ){
            if(preChar == input.charAt(i)){
                count+=1;
            }
            else{
                count = 1;
            }
            preChar = input.charAt(i);
            if(count == 6){
                result = false;
                break;
            }
        }
        if(result)
            return "Good luck!";
        else
            return "Sorry, sorry!";
    }
}
