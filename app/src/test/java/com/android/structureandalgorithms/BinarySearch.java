package com.android.structureandalgorithms;

import org.junit.Test;


/**
 * @author by sunzhongda
 * @date 2018/12/6
 */
public class BinarySearch {

    @Test
    public void text() {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 11, 15, 18};

        int index = MyBinarySearch(array, 0, array.length, 8);
        System.out.println(index);
    }

    /**
     * 将下表的索引设计成左闭右开的模式,默认array的升序
     *
     * @param array
     * @param from
     * @param end
     * @param value
     * @return 数组的下标索引
     */
    private int MyBinarySearch(int[] array, int from, int end, int value) {
        int low = from;
        int high = end - 1;

        while (low <= high) {
            int mid = (low + high) >> 1;
            if (array[mid] < value) {
                //向右侧寻找
                low = mid + 1;
            } else if (array[mid] > value) {
                //向左寻找
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -(low + 1);
    }


}
