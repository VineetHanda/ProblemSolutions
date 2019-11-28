package hackerearth.basicprogramming.inputoutput;
import java.util.Scanner;
class PrimeNumbers {
    public static void main(String[] args ){
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        int[] num = new int[T];
        for(int i=0; i <T;i++){
            num[i] = s.nextInt();
        }

        for(int i = 0; i<num.length; i++){
            int n = num[i];
            for(int j = 1; j <=n;j++){
                if (j%3 == 0 && j%5 == 0)
                    System.out.println("FizzBuzz");
                else if(j%5 == 0)
                    System.out.println("Buzz");
                else if(j%3 == 0)
                    System.out.println("Fizz");
                else
                    System.out.println(j);
            }
        }

    }
}
