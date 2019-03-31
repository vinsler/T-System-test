package com.tsystems.javaschool.tasks.pyramid;

import java.util.List;

public class PyramidDraw {
    private static List<Integer> inputNumbers;
    private static int countRows;

    public PyramidDraw(List<Integer> inputNumbers, int countRows){
        this.inputNumbers = inputNumbers;
        this.countRows = countRows;
    }

    public int[][] draw(){
        int printZero = 0;
        int printArray [][] = new int[countRows][inputNumbers.size()];

        System.out.println(countRows);

        for (int i = 0; i < countRows; i++) { // go through the rows
            printZero = (countRows * 2 - ((i+1) * 2 - 1)) / 2;
            for (int j = 0; j < (countRows * 2) - 1; j++) { // go through the columns
                if (printZero != 0) {
                    printArray[i][j] = 0;
                    System.out.print(printArray[i][j] + " ");
                    printZero--;
                } else {
                    printArray[i][j] = inputNumbers.get(i);
                    printZero = (countRows * 2 - ((i+1) * 2 - 1)) / 2;
                    System.out.print(printArray[i][j] + " ");
                    if (i > 1) { // todo fill array between indent left & right

                    }
                }
            }
            System.out.println();
        }
        return printArray;
    }
}
