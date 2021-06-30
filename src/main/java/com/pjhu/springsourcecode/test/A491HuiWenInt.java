package com.pjhu.springsourcecode.test;

// 491-是否是回文数
public class A491HuiWenInt {

    public static void main(String[] args) {
        System.out.println(solution1(12232));
        System.out.println(solution1(12321));
        System.out.println(solution1(1221));

        System.out.println(solution2(12232));
        System.out.println(solution2(12321));
        System.out.println(solution2(1221));
    }

    // solution1
    private static boolean solution1(int a) {
        String s = String.valueOf(a);
        int l=0, r=s.length()-1;
        while (l<=r) {
            if(s.charAt(l) != s.charAt(r)) return false;
            ++l;
            --r;
        }
        return true;
    }

    // solution2
    private static boolean solution2(int x) {
        //思考：这里大家可以思考一下，为什么末尾为 0 就可以直接返回 false
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber / 10;
    }
}


