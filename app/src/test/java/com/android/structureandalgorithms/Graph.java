package com.android.structureandalgorithms;

import java.util.LinkedList;

/**
 * @author by sunzhongda
 * @date 2018/12/25
 */
public class Graph {
    public int[] vertices;//顶点集
    public int[][] matrix;//图的边的信息
    public int verticesSize;

    public boolean[] visited;

    public static final int MAX_WEIGHT = Integer.MAX_VALUE;

    public Graph(int verticesSize) {
        this.verticesSize = verticesSize;
        vertices = new int[verticesSize];
        matrix = new int[verticesSize][verticesSize];
        visited = new boolean[verticesSize];
        for (int i = 0; i < verticesSize; i++) {
            vertices[i] = i;
            visited[i] = false;
        }
    }

    /**
     * 计算V1-v2
     */
    public int getWidget(int v1, int v2) {
        int widget = matrix[v1][v2];
        return widget == 0 ? 0 : (widget == MAX_WEIGHT ? -1 : widget);
    }

    /**
     * 获取顶点集合
     */
    public int[] getVertices() {
        return vertices;
    }

    /**
     * 获取出度
     */
    public int getOutDegree(int v1) {
        int result = 0;
        for (int i = 0; i < verticesSize; i++) {
            if (matrix[v1][i] != 0 && matrix[v1][i] != MAX_WEIGHT) {
                result++;
            }
        }
        return result;
    }

    /**
     * 获取入度
     */
    public int getInDegree(int v1) {
        int result = 0;
        for (int i = 0; i < verticesSize; i++) {
            if (matrix[i][v1] != 0 && matrix[i][v1] != MAX_WEIGHT) {
                result++;
            }
        }
        return result;
    }

    /**
     * 获取第一个邻接点
     */
    public int getFirstNeightbor(int v) {
        for (int i = 0; i < verticesSize; i++) {
            if (matrix[v][i] != 0 && matrix[v][i] != MAX_WEIGHT) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 获取顶点v的index的下一个邻接点
     */
    public int getNextNeightbor(int v, int index) {
        for (int i = index + 1; i < verticesSize; i++) {
            if (matrix[v][i] != 0 && matrix[v][i] != MAX_WEIGHT) {
                return i;
            }
        }
        return -1;
    }

    public void dfs() {
        for (int i = 0; i < verticesSize; i++) {
            if (!visited[i]) {
                System.out.println("visite: " + i);
                dfs(i);
            }
        }
    }

    /**
     * 深度优先
     */
    public void dfs(int v) {
        visited[v] = true;
        int next = getFirstNeightbor(v);
        while (next != -1) {
            if (!visited[next]) {
                System.out.println("visite: " + next);
                dfs(next);
            } else {
                next = getNextNeightbor(v, next);
            }
        }
    }


    public void bfs(){
        for (int i = 0; i < verticesSize; i++) {
            if (!visited[i]){
                System.out.println(i);
                bfs(i);
            }
        }
    }

    /**
     * 广度优先
     */
    public void bfs(int v) {
        visited[v] = true;
        LinkedList<Integer> list = new LinkedList<>();
        list.offer(v);
        int next;
        while (!list.isEmpty()) {
            next = list.pop();
            next = getFirstNeightbor(next);
            while (next != -1) {
                if (!visited[next]) {
                    System.out.println(next);
                    visited[next] = true;
                    list.offer(next);
                }

                next = getNextNeightbor(v, next);
            }
        }

    }
}
