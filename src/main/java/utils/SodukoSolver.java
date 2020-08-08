package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SodukoSolver {

    private Soduko inputSoduko;

    public static void main(String[] args) {
        SodukoSolver ss = new SodukoSolver();
        for(int i = 0; i < 12; i++) {
            ss.startProcess();
        }
        System.out.println("************* Output Soduko *************");
        ss.inputSoduko.printSoduko();
        System.out.println("************* Output Soduko *************");
        System.out.println("\n **Soduko Solve Level = "+ss.inputSoduko.calculateSudukoSum()+"**");
    }

    public SodukoSolver(){
        int[][] input = initializeInput();
        inputSoduko = new Soduko(input);
        System.out.println("************* Input Soduko *************");
        inputSoduko.printSoduko();
        System.out.println("************* Input Soduko *************");
    }

    public int[][] initializeInput(){

        SodukoInputReader sir = new SodukoInputReader();
        int[][] input = sir.getInput();

        return input;
    }

    public void startProcess(){

        System.out.print("*************** Start ***************");
        for(Grid grid: inputSoduko.getGridList()) {
            System.out.println("\nPrinting "+grid.getGridName());
            for (Cell c : grid.getCells()) {
                if(c.getValue() == 0)
                    System.out.println(c.getPossibleCellValues());
            }
        }
        if(inputSoduko.calculateSudukoSum() == 405)
            return;

        for (Grid grid : inputSoduko.getGridList()) {
            evaluateSinglePossibleGridValue(grid);
            computeGridRowColumn(grid);
            recomputeGridPossibleValues(grid);
        }
        recomputeColumnCellsPossibleValue();
        recomputeRowCellsPossibleValue();

        System.out.print("*************** Complete ***************");
        for(Grid grid: inputSoduko.getGridList()) {
            System.out.println("\nPrinting "+grid.getGridName());
            for (Cell c : grid.getCells()) {
                if(c.getValue() == 0)
                    System.out.println(c.getPossibleCellValues());
            }
        }
        //startProcess();
    }

    public void computeGridRowColumn(Grid grid){
        //System.out.println("Processing Grid:"+grid.getGridName());

        if(grid.getSum() == 45)
            return;

        for(Cell c: grid.getCells()){
            if(c.getValue() == 0) {
                List<Integer> cellPossibleValues = new ArrayList<>(c.getPossibleCellValues());
                //System.out.println("Possible Cell Values Before for "+c.getGridName()+" Index:"+c.getxIndex()+""+c.getyIndex()+" ->"+c.getPossibleCellValues());
                //traverseRow
                for (int i = 0; i < 9; i++) {
                    int value = inputSoduko.getSoduko()[c.getxIndex()+grid.getxStartIndex()][i];
                    cellPossibleValues.remove(new Integer(value));
                }
                //System.out.println("Possible Cell Values After Row for "+c.getGridName()+" Index:"+c.getxIndex()+""+c.getyIndex()+" ->"+c.getPossibleCellValues());
                //traverseColumn
                for (int i = 0; i < 9; i++) {
                    int value = inputSoduko.getSoduko()[i][c.getyIndex()+grid.getYstartIndex()];
                    cellPossibleValues.remove(new Integer(value));
                }
                //System.out.println("Possible Cell Values After Column for "+c.getGridName()+" Index:"+c.getxIndex()+""+c.getyIndex()+" ->"+c.getPossibleCellValues());
                c.setPossibleCellValues(cellPossibleValues);

                if(cellPossibleValues.size() == 1){
                    inputSoduko.getSoduko()[c.getxIndex()+grid.getxStartIndex()][c.getyIndex()+grid.getYstartIndex()] = cellPossibleValues.get(0);
                    grid.setGridValue(c.getxIndex()+""+c.getyIndex(),cellPossibleValues.get(0));
                    c.setValue(cellPossibleValues.get(0));
                    grid.setSum(grid.calculateGridSum());
                    grid.getPossibleGridValues().remove(new Integer(cellPossibleValues.get(0)));
                    grid.setPossibleGridValues(grid.calculateGridPossibleValues());
                    inputSoduko.calculateSudukoSum();
                }
            }
        }
        //Eliminate Possible Values from Cells based on Grid Possible Values
        grid.setPossibleGridValues(grid.getPossibleGridValues());
        for(Cell c: grid.getCells()){
            List<Integer> gridPossibleValuesList = grid.getPossibleGridValues();
            List<Integer> cellPossibleValueList = new ArrayList(c.getPossibleCellValues());
            for(int value: cellPossibleValueList){
                if(! gridPossibleValuesList.contains(value)){
                    c.getPossibleCellValues().remove(new Integer(value));
                }
            }
        }
    }

    //If two Cells with Exactly 2 Possible Values in the Grid, then fix those two values for those
    //and remove those two values from rest cells Possible cells list
    public void recomputeGridPossibleValues(Grid grid){
        //recompute cellPossibleValues based on common 2 Element list
        for(Cell c: grid.getCells()){
            if(c.getValue() == 0) {
                if (c.getPossibleCellValues() != null) {
                    int count = -1;
                    if (c.getPossibleCellValues().size() == 2) {
                        for (Cell gridCells : grid.getCells()) {
                            if (c.getPossibleCellValues().equals((gridCells.getPossibleCellValues()))) {
                                count += 1;
                            }
                        }
                        if (count == 1) {
                            int firstContainedElement = c.getPossibleCellValues().get(0);
                            int secondContainedElement = c.getPossibleCellValues().get(1);
                            for (Cell cellIterator : grid.getCells()) {
                                if(cellIterator.getValue() == 0) {
                                    if (cellIterator.getPossibleCellValues() != null) {
                                        if (!(cellIterator.getPossibleCellValues().equals(c.getPossibleCellValues()))) {
                                            List<Integer> originalList = cellIterator.getPossibleCellValues();
                                            originalList.remove(new Integer(firstContainedElement));
                                            originalList.remove(new Integer(secondContainedElement));
                                            cellIterator.setPossibleCellValues(originalList);
                                        }
                                    }
                                }
                            }// Element Removal from Existing List
                        }
                    }
                }
            }
        }//recompute Loop
    }

    //If two Cells with Exactly 2 Possible Values in the Column, then fix those two values for those
    //and remove those two values from rest cells Possible cells list of the column
    public void recomputeColumnCellsPossibleValue(){
        int [][] input = inputSoduko.getSoduko();

        for(int i = 0; i < 9; i++){
            int traversingColumn = i;

            List<Cell> traversingCellList = new ArrayList<>();
            for(Grid grid: inputSoduko.getGridList()){
                for(Cell c: grid.getCells()){
                    if(grid.getYstartIndex()+c.getyIndex() == traversingColumn){
                        traversingCellList.add(c);
                    }
                }
            }
            //System.out.println("Column="+i+" ->"+traversingCellList);
            removePossibleValues(traversingCellList);
        }

    }

    //If two Cells with Exactly 2 Possible Values in the Row, then fix those two values for those
    //and remove those two values from rest cells Possible cells list of the Row
    public void recomputeRowCellsPossibleValue(){
        int [][] input = inputSoduko.getSoduko();

        for(int i = 0; i < 9; i++){
            int traversingColumn = i;

            List<Cell> traversingCellList = new ArrayList<>();
            for(Grid grid: inputSoduko.getGridList()){
                for(Cell c: grid.getCells()){
                    if(grid.getxStartIndex()+c.getxIndex() == traversingColumn){
                        traversingCellList.add(c);
                    }
                }
            }
            //System.out.println("Column="+i+" ->"+traversingCellList);
            removePossibleValues(traversingCellList);
        }
    }

    //Actually Remove the Two Possible Values from Rest of Cells Possible Values
    public void removePossibleValues(List<Cell> cellList){
        for(Cell c: cellList) {
            if (c.getValue() == 0) {
                if (c.getPossibleCellValues() != null) {
                    int count = -1;
                    if (c.getPossibleCellValues().size() == 2) {
                        for (Cell gridCells : cellList) {
                            if (c.getPossibleCellValues().equals((gridCells.getPossibleCellValues()))) {
                                count += 1;
                            }
                        }
                        if (count == 1) {
                            int firstContainedElement = c.getPossibleCellValues().get(0);
                            int secondContainedElement = c.getPossibleCellValues().get(1);
                            for (Cell cellIterator : cellList) {
                                if (cellIterator.getValue() == 0) {
                                    if (cellIterator.getPossibleCellValues() != null) {
                                        if (!(cellIterator.getPossibleCellValues().equals(c.getPossibleCellValues()))) {
                                            List<Integer> originalList = cellIterator.getPossibleCellValues();
                                            //System.out.println("Before OriginalPossibleValues for "+cellIterator+" -> "+cellIterator.getPossibleCellValues());
                                            originalList.remove(new Integer(firstContainedElement));
                                            originalList.remove(new Integer(secondContainedElement));
                                            cellIterator.setPossibleCellValues(originalList);
                                            //System.out.println("After updatedPossibleValues for "+cellIterator+" -> "+cellIterator.getPossibleCellValues());
                                        }
                                    }
                                }
                            }// Element Removal from Existing List
                        }
                    }
                }
            }
        }
    }

    //Check if only 1 Possible Value occurrence exactly once in all cells of grid's possible values
    public void evaluateSinglePossibleGridValue(Grid grid){
        for(int i = 1; i <= 9; i++){
            int countSingleElement = 0;
            int singleElement = i;
            for(Cell c: grid.getCells()){
                if(c.getPossibleCellValues() != null && c.getValue() == 0) {
                    if (c.getPossibleCellValues().contains(new Integer(singleElement))) countSingleElement += 1;
                }
            }
            if(countSingleElement == 1 && grid.getPossibleGridValues().contains(new Integer(singleElement))){
                for(Cell c: grid.getCells()){
                    if(c.getPossibleCellValues() != null && c.getValue() == 0) {
                        if (c.getPossibleCellValues().contains(new Integer(singleElement))) {
                            inputSoduko.getSoduko()[c.getxIndex()+grid.getxStartIndex()][c.getyIndex()+grid.getYstartIndex()] = singleElement;
                            grid.setGridValue(c.getxIndex()+""+c.getyIndex(),singleElement);
                            grid.setSum(grid.calculateGridSum());
                            grid.getPossibleGridValues().remove(new Integer(singleElement));
                            grid.setPossibleGridValues(grid.calculateGridPossibleValues());
                            c.setValue(singleElement);
                            inputSoduko.calculateSudukoSum();
                        }
                    }
                }
            }
        }
    }

    //This Method calculates the sum for 3*3 Matrix given initial point for Row and Column
    public int checkBoxSum(int initialPointRow, int initialPointColumn){
        int sum = 0;
        for(int i = initialPointRow; i < initialPointRow+3; i++){
            for(int j = initialPointColumn; j < initialPointColumn+3; j++){
                sum+=inputSoduko.getSoduko()[i][j];
            }
        }
        return sum;
    }
}

