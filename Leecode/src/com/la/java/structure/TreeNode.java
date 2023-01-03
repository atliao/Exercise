package com.la.java.structure;

import java.util.*;

/**
 * @author LA
 * @date 2022-11-22-13:20
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
    }

    //按数组顺序打印

    public static List<Integer> printASList(TreeNode root) {
        if(root == null){
            return null;
        }
        List<Integer> list = new ArrayList<>();

        //利用队列，先进先出
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        //进队列第一个元素的左右子节点，再弹出第一个元素
        //用-1填充 空的子节点
        while(!queue.isEmpty() && queue.peek().val != -1){
            TreeNode firstNode = queue.peek();
            queue.poll();
            if(firstNode.val == -1){
                list.add(null);
            }else{
                list.add(firstNode.val);
            }

            if(firstNode.left != null && firstNode.val != -1) {
                queue.add(firstNode.left);
            }else{
                queue.add(new TreeNode(-1));
            }
            if(firstNode.right != null && firstNode.val != -1)
            {
                queue.add(firstNode.right);
            }else{
                queue.add(new TreeNode(-1));
            }
        }
        return list;
    }



    //前序遍历：根左右

    //方法一：递归 推荐
    public static List<Integer> preOrderPrint1(TreeNode root){
        List<Integer> list = new ArrayList<>();
        preProcess(root, list);
        return list;
    }

    public static void preProcess(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        list.add(root.val);
        preProcess(root.left, list);
        preProcess(root.right, list);
    }

    //方法二：栈
    //后进后出，因此进栈顺序为右边先进
    public static List<Integer> preOrderPrint2(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.peek();
            stack.pop();
            if(node != null){
                list.add(node.val);
            }
            else{
                continue;
            }
            stack.push(node.right);
            stack.push(node.left);
        }
        return list;
    }

    //中序遍历：左中右，每个节点都先看左边
    //方法一：递归 推荐
    public static List<Integer> inOrderPrint(TreeNode root){
        List<Integer> list = new ArrayList<>();
        inProcess(root, list);
        return list;
    }

    public static void inProcess(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        inProcess(root.left, list);
        list.add(root.val);
        inProcess(root.right, list);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(2);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        List<Integer> list1 = preOrderPrint1(node1);
        List<Integer> list2 = preOrderPrint2(node1);
        List<Integer> list3 = inOrderPrint(node1);
        System.out.println(list1);
        System.out.println(list2);
        System.out.println(list3);
        List<Integer> list4 = printASList(node1);
        System.out.println(list4);
    }


}
