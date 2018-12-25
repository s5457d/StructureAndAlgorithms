package com.android.structureandalgorithms;

import org.junit.Test;

import static com.android.structureandalgorithms.Graph.MAX_WEIGHT;

/**
 * @author by sunzhongda
 * @date 2018/12/25
 */
public class GraphTest {

    @Test
    public void test() {
        Graph graph = new Graph(5);
//        int[] a0 = new int[]{0, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 6};
//        int[] a1 = new int[]{9, 0, 3, MAX_WEIGHT, MAX_WEIGHT};
//        int[] a2 = new int[]{2, MAX_WEIGHT, 0, 5, MAX_WEIGHT};
//        int[] a3 = new int[]{MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 0, 1};
//        int[] a4 = new int[]{MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 0};
//        graph.matrix[0] = a0;
//        graph.matrix[1] = a1;
//        graph.matrix[2] = a2;
//        graph.matrix[3] = a3;
//        graph.matrix[4] = a4;
//        System.out.println(graph.getInDegree(2));
        int[] v0 = new int[]{         0,         1,          1, MAX_WEIGHT, MAX_WEIGHT};
        int[] v1 = new int[]{MAX_WEIGHT,         0, MAX_WEIGHT,          1, MAX_WEIGHT};
        int[] v2 = new int[]{MAX_WEIGHT, MAX_WEIGHT,         0, MAX_WEIGHT, MAX_WEIGHT};
        int[] v3 = new int[]{         1, MAX_WEIGHT,MAX_WEIGHT,          0, MAX_WEIGHT};
        int[] v4 = new int[]{MAX_WEIGHT, MAX_WEIGHT,         1, MAX_WEIGHT,          0};
        graph.matrix[0] = v0;
        graph.matrix[1] = v1;
        graph.matrix[2] = v2;
        graph.matrix[3] = v3;
        graph.matrix[4] = v4;
//        graph.dfs();
//
//        for (int i = 0; i < graph.verticesSize; i++) {
//            for (int j = 0; j < graph.verticesSize; j++) {
//                System.out.print(graph.matrix[i][j] + "        ");
//            }
//            System.out.println();
//        }

        graph.bfs();
    }
}
