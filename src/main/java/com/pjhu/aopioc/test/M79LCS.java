package com.pjhu.aopioc.test;

// 最长公共子串
// https://zhuanlan.zhihu.com/p/91582909 DP问题
// 含义：f[i][j]为 字符串i，j最长公共字串，
// 关系：f[i][j]=f[i-1][j-1] +1
// 初始值：f[i][j] = 0
public class M79LCS {

    public static void main(String[] args) {

    }

    public static int solution(String a, String b) {

        int n = a.length();
        int m = b.length();
        int[][] f = new int[n+1][m+1];

        for (int i=1;i<=n;i++) {

            for(int j=1;j<=m;j++) {
                if (a.charAt(i-1) == b.charAt(j-1)) {
                    f[i][j] = f[i-1][j-1] + 1;
                } else {
                    f[i][j] = 0;
                }
            }
        }

        int max = 0;
        for (int i=1;i<=n;i++) {
            for (int j = 1; j <= m; j++) {
                if (f[i][j] > max) {
                    max = f[i][j];
                }
            }
        }
        return max;
    }
}
