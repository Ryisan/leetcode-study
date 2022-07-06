package com.ryisan.algorithm.easy;

import java.util.Arrays;

/**
 * @author ruansm
 * @date 2022/5/24
 * 给定一个整数数组 `nums` 和一个目标值 `target`，
 * 请你在该数组中找出和为目标值的那 **两个** 整数，并返回他们的数组下标。
 */
public class TwoSumEqualsTarget001 {

    public static void main(String[] args) {
        int[] nums = {1,5,7,2,9,5};
        int target = 9;
        int[] result = twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int length = nums.length;
        for (int i = 0; i < length-1; i++) {
            for (int j = i+1; j < length; j++) {
                if(nums[i] + nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }
}
