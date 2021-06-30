package com.pjhu.springsourcecode.test;

// 最长升序数组
// https://zhuanlan.zhihu.com/p/91582909 DP问题
// 步骤一【定义元素的含义】：f[i], 到达a[i]的最长升序的长度
// 步骤二【找出关系数组元素间的关系式】：要怎么才能到达f[i]呢，找出f[0....i-1]中找出a[0....i-1] < a[i]，f[i] = max(f[0...i-1]) + 1
// 步骤三【找出初始条件】：所有值为1，整个数组倒叙
public class M76LIS {
    public static void main(String[] args) {
        // 结果为[2,3,4,7]
        Integer[] a = new Integer[] {4,2,4,5,3,7};
        System.out.println(solution1(a));
    }

    public static Integer solution1(Integer[] a) {

        Integer[] f = new Integer[a.length];
        Integer max=0;
        for(int i=0; i< a.length; i++) {
            f[i] = 1;
            for (int j=0;j<i;j++) {
                if (a[j] < a[i]) {
                    // f[i] = f[i] > f[j] + 1 ? f[i] : f[j] + 1;
                    f[i] = Math.max(f[i], f[j]+1);
                }
            }
            if (f[i] > max) {
                max = f[i];
            }
        }
        return max;
    }
}
