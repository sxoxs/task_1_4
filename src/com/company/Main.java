package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IOException {
        int[] intRangeArray;
        int[] intArray;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите диапазон чисел в формате \"[a;b]\": ");
        intRangeArray = getRange(br.readLine().trim());
        intArray = getRandomArray(intRangeArray[0], intRangeArray[1]);
        System.out.println(Arrays.toString( intArray ));
    }

    static int[] getRange(String str) {
        String strTemp = "";
        int[] array = new int[2];

        for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) {
                case '[':
                case ' ': {
                    continue;
                }
                case ';': {
                    array[0] = Integer.parseInt(strTemp);
                    strTemp = "";
                    continue;
                }
                case ']': {
                    break;
                }
                default: {
                    strTemp += str.charAt(i);
                }
            }
        }
        array[1] = Integer.parseInt(strTemp);

        return array;
    }

    static int[] getRandomArray(int min, int max) {
        Random rand = new Random();
        int[] rr = new int[10];

        for (int i = 0; i < 10; i++) {
            rr[i] = (rand.nextInt( max - min + 1) + min);
        }
        return rr;
    }

}



