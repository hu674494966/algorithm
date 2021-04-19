package io.hzp.algorithem.search;

import java.util.ArrayList;
import java.util.List;

/**
 * https://juejin.im/post/6844904200686534663
 */
public class BackTrace {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> tempSubset = new ArrayList<>();
        //size大小控制待加入的集合元素的个数，比如，size为1,取值为[1],[2],[3]. size为2,取值为[1,2],[1,3],[2,3]
        for (int size = 0; size <= nums.length; size++) {
            backtracking(0, tempSubset, subsets, size, nums); // 不同的子集大小
        }
        return subsets;
    }

    private static void backtracking(int start, List<Integer> tempSubset, List<List<Integer>> subsets,
                              final int size, final int[] nums) {
        System.out.println("tempsize大小：" + tempSubset.size() + "  size大小为：" + size);

        if (tempSubset.size() == size) {
            subsets.add(new ArrayList<>(tempSubset));
            System.out.println(tempSubset);
            System.out.println("subset元素为：" + subsets);
            return;
        }
        //size为2的时候，取值[1,2],[1,3],[2,3]
        for (int i = start; i < nums.length; i++) {
            tempSubset.add(nums[i]);//1
            System.out.println("标记tempsubset：" + tempSubset);
            backtracking(i + 1, tempSubset, subsets, size, nums);//1
            tempSubset.remove(tempSubset.size() - 1);
        }
    }

    /**
     * 方法2
     * @param args
     */

    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> subsets2(int[] nums) {
        if(nums.length == 0){
            return null;
        }
        List<Integer> temp = new ArrayList<>();
        backTrace(0, nums, temp);
        return list;
    }

    public void backTrace(int start, int[] nums, List<Integer> temp){
        list.add(new ArrayList<>(temp));
        System.out.println("临时list： " +list);
        //System.out.println(nums.length);
        //从start开始遍历，避免重复
        for(int j = start; j < nums.length; j++){
            temp.add(nums[j]);
            System.out.println("temp值：" + temp);
            backTrace(j+1,nums,temp);
            temp.remove(temp.size()-1);
        }
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
       /* List<List<Integer>> result = subsets(nums);
        for (List res : result){
            System.out.println(res);

        }*/
       BackTrace bt = new BackTrace();
        List<List<Integer>> result2 = bt.subsets2(nums);
        for (List res : result2){
            System.out.println(res);

        }

    }
}
