package com.la.java.jianZhi2;

import com.la.java.structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author LA
 * @createDate 2022-12-10-20:23
 */
public class P32_G_3 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> lists = new ArrayList<>();
        boolean b = true;
        if(root != null){
            queue.addLast(root);
        }
        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node ;
                if(b){
                    node = queue.removeFirst();
                    if(node.left != null){
                        queue.addLast(node.left);
                    }
                    if(node.right != null){
                        queue.addLast(node.right);
                    }
                }else{
                    node = queue.removeLast();
                    if(node.right != null){
                        queue.addFirst(node.right);
                    }
                    if(node.left != null){
                        queue.addFirst(node.left);
                    }
                }
                list.add(node.val);
            }
            b = !b;
            lists.add(list);
        }
        return lists;
    }

    //题解：使用双向链表即可，不用双向队列
    public List<List<Integer>> levelOrder2(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> lists = new ArrayList<>();
        boolean b = true;
        if(root != null){
            queue.addLast(root);
        }
        while(!queue.isEmpty()){
            LinkedList<Integer> list = new LinkedList<>();
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.removeFirst();
                if(node.left != null){
                    queue.addLast(node.left);
                }
                if(node.right != null){
                    queue.addLast(node.right);
                }
                if(b){
                    list.addLast(node.val);
                }else{
                    list.addFirst(node.val);
                }
            }
            b = !b;
            lists.add(list);
        }
        return lists;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        List<List<Integer>> lists = new P32_G_3().levelOrder2(root);
        for(List list : lists){
            System.out.print("[");
            for(Object i : list){
                System.out.print(i + " ");
            }
            System.out.println("]");
        }
    }
}
