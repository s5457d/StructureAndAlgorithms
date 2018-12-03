package com.android.structureandalgorithms.list;

import org.junit.Test;

import java.util.Stack;

/**
 * @author by sunzhongda
 * @date 2018/12/3
 */
public class ReverseList {

    @Test
    public void reverseList() {
        SingleList<Integer> SingleList = new SingleList<>();

        SingleList.addLast(5);
        SingleList.addLast(6);
        SingleList.insert(4, 0);
        SingleList.insert(3, 0);
        SingleList.display();

        reverse(SingleList);
        SingleList.display();
    }

    private void reverse(SingleList<Integer> singleList) {
        // 如果singleList的个数为0 就不用逆序了
        if (singleList.size <= 0) {
            System.out.println("链表为空");
            return;
        }

        // 定义一个stack
        Stack<Object> stacks = new Stack<>();

        // 遍历单链表的元素，放到stack中
        while (singleList.size > 0) {
            stacks.push(singleList.deleteIndex(0));
        }

        //将stack中的元素分别弹出，放到链表中
        while (stacks.size() > 0) {
            singleList.addLast((Integer) stacks.pop());
        }
    }
}
