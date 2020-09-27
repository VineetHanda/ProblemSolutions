package codility;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;




public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        int lowerCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> lower = new ArrayList<>();

        for (int i = 0; i < lowerCount; i++) {
            int lowerItem = Integer.parseInt(bufferedReader.readLine().trim());
            lower.add(lowerItem);
        }

        int upperCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> upper = new ArrayList<>();

        for (int i = 0; i < upperCount; i++) {
            int upperItem = Integer.parseInt(bufferedReader.readLine().trim());
            upper.add(upperItem);
        }

        List<Long> result = howManyPalindromes(s, lower, upper);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

    public static List<Long> howManyPalindromes(String s, List<Integer> lower, List<Integer> upper) {
        // Write your code here

        List<String> allSubstrings = new ArrayList<>();
        List<String> actualSubstrings = new ArrayList<>();
        List<Long> outputSubstrings = new ArrayList<>();
        //Get All Possible Substrings
        for(int i = 0; i< s.length(); i++){
            for(int j = i+1; j < s.length(); j++){
                allSubstrings.add(s.substring(i,j));
            }
        }

        for(int k = 0; k < lower.size(); k++){
            for(String input: allSubstrings){
                if(input.length()>=lower.get(k) && input.length() <= upper.get(k)){
                    actualSubstrings.add(input);
                }
            }
            outputSubstrings.add(Long.valueOf(actualSubstrings.size()));
        }
        return outputSubstrings;
    }
}
