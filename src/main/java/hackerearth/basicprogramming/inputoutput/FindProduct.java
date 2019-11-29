package hackerearth.basicprogramming.inputoutput;

import java.util.Scanner;

public class FindProduct {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arraySize = Integer.parseInt(sc.nextLine());
        String elements = sc.nextLine();
        int[] array = new int[arraySize];
        int i = 0;
        for(String element:elements.split(" ")){
            array[i++] = Integer.parseInt(element);
        }
        System.out.print(findProduct(array));

    }

    private static long findProduct(int[] array){
        long answer = 1;
        for(int element:array){
            answer = (answer*element)%(1000000000+7);
        }

        return answer;
    }
}
