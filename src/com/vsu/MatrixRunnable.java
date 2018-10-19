package com.vsu;

public class MatrixRunnable implements Runnable {

    private int start, end, result;
    private final Matrix matrix;
    private Integer test;

    public MatrixRunnable(int start, int end, Matrix matrix) {
        this.start = start;
        this.end = end;
        this.matrix = matrix;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+ " Started running... ");
        int max = matrix.getMax(start, end);
        System.out.println(Thread.currentThread().getName()+ " Found max =" + max);
        if (matrix.getMaxElem() < max) {
            synchronized (matrix) {
                System.out.println(Thread.currentThread().getName()+ " Rewriting previous max");
                matrix.setMaxElem(max);
            }
        }
    }
}
