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
        int max = matrix.getMax(start, end);
        if (matrix.getMaxElem() < max) {
            synchronized (matrix) {
                matrix.setMaxElem(max);
            }
        }
    }
}
