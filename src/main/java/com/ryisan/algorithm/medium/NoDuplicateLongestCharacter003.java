package com.ryisan.algorithm.medium;

/**
 * @author ruansm
 * @date 2022/5/24
 * 定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 思路：
 *  1.使用滑动窗口
 *  2.右边边界向右滑动直到找到重复的字符
 *  3.右边边界找到重复的字符后，左边的索引向右移动
 *  4.重复 1，2操作，直到尽头
 */
public class NoDuplicateLongestCharacter003 {

    public static void main(String[] args) {
        String s = "aa";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static String max(String a,String b){
        return a.length() > b.length() ? a : b;
    }

    public static int lengthOfLongestSubstring(String s) {
        if(s ==null || s.equals("")){
            return 0;
        }
        String trim = s.trim();
        if(trim.length()==0 || trim.length()==1){
            return 1;
        }
        char[] chars = s.toCharArray();
        StringBuffer stringBuffer = new StringBuffer(s);
        StringBuffer windows = new StringBuffer();
        windows.append(chars[0]);
        int length = s.length();
        int left = 0;
        int right = 1;
        String res="";
        while (right < length){
            char rightChar = chars[right];
            if(windows.toString().contains(rightChar+"")){
                left++;
                char[] temp = new char[right-left];
                stringBuffer.getChars(left,right,temp,0);
                windows = new StringBuffer(new String(temp));
            }else{
                right++;
                windows.append(rightChar);
            }
            res = max(windows.toString(), res);
        }
        return res.length();
    }
}
