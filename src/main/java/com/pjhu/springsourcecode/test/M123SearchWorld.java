package com.pjhu.springsourcecode.test;

public class M123SearchWorld {
    public static void main(String[] args) {

    }

    public static boolean solution(char[][] board, String word) {

        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                boolean rst = find(board,i,j,word,0);
                if (rst) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean find(char[][] board, int row, int col, String world, int start) {
        if (start == world.length()) {
            return true;
        }

        if(row<0 || row>=board.length || col<0 ||col>=board[0].length || board[row][col] != world.charAt(start))  {
            return false;
        }

        board[row][col] = '#';
        boolean rst =  find(board, row-1, col, world, start+1) ||
                find(board, row, col-1, world, start+1) ||
                find(board, row+1, col, world, start+1) ||
                find(board, row, col+1, world, start+1);

        board[row][col] = world.charAt(start);
        return rst;
    }
}
