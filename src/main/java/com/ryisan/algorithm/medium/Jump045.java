package com.ryisan.algorithm.medium;

/**
 * @author ruansm
 * @date 2022/6/14
 * 跳跃游戏
 * 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 假设你总是可以到达数组的最后一个位置。
 *
 *示例 1:
 *
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 *
 * 思路：
 * 1）正向查找可到达的最大位置
 * 2）如果我们「贪心」地进行正向查找，每次找到可到达的最远位置，就可以在线性时间内得到最少的跳跃次数。
 * 例如，对于数组 [2,3,1,2,4,2,3]，初始位置是下标 0，从下标 0 出发，最远可到达下标 2。
 * 下标 0 可到达的位置中，下标 1 的值是 3，从下标 1 出发可以达到更远的位置，因此第一步到达下标 1。
 * 从下标 1 出发，最远可到达下标 4。下标 1 可到达的位置中，下标 4 的值是 4 ，
 * 从下标 4 出发可以达到更远的位置，因此第二步到达下标 4
 *
 */
public class Jump045 {

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,2,4,2,3};
        System.out.println(jump(nums));
    }

    public static int jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length-1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if(i == end){
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

}
