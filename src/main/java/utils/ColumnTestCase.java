package utils;

import java.util.ArrayList;
import java.util.List;

public class ColumnTestCase {
    public static void main(String[] args) {
        String[] columns = {"col1","col2","col3","col4","col5","col6","col7","col8","col9","col10"};
        formatColumns(2,columns);
    }

    public static void formatColumns(int numOfColumns, String[] columns){
        List tempList = new ArrayList<String>();
        List<List> mainList = new ArrayList<List>();
        int iterator = 1;
        for(String column:columns){
            if(iterator==numOfColumns){
                tempList.add(column);
                mainList.add(tempList);
                tempList = new ArrayList();
                iterator = 0;
            }
            else{
                tempList.add(column);
            }
            iterator+=1;
        }
        System.out.println(mainList);
    }
}
