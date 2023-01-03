package com.la.java.jianZhi2;

import com.la.java.structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author LA
 * @createDate 2022-12-09-20:53
 *
 */
public class P32_G_2 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new LinkedList<>();
        }
        LinkedList<TreeNode> queue1 = new LinkedList<>();
        LinkedList<TreeNode> queue2 = new LinkedList<>();
        List<List<Integer>> lists = new ArrayList<>();
        queue1.addLast(root);
        while(!queue1.isEmpty()){
            List<Integer> list = new ArrayList<>();
            while(!queue1.isEmpty()){
                TreeNode node = queue1.removeFirst();
                list.add(node.val);
                if(node.left != null){
                    queue2.addLast(node.left);
                }
                if(node.right != null){
                    queue2.addLast(node.right);
                }
            }
            lists.add(list);
            while(!queue2.isEmpty()){
                queue1.addLast(queue2.removeFirst());
            }
        }
        return lists;
    }

    //题解：不用再设置一个queue，记住queue里面的元素个数就行
    public List<List<Integer>> levelOrder2(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> lists = new ArrayList<>();
        if(root != null){
            queue.addLast(root);
        }
        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.removeFirst();
                list.add(node.val);
                if(node.left != null){
                    queue.addLast(node.left);
                }
                if(node.right != null){
                    queue.addLast(node.right);
                }
            }
            lists.add(list);
        }
        return lists;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> lists = new P32_G_2().levelOrder2(root);
        for(List list : lists){
            System.out.print("[");
            for(Object i : list){
                System.out.print(i + " ");
            }
            System.out.println("]");
        }
    }
}
