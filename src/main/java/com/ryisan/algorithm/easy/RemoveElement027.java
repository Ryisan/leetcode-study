package com.ryisan.algorithm.easy;

import java.util.Arrays;

/**
 * @author ruansm
 * @date 2022/6/6
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * 思路：
 * 1）使用快慢双指针
 */
public class RemoveElement027 {

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,1,2,2,3};
        int val = 2;
        System.out.println(removeElement(nums,val));
        System.out.println(Arrays.toString(nums));
    }
    public static int removeElement(int[] nums, int val) {
        int length = nums.length;
        int slow = 0;
        int fast = 0;
        while (fast < length){
            if(nums[fast] != val){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;

        }
        return slow;
    }
}
