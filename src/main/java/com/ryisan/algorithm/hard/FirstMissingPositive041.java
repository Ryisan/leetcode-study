package com.ryisan.algorithm.hard;

import java.util.HashMap;

/**
 * @author ruansm
 * @date 2022/6/10
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 *
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 *
 * 示例：
 * nums = [1,2,0]
 * 输出：3
 */
public class FirstMissingPositive041 {
    public static void main(String[] args) {
        int[] nums = new int[]{3,4,-1,1};
    }

    //时间复杂度为 O(N)，空间复杂度为 O(N)
    //不合符题目要求
    public static int firstMissingPositive2(int[] nums) {

       HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            if(!map.containsKey(i)){
                return i;
            }
        }
        return -1;
    }
}
