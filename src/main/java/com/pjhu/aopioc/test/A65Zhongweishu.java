package com.pjhu.aopioc.test;

public class A65Zhongweishu {

    public static void main(String[] args) {

        int[] a = {1,2,3,4,5,6,7};
        int[] b = {1,2,3};

        int n = a.length + b.length;

        if (n % 2 == 0) {
            int first = solution(a, 0, b, 0, (n+1)/2);
            int second = solution(a, 0, b, 0, (n+2)/2);
            System.out.println((first+second) / 2.0);

        } else {
            int r = solution(a, 0, b, 0, n / 2);
            System.out.println(r);
        }
    }

    private static int solution(int[] a, int startA, int[] b, int startB, int k) {

        if (startA >= a.length) {
            return b[startB + k -1];
        }

        if (startB >= b.length) {
            return a[startA + k - 1];
        }

        if (k == 1) {
            return Math.min(a[startA], b[startB]);
        }

        int khalf = k / 2;
        if (startA + khalf -1 < a.length && startB + khalf -1 < b.length) {
            if (a[startA + khalf -1] < b[startB + khalf -1]) {
                return solution(a, startA+khalf, b, startB, k - khalf);
            } else {
                return solution(a, startA, b, startB + khalf, k - khalf);
            }
        } else if (startA + khalf -1 < a.length) {
            return solution(a, startB+khalf, b, startB, k-khalf);
        } else {
            return solution(a, startA, b ,startB+khalf, k-khalf);
        }
    }
}
