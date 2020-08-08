package hackerearth.basicprogramming.inputoutput;

import java.util.Arrays;

public class AnagramCheck {


    /* function to check whether two strings are
    anagram of each other */
    static boolean checkAnagramStrings(char[] input1, char[] input2)
    {
        int input1_length = input1.length;
        int input2_length = input2.length;

        if (input1_length != input2_length)
            return false;

        Arrays.sort(input1);
        Arrays.sort(input2);

        // Compare sorted strings
        for (int i = 0; i < input1_length; i++)
            if (input1[i] != input2[i])
                return false;

        return true;
    }

    /* Driver program to test to print printDups*/
    public static void main(String args[])
    {
        char str1[] = { 't', 'e', 's', 't' };
        char str2[] = { 't', 't', 'e', 's' };
        if (checkAnagramStrings(str1, str2))
            System.out.println("The two strings are"
                    + " anagram of each other");
        else
            System.out.println("The two strings are not"
                    + " anagram of each other");
    }
}
