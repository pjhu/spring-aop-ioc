package com.pjhu.springsourcecode.test;

//https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/solution/er-cha-shu-zhong-de-zui-da-lu-jing-he-by-leetcode-/
// 寻找路径和 是路径中各节点值的总和。
// 给你一个二叉树的根节点 root ，返回其 最大路径和
public class M94TreeMaxPath {

    private static int maxSum = Integer.MIN_VALUE;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left  = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        solution(root);

        System.out.println(maxSum);
    }

    // 该函数计算二叉树中的一个节点的最大贡献值
    // 具体而言，就是在以该节点为根节点的子树中寻找以该节点为起点的一条路径，使得该路径上的节点值之和最大
    // 空节点的最大贡献值等于 0
    // 非空节点的最大贡献值等于节点值与其子节点中的最大贡献值之和
    // 对于叶节点而言，最大贡献值等于节点值
    public static int solution(TreeNode root) {

        if (root == null) {
            return 0;
        }

        // 递归计算左右子节点的最大贡献值
        // 只有在最大贡献值大于 0 时，才会选取对应子节点
        int left = Math.max(solution(root.left), 0);
        int right = Math.max(solution(root.right), 0);

        // 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
        int priceNewPath = root.value + left + right;

        // 递归后，先计算叶子节点，把叶子节点放入最大值
        maxSum = Math.max(maxSum, priceNewPath);

        // 返回该节点的最大贡献值
        return root.value + Math.max(left, right);
    }


    public static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
}
