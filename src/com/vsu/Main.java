package com.vsu;

public class Main {

    private static final String PATH = "./resources/matrix.txt";
    //private static final String PATH_TEST = "./matrixTest.txt";
    private static final int rows = 1000;
    private static final int cols = 1000;
    private static final Matrix matrix = new Matrix();
    public static void main(String[] args) {


        FileReaderUtils fileReaderUtils = new FileReaderUtils(PATH);
//
        int[][] arr = fileReaderUtils.getRandomMatrix(rows,cols);

        //fileReaderUtils.printArray(arr);


        //fileReaderUtils.saveArrayToFile(arr, PATH);

//        int[][] nArr = fileReaderUtils.loadArrayFromFile(PATH);
//        fileReaderUtils.printArray(nArr);


        matrix.setData(arr);


        int max;
        int startPos;
        try {
            startPos = MaxFinder.findMax(matrix);
            System.out.println(Thread.currentThread().getName() + "thread Started");
            max = matrix.getMax(startPos, matrix.getM()*matrix.getN()-1);
            System.out.println(Thread.currentThread().getName() + "thread found max = " + max);
            if (matrix.getMaxElem() < max){
                synchronized (matrix){
                    System.out.println(Thread.currentThread().getName() + "thread rewriting max");
                    matrix.setMaxElem(max);
                }
            }
            System.out.println(matrix.getMaxElem());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();


    }


}
