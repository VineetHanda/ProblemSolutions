package codility;

import java.util.Scanner;

public class ConsectiveThreeRemoveUtil {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputString = sc.nextLine();
        System.out.print(solution(inputString));
    }

    public static String solution(String S){
        StringBuilder output = new StringBuilder();
        char previousChar = '\0';
        int counter = 1;

        for(int i = 0; i < S.length(); i++){
            if(S.charAt(i) == previousChar) {
                if(counter < 2) {
                    output.append(S.charAt(i));
                    previousChar = S.charAt(i);
                    counter += 1;
                }
            }
            else{
                output.append(S.charAt(i));
                previousChar = S.charAt(i);
                counter = 1;
            }
        }
        return output.toString();
    }
}
