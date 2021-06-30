package com.pjhu.aopioc.test;

import java.util.*;

// DFS 深度优先遍历 https://zhuanlan.zhihu.com/p/24986203
// 回溯法
// https://leetcode-cn.com/problems/n-queens/solution/nhuang-hou-by-leetcode-solution/
public class M33NhuangHou {

    public static void main(String[] args) {

        List<List<String>> solutions = new ArrayList<>();

        // 记录每行放置的皇后的列下标
        int[] queues = new int[4];
        Arrays.fill(queues, -1);

        // 一共有 N 列，每一列的下标范围从 0 到 N−1，使用列的下标即可明确表示每一列
        Set<Integer> columns = new HashSet<>();
        // 斜线为从左上到右下方向，同一条斜线上的每个位置满足行下标与列下标之差相等，行列都加一
        Set<Integer> diagonals1 = new HashSet<>();
        // 斜线为从右上到左下方向，同一条斜线上的每个位置满足行下标与列下标之和相等，行加一，列减一
        Set<Integer> diagonals2 = new HashSet<>();

        solution(solutions, queues, 4, 0, columns, diagonals1, diagonals2);
    }

    // row标示，本次调用，本行选择哪一列符合要求
    public static void solution(List<List<String>> solutions, int[] queues, int n, int row,
                                Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {

        if (n == row) {
            List<String> board = generate(queues, n);
            solutions.add(board);
        } else {

            // 列循环
            for  (int i=0;i<n;i++) {

                // 不符合结束循环
                if (columns.contains(i)) {
                    continue;
                }

                // 不符合结束循环，斜线为从左上到右下方向
                int diagonal1 = row -i;
                if  (diagonals1.contains(diagonal1)) {
                    continue;
                }

                // 不符合结束循环，斜线为从右上到左下方向
                int diagonal2 = row +  i;
                if (diagonals2.contains(diagonal2)) {
                    continue;
                }

                // 添加，假设符合要求
                queues[row] = i;
                columns.add(i);
                diagonals1.add(diagonal1);
                diagonals2.add(diagonal2);
                // 递归下一行
                solution(solutions, queues, n, row+1, columns, diagonals1, diagonals2);

                // 不符合结束循环，回溯
                queues[row] = -1;
                columns.remove(i);
                diagonals1.remove(diagonal1);
                diagonals2.remove(diagonal2);
            }
        }
    }

    public static List<String> generate(int[] queues, int n) {
        List<String> board = new ArrayList<>();
        for (int i=0;i<n;i++) {
            char[] row  = new char[n];

            Arrays.fill(row, '.');
            row[queues[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}
