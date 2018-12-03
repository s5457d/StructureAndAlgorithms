package com.android.structureandalgorithms.list;

/**
 * @author by sunzhongda
 * @date 2018/12/1
 */
public class SingleList<E> {

    public int size = 0;
    // 链表头结点
    Node head = null;
    // 链表尾节点
    Node tail = null;

    class Node<E> {
        E data;
        Node<E> next;

        Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    /**
     * 遍历所有节点
     */
    public void display() {
        if (size == 0) {
            // 空链表 无需打印直接返回
            System.out.println("空链表");
            return;
        }

        Node current = head;
        while (current != tail) {
            // 没有遍历到尾节点 就打印出来当前节点打印出来
            System.out.println(current.data);
            // 当前节点向后移动
            current = current.next;
        }

        // 打印最后的尾节点
        System.out.println(tail.data);
    }

    /**
     * 在单链表的末尾添加一个元素
     */
    public void addLast(E e) {
        // 根据元素e 创建一个Node,因为是在最后插入，所以next 为null
        Node<E> eNode = new Node<>(e, null);

        if (size == 0) {
            // 当前是一个空链表
            head = eNode;
            tail = eNode;
        } else {
            //当前的链表非空 tail的后继节点是新节点，tail向后移动一个。
            tail.next = eNode;
            tail = eNode;
        }
        size++;
    }

    /**
     * 在index的位置插入元素
     */
    public void insert(E e, int index) {
        //检查index合法性
        if (index < 0 || index > size) {
            System.out.println("插入的位置不合法,size : " + size + " index : " + index);
        }

        if (size == 0) {
            //表名当前是第一个插入的元素
            addLast(e);
            return;
        }

        // 构造被插入节点
        Node insertNode = new Node(e, null);

        // 寻找插入点前驱
        Node prevNode = searchIndex(index);
        if (prevNode == null) {
            // index 为0 在头结点位置插入
            insertNode.next = head;
            head = insertNode;
        } else {
            insertNode.next = prevNode.next;
            prevNode.next = insertNode;
        }

        size++;
    }

    /**
     * 删除index位置元素
     *
     * @param index
     */
    public Object deleteIndex(int index) {

        if (size <= 0){
            System.out.println("空链表");
            return null;
        }

        //检查index合法性
        if (index < 0 || index >= size) {
            System.out.println("插入的位置不合法,size : " + size + " index : " + index);
            return null;
        }

        // 寻找删除点前驱
        Node prevNode = searchIndex(index);
        Node cur;
        Node res;
        if (prevNode == null) {
            // index 为0 在头结点位置删除
            res = head;
            cur = head.next;
            head.next = null;
            head = cur;
            if (size == 1) {
                //如果只有一个头结点删除之后，tail null
                tail = null;
            }
        } else {
            res = prevNode.next;
            cur = prevNode.next;
            prevNode.next = cur.next;
            cur.next = null;
            if (size - 1 == index) {
                //如果删除的是最后一个，tail前移
                tail = prevNode;
            }
        }
        size--;
        return res.data;
    }

    /**
     * 需要找到带插入点的前驱节点
     *
     * @param index
     * @return
     */
    private Node searchIndex(int index) {
        Node current = head;
        Node prev = null;
        for (int i = 0; i < index; i++) {
            //记录pre， 并且将current向后移动
            prev = current;
            current = current.next;
        }
        return prev;
    }
}
