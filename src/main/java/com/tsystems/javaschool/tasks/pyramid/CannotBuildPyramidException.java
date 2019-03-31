package com.tsystems.javaschool.tasks.pyramid;

public class CannotBuildPyramidException extends RuntimeException {

    public void listDontValidate(){
        System.err.println("Please check you data in the input list!");
    }
}
