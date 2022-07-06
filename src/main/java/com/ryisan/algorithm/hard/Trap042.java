package com.ryisan.algorithm.hard;

/**
 * @author ruansm
 * @date 2022/6/14
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 思路：
 * 1）使用双指针
 * 2）根据木桶原理，根据最短的一遍进行计算
 */
public class Trap042 {

    public static void main(String[] args) {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }

    public static int trap(int[] height) {
        int left = 0;
        int right = height.length-1;
        int trap = 0;
        int left_max = 0;
        int right_max = 0;
        while (left < right){
            if(height[left] < height[right]){
                if(height[left] >= left_max){
                    left_max = height[left];
                }else{
                    trap += left_max - height[left];
                }
                left++;
            }else {
                if(height[right] >= right_max){
                    right_max = height[right];
                }else{
                    trap += right_max - height[right];
                }
                right--;
            }
        }
        return trap;
    }

}
