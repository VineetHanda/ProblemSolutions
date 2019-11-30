package hackerearth.basicprogramming.inputoutput;

import java.util.Scanner;

public class ProfileUpload {
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
