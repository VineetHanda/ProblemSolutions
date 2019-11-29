package hackerearth.basicprogramming.inputoutput;
import java.util.Scanner;

public class Anagrams {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        int[] outputArray = new int[testCases];
        for(int i = 0; i < testCases; i++){
            String input1 = sc.next();
            String input2 = sc.next();
            outputArray[i] = anagramCheck(input1, input2);
        }
        for(int output:outputArray){
            System.out.println(output);
        }
    }

    private static int anagramCheck(String input1, String input2){
        StringBuilder sb1 = new StringBuilder(input1);
        StringBuilder sb2 = new StringBuilder(input2);

        int numberOfDeletions1 = 0;
        int numberOfDeletions2 = 0;

        for(int i = 0; i < input1.length(); i++){
            if(sb2.indexOf(String.valueOf(input1.charAt(i))) == -1 ){
                numberOfDeletions1+=1;
            }else{
                sb2.deleteCharAt(sb2.indexOf(String.valueOf(input1.charAt(i))));
                sb1.deleteCharAt(sb1.indexOf(String.valueOf(input1.charAt(i))));
            }
        }

        sb1 = new StringBuilder(input1);
        sb2 = new StringBuilder(input2);
        for(int i = 0; i < input2.length(); i++){
            if(sb1.indexOf(String.valueOf(input2.charAt(i))) == -1 ){
                numberOfDeletions2+=1;
            }else{
                sb1.deleteCharAt(sb1.indexOf(String.valueOf(input2.charAt(i))));
                sb2.deleteCharAt(sb2.indexOf(String.valueOf(input2.charAt(i))));
            }
        }
        return numberOfDeletions1+numberOfDeletions2;

    }

}
