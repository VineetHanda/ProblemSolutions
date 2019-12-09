package hackerrank;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/*
Problem Link: https://www.hackerrank.com/challenges/ctci-ransom-note/problem
 */
public class RansomNote {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
        HashMap<String, Integer> noteHashMap = new HashMap<String, Integer>();
        for(String noteElement: note){
            if(noteHashMap.containsKey(noteElement)){
                noteHashMap.put(noteElement,noteHashMap.get(noteElement)+1);
            }
            else
                noteHashMap.put(noteElement,1);
        }
        HashMap<String, Integer> magazineHashMap = new HashMap<String, Integer>();
        for (String magazineElement: magazine){
            if(magazineHashMap.containsKey(magazineElement)){
                magazineHashMap.put(magazineElement, magazineHashMap.get(magazineElement)+1);
            }
            else magazineHashMap.put(magazineElement, 1);
        }

        boolean ransomNotePossible = true;
        for(String noteRequired: noteHashMap.keySet()){
            if(!magazineHashMap.containsKey(noteRequired)) {
                ransomNotePossible = false;
                break;
            }
            else if((magazineHashMap.get(noteRequired) < noteHashMap.get(noteRequired))){
                ransomNotePossible = false;
                break;
            }
        }
        if(ransomNotePossible)
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}
