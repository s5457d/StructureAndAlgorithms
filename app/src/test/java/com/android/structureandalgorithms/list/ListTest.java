package com.android.structureandalgorithms.list;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @author by sunzhongda
 * @date 2018/11/30
 */
public class ListTest {
    @Test
    public void addition_isCorrect() throws Exception {
        LinkedList<Mahjong> list = new LinkedList<Mahjong>();
        list.add(new Mahjong(3, 1));
        list.add(new Mahjong(2, 3));
        list.add(new Mahjong(3, 7));
        list.add(new Mahjong(1, 1));
        list.add(new Mahjong(3, 8));
        list.add(new Mahjong(2, 2));
        list.add(new Mahjong(3, 2));
        list.add(new Mahjong(1, 3));
        list.add(new Mahjong(3, 9));
        System.out.println(list);
        radixSort(list);
        System.out.println(list);
    }

    private void radixSort(LinkedList<Mahjong> list) {
        // 定义9个点数，定义9个数组，每个数组都是一个linkedList
        LinkedList[] rankList = new LinkedList[9];
        for (int i = 0; i < rankList.length; i++) {
            rankList[i] = new LinkedList();
        }

        // 将原列表的数据，按照点数进行分类
        while (list.size()>0){
            Mahjong mahjong = list.remove();
            rankList[mahjong.rank - 1].add(mahjong);
        }

        // 将分类之后的linkedList合并成一个list
        for (LinkedList linkedList : rankList) {
            list.addAll(linkedList);
        }
        System.out.println(list);

        // 定义3个点数，定义3个数组，每个数组都是一个linkedList
        LinkedList[] suitList = new LinkedList[3];
        for (int i = 0; i < suitList.length; i++) {
            suitList[i] = new LinkedList();
        }

        // 将按照点数排列的数据，再按花色进行分类
        while (list.size()>0){
            Mahjong mahjong = list.remove();
            suitList[mahjong.suit - 1].add(mahjong);
        }

        // 合并
        for (LinkedList linkedList : suitList) {
            list.addAll(linkedList);
        }
    }

    @Test
    public void singleListText(){
        SingleList<Integer> SingleList = new SingleList<>();

        SingleList.addLast(5);
        SingleList.addLast(6);
        SingleList.insert(4,0);
        SingleList.insert(7,1);
        SingleList.deleteIndex(0);
        SingleList.display();
    }
}
