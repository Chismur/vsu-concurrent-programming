package com.vsu;

public class Matrix {
    private int[][] data;

    /**
     * dimensions of the matrix
     */
    private int n, m;

    private int maxElem;

    public int[][] getData() {
        return data;
    }

    public void setData(int[][] data) {
        this.data = data;
    }

    public int getMaxElem() {
        return maxElem;
    }

    public void setMaxElem(int maxElem) {
        this.maxElem = maxElem;
    }

    public int getN() {
        return data.length;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getM() {
        return data[0].length;
    }

    public void setM(int m) {
        this.m = m;
    }

    private int getBySequenceNumber(int sequenceNumber) {
        if (sequenceNumber >= 0 && sequenceNumber <= data.length* data[0].length) {
            int i = sequenceNumber / data[0].length;
            int j = sequenceNumber % data[0].length;
            return data[i][j];
        } else {
            throw new IndexOutOfBoundsException("Sequence Number is out of bounds of a matrix");
        }
    }


    /**
     * @param startIndex index of the left bound (matrix here is treated like a linear array)
     * @param endIndex   index of the right bound (matrix here is treated like a linear array)
     * @return maxElem element of the matrix in given bounds which is divisible by three
     */
    public int getMax(int startIndex, int endIndex) {
        int max = Integer.MIN_VALUE;
        for (int i = startIndex; i < endIndex; i++) {
            int testElement = getBySequenceNumber(i);
            if (testElement % 3 == 0 && testElement > max) {
                max = testElement;
            }
        }
        return max;
    }


    //todo: read from file
    //todo: get/set elements
}
