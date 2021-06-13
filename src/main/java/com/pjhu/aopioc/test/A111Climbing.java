package com.pjhu.aopioc.test;

// 111-爬楼梯，每次只能爬一步或两步, 爬到顶部有多少种方法
public class A111Climbing {

    public static void main(String[] args) {
        System.out.println(solution1(2));
        System.out.println(solution2(2));
    }
    
    private static int solution1(int n) {
        if (n < 3) {
            return n;
        }
        return solution1(n-1) + solution1(n-2);
    }

    private static int solution2(int n) {
        if (n < 2) {
            return n;
        }
        int onePrev = 1;
        int twoPrev = 1;
        int cur = 0;
        for (int i=2;i<=n;i++){
            cur = twoPrev + onePrev;
            twoPrev = onePrev;
            onePrev = cur;
        }
        return cur;
    }
}
