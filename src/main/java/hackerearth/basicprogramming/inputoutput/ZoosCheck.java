package hackerearth.basicprogramming.inputoutput;

import java.util.Scanner;

public class ZoosCheck {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String inputString = sc.next();
        if(checkValid(inputString))
            System.out.println("Yes");
        else
            System.out.println("No");

    }

    private static boolean checkValid(String inputString){
        int zCount = 0;
        char ch;
        for(int i = 0; i< inputString.length(); i++){
            if(inputString.charAt(i) == 'z')
                zCount+=1;
            else
                break;
        }
        if(inputString.length() - zCount == zCount*2)
            return true;

        return false;
    }
}
