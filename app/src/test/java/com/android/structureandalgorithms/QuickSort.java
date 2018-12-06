package com.android.structureandalgorithms;

import org.junit.Test;

/**
 * @author by sunzhongda
 * @date 2018/12/6
 */
public class QuickSort {

    @Test
    public void test() {
        int[] array = new int[]{3, 2, 1, 4, 5, 6, 5, 6, 0, 9};
        quickSort(array, 0, array.length - 1);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    private void quickSort(int[] array, int from, int end) {
        if (from >= end) return;

        int low = from;
        int high = end;

        boolean direcation = true;
        int index = array[low];
        L1:
        while (low < high) {
            if (direcation) {
                for (int i = high; i > low; i--) {
                    if (array[i] <= index) {// 比参照物的数据小，左移后，更改遍历方向。
                        array[low++] = array[i];
                        direcation = !direcation;
                        high = i;
                        continue L1;
                    }
                }
                high = low;
            } else {
                for (int i = low; i < high; i++) {
                    if (array[i] >= index) {// 比参照物的数据大，右移后，更改遍历方向。
                        array[high--] = array[i];
                        direcation = !direcation;
                        low = i;
                        continue L1;
                    }
                }
                low = high;
            }
        }
        array[low] = index;
        quickSort(array, from, low - 1);
        quickSort(array, low + 1, end);
    }

}
