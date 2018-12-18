package com.android.structureandalgorithms.tree.avl;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @author by sunzhongda
 * @date 2018/12/18
 */
public class AVLBTree<E extends Comparable<E>> {

    Node<E> root;
    int size;


    public boolean insertElement(E element) {
        Node<E> t = root;
        if (t == null) {
            root = new Node<>(element, null);
            size = 1;
            root.balance = EH;
            return true;
        }

        // 找到位置
        int cmp = 0;
        Node<E> parent;
        Comparable<? super E> e = element;
        do {
            parent = t;
            cmp = e.compareTo(t.element);
            if (cmp > 0) {
                t = t.right;
            } else if (cmp < 0) {
                t = t.left;
            } else {
                return false;
            }
        } while (t != null);

        //插入数据
        Node<E> child = new Node<>(element, parent);
        if (element.compareTo(parent.element) > 0) {
            parent.right = child;
        } else {
            parent.left = child;
        }

        //检查是否是平衡AVL，使用回溯的方式
        while (parent != null) {
            cmp = element.compareTo(parent.element);
            if (cmp > 0) {
                parent.balance--;
            } else {
                parent.balance++;
            }
            if (parent.balance == 0) {
                break;
            }
            if (parent.balance == 2 || parent.balance == -2) {
                //出现平衡问题，需要修正
                fixAfterInsert(parent);
                break;

            } else {
                parent = parent.parent;
            }
        }
        size++;
        return true;
    }

    private void fixAfterInsert(Node<E> parent) {
        if (parent.balance == 2) {
            leftBalance(parent);
        }
        if (parent.balance == -2) {
            right_retate(parent);
        }
    }

    public static final int LH = 1;
    public static final int RH = -1;
    public static final int EH = 0;

    public void rightBalance(Node<E> t) {
        Node<E> tr = t.right;

        switch (tr.balance) {
            case RH:
                t.balance = EH;
                tr.balance = EH;
                left_retate(t);
                break;
            case LH:
                Node<E> trl = tr.left;
                switch (trl.balance) {
                    case RH:
                        t.balance = LH;
                        tr.balance = RH;
                        trl.balance = EH;
                        break;
                    case LH:
                        t.balance = EH;
                        tr.balance = RH;
                        trl.balance = EH;
                        break;
                    case EH:
                        t.balance = EH;
                        tr.balance = EH;
                        trl.balance = EH;
                        break;
                }
                right_retate(t.right);
                left_retate(t);
                break;
        }
    }

    /**
     * 左边修正
     *
     * @param t
     */
    public void leftBalance(Node<E> t) {
        Node<E> tl = t.left;
        switch (tl.balance) {
            case LH:
                right_retate(t);
                tl.balance = EH;
                t.balance = EH;
                break;
            case RH:
                Node<E> tlr = tl.right;
                switch (tlr.balance) {
                    case LH:
                        t.balance = RH;
                        tl.balance = EH;
                        tlr.balance = EH;
                        break;
                    case RH:
                        t.balance = EH;
                        tl.balance = LH;
                        tlr.balance = EH;
                        break;
                    case EH:
                        t.balance = EH;
                        tl.balance = EH;
                        tlr.balance = EH;
                        break;
                    default:
                        break;
                }
                left_retate(t.left);
                right_retate(t);
                break;
        }
    }

    /**
     * 在Node x处左旋转
     *
     * @param x
     */
    public void left_retate(Node<E> x) {
        if (x == null) {
            return;
        }

        Node<E> y = x.right;
        if (y != null) {
            Node<E> b;
            b = y.left;
            x.right = b;
            if (b != null)
                b.parent = x;

            y.parent = x.parent;
            Node<E> p = x.parent;
            if (p == null) {
                root = y;
            } else {
                if (p.left == x) {
                    p.left = y;
                } else if (p.right == x) {
                    p.right = y;
                }
            }
            y.left = x;
            x.parent = y;
        }
    }

    /**
     * 在Node x处右旋转
     *
     * @param x
     */
    public void right_retate(Node<E> x) {
        if (x == null) return;

        Node<E> y = x.left;
        if (y != null) {
            Node<E> b;
            b = y.right;
            x.left = b;
            if (b != null)
                b.parent = x;

            y.parent = x.parent;
            if (x.parent == null) {
                root = y;
            } else {
                if (x.parent.left == x) {
                    x.parent.left = y;
                } else if (x.parent.right == x) {
                    x.parent.right = y;
                }
            }

            y.right = x;
            x.parent = y;
        }
    }


    @Test
    public void test() {
        Integer[] nums = {5, 8, 2, 0, 1, -2};
        AVLBTree<Integer> tree = new AVLBTree<>();
        for (int i = 0; i < nums.length; i++) {
            tree.insertElement(nums[i]);
        }

        showAVL((Node<E>) tree.root);
    }

    private void showAVL(Node<E> root) {
        LinkedList<Node> list = new LinkedList<>();
        list.offer(root);
        while (!list.isEmpty()) {
            Node<E> node = list.pop();
            System.out.println(node.element);
            if (node.left != null) {
                list.offer(node.left);
            }
            if (node.right != null) {
                list.offer(node.right);
            }
        }
    }

    public static class Node<E extends Comparable<E>> {
        E element;
        int balance;
        Node<E> left;
        Node<E> right;
        Node<E> parent;

        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
            left = null;
            right = null;
        }
    }
}
