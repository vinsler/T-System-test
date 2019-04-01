package com.tsystems.javaschool.tasks.pyramid;

import java.util.List;

public class PyramidDraw {
    private static List<Integer> inputNumbers;
    private int countRows;

    public PyramidDraw(List<Integer> inputNumbers, int countRows){
        this.inputNumbers = inputNumbers;
        this.countRows = countRows;
    }

    public int[][] draw(){
        int printZero = 0;
        int printArray [][] = new int[countRows][(countRows * 2) - 1];

        int countPositionArray = 0;
        int nowPositionRows = 1;
        for (int i = 0; i < countRows; i++) { // go through the rows
            printZero = (countRows * 2 - ((i+1) * 2 - 1)) / 2;
            for (int j = 0; j < (countRows * 2) - 1; j++) { // go through the columns
                if (printZero != 0) {
                    printArray[i][j] = 0;
                    printZero--;
                } else {
                    printArray[i][j] = inputNumbers.get(countPositionArray);
                    countPositionArray++; // next Position Array
                    printZero = (countRows * 2 - ((i+1) * 2 - 1)) / 2;
                    if (i > 0) { // go through internal row
                        nowPositionRows += 2; // increment the internal row by +2 [ 1 left + 1 right ]
                        for (int t = 1; t < nowPositionRows; t++) {
                            if (t % 2 != 0) { // every even zero
                                j++;
                                printArray[i][j] = 0;
                            } else {
                                j++;
                                printArray[i][j] = inputNumbers.get(countPositionArray);
                                countPositionArray++;
                            }
                        }
                    }
                }
            }
        }
        return printArray;
    }
}