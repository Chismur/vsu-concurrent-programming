package com.vsu;

import java.io.*;
import java.util.Random;

public class FileReaderUtils {

    private String path;

    public FileReaderUtils(String path) {
        this.path = path;
    }

    public  void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void saveArrayToFile(int[][] arr, String path) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(path));
            bw.write(String.valueOf(arr.length));
            bw.newLine();
            bw.write(String.valueOf(arr[0].length));
            bw.newLine();
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    bw.write(String.valueOf(arr[i][j]));
                    bw.newLine();
                }
            }
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int[][] loadArrayFromFile(String path) {
        int[][] arr = null;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            // first 2 lines = rows and columns
            int rows = Integer.parseInt(br.readLine());
            int cols = Integer.parseInt(br.readLine());
            arr = new int[rows][cols];

            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    arr[i][j] = Integer.parseInt(br.readLine());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arr;
    }

    public int[][] getRandomMatrix(int rows, int cols){
        int[][] arr = new int[rows][cols];

        Random random = new Random();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arr[i][j] = random.nextInt(100);
            }
        }
        return arr;
    }
}
