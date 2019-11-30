package hackerearth.basicprogramming.inputoutput;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        System.out.println(findFactorial(number));
    }

    private static int findFactorial(int number){
        int result = 1;
        for(int i = 1; i <= number; i++){
            result = result*i;
        }
        return result;
    }
}
