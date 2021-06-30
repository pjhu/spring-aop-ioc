package com.pjhu.springsourcecode.test;

// 和大于S的最小子数组，必须连续
public class M406MiniArray {

    public static void main(String[] args) {

    }

    public static int solution(int[] nums, int s) {
        int sum=0;
        int ans=Integer.MAX_VALUE;

        for (int l=0, r=0;r<nums.length;r++) {

            sum += nums[r];

            while (sum>s) {
                ans = Math.min(ans, r-l+1);
                sum -= nums[l++];
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
