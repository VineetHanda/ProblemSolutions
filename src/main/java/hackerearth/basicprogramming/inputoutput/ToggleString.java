package hackerearth.basicprogramming.inputoutput;

import java.util.Scanner;

public class ToggleString {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        String inputString = sc.nextLine();
        System.out.println(convertString(inputString));
    }

    private static StringBuilder convertString(String inputString){
        StringBuilder outputString = new StringBuilder();
        for(int i = 0; i < inputString.length(); i++){
            if((int)inputString.charAt(i) >= 97)
                outputString.append(String.valueOf(inputString.charAt(i)).toUpperCase());
            else
                outputString.append(String.valueOf(inputString.charAt(i)).toLowerCase());
        }
        return outputString;
    }
}
