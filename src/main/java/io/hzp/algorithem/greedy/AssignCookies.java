package io.hzp.algorithem.greedy;


import java.util.Arrays;

/**
 * 贪心思想！！！
 * 分配饼干
 * 1,题目描述：每个孩子都有一个满足度 grid（胃口值），每个饼干都有一个大小 size，只有饼干的大小大于等于一个孩子的满足度，该孩子才会获得满足。求解最多可以获得满足的孩子数量。
 * 2,注解：对每个孩子i ，都有一个胃口值gi ，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干j ，都有一个尺寸 sj
 * 3,链接：https://github.com/CyC2018/CS-Notes/blob/master/notes/Leetcode%20%E9%A2%98%E8%A7%A3%20-%20%E8%B4%AA%E5%BF%83%E6%80%9D%E6%83%B3.md#8-%E5%88%A4%E6%96%AD%E6%98%AF%E5%90%A6%E4%B8%BA%E5%AD%90%E5%BA%8F%E5%88%97
 * 4,所谓贪心算法是指，在对问题求解时，总是做出在当前看来是最好的选择。也就是说，不从整体最优上加以考虑，他所做出的仅是在某种意义上的局部最优解。
 *贪心策略适用的前提是：局部最优策略能导致产生全局最优解。
 */

public class AssignCookies {
    public static int findContentChildren(int[] grid, int[] size){
        int gi = 0, si = 0;
        Arrays.sort(grid);
        Arrays.sort(size);//默认asc，升序
        while (gi < grid.length && si < size.length){//事实上就是保证size里面的元素>=grid中的元素
            if (grid[gi] <= size[si]) {
                gi++;
            }
            si++;

        }


        return gi;
    }

    public static void main(String[] args) {
        /**
         * 表示两个孩子和三块小饼干，2个孩子的胃口值分别是1,3。
         * 三块饼干的size分别为1,2,4
         * 你拥有的饼干数量和尺寸都足以让所有孩子满足。
         *
         */
        //表示两个孩子和三块小饼干，2个孩子的胃口值分别是1,3。
        int[] grid = {1,3};
        int[] size = {1,2,4};

        int count = findContentChildren(grid, size);
        System.out.println("最多可以获得满足的孩子数量为：" + count);


    }
}
