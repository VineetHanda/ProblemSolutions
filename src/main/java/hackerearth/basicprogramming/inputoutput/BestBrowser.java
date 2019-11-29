package hackerearth.basicprogramming.inputoutput;

import java.util.Scanner;

public class BestBrowser {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = Integer.parseInt(sc.nextLine());
        String[] outputArray = new String[testCases];
        for(int i =0; i< testCases; i++){
            String inputString = sc.nextLine();
            outputArray[i] = removeVowels(new StringBuilder(inputString))-4+1 +"/"+inputString.length();
        }
        for(String output:outputArray){
            System.out.println(output);
        }
    }

    private static int removeVowels(StringBuilder input){
        int countVowels = 0;
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) == 'a' || input.charAt(i) == 'e' || input.charAt(i) == 'i' || input.charAt(i) == 'o' || input.charAt(i) == 'u'){
                countVowels+=1;
            }
        }
        return input.length()-countVowels;
    }
}
