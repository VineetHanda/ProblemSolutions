package codility;

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
/*
Problem Link: https://app.codility.com/programmers/lessons/2-arrays/odd_occurrences_in_array/
 */
import java.util.Arrays;

class OddOccurrences {
    public static void main(String[] args) {
    int[] arr = {1,4,2,6,4,1,6};
    System.out.println(solution(arr));
    }
    public static int solution(int[] A) {
        // write your code in Java SE 8
        int result = 0;
        if(A.length == 1)
            return A[0];
        Arrays.sort(A);
        for(int i = 0; i < A.length-1; i+=2){
            if(A[i] == A[i+1])
                continue;
            else
                return A[i];
        }

        return result;
    }
}
