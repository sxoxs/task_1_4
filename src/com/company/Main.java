package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Введите диапазон чисел в формате \"[a;b]\": ");

        System.out.println(Arrays.toString( getRandomRange(getRange(inConsole().trim())) ));
    }

    static String inConsole () throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
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

    static int[] getRandomRange (int[] ar) {
        Random rand = new Random();
        int[] rr = new int[10];

        if (ar[0] >= 0) {
            for (int i = 0; i < 10; i++) {
                rr[i] = (rand.nextInt(ar[1] - ar[0] + 1) + ar[0]);
            }
        }
        else {
            if (ar[1] >= 0) {
                for (int i = 0; i < 10; i++) {
                    rr[i] = (rand.nextInt( Math.abs(ar[0]) + ar[1] +1) + ar[0]);
                }
            }
            else {
                for (int i = 0; i < 10; i++) {
                    rr[i] = (rand.nextInt(Math.abs(ar[0] - ar[1]) + 1)+ ar[0]);
                }
            }
        }
        return rr;
    }

}



