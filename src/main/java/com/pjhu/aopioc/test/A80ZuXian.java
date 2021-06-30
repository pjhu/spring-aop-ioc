package com.pjhu.aopioc.test;

// 88-最近公共祖先
// https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/236-er-cha-shu-de-zui-jin-gong-gong-zu-xian-hou-xu/
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

    //若 root 是 p,q 的 最近公共祖先 ，则只可能为以下情况之一：
    //p 和 q 在 root 的子树中，且分列 root 的 异侧（即分别在左、右子树中）；
    //p = root，且 q 在 root 的左或右子树中；
    //q=root ，且 p 在 root 的左或右子树中
    private static TreeNode lca(TreeNode root, TreeNode first, TreeNode second) {

        if (root == null) {
            return null;
        }
        if (root.val == first.val || root.val == second.val ) {
            return root;
        }

        TreeNode left = lca(root.left, first, second);
        TreeNode right = lca(root.right, first, second);

        // 说明 p,q 分列在 root 的 异侧 （分别在 左 / 右子树），
        // 因此 root为最近公共祖先，返回 root
        if (left != null && right != null) return root;

        // p,q 都不在 root 的右子树中，直接返回 left
        if (left != null) return left;
        //  p,q 都不在 root 的左子树中，直接返回 right
        if (right != null) return right;

        // 当 left 和 right 同时为空 ：说明 root 的左 / 右子树中都不包含 p,q ，返回 null；
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
