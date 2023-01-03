package com.la.java.jianZhi2;

import com.la.java.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LA
 * @createDate 2023-01-03-11:24
 */
public class P34_G {
    List<List<Integer>> lists = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    int sum = 0;
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<Integer> list = new ArrayList<>();
        process(root, target);
        return lists;
    }

    public List<Integer> process(TreeNode node, int target){
        if(node == null){
            return list;
        }
        if(node.left == null && node.right == null && (sum + node.val) != target){
            return list;
        }
        if(node.left == null && node.right == null && (sum + node.val) == target){
            list.add(node.val);
            List<Integer> res = new ArrayList<>(list);
            lists.add(res);
            list.remove(list.size() - 1);
            return list;
        }
        sum = sum + node.val;
        list.add(node.val);
        list = process(node.left, target);
        list = process(node.right, target);
        list.remove(list.size() - 1);
        sum = sum - node.val;
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        List<List<Integer>> lists = new P34_G().pathSum(root, 3);
        for(List<Integer> list : lists){
            for(int i : list){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
