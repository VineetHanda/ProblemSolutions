package hackerearth.basicprogramming.inputoutput;

import java.util.Scanner;
/*
Problem Link: https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/roy-and-profile-picture/
Input:
First line contains L.
Second line contains N, number of photos.
Following N lines each contains two space separated integers W and H.

Output:
Print appropriate text for each photo in a new line.

Constraints:
1 <= L,W,H <= 10000
1 <= N <= 1000

SAMPLE INPUT
180
3
640 480
120 300
180 180
SAMPLE OUTPUT
CROP IT
UPLOAD ANOTHER
ACCEPTED
*/

public class ProfilePictureUpload {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int acceptedLength = Integer.parseInt(sc.nextLine());
        int numberOfPhotos = Integer.parseInt(sc.nextLine());

        String[] outputArray = new String[numberOfPhotos];

        for(int i = 0; i < numberOfPhotos; i++){
            String[] input = sc.nextLine().split(" ");
            int width = Integer.parseInt(input[0]);
            int height = Integer.parseInt(input[1]);
            outputArray[i] = checkInputDimension(acceptedLength, width, height);
        }
        for(String output:outputArray){
            System.out.println(output);
        }
    }

    private static String checkInputDimension(int acceptedLength, int inputWidth, int inputHeight){
        String result = "";

        if(inputWidth == inputHeight) {
            if(inputWidth < acceptedLength || inputHeight < acceptedLength)
                result = "UPLOAD ANOTHER";
            else
                result = "ACCEPTED";

        }
        else if(inputWidth < acceptedLength || inputHeight < acceptedLength)
            result = "UPLOAD ANOTHER";
        else
            result = "CROP IT";

        return result;
    }


}
