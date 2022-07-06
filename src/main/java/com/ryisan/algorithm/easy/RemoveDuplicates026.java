package com.ryisan.algorithm.easy;

import java.util.Arrays;

/**
 * @author ruansm
 * @date 2022/6/6
 * 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。
 * 由于在某些语言中不能改变数组的长度，所以必须将结果放在数组nums的第一部分。更规范地说，如果在删除重复项之后有 k 个元素，那么 nums 的前 k 个元素应该保存最终结果。
 * 将最终结果插入 nums 的前 k 个位置后返回 k 。
 * 不要使用额外的空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * 思路：
 * 1）使用快慢双指针
 * 2）左右指针指向同一个数组下标
 * 3）当右指针向右移动到数组下标与左指针相同时,右指针继续向右移动
 * 4)当右指针向右移动到数组下标与左指针不同时,左指针向右移动
 */
public class RemoveDuplicates026 {

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,1,2,2,3};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));

    }

    public static int removeDuplicates(int[] nums) {
        int length = nums.length;
        int left = 0;
        int index = 0;
        for (int right = 0; right < length; right++) {
            if (nums[left] != nums[right]) {
                index++;
                nums[index] = nums[right];
                left = right;
            }
        }
        return index+1;
    }

    public static int removeDuplicatesOfficial(int[] nums) {
        int length = nums.length;
        if(length == 0){
            return 0;
        }
        int fast = 1;
        int slow = 1;
        while (fast < length){
            if(nums[fast-1] != nums[fast]){
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }


}
