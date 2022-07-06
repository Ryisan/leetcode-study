package com.ryisan.algorithm.medium;

/**
 * @author ruansm
 * @date 2022/5/31
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 *输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 思路：
 * 1）根据木桶原理，最大容量取决于最小短板
 * max = min(l,r) * t
 * l：左边界，r：右边界，t：l与r的距离
 * 2）使用双指针，以左右为边界，总是以更小一方边界移动
 *
 * */
public class MaxArea011 {

    public static void main(String[] args) {
        int[] a = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(a));
    }

    public static int maxArea(int[] a){
        int length = a.length;
        int leftIndex = 0;
        int rightIndex = length-1;
        int res = 0;
        while (leftIndex < rightIndex){
            int left = a[leftIndex];
            int right = a[rightIndex];
            int t = rightIndex - leftIndex;
            int min = Integer.min(left, right);
            res = Integer.max(res,min*t);
            if(left < right){
                leftIndex++;
            }else {
                rightIndex--;
            }
        }
        return res;
    }
}
