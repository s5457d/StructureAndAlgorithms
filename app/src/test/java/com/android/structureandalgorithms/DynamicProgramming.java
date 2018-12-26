package com.android.structureandalgorithms;

import org.junit.Test;

import java.util.Stack;

/**
 * @author by sunzhongda
 * @date 2018/12/26
 */
public class DynamicProgramming {

    public static int max(int a, int b) {
        return a > b ? a : b;
    }

    public static void getLCS(String x, String y) {
        char[] s1 = x.toCharArray();
        char[] s2 = y.toCharArray();
        int[][] array = new int[x.length() + 1][y.length() + 1];

        //把第一行和第一列都填上0
        for (int i = 0; i < array[0].length; i++) {
            array[0][i] = 0;
        }
        for (int i = 0; i < array.length; i++) {
            array[i][0] = 0;
        }

        //使用动态规划的方式填上数据
        for (int i = 1; i < array.length; i++) {
            for (int j = 1; j < array[i].length; j++) {
                if (s1[i - 1] == s2[j - 1]) {
                    array[i][j] = array[i - 1][j - 1] + 1;//如果相等，左上角+1
                } else {
                    array[i][j] = max(array[i - 1][j], array[i][j - 1]);
                }
            }
        }

        //打印
        for (int[] anArray : array) {
            for (int anAnArray : anArray) {
                System.out.print(anAnArray + "  ");
            }
            System.out.println();
        }

        //便利结果
        Stack result = new Stack();
        int i = x.length() - 1;
        int j = y.length() - 1;
        while (i >= 0 && j >= 0) {
            if (s1[i] == s2[j]) {
                result.push(s1[i]);
                i--;
                j--;
            } else {
//                if (array[i + 1][j + 1 - 1] > array[i + 1 - 1][j]) {
//                    j--;
//                } else {
//                    i--;
//                }
                if (array[i + 1 - 1][j] > array[i + 1][j + 1 - 1]) {
                    i--;
                } else {
                    j--;
                }
            }
        }

        while (!result.isEmpty()) {
            System.out.print(result.pop() + "  ");
        }
    }

    @Test
    public void test() {
        getLCS("abcbdab", "bdcaba");
    }
}
