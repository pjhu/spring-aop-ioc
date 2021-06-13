package com.pjhu.aopioc.test;

// 265-最大非负子序和
public class A265MaxNonNegativeSubArray {

    public static void main(String[] args) {
        int[] a = new int[] {1, 2, -3, 4, 5, -6};
        // 1 + 2 < 4 + 5
        System.out.println(solution(a));
    }

    private static Integer solution(int [] a) {
        int sum = 0;
        int maxSum = 0;
        boolean allNeg = true;
        for (int value : a) {
            if (value > 0) {
                sum += value;
                allNeg = false;
            } else {
                if (maxSum < sum) {
                    maxSum = sum;
                }
                sum = 0;
            }
        }
        if(allNeg) {
            return -1;
        }
        return Math.max(maxSum, sum);
    }
}
