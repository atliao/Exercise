package com.la.java.jianZhi2;

import com.la.java.structure.TreeNode;

import java.util.HashMap;
import java.util.List;

/**
 * @author LA
 * @date 2022-11-22-13:59
 */
public class P7_G {


    //自己根据解题思路写的
    //最坏的情况O(n^2): 只有左子节点或右子节点，要执行n次递归函数确定n个节点，每次递归函数的时间开销为O(n)级别
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0){
            return null;
        }
        int rootValue = preorder[0];
        int n = 0;
        while(inorder[n] != rootValue){
            n++;
        }
        //左子树的先序遍历
        int[] leftPreOrder = new int[n];
        for(int i = 0; i < n; i++){
            leftPreOrder[i] = preorder[i + 1];
        }
        //右子树的先序遍历
        int[] rightPreOrder = new int[preorder.length - n - 1];
        for(int i = 0; i < preorder.length - n - 1; i++){
            rightPreOrder[i] = preorder[n + 1 + i];
        }
        //左子树的中序遍历
        int[] leftInOrder = new int[n];
        for(int i = 0; i < n; i++){
            leftInOrder[i] = inorder[i];
        }
        //右子树的中序遍历
        int[] rightInOrder = new int[preorder.length - n - 1];
        for(int i = 0; i < preorder.length - n - 1; i++){
            rightInOrder[i] = inorder[n + 1 + i];
        }
        //目前的根节点
        TreeNode root = new TreeNode(rootValue);
        //左根节点
        root.left = buildTree(leftPreOrder, leftInOrder);
        //右根节点
        root.right = buildTree(rightPreOrder, rightInOrder);

        return root;
    }

    //题解方法：用下标代替数组，用哈希表存储索引，查找时间为O(1)，且传入下标即可，不用每次生成一个新的数组
    //递归找n个节点，总时间复杂度为O(N)
    //并且先序遍历本来每个节点的优先级都是根，可直接确定根节点
    //      可以看做先序数组某个位置开始从左到右一直都是它的左子树部分，直到一个数为右子根
    int[] preorder;
    HashMap<Integer, Integer> dic = new HashMap<>();
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for(int i = 0; i < inorder.length; i++)
            dic.put(inorder[i], i);//将中序遍历所有值存入哈希中，可以快速查找索引
        return recur(0, 0, inorder.length - 1);//传入根节点索引，最左边的节点索引，最右边的节点索引
        //root为preorder中的根节点索引，后面两个参数，是树的最左边和最右边的节点索引，是inorder中的索引
    }
    TreeNode recur(int root, int left, int right) {
        if(left > right){
            return null;                          // 递归终止
        }
        TreeNode node = new TreeNode(preorder[root]);          // 根据先序遍历，可找到目前根节点的值
        int i = dic.get(preorder[root]);                       // 根据哈希表找到目前根节点在inorder中的索引，找到左子树的数量

        //传入左子树信息
        //左子树的根的索引为先序中的根节点+1
        //递归左子树的左边界为原来的中序left
        //递归左子树的右边界为中序中的根节点索引-1
        node.left = recur(root + 1, left, i - 1);              // 左子节点

        //传入右子树信息
        //右子树的根的索引为先序中的 当前根位置 + 左子树的数量 + 1
        //递归右子树的左边界为中序中当前根节点+1
        //递归右子树的右边界为中序中原来右子树的边界
        node.right = recur(root + i - left + 1, i + 1, right); // 右子节点

        return node;                                           // 返回根节点
    }



    public static void main(String[] args) {
        int[] preorder = {5,4,1,2,6,3};
        int[] inorder = {1,4,2,5,6,3};
        TreeNode root = new P7_G().buildTree(preorder, inorder);
        List<Integer> preList = TreeNode.preOrderPrint1(root);
        List<Integer> inList = TreeNode.inOrderPrint(root);
        System.out.println(preList);
        System.out.println(inList);
        root = new P7_G().buildTree2(preorder, inorder);
        preList = TreeNode.preOrderPrint1(root);
        inList = TreeNode.inOrderPrint(root);
        System.out.println(preList);
        System.out.println(inList);
    }
}
