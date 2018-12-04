package com.android.structureandalgorithms.tree;

import org.junit.Test;

/**
 * @author by sunzhongda
 * @date 2018/12/4
 */
public class TwoTreeTest {

    @Test
    public void treeTest() {
        TwoTree twoTree = new TwoTree();
        twoTree.createTree();
        twoTree.midOrderTraverse(twoTree.root);
    }
}
