package com.ryisan.algorithm.easy;

/**
 * @author ruansm
 * @date 2022/6/6
 * 实现 strStr() 函数。
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
 */
public class StrStr028 {

    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
        System.out.println(strStr(haystack,needle));
    }

    public static int strStr(String haystack, String needle) {
        int i = haystack.indexOf(needle);
        return i;
    }
}
