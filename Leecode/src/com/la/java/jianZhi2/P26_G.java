package com.la.java.jianZhi2;


import com.la.java.structure.TreeNode;

/**
 * @author LA
 * @createDate 2022-12-05-15:35
 */
public class P26_G {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(B == null){
            return false;
        }
        if(A == null){
            return false;
        }
        if(A.val == B.val && compareTree(A, B) == true){
            return true;
        }else{
            return isSubStructure(A.left, B) || isSubStructure(A.right, B);
        }
    }

    //同一个节点起的B是否为A的子树
    public boolean compareTree(TreeNode A, TreeNode B){
        if(A == null && B == null){
            return true;
        }
        if(A == null && B != null){
            return false;
        }
        if(A != null && B == null){
            return true;
        }
        if(A.val != B.val){
            return false;
        }
        return compareTree(A.left, B.left) && compareTree(A.right, B.right);

    }

    public static void main(String[] args) {
        TreeNode A = new TreeNode(3);
        A.left = new TreeNode(4);
        A.right = new TreeNode(5);
        A.left.left = new TreeNode(1);
        A.left.right = new TreeNode(2);

        TreeNode B = new TreeNode(4);
        B.left = new TreeNode(1);

        System.out.println(new P26_G().isSubStructure(A, B));
    }
}
