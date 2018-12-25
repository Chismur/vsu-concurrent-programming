package com.vsu;

import java.util.HashMap;
import java.util.Map;

public class BorderRules {

    private double[][] matrix;
    private double[] f;

    public BorderRules(double[][] matrix, double[] f) {
        this.matrix = matrix;
        this.f = f;
    }

    public void countBorderRules(HashMap<Integer, Double> hashMap) {
        for (Map.Entry<Integer, Double> entry : hashMap.entrySet()) {
            int key = entry.getKey();
            double val = entry.getValue();

            matrix[key][key] = 1;
            f[key] = val;

            for (int i = 1; i < matrix.length; i++) {
                if (i != key) {
                    matrix[key][i] = 0;
                    f[i] = f[i] - matrix[i][key] * val;
                    matrix[i][key] = 0;
                }
            }
        }
    }

    void showMatrix() {
        for (double[] aMatrix : this.matrix) {
            for (double anAMatrix : aMatrix) {
                System.out.print(anAMatrix + " ");
            }
            System.out.println();
        }
    }

    void showVector() {
        for (double aF : f) {
            System.out.println(aF);
        }
    }

    void showConditions(HashMap<Integer, Double> map) {
        for (Map.Entry<Integer,Double> entry:map.entrySet()) {
            System.out.println("key = "+entry.getKey()+" value = "+entry.getValue());
        }
    }
}