class Soduko{

    int[][] soduko;
    List<Grid> gridList;

    public Soduko(int[][] soduko){
        this.soduko= soduko;
        gridList = new ArrayList<>();
        initializeGridList(soduko);
    }

    public void setSoduko(int[][] soduko) {
        this.soduko = soduko;
    }

    public int[][] getSoduko() {
        return soduko;
    }

    public List<Grid> getGridList() {
        return gridList;
    }

    public void setGridList(List<Grid> gridList) {
        this.gridList = gridList;
    }

    public void initializeGridList(int[][] sodukoValues){

        gridList.add(new Grid("grid1", 0, 0, sodukoValues));
        gridList.add(new Grid("grid2", 0, 3, sodukoValues));
        gridList.add(new Grid("grid3", 0, 6, sodukoValues));
        gridList.add(new Grid("grid4", 3, 0, sodukoValues));
        gridList.add(new Grid("grid5", 3, 3, sodukoValues));
        gridList.add(new Grid("grid6", 3, 6, sodukoValues));
        gridList.add(new Grid("grid7", 6, 0, sodukoValues));
        gridList.add(new Grid("grid8", 6, 3, sodukoValues));
        gridList.add(new Grid("grid9", 6, 6, sodukoValues));

    }

    public void printSoduko() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(soduko[i][j] + "   ");
                if (j == 2 || j == 5) System.out.print("|   ");
            }
            System.out.println();
            if (i == 2 || i == 5) System.out.println("----------  |  ----------   |  ----------");
        }
    }

    public int calculateSudukoSum(){
        int result = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                result+=soduko[i][j];
            }
        }
        return result;
    }
}

