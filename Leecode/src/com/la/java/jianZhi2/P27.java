package com.la.java.jianZhi2;

import com.la.java.structure.TreeNode;

/**
 * @author LA
 * @createDate 2022-12-05-16:57
 */
public class P27 {


    public TreeNode mirrorTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode curNode = new TreeNode(root.val);
        curNode.right = mirrorTree(root.left);
        curNode.left = mirrorTree(root.right);
        return curNode;
    }

    //题解：不用额外开辟一棵树，在原树上操作，但也要开辟tmp节点，使用空间是上面所有节点都开辟的一半
    public TreeNode mirrorTree2(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode tmp = root.right; //先保存
        root.right = mirrorTree(root.left); //否则这一步就会改变root.right的值
        root.left = mirrorTree(tmp);
        return root;
    }

    public static void main(String[] args) {
        TreeNode A = new TreeNode(4);
        A.left = new TreeNode(2);
        A.right = new TreeNode(7);
        A.left.left = new TreeNode(1);
        A.left.right = new TreeNode(3);
        A.right.left = new TreeNode(6);
        A.right.right = new TreeNode(9);

        TreeNode B = new P27().mirrorTree2(A);
        System.out.println(B.val);
        System.out.println(B.left.val);
        System.out.println(B.right.val);
        System.out.println(B.left.left.val);
        System.out.println(B.left.right.val);
        System.out.println(B.right.left.val);
        System.out.println(B.right.right.val);

    }
}
