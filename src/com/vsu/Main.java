package com.vsu;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        double[][] m = {
                {2,4,0,0,0},
                {4,2,1,2,0},
                {0,1,3,4,3},
                {0,2,4,2,0},
                {0,0,3,0,1} };

        double[] f = {8,23,19,12,14};

        HashMap<Integer,Double> map = new HashMap<>();
        map.put(0,2.0);
        map.put(4,2.0);

        BorderRules borderRules = new BorderRules(m,f);
        System.out.println("Initial matrix : ");
        borderRules.showMatrix();
        System.out.println("Initial vector f : ");
        borderRules.showVector();
        System.out.println("Border conditions : ");
        borderRules.showConditions(map);
        borderRules.countBorderRules(map);
        System.out.println("Result matrix : ");
        borderRules.showMatrix();
        System.out.println("Result vector f : ");
        borderRules.showVector();




    }


}
