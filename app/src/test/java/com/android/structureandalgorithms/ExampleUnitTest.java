package com.android.structureandalgorithms;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void swap() {
        int a = 4;
        int b = 3;

        byte c = 1;
        byte d = 2;
        c = (byte) (c^d);
        d = (byte) (c^d);
        c = (byte) (c^d);
        System.out.println("c = " + c + " d = " + d);
        //1
//        int temp = a;
//        a = b;
//        b = temp;
//
//        System.out.println("a = " + a + " b = " + b);

        // 2
//        a = a + b;
//        b = a - b;
//        a = a - b;
//        System.out.println("a = " + a + " b = " + b);

        // 3
//        a = a ^ b;
//        b = a ^ b;
//        a = a ^ b;
//        System.out.println("a = " + a + " b = " + b);
    }

    @Test
    public void sort() {
        int[] array = new int[]{9, 8, 2, 4, 3, 1, 5, 7, 6};

//        selectSort(array);
//        bobbleSort(array);
        Arrays.sort(array);
        for (int i : array) {
            System.out.print(" " + i);
        }
    }

    public void bobbleSort(int array[]) {
        for (int j = array.length - 1; j > 0; j--) {
            boolean flag = false;
            for (int i = 0; i < j; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    flag = true;
                }
            }
            if (!flag)
                break;
            for (int i : array) {
                System.out.print(" " + i);
            }
            System.out.println();
        }
    }

    public void selectSort(int array[]) {

        for (int j = 0; j < array.length - 1; j++) {

            int index = j;
            for (int i = index + 1; i < array.length; i++) {
                if (array[i] < array[index])
                    index = i;
            }
            if (index != j) {
                int temp = array[index];
                array[index] = array[j];
                array[j] = temp;
            }
            for (int i : array) {
                System.out.print(" " + i);
            }
            System.out.println();
        }
    }
}