class Grid{

    String gridName;
    int xStartIndex;
    int ystartIndex;
    int[][] gridValues;
    int sum;
    List<Integer> possibleGridValues;
    List<Cell> cells;

    public Grid(String gridName, int xStartIndex, int ystartIndex, int[][] sodukoValues){
        this.gridName = gridName;
        this.xStartIndex = xStartIndex;
        this.ystartIndex = ystartIndex;
        gridValues = new int[3][3];
        cells = new ArrayList<>();
        initializeGridValues(sodukoValues);
        this.possibleGridValues = new ArrayList<>();
        this.possibleGridValues = calculateGridPossibleValues();
        initializePossibleCellValues(this.possibleGridValues);
        this.sum = calculateGridSum();
    }

    public int getxStartIndex() {
        return xStartIndex;
    }

    public int getYstartIndex() {
        return ystartIndex;
    }

    public void setxStartIndex(int xStartIndex) {
        this.xStartIndex = xStartIndex;
    }

    public void setYstartIndex(int ystartIndex) {
        this.ystartIndex = ystartIndex;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getSum() {
        return sum;
    }

    public List<Integer> getPossibleGridValues() {
        return possibleGridValues;
    }

    public void setPossibleGridValues(List<Integer> possibleGridValues) {
        this.possibleGridValues = possibleGridValues;
    }

    public String getGridName() {
        return gridName;
    }

    public void setGridName(String gridName) {
        this.gridName = gridName;
    }

    public int[][] getGridValues() {
        return gridValues;
    }

    public void setGridValues(int[][] gridValues) {
        this.gridValues = gridValues;
    }

    public List<Cell> getCells() {
        return cells;
    }

    public void setCells(List<Cell> cells) {
        this.cells = cells;
    }

    public List<Integer> calculateGridPossibleValues(){
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3 ; j++){
                list.remove(new Integer(gridValues[i][j]));
            }
        }
        return list;
    }

    public int calculateGridSum(){
        int sum = 0;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3 ; j++){
                sum+=gridValues[i][j];
            }
        }
        return sum;
    }

    public void initializeGridValues(int[][] soduko){
        List<Integer> list = new ArrayList<>();
        for(int i = xStartIndex; i < xStartIndex+3; i++){
            for(int j = ystartIndex; j < ystartIndex+3; j++){
                list.add(soduko[i][j]);
            }
        }

        int listIndex = 0;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                gridValues[i][j] = list.get(listIndex);
                cells.add(new Cell(i,j,list.get(listIndex),gridName));
                listIndex+=1;
            }
        }
    }

    public void printGrid(){
        for(int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                System.out.print(gridValues[i][j]+"   ");
            }
            System.out.println();
        }
    }

    public String getIndexByValue(int value){
        String index = null;
        for(int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if(gridValues[i][j] == value)
                    index = i+""+j;
            }
        }
        return index;
    }

    public int getElementByIndex(String index){
        int element = 0;
        if(index.length()!=2) return 0;
        else {
            int xIndex = Character.getNumericValue(index.charAt(0));
            int yIndex = Character.getNumericValue(index.charAt(1));
            element = gridValues[xIndex][yIndex];
        }
        return element;
    }

    public void setGridValue(String index, int value){
        int xIndex = Character.getNumericValue(index.charAt(0));
        int yIndex = Character.getNumericValue(index.charAt(1));
        gridValues[xIndex][yIndex] = value;
    }

    public void initializePossibleCellValues(List<Integer> possibleGridValues){
        for(Cell c: cells){
            c.setPossibleCellValues(possibleGridValues);
        }
    }

}

