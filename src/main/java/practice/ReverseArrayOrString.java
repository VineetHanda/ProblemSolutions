package practice;

import java.util.Arrays;

/***
 * https://www.geeksforgeeks.org/write-a-program-to-reverse-an-array-or-string/
 */

public class ReverseArrayOrString {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        String string = "TestString";

        Solution s = new Solution();
        int[] result_int = s.reverseArray(arr);
        char[] result_string = s.reverseString(string.toCharArray());

        System.out.println(Arrays.toString(result_int));
        System.out.println(result_string);
    }
}

class Solution {
    public int[] reverseArray(int[] arr){
        if (arr.length == 0)
            return arr;

        for (int i = 0, j = (arr.length-1); i < (arr.length)/2; i++,j--) {
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }

        return arr;
    }
    public char[] reverseString(char[] arr){
        if (arr.length == 0)
            return arr;

        for (int i = 0, j = (arr.length-1); i < (arr.length)/2; i++,j--) {
            char temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }

        return arr;
    }
}
