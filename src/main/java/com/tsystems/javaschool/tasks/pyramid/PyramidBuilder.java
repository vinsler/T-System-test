package com.tsystems.javaschool.tasks.pyramid;

import java.util.Collections;
import java.util.List;

public class PyramidBuilder {
    /**
     * Builds a pyramid with sorted values (with minumum value at the top line and maximum at the bottom,
     * from left to right). All vacant positions in the array are zeros.
     *
     * @param inputNumbers to be used in the pyramid
     * @return 2d array with pyramid inside
     * @throws {@link CannotBuildPyramidException} if the pyramid cannot be build with given input
     */
    public int[][] buildPyramid(List<Integer> inputNumbers) {
        Validation validation = new Validation(inputNumbers);

        if (validation.isValidate()) {
            Collections.sort(inputNumbers);
            PyramidDraw pyramidDraw = new PyramidDraw(inputNumbers, validation.getCountRows());
            return pyramidDraw.draw();
        } else {
            CannotBuildPyramidException cannotBuildPyramidException = new CannotBuildPyramidException();
            cannotBuildPyramidException.listDontValidate();
            throw cannotBuildPyramidException;
        }
    }

//    public static void main(String[] args) { // may be useful for checking
//        PyramidBuilder pyramidBuilder = new PyramidBuilder();
//        List<Integer> input = Arrays.asList(1, 3, 2, 9, 4, 5);
//        int[][] intArr = pyramidBuilder.buildPyramid(input);
//
//        for (int i = 0; i < intArr.length ; i++) {
//            System.out.println();
//            for (int j = 0; j < intArr[1].length; j++){
//                System.out.print(intArr[i][j]);
//                System.out.print(" ");
//            }
//        }
//    }
}