package com.ryisan.algorithm.medium;

/**
 * @author ruansm
 * @date 2022/5/26
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * 示例 1：
 * 输入：x = 123
 * 输出：321
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IntReverse007 {

    public static void main(String[] args) {
        int x = 123;
        System.out.println(reverse(x));
    }

    public static int reverse(int x) {
        if(x==0){
            return 0;
        }
        int flag=1;
        if(x < 0){
            flag = -1;
        }
        x = x*flag;
        double reverseNum = 0;
        while (x > 0){
            reverseNum = reverseNum * 10 + x % 10;
            x = x/10;
        }
        if(reverseNum > Integer.MAX_VALUE){
            return 0;
        }else{
            return (int) reverseNum*flag;
        }
    }
}
