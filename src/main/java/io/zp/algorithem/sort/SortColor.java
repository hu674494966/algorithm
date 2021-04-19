package io.zp.algorithem.sort;

/**链接：
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/Leetcode%20%E9%A2%98%E8%A7%A3%20-%20%E6%8E%92%E5%BA%8F.md#1-%E6%8C%89%E9%A2%9C%E8%89%B2%E8%BF%9B%E8%A1%8C%E6%8E%92%E5%BA%8F
 * 荷兰国旗问题：
 * 它其实是三向切分快速排序的一种变种，在三向切分快速排序中，每次切分都将数组分成三个区间：小于切分元素、等于切分元素、大于切分元素，
 * 而该算法是将数组分成三个区间：等于红色、等于白色、等于蓝色。
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 */
public class SortColor {
    //快排序算法，这里只不过换成了==
    //因为curr左边的值已经扫描过了，所以curr要++继续扫描下一位，而与p2交换的值，curr未扫描，要停下来扫描一下，所以curr不用++。
    public static void sortColors(int[] nums){

        int curr = 0, p0 = 0, p2 = nums.length-1;
        while (curr < p2){
            if (nums[curr] == 0){
                swap(nums,curr ++, p0 ++);
            } else if (nums[curr] == 2){
                swap(nums,curr ,p2 --);
            } else {
                curr ++;
            }
        }


    }

    private static void swap(int[] nums,int i, int j){
        int tmp;
        tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] test = {0,0,1,2,1,2,1,2,0,2,1,2,0,1,2,0,0,2,1,0,2,1,0,2,1,0,2,1,1,2,0,2,1,2,1,0};
        sortColors(test);
        for (int num : test ) {
            System.out.print(num  + " ");
        }

    }
}
