package com.pjhu.springsourcecode.test;

public class M1347ZeroSum {
    public static void main(String[] args) {

    }

    private static int solution(int n) {
        if (n>=5) {
            return n/5 + solution(n/5);
        } else {
            return 0;
        }
    }
}

