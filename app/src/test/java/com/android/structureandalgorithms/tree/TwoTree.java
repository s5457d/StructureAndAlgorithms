package com.android.structureandalgorithms.tree;

/**
 * @author by sunzhongda
 * @date 2018/12/4
 */
public class TwoTree {

    Node<String> root;

    public TwoTree() {
        this.root = new Node<>("A", null, null);
    }

    public void createTree() {
        Node<String> nodeB = new Node<>("B", null, null);
        Node<String> nodeC = new Node<>("C", null, null);
        Node<String> nodeD = new Node<>("D", null, null);
        Node<String> nodeE = new Node<>("E", null, null);
        Node<String> nodeF = new Node<>("F", null, null);
        Node<String> nodeG = new Node<>("G", null, null);
        Node<String> nodeH = new Node<>("H", null, null);
        Node<String> nodeJ = new Node<>("J", null, null);
        Node<String> nodeI = new Node<>("I", null, null);
        root.left = nodeB;
        root.right = nodeC;
        nodeB.left = nodeD;
        nodeC.left = nodeE;
        nodeC.right = nodeF;
        nodeD.left = nodeG;
        nodeD.right = nodeH;
        nodeE.right = nodeJ;
        nodeH.left = nodeI;
    }

    /**
     * 中序遍历
     *
     * @param root
     */
    public void midOrderTraverse(Node root) {
        if (root == null) {
            return;
        }

        midOrderTraverse(root.left);
        System.out.println("mid " + root.data);
        midOrderTraverse(root.right);
    }

    class Node<E> {

        E data;
        Node<E> left;
        Node<E> right;

        Node(E data, Node<E> left, Node<E> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        E getData() {
            return data;
        }

        void setData(E data) {
            this.data = data;
        }

        Node<E> getLeft() {
            return left;
        }

        void setLeft(Node<E> left) {
            this.left = left;
        }

        Node<E> getRight() {
            return right;
        }

        void setRight(Node<E> right) {
            this.right = right;
        }
    }
}
