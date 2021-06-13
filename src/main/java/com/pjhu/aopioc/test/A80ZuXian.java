package com.pjhu.aopioc.test;

import cn.hutool.core.lang.tree.Tree;

// 88-最近公共祖先
public class A80ZuXian {

    public static void main(String[] args) {
        // {4,3,7,#,#,5,6},3,5
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        TreeNode result = lca(root, new TreeNode(3), new TreeNode(0));
        assert result != null;
        System.out.println(result.val);
    }

    private static TreeNode lca(TreeNode root, TreeNode a, TreeNode b) {
        if (root == null || a == null || b == null) {
            return null;
        }
        if (root.val == a.val || root.val == b.val ) {
            return root;
        }
        TreeNode left = lca(root.left, a, b);
        TreeNode right = lca(root.right, a, b);

        if (left != null && right != null) return root;
        if (left != null) return left;
        if (right != null) return right;
        return null;
    }

    static class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
}
