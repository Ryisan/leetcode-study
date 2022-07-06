package com.ryisan.algorithm.medium;

/**
 * @author ruansm
 * @date 2022/5/25
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 示例1
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 思路：
 * 1.使用两个循环，最外层从左索引递增，内层从右索引递减
 * 2.遍历所有左索引与右索引相等的字符
 * 3.如果左索引不等于右索引，则快速失败
 * 4.如果左索引等于右索引，则左边索引向右移动，继续执行 2
 * 5.使用字符数组保存结果，返回最长字符串
 */
public class LongestPalindrome005 {

    public static void main(String[] args) {
        String s = "ccbb";
        System.out.println(longestPalindrome(s));

    }

    public static String longestPalindrome(String s){
        String trim = s.trim();
        char[] charArray = s.toCharArray();
        int length = trim.length();
        if(length == 1){
            return trim;
        }
        if(length == 2){
            if(charArray[0] == charArray[1]){
                return trim;
            }else {
                return String.valueOf(charArray[0]);
            }

        }

        StringBuffer stringBuffer = new StringBuffer(s);
        String res="";
        for (int i = 0; i < length; i++) {
            int left = i;
            int right = length - 1;
            for (int j = right; j > 0; j--) {

                if(left == length){
                    break;
                }
                char leftChar = charArray[left];
                char rightChar = charArray[j];
                if(leftChar == rightChar){
                    if(i+1==j){
                        int len = j - i  + 1;
                        res = getSubstring(stringBuffer, res, i, len);
                    }
                    if(left == j){
                        int len = 2*(left - i) +1;
                        res = getSubstring(stringBuffer, res, i, len);
                        break;
                    }else if(left > j){
                        int len = 2*(left - i);
                        res = getSubstring(stringBuffer, res, i, len);
                        break;
                    }
                    left++;
                }else{
                    //截取回文字符时，中间字符不匹配回文规则
                    if(left != i){
                        left = i;
                        j = right--;
                    }
                }
            }
        }
        return res;
    }

    private static String getSubstring(StringBuffer stringBuffer, String res, int i, int len) {
        char[] temp = new char[len];
        stringBuffer.getChars(i, i+len, temp, 0);
        res = max(res, new String(temp));
        return res;
    }

    public static String max(String a,String b){
        return a.length() >= b.length() ? a : b;
    }
}
