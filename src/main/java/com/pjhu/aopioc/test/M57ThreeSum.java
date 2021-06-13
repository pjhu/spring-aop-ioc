package com.pjhu.aopioc.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class M57ThreeSum {

    public static void main(String[] args) {
        int[] a = new int[] {-1,0,1,2,-1,-4};
        solution(a);
    }

    private static void solution(int a[]) {
        Arrays.sort(a);
        List<List<Integer>> rst = new ArrayList<>();
        for (int i=0;i<a.length-3;i++) {
            int left = i+1;
            int right = a.length - 1;
            int target = 0-a[i];

            if (i > 0 && a[i]==a[i-1]){
                continue;
            }
            while (left < right) {
                if (a[left] + a[right] == target) {
                    System.out.print(Arrays.toString(new int[]{a[i], a[left], a[right]}));
                    while (left < right & a[left]==a[left+1]) {
                        left++;
                    }
                    while (left<right && a[right]==a[right-1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if(a[left] +a[right] < target) {
                    left++;

                } else {
                    right--;
                }
            }
        }
    }
}
