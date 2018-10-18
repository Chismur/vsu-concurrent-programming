package com.vsu;

import java.io.*;
import java.util.Random;

import static com.sun.org.apache.bcel.internal.classfile.Utility.printArray;

public class Main {

    private static final String PATH = "./matrix.txt";
    //private static final String PATH_TEST = "./matrixTest.txt";
    private static final int rows = 10;
    private static final int cols = 10;

    public static void main(String[] args) {

        FileReaderUtils fileReaderUtils = new FileReaderUtils(PATH);

        int[][] arr = fileReaderUtils.getRandomMatrix(rows,cols);

        fileReaderUtils.printArray(arr);

        fileReaderUtils.saveArrayToFile(arr, PATH);

        int[][] nArr = fileReaderUtils.loadArrayFromFile(PATH);

    }





}
