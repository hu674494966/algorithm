package io.hzp.algorithem.search;

import javafx.util.Pair;


import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * 题目：计算在网格中从原点到特定点的最短路径长度，0 表示可以经过某个位置，求解从左上角到右下角的最短路径长度。
 * 链接：https://github.com/CyC2018/CS-Notes/blob/master/notes/Leetcode%20%E9%A2%98%E8%A7%A3%20-%20%E6%90%9C%E7%B4%A2.md#1-%E8%AE%A1%E7%AE%97%E5%9C%A8%E7%BD%91%E6%A0%BC%E4%B8%AD%E4%BB%8E%E5%8E%9F%E7%82%B9%E5%88%B0%E7%89%B9%E5%AE%9A%E7%82%B9%E7%9A%84%E6%9C%80%E7%9F%AD%E8%B7%AF%E5%BE%84%E9%95%BF%E5%BA%A6
 *
 * 数据结构：队列
 * BFS思想，最短路径选用广度优先，父节点入队，父节点出队列，先左子节点入队，后右子节点入队。递归遍历全部节点即可
 *
 */
public class BFS {


    public static int shortestPathBinaryMatrix(int [][] grids){

        if(grids == null || grids.length == 0 || grids[0].length == 0){
            return -1;
        }
        //某一个点可以走的八个方向，上下左右、左上、右下等
        int[][] direction = {{1, -1}, {1, 0}, {1, 1}, {0, -1}, {0, 1}, {-1, -1}, {-1, 0}, {-1, 1}};
        //m代表二维数组行数，n代表二位数组列数
        int m = grids.length, n = grids[0].length;
        //定义一个queue存放需要遍历的点，pair存放当前点的坐标
        Queue<Pair<Integer,Integer>> queue = new LinkedList<>();
        //首先将（0,0）点放入队列
        queue.add(new Pair<>(0,0));
        //初次长度为0
        int pathLength = 0;

        while (!queue.isEmpty()){
            //队列的长度，当前层的队列长度
            int size = queue.size();
            //每遍历一层，长度+1
            pathLength ++ ;

            while (size-- > 0){
                //取出队列元素
                Pair<Integer,Integer> curr = queue.poll();
                //获取队列里面点的行、列坐标
                int cr = curr.getKey(),cc = curr.getValue();
                //如果已经搜索过的点，标记为1，后续就不再重复搜索
                if (grids[cr][cc] == 1){
                    continue;
                }
                if (cr == m-1 && cc == n-1){
                    return pathLength;

                }

                grids[cr][cc] = 1;//标记
                //当前点尝试访问其他八个方向的点，可以被访问的点加入到queue里面
                for (int[] d : direction){
                    int nr = cr + d[0], nc = cc + d[1];
                    //防止越界
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n ){
                        continue;

                    }
                    //符合条件的放入queue
                    queue.add(new Pair<>(nr,nc));

                }

            }

        }

        return -1;
    }

    public static void main(String[] args) {
        int[][] grids =
                {{0,1,0,1},
                 {1,0,1,0},
                 {1,1,1,0},
                 {1,0,1,0}};

        int shortestLength = shortestPathBinaryMatrix(grids);
        System.out.println("最短路径为：" + shortestLength);
    }

}
