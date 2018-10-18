package com.vsu;

import java.util.ArrayList;
import java.util.List;

public class MaxFinder {

    private int result;

    public static int findMax(Matrix matrix, int threadCount) throws InterruptedException {

        List<Thread> threads = new ArrayList<>();
        int elementsPerThread = matrix.getM() * matrix.getN() / threadCount;
        int elementsLeft = matrix.getM() * matrix.getN() % threadCount;

        for (int i = 0; i < threadCount; i++) {
            threads.add(new Thread(new MatrixRunnable(
                    i * elementsPerThread,
                    (i + 1) * elementsPerThread + (i % (threadCount) * elementsLeft),
                    matrix)));
        }

        for(Thread thread: threads){
            thread.start();
        }
        for(Thread thread: threads){
            thread.join();
        }
        return matrix.getMaxElem();
    }
}
