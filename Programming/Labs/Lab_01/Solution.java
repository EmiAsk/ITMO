import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;
import java.lang.Math;

// Лабораторная по программированию №1

public class Solution {

    // Константы для 1го пункта
    public static final int MIN_VALUE_1 = 3;
    public static final int MAX_VALUE_1 = 15;

    // Константы для 2го пункта
    public static final int ARRAY_SIZE_2 = 15;
    public static final float MIN_VALUE_2 = -5;
    public static final float MAX_VALUE_2 = 7;

    // Константы для 3го пункта
    public static final int N_ROWS = 13;
    public static final int N_COLS = 15;

    public static void main(String[] args) {

        // 1й пункт
        int arraySize = MAX_VALUE_1 - MIN_VALUE_1 + 1;
        short[] a = new short[arraySize];

        for (int i = 0; i < arraySize; i++) {
            a[i] = (short) (MAX_VALUE_1 - i);
        }


        // 2й пункт
        float[] x = new float[ARRAY_SIZE_2];
        Random rnd = new Random();

        for (int i = 0; i < ARRAY_SIZE_2; i++) {
            x[i] = rnd.nextFloat() * (MAX_VALUE_2 - MIN_VALUE_2) + MIN_VALUE_2;
        }


        // 3й пункт
        double[][] a2 = new double[N_ROWS][N_COLS];

        // Вспомогательные переменные для вычисления сложных математических выражений
        double part_1, part_2;

        for (int i = 0; i < N_ROWS; i++) {
            
            if (a[i] == 3) {
                for (int j = 0; j < N_COLS; j++) {
                    part_1 = Math.sin(Math.pow(x[j], 1f / 3));
                    part_2 = 1f / 4 / Math.tan(Math.sin(x[j]));
                    a2[i][j] = Math.pow(part_1, part_2);
                }
                continue;
            }

            if (a[i] == 4 || a[i] == 7 || a[i] == 9 || a[i] == 11 || a[i] == 12 || a[i] == 14) {
                for (int j = 0; j < N_COLS; j++) {
                    a2[i][j] = Math.sin(Math.tan(Math.tan(x[j])));
                }
                continue;
            }

            for (int j = 0; j < N_COLS; j++) {
                part_1 = Math.pow((1f / 2) / x[j], x[j]);
                part_2 = (Math.pow(x[j], (1 - x[j]) / x[j])) / (1 - Math.log(Math.abs(x[j])));

                a2[i][j] = Math.tan(Math.pow(Math.pow(part_1, part_2) - 4, 3));

            }
        }

        // Вывод массива
        System.out.print("Вывод массива:\n\n");
        for (int i = 0; i < N_ROWS; i++) {
            for (int j = 0; j < N_COLS; j++) {
                System.out.printf("%.3f\t", a2[i][j]);
            }
            System.out.println();
        }
      
    }
}
