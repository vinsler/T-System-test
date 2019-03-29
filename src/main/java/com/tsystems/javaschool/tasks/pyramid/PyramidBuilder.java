package com.tsystems.javaschool.tasks.pyramid;

import java.util.Arrays;
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
        PyramidDraw pyramidDraw = new PyramidDraw(inputNumbers);

        if (validation.isValidate()) {
            System.out.println("validation ok!");
            return pyramidDraw.draw();
        } else {
            System.out.println("validation fail");
            throw new CannotBuildPyramidException();
        }

    }

    public static void main(String[] args) {
        PyramidBuilder pyramidBuilder = new PyramidBuilder();
        pyramidBuilder.buildPyramid(Arrays.asList(1, 3, 6, 4, 5, 7));
    }

}
