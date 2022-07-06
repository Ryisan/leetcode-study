package com.ryisan.algorithm.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ruansm
 * @date 2022/6/16
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * 示例 1：
 *
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 *
 *  思路：
 *  1）溯源算法
 *  2）排序后，同一层级重复数值过滤，不同层级重复数值保留
 *
 */
public class PermuteUnique047 {
    static boolean[] vis;
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2};
        System.out.println(permuteUnique(nums));
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        vis = new boolean[nums.length];
        backtrack(results,new ArrayList<>(),nums,0);
        return results;
    }

    public static void backtrack(List<List<Integer>> results,List<Integer> combines
            ,int[] nums,int index){
        //终止条件
        if(index == nums.length){
            results.add(new ArrayList<>(combines));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])){
                //同层级重复数值，直接过滤
                continue;
            }
            combines.add(nums[i]);
            vis[i] = true;
            backtrack(results,combines,nums,index+1);
            vis[i] = false;
            combines.remove(index);
        }
    }
}
