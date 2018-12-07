package com.android.structureandalgorithms;

import org.junit.Test;

/**
 * @author by sunzhongda
 * @date 2018/12/7
 */
public class MergeSort {

    @Test
    public void test() {
//        int[] array = new int[]{1, 3, 5, 7, 9, 2, 4, 6, 8, 10};
//        mergeSort(array, 0, (array.length - 1) >> 1, array.length - 1);
//        for (int anArray : array) {
//            System.out.print(anArray + " ");
//        }

        int[] array = new int[]{8, 1, 3, 2, 0, 7, 6, 9, 4, 5};
        mergeSort(array, 0, array.length - 1);
        for (int anArray : array) {
            System.out.print(anArray + " ");
        }
    }

    /**
     * @param array
     * @param left
     * @param right
     */
    private void mergeSort(int[] array, int left, int right) {
        if (left == right) return;
        int mid = (left + right) >> 1;
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        mergeSort(array, left, mid, right);
    }

    private void mergeSort(int[] array, int left, int mid, int right) {
        System.out.print("原数组：");
        for (int anArray : array) {
            System.out.print(anArray + " ");
        }
        System.out.println();
        System.out.println("left:" + left + " mid:" + mid + " right:" + right);
        //先分别计算出，需要归并的两个数组的大小
        int leftSize = mid - left + 1;
        int rightSize = right - mid;

        int[] leftArray = new int[leftSize];
        int[] rightArray = new int[rightSize];

        //将左右两个部分的数组分别初始化
        System.arraycopy(array, left, leftArray, 0, leftArray.length);

        for (int i = 0; i < rightArray.length; i++) {
            rightArray[i] = array[i + mid + 1];
        }

        System.out.println("left:");
        for (int anArray : leftArray) {
            System.out.print(anArray + " ");
        }
        System.out.println();

        System.out.println("right:");
        for (int anArray : rightArray) {
            System.out.print(anArray + " ");
        }
        System.out.println();

        int i = 0;
        int j = 0;
        int k = left;
        // 消耗掉了一个数组
        while (i < leftSize && j < rightSize) {
            if (leftArray[i] <= rightArray[j]) {
                array[k++] = leftArray[i++];
            } else if (leftArray[i] > rightArray[j]) {
                array[k++] = rightArray[j++];
            }
        }

        // leftArray 还有剩余
        while (i < leftSize) {
            array[k++] = leftArray[i++];
        }

        // rightArray 还有剩余
        while (j < rightSize) {
            array[k++] = rightArray[j++];
        }

        System.out.print("排序后：");
        for (int anArray : array) {
            System.out.print(anArray + " ");
        }
        System.out.println();
        System.out.println("-------------");
    }
}
