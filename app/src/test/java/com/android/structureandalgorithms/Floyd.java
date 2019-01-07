package com.android.structureandalgorithms;

import org.junit.Test;

/**
 * @author by sunzhongda
 * @date 2018/12/28
 */
public class Floyd {

    public static final int I = 100;
    //邻接矩阵
    public static int[][] d = new int[][]{
            {0, 2, 1, 5},
            {2, 0, 4, I},
            {1, 4, 0, 3},
            {5, I, 3, 0}
    };

    public static int[][] p = new int[][]{
            {0, 1, 2, 3},
            {0, 1, 2, 3},
            {0, 1, 2, 3},
            {0, 1, 2, 3}
    };

    public static void floyd() {

        //时间复杂度 n*n*n
        for (int k = 0; k < d.length; k++) {
            for (int i = 0; i < d.length; i++) {
                for (int j = 0; j < d.length; j++) {
                    if (d[i][j] > d[i][k] + d[k][j]) {
                        d[i][j] = d[i][k] + d[k][j];
                        p[i][j] = p[i][k];
                    }
                }
            }
        }
    }

    public static void printShortPath() {
        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < d.length; j++) {
                System.out.println("V" + i + "->V" + j + " weight:" + d[i][j]);
                int k = p[i][j];
                int temp = j;
                while (k != temp) {
                    temp = k;
                    System.out.println("->" + k);
                    k = p[i][k];
                }
                System.out.println();
            }
        }
    }

    @Test
    public void test() {
        floyd();
        printArray(d);
        System.out.println("          ddddddd");
        printArray(p);
        printShortPath();
    }

    private void printArray(int[][] d) {
        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < d[i].length; j++) {
                System.out.print(d[i][j] + " ");
            }
            System.out.println();
        }
    }
}
