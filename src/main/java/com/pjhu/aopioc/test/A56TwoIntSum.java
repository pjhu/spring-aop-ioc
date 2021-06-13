package com.pjhu.aopioc.test;

import java.util.HashMap;

public class A56TwoIntSum {

    public static void main(String[] args) {

    }

    private static int[] solution(int[] a, int target) {

        HashMap<Integer, Integer> h = new HashMap<>();

        for(int i=0;i< a.length;i++) {
            if (h.get(a[i]) != null) {
                return new int[] {i, h.get(a[i])};
            }
            h.put(target-a[i],i);
        }
        return new int[] {};
    }
}
