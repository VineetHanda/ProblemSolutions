package hackerearth.basicprogramming.inputoutput;
import java.util.HashSet;

public class CheckSumOfPairs {
    public static void main(String[] args) {
        int[] arr1 = {2,3,5,9};
        int[] arr2 = {4,9,7,3};
        int targetSum = 11;

        //System.out.println(checkPairsForSum(arr1, arr2, targetSum));
        System.out.println(checkPairsForSum2(arr1, targetSum));

    }

    //Brute Force
    public static boolean checkPairsForSum(int[] array1, int[] array2, int sum){
        for(int i = 0; i < array1.length; i++){
            for(int j = 0; j < array2.length; j++){
                if(array1[i] + array2[j] == sum)
                    return true;
            }
        }
        return false;
    }

    public static boolean checkPairsForSum2(int[] array1, int sum){
        HashSet<Integer> hs = new HashSet<Integer>();
        for(int i = 0; i < array1.length; i++){
            if(hs.contains(sum - array1[i]))
                return true;
            else
                hs.add(array1[i]);
        }
        return false;
    }
}