package com.la.java.jianZhi2;

/**
 * @author LA
 * @createDate 2022-11-25-16:17
 */
public class P12_G {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(dfs(board, words, i, j, 0)) return true; //每个元素作为起点查找一次
            }
        }
        return false;
    }
    boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        if(i >= board.length || i < 0 || j >= board[0].length || j < 0 ){
            return false; //越界
        }
        if(board[i][j] != word[k]){
            return false; //结点的值与字符串不符
        }

        //否则是符合单词中的字符的，继续往下

        if(k == word.length - 1){
            return true; //单词已经探索完了，返回true表示找到了
        }

        //否则表示还未查找完

        board[i][j] = '\0'; //标记为空，以免继续往下探索时，回重复探索该点

        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i , j - 1, k + 1); //只要有一条路成功，就是存在该单词

        board[i][j] = word[k]; //以该点为起始的子路都探索完了，要恢复，以便上层点可以继续探索
        return res;
    }

}
