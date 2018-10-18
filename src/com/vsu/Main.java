package com.vsu;

public class Main {

    private static final String PATH = "./resources/matrix.txt";
    //private static final String PATH_TEST = "./matrixTest.txt";
    private static final int rows = 5;
    private static final int cols = 5;

    public static void main(String[] args) {


        FileReaderUtils fileReaderUtils = new FileReaderUtils(PATH);

        //int[][] arr = fileReaderUtils.getRandomMatrix(rows,cols);

        //fileReaderUtils.printArray(arr);


        //fileReaderUtils.saveArrayToFile(arr, PATH);

        int[][] nArr = fileReaderUtils.loadArrayFromFile(PATH);
        fileReaderUtils.printArray(nArr);

        Matrix matrix = new Matrix();
        matrix.setData(nArr);
        try {
            System.out.println(MaxFinder.findMax(matrix, 1));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();


    }





}
