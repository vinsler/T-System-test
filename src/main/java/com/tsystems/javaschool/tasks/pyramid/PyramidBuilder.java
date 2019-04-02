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
}