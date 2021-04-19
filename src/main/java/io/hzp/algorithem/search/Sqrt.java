package io.hzp.algorithem.search;

/**
 * 考察二分查找
 * 基本二分查找算法：
 * public int search(int[] nums, int target) {
 *     int left = 0 , right = nums.length-1, mid;
 *     while (left <= right) {           // 循环结束条件 ?
 *         mid = (left+right) / 2;
 *         if (target == nums[mid])      // 发现目标元素
 *             return mid;               // ?
 *         else if (target < nums[mid])  // 目标在左半区
 *             right = mid-1;            // ?
 *         else                          // 目标在右半区
 *             left = mid+1;             // ?
 *     }
 *     return -1;                        // 找不到目标
 * }
 *
 * 作者：bryansun2020
 * 链接：https://leetcode-cn.com/problems/binary-search/solution/er-fen-cha-zhao-xiang-xi-jie-xi-han-gai-duo-chong-/
 * 来源：力扣（LeetCode）
 *
 */
public class Sqrt {

    public static int mySqrt(int  x){
        int l = 1, h = x;
        if (x <= 1){
            return x;
        }
        while (l < h){
            int mid = (l + h) / 2;

            int sqrt = x / mid;

            if (sqrt == mid){
                return mid;
            } else if (sqrt > mid){
                l = mid + 1;

            } else {
                h = mid ;

            }
        }
        return l - 1;


    }

    public static void main(String[] args) {
        int result;
        result = mySqrt(1);
        System.out.println("sqrt的结果是：" + result);
    }
}

