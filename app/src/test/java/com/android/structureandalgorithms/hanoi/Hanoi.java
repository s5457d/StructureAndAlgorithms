package com.android.structureandalgorithms.hanoi;

import org.junit.Test;

/**
 * @author by sunzhongda
 * @date 2018/12/1
 */
public class Hanoi {


    @Test
    public void test() {
        Hanoi(3, 1, 2, 3);
    }

    /**
     * 汉诺塔实现过程
     *
     * @param count
     * @param start
     * @param middle
     * @param end
     */
    private void Hanoi(int count, int start, int middle, int end) {

        if (count == 1) {
            System.out.println(start + " -> " + end);
        } else {
            Hanoi(count - 1, start, end, middle);
            System.out.println(start + " -> " + end);
            Hanoi(count - 1, middle, start, end);
        }
    }
}
