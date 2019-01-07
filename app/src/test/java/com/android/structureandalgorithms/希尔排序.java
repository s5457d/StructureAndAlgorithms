package com.android.structureandalgorithms;

import org.junit.Test;

/**
 * @author by sunzhongda
 * @date 2019/1/7
 */
public class 希尔排序 {


    @Test
    public void test() {
        int[] array = new int[]{5, 1, 7, 2, 3, 9, 8, 4, 0, 6};

        insertSortDo(array, 5);
        insertSortDo(array, 3);
        insertSortDo(array, 1);

        for (int anArray : array) {
            System.out.print(anArray + " ");
        }
    }

    /**
     * 插入排序
     *
     * @param array
     */
    private void insertSortDo(int[] array, int step) {

        for (int k = 0; k < step; k++) {
            for (int i = k + step; i < array.length; i = i + step) {
                int j = i;
                int target = array[j];
                while (j > step - 1 && target < array[j - step]) {
                    array[j] = array[j - step];
                    j = j - step;
                }

                array[j] = target;
            }
        }

    }
}
