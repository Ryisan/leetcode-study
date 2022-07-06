package com.ryisan.algorithm.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ruansm
 * @date 2022/6/8
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 *
 * 注意：解集不能包含重复的组合。 
 *示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * 思路：
 * 1）回溯+剪枝算法
 * 2）去重
 *       1
 *      / \
 *     2   2  这种情况不会发生 但是却允许了不同层级之间的重复
 *    /     \
 *   5       5
 * 例2
 *      1
 *     /
 *    2      这种情况确是允许的
 *   /
 *  2
 */
public class CombinationSum2_040 {

    public static void main(String[] args) {
        int[] candidates = new int[]{1,2,1,3,1,5};
        int target = 8;
        System.out.println(combinationSum2(candidates,target));
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> resultList = new ArrayList<>();
        //数组排序后再去重
        Arrays.sort(candidates);
        backtrack(resultList,new ArrayList(),candidates,target,0);
        return resultList;
    }

    public static void backtrack(List<List<Integer>> results,List<Integer> combines,int[] candidates,
                                 int target,int begin){
        if(target == 0){
            results.add(new ArrayList(combines));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            if(target < candidates[i]){
                break;
            }
            //同一层相同数值的结点，剪掉，去重
            if(i > begin && candidates[i] == candidates[i-1]){
                continue;
            }
            combines.add(candidates[i]);
            backtrack(results,combines,candidates,target-candidates[i],i+1);
            combines.remove(combines.size()-1);

        }
    }
}
