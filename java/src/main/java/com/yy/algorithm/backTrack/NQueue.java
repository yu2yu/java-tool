package com.yy.algorithm.backTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: N皇后
 * @author: yy
 * @date: 2020/7/13 10:41
 */
public class NQueue {

    List<String[][]> results = new ArrayList<>();

    public boolean isValid(String[][] board,int row,int col){
        int n = board.length;
        // 在该列上有‘Q’
        for(int i=0;i<row;i++){
            if("Q".equals(board[i][col])) return false;
        }
        // 右上方
        for(int i=row-1,j=col+1;i>=0 && j<n;i--,j++ ){
            if("Q".equals(board[i][j])) return false;
        }
        // 左上方
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if("Q".equals(board[i][j])) return false;
        }
        return true;
    }

    /**
     * 需要一个数组来放置皇后，由于nXn的棋盘放置n个皇后，因此每一行只能放一个
     */
    public void nQueue(String[][] board,int row,int col){
        if(row == board.length){
            // 将board添加到结果中
            String[][] dest = new String[board.length][col];
            for(int i=0;i<board.length;i++){
                for(int j=0;j<board.length;j++){
                    dest[i][j] = board[i][j];
                }
            }
            results.add(dest);
            return;
        }
        for(int i=0;i<col;i++){
            if(!isValid(board,row,i)) continue;
            board[row][i] = "Q";
            nQueue(board,row+1,col);
            board[row][i] = "";
        }
    }

    public static void outArray(String[][] result){
        System.out.println("===================");
        for(int i=0;i<result.length;i++){
            for(int j=0;j<result[i].length;j++){
                if("Q".equals(result[i][j])){
                    System.out.print("["+i+","+j+"]"+result[i][j]+"  ");
                }
            }
        }
    }

    public static void main(String[] args) {
        NQueue queue = new NQueue();
        String[][] dest = new String[4][4];
        queue.nQueue(dest,0,4);
        queue.results.forEach(NQueue::outArray);
    }

}
