package com.pjhu.springsourcecode.test;

// 给定一棵BST，再给定其中一个节点p，求其中序遍历的前驱节点
// https://blog.csdn.net/qq_46105170/article/details/105885857
// 前驱结点：结点val值小于该结点val值并且值最大的结点
// 后继结点：结点val值大于该结点val值并且值最小的结点
// 中序遍历【左根右】的前驱节点的意思是，比p小的所有节点里取最大的，也就是以p为根的子树的左子树的最右边的节点。
// 如果p左子树为空，并且p是其父亲的右儿子，那就是p的父亲；
// 如果p左子树为空，并且p是其父亲的左儿子，那整棵树中就不存在p的前驱，返回null。
// 所以可以先设一个前驱指针，这个指针的用处是，在找到p的左子树后，
// 跟在另一个指针后面，然后让另一个指针向右探路直到走到null
public class M915BST {
    public static void main(String[] args) {

    }

    public static TreeNode solution(TreeNode root, TreeNode p) {

        TreeNode rst = null;
        while (root != null) {
            if (root.value >= p.value)  {
                root = root.left;
            } else {
                if (rst == null || root.value > rst.value) {
                    rst = root;
                }
                root = root.right;
            }
        }
        return rst;
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
