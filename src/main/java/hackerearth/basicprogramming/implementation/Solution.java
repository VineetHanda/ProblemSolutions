package hackerearth.basicprogramming.implementation;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(202);
        list.add(200);
        list.add(202);

        /*list.add(15);
        list.add(201);
        list.add(204);
        list.add(205);
        list.add(200);
        list.add(203);
        list.add(202);
        list.add(200);
        list.add(202);
        list.add(200);
        list.add(203);
        list.add(200);
        list.add(200);
        list.add(203);
        list.add(205);
        list.add(202);*/

        /*list.add(6);
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(1);
        list.add(5);
        list.add(1);*/
        System.out.print(getDistanceMetrics(list));
        //System.out.println(getRelativeDistance(2,3));
    }

    public static List<Long> getDistanceMetrics(List<Integer> arr) {
        // Write your code here
        System.out.println(arr);
        List<Long> result =  new ArrayList<>();
        for(int i = 0; i < arr.size(); i++){
            Long value=0L;
            System.out.println("Started for Element "+arr.get(i));
            for(int j = 0; j < arr.size(); j++){
                System.out.println("Inner");
                //if(i == j) continue;
                System.out.println("Comparing"+arr.get(i)+" and "+arr.get(j));
                if (arr.get(i).equals(arr.get(j))){
                    System.out.println("Inner Match = "+arr.get(i));
                    value = value+getRelativeDistance(i,j);
                }
            }
            System.out.println("Ended for Element "+arr.get(i));
            result.add(value);
        }
        return result;
    }

    public static Long getRelativeDistance(int i, int j){
        if(i > j)
            return new Long(i-j);
        else
            return new Long(j-i);
    }
}
