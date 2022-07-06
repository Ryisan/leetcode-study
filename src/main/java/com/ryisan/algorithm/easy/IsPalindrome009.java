package com.ryisan.algorithm.easy;

/**
 * @author ruansm
 * @date 2022/5/26
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 例如，121 是回文，而 123 不是。
 */
public class IsPalindrome009 {

    public static void main(String[] args) {
        int x = 112;
        System.out.println(isPalindrome(x));
    }

    public static boolean isPalindrome(int x){
        int orgiX = x;
        if(x < 0 || (x !=0 && x % 10 == 0)){
            return false;
        }
        int reverseNum = 0;
        while (x > 0){
            reverseNum = reverseNum * 10 + x % 10;
            x = x/10;
        }
        return orgiX == reverseNum;
    }

    public static boolean isPalindrome2(int x){
        if(x < 0){
            return false;
        }
        String s = String.valueOf(x);
        int length = s.length();
        char[] charArray = s.toCharArray();
        int left = 0;
        int right = length-1;
        while (true){
            char leftChar = charArray[left];
            char rightChar = charArray[right];
            if(leftChar == rightChar){
                left++;
                right--;
                if(left >= right){
                    return true;
                }
            }else {
                return false;
            }
        }

    }
}
