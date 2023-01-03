package com.la.java.jianZhi2;

import com.la.java.structure.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author LA
 * @createDate 2022-12-08-20:53
 * 二叉树的层序遍历
 */
public class P32_G_1 {


    //使用辅助队列
    public int[] levelOrder(TreeNode root) {
        if(root == null){
            return new int[0];
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        queue.addLast(root);
        while(!queue.isEmpty()){
            list.add(queue.getFirst().val);
            TreeNode node = queue.removeFirst();
            if(node.left != null){
                queue.addLast(node.left);
            }
            if(node.right != null){
                queue.addLast(node.right);
            }
        }
        int[] res = new int[list.size()];
        for(int i = 0; i < res.length; i++){
            res[i] = list.get(i);
        }
        return res;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        int[] res = new P32_G_1().levelOrder(root);
        System.out.println(Arrays.toString(res));
    }
}
