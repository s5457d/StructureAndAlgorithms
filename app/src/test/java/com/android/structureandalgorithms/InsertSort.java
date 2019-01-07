package com.android.structureandalgorithms;

import org.junit.Test;

/**
 * @author by sunzhongda
 * @date 2019/1/7
 */
public class InsertSort {

    @Test
    public void test() {
        int[] array = new int[]{5, 1, 7, 2, 3, 9, 8, 4, 0, 6};

        insertSortDo(array);

        for (int anArray : array) {
            System.out.print(anArray + " ");
        }
    }

    /**
     * 插入排序
     * @param array
     */
    private void insertSortDo(int[] array) {

        int index = 1;
        for (int i = index; i < array.length; i++) {
            int j = i;
            int target = array[j];
            while (j > 0 && array[j] < array[j - 1]) {
                int temp = array[j];
                array[j] = array[j - 1];
                array[j - 1] = temp;
                j = j - 1;
            }

            array[j] = target;
        }

    }
}