class Cell{
    int xIndex;
    int yIndex;
    int value;
    String gridName;
    List<Integer> possibleCellValues;

    public Cell(int xIndex, int yIndex, int value, String gridName){
        this.xIndex = xIndex;
        this.yIndex = yIndex;
        this.value = value;
        this.gridName = gridName;
    }

    public int getxIndex() {
        return xIndex;
    }

    public void setxIndex(int xIndex) {
        this.xIndex = xIndex;
    }

    public int getyIndex() {
        return yIndex;
    }

    public void setyIndex(int yIndex) {
        this.yIndex = yIndex;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public List<Integer> getPossibleCellValues() {
        return possibleCellValues;
    }

    public void setPossibleCellValues(List<Integer> possibleCellValues) {
        this.possibleCellValues = new ArrayList<>(possibleCellValues);
    }

    public String getGridName() {
        return gridName;
    }

    public void setGridName(String gridName) {
        this.gridName = gridName;
    }

    @Override
    public String toString() {
        return "[xIndex="+xIndex+", yIndex="+yIndex+", Value="+value+", gridName="+gridName+"]";
    }

}

class SodukoInputReader{
    int[][] input;
    public SodukoInputReader(){

        /* Raw Input Format
        input = new int[9][9];
        input[0][0] = 0;  input[0][1] = 0;  input[0][2] = 0;  input[0][3] = 0;  input[0][4] = 0;  input[0][5] = 0;  input[0][6] = 0;  input[0][7] = 0;  input[0][8] = 0;
        input[1][0] = 0;  input[1][1] = 0;  input[1][2] = 0;  input[1][3] = 0;  input[1][4] = 0;  input[1][5] = 0;  input[1][6] = 0;  input[1][7] = 0;  input[1][8] = 0;
        input[2][0] = 0;  input[2][1] = 0;  input[2][2] = 0;  input[2][3] = 0;  input[2][4] = 0;  input[2][5] = 0;  input[2][6] = 0;  input[2][7] = 0;  input[2][8] = 0;

        input[3][0] = 0;  input[3][1] = 0;  input[3][2] = 0;  input[3][3] = 0;  input[3][4] = 0;  input[3][5] = 0;  input[3][6] = 0;  input[3][7] = 0;  input[3][8] = 0;
        input[4][0] = 0;  input[4][1] = 0;  input[4][2] = 0;  input[4][3] = 0;  input[4][4] = 0;  input[4][5] = 0;  input[4][6] = 0;  input[4][7] = 0;  input[4][8] = 0;
        input[5][0] = 0;  input[5][1] = 0;  input[5][2] = 0;  input[5][3] = 0;  input[5][4] = 0;  input[5][5] = 0;  input[5][6] = 0;  input[5][7] = 0;  input[5][8] = 0;

        input[6][0] = 0;  input[6][1] = 0;  input[6][2] = 0;  input[6][3] = 0;  input[6][4] = 0;  input[6][5] = 0;  input[6][6] = 0;  input[6][7] = 0;  input[6][8] = 0;
        input[7][0] = 0;  input[7][1] = 0;  input[7][2] = 0;  input[7][3] = 0;  input[7][4] = 0;  input[7][5] = 0;  input[7][6] = 0;  input[7][7] = 0;  input[7][8] = 0;
        input[8][0] = 0;  input[8][1] = 0;  input[8][2] = 0;  input[8][3] = 0;  input[8][4] = 0;  input[8][5] = 0;  input[8][6] = 0;  input[8][7] = 0;  input[8][8] = 0;
        */

        /* Sample1
        input = new int[9][9];

        input[0][3] = 2;input[0][4] = 6;input[0][6] = 7;input[0][8] = 1;
        input[1][0] = 6;input[1][1] = 8;input[1][4] = 7;input[1][7] = 9;
        input[2][0] = 1;input[2][1] = 9;input[2][5] = 4;input[2][6] = 5;

        input[3][0] = 8;input[3][1] = 2;input[3][3] = 1;input[3][7] = 4;
        input[4][2] = 4;input[4][3] = 6;input[4][5] = 2;input[4][6] = 9;
        input[5][1] = 5;input[5][5] = 3;input[5][7] = 2;input[5][8] = 8;

        input[6][2] = 9;input[6][3] = 3;input[6][7] = 7;input[6][8] = 4;
        input[7][1] = 4;input[7][4] = 5;input[7][7] = 3;input[7][8] = 6;
        input[8][0] = 7;input[8][2] = 3;input[8][4] = 1;input[8][5] = 8;
         */

        /*Sample2
        input = new int[9][9];
        input[0][0] = 3;  input[0][1] = 9;  input[0][2] = 0;  input[0][3] = 1;  input[0][4] = 0;  input[0][5] = 0;  input[0][6] = 0;  input[0][7] = 0;  input[0][8] = 0;
        input[1][0] = 0;  input[1][1] = 0;  input[1][2] = 0;  input[1][3] = 0;  input[1][4] = 0;  input[1][5] = 0;  input[1][6] = 0;  input[1][7] = 2;  input[1][8] = 4;
        input[2][0] = 4;  input[2][1] = 0;  input[2][2] = 0;  input[2][3] = 0;  input[2][4] = 0;  input[2][5] = 7;  input[2][6] = 3;  input[2][7] = 0;  input[2][8] = 9;

        input[3][0] = 5;  input[3][1] = 0;  input[3][2] = 4;  input[3][3] = 2;  input[3][4] = 0;  input[3][5] = 0;  input[3][6] = 0;  input[3][7] = 0;  input[3][8] = 6;
        input[4][0] = 0;  input[4][1] = 2;  input[4][2] = 0;  input[4][3] = 5;  input[4][4] = 0;  input[4][5] = 4;  input[4][6] = 0;  input[4][7] = 8;  input[4][8] = 0;
        input[5][0] = 7;  input[5][1] = 0;  input[5][2] = 0;  input[5][3] = 0;  input[5][4] = 0;  input[5][5] = 1;  input[5][6] = 4;  input[5][7] = 0;  input[5][8] = 2;

        input[6][0] = 8;  input[6][1] = 0;  input[6][2] = 7;  input[6][3] = 4;  input[6][4] = 0;  input[6][5] = 0;  input[6][6] = 0;  input[6][7] = 0;  input[6][8] = 3;
        input[7][0] = 9;  input[7][1] = 5;  input[7][2] = 0;  input[7][3] = 0;  input[7][4] = 0;  input[7][5] = 0;  input[7][6] = 0;  input[7][7] = 0;  input[7][8] = 0;
        input[8][0] = 0;  input[8][1] = 0;  input[8][2] = 0;  input[8][3] = 0;  input[8][4] = 0;  input[8][5] = 5;  input[8][6] = 0;  input[8][7] = 9;  input[8][8] = 8;
        */

        /* Sample 3 (GL)
        input = new int[9][9];
        input[0][0] = 0;  input[0][1] = 7;  input[0][2] = 8;  input[0][3] = 0;  input[0][4] = 4;  input[0][5] = 3;  input[0][6] = 0;  input[0][7] = 0;  input[0][8] = 9;
        input[1][0] = 4;  input[1][1] = 0;  input[1][2] = 0;  input[1][3] = 6;  input[1][4] = 0;  input[1][5] = 0;  input[1][6] = 0;  input[1][7] = 0;  input[1][8] = 2;
        input[2][0] = 0;  input[2][1] = 0;  input[2][2] = 0;  input[2][3] = 0;  input[2][4] = 0;  input[2][5] = 7;  input[2][6] = 0;  input[2][7] = 0;  input[2][8] = 4;

        input[3][0] = 5;  input[3][1] = 0;  input[3][2] = 9;  input[3][3] = 0;  input[3][4] = 0;  input[3][5] = 1;  input[3][6] = 0;  input[3][7] = 2;  input[3][8] = 0;
        input[4][0] = 1;  input[4][1] = 0;  input[4][2] = 0;  input[4][3] = 0;  input[4][4] = 3;  input[4][5] = 0;  input[4][6] = 0;  input[4][7] = 0;  input[4][8] = 8;
        input[5][0] = 0;  input[5][1] = 8;  input[5][2] = 0;  input[5][3] = 5;  input[5][4] = 0;  input[5][5] = 0;  input[5][6] = 4;  input[5][7] = 0;  input[5][8] = 3;

        input[6][0] = 7;  input[6][1] = 0;  input[6][2] = 0;  input[6][3] = 3;  input[6][4] = 0;  input[6][5] = 0;  input[6][6] = 0;  input[6][7] = 0;  input[6][8] = 0;
        input[7][0] = 8;  input[7][1] = 0;  input[7][2] = 0;  input[7][3] = 0;  input[7][4] = 0;  input[7][5] = 4;  input[7][6] = 0;  input[7][7] = 0;  input[7][8] = 1;
        input[8][0] = 3;  input[8][1] = 0;  input[8][2] = 0;  input[8][3] = 9;  input[8][4] = 5;  input[8][5] = 0;  input[8][6] = 2;  input[8][7] = 4;  input[8][8] = 0;
        */

        /* Sample 4 (GL)*/
        input = new int[9][9];
        input[0][0] = 0;  input[0][1] = 0;  input[0][2] = 2;  input[0][3] = 0;  input[0][4] = 0;  input[0][5] = 0;  input[0][6] = 9;  input[0][7] = 0;  input[0][8] = 5;
        input[1][0] = 0;  input[1][1] = 0;  input[1][2] = 0;  input[1][3] = 0;  input[1][4] = 0;  input[1][5] = 0;  input[1][6] = 0;  input[1][7] = 0;  input[1][8] = 0;
        input[2][0] = 0;  input[2][1] = 0;  input[2][2] = 0;  input[2][3] = 0;  input[2][4] = 7;  input[2][5] = 0;  input[2][6] = 4;  input[2][7] = 6;  input[2][8] = 0;

        input[3][0] = 9;  input[3][1] = 0;  input[3][2] = 0;  input[3][3] = 1;  input[3][4] = 0;  input[3][5] = 0;  input[3][6] = 0;  input[3][7] = 0;  input[3][8] = 0;
        input[4][0] = 0;  input[4][1] = 0;  input[4][2] = 5;  input[4][3] = 6;  input[4][4] = 0;  input[4][5] = 0;  input[4][6] = 3;  input[4][7] = 0;  input[4][8] = 0;
        input[5][0] = 0;  input[5][1] = 6;  input[5][2] = 1;  input[5][3] = 0;  input[5][4] = 0;  input[5][5] = 0;  input[5][6] = 0;  input[5][7] = 0;  input[5][8] = 8;

        input[6][0] = 0;  input[6][1] = 8;  input[6][2] = 0;  input[6][3] = 2;  input[6][4] = 0;  input[6][5] = 0;  input[6][6] = 0;  input[6][7] = 0;  input[6][8] = 0;
        input[7][0] = 7;  input[7][1] = 4;  input[7][2] = 0;  input[7][3] = 0;  input[7][4] = 0;  input[7][5] = 3;  input[7][6] = 1;  input[7][7] = 0;  input[7][8] = 0;
        input[8][0] = 0;  input[8][1] = 0;  input[8][2] = 0;  input[8][3] = 0;  input[8][4] = 8;  input[8][5] = 9;  input[8][6] = 0;  input[8][7] = 0;  input[8][8] = 0;

    }

    public int[][] getInput() {
        return input;
    }

    public void setInput(int[][] input) {
        this.input = input;
    }
}
