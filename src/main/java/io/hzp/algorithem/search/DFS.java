package io.hzp.algorithem.search;

/**
 * 给定一个包含了一些 0 和 1 的非空二维数组 grid 。
 *
 * 一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 *
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。)
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-area-of-island
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 思想，采用DFS思想，DFS就是沿着一个方向一直走下去，直到不满足条件为止
 */
public class DFS {
    private int m, n;
    //定义上下左右4个方向
    private  int[][] direction =  {{0,1},{0,-1},{1,0},{-1,0}};

    public  int maxAreaOfIsland(int[][] grid){
        int maxArea = 0;
        //初始化二维数组的行、列长度
         m = grid.length;
         n = grid[0].length;
        if (grid ==  null || grid[0].length == 0){
            return 0;

        }
        //遍历每一个点
        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n; j++) {
                maxArea = Math.max(maxArea,dfs(grid, i, j));

            }

        }
        return  maxArea;


    }

    public int dfs(int[][] grid, int r, int c){
        if(r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == 0){
            return 0;

        }
        //走过的点进行标记，防止重复计算
        grid[r][c] = 0;
        //
        int area = 1;
        //每个点都进行四个方向的探索
        for(int[] d : direction){
            //递归搜索，结果累加
            area += dfs(grid, r + d[0], c + d[1]);
        }
        return area;

    }

    public static void main(String[] args) {
        //给定一个矩阵
        int[][] grids = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                         {0,0,0,0,0,0,0,1,1,1,0,0,0},
                         {0,1,1,0,1,0,0,0,0,0,0,0,0},
                         {0,1,0,0,1,1,0,0,1,0,1,0,0},
                         {0,1,0,0,1,1,0,0,1,1,1,0,0},
                         {0,0,0,0,0,0,0,0,0,0,1,0,0},
                         {0,0,0,0,0,0,0,1,1,1,0,0,0},
                         {0,0,0,0,0,0,0,1,1,0,0,0,0}};

        DFS dfs = new DFS();

        int len = dfs.maxAreaOfIsland(grids);
        System.out.println("岛屿的最大面积为：" + len);
    }


}
