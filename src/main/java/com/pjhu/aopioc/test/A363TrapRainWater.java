package com.pjhu.aopioc.test;

// 363-接雨水
public class A363TrapRainWater {

    public static void main(String[] args) {
        int[] a = new int[] {1,2,0,2,1,0,1,3,2,1,2,1};
        System.out.println(solution(a));
    }

    private static Integer solution(int[] heights) {
        int i=0,j=heights.length-1;
        int left = -1, right = -1;
        int water = 0;

        while (i<=j) {
            if(heights[i] >= left) {
                left = heights[i];
                i++;
                continue;
            }

            if(heights[j] >= right) {
                right = heights[j];
                j--;
                continue;
            }

            if (left <= right) {
                water += left - heights[i];
                i++;
            } else {
                water += right - heights[j];
                j--;
            }
        }
        return water;
    }
}
