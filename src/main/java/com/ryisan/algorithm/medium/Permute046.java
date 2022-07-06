package com.ryisan.algorithm.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ruansm
 * @date 2022/6/15
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * 思路：
 * 1）回溯算法 + 剪枝去重
 */
public class Permute046 {

    static boolean[] vis;
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        System.out.println(permute(nums));
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        vis = new boolean[nums.length];
        backtrack(new ArrayList<>(),results,nums,0);
        return results;
    }

    public static void backtrack(List<Integer> combines,List<List<Integer>> results
            ,int[] nums,int index){
        //终止条件
        if(index == nums.length){
            results.add(new ArrayList<>(combines));
            return;
        }
        //单程循环处理逻辑
        //清除状态标记
        for (int i = 0; i < nums.length; i++) {
//            if(combines.contains(nums[i])){
//                continue;
//            }
            if(vis[i]){
                continue;
            }
            combines.add(nums[i]);
            vis[i] = true;
            backtrack(combines,results,nums,index+1);
            vis[i] = false;
            combines.remove(combines.size()-1);
        }
    }
}
