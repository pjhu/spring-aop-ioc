package com.pjhu.aopioc.test;

import java.util.Arrays;
import java.util.Collections;

public class M587TwoSum {

    public static void main(String[] args) {

    }

    private static int solution(int[] a, int target) {
        Arrays.sort(a);
        int left =0;
        int right = a.length-1;
        int count = 0;

        while (left < right) {
            int v = a[left] + a[right];
            if(v == target) {
                left++;
                right--;
                count++;
                while (left < right && a[left] == a[left+1]) {
                    left++;
                }
                while (left<right && a[right] == a[right-1]) {
                    right--;
                }
            } else if (v > target) {
                right--;
            } else {
                left++;
            }
        }
        return count;
    }
}
