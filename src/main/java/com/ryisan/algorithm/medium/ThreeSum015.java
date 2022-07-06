package com.ryisan.algorithm.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ruansm
 * @date 2022/5/31
 * 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 思路：
 * 1）先排序，使用双指针，过滤重复
 * 2）三重循环执行
 */
public class ThreeSum015 {

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums){
        Arrays.sort(nums);
        int length = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        for (int first = 0; first < length; first++) {

            if(first>0 && nums[first] == nums[first-1]){
                continue;
            }
            int third = length - 1;
            int target = -nums[first];
            for (int second = first+1; second < length; second++) {
                if(second > first + 1 && nums[second] == nums[second-1]){
                    continue;
                }
                while (second<third && nums[second] + nums[third] > target){
                    third--;
                }
                if (second == third) {
                    break;
                }
                if(target == nums[second] + nums[third]){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    result.add(list);
                }
            }
        }
        return result;
    }
}
