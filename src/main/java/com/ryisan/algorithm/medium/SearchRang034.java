package com.ryisan.algorithm.medium;

import java.util.Arrays;

/**
 * @author ruansm
 * @date 2022/6/7
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 示例 1：
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 */
public class SearchRang034 {

    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,10};
        int target = 8;
        System.out.println(Arrays.toString(searchRange(nums,target)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1,-1};
        int length = nums.length;

        int right = length-1;
        for (int i = 0; i < length; i++) {
            if(nums[i] == target){
                result[0] = i;
                while (right >= i){
                    if(nums[right] == target){
                        result[1] = right;
                        break;
                    }
                    right--;
                }
                break;
            }
        }
        return result;
    }
}
