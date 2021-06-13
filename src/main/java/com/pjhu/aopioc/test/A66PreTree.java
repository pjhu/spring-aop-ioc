package com.pjhu.aopioc.test;

import java.util.ArrayList;

public class A66PreTree {

    public static void main(String[] args) {

    }

    private static ArrayList<Integer> solution1(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        ArrayList<Integer> left = solution1(root.left);
        ArrayList<Integer> right = solution1(root.right);

        result.add(root.val);
        result.addAll(left);
        result.addAll(right);
        return result;
    }

    private static void solution2(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        solution2(root.left, result);
        solution2(root.right, result);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
