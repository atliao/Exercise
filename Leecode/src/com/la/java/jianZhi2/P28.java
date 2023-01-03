package com.la.java.jianZhi2;

import com.la.java.structure.TreeNode;

/**
 * @author LA
 * @createDate 2022-12-06-19:46
 */
public class P28 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return process(root.left, root.right);
    }

    public boolean process(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }
        if( (left == null && right != null) || (left != null && right == null) ){
            return false;
        }
        if(left.val != right.val){
            return false;
        }
        return process(left.left, right.right)&&process(left.right,right.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        System.out.println(new P28().isSymmetric(root));
    }
}
