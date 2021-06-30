package com.pjhu.springsourcecode.test;

import java.util.Arrays;

public class A918ThreeSum {
    public static void main(String[] args) {
        Integer[] a = new Integer[] {-2,0,-1,3};
        Integer result = solution(a, 2);
        System.out.println(result);
    }

    // 3个数之和小于某个值
    private static int solution(Integer[] a, Integer target) {

        int ant = 0;
        Arrays.sort(a);
        for(int i=0;i<a.length-2;i++) {
            int left = i+1;
            int right = a.length -1;

            while (left < right) {
                if(a[i] + a[left] + a[right] < target) {
                    ant += right - left; // right  和 left之间的数据都满足要求
                    left++;
                } else {
                    right--;
                }
            }

        }
        return ant;
    }
}
