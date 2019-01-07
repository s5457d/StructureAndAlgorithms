package com.android.structureandalgorithms;

import org.junit.Test;

/**
 * @author by sunzhongda
 * @date 2019/1/7
 */
public class 堆排序 {


    @Test
    public void test() {
        int[] array = new int[]{5, 1, 7, 2, 3, 9, 8, 4, 0, 6};

        heapSort(array, array.length);

        for (int anArray : array) {
            System.out.print(anArray + " ");
        }
    }


    void heapSort(int array[], int len) {

        int index = len / 2 - 1;//从第一个非叶子节点，一直调整到根节点
        for (int i = index; i >= 0; i--) {
            maxHeapify(array, i, len - 1);
        }

        /**
         * 将第一个最大的与最后一个交换后，重新建立对
         */
        for (int i = len - 1; i > 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            maxHeapify(array, 0, i - 1);
        }
    }

    private void maxHeapify(int[] array, int start, int end) {

        int father = start;
        int child = father * 2 + 1;

        while (child < end) {
            if (child + 1 <= end && array[child + 1] > array[child]) {
                child++;
            }

            if (array[father] > array[child]) {
                return;
            } else {
                int temp = array[father];
                array[father] = array[child];
                array[child] = temp;

                father = child;
                child = (father << 1) + 1;
            }
        }
    }
}
