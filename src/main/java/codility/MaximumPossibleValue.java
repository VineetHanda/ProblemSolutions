package codility;

import java.util.Scanner;

public class MaximumPossibleValue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = Integer.parseInt(sc.nextLine());
        System.out.println(solution(input));
    }

    public static int solution(int N){
        int result = -8000;
        int insertNum = 5;
        if(N>=0) {
            StringBuilder inputString = new StringBuilder(String.valueOf(N));
            for (int i = 0; i < inputString.length(); i++) {
                inputString = new StringBuilder(String.valueOf(N));
                result = Math.max(Integer.parseInt(String.valueOf(inputString.insert(i, insertNum))), result);
            }
        }
        else{
            result = 8000;
            int num = N*(-1);
            StringBuilder inputString = new StringBuilder(String.valueOf(num));
            for(int i = 0; i < inputString.length(); i++){
                inputString = new StringBuilder(String.valueOf(num));
                result = Math.min( Integer.parseInt( String.valueOf(inputString.insert(i, insertNum)) ), result );
            }
            result = result*(-1);
        }
        return result;
    }
}
