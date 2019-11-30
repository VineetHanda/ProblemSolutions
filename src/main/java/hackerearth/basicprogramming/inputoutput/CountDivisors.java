package hackerearth.basicprogramming.inputoutput;

import java.util.Scanner;

public class CountDivisors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputLine = sc.nextLine();
        String[] inputIntegers = inputLine.split(" ");
        int divisor = Integer.parseInt(inputIntegers[2]);
        int answer = 0;

        for(int i = Integer.parseInt(inputIntegers[0]); i <= Integer.parseInt(inputIntegers[1]); i++){
            if((i%divisor) == 0)
                answer+=1;
        }

        System.out.println(answer);
    }
}
