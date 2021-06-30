package com.pjhu.springsourcecode.test;

import java.util.Arrays;

public class M587TwoSum {

    public static void main(String[] args) {

    }

    private static int solution1(int[] a, int target) {
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

    public static int solution2(int[] a, int target) {

        int j = a.length -1;
        int rst = 0;
        Arrays.sort(a);
        for (int i=0;i<a.length;i++) {

            int v = a[i] + a[j];

            if (i>0 &&  a[i] == a[i-1]){
                continue;
            }

            while (i<j  && v > target) {
                --j;
            }
            if (v == target) {
                rst++;
            }
        }
        return rst;
    }
}
