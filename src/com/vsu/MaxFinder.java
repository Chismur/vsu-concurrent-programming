package com.vsu;

import java.util.ArrayList;
import java.util.List;

public class MaxFinder {

    private int result;

    private static final int MIN_ELEMENTS_PER_THREAD = 30;

    public static int findMax(Matrix matrix) throws InterruptedException {

        List<Thread> threads = new ArrayList<>();
        int elementsCount = matrix.getM() * matrix.getN();
        int threadCount = (elementsCount / MIN_ELEMENTS_PER_THREAD > 3) ?
                3 : elementsCount / MIN_ELEMENTS_PER_THREAD - 1;
        if (elementsCount < MIN_ELEMENTS_PER_THREAD) {
            threadCount = 0;
        }
        int elementsPerThread = matrix.getM() * matrix.getN() / (threadCount + 1);
        int i;
        for (i = 0; i < threadCount; i++) {
            threads.add(new Thread(new MatrixRunnable(
                    i * elementsPerThread,
                    (i + 1) * elementsPerThread,
                    matrix)));
        }
        int startPositionForMainThread = (threadCount == 0) ? 0 : i* elementsPerThread;

        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        return startPositionForMainThread;
    }
}
